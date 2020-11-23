package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.TimePeriodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * Reference to an external entity that can be tipically queried with another API such as a customer account, a ticket, etc.
 */
@ApiModel(description = "Reference to an external entity that can be tipically queried with another API such as a customer account, a ticket, etc.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class EntityRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("entityType")
  private String entityType = null;

  @JsonProperty("description")
  private String description = null;

  public EntityRefType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of the entity
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the entity")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EntityRefType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * URI where to query or perform actions on the entity
   * @return href
  **/
  @ApiModelProperty(required = true, value = "URI where to query or perform actions on the entity")
  @NotNull
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public EntityRefType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Screen name of the entity
   * @return name
  **/
  @ApiModelProperty(value = "Screen name of the entity")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EntityRefType role(String role) {
    this.role = role;
    return this;
  }

   /**
   * Role on the entity
   * @return role
  **/
  @ApiModelProperty(value = "Role on the entity")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public EntityRefType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * Duration of the relationship with the entity
   * @return validFor
  **/
  @ApiModelProperty(value = "Duration of the relationship with the entity")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public EntityRefType entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Type of entity (e.g.: account, customer, ticket, etc.)
   * @return entityType
  **/
  @ApiModelProperty(value = "Type of entity (e.g.: account, customer, ticket, etc.)")
  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public EntityRefType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the entity
   * @return description
  **/
  @ApiModelProperty(value = "Description of the entity")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityRefType entityRefType = (EntityRefType) o;
    return Objects.equals(this.id, entityRefType.id) &&
        Objects.equals(this.href, entityRefType.href) &&
        Objects.equals(this.name, entityRefType.name) &&
        Objects.equals(this.role, entityRefType.role) &&
        Objects.equals(this.validFor, entityRefType.validFor) &&
        Objects.equals(this.entityType, entityRefType.entityType) &&
        Objects.equals(this.description, entityRefType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, validFor, entityType, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

