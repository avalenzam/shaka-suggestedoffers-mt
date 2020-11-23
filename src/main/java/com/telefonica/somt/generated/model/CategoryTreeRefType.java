package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.CategoryRefType;
import com.telefonica.somt.generated.model.CategoryTreeRefType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * CategoryTreeRefType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class CategoryTreeRefType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("children")
  private List<CategoryTreeRefType> children = new ArrayList<CategoryTreeRefType>();

  public CategoryTreeRefType id(String id) {
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

  public CategoryTreeRefType href(String href) {
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

  public CategoryTreeRefType name(String name) {
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

  public CategoryTreeRefType children(List<CategoryTreeRefType> children) {
    this.children = children;
    return this;
  }

  public CategoryTreeRefType addChildrenItem(CategoryTreeRefType childrenItem) {
    this.children.add(childrenItem);
    return this;
  }

   /**
   * Children of the current node
   * @return children
  **/
  @ApiModelProperty(value = "Children of the current node")
  public List<CategoryTreeRefType> getChildren() {
    return children;
  }

  public void setChildren(List<CategoryTreeRefType> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryTreeRefType categoryTreeRefType = (CategoryTreeRefType) o;
    return Objects.equals(this.id, categoryTreeRefType.id) &&
        Objects.equals(this.href, categoryTreeRefType.href) &&
        Objects.equals(this.name, categoryTreeRefType.name) &&
        Objects.equals(this.children, categoryTreeRefType.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryTreeRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

