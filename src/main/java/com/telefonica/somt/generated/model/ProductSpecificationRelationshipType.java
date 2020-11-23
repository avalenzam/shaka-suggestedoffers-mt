package com.telefonica.somt.generated.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
/**
 * ProductSpecificationRelationshipType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ProductSpecificationRelationshipType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  public ProductSpecificationRelationshipType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identifier for the product that is related to the referenced one
   * @return id
  **/
  @ApiModelProperty(value = "Identifier for the product that is related to the referenced one")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductSpecificationRelationshipType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * URI providing the resource address for the other product that is related to the referenced one
   * @return href
  **/
  @ApiModelProperty(required = true, value = "URI providing the resource address for the other product that is related to the referenced one")
  @NotNull
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductSpecificationRelationshipType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * A categorization of the relationship (e.g.: migration, substitution, dependency, exclusivity)
   * @return type
  **/
  @ApiModelProperty(value = "A categorization of the relationship (e.g.: migration, substitution, dependency, exclusivity)")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ProductSpecificationRelationshipType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

   /**
   * The period for which the relationship is applicable
   * @return validFor
  **/
  @ApiModelProperty(value = "The period for which the relationship is applicable")
  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecificationRelationshipType productSpecificationRelationshipType = (ProductSpecificationRelationshipType) o;
    return Objects.equals(this.id, productSpecificationRelationshipType.id) &&
        Objects.equals(this.href, productSpecificationRelationshipType.href) &&
        Objects.equals(this.type, productSpecificationRelationshipType.type) &&
        Objects.equals(this.validFor, productSpecificationRelationshipType.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, type, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecificationRelationshipType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

