package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductInstanceRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProductInstanceRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("publicId")
  private String publicId = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Indication of the type of product instance registered. Supported values are implementation and application specific
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

  public ProductInstanceRefType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier within the server (product inventory) for the product instance that is associated to an account
   * @return id
  **/
  @ApiModelProperty(value = "Unique Identifier within the server (product inventory) for the product instance that is associated to an account")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductInstanceRefType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: /productinventory/v1/products/{productId})
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the product instance detailed information (e.g.: /productinventory/v1/products/{productId})")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductInstanceRefType name(String name) {
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

  public ProductInstanceRefType publicId(String publicId) {
    this.publicId = publicId;
    return this;
  }

   /**
   * Public number associated to the product (e.g.: use of an msisdn to refer to a subscription to a mobileline product)
   * @return publicId
  **/
  @ApiModelProperty(value = "Public number associated to the product (e.g.: use of an msisdn to refer to a subscription to a mobileline product)")
  public String getPublicId() {
    return publicId;
  }

  public void setPublicId(String publicId) {
    this.publicId = publicId;
  }

  public ProductInstanceRefType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Some text providing a user-friendly detailed description of the product instance
   * @return description
  **/
  @ApiModelProperty(value = "Some text providing a user-friendly detailed description of the product instance")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductInstanceRefType productType(ProductTypeEnum productType) {
    this.productType = productType;
    return this;
  }

   /**
   * Indication of the type of product instance registered. Supported values are implementation and application specific
   * @return productType
  **/
  @ApiModelProperty(value = "Indication of the type of product instance registered. Supported values are implementation and application specific")
  public ProductTypeEnum getProductType() {
    return productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = productType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInstanceRefType productInstanceRefType = (ProductInstanceRefType) o;
    return Objects.equals(this.id, productInstanceRefType.id) &&
        Objects.equals(this.href, productInstanceRefType.href) &&
        Objects.equals(this.name, productInstanceRefType.name) &&
        Objects.equals(this.publicId, productInstanceRefType.publicId) &&
        Objects.equals(this.description, productInstanceRefType.description) &&
        Objects.equals(this.productType, productInstanceRefType.productType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, publicId, description, productType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInstanceRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    publicId: ").append(toIndentedString(publicId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
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

