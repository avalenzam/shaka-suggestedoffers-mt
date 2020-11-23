package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * ChannelInfoType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class ChannelInfoType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  public ChannelInfoType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An identifier for the channel
   * @return id
  **/
  @ApiModelProperty(required = true, value = "An identifier for the channel")
  @NotNull
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChannelInfoType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores the channel detailed information
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the channel detailed information")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ChannelInfoType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * A human readable channel name. Defines the channels that can be used for selling the product offering (e.g.: WEB, CRM, SMS, IVR, UE)
   * @return name
  **/
  @ApiModelProperty(value = "A human readable channel name. Defines the channels that can be used for selling the product offering (e.g.: WEB, CRM, SMS, IVR, UE)")
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
    ChannelInfoType channelInfoType = (ChannelInfoType) o;
    return Objects.equals(this.id, channelInfoType.id) &&
        Objects.equals(this.href, channelInfoType.href) &&
        Objects.equals(this.name, channelInfoType.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelInfoType {\n");
    
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

