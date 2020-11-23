package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.CategoryTreeType;
import com.telefonica.somt.generated.model.ComposingProductType;
import com.telefonica.somt.generated.model.InfoAttachmentType;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.ProductSpecCharacteristicType;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductRequestType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProductRequestType  implements Serializable {
  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("category")
  private List<CategoryTreeType> category = new ArrayList<CategoryTreeType>();

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("attachment")
  private InfoAttachmentType attachment = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("bundledProductSpecification")
  private List<ComposingProductType> bundledProductSpecification = new ArrayList<ComposingProductType>();

  @JsonProperty("productSpecCharacteristic")
  private List<ProductSpecCharacteristicType> productSpecCharacteristic = new ArrayList<ProductSpecCharacteristicType>();

  /**
   * Status to be set for the product within the catalog
   */
  public enum LifeCycleStatusEnum {
    DRAFT("draft"),
    
    ACTIVE("active"),
    
    EXPIRED("expired");

    private String value;

    LifeCycleStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LifeCycleStatusEnum fromValue(String text) {
      for (LifeCycleStatusEnum b : LifeCycleStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("lifeCycleStatus")
  private LifeCycleStatusEnum lifeCycleStatus = null;

  @JsonProperty("additionalData")
  private List<MoneyType> additionalData = new ArrayList<MoneyType>();

  public ProductRequestType correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

   /**
   * Unique identifier for the product description within the client, used to synchronize and map internal identifiers between server and client
   * @return correlationId
  **/
  @ApiModelProperty(value = "Unique identifier for the product description within the client, used to synchronize and map internal identifiers between server and client")
  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public ProductRequestType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable product name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable product name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductRequestType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A human readable product short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable product short description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductRequestType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public ProductRequestType addCategoryItem(CategoryTreeType categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * A class defining the type of product A product may belong to more than one class. A standard list of classes (e.g.: Video,Audio,Adult,etc) would be helpful together with the ability to extend as required. Each service may define its own classes. Therefore, only certain values for class will be allowed depending on the service
   * @return category
  **/
  @ApiModelProperty(value = "A class defining the type of product A product may belong to more than one class. A standard list of classes (e.g.: Video,Audio,Adult,etc) would be helpful together with the ability to extend as required. Each service may define its own classes. Therefore, only certain values for class will be allowed depending on the service")
  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public ProductRequestType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the product in the catalog If not included, the current date is used as starting date and no ending date is defined. Notice that the use of this parameter may drive to inconsistencies between offering validity and product validity. The application must manage these cases
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the product in the catalog If not included, the current date is used as starting date and no ending date is defined. Notice that the use of this parameter may drive to inconsistencies between offering validity and product validity. The application must manage these cases")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public ProductRequestType brand(String brand) {
    this.brand = brand;
    return this;
  }

   /**
   * Identifier for the original provider or developer for the product when provided by third parties. The manufacturer or trademark of the specification
   * @return brand
  **/
  @ApiModelProperty(value = "Identifier for the original provider or developer for the product when provided by third parties. The manufacturer or trademark of the specification")
  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public ProductRequestType number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Any commercial code string that can be used for internal accounting to uniquely identify the product. This could be different than the unique identifier assigned by server or client?s catalogs. It can be used as a merchant-supplied identifier for products provided by third parties. Notice that in the TMForum API version 14.5 this parameter is named productNumber which is not consistent with the names of the rest of attributes in the resource
   * @return number
  **/
  @ApiModelProperty(value = "Any commercial code string that can be used for internal accounting to uniquely identify the product. This could be different than the unique identifier assigned by server or client?s catalogs. It can be used as a merchant-supplied identifier for products provided by third parties. Notice that in the TMForum API version 14.5 this parameter is named productNumber which is not consistent with the names of the rest of attributes in the resource")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public ProductRequestType attachment(InfoAttachmentType attachment) {
    this.attachment = attachment;
    return this;
  }

   /**
   * Structure including an URL that can provide additional information of the product (e.g.: weblink with a downloadable product description brochure)
   * @return attachment
  **/
  @ApiModelProperty(value = "Structure including an URL that can provide additional information of the product (e.g.: weblink with a downloadable product description brochure)")
  public InfoAttachmentType getAttachment() {
    return attachment;
  }

  public void setAttachment(InfoAttachmentType attachment) {
    this.attachment = attachment;
  }

  public ProductRequestType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)
   * @return isBundle
  **/
  @ApiModelProperty(value = "Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)")
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductRequestType bundledProductSpecification(List<ComposingProductType> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
    return this;
  }

  public ProductRequestType addBundledProductSpecificationItem(ComposingProductType bundledProductSpecificationItem) {
    this.bundledProductSpecification.add(bundledProductSpecificationItem);
    return this;
  }

   /**
   * List of individual product identifiers that compose the parent product. Only required if isBundle is set to TRUE
   * @return bundledProductSpecification
  **/
  @ApiModelProperty(value = "List of individual product identifiers that compose the parent product. Only required if isBundle is set to TRUE")
  public List<ComposingProductType> getBundledProductSpecification() {
    return bundledProductSpecification;
  }

  public void setBundledProductSpecification(List<ComposingProductType> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
  }

  public ProductRequestType productSpecCharacteristic(List<ProductSpecCharacteristicType> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
    return this;
  }

  public ProductRequestType addProductSpecCharacteristicItem(ProductSpecCharacteristicType productSpecCharacteristicItem) {
    this.productSpecCharacteristic.add(productSpecCharacteristicItem);
    return this;
  }

   /**
   * List of specific parameters for a product that could be configured and/or charged for
   * @return productSpecCharacteristic
  **/
  @ApiModelProperty(value = "List of specific parameters for a product that could be configured and/or charged for")
  public List<ProductSpecCharacteristicType> getProductSpecCharacteristic() {
    return productSpecCharacteristic;
  }

  public void setProductSpecCharacteristic(List<ProductSpecCharacteristicType> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
  }

  public ProductRequestType lifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
    return this;
  }

   /**
   * Status to be set for the product within the catalog
   * @return lifeCycleStatus
  **/
  @ApiModelProperty(value = "Status to be set for the product within the catalog")
  public LifeCycleStatusEnum getLifeCycleStatus() {
    return lifeCycleStatus;
  }

  public void setLifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
  }

  public ProductRequestType additionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductRequestType addAdditionalDataItem(MoneyType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines")
  public List<MoneyType> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductRequestType productRequestType = (ProductRequestType) o;
    return Objects.equals(this.correlationId, productRequestType.correlationId) &&
        Objects.equals(this.name, productRequestType.name) &&
        Objects.equals(this.description, productRequestType.description) &&
        Objects.equals(this.category, productRequestType.category) &&
        Objects.equals(this.validFor, productRequestType.validFor) &&
        Objects.equals(this.brand, productRequestType.brand) &&
        Objects.equals(this.number, productRequestType.number) &&
        Objects.equals(this.attachment, productRequestType.attachment) &&
        Objects.equals(this.isBundle, productRequestType.isBundle) &&
        Objects.equals(this.bundledProductSpecification, productRequestType.bundledProductSpecification) &&
        Objects.equals(this.productSpecCharacteristic, productRequestType.productSpecCharacteristic) &&
        Objects.equals(this.lifeCycleStatus, productRequestType.lifeCycleStatus) &&
        Objects.equals(this.additionalData, productRequestType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(correlationId, name, description, category, validFor, brand, number, attachment, isBundle, bundledProductSpecification, productSpecCharacteristic, lifeCycleStatus, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductRequestType {\n");
    
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification)).append("\n");
    sb.append("    productSpecCharacteristic: ").append(toIndentedString(productSpecCharacteristic)).append("\n");
    sb.append("    lifeCycleStatus: ").append(toIndentedString(lifeCycleStatus)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
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

