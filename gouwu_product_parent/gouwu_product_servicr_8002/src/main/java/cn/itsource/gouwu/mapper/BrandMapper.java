package cn.itsource.gouwu.mapper;

import cn.itsource.gouwu.domain.Brand;
import cn.itsource.gouwu.query.BrandQuery;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
public interface BrandMapper extends BaseMapper<Brand> {

    List<Brand> queryPage(BrandQuery query);
    long queryPageCount(BrandQuery query);
}
