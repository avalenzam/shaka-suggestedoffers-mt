package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * Key - value pair typically used for extensions or for adding extra data which structure is previously unknown
 */
@ApiModel(description = "Key - value pair typically used for extensions or for adding extra data which structure is previously unknown")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class KeyValueType  implements Serializable {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("value")
  private String value = null;

  public KeyValueType key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Name of the field
   * @return key
  **/
  @ApiModelProperty(required = true, value = "Name of the field")
  @NotNull
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public KeyValueType value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Value of the field
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Value of the field")
  @NotNull
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
    KeyValueType keyValueType = (KeyValueType) o;
    return Objects.equals(this.key, keyValueType.key) &&
        Objects.equals(this.value, keyValueType.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyValueType {\n");
    
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

