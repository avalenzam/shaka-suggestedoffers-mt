package com.telefonica.somt.generated.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
/**
 * ProductSpecificationType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProductSpecificationType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

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

  @JsonProperty("offerings")
  private List<EntityRefType> offerings = new ArrayList<EntityRefType>();

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("bundledProductSpecification")
  private List<ComposingProductType> bundledProductSpecification = new ArrayList<ComposingProductType>();

  @JsonProperty("productSpecificationRelationship")
  private List<ProductSpecificationRelationshipType> productSpecificationRelationship = new ArrayList<ProductSpecificationRelationshipType>();

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

  public ProductSpecificationType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier within the server for the product definition reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique Identifier within the server for the product definition reported")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductSpecificationType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the product detailed information
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the resource in the OB that stores the product detailed information")
  @NotNull
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductSpecificationType correlationId(String correlationId) {
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

  public ProductSpecificationType name(String name) {
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

  public ProductSpecificationType description(String description) {
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

  public ProductSpecificationType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public ProductSpecificationType addCategoryItem(CategoryTreeType categoryItem) {
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

  public ProductSpecificationType validFor(TimePeriodType validFor) {
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

  public ProductSpecificationType brand(String brand) {
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

  public ProductSpecificationType number(String number) {
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

  public ProductSpecificationType attachment(InfoAttachmentType attachment) {
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

  public ProductSpecificationType offerings(List<EntityRefType> offerings) {
    this.offerings = offerings;
    return this;
  }

  public ProductSpecificationType addOfferingsItem(EntityRefType offeringsItem) {
    this.offerings.add(offeringsItem);
    return this;
  }

   /**
   * List of URIs including the resource address for the offerings where the product is included. When empty this means that the reported product has not been included in any offering
   * @return offerings
  **/
  @ApiModelProperty(value = "List of URIs including the resource address for the offerings where the product is included. When empty this means that the reported product has not been included in any offering")
  public List<EntityRefType> getOfferings() {
    return offerings;
  }

  public void setOfferings(List<EntityRefType> offerings) {
    this.offerings = offerings;
  }

  public ProductSpecificationType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)
   * @return isBundle
  **/
  @ApiModelProperty(required = true, value = "Indicates if the product is a single entity (false) or if it is actually composed of subproducts itself (true)")
  @NotNull
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public ProductSpecificationType bundledProductSpecification(List<ComposingProductType> bundledProductSpecification) {
    this.bundledProductSpecification = bundledProductSpecification;
    return this;
  }

  public ProductSpecificationType addBundledProductSpecificationItem(ComposingProductType bundledProductSpecificationItem) {
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

  public ProductSpecificationType productSpecificationRelationship(List<ProductSpecificationRelationshipType> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
    return this;
  }

  public ProductSpecificationType addProductSpecificationRelationshipItem(ProductSpecificationRelationshipType productSpecificationRelationshipItem) {
    this.productSpecificationRelationship.add(productSpecificationRelationshipItem);
    return this;
  }

   /**
   * List of other products that are related to the current one (e.g.: accessories or similar products that can be offered to the customer). When empty this means that there are no other products registered as related to the reported one
   * @return productSpecificationRelationship
  **/
  @ApiModelProperty(value = "List of other products that are related to the current one (e.g.: accessories or similar products that can be offered to the customer). When empty this means that there are no other products registered as related to the reported one")
  public List<ProductSpecificationRelationshipType> getProductSpecificationRelationship() {
    return productSpecificationRelationship;
  }

  public void setProductSpecificationRelationship(List<ProductSpecificationRelationshipType> productSpecificationRelationship) {
    this.productSpecificationRelationship = productSpecificationRelationship;
  }

  public ProductSpecificationType productSpecCharacteristic(List<ProductSpecCharacteristicType> productSpecCharacteristic) {
    this.productSpecCharacteristic = productSpecCharacteristic;
    return this;
  }

  public ProductSpecificationType addProductSpecCharacteristicItem(ProductSpecCharacteristicType productSpecCharacteristicItem) {
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

  public ProductSpecificationType lifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
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

  public ProductSpecificationType additionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductSpecificationType addAdditionalDataItem(MoneyType additionalDataItem) {
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
    ProductSpecificationType productSpecificationType = (ProductSpecificationType) o;
    return Objects.equals(this.id, productSpecificationType.id) &&
        Objects.equals(this.href, productSpecificationType.href) &&
        Objects.equals(this.correlationId, productSpecificationType.correlationId) &&
        Objects.equals(this.name, productSpecificationType.name) &&
        Objects.equals(this.description, productSpecificationType.description) &&
        Objects.equals(this.category, productSpecificationType.category) &&
        Objects.equals(this.validFor, productSpecificationType.validFor) &&
        Objects.equals(this.brand, productSpecificationType.brand) &&
        Objects.equals(this.number, productSpecificationType.number) &&
        Objects.equals(this.attachment, productSpecificationType.attachment) &&
        Objects.equals(this.offerings, productSpecificationType.offerings) &&
        Objects.equals(this.isBundle, productSpecificationType.isBundle) &&
        Objects.equals(this.bundledProductSpecification, productSpecificationType.bundledProductSpecification) &&
        Objects.equals(this.productSpecificationRelationship, productSpecificationType.productSpecificationRelationship) &&
        Objects.equals(this.productSpecCharacteristic, productSpecificationType.productSpecCharacteristic) &&
        Objects.equals(this.lifeCycleStatus, productSpecificationType.lifeCycleStatus) &&
        Objects.equals(this.additionalData, productSpecificationType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, correlationId, name, description, category, validFor, brand, number, attachment, offerings, isBundle, bundledProductSpecification, productSpecificationRelationship, productSpecCharacteristic, lifeCycleStatus, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    attachment: ").append(toIndentedString(attachment)).append("\n");
    sb.append("    offerings: ").append(toIndentedString(offerings)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    bundledProductSpecification: ").append(toIndentedString(bundledProductSpecification)).append("\n");
    sb.append("    productSpecificationRelationship: ").append(toIndentedString(productSpecificationRelationship)).append("\n");
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

