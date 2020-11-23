package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CategoryRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class CategoryRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  public CategoryRefType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Unique identifier of the category
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the category")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CategoryRefType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * URI where to query or perform actions on the category
   * @return href
  **/
  @ApiModelProperty(value = "URI where to query or perform actions on the category")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public CategoryRefType name(String name) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryRefType categoryRefType = (CategoryRefType) o;
    return Objects.equals(this.id, categoryRefType.id) &&
        Objects.equals(this.href, categoryRefType.href) &&
        Objects.equals(this.name, categoryRefType.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

