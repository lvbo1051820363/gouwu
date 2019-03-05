package cn.itsource.gouwu.domain;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 品牌信息
 * </p>
 *
 * @author wbtest
 * @since 2019-02-28
 */
@TableName("t_brand")
public class Brand extends Model<Brand> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long createTime;
    private Long updateTime;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 英文名
     */
    private String englishName;
    /**
     * 首字母
     */
    private String firstLetter;
    private String description;
    /**
     * 商品分类ID
     */
    @TableField("product_type_id")
    private Long productTypeId;

    @TableField(exist = false)
    private ProductType productType;

    private Integer sortIndex;
    /**
     * 品牌LOGO
     */
    private String logo;


    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
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

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Brand{" +
        ", id=" + id +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", name=" + name +
        ", englishName=" + englishName +
        ", firstLetter=" + firstLetter +
        ", description=" + description +
        ", productTypeId=" + productTypeId +
        ", sortIndex=" + sortIndex +
        ", logo=" + logo +
        "}";
    }
}
