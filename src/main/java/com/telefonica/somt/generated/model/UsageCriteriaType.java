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
 * Definition of usage criteria considered in the quota for consumption measurement (timebands, origins or destinations).
 */
@ApiModel(description = "Definition of usage criteria considered in the quota for consumption measurement (timebands, origins or destinations).")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-20T15:28:41.044-05:00")

public class UsageCriteriaType  implements Serializable {
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

  /**
   * Gets or Sets timebands
   */
  public enum TimebandsEnum {
    DAY("day"),
    
    NIGHT("night"),
    
    MORNING("morning"),
    
    EVENING("evening"),
    
    WEEKENDS("weekends"),
    
    WORKDAYS("workdays"),
    
    ALL("all");

    private String value;

    TimebandsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TimebandsEnum fromValue(String text) {
      for (TimebandsEnum b : TimebandsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("timebands")
  private List<TimebandsEnum> timebands = new ArrayList<TimebandsEnum>();

  public UsageCriteriaType origins(List<OriginsEnum> origins) {
    this.origins = origins;
    return this;
  }

  public UsageCriteriaType addOriginsItem(OriginsEnum originsItem) {
    this.origins.add(originsItem);
    return this;
  }

   /**
   * List of origins that are considered when registering usage of a given product/service by the consumption quota
   * @return origins
  **/
  @ApiModelProperty(value = "List of origins that are considered when registering usage of a given product/service by the consumption quota")
  public List<OriginsEnum> getOrigins() {
    return origins;
  }

  public void setOrigins(List<OriginsEnum> origins) {
    this.origins = origins;
  }

  public UsageCriteriaType destinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
    return this;
  }

  public UsageCriteriaType addDestinationsItem(DestinationsEnum destinationsItem) {
    this.destinations.add(destinationsItem);
    return this;
  }

   /**
   * List of destinations that are considered when registering usage of a given product/service by the consumption quota
   * @return destinations
  **/
  @ApiModelProperty(value = "List of destinations that are considered when registering usage of a given product/service by the consumption quota")
  public List<DestinationsEnum> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
  }

  public UsageCriteriaType timebands(List<TimebandsEnum> timebands) {
    this.timebands = timebands;
    return this;
  }

  public UsageCriteriaType addTimebandsItem(TimebandsEnum timebandsItem) {
    this.timebands.add(timebandsItem);
    return this;
  }

   /**
   * List of time bands that are considered when registering usage of a given product/service by the consumption quota
   * @return timebands
  **/
  @ApiModelProperty(value = "List of time bands that are considered when registering usage of a given product/service by the consumption quota")
  public List<TimebandsEnum> getTimebands() {
    return timebands;
  }

  public void setTimebands(List<TimebandsEnum> timebands) {
    this.timebands = timebands;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsageCriteriaType usageCriteriaType = (UsageCriteriaType) o;
    return Objects.equals(this.origins, usageCriteriaType.origins) &&
        Objects.equals(this.destinations, usageCriteriaType.destinations) &&
        Objects.equals(this.timebands, usageCriteriaType.timebands);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origins, destinations, timebands);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsageCriteriaType {\n");
    
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
    sb.append("    timebands: ").append(toIndentedString(timebands)).append("\n");
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

