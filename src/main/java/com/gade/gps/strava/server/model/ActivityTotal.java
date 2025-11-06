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
 * A roll-up of metrics pertaining to a set of activities. Values are in seconds and meters.
 */

@Schema(name = "ActivityTotal", description = "A roll-up of metrics pertaining to a set of activities. Values are in seconds and meters.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class ActivityTotal {

  private @Nullable Integer count;

  private @Nullable Float distance;

  private @Nullable Integer movingTime;

  private @Nullable Integer elapsedTime;

  private @Nullable Float elevationGain;

  private @Nullable Integer achievementCount;

  public ActivityTotal count(@Nullable Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The number of activities considered in this total.
   * @return count
   */
  
  @Schema(name = "count", description = "The number of activities considered in this total.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public @Nullable Integer getCount() {
    return count;
  }

  public void setCount(@Nullable Integer count) {
    this.count = count;
  }

  public ActivityTotal distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The total distance covered by the considered activities.
   * @return distance
   */
  
  @Schema(name = "distance", description = "The total distance covered by the considered activities.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public ActivityTotal movingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
    return this;
  }

  /**
   * The total moving time of the considered activities.
   * @return movingTime
   */
  
  @Schema(name = "moving_time", description = "The total moving time of the considered activities.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving_time")
  public @Nullable Integer getMovingTime() {
    return movingTime;
  }

  public void setMovingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
  }

  public ActivityTotal elapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * The total elapsed time of the considered activities.
   * @return elapsedTime
   */
  
  @Schema(name = "elapsed_time", description = "The total elapsed time of the considered activities.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elapsed_time")
  public @Nullable Integer getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public ActivityTotal elevationGain(@Nullable Float elevationGain) {
    this.elevationGain = elevationGain;
    return this;
  }

  /**
   * The total elevation gain of the considered activities.
   * @return elevationGain
   */
  
  @Schema(name = "elevation_gain", description = "The total elevation gain of the considered activities.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elevation_gain")
  public @Nullable Float getElevationGain() {
    return elevationGain;
  }

  public void setElevationGain(@Nullable Float elevationGain) {
    this.elevationGain = elevationGain;
  }

  public ActivityTotal achievementCount(@Nullable Integer achievementCount) {
    this.achievementCount = achievementCount;
    return this;
  }

  /**
   * The total number of achievements of the considered activities.
   * @return achievementCount
   */
  
  @Schema(name = "achievement_count", description = "The total number of achievements of the considered activities.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("achievement_count")
  public @Nullable Integer getAchievementCount() {
    return achievementCount;
  }

  public void setAchievementCount(@Nullable Integer achievementCount) {
    this.achievementCount = achievementCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityTotal activityTotal = (ActivityTotal) o;
    return Objects.equals(this.count, activityTotal.count) &&
        Objects.equals(this.distance, activityTotal.distance) &&
        Objects.equals(this.movingTime, activityTotal.movingTime) &&
        Objects.equals(this.elapsedTime, activityTotal.elapsedTime) &&
        Objects.equals(this.elevationGain, activityTotal.elevationGain) &&
        Objects.equals(this.achievementCount, activityTotal.achievementCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, distance, movingTime, elapsedTime, elevationGain, achievementCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityTotal {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    movingTime: ").append(toIndentedString(movingTime)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    elevationGain: ").append(toIndentedString(elevationGain)).append("\n");
    sb.append("    achievementCount: ").append(toIndentedString(achievementCount)).append("\n");
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

