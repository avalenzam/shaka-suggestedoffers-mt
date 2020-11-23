package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ComposingOfferingType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ComposingOfferingType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("planName")
  private String planName = null;

  @JsonProperty("displayName")
  private String displayName = null;

  @JsonProperty("image")
  private String image = null;

  @JsonProperty("minCardinality")
  private Integer minCardinality = null;

  @JsonProperty("maxCardinality")
  private Integer maxCardinality = null;

  @JsonProperty("defaultCardinality")
  private Integer defaultCardinality = null;

  public ComposingOfferingType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Product Offering Identifier. This is the identifier that can be used to retrieve specific information for that offering
   * @return id
  **/
  @ApiModelProperty(value = "Product Offering Identifier. This is the identifier that can be used to retrieve specific information for that offering")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ComposingOfferingType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the detailed information for the referred product offering
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the detailed information for the referred product offering")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ComposingOfferingType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable offering name
   * @return name
  **/
  @ApiModelProperty(value = "A human readable offering name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ComposingOfferingType planName(String planName) {
    this.planName = planName;
    return this;
  }

   /**
   * Nombre del plan
   * @return planName
  **/
  @ApiModelProperty(value = "Nombre del plan")
  public String getPlanName() {
    return planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public ComposingOfferingType displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Nombre del plan que se mostrará según el LOB
   * @return displayName
  **/
  @ApiModelProperty(value = "Nombre del plan que se mostrará según el LOB")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ComposingOfferingType image(String image) {
    this.image = image;
    return this;
  }

   /**
   * Es la URL de la imagen
   * @return image
  **/
  @ApiModelProperty(value = "Es la URL de la imagen")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public ComposingOfferingType minCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
    return this;
  }

   /**
   * Indicates the minimum number of entities of this offering that can be included within the parent offering. If not included then value 0 will be considered
   * @return minCardinality
  **/
  @ApiModelProperty(value = "Indicates the minimum number of entities of this offering that can be included within the parent offering. If not included then value 0 will be considered")
  public Integer getMinCardinality() {
    return minCardinality;
  }

  public void setMinCardinality(Integer minCardinality) {
    this.minCardinality = minCardinality;
  }

  public ComposingOfferingType maxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
    return this;
  }

   /**
   * Indicates the maximum number of entities of this offering that can be included within the parent offering. If not included then no limit will be considered
   * @return maxCardinality
  **/
  @ApiModelProperty(value = "Indicates the maximum number of entities of this offering that can be included within the parent offering. If not included then no limit will be considered")
  public Integer getMaxCardinality() {
    return maxCardinality;
  }

  public void setMaxCardinality(Integer maxCardinality) {
    this.maxCardinality = maxCardinality;
  }

  public ComposingOfferingType defaultCardinality(Integer defaultCardinality) {
    this.defaultCardinality = defaultCardinality;
    return this;
  }

   /**
   * Indicates the default number of entities of this offering that are included within the parent offering
   * @return defaultCardinality
  **/
  @ApiModelProperty(value = "Indicates the default number of entities of this offering that are included within the parent offering")
  public Integer getDefaultCardinality() {
    return defaultCardinality;
  }

  public void setDefaultCardinality(Integer defaultCardinality) {
    this.defaultCardinality = defaultCardinality;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ComposingOfferingType composingOfferingType = (ComposingOfferingType) o;
    return Objects.equals(this.id, composingOfferingType.id) &&
        Objects.equals(this.href, composingOfferingType.href) &&
        Objects.equals(this.name, composingOfferingType.name) &&
        Objects.equals(this.planName, composingOfferingType.planName) &&
        Objects.equals(this.displayName, composingOfferingType.displayName) &&
        Objects.equals(this.image, composingOfferingType.image) &&
        Objects.equals(this.minCardinality, composingOfferingType.minCardinality) &&
        Objects.equals(this.maxCardinality, composingOfferingType.maxCardinality) &&
        Objects.equals(this.defaultCardinality, composingOfferingType.defaultCardinality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, planName, displayName, image, minCardinality, maxCardinality, defaultCardinality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ComposingOfferingType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    planName: ").append(toIndentedString(planName)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
    sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
    sb.append("    defaultCardinality: ").append(toIndentedString(defaultCardinality)).append("\n");
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

