package cn.itsource.gouwu.service.impl;

import cn.itsource.gouwu.domain.Product;
import cn.itsource.gouwu.domain.ProductExt;
import cn.itsource.gouwu.mapper.ProductExtMapper;
import cn.itsource.gouwu.mapper.ProductMapper;
import cn.itsource.gouwu.query.ProductQuery;
import cn.itsource.gouwu.service.IProductService;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductExtMapper productExtMapper;

    @Override
    public boolean insert(Product entity) {
        boolean ins = super.insert(entity);
        ProductExt productExt = entity.getProductExt();
        productExt.setProductId(entity.getId());
        productExtMapper.insert(productExt);
        return ins;
    }

    @Override
    public PageList<Product> selectQuery(ProductQuery query) {
        //设置总的页数
        PageList<Product> pageList = new PageList<>();
        long l = productMapper.queryPageCount(query);
        if (l > 0){
            pageList.setTotal(l);
            //设置当前页的数据
            List<Product> products = productMapper.queryPage(query);
            pageList.setRows(products);
        }
        return pageList;
    }
}
