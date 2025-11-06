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
 * SummaryPRSegmentEffort
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummaryPRSegmentEffort {

  private @Nullable Long prActivityId;

  private @Nullable Integer prElapsedTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime prDate;

  private @Nullable Integer effortCount;

  public SummaryPRSegmentEffort prActivityId(@Nullable Long prActivityId) {
    this.prActivityId = prActivityId;
    return this;
  }

  /**
   * The unique identifier of the activity related to the PR effort.
   * @return prActivityId
   */
  
  @Schema(name = "pr_activity_id", description = "The unique identifier of the activity related to the PR effort.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pr_activity_id")
  public @Nullable Long getPrActivityId() {
    return prActivityId;
  }

  public void setPrActivityId(@Nullable Long prActivityId) {
    this.prActivityId = prActivityId;
  }

  public SummaryPRSegmentEffort prElapsedTime(@Nullable Integer prElapsedTime) {
    this.prElapsedTime = prElapsedTime;
    return this;
  }

  /**
   * The elapsed time ot the PR effort.
   * @return prElapsedTime
   */
  
  @Schema(name = "pr_elapsed_time", description = "The elapsed time ot the PR effort.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pr_elapsed_time")
  public @Nullable Integer getPrElapsedTime() {
    return prElapsedTime;
  }

  public void setPrElapsedTime(@Nullable Integer prElapsedTime) {
    this.prElapsedTime = prElapsedTime;
  }

  public SummaryPRSegmentEffort prDate(@Nullable OffsetDateTime prDate) {
    this.prDate = prDate;
    return this;
  }

  /**
   * The time at which the PR effort was started.
   * @return prDate
   */
  @Valid 
  @Schema(name = "pr_date", description = "The time at which the PR effort was started.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pr_date")
  public @Nullable OffsetDateTime getPrDate() {
    return prDate;
  }

  public void setPrDate(@Nullable OffsetDateTime prDate) {
    this.prDate = prDate;
  }

  public SummaryPRSegmentEffort effortCount(@Nullable Integer effortCount) {
    this.effortCount = effortCount;
    return this;
  }

  /**
   * Number of efforts by the authenticated athlete on this segment.
   * @return effortCount
   */
  
  @Schema(name = "effort_count", description = "Number of efforts by the authenticated athlete on this segment.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("effort_count")
  public @Nullable Integer getEffortCount() {
    return effortCount;
  }

  public void setEffortCount(@Nullable Integer effortCount) {
    this.effortCount = effortCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryPRSegmentEffort summaryPRSegmentEffort = (SummaryPRSegmentEffort) o;
    return Objects.equals(this.prActivityId, summaryPRSegmentEffort.prActivityId) &&
        Objects.equals(this.prElapsedTime, summaryPRSegmentEffort.prElapsedTime) &&
        Objects.equals(this.prDate, summaryPRSegmentEffort.prDate) &&
        Objects.equals(this.effortCount, summaryPRSegmentEffort.effortCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prActivityId, prElapsedTime, prDate, effortCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryPRSegmentEffort {\n");
    sb.append("    prActivityId: ").append(toIndentedString(prActivityId)).append("\n");
    sb.append("    prElapsedTime: ").append(toIndentedString(prElapsedTime)).append("\n");
    sb.append("    prDate: ").append(toIndentedString(prDate)).append("\n");
    sb.append("    effortCount: ").append(toIndentedString(effortCount)).append("\n");
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

