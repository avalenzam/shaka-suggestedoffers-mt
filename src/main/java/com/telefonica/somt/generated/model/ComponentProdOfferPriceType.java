package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.BenefitType;
import com.telefonica.somt.generated.model.EntityRefType;
import com.telefonica.somt.generated.model.KeyValueType;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.ProdOfferPriceAlterationType;
import com.telefonica.somt.generated.model.QuantityType;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ComponentProdOfferPriceType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ComponentProdOfferPriceType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("productSpecContainmentID")
  private String productSpecContainmentID = null;

  @JsonProperty("pricePlanSpecContainmentID")
  private String pricePlanSpecContainmentID = null;

  @JsonProperty("isMandatory")
  private Boolean isMandatory = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  /**
   * Identification for the type of individual pricing component
   */
  public enum PriceTypeEnum {
    RECURRING("recurring"),
    
    USAGE("usage"),
    
    ONE_TIME("one time");

    private String value;

    PriceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PriceTypeEnum fromValue(String text) {
      for (PriceTypeEnum b : PriceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("priceType")
  private PriceTypeEnum priceType = null;

  /**
   * Identification for the recurring charging periodicity in the case of recurring pricing models (e.g.: monthly, yearly)
   */
  public enum RecurringChargePeriodEnum {
    DAILY("daily"),
    
    WEEKLY("weekly"),
    
    MONTHLY("monthly"),
    
    YEARLY("yearly");

    private String value;

    RecurringChargePeriodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RecurringChargePeriodEnum fromValue(String text) {
      for (RecurringChargePeriodEnum b : RecurringChargePeriodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("recurringChargePeriod")
  private RecurringChargePeriodEnum recurringChargePeriod = null;

  @JsonProperty("unitOfMeasure")
  private QuantityType unitOfMeasure = null;

  @JsonProperty("price")
  private MoneyType price = null;

  @JsonProperty("minPrice")
  private MoneyType minPrice = null;

  @JsonProperty("maxPrice")
  private MoneyType maxPrice = null;

  @JsonProperty("taxAmount")
  private MoneyType taxAmount = null;

  @JsonProperty("priceWithTax")
  private MoneyType priceWithTax = null;

  @JsonProperty("originalAmount")
  private MoneyType originalAmount = null;

  @JsonProperty("originalTaxAmount")
  private MoneyType originalTaxAmount = null;

  @JsonProperty("taxIncluded")
  private Boolean taxIncluded = null;

  @JsonProperty("taxRate")
  private BigDecimal taxRate = null;

  @JsonProperty("taxType")
  private String taxType = null;

  @JsonProperty("productOfferPriceAlteration")
  private List<ProdOfferPriceAlterationType> productOfferPriceAlteration = new ArrayList<ProdOfferPriceAlterationType>();

  @JsonProperty("pricedComponents")
  private List<KeyValueType> pricedComponents = new ArrayList<KeyValueType>();

  @JsonProperty("priceLocation")
  private List<String> priceLocation = new ArrayList<String>();

  @JsonProperty("priceConsumer")
  private EntityRefType priceConsumer = null;

  @JsonProperty("benefits")
  private List<BenefitType> benefits = new ArrayList<BenefitType>();

  @JsonProperty("additionalData")
  private List<KeyValueType> additionalData = new ArrayList<KeyValueType>();

  public ComponentProdOfferPriceType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier for the pricing model
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier for the pricing model")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ComponentProdOfferPriceType code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Code of the billingOffer
   * @return code
  **/
  @ApiModelProperty(value = "Code of the billingOffer")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ComponentProdOfferPriceType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable pricing model name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable pricing model name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ComponentProdOfferPriceType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A human readable pricing short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable pricing short description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ComponentProdOfferPriceType productSpecContainmentID(String productSpecContainmentID) {
    this.productSpecContainmentID = productSpecContainmentID;
    return this;
  }

   /**
   * Esta es la relación entre el componente del padre y el componente principal.  Seran usados para la creación de orden (UPC)
   * @return productSpecContainmentID
  **/
  @ApiModelProperty(value = "Esta es la relación entre el componente del padre y el componente principal.  Seran usados para la creación de orden (UPC)")
  public String getProductSpecContainmentID() {
    return productSpecContainmentID;
  }

  public void setProductSpecContainmentID(String productSpecContainmentID) {
    this.productSpecContainmentID = productSpecContainmentID;
  }

  public ComponentProdOfferPriceType pricePlanSpecContainmentID(String pricePlanSpecContainmentID) {
    this.pricePlanSpecContainmentID = pricePlanSpecContainmentID;
    return this;
  }

   /**
   * Identificador de la relación entre el componente padre y la billingOffer.    Seran usados para la creación de orden (UPC)
   * @return pricePlanSpecContainmentID
  **/
  @ApiModelProperty(value = "Identificador de la relación entre el componente padre y la billingOffer.    Seran usados para la creación de orden (UPC)")
  public String getPricePlanSpecContainmentID() {
    return pricePlanSpecContainmentID;
  }

  public void setPricePlanSpecContainmentID(String pricePlanSpecContainmentID) {
    this.pricePlanSpecContainmentID = pricePlanSpecContainmentID;
  }

  public ComponentProdOfferPriceType isMandatory(Boolean isMandatory) {
    this.isMandatory = isMandatory;
    return this;
  }

   /**
   * Indicates if the pricing model must be always included as part of the offering
   * @return isMandatory
  **/
  @ApiModelProperty(value = "Indicates if the pricing model must be always included as part of the offering")
  public Boolean getIsMandatory() {
    return isMandatory;
  }

  public void setIsMandatory(Boolean isMandatory) {
    this.isMandatory = isMandatory;
  }

  public ComponentProdOfferPriceType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the charging price model in the catalog. If not enDate included in the structure then no ending date for validity is defined.
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the charging price model in the catalog. If not enDate included in the structure then no ending date for validity is defined.")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public ComponentProdOfferPriceType priceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
    return this;
  }

   /**
   * Identification for the type of individual pricing component
   * @return priceType
  **/
  @ApiModelProperty(required = true, value = "Identification for the type of individual pricing component")
  @NotNull
  public PriceTypeEnum getPriceType() {
    return priceType;
  }

  public void setPriceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
  }

  public ComponentProdOfferPriceType recurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

   /**
   * Identification for the recurring charging periodicity in the case of recurring pricing models (e.g.: monthly, yearly)
   * @return recurringChargePeriod
  **/
  @ApiModelProperty(value = "Identification for the recurring charging periodicity in the case of recurring pricing models (e.g.: monthly, yearly)")
  public RecurringChargePeriodEnum getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public ComponentProdOfferPriceType unitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * Indication of the criteria to be used for the charging (e.g.: per minute, per second, per GB, per 50GB, per license, per subscription to offering ...). Notice that in the TMForum API version 14.5 this parameter is defined as a string, not meeting SID definition
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Indication of the criteria to be used for the charging (e.g.: per minute, per second, per GB, per 50GB, per license, per subscription to offering ...). Notice that in the TMForum API version 14.5 this parameter is defined as a string, not meeting SID definition")
  public QuantityType getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public ComponentProdOfferPriceType price(MoneyType price) {
    this.price = price;
    return this;
  }

   /**
   * Base value applied to the price model offering (tax included). This could refer to a charge, a discount or an allowance. If the value is defined as a range (min and max included) this will define the defaulted amount
   * @return price
  **/
  @ApiModelProperty(required = true, value = "Base value applied to the price model offering (tax included). This could refer to a charge, a discount or an allowance. If the value is defined as a range (min and max included) this will define the defaulted amount")
  @NotNull
  public MoneyType getPrice() {
    return price;
  }

  public void setPrice(MoneyType price) {
    this.price = price;
  }

  public ComponentProdOfferPriceType minPrice(MoneyType minPrice) {
    this.minPrice = minPrice;
    return this;
  }

   /**
   * Minimum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value
   * @return minPrice
  **/
  @ApiModelProperty(value = "Minimum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value")
  public MoneyType getMinPrice() {
    return minPrice;
  }

  public void setMinPrice(MoneyType minPrice) {
    this.minPrice = minPrice;
  }

  public ComponentProdOfferPriceType maxPrice(MoneyType maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }

   /**
   * Maximum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value
   * @return maxPrice
  **/
  @ApiModelProperty(value = "Maximum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value")
  public MoneyType getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(MoneyType maxPrice) {
    this.maxPrice = maxPrice;
  }

  public ComponentProdOfferPriceType taxAmount(MoneyType taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

   /**
   * Tax amount
   * @return taxAmount
  **/
  @ApiModelProperty(value = "Tax amount")
  public MoneyType getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(MoneyType taxAmount) {
    this.taxAmount = taxAmount;
  }

  public ComponentProdOfferPriceType priceWithTax(MoneyType priceWithTax) {
    this.priceWithTax = priceWithTax;
    return this;
  }

   /**
   * The sum of price + taAmount
   * @return priceWithTax
  **/
  @ApiModelProperty(value = "The sum of price + taAmount")
  public MoneyType getPriceWithTax() {
    return priceWithTax;
  }

  public void setPriceWithTax(MoneyType priceWithTax) {
    this.priceWithTax = priceWithTax;
  }

  public ComponentProdOfferPriceType originalAmount(MoneyType originalAmount) {
    this.originalAmount = originalAmount;
    return this;
  }

   /**
   * The original amount of the price - before any discounts.
   * @return originalAmount
  **/
  @ApiModelProperty(value = "The original amount of the price - before any discounts.")
  public MoneyType getOriginalAmount() {
    return originalAmount;
  }

  public void setOriginalAmount(MoneyType originalAmount) {
    this.originalAmount = originalAmount;
  }

  public ComponentProdOfferPriceType originalTaxAmount(MoneyType originalTaxAmount) {
    this.originalTaxAmount = originalTaxAmount;
    return this;
  }

   /**
   * The original Tax amount of the price - before any discounts.
   * @return originalTaxAmount
  **/
  @ApiModelProperty(value = "The original Tax amount of the price - before any discounts.")
  public MoneyType getOriginalTaxAmount() {
    return originalTaxAmount;
  }

  public void setOriginalTaxAmount(MoneyType originalTaxAmount) {
    this.originalTaxAmount = originalTaxAmount;
  }

  public ComponentProdOfferPriceType taxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
    return this;
  }

   /**
   * Indication if the price is with taxes (true) or without (false)
   * @return taxIncluded
  **/
  @ApiModelProperty(value = "Indication if the price is with taxes (true) or without (false)")
  public Boolean getTaxIncluded() {
    return taxIncluded;
  }

  public void setTaxIncluded(Boolean taxIncluded) {
    this.taxIncluded = taxIncluded;
  }

  public ComponentProdOfferPriceType taxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
    return this;
  }

   /**
   * Taxes (in percentage) applied to the individual pricing component
   * @return taxRate
  **/
  @ApiModelProperty(value = "Taxes (in percentage) applied to the individual pricing component")
  public BigDecimal getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(BigDecimal taxRate) {
    this.taxRate = taxRate;
  }

  public ComponentProdOfferPriceType taxType(String taxType) {
    this.taxType = taxType;
    return this;
  }

   /**
   * Indication on the type of tax applied (e.g. VAT, IVA,...)
   * @return taxType
  **/
  @ApiModelProperty(value = "Indication on the type of tax applied (e.g. VAT, IVA,...)")
  public String getTaxType() {
    return taxType;
  }

  public void setTaxType(String taxType) {
    this.taxType = taxType;
  }

  public ComponentProdOfferPriceType productOfferPriceAlteration(List<ProdOfferPriceAlterationType> productOfferPriceAlteration) {
    this.productOfferPriceAlteration = productOfferPriceAlteration;
    return this;
  }

  public ComponentProdOfferPriceType addProductOfferPriceAlterationItem(ProdOfferPriceAlterationType productOfferPriceAlterationItem) {
    this.productOfferPriceAlteration.add(productOfferPriceAlterationItem);
    return this;
  }

   /**
   * An amount, usually of money, that modifies a price charged for a ProductOffering
   * @return productOfferPriceAlteration
  **/
  @ApiModelProperty(value = "An amount, usually of money, that modifies a price charged for a ProductOffering")
  public List<ProdOfferPriceAlterationType> getProductOfferPriceAlteration() {
    return productOfferPriceAlteration;
  }

  public void setProductOfferPriceAlteration(List<ProdOfferPriceAlterationType> productOfferPriceAlteration) {
    this.productOfferPriceAlteration = productOfferPriceAlteration;
  }

  public ComponentProdOfferPriceType pricedComponents(List<KeyValueType> pricedComponents) {
    this.pricedComponents = pricedComponents;
    return this;
  }

  public ComponentProdOfferPriceType addPricedComponentsItem(KeyValueType pricedComponentsItem) {
    this.pricedComponents.add(pricedComponentsItem);
    return this;
  }

   /**
   * Combination of characteristics to apply the charging. If not included, the charge applies to the whole offering/product.
   * @return pricedComponents
  **/
  @ApiModelProperty(value = "Combination of characteristics to apply the charging. If not included, the charge applies to the whole offering/product.")
  public List<KeyValueType> getPricedComponents() {
    return pricedComponents;
  }

  public void setPricedComponents(List<KeyValueType> pricedComponents) {
    this.pricedComponents = pricedComponents;
  }

  public ComponentProdOfferPriceType priceLocation(List<String> priceLocation) {
    this.priceLocation = priceLocation;
    return this;
  }

  public ComponentProdOfferPriceType addPriceLocationItem(String priceLocationItem) {
    this.priceLocation.add(priceLocationItem);
    return this;
  }

   /**
   * Identification for the specific locations where the price applies. This is intended to allow complex scenarios where a given price depends on the location
   * @return priceLocation
  **/
  @ApiModelProperty(value = "Identification for the specific locations where the price applies. This is intended to allow complex scenarios where a given price depends on the location")
  public List<String> getPriceLocation() {
    return priceLocation;
  }

  public void setPriceLocation(List<String> priceLocation) {
    this.priceLocation = priceLocation;
  }

  public ComponentProdOfferPriceType priceConsumer(EntityRefType priceConsumer) {
    this.priceConsumer = priceConsumer;
    return this;
  }

   /**
   * Reference to the entity identifying the specific consumer for the price. This is intended to allow complex scenarios where a given price depends on the specific consumer of a product/service
   * @return priceConsumer
  **/
  @ApiModelProperty(value = "Reference to the entity identifying the specific consumer for the price. This is intended to allow complex scenarios where a given price depends on the specific consumer of a product/service")
  public EntityRefType getPriceConsumer() {
    return priceConsumer;
  }

  public void setPriceConsumer(EntityRefType priceConsumer) {
    this.priceConsumer = priceConsumer;
  }

  public ComponentProdOfferPriceType benefits(List<BenefitType> benefits) {
    this.benefits = benefits;
    return this;
  }

  public ComponentProdOfferPriceType addBenefitsItem(BenefitType benefitsItem) {
    this.benefits.add(benefitsItem);
    return this;
  }

   /**
   * Beneficios asociados a la Billing Offer del Plan
   * @return benefits
  **/
  @ApiModelProperty(value = "Beneficios asociados a la Billing Offer del Plan")
  public List<BenefitType> getBenefits() {
    return benefits;
  }

  public void setBenefits(List<BenefitType> benefits) {
    this.benefits = benefits;
  }

  public ComponentProdOfferPriceType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ComponentProdOfferPriceType addAdditionalDataItem(KeyValueType additionalDataItem) {
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
    ComponentProdOfferPriceType componentProdOfferPriceType = (ComponentProdOfferPriceType) o;
    return Objects.equals(this.id, componentProdOfferPriceType.id) &&
        Objects.equals(this.code, componentProdOfferPriceType.code) &&
        Objects.equals(this.name, componentProdOfferPriceType.name) &&
        Objects.equals(this.description, componentProdOfferPriceType.description) &&
        Objects.equals(this.productSpecContainmentID, componentProdOfferPriceType.productSpecContainmentID) &&
        Objects.equals(this.pricePlanSpecContainmentID, componentProdOfferPriceType.pricePlanSpecContainmentID) &&
        Objects.equals(this.isMandatory, componentProdOfferPriceType.isMandatory) &&
        Objects.equals(this.validFor, componentProdOfferPriceType.validFor) &&
        Objects.equals(this.priceType, componentProdOfferPriceType.priceType) &&
        Objects.equals(this.recurringChargePeriod, componentProdOfferPriceType.recurringChargePeriod) &&
        Objects.equals(this.unitOfMeasure, componentProdOfferPriceType.unitOfMeasure) &&
        Objects.equals(this.price, componentProdOfferPriceType.price) &&
        Objects.equals(this.minPrice, componentProdOfferPriceType.minPrice) &&
        Objects.equals(this.maxPrice, componentProdOfferPriceType.maxPrice) &&
        Objects.equals(this.taxAmount, componentProdOfferPriceType.taxAmount) &&
        Objects.equals(this.priceWithTax, componentProdOfferPriceType.priceWithTax) &&
        Objects.equals(this.originalAmount, componentProdOfferPriceType.originalAmount) &&
        Objects.equals(this.originalTaxAmount, componentProdOfferPriceType.originalTaxAmount) &&
        Objects.equals(this.taxIncluded, componentProdOfferPriceType.taxIncluded) &&
        Objects.equals(this.taxRate, componentProdOfferPriceType.taxRate) &&
        Objects.equals(this.taxType, componentProdOfferPriceType.taxType) &&
        Objects.equals(this.productOfferPriceAlteration, componentProdOfferPriceType.productOfferPriceAlteration) &&
        Objects.equals(this.pricedComponents, componentProdOfferPriceType.pricedComponents) &&
        Objects.equals(this.priceLocation, componentProdOfferPriceType.priceLocation) &&
        Objects.equals(this.priceConsumer, componentProdOfferPriceType.priceConsumer) &&
        Objects.equals(this.benefits, componentProdOfferPriceType.benefits) &&
        Objects.equals(this.additionalData, componentProdOfferPriceType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code, name, description, productSpecContainmentID, pricePlanSpecContainmentID, isMandatory, validFor, priceType, recurringChargePeriod, unitOfMeasure, price, minPrice, maxPrice, taxAmount, priceWithTax, originalAmount, originalTaxAmount, taxIncluded, taxRate, taxType, productOfferPriceAlteration, pricedComponents, priceLocation, priceConsumer, benefits, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComponentProdOfferPriceType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    productSpecContainmentID: ").append(toIndentedString(productSpecContainmentID)).append("\n");
    sb.append("    pricePlanSpecContainmentID: ").append(toIndentedString(pricePlanSpecContainmentID)).append("\n");
    sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    minPrice: ").append(toIndentedString(minPrice)).append("\n");
    sb.append("    maxPrice: ").append(toIndentedString(maxPrice)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    priceWithTax: ").append(toIndentedString(priceWithTax)).append("\n");
    sb.append("    originalAmount: ").append(toIndentedString(originalAmount)).append("\n");
    sb.append("    originalTaxAmount: ").append(toIndentedString(originalTaxAmount)).append("\n");
    sb.append("    taxIncluded: ").append(toIndentedString(taxIncluded)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    taxType: ").append(toIndentedString(taxType)).append("\n");
    sb.append("    productOfferPriceAlteration: ").append(toIndentedString(productOfferPriceAlteration)).append("\n");
    sb.append("    pricedComponents: ").append(toIndentedString(pricedComponents)).append("\n");
    sb.append("    priceLocation: ").append(toIndentedString(priceLocation)).append("\n");
    sb.append("    priceConsumer: ").append(toIndentedString(priceConsumer)).append("\n");
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

