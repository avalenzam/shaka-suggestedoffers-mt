package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.QuantityType;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ProductSpecCharacteristicValueType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProductSpecCharacteristicValueType  implements Serializable {
  /**
   * Indicates the kind of value that is being defined for the characteristic
   */
  public enum ValueTypeEnum {
    INTEGERWRAPPER("integerWrapper"),
    
    DECIMALWRAPPER("decimalWrapper"),
    
    STRINGWRAPPER("stringWrapper"),
    
    BOOLEANWRAPPER("booleanWrapper"),
    
    NUMERICWRAPPER("numericWrapper"),
    
    TEXTWRAPPER("textWrapper"),
    
    OBJECTWRAPPER("objectWrapper");

    private String value;

    ValueTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValueTypeEnum fromValue(String text) {
      for (ValueTypeEnum b : ValueTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  @JsonProperty("unitOfMeasure")
  private QuantityType unitOfMeasure = null;

  @JsonProperty("default")
  private Boolean _default = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("valueFrom")
  private String valueFrom = null;

  @JsonProperty("valueTo")
  private String valueTo = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("additionalData")
  private List<MoneyType> additionalData = new ArrayList<MoneyType>();

  public ProductSpecCharacteristicValueType valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

   /**
   * Indicates the kind of value that is being defined for the characteristic
   * @return valueType
  **/
  @ApiModelProperty(value = "Indicates the kind of value that is being defined for the characteristic")
  public ValueTypeEnum getValueType() {
    return valueType;
  }

  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }

  public ProductSpecCharacteristicValueType unitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * Indication of the criteria to be used for the charging (e.g.: 1 call, 60 minutes, 50 GB). Notice that in the TMForum API version 14.5 this parameter is defined as a string, not meeting SID definition
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Indication of the criteria to be used for the charging (e.g.: 1 call, 60 minutes, 50 GB). Notice that in the TMForum API version 14.5 this parameter is defined as a string, not meeting SID definition")
  public QuantityType getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public ProductSpecCharacteristicValueType _default(Boolean _default) {
    this._default = _default;
    return this;
  }

   /**
   * Indicates if the value is the defaulted one for the characteristic (true means it is the default value)
   * @return _default
  **/
  @ApiModelProperty(value = "Indicates if the value is the defaulted one for the characteristic (true means it is the default value)")
  public Boolean getDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public ProductSpecCharacteristicValueType value(String value) {
    this.value = value;
    return this;
  }

   /**
   * The value that the characteristic can take. For non-defaulted range values this will be one of the possible values in the range
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value that the characteristic can take. For non-defaulted range values this will be one of the possible values in the range")
  @NotNull
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public ProductSpecCharacteristicValueType valueFrom(String valueFrom) {
    this.valueFrom = valueFrom;
    return this;
  }

   /**
   * The lower range value that the characteristic can take on. Only required for ranged values
   * @return valueFrom
  **/
  @ApiModelProperty(value = "The lower range value that the characteristic can take on. Only required for ranged values")
  public String getValueFrom() {
    return valueFrom;
  }

  public void setValueFrom(String valueFrom) {
    this.valueFrom = valueFrom;
  }

  public ProductSpecCharacteristicValueType valueTo(String valueTo) {
    this.valueTo = valueTo;
    return this;
  }

   /**
   * The upper range value that the characteristic can take on. Only required for ranged values
   * @return valueTo
  **/
  @ApiModelProperty(value = "The upper range value that the characteristic can take on. Only required for ranged values")
  public String getValueTo() {
    return valueTo;
  }

  public void setValueTo(String valueTo) {
    this.valueTo = valueTo;
  }

  public ProductSpecCharacteristicValueType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The period of time for which a characteristic is applicable
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which a characteristic is applicable")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public ProductSpecCharacteristicValueType additionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProductSpecCharacteristicValueType addAdditionalDataItem(MoneyType additionalDataItem) {
    this.additionalData.add(additionalDataItem);
    return this;
  }

   /**
   * Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines")
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
    ProductSpecCharacteristicValueType productSpecCharacteristicValueType = (ProductSpecCharacteristicValueType) o;
    return Objects.equals(this.valueType, productSpecCharacteristicValueType.valueType) &&
        Objects.equals(this.unitOfMeasure, productSpecCharacteristicValueType.unitOfMeasure) &&
        Objects.equals(this._default, productSpecCharacteristicValueType._default) &&
        Objects.equals(this.value, productSpecCharacteristicValueType.value) &&
        Objects.equals(this.valueFrom, productSpecCharacteristicValueType.valueFrom) &&
        Objects.equals(this.valueTo, productSpecCharacteristicValueType.valueTo) &&
        Objects.equals(this.validFor, productSpecCharacteristicValueType.validFor) &&
        Objects.equals(this.additionalData, productSpecCharacteristicValueType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueType, unitOfMeasure, _default, value, valueFrom, valueTo, validFor, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecCharacteristicValueType {\n");
    
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
    sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

