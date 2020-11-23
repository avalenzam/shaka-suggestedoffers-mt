package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.CharacteristicBenefitType;
import com.telefonica.somt.generated.model.PriceBenefitType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * BenefitType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class BenefitType  implements Serializable {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("downloadSpeed")
  private String downloadSpeed = null;

  @JsonProperty("characteristics")
  private List<CharacteristicBenefitType> characteristics = new ArrayList<CharacteristicBenefitType>();

  @JsonProperty("priceBenefits")
  private List<PriceBenefitType> priceBenefits = new ArrayList<PriceBenefitType>();

  public BenefitType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * id del beneficio (boCode)
   * @return id
  **/
  @ApiModelProperty(value = "id del beneficio (boCode)")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BenefitType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Nombre del beneficio. (SE OBTENDRA TABLE BILLING OFFERING en base al BILLINOFFER CODE)
   * @return name
  **/
  @ApiModelProperty(value = "Nombre del beneficio. (SE OBTENDRA TABLE BILLING OFFERING en base al BILLINOFFER CODE)")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BenefitType type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Es el tipo de beneficio
   * @return type
  **/
  @ApiModelProperty(value = "Es el tipo de beneficio")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public BenefitType value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Es el valor del beneficio
   * @return value
  **/
  @ApiModelProperty(value = "Es el valor del beneficio")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public BenefitType downloadSpeed(String downloadSpeed) {
    this.downloadSpeed = downloadSpeed;
    return this;
  }

   /**
   * Es la velocidad de descarga
   * @return downloadSpeed
  **/
  @ApiModelProperty(value = "Es la velocidad de descarga")
  public String getDownloadSpeed() {
    return downloadSpeed;
  }

  public void setDownloadSpeed(String downloadSpeed) {
    this.downloadSpeed = downloadSpeed;
  }

  public BenefitType characteristics(List<CharacteristicBenefitType> characteristics) {
    this.characteristics = characteristics;
    return this;
  }

  public BenefitType addCharacteristicsItem(CharacteristicBenefitType characteristicsItem) {
    this.characteristics.add(characteristicsItem);
    return this;
  }

   /**
   * Aquí se poblaran las caracteristicas del beneficio
   * @return characteristics
  **/
  @ApiModelProperty(value = "Aquí se poblaran las caracteristicas del beneficio")
  public List<CharacteristicBenefitType> getCharacteristics() {
    return characteristics;
  }

  public void setCharacteristics(List<CharacteristicBenefitType> characteristics) {
    this.characteristics = characteristics;
  }

  public BenefitType priceBenefits(List<PriceBenefitType> priceBenefits) {
    this.priceBenefits = priceBenefits;
    return this;
  }

  public BenefitType addPriceBenefitsItem(PriceBenefitType priceBenefitsItem) {
    this.priceBenefits.add(priceBenefitsItem);
    return this;
  }

   /**
   * Es el precio del beneficio
   * @return priceBenefits
  **/
  @ApiModelProperty(value = "Es el precio del beneficio")
  public List<PriceBenefitType> getPriceBenefits() {
    return priceBenefits;
  }

  public void setPriceBenefits(List<PriceBenefitType> priceBenefits) {
    this.priceBenefits = priceBenefits;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BenefitType benefitType = (BenefitType) o;
    return Objects.equals(this.id, benefitType.id) &&
        Objects.equals(this.name, benefitType.name) &&
        Objects.equals(this.type, benefitType.type) &&
        Objects.equals(this.value, benefitType.value) &&
        Objects.equals(this.downloadSpeed, benefitType.downloadSpeed) &&
        Objects.equals(this.characteristics, benefitType.characteristics) &&
        Objects.equals(this.priceBenefits, benefitType.priceBenefits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, value, downloadSpeed, characteristics, priceBenefits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BenefitType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    downloadSpeed: ").append(toIndentedString(downloadSpeed)).append("\n");
    sb.append("    characteristics: ").append(toIndentedString(characteristics)).append("\n");
    sb.append("    priceBenefits: ").append(toIndentedString(priceBenefits)).append("\n");
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

