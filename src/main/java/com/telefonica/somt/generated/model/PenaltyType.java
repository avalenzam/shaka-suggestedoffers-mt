package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.MoneyType;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * PenaltyType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class PenaltyType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("condition")
  private String condition = null;

  @JsonProperty("penaltyValue")
  private MoneyType penaltyValue = null;

  @JsonProperty("additionalData")
  private List<MoneyType> additionalData = new ArrayList<MoneyType>();

  public PenaltyType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier for the penalty model
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier for the penalty model")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PenaltyType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable penalty model name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable penalty model name")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PenaltyType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * A human readable penalty short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable penalty short description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PenaltyType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The validity for the penalty model in the catalog. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the penalty model in the catalog. If not included, the current date is used as starting date and no ending date is defined")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public PenaltyType condition(String condition) {
    this.condition = condition;
    return this;
  }

   /**
   * Text describing the condition that triggers the penalty application
   * @return condition
  **/
  @ApiModelProperty(required = true, value = "Text describing the condition that triggers the penalty application")
  @NotNull
  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public PenaltyType penaltyValue(MoneyType penaltyValue) {
    this.penaltyValue = penaltyValue;
    return this;
  }

   /**
   * Monetary value of the penalty
   * @return penaltyValue
  **/
  @ApiModelProperty(required = true, value = "Monetary value of the penalty")
  @NotNull
  public MoneyType getPenaltyValue() {
    return penaltyValue;
  }

  public void setPenaltyValue(MoneyType penaltyValue) {
    this.penaltyValue = penaltyValue;
  }

  public PenaltyType additionalData(List<MoneyType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public PenaltyType addAdditionalDataItem(MoneyType additionalDataItem) {
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
    PenaltyType penaltyType = (PenaltyType) o;
    return Objects.equals(this.id, penaltyType.id) &&
        Objects.equals(this.name, penaltyType.name) &&
        Objects.equals(this.description, penaltyType.description) &&
        Objects.equals(this.validFor, penaltyType.validFor) &&
        Objects.equals(this.condition, penaltyType.condition) &&
        Objects.equals(this.penaltyValue, penaltyType.penaltyValue) &&
        Objects.equals(this.additionalData, penaltyType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, validFor, condition, penaltyValue, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PenaltyType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    penaltyValue: ").append(toIndentedString(penaltyValue)).append("\n");
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

