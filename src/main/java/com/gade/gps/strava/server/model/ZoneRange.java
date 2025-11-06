package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ZoneRange
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class ZoneRange {

  private @Nullable Integer min;

  private @Nullable Integer max;

  public ZoneRange min(@Nullable Integer min) {
    this.min = min;
    return this;
  }

  /**
   * The minimum value in the range.
   * @return min
   */
  
  @Schema(name = "min", description = "The minimum value in the range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("min")
  public @Nullable Integer getMin() {
    return min;
  }

  public void setMin(@Nullable Integer min) {
    this.min = min;
  }

  public ZoneRange max(@Nullable Integer max) {
    this.max = max;
    return this;
  }

  /**
   * The maximum value in the range.
   * @return max
   */
  
  @Schema(name = "max", description = "The maximum value in the range.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max")
  public @Nullable Integer getMax() {
    return max;
  }

  public void setMax(@Nullable Integer max) {
    this.max = max;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZoneRange zoneRange = (ZoneRange) o;
    return Objects.equals(this.min, zoneRange.min) &&
        Objects.equals(this.max, zoneRange.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZoneRange {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
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

