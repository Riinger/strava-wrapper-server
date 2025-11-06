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
 * Split
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Split {

  private @Nullable Float averageSpeed;

  private @Nullable Float distance;

  private @Nullable Integer elapsedTime;

  private @Nullable Float elevationDifference;

  private @Nullable Integer paceZone;

  private @Nullable Integer movingTime;

  private @Nullable Integer split;

  public Split averageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
    return this;
  }

  /**
   * The average speed of this split, in meters per second
   * @return averageSpeed
   */
  
  @Schema(name = "average_speed", description = "The average speed of this split, in meters per second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_speed")
  public @Nullable Float getAverageSpeed() {
    return averageSpeed;
  }

  public void setAverageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  public Split distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The distance of this split, in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The distance of this split, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public Split elapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * The elapsed time of this split, in seconds
   * @return elapsedTime
   */
  
  @Schema(name = "elapsed_time", description = "The elapsed time of this split, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elapsed_time")
  public @Nullable Integer getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public Split elevationDifference(@Nullable Float elevationDifference) {
    this.elevationDifference = elevationDifference;
    return this;
  }

  /**
   * The elevation difference of this split, in meters
   * @return elevationDifference
   */
  
  @Schema(name = "elevation_difference", description = "The elevation difference of this split, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elevation_difference")
  public @Nullable Float getElevationDifference() {
    return elevationDifference;
  }

  public void setElevationDifference(@Nullable Float elevationDifference) {
    this.elevationDifference = elevationDifference;
  }

  public Split paceZone(@Nullable Integer paceZone) {
    this.paceZone = paceZone;
    return this;
  }

  /**
   * The pacing zone of this split
   * @return paceZone
   */
  
  @Schema(name = "pace_zone", description = "The pacing zone of this split", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pace_zone")
  public @Nullable Integer getPaceZone() {
    return paceZone;
  }

  public void setPaceZone(@Nullable Integer paceZone) {
    this.paceZone = paceZone;
  }

  public Split movingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
    return this;
  }

  /**
   * The moving time of this split, in seconds
   * @return movingTime
   */
  
  @Schema(name = "moving_time", description = "The moving time of this split, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving_time")
  public @Nullable Integer getMovingTime() {
    return movingTime;
  }

  public void setMovingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
  }

  public Split split(@Nullable Integer split) {
    this.split = split;
    return this;
  }

  /**
   * N/A
   * @return split
   */
  
  @Schema(name = "split", description = "N/A", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("split")
  public @Nullable Integer getSplit() {
    return split;
  }

  public void setSplit(@Nullable Integer split) {
    this.split = split;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Split split = (Split) o;
    return Objects.equals(this.averageSpeed, split.averageSpeed) &&
        Objects.equals(this.distance, split.distance) &&
        Objects.equals(this.elapsedTime, split.elapsedTime) &&
        Objects.equals(this.elevationDifference, split.elevationDifference) &&
        Objects.equals(this.paceZone, split.paceZone) &&
        Objects.equals(this.movingTime, split.movingTime) &&
        Objects.equals(this.split, split.split);
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageSpeed, distance, elapsedTime, elevationDifference, paceZone, movingTime, split);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Split {\n");
    sb.append("    averageSpeed: ").append(toIndentedString(averageSpeed)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    elevationDifference: ").append(toIndentedString(elevationDifference)).append("\n");
    sb.append("    paceZone: ").append(toIndentedString(paceZone)).append("\n");
    sb.append("    movingTime: ").append(toIndentedString(movingTime)).append("\n");
    sb.append("    split: ").append(toIndentedString(split)).append("\n");
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

