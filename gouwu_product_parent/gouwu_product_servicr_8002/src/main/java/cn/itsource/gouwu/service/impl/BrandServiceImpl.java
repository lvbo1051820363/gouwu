package cn.itsource.gouwu.service.impl;

import cn.itsource.gouwu.domain.Brand;
import cn.itsource.gouwu.mapper.BrandMapper;
import cn.itsource.gouwu.query.BrandQuery;
import cn.itsource.gouwu.service.IBrandService;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;
    public PageList<Brand> queryPage(BrandQuery query) {
        //设置总页数数据
        PageList<Brand> pageList = new PageList<>();
        /*pageList.setTotal(page.getTotal());*/

       long totacont =brandMapper.queryPageCount(query);
       if (totacont>0){
           pageList.setTotal(totacont);
           //设置当前分页数据
           List<Brand> brands = brandMapper.queryPage( query);
           pageList.setRows(brands);
       }
        return pageList;
    }
}
