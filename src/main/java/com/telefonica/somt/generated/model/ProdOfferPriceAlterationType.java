package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.QuantityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProdOfferPriceAlterationType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProdOfferPriceAlterationType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("priceCondition")
  private String priceCondition = null;

  /**
   * Identification for the type of individual alteration type
   */
  public enum PriceTypeEnum {
    RECURRING_DISCOUNT("recurring discount"),
    
    ONE_TIME_DISCOUNT("one time discount"),
    
    RECURRING_ALLOWANCE("recurring allowance"),
    
    ONE_TIME_ALLOWANCE("one time allowance");

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

  @JsonProperty("applicationDuration")
  private Integer applicationDuration = null;

  @JsonProperty("unitOfMeasure")
  private QuantityType unitOfMeasure = null;

  /**
   * Identification for the type of discount to be applied
   */
  public enum DiscountTypeEnum {
    AMOUNT("amount"),
    
    PERCENTAGE("percentage");

    private String value;

    DiscountTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DiscountTypeEnum fromValue(String text) {
      for (DiscountTypeEnum b : DiscountTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("discountType")
  private DiscountTypeEnum discountType = null;

  @JsonProperty("price")
  private MoneyType price = null;

  @JsonProperty("additionalData")
  private List<MoneyType> additionalData = new ArrayList<MoneyType>();

  public ProdOfferPriceAlterationType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier for the price alteration model
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier for the price alteration model")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProdOfferPriceAlterationType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable charging discount model name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable charging discount model name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProdOfferPriceAlterationType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A human readable discount short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable discount short description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProdOfferPriceAlterationType priceCondition(String priceCondition) {
    this.priceCondition = priceCondition;
    return this;
  }

   /**
   * Text describing the condition that triggers the alteration to be applied
   * @return priceCondition
  **/
  @ApiModelProperty(required = true, value = "Text describing the condition that triggers the alteration to be applied")
  @NotNull
  public String getPriceCondition() {
    return priceCondition;
  }

  public void setPriceCondition(String priceCondition) {
    this.priceCondition = priceCondition;
  }

  public ProdOfferPriceAlterationType priceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
    return this;
  }

   /**
   * Identification for the type of individual alteration type
   * @return priceType
  **/
  @ApiModelProperty(required = true, value = "Identification for the type of individual alteration type")
  @NotNull
  public PriceTypeEnum getPriceType() {
    return priceType;
  }

  public void setPriceType(PriceTypeEnum priceType) {
    this.priceType = priceType;
  }

  public ProdOfferPriceAlterationType recurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
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

  public ProdOfferPriceAlterationType applicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
    return this;
  }

   /**
   * Duration defined as a number of instances of the recurring period to apply the alteration (e.g.: 2 months for the recurring discount)
   * @return applicationDuration
  **/
  @ApiModelProperty(value = "Duration defined as a number of instances of the recurring period to apply the alteration (e.g.: 2 months for the recurring discount)")
  public Integer getApplicationDuration() {
    return applicationDuration;
  }

  public void setApplicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
  }

  public ProdOfferPriceAlterationType unitOfMeasure(QuantityType unitOfMeasure) {
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

  public ProdOfferPriceAlterationType discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

   /**
   * Identification for the type of discount to be applied
   * @return discountType
  **/
  @ApiModelProperty(value = "Identification for the type of discount to be applied")
  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public ProdOfferPriceAlterationType price(MoneyType price) {
    this.price = price;
    return this;
  }

   /**
   * Value of the alteration for the case of discount. This will refer to a monetary value or a percentage
   * @return price
  **/
  @ApiModelProperty(value = "Value of the alteration for the case of discount. This will refer to a monetary value or a percentage")
  public MoneyType getPrice() {
    return price;
  }

  public void setPrice(MoneyType price) {
    this.price = price;
  }

  public ProdOfferPriceAlterationType additionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProdOfferPriceAlterationType addAdditionalDataItem(MoneyType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any additional metadata that the application may supply (implementation and application specific
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that the application may supply (implementation and application specific")
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
    ProdOfferPriceAlterationType prodOfferPriceAlterationType = (ProdOfferPriceAlterationType) o;
    return Objects.equals(this.id, prodOfferPriceAlterationType.id) &&
        Objects.equals(this.name, prodOfferPriceAlterationType.name) &&
        Objects.equals(this.description, prodOfferPriceAlterationType.description) &&
        Objects.equals(this.priceCondition, prodOfferPriceAlterationType.priceCondition) &&
        Objects.equals(this.priceType, prodOfferPriceAlterationType.priceType) &&
        Objects.equals(this.recurringChargePeriod, prodOfferPriceAlterationType.recurringChargePeriod) &&
        Objects.equals(this.applicationDuration, prodOfferPriceAlterationType.applicationDuration) &&
        Objects.equals(this.unitOfMeasure, prodOfferPriceAlterationType.unitOfMeasure) &&
        Objects.equals(this.discountType, prodOfferPriceAlterationType.discountType) &&
        Objects.equals(this.price, prodOfferPriceAlterationType.price) &&
        Objects.equals(this.additionalData, prodOfferPriceAlterationType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, priceCondition, priceType, recurringChargePeriod, applicationDuration, unitOfMeasure, discountType, price, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProdOfferPriceAlterationType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    priceCondition: ").append(toIndentedString(priceCondition)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    applicationDuration: ").append(toIndentedString(applicationDuration)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

