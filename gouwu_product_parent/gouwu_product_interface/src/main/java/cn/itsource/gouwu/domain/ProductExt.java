package cn.itsource.gouwu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 商品扩展
 * </p>
 *
 * @author wbtest
 * @since 2019-03-04
 */
@TableName("t_product_ext")
public class ProductExt extends Model<ProductExt> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 简介
     */
    private String description;
    /**
     * 图文内容
     */
    private String richContent;
    /**
     * 商品ID
     */
    private Long productId;
    private String viewProperties;
    private String skuProperties;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRichContent() {
        return richContent;
    }

    public void setRichContent(String richContent) {
        this.richContent = richContent;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getViewProperties() {
        return viewProperties;
    }

    public void setViewProperties(String viewProperties) {
        this.viewProperties = viewProperties;
    }

    public String getSkuProperties() {
        return skuProperties;
    }

    public void setSkuProperties(String skuProperties) {
        this.skuProperties = skuProperties;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductExt{" +
        ", id=" + id +
        ", description=" + description +
        ", richContent=" + richContent +
        ", productId=" + productId +
        ", viewProperties=" + viewProperties +
        ", skuProperties=" + skuProperties +
        "}";
    }
}
