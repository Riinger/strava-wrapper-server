package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.MetaActivity;
import com.gade.gps.strava.server.model.MetaAthlete;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Lap
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Lap {

  private @Nullable Long id;

  private @Nullable MetaActivity activity;

  private @Nullable MetaAthlete athlete;

  private @Nullable Float averageCadence;

  private @Nullable Float averageSpeed;

  private @Nullable Float distance;

  private @Nullable Integer elapsedTime;

  private @Nullable Integer startIndex;

  private @Nullable Integer endIndex;

  private @Nullable Integer lapIndex;

  private @Nullable Float maxSpeed;

  private @Nullable Integer movingTime;

  private @Nullable String name;

  private @Nullable Integer paceZone;

  private @Nullable Integer split;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDateLocal;

  private @Nullable Float totalElevationGain;

  public Lap id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of this lap
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of this lap", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public Lap activity(@Nullable MetaActivity activity) {
    this.activity = activity;
    return this;
  }

  /**
   * Get activity
   * @return activity
   */
  @Valid 
  @Schema(name = "activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activity")
  public @Nullable MetaActivity getActivity() {
    return activity;
  }

  public void setActivity(@Nullable MetaActivity activity) {
    this.activity = activity;
  }

  public Lap athlete(@Nullable MetaAthlete athlete) {
    this.athlete = athlete;
    return this;
  }

  /**
   * Get athlete
   * @return athlete
   */
  @Valid 
  @Schema(name = "athlete", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("athlete")
  public @Nullable MetaAthlete getAthlete() {
    return athlete;
  }

  public void setAthlete(@Nullable MetaAthlete athlete) {
    this.athlete = athlete;
  }

  public Lap averageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
    return this;
  }

  /**
   * The lap's average cadence
   * @return averageCadence
   */
  
  @Schema(name = "average_cadence", description = "The lap's average cadence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_cadence")
  public @Nullable Float getAverageCadence() {
    return averageCadence;
  }

  public void setAverageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
  }

  public Lap averageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
    return this;
  }

  /**
   * The lap's average speed
   * @return averageSpeed
   */
  
  @Schema(name = "average_speed", description = "The lap's average speed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_speed")
  public @Nullable Float getAverageSpeed() {
    return averageSpeed;
  }

  public void setAverageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  public Lap distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The lap's distance, in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The lap's distance, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public Lap elapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * The lap's elapsed time, in seconds
   * @return elapsedTime
   */
  
  @Schema(name = "elapsed_time", description = "The lap's elapsed time, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elapsed_time")
  public @Nullable Integer getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public Lap startIndex(@Nullable Integer startIndex) {
    this.startIndex = startIndex;
    return this;
  }

  /**
   * The start index of this effort in its activity's stream
   * @return startIndex
   */
  
  @Schema(name = "start_index", description = "The start index of this effort in its activity's stream", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_index")
  public @Nullable Integer getStartIndex() {
    return startIndex;
  }

  public void setStartIndex(@Nullable Integer startIndex) {
    this.startIndex = startIndex;
  }

  public Lap endIndex(@Nullable Integer endIndex) {
    this.endIndex = endIndex;
    return this;
  }

  /**
   * The end index of this effort in its activity's stream
   * @return endIndex
   */
  
  @Schema(name = "end_index", description = "The end index of this effort in its activity's stream", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("end_index")
  public @Nullable Integer getEndIndex() {
    return endIndex;
  }

  public void setEndIndex(@Nullable Integer endIndex) {
    this.endIndex = endIndex;
  }

  public Lap lapIndex(@Nullable Integer lapIndex) {
    this.lapIndex = lapIndex;
    return this;
  }

  /**
   * The index of this lap in the activity it belongs to
   * @return lapIndex
   */
  
  @Schema(name = "lap_index", description = "The index of this lap in the activity it belongs to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lap_index")
  public @Nullable Integer getLapIndex() {
    return lapIndex;
  }

  public void setLapIndex(@Nullable Integer lapIndex) {
    this.lapIndex = lapIndex;
  }

  public Lap maxSpeed(@Nullable Float maxSpeed) {
    this.maxSpeed = maxSpeed;
    return this;
  }

  /**
   * The maximum speed of this lat, in meters per second
   * @return maxSpeed
   */
  
  @Schema(name = "max_speed", description = "The maximum speed of this lat, in meters per second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max_speed")
  public @Nullable Float getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(@Nullable Float maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public Lap movingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
    return this;
  }

  /**
   * The lap's moving time, in seconds
   * @return movingTime
   */
  
  @Schema(name = "moving_time", description = "The lap's moving time, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving_time")
  public @Nullable Integer getMovingTime() {
    return movingTime;
  }

  public void setMovingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
  }

  public Lap name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the lap
   * @return name
   */
  
  @Schema(name = "name", description = "The name of the lap", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public Lap paceZone(@Nullable Integer paceZone) {
    this.paceZone = paceZone;
    return this;
  }

  /**
   * The athlete's pace zone during this lap
   * @return paceZone
   */
  
  @Schema(name = "pace_zone", description = "The athlete's pace zone during this lap", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pace_zone")
  public @Nullable Integer getPaceZone() {
    return paceZone;
  }

  public void setPaceZone(@Nullable Integer paceZone) {
    this.paceZone = paceZone;
  }

  public Lap split(@Nullable Integer split) {
    this.split = split;
    return this;
  }

  /**
   * Get split
   * @return split
   */
  
  @Schema(name = "split", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("split")
  public @Nullable Integer getSplit() {
    return split;
  }

  public void setSplit(@Nullable Integer split) {
    this.split = split;
  }

  public Lap startDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The time at which the lap was started.
   * @return startDate
   */
  @Valid 
  @Schema(name = "start_date", description = "The time at which the lap was started.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date")
  public @Nullable OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Lap startDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
    return this;
  }

  /**
   * The time at which the lap was started in the local timezone.
   * @return startDateLocal
   */
  @Valid 
  @Schema(name = "start_date_local", description = "The time at which the lap was started in the local timezone.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date_local")
  public @Nullable OffsetDateTime getStartDateLocal() {
    return startDateLocal;
  }

  public void setStartDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
  }

  public Lap totalElevationGain(@Nullable Float totalElevationGain) {
    this.totalElevationGain = totalElevationGain;
    return this;
  }

  /**
   * The elevation gain of this lap, in meters
   * @return totalElevationGain
   */
  
  @Schema(name = "total_elevation_gain", description = "The elevation gain of this lap, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_elevation_gain")
  public @Nullable Float getTotalElevationGain() {
    return totalElevationGain;
  }

  public void setTotalElevationGain(@Nullable Float totalElevationGain) {
    this.totalElevationGain = totalElevationGain;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lap lap = (Lap) o;
    return Objects.equals(this.id, lap.id) &&
        Objects.equals(this.activity, lap.activity) &&
        Objects.equals(this.athlete, lap.athlete) &&
        Objects.equals(this.averageCadence, lap.averageCadence) &&
        Objects.equals(this.averageSpeed, lap.averageSpeed) &&
        Objects.equals(this.distance, lap.distance) &&
        Objects.equals(this.elapsedTime, lap.elapsedTime) &&
        Objects.equals(this.startIndex, lap.startIndex) &&
        Objects.equals(this.endIndex, lap.endIndex) &&
        Objects.equals(this.lapIndex, lap.lapIndex) &&
        Objects.equals(this.maxSpeed, lap.maxSpeed) &&
        Objects.equals(this.movingTime, lap.movingTime) &&
        Objects.equals(this.name, lap.name) &&
        Objects.equals(this.paceZone, lap.paceZone) &&
        Objects.equals(this.split, lap.split) &&
        Objects.equals(this.startDate, lap.startDate) &&
        Objects.equals(this.startDateLocal, lap.startDateLocal) &&
        Objects.equals(this.totalElevationGain, lap.totalElevationGain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, activity, athlete, averageCadence, averageSpeed, distance, elapsedTime, startIndex, endIndex, lapIndex, maxSpeed, movingTime, name, paceZone, split, startDate, startDateLocal, totalElevationGain);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lap {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    athlete: ").append(toIndentedString(athlete)).append("\n");
    sb.append("    averageCadence: ").append(toIndentedString(averageCadence)).append("\n");
    sb.append("    averageSpeed: ").append(toIndentedString(averageSpeed)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
    sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
    sb.append("    lapIndex: ").append(toIndentedString(lapIndex)).append("\n");
    sb.append("    maxSpeed: ").append(toIndentedString(maxSpeed)).append("\n");
    sb.append("    movingTime: ").append(toIndentedString(movingTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    paceZone: ").append(toIndentedString(paceZone)).append("\n");
    sb.append("    split: ").append(toIndentedString(split)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startDateLocal: ").append(toIndentedString(startDateLocal)).append("\n");
    sb.append("    totalElevationGain: ").append(toIndentedString(totalElevationGain)).append("\n");
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

