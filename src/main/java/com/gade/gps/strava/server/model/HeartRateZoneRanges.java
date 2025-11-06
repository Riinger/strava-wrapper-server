package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.ZoneRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * HeartRateZoneRanges
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class HeartRateZoneRanges {

  private @Nullable Boolean customZones;

  @Valid
  private List<@Valid ZoneRange> zones = new ArrayList<>();

  public HeartRateZoneRanges customZones(@Nullable Boolean customZones) {
    this.customZones = customZones;
    return this;
  }

  /**
   * Whether the athlete has set their own custom heart rate zones
   * @return customZones
   */
  
  @Schema(name = "custom_zones", description = "Whether the athlete has set their own custom heart rate zones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("custom_zones")
  public @Nullable Boolean getCustomZones() {
    return customZones;
  }

  public void setCustomZones(@Nullable Boolean customZones) {
    this.customZones = customZones;
  }

  public HeartRateZoneRanges zones(List<@Valid ZoneRange> zones) {
    this.zones = zones;
    return this;
  }

  public HeartRateZoneRanges addZonesItem(ZoneRange zonesItem) {
    if (this.zones == null) {
      this.zones = new ArrayList<>();
    }
    this.zones.add(zonesItem);
    return this;
  }

  /**
   * Get zones
   * @return zones
   */
  @Valid 
  @Schema(name = "zones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("zones")
  public List<@Valid ZoneRange> getZones() {
    return zones;
  }

  public void setZones(List<@Valid ZoneRange> zones) {
    this.zones = zones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HeartRateZoneRanges heartRateZoneRanges = (HeartRateZoneRanges) o;
    return Objects.equals(this.customZones, heartRateZoneRanges.customZones) &&
        Objects.equals(this.zones, heartRateZoneRanges.zones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customZones, zones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HeartRateZoneRanges {\n");
    sb.append("    customZones: ").append(toIndentedString(customZones)).append("\n");
    sb.append("    zones: ").append(toIndentedString(zones)).append("\n");
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

