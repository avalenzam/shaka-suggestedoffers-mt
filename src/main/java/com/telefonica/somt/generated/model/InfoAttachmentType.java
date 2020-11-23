package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * InfoAttachmentType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class InfoAttachmentType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("url")
  private String url = null;

  public InfoAttachmentType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Identifier for the entity storing the additional resources describing the product (such as a video, picture, web address, ?)
   * @return id
  **/
  @ApiModelProperty(value = "Identifier for the entity storing the additional resources describing the product (such as a video, picture, web address, ?)")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public InfoAttachmentType href(String href) {
    this.href = href;
    return this;
  }

   /**
   * A resource URI pointing to the resource in the OB that stores additional detailed information for the referred product
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores additional detailed information for the referred product")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public InfoAttachmentType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type/format of the additional information available (e.g.: picture, video, web, document)
   * @return type
  **/
  @ApiModelProperty(value = "Type/format of the additional information available (e.g.: picture, video, web, document)")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public InfoAttachmentType url(String url) {
    this.url = url;
    return this;
  }

   /**
   * The URL that stores the additional information of the product (e.g.: weblink with a downloadable product description brochure)
   * @return url
  **/
  @ApiModelProperty(required = true, value = "The URL that stores the additional information of the product (e.g.: weblink with a downloadable product description brochure)")
  @NotNull
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InfoAttachmentType infoAttachmentType = (InfoAttachmentType) o;
    return Objects.equals(this.id, infoAttachmentType.id) &&
        Objects.equals(this.href, infoAttachmentType.href) &&
        Objects.equals(this.type, infoAttachmentType.type) &&
        Objects.equals(this.url, infoAttachmentType.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, type, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoAttachmentType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

