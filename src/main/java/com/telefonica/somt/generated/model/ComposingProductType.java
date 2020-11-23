package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.ComponentProdOfferPriceType;
import com.telefonica.somt.generated.model.RefinedProductType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ComposingProductType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ComposingProductType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Indication of the type of product that forms the offer. Supported values are implementation and application specific
   */
  public enum ProductTypeEnum {
    MOBILE("mobile"),
    
    LANDLINE("landline"),
    
    IPTV("ipTv"),
    
    CABLETV("cableTv"),
    
    EMAIL("email"),
    
    BROADBAND("broadband"),
    
    BUNDLE("bundle"),
    
    SVAINCLUDED("svaIncluded"),
    
    SVA("sva"),
    
    SIM("sim"),
    
    DEVICE("device"),
    
    BOLTON("bolton"),
    
    MT("mt"),
    
    ACCESSORIES("accessories");

    private String value;

    ProductTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductTypeEnum fromValue(String text) {
      for (ProductTypeEnum b : ProductTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("productType")
  private ProductTypeEnum productType = null;

  @JsonProperty("tags")
  private List<String> tags = new ArrayList<String>();

  @JsonProperty("minCardinality")
  private Integer minCardinality = null;

  @JsonProperty("maxCardinality")
  private Integer maxCardinality = null;

  @JsonProperty("defaultCardinality")
  private Integer defaultCardinality = null;

  @JsonProperty("periodDuration")
  private String periodDuration = null;

  @JsonProperty("refinedProduct")
  private RefinedProductType refinedProduct = null;

  @JsonProperty("productPrice")
  private List<ComponentProdOfferPriceType> productPrice = new ArrayList<ComponentProdOfferPriceType>();

  public ComposingProductType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Product Identifier. This is the identifier that can be used to retrieve specific information for that product
   * @return id
  **/
  @ApiModelProperty(value = "Product Identifier. This is the identifier that can be used to retrieve specific information for that product")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ComposingProductType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the detailed information for the referred product
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the detailed information for the referred product")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ComposingProductType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable product name
   * @return name
  **/
  @ApiModelProperty(value = "A human readable product name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ComposingProductType productType(ProductTypeEnum productType) {
    this.productType = productType;
    return this;
  }

   /**
   * Indication of the type of product that forms the offer. Supported values are implementation and application specific
   * @return productType
  **/
  @ApiModelProperty(value = "Indication of the type of product that forms the offer. Supported values are implementation and application specific")
  public ProductTypeEnum getProductType() {
    return productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = productType;
  }

  public ComposingProductType tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ComposingProductType addTagsItem(String tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * ist of freely defined strings that tag the product based on some criteria. This can be used by consumer application to define presentation logic
   * @return tags
  **/
  @ApiModelProperty(value = "ist of freely defined strings that tag the product based on some criteria. This can be used by consumer application to define presentation logic")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public ComposingProductType minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

   /**
   * Indicates the minimum number of entities of this product that can be included within the product/offering. If not included then value 0 will be considered
   * @return minCardinality
  **/
  @ApiModelProperty(value = "Indicates the minimum number of entities of this product that can be included within the product/offering. If not included then value 0 will be considered")
  public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public ComposingProductType maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

   /**
   * Indicates the maximum number of entities of this product that can be included within the product/offering. If not included then no limit will be considered
   * @return maxCardinality
  **/
  @ApiModelProperty(value = "Indicates the maximum number of entities of this product that can be included within the product/offering. If not included then no limit will be considered")
  public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public ComposingProductType defaultCardinality(Integer defaultCardinality) {
    this.defaultCardinality = defaultCardinality;
    return this;
  }

   /**
   * Indicates the default number of entities of this product that are included within the parent product/offering
   * @return defaultCardinality
  **/
  @ApiModelProperty(value = "Indicates the default number of entities of this product that are included within the parent product/offering")
  public Integer getDefaultCardinality() {
    return defaultCardinality;
  }

  public void setDefaultCardinality(Integer defaultCardinality) {
    this.defaultCardinality = defaultCardinality;
  }

  public ComposingProductType periodDuration(String periodDuration) {
    this.periodDuration = periodDuration;
    return this;
  }

   /**
   * Period for which the product will be subscribed if offer is purchased. It does not mean that offer is available for indicated period, it means that in case offer is purchased, product will be acquired and will last for indicated period. Applies when type equals one-off or usage. For backwards compatibility, in case of recurring prices, recurring_period param is used instead.  Additional to pre-defined values of day, week, month, year, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).
   * @return periodDuration
  **/
  @ApiModelProperty(value = "Period for which the product will be subscribed if offer is purchased. It does not mean that offer is available for indicated period, it means that in case offer is purchased, product will be acquired and will last for indicated period. Applies when type equals one-off or usage. For backwards compatibility, in case of recurring prices, recurring_period param is used instead.  Additional to pre-defined values of day, week, month, year, any indication of number of days or hours is possible, with format {x}-days or {x}-hours (e.g.: 7-days or 24-hours).")
  @Pattern(regexp="^(day|week|month|year|\\d{1,4}-(days|hours))$")
  public String getPeriodDuration() {
    return periodDuration;
  }

  public void setPeriodDuration(String periodDuration) {
    this.periodDuration = periodDuration;
  }

  public ComposingProductType refinedProduct(RefinedProductType refinedProduct) {
    this.refinedProduct = refinedProduct;
    return this;
  }

   /**
   * Structure defining the particular instantiation (e.g.: limitation on the cardinality and/or characteristic values) of the product when included in an specific product offering
   * @return refinedProduct
  **/
  @ApiModelProperty(value = "Structure defining the particular instantiation (e.g.: limitation on the cardinality and/or characteristic values) of the product when included in an specific product offering")
  public RefinedProductType getRefinedProduct() {
    return refinedProduct;
  }

  public void setRefinedProduct(RefinedProductType refinedProduct) {
    this.refinedProduct = refinedProduct;
  }

  public ComposingProductType productPrice(List<ComponentProdOfferPriceType> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ComposingProductType addProductPriceItem(ComponentProdOfferPriceType productPriceItem) {
    this.productPrice.add(productPriceItem);
    return this;
  }

   /**
   * List of price models available for the product within the offering. Typically prices are at top offering level, but sometimes offerings break up prices for each product and that can be done with this structure
   * @return productPrice
  **/
  @ApiModelProperty(value = "List of price models available for the product within the offering. Typically prices are at top offering level, but sometimes offerings break up prices for each product and that can be done with this structure")
  public List<ComponentProdOfferPriceType> getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(List<ComponentProdOfferPriceType> productPrice) {
    this.productPrice = productPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComposingProductType composingProductType = (ComposingProductType) o;
    return Objects.equals(this.id, composingProductType.id) &&
        Objects.equals(this.href, composingProductType.href) &&
        Objects.equals(this.name, composingProductType.name) &&
        Objects.equals(this.productType, composingProductType.productType) &&
        Objects.equals(this.tags, composingProductType.tags) &&
        Objects.equals(this.minCardinality, composingProductType.minCardinality) &&
        Objects.equals(this.maxCardinality, composingProductType.maxCardinality) &&
        Objects.equals(this.defaultCardinality, composingProductType.defaultCardinality) &&
        Objects.equals(this.periodDuration, composingProductType.periodDuration) &&
        Objects.equals(this.refinedProduct, composingProductType.refinedProduct) &&
        Objects.equals(this.productPrice, composingProductType.productPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, productType, tags, minCardinality, maxCardinality, defaultCardinality, periodDuration, refinedProduct, productPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComposingProductType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    defaultCardinality: ").append(toIndentedString(defaultCardinality)).append("\n");
    sb.append("    periodDuration: ").append(toIndentedString(periodDuration)).append("\n");
    sb.append("    refinedProduct: ").append(toIndentedString(refinedProduct)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

