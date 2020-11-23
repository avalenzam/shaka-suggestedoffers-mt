package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.BenefitType;
import com.telefonica.somt.generated.model.CategoryTreeType;
import com.telefonica.somt.generated.model.ChannelInfoType;
import com.telefonica.somt.generated.model.ComponentProdOfferPriceType;
import com.telefonica.somt.generated.model.ComposingOfferingType;
import com.telefonica.somt.generated.model.ComposingProductType;
import com.telefonica.somt.generated.model.KeyValueType;
import com.telefonica.somt.generated.model.PenaltyType;
import com.telefonica.somt.generated.model.ProductInstanceRefType;
import com.telefonica.somt.generated.model.TimePeriodType;
import com.telefonica.somt.generated.model.UpFrontType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * OfferingType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class OfferingType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("catalogItemType")
  private String catalogItemType = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Indica el tipo de oferta a obtener  Puede tomar dos valores: elegibles ,  sugeridas
   */
  public enum TypeEnum {
    ELEGIBLES("elegibles"),
    
    SUGERIDAS("sugeridas");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("currentPlanRelationID")
  private String currentPlanRelationID = null;

  @JsonProperty("productOfferingProductSpecID")
  private String productOfferingProductSpecID = null;

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

  @JsonProperty("compatibleProducts")
  private List<ProductInstanceRefType> compatibleProducts = new ArrayList<ProductInstanceRefType>();

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

  @JsonProperty("isDowngrade")
  private Boolean isDowngrade = null;

  @JsonProperty("productOfferingPrice")
  private List<ComponentProdOfferPriceType> productOfferingPrice = new ArrayList<ComponentProdOfferPriceType>();

  /**
   * Status of the offering within the catalog
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

  @JsonProperty("upFront")
  private UpFrontType upFront = null;

  @JsonProperty("benefits")
  private List<BenefitType> benefits = new ArrayList<BenefitType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public OfferingType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique Identifier within the server for the offering reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique Identifier within the server for the offering reported")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OfferingType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Code of Offer reported
   * @return code
  **/
  @ApiModelProperty(value = "Code of Offer reported")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public OfferingType catalogItemType(String catalogItemType) {
    this.catalogItemType = catalogItemType;
    return this;
  }

   /**
   * Represents the Catalog item type.
   * @return catalogItemType
  **/
  @ApiModelProperty(value = "Represents the Catalog item type.")
  public String getCatalogItemType() {
    return catalogItemType;
  }

  public void setCatalogItemType(String catalogItemType) {
    this.catalogItemType = catalogItemType;
  }

  public OfferingType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the detailed information of the offering
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the resource in the OB that stores the detailed information of the offering")
  @NotNull
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public OfferingType correlationId(String correlationId) {
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

  public OfferingType name(String name) {
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

  public OfferingType description(String description) {
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

  public OfferingType type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Indica el tipo de oferta a obtener  Puede tomar dos valores: elegibles ,  sugeridas
   * @return type
  **/
  @ApiModelProperty(value = "Indica el tipo de oferta a obtener  Puede tomar dos valores: elegibles ,  sugeridas")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public OfferingType currentPlanRelationID(String currentPlanRelationID) {
    this.currentPlanRelationID = currentPlanRelationID;
    return this;
  }

   /**
   * Id del plan actual de la billing offer
   * @return currentPlanRelationID
  **/
  @ApiModelProperty(value = "Id del plan actual de la billing offer")
  public String getCurrentPlanRelationID() {
    return currentPlanRelationID;
  }

  public void setCurrentPlanRelationID(String currentPlanRelationID) {
    this.currentPlanRelationID = currentPlanRelationID;
  }

  public OfferingType productOfferingProductSpecID(String productOfferingProductSpecID) {
    this.productOfferingProductSpecID = productOfferingProductSpecID;
    return this;
  }

   /**
   * Identificador de la relación entre el producto    en sí (como WirelessMain) y sus especificaciones    de producto (como Wireless).
   * @return productOfferingProductSpecID
  **/
  @ApiModelProperty(value = "Identificador de la relación entre el producto    en sí (como WirelessMain) y sus especificaciones    de producto (como Wireless).")
  public String getProductOfferingProductSpecID() {
    return productOfferingProductSpecID;
  }

  public void setProductOfferingProductSpecID(String productOfferingProductSpecID) {
    this.productOfferingProductSpecID = productOfferingProductSpecID;
  }

  public OfferingType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public OfferingType addCategoryItem(CategoryTreeType categoryItem) {
    this.category.add(categoryItem);
    return this;
  }

   /**
   * List of categories/subcategories allocated to the offering, intended to allow segmentation A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree
   * @return category
  **/
  @ApiModelProperty(value = "List of categories/subcategories allocated to the offering, intended to allow segmentation A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree")
  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public OfferingType isPromotion(Boolean isPromotion) {
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

  public OfferingType billingMethod(BillingMethodEnum billingMethod) {
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

  public OfferingType channel(List<ChannelInfoType> channel) {
    this.channel = channel;
    return this;
  }

  public OfferingType addChannelItem(ChannelInfoType channelItem) {
    this.channel.add(channelItem);
    return this;
  }

   /**
   * Defines the channels that can be used for selling the product offering
   * @return channel
  **/
  @ApiModelProperty(value = "Defines the channels that can be used for selling the product offering")
  public List<ChannelInfoType> getChannel() {
    return channel;
  }

  public void setChannel(List<ChannelInfoType> channel) {
    this.channel = channel;
  }

  public OfferingType frameworkAgreement(String frameworkAgreement) {
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

  public OfferingType customerId(String customerId) {
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

  public OfferingType compatibleProducts(List<ProductInstanceRefType> compatibleProducts) {
    this.compatibleProducts = compatibleProducts;
    return this;
  }

  public OfferingType addCompatibleProductsItem(ProductInstanceRefType compatibleProductsItem) {
    this.compatibleProducts.add(compatibleProductsItem);
    return this;
  }

   /**
   * Indication of an existing product already acquired by the customer that is compatible with the offering
   * @return compatibleProducts
  **/
  @ApiModelProperty(value = "Indication of an existing product already acquired by the customer that is compatible with the offering")
  public List<ProductInstanceRefType> getCompatibleProducts() {
    return compatibleProducts;
  }

  public void setCompatibleProducts(List<ProductInstanceRefType> compatibleProducts) {
    this.compatibleProducts = compatibleProducts;
  }

  public OfferingType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

   /**
   * Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)
   * @return isBundle
  **/
  @ApiModelProperty(required = true, value = "Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)")
  @NotNull
  public Boolean getIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public OfferingType offeringUrl(String offeringUrl) {
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

  public OfferingType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the product in the catalog. If not enDate included in the structure then no ending date for validity is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the product in the catalog. If not enDate included in the structure then no ending date for validity is defined")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public OfferingType bundledProductOffering(List<ComposingOfferingType> bundledProductOffering) {
    this.bundledProductOffering = bundledProductOffering;
    return this;
  }

  public OfferingType addBundledProductOfferingItem(ComposingOfferingType bundledProductOfferingItem) {
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

  public OfferingType productSpecification(List<ComposingProductType> productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public OfferingType addProductSpecificationItem(ComposingProductType productSpecificationItem) {
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

  public OfferingType isDowngrade(Boolean isDowngrade) {
    this.isDowngrade = isDowngrade;
    return this;
  }

   /**
   * When reporting the offerings that are intended for an specific customer/account, this paremeter indicates if the offering is a downgrade of any of the existing offerings subscribed by the customer/account
   * @return isDowngrade
  **/
  @ApiModelProperty(value = "When reporting the offerings that are intended for an specific customer/account, this paremeter indicates if the offering is a downgrade of any of the existing offerings subscribed by the customer/account")
  public Boolean getIsDowngrade() {
    return isDowngrade;
  }

  public void setIsDowngrade(Boolean isDowngrade) {
    this.isDowngrade = isDowngrade;
  }

  public OfferingType productOfferingPrice(List<ComponentProdOfferPriceType> productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  public OfferingType addProductOfferingPriceItem(ComponentProdOfferPriceType productOfferingPriceItem) {
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

  public OfferingType lifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
    return this;
  }

   /**
   * Status of the offering within the catalog
   * @return lifeCycleStatus
  **/
  @ApiModelProperty(value = "Status of the offering within the catalog")
  public LifeCycleStatusEnum getLifeCycleStatus() {
    return lifeCycleStatus;
  }

  public void setLifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
  }

  public OfferingType offeringPenalties(List<PenaltyType> offeringPenalties) {
    this.offeringPenalties = offeringPenalties;
    return this;
  }

  public OfferingType addOfferingPenaltiesItem(PenaltyType offeringPenaltiesItem) {
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

  public OfferingType upFront(UpFrontType upFront) {
    this.upFront = upFront;
    return this;
  }

   /**
   * Objeto que indica si se debe cobrar por la instalación del serivicio fijo
   * @return upFront
  **/
  @ApiModelProperty(value = "Objeto que indica si se debe cobrar por la instalación del serivicio fijo")
  public UpFrontType getUpFront() {
    return upFront;
  }

  public void setUpFront(UpFrontType upFront) {
    this.upFront = upFront;
  }

  public OfferingType benefits(List<BenefitType> benefits) {
    this.benefits = benefits;
    return this;
  }

  public OfferingType addBenefitsItem(BenefitType benefitsItem) {
    this.benefits.add(benefitsItem);
    return this;
  }

   /**
   * Beneficios asociados a la oferta
   * @return benefits
  **/
  @ApiModelProperty(value = "Beneficios asociados a la oferta")
  public List<BenefitType> getBenefits() {
    return benefits;
  }

  public void setBenefits(List<BenefitType> benefits) {
    this.benefits = benefits;
  }

  public OfferingType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public OfferingType addAdditionalDataItem(KeyValueType additionalDataItem) {
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
    OfferingType offeringType = (OfferingType) o;
    return Objects.equals(this.id, offeringType.id) &&
        Objects.equals(this.code, offeringType.code) &&
        Objects.equals(this.catalogItemType, offeringType.catalogItemType) &&
        Objects.equals(this.href, offeringType.href) &&
        Objects.equals(this.correlationId, offeringType.correlationId) &&
        Objects.equals(this.name, offeringType.name) &&
        Objects.equals(this.description, offeringType.description) &&
        Objects.equals(this.type, offeringType.type) &&
        Objects.equals(this.currentPlanRelationID, offeringType.currentPlanRelationID) &&
        Objects.equals(this.productOfferingProductSpecID, offeringType.productOfferingProductSpecID) &&
        Objects.equals(this.category, offeringType.category) &&
        Objects.equals(this.isPromotion, offeringType.isPromotion) &&
        Objects.equals(this.billingMethod, offeringType.billingMethod) &&
        Objects.equals(this.channel, offeringType.channel) &&
        Objects.equals(this.frameworkAgreement, offeringType.frameworkAgreement) &&
        Objects.equals(this.customerId, offeringType.customerId) &&
        Objects.equals(this.compatibleProducts, offeringType.compatibleProducts) &&
        Objects.equals(this.isBundle, offeringType.isBundle) &&
        Objects.equals(this.offeringUrl, offeringType.offeringUrl) &&
        Objects.equals(this.validFor, offeringType.validFor) &&
        Objects.equals(this.bundledProductOffering, offeringType.bundledProductOffering) &&
        Objects.equals(this.productSpecification, offeringType.productSpecification) &&
        Objects.equals(this.isDowngrade, offeringType.isDowngrade) &&
        Objects.equals(this.productOfferingPrice, offeringType.productOfferingPrice) &&
        Objects.equals(this.lifeCycleStatus, offeringType.lifeCycleStatus) &&
        Objects.equals(this.offeringPenalties, offeringType.offeringPenalties) &&
        Objects.equals(this.upFront, offeringType.upFront) &&
        Objects.equals(this.benefits, offeringType.benefits) &&
        Objects.equals(this.additionalData, offeringType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, catalogItemType, href, correlationId, name, description, type, currentPlanRelationID, productOfferingProductSpecID, category, isPromotion, billingMethod, channel, frameworkAgreement, customerId, compatibleProducts, isBundle, offeringUrl, validFor, bundledProductOffering, productSpecification, isDowngrade, productOfferingPrice, lifeCycleStatus, offeringPenalties, upFront, benefits, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferingType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    catalogItemType: ").append(toIndentedString(catalogItemType)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    currentPlanRelationID: ").append(toIndentedString(currentPlanRelationID)).append("\n");
    sb.append("    productOfferingProductSpecID: ").append(toIndentedString(productOfferingProductSpecID)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isPromotion: ").append(toIndentedString(isPromotion)).append("\n");
    sb.append("    billingMethod: ").append(toIndentedString(billingMethod)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    frameworkAgreement: ").append(toIndentedString(frameworkAgreement)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    compatibleProducts: ").append(toIndentedString(compatibleProducts)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    offeringUrl: ").append(toIndentedString(offeringUrl)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    isDowngrade: ").append(toIndentedString(isDowngrade)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    lifeCycleStatus: ").append(toIndentedString(lifeCycleStatus)).append("\n");
    sb.append("    offeringPenalties: ").append(toIndentedString(offeringPenalties)).append("\n");
    sb.append("    upFront: ").append(toIndentedString(upFront)).append("\n");
    sb.append("    benefits: ").append(toIndentedString(benefits)).append("\n");
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

