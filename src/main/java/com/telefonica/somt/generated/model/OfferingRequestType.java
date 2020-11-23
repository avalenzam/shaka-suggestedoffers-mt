package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.CategoryTreeType;
import com.telefonica.somt.generated.model.ChannelInfoType;
import com.telefonica.somt.generated.model.ComponentProdOfferPriceType;
import com.telefonica.somt.generated.model.ComposingOfferingType;
import com.telefonica.somt.generated.model.ComposingProductType;
import com.telefonica.somt.generated.model.KeyValueType;
import com.telefonica.somt.generated.model.PenaltyType;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * OfferingRequestType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class OfferingRequestType  implements Serializable {
  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("category")
  private List<CategoryTreeType> category = new ArrayList<CategoryTreeType>();

  @JsonProperty("isPromotion")
  private Boolean isPromotion = null;

  /**
   * How this offered product is billed
   */
  public enum BillingMethodEnum {
    PREPAID("prepaid"),
    
    POSTPAID("postpaid"),
    
    CONTROL("control"),
    
    HYBRID("hybrid");

    private String value;

    BillingMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BillingMethodEnum fromValue(String text) {
      for (BillingMethodEnum b : BillingMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("billingMethod")
  private BillingMethodEnum billingMethod = null;

  @JsonProperty("channel")
  private List<ChannelInfoType> channel = new ArrayList<ChannelInfoType>();

  @JsonProperty("frameworkAgreement")
  private String frameworkAgreement = null;

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("offeringUrl")
  private String offeringUrl = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("bundledProductOffering")
  private List<ComposingOfferingType> bundledProductOffering = new ArrayList<ComposingOfferingType>();

  @JsonProperty("productSpecification")
  private List<ComposingProductType> productSpecification = new ArrayList<ComposingProductType>();

  @JsonProperty("productOfferingPrice")
  private List<ComponentProdOfferPriceType> productOfferingPrice = new ArrayList<ComponentProdOfferPriceType>();

  /**
   * Status to be set for the offering within the catalog
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

  @JsonProperty("offeringPenalties")
  private List<PenaltyType> offeringPenalties = new ArrayList<PenaltyType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public OfferingRequestType correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

   /**
   * Unique identifier for the offering within the client, used to synchronize and map internal identifiers between server and client
   * @return correlationId
  **/
  @ApiModelProperty(value = "Unique identifier for the offering within the client, used to synchronize and map internal identifiers between server and client")
  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public OfferingRequestType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable offering name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable offering name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OfferingRequestType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A human readable offering short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable offering short description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OfferingRequestType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public OfferingRequestType addCategoryItem(CategoryTreeType categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * List of categories/subcategories allocated to the offering, intended to allow segmentation. A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree
   * @return category
  **/
  @ApiModelProperty(value = "List of categories/subcategories allocated to the offering, intended to allow segmentation. A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree")
  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public OfferingRequestType isPromotion(Boolean isPromotion) {
    this.isPromotion = isPromotion;
    return this;
  }

   /**
   * Indicates if the offering is a promotion
   * @return isPromotion
  **/
  @ApiModelProperty(value = "Indicates if the offering is a promotion")
  public Boolean getIsPromotion() {
    return isPromotion;
  }

  public void setIsPromotion(Boolean isPromotion) {
    this.isPromotion = isPromotion;
  }

  public OfferingRequestType billingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
    return this;
  }

   /**
   * How this offered product is billed
   * @return billingMethod
  **/
  @ApiModelProperty(value = "How this offered product is billed")
  public BillingMethodEnum getBillingMethod() {
    return billingMethod;
  }

  public void setBillingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
  }

  public OfferingRequestType channel(List<ChannelInfoType> channel) {
    this.channel = channel;
    return this;
  }

  public OfferingRequestType addChannelItem(ChannelInfoType channelItem) {
    this.channel.add(channelItem);
    return this;
  }

   /**
   * Defines the channels that can be used for selling the product offering (e.g.: WEB, CRM, SMS, IVR, UE)
   * @return channel
  **/
  @ApiModelProperty(value = "Defines the channels that can be used for selling the product offering (e.g.: WEB, CRM, SMS, IVR, UE)")
  public List<ChannelInfoType> getChannel() {
    return channel;
  }

  public void setChannel(List<ChannelInfoType> channel) {
    this.channel = channel;
  }

  public OfferingRequestType frameworkAgreement(String frameworkAgreement) {
    this.frameworkAgreement = frameworkAgreement;
    return this;
  }

   /**
   * Unique identifier of the framework agreement associated to the offering
   * @return frameworkAgreement
  **/
  @ApiModelProperty(value = "Unique identifier of the framework agreement associated to the offering")
  public String getFrameworkAgreement() {
    return frameworkAgreement;
  }

  public void setFrameworkAgreement(String frameworkAgreement) {
    this.frameworkAgreement = frameworkAgreement;
  }

  public OfferingRequestType customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Unique Identifier for the customer that is the specific target to the offering
   * @return customerId
  **/
  @ApiModelProperty(value = "Unique Identifier for the customer that is the specific target to the offering")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public OfferingRequestType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)
   * @return isBundle
  **/
  @ApiModelProperty(value = "Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)")
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public OfferingRequestType offeringUrl(String offeringUrl) {
    this.offeringUrl = offeringUrl;
    return this;
  }

   /**
   * A URL that can provide additional information of the offer (e.g.: weblink with a downloadable description brochure)
   * @return offeringUrl
  **/
  @ApiModelProperty(value = "A URL that can provide additional information of the offer (e.g.: weblink with a downloadable description brochure)")
  public String getOfferingUrl() {
    return offeringUrl;
  }

  public void setOfferingUrl(String offeringUrl) {
    this.offeringUrl = offeringUrl;
  }

  public OfferingRequestType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the product in the catalog. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the product in the catalog. If not included, the current date is used as starting date and no ending date is defined")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public OfferingRequestType bundledProductOffering(List<ComposingOfferingType> bundledProductOffering) {
    this.bundledProductOffering = bundledProductOffering;
    return this;
  }

  public OfferingRequestType addBundledProductOfferingItem(ComposingOfferingType bundledProductOfferingItem) {
    this.bundledProductOffering.add(bundledProductOfferingItem);
    return this;
  }

   /**
   * List of codes and URIs providing the resource address for the individual offerings included in the bundle offering
   * @return bundledProductOffering
  **/
  @ApiModelProperty(value = "List of codes and URIs providing the resource address for the individual offerings included in the bundle offering")
  public List<ComposingOfferingType> getBundledProductOffering() {
    return bundledProductOffering;
  }

  public void setBundledProductOffering(List<ComposingOfferingType> bundledProductOffering) {
    this.bundledProductOffering = bundledProductOffering;
  }

  public OfferingRequestType productSpecification(List<ComposingProductType> productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public OfferingRequestType addProductSpecificationItem(ComposingProductType productSpecificationItem) {
    this.productSpecification.add(productSpecificationItem);
    return this;
  }

   /**
   * List of codes and URIs providing the resource address for the products included in the offering. If the offer is for a single product (isBundle set to false) then the list will have one single entry
   * @return productSpecification
  **/
  @ApiModelProperty(value = "List of codes and URIs providing the resource address for the products included in the offering. If the offer is for a single product (isBundle set to false) then the list will have one single entry")
  public List<ComposingProductType> getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(List<ComposingProductType> productSpecification) {
    this.productSpecification = productSpecification;
  }

  public OfferingRequestType productOfferingPrice(List<ComponentProdOfferPriceType> productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  public OfferingRequestType addProductOfferingPriceItem(ComponentProdOfferPriceType productOfferingPriceItem) {
    this.productOfferingPrice.add(productOfferingPriceItem);
    return this;
  }

   /**
   * List of price models available for the offering
   * @return productOfferingPrice
  **/
  @ApiModelProperty(value = "List of price models available for the offering")
  public List<ComponentProdOfferPriceType> getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(List<ComponentProdOfferPriceType> productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }

  public OfferingRequestType lifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
    return this;
  }

   /**
   * Status to be set for the offering within the catalog
   * @return lifeCycleStatus
  **/
  @ApiModelProperty(value = "Status to be set for the offering within the catalog")
  public LifeCycleStatusEnum getLifeCycleStatus() {
    return lifeCycleStatus;
  }

  public void setLifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
  }

  public OfferingRequestType offeringPenalties(List<PenaltyType> offeringPenalties) {
    this.offeringPenalties = offeringPenalties;
    return this;
  }

  public OfferingRequestType addOfferingPenaltiesItem(PenaltyType offeringPenaltiesItem) {
    this.offeringPenalties.add(offeringPenaltiesItem);
    return this;
  }

   /**
   * List of penalties that can be applied to the product offering
   * @return offeringPenalties
  **/
  @ApiModelProperty(value = "List of penalties that can be applied to the product offering")
  public List<PenaltyType> getOfferingPenalties() {
    return offeringPenalties;
  }

  public void setOfferingPenalties(List<PenaltyType> offeringPenalties) {
    this.offeringPenalties = offeringPenalties;
  }

  public OfferingRequestType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public OfferingRequestType addAdditionalDataItem(KeyValueType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines")
  public List<KeyValueType> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(List<KeyValueType> additionalData) {
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
    OfferingRequestType offeringRequestType = (OfferingRequestType) o;
    return Objects.equals(this.correlationId, offeringRequestType.correlationId) &&
        Objects.equals(this.name, offeringRequestType.name) &&
        Objects.equals(this.description, offeringRequestType.description) &&
        Objects.equals(this.category, offeringRequestType.category) &&
        Objects.equals(this.isPromotion, offeringRequestType.isPromotion) &&
        Objects.equals(this.billingMethod, offeringRequestType.billingMethod) &&
        Objects.equals(this.channel, offeringRequestType.channel) &&
        Objects.equals(this.frameworkAgreement, offeringRequestType.frameworkAgreement) &&
        Objects.equals(this.customerId, offeringRequestType.customerId) &&
        Objects.equals(this.isBundle, offeringRequestType.isBundle) &&
        Objects.equals(this.offeringUrl, offeringRequestType.offeringUrl) &&
        Objects.equals(this.validFor, offeringRequestType.validFor) &&
        Objects.equals(this.bundledProductOffering, offeringRequestType.bundledProductOffering) &&
        Objects.equals(this.productSpecification, offeringRequestType.productSpecification) &&
        Objects.equals(this.productOfferingPrice, offeringRequestType.productOfferingPrice) &&
        Objects.equals(this.lifeCycleStatus, offeringRequestType.lifeCycleStatus) &&
        Objects.equals(this.offeringPenalties, offeringRequestType.offeringPenalties) &&
        Objects.equals(this.additionalData, offeringRequestType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(correlationId, name, description, category, isPromotion, billingMethod, channel, frameworkAgreement, customerId, isBundle, offeringUrl, validFor, bundledProductOffering, productSpecification, productOfferingPrice, lifeCycleStatus, offeringPenalties, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferingRequestType {\n");
    
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isPromotion: ").append(toIndentedString(isPromotion)).append("\n");
    sb.append("    billingMethod: ").append(toIndentedString(billingMethod)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    frameworkAgreement: ").append(toIndentedString(frameworkAgreement)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    offeringUrl: ").append(toIndentedString(offeringUrl)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    lifeCycleStatus: ").append(toIndentedString(lifeCycleStatus)).append("\n");
    sb.append("    offeringPenalties: ").append(toIndentedString(offeringPenalties)).append("\n");
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

