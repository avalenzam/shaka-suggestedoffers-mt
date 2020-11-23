package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.CategoryTreeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CategoryTreeType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class CategoryTreeType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("subcategories")
  private CategoryTreeType subcategories = null;

  public CategoryTreeType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An identifier for the category
   * @return id
  **/
  @ApiModelProperty(required = true, value = "An identifier for the category")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategoryTreeType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the category detailed information
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the category detailed information")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CategoryTreeType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable category name
   * @return name
  **/
  @ApiModelProperty(value = "A human readable category name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CategoryTreeType subcategories(CategoryTreeType subcategories) {
    this.subcategories = subcategories;
    return this;
  }

   /**
   * 
   * @return subcategories
  **/
  @ApiModelProperty(value = "")
  public CategoryTreeType getSubcategories() {
    return subcategories;
  }

  public void setSubcategories(CategoryTreeType subcategories) {
    this.subcategories = subcategories;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryTreeType categoryTreeType = (CategoryTreeType) o;
    return Objects.equals(this.id, categoryTreeType.id) &&
        Objects.equals(this.href, categoryTreeType.href) &&
        Objects.equals(this.name, categoryTreeType.name) &&
        Objects.equals(this.subcategories, categoryTreeType.subcategories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, subcategories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryTreeType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    subcategories: ").append(toIndentedString(subcategories)).append("\n");
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

