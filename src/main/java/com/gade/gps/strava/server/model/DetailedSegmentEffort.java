package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.MetaActivity;
import com.gade.gps.strava.server.model.MetaAthlete;
import com.gade.gps.strava.server.model.SummarySegment;
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
 * DetailedSegmentEffort
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class DetailedSegmentEffort {

  private @Nullable Long id;

  private @Nullable Long activityId;

  private @Nullable Integer elapsedTime;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDateLocal;

  private @Nullable Float distance;

  private @Nullable Boolean isKom;

  private @Nullable String name;

  private @Nullable MetaActivity activity;

  private @Nullable MetaAthlete athlete;

  private @Nullable Integer movingTime;

  private @Nullable Integer startIndex;

  private @Nullable Integer endIndex;

  private @Nullable Float averageCadence;

  private @Nullable Float averageWatts;

  private @Nullable Boolean deviceWatts;

  private @Nullable Float averageHeartrate;

  private @Nullable Float maxHeartrate;

  private @Nullable SummarySegment segment;

  private @Nullable Integer komRank;

  private @Nullable Integer prRank;

  private @Nullable Boolean hidden;

  public DetailedSegmentEffort id(@Nullable Long id) {
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

  public DetailedSegmentEffort activityId(@Nullable Long activityId) {
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

  public DetailedSegmentEffort elapsedTime(@Nullable Integer elapsedTime) {
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

  public DetailedSegmentEffort startDate(@Nullable OffsetDateTime startDate) {
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

  public DetailedSegmentEffort startDateLocal(@Nullable OffsetDateTime startDateLocal) {
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

  public DetailedSegmentEffort distance(@Nullable Float distance) {
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

  public DetailedSegmentEffort isKom(@Nullable Boolean isKom) {
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

  public DetailedSegmentEffort name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the segment on which this effort was performed
   * @return name
   */
  
  @Schema(name = "name", description = "The name of the segment on which this effort was performed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public DetailedSegmentEffort activity(@Nullable MetaActivity activity) {
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

  public DetailedSegmentEffort athlete(@Nullable MetaAthlete athlete) {
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

  public DetailedSegmentEffort movingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
    return this;
  }

  /**
   * The effort's moving time
   * @return movingTime
   */
  
  @Schema(name = "moving_time", description = "The effort's moving time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving_time")
  public @Nullable Integer getMovingTime() {
    return movingTime;
  }

  public void setMovingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
  }

  public DetailedSegmentEffort startIndex(@Nullable Integer startIndex) {
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

  public DetailedSegmentEffort endIndex(@Nullable Integer endIndex) {
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

  public DetailedSegmentEffort averageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
    return this;
  }

  /**
   * The effort's average cadence
   * @return averageCadence
   */
  
  @Schema(name = "average_cadence", description = "The effort's average cadence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_cadence")
  public @Nullable Float getAverageCadence() {
    return averageCadence;
  }

  public void setAverageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
  }

  public DetailedSegmentEffort averageWatts(@Nullable Float averageWatts) {
    this.averageWatts = averageWatts;
    return this;
  }

  /**
   * The average wattage of this effort
   * @return averageWatts
   */
  
  @Schema(name = "average_watts", description = "The average wattage of this effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_watts")
  public @Nullable Float getAverageWatts() {
    return averageWatts;
  }

  public void setAverageWatts(@Nullable Float averageWatts) {
    this.averageWatts = averageWatts;
  }

  public DetailedSegmentEffort deviceWatts(@Nullable Boolean deviceWatts) {
    this.deviceWatts = deviceWatts;
    return this;
  }

  /**
   * For riding efforts, whether the wattage was reported by a dedicated recording device
   * @return deviceWatts
   */
  
  @Schema(name = "device_watts", description = "For riding efforts, whether the wattage was reported by a dedicated recording device", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("device_watts")
  public @Nullable Boolean getDeviceWatts() {
    return deviceWatts;
  }

  public void setDeviceWatts(@Nullable Boolean deviceWatts) {
    this.deviceWatts = deviceWatts;
  }

  public DetailedSegmentEffort averageHeartrate(@Nullable Float averageHeartrate) {
    this.averageHeartrate = averageHeartrate;
    return this;
  }

  /**
   * The heart heart rate of the athlete during this effort
   * @return averageHeartrate
   */
  
  @Schema(name = "average_heartrate", description = "The heart heart rate of the athlete during this effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_heartrate")
  public @Nullable Float getAverageHeartrate() {
    return averageHeartrate;
  }

  public void setAverageHeartrate(@Nullable Float averageHeartrate) {
    this.averageHeartrate = averageHeartrate;
  }

  public DetailedSegmentEffort maxHeartrate(@Nullable Float maxHeartrate) {
    this.maxHeartrate = maxHeartrate;
    return this;
  }

  /**
   * The maximum heart rate of the athlete during this effort
   * @return maxHeartrate
   */
  
  @Schema(name = "max_heartrate", description = "The maximum heart rate of the athlete during this effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max_heartrate")
  public @Nullable Float getMaxHeartrate() {
    return maxHeartrate;
  }

  public void setMaxHeartrate(@Nullable Float maxHeartrate) {
    this.maxHeartrate = maxHeartrate;
  }

  public DetailedSegmentEffort segment(@Nullable SummarySegment segment) {
    this.segment = segment;
    return this;
  }

  /**
   * Get segment
   * @return segment
   */
  @Valid 
  @Schema(name = "segment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("segment")
  public @Nullable SummarySegment getSegment() {
    return segment;
  }

  public void setSegment(@Nullable SummarySegment segment) {
    this.segment = segment;
  }

  public DetailedSegmentEffort komRank(@Nullable Integer komRank) {
    this.komRank = komRank;
    return this;
  }

  /**
   * The rank of the effort on the global leaderboard if it belongs in the top 10 at the time of upload
   * minimum: 1
   * maximum: 10
   * @return komRank
   */
  @Min(1) @Max(10) 
  @Schema(name = "kom_rank", description = "The rank of the effort on the global leaderboard if it belongs in the top 10 at the time of upload", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kom_rank")
  public @Nullable Integer getKomRank() {
    return komRank;
  }

  public void setKomRank(@Nullable Integer komRank) {
    this.komRank = komRank;
  }

  public DetailedSegmentEffort prRank(@Nullable Integer prRank) {
    this.prRank = prRank;
    return this;
  }

  /**
   * The rank of the effort on the athlete's leaderboard if it belongs in the top 3 at the time of upload
   * minimum: 1
   * maximum: 3
   * @return prRank
   */
  @Min(1) @Max(3) 
  @Schema(name = "pr_rank", description = "The rank of the effort on the athlete's leaderboard if it belongs in the top 3 at the time of upload", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pr_rank")
  public @Nullable Integer getPrRank() {
    return prRank;
  }

  public void setPrRank(@Nullable Integer prRank) {
    this.prRank = prRank;
  }

  public DetailedSegmentEffort hidden(@Nullable Boolean hidden) {
    this.hidden = hidden;
    return this;
  }

  /**
   * Whether this effort should be hidden when viewed within an activity
   * @return hidden
   */
  
  @Schema(name = "hidden", description = "Whether this effort should be hidden when viewed within an activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hidden")
  public @Nullable Boolean getHidden() {
    return hidden;
  }

  public void setHidden(@Nullable Boolean hidden) {
    this.hidden = hidden;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedSegmentEffort detailedSegmentEffort = (DetailedSegmentEffort) o;
    return Objects.equals(this.id, detailedSegmentEffort.id) &&
        Objects.equals(this.activityId, detailedSegmentEffort.activityId) &&
        Objects.equals(this.elapsedTime, detailedSegmentEffort.elapsedTime) &&
        Objects.equals(this.startDate, detailedSegmentEffort.startDate) &&
        Objects.equals(this.startDateLocal, detailedSegmentEffort.startDateLocal) &&
        Objects.equals(this.distance, detailedSegmentEffort.distance) &&
        Objects.equals(this.isKom, detailedSegmentEffort.isKom) &&
        Objects.equals(this.name, detailedSegmentEffort.name) &&
        Objects.equals(this.activity, detailedSegmentEffort.activity) &&
        Objects.equals(this.athlete, detailedSegmentEffort.athlete) &&
        Objects.equals(this.movingTime, detailedSegmentEffort.movingTime) &&
        Objects.equals(this.startIndex, detailedSegmentEffort.startIndex) &&
        Objects.equals(this.endIndex, detailedSegmentEffort.endIndex) &&
        Objects.equals(this.averageCadence, detailedSegmentEffort.averageCadence) &&
        Objects.equals(this.averageWatts, detailedSegmentEffort.averageWatts) &&
        Objects.equals(this.deviceWatts, detailedSegmentEffort.deviceWatts) &&
        Objects.equals(this.averageHeartrate, detailedSegmentEffort.averageHeartrate) &&
        Objects.equals(this.maxHeartrate, detailedSegmentEffort.maxHeartrate) &&
        Objects.equals(this.segment, detailedSegmentEffort.segment) &&
        Objects.equals(this.komRank, detailedSegmentEffort.komRank) &&
        Objects.equals(this.prRank, detailedSegmentEffort.prRank) &&
        Objects.equals(this.hidden, detailedSegmentEffort.hidden);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, activityId, elapsedTime, startDate, startDateLocal, distance, isKom, name, activity, athlete, movingTime, startIndex, endIndex, averageCadence, averageWatts, deviceWatts, averageHeartrate, maxHeartrate, segment, komRank, prRank, hidden);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedSegmentEffort {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startDateLocal: ").append(toIndentedString(startDateLocal)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    isKom: ").append(toIndentedString(isKom)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    activity: ").append(toIndentedString(activity)).append("\n");
    sb.append("    athlete: ").append(toIndentedString(athlete)).append("\n");
    sb.append("    movingTime: ").append(toIndentedString(movingTime)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
    sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
    sb.append("    averageCadence: ").append(toIndentedString(averageCadence)).append("\n");
    sb.append("    averageWatts: ").append(toIndentedString(averageWatts)).append("\n");
    sb.append("    deviceWatts: ").append(toIndentedString(deviceWatts)).append("\n");
    sb.append("    averageHeartrate: ").append(toIndentedString(averageHeartrate)).append("\n");
    sb.append("    maxHeartrate: ").append(toIndentedString(maxHeartrate)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
    sb.append("    komRank: ").append(toIndentedString(komRank)).append("\n");
    sb.append("    prRank: ").append(toIndentedString(prRank)).append("\n");
    sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
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

