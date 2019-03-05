package cn.itsource.gouwu.service;

import cn.itsource.gouwu.domain.Product;
import cn.itsource.gouwu.query.ProductQuery;
import cn.itsource.util.PageList;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
public interface IProductService extends IService<Product> {

    PageList<Product> selectQuery(ProductQuery query);
}
