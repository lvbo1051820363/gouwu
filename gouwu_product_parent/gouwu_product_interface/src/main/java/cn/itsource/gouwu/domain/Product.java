package cn.itsource.gouwu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
@TableName("t_product")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long createTime;
    private Long updateTime;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 副名称
     */
    private String subName;
    /**
     * 商品编码
     */
    private String code;
    /**
     * 商品类型ID
     */
    @TableField("product_type_id")
    private Long productTypeId;
    /**
     * 上架时间
     */
    private Long onSaleTime;
    /**
     * 下架时间
     */
    private Long offSaleTime;

    @TableField(exist = false)
    private String offsaleTimeStr;

    @TableField("brand_id")
    private Long brandId;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 最高价
     */
    private Integer maxPrice;
    /**
     * 最低价
     */
    private Integer minPrice;
    /**
     * 销量
     */
    private Integer saleCount;
    /**
     * 浏览量
     */
    private Integer viewCount;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 评分
     */
    private Integer commentScore;
    /**
     * 显示属性摘要
     */
    private String viewProperties;
    private Integer goodCommentCount;
    private Integer commonCommentCount;
    private Integer badCommentCount;

    @TableField(exist = false)
    private ProductExt productExt;

    public ProductExt getProductExt() {
        return productExt;
    }

    public void setProductExt(ProductExt productExt) {
        this.productExt = productExt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getOnSaleTime() {
        return onSaleTime;
    }

    public void setOnSaleTime(Long onSaleTime) {
        this.onSaleTime = onSaleTime;
    }

    public Long getOffSaleTime() {
        return offSaleTime;
    }

    public void setOffSaleTime(Long offSaleTime) {
        this.offSaleTime = offSaleTime;
    }


    public String getOffsaleTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (offSaleTime ==null){
            return null;
        }else {
            return sdf.format(offSaleTime);
        }
    }

    public void setOffsaleTimeStr(String offsaleTimeStr) {
        this.offsaleTimeStr = offsaleTimeStr;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getViewProperties() {
        return viewProperties;
    }

    public void setViewProperties(String viewProperties) {
        this.viewProperties = viewProperties;
    }

    public Integer getGoodCommentCount() {
        return goodCommentCount;
    }

    public void setGoodCommentCount(Integer goodCommentCount) {
        this.goodCommentCount = goodCommentCount;
    }

    public Integer getCommonCommentCount() {
        return commonCommentCount;
    }

    public void setCommonCommentCount(Integer commonCommentCount) {
        this.commonCommentCount = commonCommentCount;
    }

    public Integer getBadCommentCount() {
        return badCommentCount;
    }

    public void setBadCommentCount(Integer badCommentCount) {
        this.badCommentCount = badCommentCount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product{" +
        ", id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", name=" + name +
        ", subName=" + subName +
        ", code=" + code +
        ", productTypeId=" + productTypeId +
        ", onSaleTime=" + onSaleTime +
        ", offSaleTime=" + offSaleTime +
        ", brandId=" + brandId +
        ", state=" + state +
        ", maxPrice=" + maxPrice +
        ", minPrice=" + minPrice +
        ", saleCount=" + saleCount +
        ", viewCount=" + viewCount +
        ", commentCount=" + commentCount +
        ", commentScore=" + commentScore +
        ", viewProperties=" + viewProperties +
        ", goodCommentCount=" + goodCommentCount +
        ", commonCommentCount=" + commonCommentCount +
        ", badCommentCount=" + badCommentCount +
        "}";
    }
}
