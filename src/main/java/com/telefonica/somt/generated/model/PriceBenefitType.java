package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.MoneyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * PriceBenefitType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class PriceBenefitType  implements Serializable {
  @JsonProperty("priceType")
  private String priceType = null;

  @JsonProperty("recurringChargePeriod")
  private String recurringChargePeriod = null;

  @JsonProperty("price")
  private MoneyType price = null;

  @JsonProperty("priceWithTax")
  private MoneyType priceWithTax = null;

  public PriceBenefitType priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

   /**
   * Identificación para el tipo de componente de precio individual
   * @return priceType
  **/
  @ApiModelProperty(value = "Identificación para el tipo de componente de precio individual")
  public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public PriceBenefitType recurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

   /**
   * Identificación de la periodicidad de cobro recurrente  en el caso de modelos de precios recurrentes (por ejemplo, mensual, anual)
   * @return recurringChargePeriod
  **/
  @ApiModelProperty(value = "Identificación de la periodicidad de cobro recurrente  en el caso de modelos de precios recurrentes (por ejemplo, mensual, anual)")
  public String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public PriceBenefitType price(MoneyType price) {
    this.price = price;
    return this;
  }

   /**
   * Es el precio del beneficio
   * @return price
  **/
  @ApiModelProperty(value = "Es el precio del beneficio")
  public MoneyType getPrice() {
    return price;
  }

  public void setPrice(MoneyType price) {
    this.price = price;
  }

  public PriceBenefitType priceWithTax(MoneyType priceWithTax) {
    this.priceWithTax = priceWithTax;
    return this;
  }

   /**
   * Es el precio del beneficio con impuesto
   * @return priceWithTax
  **/
  @ApiModelProperty(value = "Es el precio del beneficio con impuesto")
  public MoneyType getPriceWithTax() {
    return priceWithTax;
  }

  public void setPriceWithTax(MoneyType priceWithTax) {
    this.priceWithTax = priceWithTax;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceBenefitType priceBenefitType = (PriceBenefitType) o;
    return Objects.equals(this.priceType, priceBenefitType.priceType) &&
        Objects.equals(this.recurringChargePeriod, priceBenefitType.recurringChargePeriod) &&
        Objects.equals(this.price, priceBenefitType.price) &&
        Objects.equals(this.priceWithTax, priceBenefitType.priceWithTax);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priceType, recurringChargePeriod, price, priceWithTax);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceBenefitType {\n");
    
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceWithTax: ").append(toIndentedString(priceWithTax)).append("\n");
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

