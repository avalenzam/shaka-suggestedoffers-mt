package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.somt.generated.model.ObjectCharacteristicValueType;
import com.telefonica.somt.generated.model.PackageType;
import com.telefonica.somt.generated.model.TvPackagesCharacteristicType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * TvPackages
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class TvPackages extends ObjectCharacteristicValueType implements Serializable {
  @JsonProperty("packages")
  private List<PackageType> packages = new ArrayList<PackageType>();

  public TvPackages packages(List<PackageType> packages) {
    this.packages = packages;
    return this;
  }

  public TvPackages addPackagesItem(PackageType packagesItem) {
    this.packages.add(packagesItem);
    return this;
  }

   /**
   * List of subscribed available TV packages
   * @return packages
  **/
  @ApiModelProperty(required = true, value = "List of subscribed available TV packages")
  @NotNull
  public List<PackageType> getPackages() {
    return packages;
  }

  public void setPackages(List<PackageType> packages) {
    this.packages = packages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TvPackages tvPackages = (TvPackages) o;
    return Objects.equals(this.packages, tvPackages.packages) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvPackages {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    packages: ").append(toIndentedString(packages)).append("\n");
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

