package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ObjectCharacteristicValueType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = MobileQuota.class, name = "MobileQuota"),
  @JsonSubTypes.Type(value = InternetConnection.class, name = "InternetConnection"),
  @JsonSubTypes.Type(value = TvPackages.class, name = "TvPackages"),
})

public class ObjectCharacteristicValueType  implements Serializable {
  /**
   * type of characteristic information element, defines the format structure of the value information element (string or specific object type)
   */
  public enum TypeEnum {
    MOBILEQUOTA("MobileQuota"),
    
    INTERNETCONNECTION("InternetConnection"),
    
    TVPACKAGES("TvPackages");

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

  @JsonProperty("@type")
  private TypeEnum type = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  public ObjectCharacteristicValueType type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * type of characteristic information element, defines the format structure of the value information element (string or specific object type)
   * @return type
  **/
  @ApiModelProperty(value = "type of characteristic information element, defines the format structure of the value information element (string or specific object type)")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ObjectCharacteristicValueType schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

   /**
   * This field provides a link to the schema describing the resource model for the Object defining the characteristics for a TV product
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "This field provides a link to the schema describing the resource model for the Object defining the characteristics for a TV product")
  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectCharacteristicValueType objectCharacteristicValueType = (ObjectCharacteristicValueType) o;
    return Objects.equals(this.type, objectCharacteristicValueType.type) &&
        Objects.equals(this.schemaLocation, objectCharacteristicValueType.schemaLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, schemaLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectCharacteristicValueType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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

