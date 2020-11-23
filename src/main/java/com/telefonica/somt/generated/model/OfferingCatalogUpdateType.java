package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.OfferingType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * OfferingCatalogUpdateType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class OfferingCatalogUpdateType  implements Serializable {
  @JsonProperty("isIncremental")
  private Boolean isIncremental = null;

  @JsonProperty("offerings")
  private List<OfferingType> offerings = new ArrayList<OfferingType>();

  public OfferingCatalogUpdateType isIncremental(Boolean isIncremental) {
    this.isIncremental = isIncremental;
    return this;
  }

   /**
   * Indicates whether the provided list of product offerings is Incremental (true) or Total (false). Incremental means that the list of product offerings in the request message includes the modification of currently stored offerings in the catalog or new offerings to be added. Total means that the list of offerings in the request message provides the new whole list of offerings that substitutes completely the existing catalog
   * @return isIncremental
  **/
  @ApiModelProperty(required = true, value = "Indicates whether the provided list of product offerings is Incremental (true) or Total (false). Incremental means that the list of product offerings in the request message includes the modification of currently stored offerings in the catalog or new offerings to be added. Total means that the list of offerings in the request message provides the new whole list of offerings that substitutes completely the existing catalog")
  @NotNull
  public Boolean getIsIncremental() {
    return isIncremental;
  }

  public void setIsIncremental(Boolean isIncremental) {
    this.isIncremental = isIncremental;
  }

  public OfferingCatalogUpdateType offerings(List<OfferingType> offerings) {
    this.offerings = offerings;
    return this;
  }

  public OfferingCatalogUpdateType addOfferingsItem(OfferingType offeringsItem) {
    this.offerings.add(offeringsItem);
    return this;
  }

   /**
   * List of offerings (single or bundled) offered by the server
   * @return offerings
  **/
  @ApiModelProperty(required = true, value = "List of offerings (single or bundled) offered by the server")
  @NotNull
  public List<OfferingType> getOfferings() {
    return offerings;
  }

  public void setOfferings(List<OfferingType> offerings) {
    this.offerings = offerings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferingCatalogUpdateType offeringCatalogUpdateType = (OfferingCatalogUpdateType) o;
    return Objects.equals(this.isIncremental, offeringCatalogUpdateType.isIncremental) &&
        Objects.equals(this.offerings, offeringCatalogUpdateType.offerings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isIncremental, offerings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferingCatalogUpdateType {\n");
    
    sb.append("    isIncremental: ").append(toIndentedString(isIncremental)).append("\n");
    sb.append("    offerings: ").append(toIndentedString(offerings)).append("\n");
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

