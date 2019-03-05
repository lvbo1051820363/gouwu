package cn.itsource.gouwu.mapper;

import cn.itsource.gouwu.domain.Product;
import cn.itsource.gouwu.domain.ProductExt;
import cn.itsource.gouwu.query.ProductQuery;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 商品 Mapper 接口
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
public interface ProductMapper extends BaseMapper<Product> {
    long queryPageCount(ProductQuery query);

    List<Product> queryPage(ProductQuery query);

}
