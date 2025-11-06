package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.HeartRateZoneRanges;
import com.gade.gps.strava.server.model.PowerZoneRanges;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Zones
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Zones {

  private @Nullable HeartRateZoneRanges heartRate;

  private @Nullable PowerZoneRanges power;

  public Zones heartRate(@Nullable HeartRateZoneRanges heartRate) {
    this.heartRate = heartRate;
    return this;
  }

  /**
   * Get heartRate
   * @return heartRate
   */
  @Valid 
  @Schema(name = "heart_rate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("heart_rate")
  public @Nullable HeartRateZoneRanges getHeartRate() {
    return heartRate;
  }

  public void setHeartRate(@Nullable HeartRateZoneRanges heartRate) {
    this.heartRate = heartRate;
  }

  public Zones power(@Nullable PowerZoneRanges power) {
    this.power = power;
    return this;
  }

  /**
   * Get power
   * @return power
   */
  @Valid 
  @Schema(name = "power", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("power")
  public @Nullable PowerZoneRanges getPower() {
    return power;
  }

  public void setPower(@Nullable PowerZoneRanges power) {
    this.power = power;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Zones zones = (Zones) o;
    return Objects.equals(this.heartRate, zones.heartRate) &&
        Objects.equals(this.power, zones.power);
  }

  @Override
  public int hashCode() {
    return Objects.hash(heartRate, power);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Zones {\n");
    sb.append("    heartRate: ").append(toIndentedString(heartRate)).append("\n");
    sb.append("    power: ").append(toIndentedString(power)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

