package cn.itsource.gouwu.service.impl;

import cn.itsource.constants.GlobelConstants;
import cn.itsource.gouwu.client.PageStaticClient;
import cn.itsource.gouwu.client.RedisClient;
import cn.itsource.gouwu.domain.ProductType;
import cn.itsource.gouwu.mapper.ProductTypeMapper;
import cn.itsource.gouwu.service.IProductTypeService;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    PageStaticClient pageStaticClient;

    /*@Override
    public List<ProductType> treeData() {
        // 要得到name和儿子
        //return treeDataRecursion(0L);
        return treeDataLoop();
    }*/

    @Override
    public List<ProductType> treeData() {
        //判断是否有结果:有就直接返回,没有就从数据库获取,存入redis,并返回
        String jsonArrStr = redisClient.get(GlobelConstants.REDIS_PRODUCTTYPE_KEY);
        if(StringUtils.isEmpty(jsonArrStr)){
            //没有就从数据库获取,存入redis,并返回
            List<ProductType> productTypes = treeDataLoop();
            jsonArrStr= JSONArray.toJSONString(productTypes);
            //redis存入
            redisClient.set(GlobelConstants.REDIS_PRODUCTTYPE_KEY,jsonArrStr );
            return productTypes;
        }else{
            //有:有就直接返回
            //json的数组字符串--->json数组
            return JSONArray.parseArray(jsonArrStr, ProductType.class);
        }

    }

    private List<ProductType> treeDataLoop() {
        //1:获取所有的数据:
        List<ProductType> allProductType = productTypeMapper.selectList(null);

        //2:用于存在每一个对象和他的一个标识的 Long:id
        Map<Long,ProductType> map=new HashMap<>();
        for (ProductType productType : allProductType) {
            map.put(productType.getId(), productType);
        }

        //最终想要的结果:
        List<ProductType> result = new ArrayList<>();
        //3:遍历
        for (ProductType productType : allProductType) {
            //组装结构: productType:每一个对象:
            Long pid = productType.getPid();
            if(pid==0){
                result.add(productType);
            }else{
                // 找自己的老子,把自己添加到老子的儿子中
                ProductType parent=map.get(pid);
                parent.getChildren().add(productType);
            }
        }
        return result;
    }

    /**
     *
     * 查询无限极的树装数据:
     select * from t_product_type where pid= ?????

     先得到一级目录:
     得到0的儿子;
     遍历这个目录:
     分别的他的儿子:
     遍历这个儿子目录的儿子
     * @return
     */
    private List<ProductType> treeDataRecursion(Long pid) {
        //treeDataRecursion:获取传入参数的儿子
        //获取第一级目录
        List<ProductType> children =  getAllChildren(pid);// [1,100]

        //没有儿子
        if(children==null||children.size()==0)
        {
            //没有儿子就返回自己
            return children;
        }
        //有儿子
        for (ProductType child : children) {
            // child: 1
            //查询1的儿子
            List<ProductType> allChildren = treeDataRecursion(child.getId());// 1的儿子:
            // 把1的儿子给1
            child.setChildren(allChildren);

        }
        return children;
    }

    /**
     * 查询指定pid的儿子
     * @param pid
     * @return
     */
    private List<ProductType> getAllChildren(long pid) {
        // select * from t_product_type where pid= ?????
        Wrapper<ProductType> wrapper = new EntityWrapper<>();
        wrapper.eq("pid", pid); //select * from t_product_type where pid = #{pid}
        return  productTypeMapper.selectList(wrapper);
    }

    @Override
    public boolean updateById(ProductType entity) {
        //修改:本身数据的修改不会变;修改完后,重新生成模板:
        //1:数据修改:
        boolean b = super.updateById(entity);

        //2:模板的生成:此时此时,这个是模板的消费者:消费模板的提供者:
        //这个是java后台内部的服务的消费:feign/ribbon(采纳feign)
        //feign:注入模板接口,调用

        //逻辑实现:
        //2.1:先生成改变数据的html页面:productType
        Map<String,Object> mapProductType=new HashMap<>();
        List<ProductType> productTypes = treeDataLoop();
        mapProductType.put(GlobelConstants.PAGE_MODE, productTypes);//这里页面需要的是所有的产品类型数据
        //哪一个模板
        mapProductType.put(GlobelConstants.PAGE_TEMPLATE, "D:\\WorkSpaceIDEAEE\\gouwu_parent\\gouwu_common_parent\\gouwu_common_interface\\src\\main\\resources\\template\\product.type.vm");
        //根据模板生成的页面的地址:
        mapProductType.put(GlobelConstants.PAGE_TEMPLATE_HTML, "D:\\WorkSpaceIDEAEE\\gouwu_parent\\gouwu_common_parent\\gouwu_common_interface\\src\\main\\resources\\template\\product.type.vm.html");

        pageStaticClient.getpageString(mapProductType);

        //2.2:再生成home的html页面:
        Map<String,Object> mapHome=new HashMap<>();
        //数据:$model.staticRoot
        Map<String,String> staticRootMap=new HashMap<>();
        staticRootMap.put("staticRoot", "D:\\WorkSpaceIDEAEE\\gouwu_parent\\gouwu_common_parent\\gouwu_common_interface\\src\\main\\resources\\");
        mapHome.put(GlobelConstants.PAGE_MODE, staticRootMap);//这里页面需要的是目录的根路径
        //哪一个模板
        mapHome.put(GlobelConstants.PAGE_TEMPLATE, "D:\\WorkSpaceIDEAEE\\gouwu_parent\\gouwu_common_parent\\gouwu_common_interface\\src\\main\\resources\\template\\home.vm");
        //根据模板生成的页面的地址:
        mapHome.put(GlobelConstants.PAGE_TEMPLATE_HTML, "D:\\WorkSpaceIDEAEE\\gouwu_parent\\gouwu_common_parent\\gouwu_common_interface\\src\\main\\resources\\template\\home.html");

        pageStaticClient.getpageString(mapHome);

        return b;
    }

}
