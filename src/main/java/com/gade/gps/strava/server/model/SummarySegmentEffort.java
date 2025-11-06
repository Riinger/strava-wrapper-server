package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * SummarySegmentEffort
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummarySegmentEffort {

  private @Nullable Long id;

  private @Nullable Long activityId;

  private @Nullable Integer elapsedTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDateLocal;

  private @Nullable Float distance;

  private @Nullable Boolean isKom;

  public SummarySegmentEffort id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of this effort
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of this effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public SummarySegmentEffort activityId(@Nullable Long activityId) {
    this.activityId = activityId;
    return this;
  }

  /**
   * The unique identifier of the activity related to this effort
   * @return activityId
   */
  
  @Schema(name = "activity_id", description = "The unique identifier of the activity related to this effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activity_id")
  public @Nullable Long getActivityId() {
    return activityId;
  }

  public void setActivityId(@Nullable Long activityId) {
    this.activityId = activityId;
  }

  public SummarySegmentEffort elapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * The effort's elapsed time
   * @return elapsedTime
   */
  
  @Schema(name = "elapsed_time", description = "The effort's elapsed time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elapsed_time")
  public @Nullable Integer getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public SummarySegmentEffort startDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The time at which the effort was started.
   * @return startDate
   */
  @Valid 
  @Schema(name = "start_date", description = "The time at which the effort was started.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date")
  public @Nullable OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public SummarySegmentEffort startDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
    return this;
  }

  /**
   * The time at which the effort was started in the local timezone.
   * @return startDateLocal
   */
  @Valid 
  @Schema(name = "start_date_local", description = "The time at which the effort was started in the local timezone.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date_local")
  public @Nullable OffsetDateTime getStartDateLocal() {
    return startDateLocal;
  }

  public void setStartDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
  }

  public SummarySegmentEffort distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The effort's distance in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The effort's distance in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public SummarySegmentEffort isKom(@Nullable Boolean isKom) {
    this.isKom = isKom;
    return this;
  }

  /**
   * Whether this effort is the current best on the leaderboard
   * @return isKom
   */
  
  @Schema(name = "is_kom", description = "Whether this effort is the current best on the leaderboard", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("is_kom")
  public @Nullable Boolean getIsKom() {
    return isKom;
  }

  public void setIsKom(@Nullable Boolean isKom) {
    this.isKom = isKom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummarySegmentEffort summarySegmentEffort = (SummarySegmentEffort) o;
    return Objects.equals(this.id, summarySegmentEffort.id) &&
        Objects.equals(this.activityId, summarySegmentEffort.activityId) &&
        Objects.equals(this.elapsedTime, summarySegmentEffort.elapsedTime) &&
        Objects.equals(this.startDate, summarySegmentEffort.startDate) &&
        Objects.equals(this.startDateLocal, summarySegmentEffort.startDateLocal) &&
        Objects.equals(this.distance, summarySegmentEffort.distance) &&
        Objects.equals(this.isKom, summarySegmentEffort.isKom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, activityId, elapsedTime, startDate, startDateLocal, distance, isKom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummarySegmentEffort {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startDateLocal: ").append(toIndentedString(startDateLocal)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    isKom: ").append(toIndentedString(isKom)).append("\n");
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

