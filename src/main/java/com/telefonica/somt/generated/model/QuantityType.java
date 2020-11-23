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
 * Representation of a quantity of something. I can also be used to represent a quantity range
 */
@ApiModel(description = "Representation of a quantity of something. I can also be used to represent a quantity range")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class QuantityType  implements Serializable {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("maximum")
  private BigDecimal maximum = null;

  @JsonProperty("minimum")
  private BigDecimal minimum = null;

  @JsonProperty("units")
  private String units = null;

  public QuantityType amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Measured amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Measured amount")
  @NotNull
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public QuantityType maximum(BigDecimal maximum) {
    this.maximum = maximum;
    return this;
  }

   /**
   * Maximum amount allowed
   * @return maximum
  **/
  @ApiModelProperty(value = "Maximum amount allowed")
  public BigDecimal getMaximum() {
    return maximum;
  }

  public void setMaximum(BigDecimal maximum) {
    this.maximum = maximum;
  }

  public QuantityType minimum(BigDecimal minimum) {
    this.minimum = minimum;
    return this;
  }

   /**
   * Minimum amount allowed
   * @return minimum
  **/
  @ApiModelProperty(value = "Minimum amount allowed")
  public BigDecimal getMinimum() {
    return minimum;
  }

  public void setMinimum(BigDecimal minimum) {
    this.minimum = minimum;
  }

  public QuantityType units(String units) {
    this.units = units;
    return this;
  }

   /**
   * Units the quantity is measured in
   * @return units
  **/
  @ApiModelProperty(required = true, value = "Units the quantity is measured in")
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
    QuantityType quantityType = (QuantityType) o;
    return Objects.equals(this.amount, quantityType.amount) &&
        Objects.equals(this.maximum, quantityType.maximum) &&
        Objects.equals(this.minimum, quantityType.minimum) &&
        Objects.equals(this.units, quantityType.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, maximum, minimum, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuantityType {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
    sb.append("    minimum: ").append(toIndentedString(minimum)).append("\n");
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

