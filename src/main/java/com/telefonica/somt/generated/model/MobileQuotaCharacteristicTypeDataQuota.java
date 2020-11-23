package com.telefonica.somt.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.constraints.*;
/**
 * MobileQuotaCharacteristicTypeDataQuota
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class MobileQuotaCharacteristicTypeDataQuota  implements Serializable {
  @JsonProperty("dataAllowance")
  private Long dataAllowance = null;

  /**
   * Code of the unit used to specify the given value of the quota. If not included is bytes (default value)
   */
  public enum UnitEnum {
    BYTES("bytes"),
    
    KB("KB"),
    
    MB("MB"),
    
    GB("GB");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static UnitEnum fromValue(String text) {
      for (UnitEnum b : UnitEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("unit")
  private UnitEnum unit = UnitEnum.BYTES;

  /**
   * Gets or Sets timeBands
   */
  public enum TimeBandsEnum {
    DAY("day"),
    
    NIGHT("night"),
    
    MORNING("morning"),
    
    EVENING("evening"),
    
    WEEKENDS("weekends"),
    
    WORKDAYS("workdays"),
    
    ALL("all");

    private String value;

    TimeBandsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TimeBandsEnum fromValue(String text) {
      for (TimeBandsEnum b : TimeBandsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("timeBands")
  private List<TimeBandsEnum> timeBands = new ArrayList<TimeBandsEnum>();

  /**
   * Gets or Sets origins
   */
  public enum OriginsEnum {
    HOME("home"),
    
    ROAMING("roaming"),
    
    EU("EU"),
    
    ANY("any");

    private String value;

    OriginsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OriginsEnum fromValue(String text) {
      for (OriginsEnum b : OriginsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("origins")
  private List<OriginsEnum> origins = new ArrayList<OriginsEnum>();

  /**
   * Gets or Sets destinations
   */
  public enum DestinationsEnum {
    TELEFONICA("telefonica"),
    
    NONTELEFONICA("nontelefonica"),
    
    LOCAL("local"),
    
    REGIONAL("regional"),
    
    NATIONAL("national"),
    
    INTERNATIONAL("international"),
    
    MOBILE("mobile"),
    
    LANDLINE("landline"),
    
    RURAL("rural"),
    
    ANY("any");

    private String value;

    DestinationsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DestinationsEnum fromValue(String text) {
      for (DestinationsEnum b : DestinationsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("destinations")
  private List<DestinationsEnum> destinations = new ArrayList<DestinationsEnum>();

  public MobileQuotaCharacteristicTypeDataQuota dataAllowance(Long dataAllowance) {
    this.dataAllowance = dataAllowance;
    return this;
  }

   /**
   * Data quota max number of units allowed to consume (default bytes). -1 means unlimited
   * @return dataAllowance
  **/
  @ApiModelProperty(required = true, value = "Data quota max number of units allowed to consume (default bytes). -1 means unlimited")
  @NotNull
  public Long getDataAllowance() {
    return dataAllowance;
  }

  public void setDataAllowance(Long dataAllowance) {
    this.dataAllowance = dataAllowance;
  }

  public MobileQuotaCharacteristicTypeDataQuota unit(UnitEnum unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Code of the unit used to specify the given value of the quota. If not included is bytes (default value)
   * @return unit
  **/
  @ApiModelProperty(value = "Code of the unit used to specify the given value of the quota. If not included is bytes (default value)")
  public UnitEnum getUnit() {
    return unit;
  }

  public void setUnit(UnitEnum unit) {
    this.unit = unit;
  }

  public MobileQuotaCharacteristicTypeDataQuota timeBands(List<TimeBandsEnum> timeBands) {
    this.timeBands = timeBands;
    return this;
  }

  public MobileQuotaCharacteristicTypeDataQuota addTimeBandsItem(TimeBandsEnum timeBandsItem) {
    this.timeBands.add(timeBandsItem);
    return this;
  }

   /**
   * Get timeBands
   * @return timeBands
  **/
  @ApiModelProperty(value = "")
  public List<TimeBandsEnum> getTimeBands() {
    return timeBands;
  }

  public void setTimeBands(List<TimeBandsEnum> timeBands) {
    this.timeBands = timeBands;
  }

  public MobileQuotaCharacteristicTypeDataQuota origins(List<OriginsEnum> origins) {
    this.origins = origins;
    return this;
  }

  public MobileQuotaCharacteristicTypeDataQuota addOriginsItem(OriginsEnum originsItem) {
    this.origins.add(originsItem);
    return this;
  }

   /**
   * Get origins
   * @return origins
  **/
  @ApiModelProperty(value = "")
  public List<OriginsEnum> getOrigins() {
    return origins;
  }

  public void setOrigins(List<OriginsEnum> origins) {
    this.origins = origins;
  }

  public MobileQuotaCharacteristicTypeDataQuota destinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
    return this;
  }

  public MobileQuotaCharacteristicTypeDataQuota addDestinationsItem(DestinationsEnum destinationsItem) {
    this.destinations.add(destinationsItem);
    return this;
  }

   /**
   * Get destinations
   * @return destinations
  **/
  @ApiModelProperty(value = "")
  public List<DestinationsEnum> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileQuotaCharacteristicTypeDataQuota mobileQuotaCharacteristicTypeDataQuota = (MobileQuotaCharacteristicTypeDataQuota) o;
    return Objects.equals(this.dataAllowance, mobileQuotaCharacteristicTypeDataQuota.dataAllowance) &&
        Objects.equals(this.unit, mobileQuotaCharacteristicTypeDataQuota.unit) &&
        Objects.equals(this.timeBands, mobileQuotaCharacteristicTypeDataQuota.timeBands) &&
        Objects.equals(this.origins, mobileQuotaCharacteristicTypeDataQuota.origins) &&
        Objects.equals(this.destinations, mobileQuotaCharacteristicTypeDataQuota.destinations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataAllowance, unit, timeBands, origins, destinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileQuotaCharacteristicTypeDataQuota {\n");
    
    sb.append("    dataAllowance: ").append(toIndentedString(dataAllowance)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    timeBands: ").append(toIndentedString(timeBands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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

