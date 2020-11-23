package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CategoryRequestType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class CategoryRequestType  implements Serializable {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("lastUpdate")
  private DateTime lastUpdate = null;

  @JsonProperty("lifecycleStatus")
  private String lifecycleStatus = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("isRoot")
  private Boolean isRoot = null;

  @JsonProperty("parentId")
  private String parentId = null;

  @JsonProperty("parentHref")
  private String parentHref = null;

  public CategoryRequestType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Category name
   * @return name
  **/
  @ApiModelProperty(value = "Category name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryRequestType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Category description
   * @return description
  **/
  @ApiModelProperty(value = "Category description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CategoryRequestType lastUpdate(DateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

   /**
   * Date when the last update was performed
   * @return lastUpdate
  **/
  @ApiModelProperty(value = "Date when the last update was performed")
  public DateTime getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(DateTime lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public CategoryRequestType lifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
    return this;
  }

   /**
   * Category current status
   * @return lifecycleStatus
  **/
  @ApiModelProperty(value = "Category current status")
  public String getLifecycleStatus() {
    return lifecycleStatus;
  }

  public void setLifecycleStatus(String lifecycleStatus) {
    this.lifecycleStatus = lifecycleStatus;
  }

  public CategoryRequestType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Period of time the category is valid
   * @return validFor
  **/
  @ApiModelProperty(value = "Period of time the category is valid")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public CategoryRequestType isRoot(Boolean isRoot) {
    this.isRoot = isRoot;
    return this;
  }

   /**
   * True if the category is the root of the category tree. False otherwise
   * @return isRoot
  **/
  @ApiModelProperty(value = "True if the category is the root of the category tree. False otherwise")
  public Boolean getIsRoot() {
    return isRoot;
  }

  public void setIsRoot(Boolean isRoot) {
    this.isRoot = isRoot;
  }

  public CategoryRequestType parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

   /**
   * Id of the parent category
   * @return parentId
  **/
  @ApiModelProperty(value = "Id of the parent category")
  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public CategoryRequestType parentHref(String parentHref) {
    this.parentHref = parentHref;
    return this;
  }

   /**
   * href of the parent category
   * @return parentHref
  **/
  @ApiModelProperty(value = "href of the parent category")
  public String getParentHref() {
    return parentHref;
  }

  public void setParentHref(String parentHref) {
    this.parentHref = parentHref;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRequestType categoryRequestType = (CategoryRequestType) o;
    return Objects.equals(this.name, categoryRequestType.name) &&
        Objects.equals(this.description, categoryRequestType.description) &&
        Objects.equals(this.lastUpdate, categoryRequestType.lastUpdate) &&
        Objects.equals(this.lifecycleStatus, categoryRequestType.lifecycleStatus) &&
        Objects.equals(this.validFor, categoryRequestType.validFor) &&
        Objects.equals(this.isRoot, categoryRequestType.isRoot) &&
        Objects.equals(this.parentId, categoryRequestType.parentId) &&
        Objects.equals(this.parentHref, categoryRequestType.parentHref);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, lastUpdate, lifecycleStatus, validFor, isRoot, parentId, parentHref);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRequestType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("    lifecycleStatus: ").append(toIndentedString(lifecycleStatus)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    parentHref: ").append(toIndentedString(parentHref)).append("\n");
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

