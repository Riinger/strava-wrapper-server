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
 * A union type representing the time spent in a given zone.
 */

@Schema(name = "TimedZoneRange", description = "A union type representing the time spent in a given zone.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class TimedZoneRange {

  private @Nullable Integer min;

  private @Nullable Integer max;

  private @Nullable Integer time;

  public TimedZoneRange min(@Nullable Integer min) {
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

  public TimedZoneRange max(@Nullable Integer max) {
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

  public TimedZoneRange time(@Nullable Integer time) {
    this.time = time;
    return this;
  }

  /**
   * The number of seconds spent in this zone
   * @return time
   */
  
  @Schema(name = "time", description = "The number of seconds spent in this zone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public @Nullable Integer getTime() {
    return time;
  }

  public void setTime(@Nullable Integer time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimedZoneRange timedZoneRange = (TimedZoneRange) o;
    return Objects.equals(this.min, timedZoneRange.min) &&
        Objects.equals(this.max, timedZoneRange.max) &&
        Objects.equals(this.time, timedZoneRange.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimedZoneRange {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

