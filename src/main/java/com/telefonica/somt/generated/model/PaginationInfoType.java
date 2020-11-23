package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * PaginationInfoType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class PaginationInfoType  implements Serializable {
  @JsonProperty("totalPages")
  private Integer totalPages = null;

  @JsonProperty("totalResults")
  private Integer totalResults = null;

  @JsonProperty("last")
  private Boolean last = null;

  @JsonProperty("first")
  private Boolean first = null;

  @JsonProperty("itemsPerPage")
  private Integer itemsPerPage = null;

  public PaginationInfoType totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

   /**
   * Número total de paginas
   * @return totalPages
  **/
  @ApiModelProperty(required = true, value = "Número total de paginas")
  @NotNull
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public PaginationInfoType totalResults(Integer totalResults) {
    this.totalResults = totalResults;
    return this;
  }

   /**
   * Número total de registros en Base de datos (items)
   * @return totalResults
  **/
  @ApiModelProperty(required = true, value = "Número total de registros en Base de datos (items)")
  @NotNull
  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public PaginationInfoType last(Boolean last) {
    this.last = last;
    return this;
  }

   /**
   * Indica si estas en la ultima pagina
   * @return last
  **/
  @ApiModelProperty(required = true, value = "Indica si estas en la ultima pagina")
  @NotNull
  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public PaginationInfoType first(Boolean first) {
    this.first = first;
    return this;
  }

   /**
   * Indica si estas en la primera pagina
   * @return first
  **/
  @ApiModelProperty(required = true, value = "Indica si estas en la primera pagina")
  @NotNull
  public Boolean getFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public PaginationInfoType itemsPerPage(Integer itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
    return this;
  }

   /**
   * Número de items por pagina
   * @return itemsPerPage
  **/
  @ApiModelProperty(required = true, value = "Número de items por pagina")
  @NotNull
  public Integer getItemsPerPage() {
    return itemsPerPage;
  }

  public void setItemsPerPage(Integer itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginationInfoType paginationInfoType = (PaginationInfoType) o;
    return Objects.equals(this.totalPages, paginationInfoType.totalPages) &&
        Objects.equals(this.totalResults, paginationInfoType.totalResults) &&
        Objects.equals(this.last, paginationInfoType.last) &&
        Objects.equals(this.first, paginationInfoType.first) &&
        Objects.equals(this.itemsPerPage, paginationInfoType.itemsPerPage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalPages, totalResults, last, first, itemsPerPage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginationInfoType {\n");
    
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    totalResults: ").append(toIndentedString(totalResults)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    itemsPerPage: ").append(toIndentedString(itemsPerPage)).append("\n");
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

