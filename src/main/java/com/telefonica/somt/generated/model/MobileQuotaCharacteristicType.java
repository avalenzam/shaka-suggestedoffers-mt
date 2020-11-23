package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.telefonica.somt.generated.model.MobileQuotaCharacteristicTypeDataQuota;
import com.telefonica.somt.generated.model.MobileQuotaCharacteristicTypeSmsQuota;
import com.telefonica.somt.generated.model.MobileQuotaCharacteristicTypeVoiceQuota;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * Information for mobile type products, providing details on available data, voice and sms quota
 */
@ApiModel(description = "Information for mobile type products, providing details on available data, voice and sms quota")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class MobileQuotaCharacteristicType  implements Serializable {
  @JsonProperty("voiceQuota")
  private List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota = new ArrayList<MobileQuotaCharacteristicTypeVoiceQuota>();

  @JsonProperty("dataQuota")
  private List<MobileQuotaCharacteristicTypeDataQuota> dataQuota = new ArrayList<MobileQuotaCharacteristicTypeDataQuota>();

  @JsonProperty("smsQuota")
  private List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota = new ArrayList<MobileQuotaCharacteristicTypeSmsQuota>();

  public MobileQuotaCharacteristicType voiceQuota(List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota) {
    this.voiceQuota = voiceQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addVoiceQuotaItem(MobileQuotaCharacteristicTypeVoiceQuota voiceQuotaItem) {
    this.voiceQuota.add(voiceQuotaItem);
    return this;
  }

   /**
   * Get voiceQuota
   * @return voiceQuota
  **/
  @ApiModelProperty(value = "")
  public List<MobileQuotaCharacteristicTypeVoiceQuota> getVoiceQuota() {
    return voiceQuota;
  }

  public void setVoiceQuota(List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota) {
    this.voiceQuota = voiceQuota;
  }

  public MobileQuotaCharacteristicType dataQuota(List<MobileQuotaCharacteristicTypeDataQuota> dataQuota) {
    this.dataQuota = dataQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addDataQuotaItem(MobileQuotaCharacteristicTypeDataQuota dataQuotaItem) {
    this.dataQuota.add(dataQuotaItem);
    return this;
  }

   /**
   * Get dataQuota
   * @return dataQuota
  **/
  @ApiModelProperty(value = "")
  public List<MobileQuotaCharacteristicTypeDataQuota> getDataQuota() {
    return dataQuota;
  }

  public void setDataQuota(List<MobileQuotaCharacteristicTypeDataQuota> dataQuota) {
    this.dataQuota = dataQuota;
  }

  public MobileQuotaCharacteristicType smsQuota(List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota) {
    this.smsQuota = smsQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addSmsQuotaItem(MobileQuotaCharacteristicTypeSmsQuota smsQuotaItem) {
    this.smsQuota.add(smsQuotaItem);
    return this;
  }

   /**
   * Get smsQuota
   * @return smsQuota
  **/
  @ApiModelProperty(value = "")
  public List<MobileQuotaCharacteristicTypeSmsQuota> getSmsQuota() {
    return smsQuota;
  }

  public void setSmsQuota(List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota) {
    this.smsQuota = smsQuota;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileQuotaCharacteristicType mobileQuotaCharacteristicType = (MobileQuotaCharacteristicType) o;
    return Objects.equals(this.voiceQuota, mobileQuotaCharacteristicType.voiceQuota) &&
        Objects.equals(this.dataQuota, mobileQuotaCharacteristicType.dataQuota) &&
        Objects.equals(this.smsQuota, mobileQuotaCharacteristicType.smsQuota);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voiceQuota, dataQuota, smsQuota);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileQuotaCharacteristicType {\n");
    
    sb.append("    voiceQuota: ").append(toIndentedString(voiceQuota)).append("\n");
    sb.append("    dataQuota: ").append(toIndentedString(dataQuota)).append("\n");
    sb.append("    smsQuota: ").append(toIndentedString(smsQuota)).append("\n");
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

