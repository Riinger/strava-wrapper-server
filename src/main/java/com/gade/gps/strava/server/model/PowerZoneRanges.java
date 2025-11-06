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
 * PowerZoneRanges
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class PowerZoneRanges {

  @Valid
  private List<@Valid ZoneRange> zones = new ArrayList<>();

  public PowerZoneRanges zones(List<@Valid ZoneRange> zones) {
    this.zones = zones;
    return this;
  }

  public PowerZoneRanges addZonesItem(ZoneRange zonesItem) {
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
    PowerZoneRanges powerZoneRanges = (PowerZoneRanges) o;
    return Objects.equals(this.zones, powerZoneRanges.zones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PowerZoneRanges {\n");
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

