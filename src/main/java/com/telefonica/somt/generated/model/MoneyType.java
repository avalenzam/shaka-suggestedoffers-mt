package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * Representation of a monetary value
 */
@ApiModel(description = "Representation of a monetary value")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class MoneyType  implements Serializable {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("units")
  private String units = null;

  public MoneyType amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount of money. Notice that in the TMForum API version 14.5 this parameter is named taxIncludedAmount and is not meeting SID definition
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Amount of money. Notice that in the TMForum API version 14.5 this parameter is named taxIncludedAmount and is not meeting SID definition")
  @NotNull
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public MoneyType units(String units) {
    this.units = units;
    return this;
  }

   /**
   * Definition of the currency used. It is implementation specific to define how currencies are defined, it could be defined using ISO 4217. Notice that in the TMForum API version 14.5 this parameter is named currencyCode and is not meeting SID definition
   * @return units
  **/
  @ApiModelProperty(required = true, value = "Definition of the currency used. It is implementation specific to define how currencies are defined, it could be defined using ISO 4217. Notice that in the TMForum API version 14.5 this parameter is named currencyCode and is not meeting SID definition")
  @NotNull
  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MoneyType moneyType = (MoneyType) o;
    return Objects.equals(this.amount, moneyType.amount) &&
        Objects.equals(this.units, moneyType.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyType {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
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

