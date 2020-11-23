package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * PackageType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class PackageType  implements Serializable {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("packageId")
  private String packageId = null;

  public PackageType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the package
   * @return name
  **/
  @ApiModelProperty(value = "Name of the package")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PackageType packageId(String packageId) {
    this.packageId = packageId;
    return this;
  }

   /**
   * Unique package identifier
   * @return packageId
  **/
  @ApiModelProperty(value = "Unique package identifier")
  public String getPackageId() {
    return packageId;
  }

  public void setPackageId(String packageId) {
    this.packageId = packageId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackageType packageType = (PackageType) o;
    return Objects.equals(this.name, packageType.name) &&
        Objects.equals(this.packageId, packageType.packageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, packageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackageType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    packageId: ").append(toIndentedString(packageId)).append("\n");
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

