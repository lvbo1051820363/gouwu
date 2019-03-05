package cn.itsource.gouwu.service;

import cn.itsource.gouwu.domain.Brand;
import cn.itsource.gouwu.query.BrandQuery;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
public interface IBrandService extends IService<Brand> {

    PageList<Brand> queryPage(BrandQuery query);
}
