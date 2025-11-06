package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.TimedZoneRange;
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
 * ActivityZone
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class ActivityZone {

  private @Nullable Integer score;

  @Valid
  private List<TimedZoneRange> distributionBuckets = new ArrayList<>();

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    HEARTRATE("heartrate"),
    
    POWER("power");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable TypeEnum type;

  private @Nullable Boolean sensorBased;

  private @Nullable Integer points;

  private @Nullable Boolean customZones;

  private @Nullable Integer max;

  public ActivityZone score(@Nullable Integer score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
   */
  
  @Schema(name = "score", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("score")
  public @Nullable Integer getScore() {
    return score;
  }

  public void setScore(@Nullable Integer score) {
    this.score = score;
  }

  public ActivityZone distributionBuckets(List<TimedZoneRange> distributionBuckets) {
    this.distributionBuckets = distributionBuckets;
    return this;
  }

  public ActivityZone addDistributionBucketsItem(TimedZoneRange distributionBucketsItem) {
    if (this.distributionBuckets == null) {
      this.distributionBuckets = new ArrayList<>();
    }
    this.distributionBuckets.add(distributionBucketsItem);
    return this;
  }

  /**
   * Stores the exclusive ranges representing zones and the time spent in each.
   * @return distributionBuckets
   */
  @Valid 
  @Schema(name = "distribution_buckets", description = "Stores the exclusive ranges representing zones and the time spent in each.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distribution_buckets")
  public List<TimedZoneRange> getDistributionBuckets() {
    return distributionBuckets;
  }

  public void setDistributionBuckets(List<TimedZoneRange> distributionBuckets) {
    this.distributionBuckets = distributionBuckets;
  }

  public ActivityZone type(@Nullable TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public @Nullable TypeEnum getType() {
    return type;
  }

  public void setType(@Nullable TypeEnum type) {
    this.type = type;
  }

  public ActivityZone sensorBased(@Nullable Boolean sensorBased) {
    this.sensorBased = sensorBased;
    return this;
  }

  /**
   * Get sensorBased
   * @return sensorBased
   */
  
  @Schema(name = "sensor_based", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sensor_based")
  public @Nullable Boolean getSensorBased() {
    return sensorBased;
  }

  public void setSensorBased(@Nullable Boolean sensorBased) {
    this.sensorBased = sensorBased;
  }

  public ActivityZone points(@Nullable Integer points) {
    this.points = points;
    return this;
  }

  /**
   * Get points
   * @return points
   */
  
  @Schema(name = "points", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("points")
  public @Nullable Integer getPoints() {
    return points;
  }

  public void setPoints(@Nullable Integer points) {
    this.points = points;
  }

  public ActivityZone customZones(@Nullable Boolean customZones) {
    this.customZones = customZones;
    return this;
  }

  /**
   * Get customZones
   * @return customZones
   */
  
  @Schema(name = "custom_zones", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("custom_zones")
  public @Nullable Boolean getCustomZones() {
    return customZones;
  }

  public void setCustomZones(@Nullable Boolean customZones) {
    this.customZones = customZones;
  }

  public ActivityZone max(@Nullable Integer max) {
    this.max = max;
    return this;
  }

  /**
   * Get max
   * @return max
   */
  
  @Schema(name = "max", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    ActivityZone activityZone = (ActivityZone) o;
    return Objects.equals(this.score, activityZone.score) &&
        Objects.equals(this.distributionBuckets, activityZone.distributionBuckets) &&
        Objects.equals(this.type, activityZone.type) &&
        Objects.equals(this.sensorBased, activityZone.sensorBased) &&
        Objects.equals(this.points, activityZone.points) &&
        Objects.equals(this.customZones, activityZone.customZones) &&
        Objects.equals(this.max, activityZone.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, distributionBuckets, type, sensorBased, points, customZones, max);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityZone {\n");
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    distributionBuckets: ").append(toIndentedString(distributionBuckets)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sensorBased: ").append(toIndentedString(sensorBased)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    customZones: ").append(toIndentedString(customZones)).append("\n");
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

