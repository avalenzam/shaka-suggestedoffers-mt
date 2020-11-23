package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * Information for broadband/internet type products, providing details on connections characteristics
 */
@ApiModel(description = "Information for broadband/internet type products, providing details on connections characteristics")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ConnectionType  implements Serializable {
  /**
   * Data quota max number of bytes allowed. -1 means unlimited
   */
  public enum TypeEnum {
    FIBER("fiber"),
    
    DSL("dsl"),
    
    UNKNOWN("unknown");

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

  @JsonProperty("ulDataRate")
  private Integer ulDataRate = null;

  @JsonProperty("dlDataRate")
  private Integer dlDataRate = null;

  /**
   * Code of the unit used to specify the data rate. If not included is MBs (default value)
   */
  public enum UnitEnum {
    BYTES("bytes"),
    
    KB("KB"),
    
    MB("MB"),
    
    GB("GB");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("unit")
  private UnitEnum unit = UnitEnum.MB;

  public ConnectionType type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Data quota max number of bytes allowed. -1 means unlimited
   * @return type
  **/
  @ApiModelProperty(value = "Data quota max number of bytes allowed. -1 means unlimited")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ConnectionType ulDataRate(Integer ulDataRate) {
    this.ulDataRate = ulDataRate;
    return this;
  }

   /**
   * Uplink speed in megabits per second
   * @return ulDataRate
  **/
  @ApiModelProperty(value = "Uplink speed in megabits per second")
  public Integer getUlDataRate() {
    return ulDataRate;
  }

  public void setUlDataRate(Integer ulDataRate) {
    this.ulDataRate = ulDataRate;
  }

  public ConnectionType dlDataRate(Integer dlDataRate) {
    this.dlDataRate = dlDataRate;
    return this;
  }

   /**
   * Downlink speed in megabits per second
   * @return dlDataRate
  **/
  @ApiModelProperty(value = "Downlink speed in megabits per second")
  public Integer getDlDataRate() {
    return dlDataRate;
  }

  public void setDlDataRate(Integer dlDataRate) {
    this.dlDataRate = dlDataRate;
  }

  public ConnectionType unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Code of the unit used to specify the data rate. If not included is MBs (default value)
   * @return unit
  **/
  @ApiModelProperty(value = "Code of the unit used to specify the data rate. If not included is MBs (default value)")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConnectionType connectionType = (ConnectionType) o;
    return Objects.equals(this.type, connectionType.type) &&
        Objects.equals(this.ulDataRate, connectionType.ulDataRate) &&
        Objects.equals(this.dlDataRate, connectionType.dlDataRate) &&
        Objects.equals(this.unit, connectionType.unit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, ulDataRate, dlDataRate, unit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConnectionType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    ulDataRate: ").append(toIndentedString(ulDataRate)).append("\n");
    sb.append("    dlDataRate: ").append(toIndentedString(dlDataRate)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
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

