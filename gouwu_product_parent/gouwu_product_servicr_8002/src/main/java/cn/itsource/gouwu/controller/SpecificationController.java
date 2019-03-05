package cn.itsource.gouwu.controller;

import cn.itsource.gouwu.service.ISpecificationService;
import cn.itsource.gouwu.domain.Specification;
import cn.itsource.gouwu.query.SpecificationQuery;
import cn.itsource.util.AjaxResult;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Autowired
    public ISpecificationService specificationService;

    /**
    * 保存和修改公用的
    * @param specification  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Specification specification){
        try {
            if(specification.getId()!=null){
                specificationService.updateById(specification);
            }else{
                specificationService.insert(specification);
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
            specificationService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMsg("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Specification get(@PathVariable("id")Long id)
    {
        return specificationService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Specification> list(){

        return specificationService.selectList(null);
    }


    /**
    * 分页查询数据
    *
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Specification> json(@RequestBody SpecificationQuery query)
    {
        Page<Specification> page = new Page<Specification>(query.getPage(),query.getRows());
            page = specificationService.selectPage(page);
            return new PageList<Specification>(page.getTotal(),page.getRecords());
    }
}
