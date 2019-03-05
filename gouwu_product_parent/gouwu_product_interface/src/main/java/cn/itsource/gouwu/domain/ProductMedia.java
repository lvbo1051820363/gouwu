package cn.itsource.gouwu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品媒体
 * </p>
 *
 * @author wbtest
 * @since 2019-03-04
 */
@TableName("t_product_media")
public class ProductMedia extends Model<ProductMedia> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 商品ID
     */
    private Long productId;
    /**
     * 媒体类型
     */
    private Integer mediaType;
    private Integer sortIndex;
    /**
     * 资源地址
     */
    private String resource;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductMedia{" +
        ", id=" + id +
        ", productId=" + productId +
        ", mediaType=" + mediaType +
        ", sortIndex=" + sortIndex +
        ", resource=" + resource +
        "}";
    }
}
