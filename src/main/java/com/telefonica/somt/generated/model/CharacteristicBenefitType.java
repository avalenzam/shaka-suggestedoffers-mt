package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CharacteristicBenefitType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class CharacteristicBenefitType  implements Serializable {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("value")
  private String value = null;

  public CharacteristicBenefitType key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Es la clave de la caracteristica
   * @return key
  **/
  @ApiModelProperty(value = "Es la clave de la caracteristica")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public CharacteristicBenefitType value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Es el valor de clave
   * @return value
  **/
  @ApiModelProperty(value = "Es el valor de clave")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacteristicBenefitType characteristicBenefitType = (CharacteristicBenefitType) o;
    return Objects.equals(this.key, characteristicBenefitType.key) &&
        Objects.equals(this.value, characteristicBenefitType.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacteristicBenefitType {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

