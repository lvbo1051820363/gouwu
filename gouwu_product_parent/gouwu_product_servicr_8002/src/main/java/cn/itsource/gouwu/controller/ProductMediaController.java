package cn.itsource.gouwu.controller;

import cn.itsource.gouwu.service.IProductMediaService;
import cn.itsource.gouwu.domain.ProductMedia;
import cn.itsource.gouwu.query.ProductMediaQuery;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productMedia")
public class ProductMediaController {
    @Autowired
    public IProductMediaService productMediaService;

    /**
    * 保存和修改公用的
    * @param productMedia  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody ProductMedia productMedia){
        try {
            if(productMedia.getId()!=null){
                productMediaService.updateById(productMedia);
            }else{
                productMediaService.insert(productMedia);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMsg("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            productMediaService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ProductMedia get(@PathVariable("id")Long id)
    {
        return productMediaService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<ProductMedia> list(){

        return productMediaService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<ProductMedia> json(@RequestBody ProductMediaQuery query)
    {
        Page<ProductMedia> page = new Page<ProductMedia>(query.getPage(),query.getRows());
            page = productMediaService.selectPage(page);
            return new PageList<ProductMedia>(page.getTotal(),page.getRecords());
    }
}
