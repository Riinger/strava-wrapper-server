package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.ActivityType;
import com.gade.gps.strava.server.model.MetaAthlete;
import com.gade.gps.strava.server.model.PolylineMap;
import com.gade.gps.strava.server.model.SportType;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * SummaryActivity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummaryActivity {

  private @Nullable Long id;

  private @Nullable String externalId;

  private @Nullable Long uploadId;

  private @Nullable MetaAthlete athlete;

  private @Nullable String name;

  private @Nullable Float distance;

  private @Nullable Integer movingTime;

  private @Nullable Integer elapsedTime;

  private @Nullable Float totalElevationGain;

  private @Nullable Float elevHigh;

  private @Nullable Float elevLow;

  private @Nullable ActivityType type;

  private @Nullable SportType sportType;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDateLocal;

  private @Nullable String timezone;

  @Valid
  private List<Float> startLatlng = new ArrayList<>();

  @Valid
  private List<Float> endLatlng = new ArrayList<>();

  private @Nullable Integer achievementCount;

  private @Nullable Integer kudosCount;

  private @Nullable Integer commentCount;

  private @Nullable Integer athleteCount;

  private @Nullable Integer photoCount;

  private @Nullable Integer totalPhotoCount;

  private @Nullable PolylineMap map;

  private @Nullable String deviceName;

  private @Nullable Boolean trainer;

  private @Nullable Boolean commute;

  private @Nullable Boolean manual;

  private @Nullable Boolean _private;

  private @Nullable Boolean flagged;

  private @Nullable Integer workoutType;

  private @Nullable String uploadIdStr;

  private @Nullable Float averageSpeed;

  private @Nullable Float maxSpeed;

  private @Nullable Boolean hasKudoed;

  private @Nullable Boolean hideFromHome;

  private @Nullable String gearId;

  private @Nullable Float kilojoules;

  private @Nullable Float averageWatts;

  private @Nullable Boolean deviceWatts;

  private @Nullable Integer maxWatts;

  private @Nullable Integer weightedAverageWatts;

  private @Nullable Float averageHeartrate;

  private @Nullable Float averageCadence;

  public SummaryActivity id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the activity
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public SummaryActivity externalId(@Nullable String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * The identifier provided at upload time
   * @return externalId
   */
  
  @Schema(name = "external_id", description = "The identifier provided at upload time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("external_id")
  public @Nullable String getExternalId() {
    return externalId;
  }

  public void setExternalId(@Nullable String externalId) {
    this.externalId = externalId;
  }

  public SummaryActivity uploadId(@Nullable Long uploadId) {
    this.uploadId = uploadId;
    return this;
  }

  /**
   * The identifier of the upload that resulted in this activity
   * @return uploadId
   */
  
  @Schema(name = "upload_id", description = "The identifier of the upload that resulted in this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("upload_id")
  public @Nullable Long getUploadId() {
    return uploadId;
  }

  public void setUploadId(@Nullable Long uploadId) {
    this.uploadId = uploadId;
  }

  public SummaryActivity athlete(@Nullable MetaAthlete athlete) {
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

  public SummaryActivity name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the activity
   * @return name
   */
  
  @Schema(name = "name", description = "The name of the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public SummaryActivity distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The activity's distance, in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The activity's distance, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public SummaryActivity movingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
    return this;
  }

  /**
   * The activity's moving time, in seconds
   * @return movingTime
   */
  
  @Schema(name = "moving_time", description = "The activity's moving time, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving_time")
  public @Nullable Integer getMovingTime() {
    return movingTime;
  }

  public void setMovingTime(@Nullable Integer movingTime) {
    this.movingTime = movingTime;
  }

  public SummaryActivity elapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
    return this;
  }

  /**
   * The activity's elapsed time, in seconds
   * @return elapsedTime
   */
  
  @Schema(name = "elapsed_time", description = "The activity's elapsed time, in seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elapsed_time")
  public @Nullable Integer getElapsedTime() {
    return elapsedTime;
  }

  public void setElapsedTime(@Nullable Integer elapsedTime) {
    this.elapsedTime = elapsedTime;
  }

  public SummaryActivity totalElevationGain(@Nullable Float totalElevationGain) {
    this.totalElevationGain = totalElevationGain;
    return this;
  }

  /**
   * The activity's total elevation gain.
   * @return totalElevationGain
   */
  
  @Schema(name = "total_elevation_gain", description = "The activity's total elevation gain.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_elevation_gain")
  public @Nullable Float getTotalElevationGain() {
    return totalElevationGain;
  }

  public void setTotalElevationGain(@Nullable Float totalElevationGain) {
    this.totalElevationGain = totalElevationGain;
  }

  public SummaryActivity elevHigh(@Nullable Float elevHigh) {
    this.elevHigh = elevHigh;
    return this;
  }

  /**
   * The activity's highest elevation, in meters
   * @return elevHigh
   */
  
  @Schema(name = "elev_high", description = "The activity's highest elevation, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elev_high")
  public @Nullable Float getElevHigh() {
    return elevHigh;
  }

  public void setElevHigh(@Nullable Float elevHigh) {
    this.elevHigh = elevHigh;
  }

  public SummaryActivity elevLow(@Nullable Float elevLow) {
    this.elevLow = elevLow;
    return this;
  }

  /**
   * The activity's lowest elevation, in meters
   * @return elevLow
   */
  
  @Schema(name = "elev_low", description = "The activity's lowest elevation, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elev_low")
  public @Nullable Float getElevLow() {
    return elevLow;
  }

  public void setElevLow(@Nullable Float elevLow) {
    this.elevLow = elevLow;
  }

  public SummaryActivity type(@Nullable ActivityType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public @Nullable ActivityType getType() {
    return type;
  }

  public void setType(@Nullable ActivityType type) {
    this.type = type;
  }

  public SummaryActivity sportType(@Nullable SportType sportType) {
    this.sportType = sportType;
    return this;
  }

  /**
   * Get sportType
   * @return sportType
   */
  @Valid 
  @Schema(name = "sport_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sport_type")
  public @Nullable SportType getSportType() {
    return sportType;
  }

  public void setSportType(@Nullable SportType sportType) {
    this.sportType = sportType;
  }

  public SummaryActivity startDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The time at which the activity was started.
   * @return startDate
   */
  @Valid 
  @Schema(name = "start_date", description = "The time at which the activity was started.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date")
  public @Nullable OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public SummaryActivity startDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
    return this;
  }

  /**
   * The time at which the activity was started in the local timezone.
   * @return startDateLocal
   */
  @Valid 
  @Schema(name = "start_date_local", description = "The time at which the activity was started in the local timezone.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_date_local")
  public @Nullable OffsetDateTime getStartDateLocal() {
    return startDateLocal;
  }

  public void setStartDateLocal(@Nullable OffsetDateTime startDateLocal) {
    this.startDateLocal = startDateLocal;
  }

  public SummaryActivity timezone(@Nullable String timezone) {
    this.timezone = timezone;
    return this;
  }

  /**
   * The timezone of the activity
   * @return timezone
   */
  
  @Schema(name = "timezone", description = "The timezone of the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timezone")
  public @Nullable String getTimezone() {
    return timezone;
  }

  public void setTimezone(@Nullable String timezone) {
    this.timezone = timezone;
  }

  public SummaryActivity startLatlng(List<Float> startLatlng) {
    this.startLatlng = startLatlng;
    return this;
  }

  public SummaryActivity addStartLatlngItem(Float startLatlngItem) {
    if (this.startLatlng == null) {
      this.startLatlng = new ArrayList<>();
    }
    this.startLatlng.add(startLatlngItem);
    return this;
  }

  /**
   * A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.
   * @return startLatlng
   */
  @Size(min = 2, max = 2) 
  @Schema(name = "start_latlng", description = "A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("start_latlng")
  public List<Float> getStartLatlng() {
    return startLatlng;
  }

  public void setStartLatlng(List<Float> startLatlng) {
    this.startLatlng = startLatlng;
  }

  public SummaryActivity endLatlng(List<Float> endLatlng) {
    this.endLatlng = endLatlng;
    return this;
  }

  public SummaryActivity addEndLatlngItem(Float endLatlngItem) {
    if (this.endLatlng == null) {
      this.endLatlng = new ArrayList<>();
    }
    this.endLatlng.add(endLatlngItem);
    return this;
  }

  /**
   * A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.
   * @return endLatlng
   */
  @Size(min = 2, max = 2) 
  @Schema(name = "end_latlng", description = "A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("end_latlng")
  public List<Float> getEndLatlng() {
    return endLatlng;
  }

  public void setEndLatlng(List<Float> endLatlng) {
    this.endLatlng = endLatlng;
  }

  public SummaryActivity achievementCount(@Nullable Integer achievementCount) {
    this.achievementCount = achievementCount;
    return this;
  }

  /**
   * The number of achievements gained during this activity
   * @return achievementCount
   */
  
  @Schema(name = "achievement_count", description = "The number of achievements gained during this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("achievement_count")
  public @Nullable Integer getAchievementCount() {
    return achievementCount;
  }

  public void setAchievementCount(@Nullable Integer achievementCount) {
    this.achievementCount = achievementCount;
  }

  public SummaryActivity kudosCount(@Nullable Integer kudosCount) {
    this.kudosCount = kudosCount;
    return this;
  }

  /**
   * The number of kudos given for this activity
   * @return kudosCount
   */
  
  @Schema(name = "kudos_count", description = "The number of kudos given for this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kudos_count")
  public @Nullable Integer getKudosCount() {
    return kudosCount;
  }

  public void setKudosCount(@Nullable Integer kudosCount) {
    this.kudosCount = kudosCount;
  }

  public SummaryActivity commentCount(@Nullable Integer commentCount) {
    this.commentCount = commentCount;
    return this;
  }

  /**
   * The number of comments for this activity
   * @return commentCount
   */
  
  @Schema(name = "comment_count", description = "The number of comments for this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment_count")
  public @Nullable Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(@Nullable Integer commentCount) {
    this.commentCount = commentCount;
  }

  public SummaryActivity athleteCount(@Nullable Integer athleteCount) {
    this.athleteCount = athleteCount;
    return this;
  }

  /**
   * The number of athletes for taking part in a group activity
   * minimum: 1
   * @return athleteCount
   */
  @Min(1) 
  @Schema(name = "athlete_count", description = "The number of athletes for taking part in a group activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("athlete_count")
  public @Nullable Integer getAthleteCount() {
    return athleteCount;
  }

  public void setAthleteCount(@Nullable Integer athleteCount) {
    this.athleteCount = athleteCount;
  }

  public SummaryActivity photoCount(@Nullable Integer photoCount) {
    this.photoCount = photoCount;
    return this;
  }

  /**
   * The number of Instagram photos for this activity
   * @return photoCount
   */
  
  @Schema(name = "photo_count", description = "The number of Instagram photos for this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("photo_count")
  public @Nullable Integer getPhotoCount() {
    return photoCount;
  }

  public void setPhotoCount(@Nullable Integer photoCount) {
    this.photoCount = photoCount;
  }

  public SummaryActivity totalPhotoCount(@Nullable Integer totalPhotoCount) {
    this.totalPhotoCount = totalPhotoCount;
    return this;
  }

  /**
   * The number of Instagram and Strava photos for this activity
   * @return totalPhotoCount
   */
  
  @Schema(name = "total_photo_count", description = "The number of Instagram and Strava photos for this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total_photo_count")
  public @Nullable Integer getTotalPhotoCount() {
    return totalPhotoCount;
  }

  public void setTotalPhotoCount(@Nullable Integer totalPhotoCount) {
    this.totalPhotoCount = totalPhotoCount;
  }

  public SummaryActivity map(@Nullable PolylineMap map) {
    this.map = map;
    return this;
  }

  /**
   * Get map
   * @return map
   */
  @Valid 
  @Schema(name = "map", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("map")
  public @Nullable PolylineMap getMap() {
    return map;
  }

  public void setMap(@Nullable PolylineMap map) {
    this.map = map;
  }

  public SummaryActivity deviceName(@Nullable String deviceName) {
    this.deviceName = deviceName;
    return this;
  }

  /**
   * The name of the device used to record the activity
   * @return deviceName
   */
  
  @Schema(name = "device_name", description = "The name of the device used to record the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("device_name")
  public @Nullable String getDeviceName() {
    return deviceName;
  }

  public void setDeviceName(@Nullable String deviceName) {
    this.deviceName = deviceName;
  }

  public SummaryActivity trainer(@Nullable Boolean trainer) {
    this.trainer = trainer;
    return this;
  }

  /**
   * Whether this activity was recorded on a training machine
   * @return trainer
   */
  
  @Schema(name = "trainer", description = "Whether this activity was recorded on a training machine", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("trainer")
  public @Nullable Boolean getTrainer() {
    return trainer;
  }

  public void setTrainer(@Nullable Boolean trainer) {
    this.trainer = trainer;
  }

  public SummaryActivity commute(@Nullable Boolean commute) {
    this.commute = commute;
    return this;
  }

  /**
   * Whether this activity is a commute
   * @return commute
   */
  
  @Schema(name = "commute", description = "Whether this activity is a commute", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commute")
  public @Nullable Boolean getCommute() {
    return commute;
  }

  public void setCommute(@Nullable Boolean commute) {
    this.commute = commute;
  }

  public SummaryActivity manual(@Nullable Boolean manual) {
    this.manual = manual;
    return this;
  }

  /**
   * Whether this activity was created manually
   * @return manual
   */
  
  @Schema(name = "manual", description = "Whether this activity was created manually", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("manual")
  public @Nullable Boolean getManual() {
    return manual;
  }

  public void setManual(@Nullable Boolean manual) {
    this.manual = manual;
  }

  public SummaryActivity _private(@Nullable Boolean _private) {
    this._private = _private;
    return this;
  }

  /**
   * Whether this activity is private
   * @return _private
   */
  
  @Schema(name = "private", description = "Whether this activity is private", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("private")
  public @Nullable Boolean getPrivate() {
    return _private;
  }

  public void setPrivate(@Nullable Boolean _private) {
    this._private = _private;
  }

  public SummaryActivity flagged(@Nullable Boolean flagged) {
    this.flagged = flagged;
    return this;
  }

  /**
   * Whether this activity is flagged
   * @return flagged
   */
  
  @Schema(name = "flagged", description = "Whether this activity is flagged", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("flagged")
  public @Nullable Boolean getFlagged() {
    return flagged;
  }

  public void setFlagged(@Nullable Boolean flagged) {
    this.flagged = flagged;
  }

  public SummaryActivity workoutType(@Nullable Integer workoutType) {
    this.workoutType = workoutType;
    return this;
  }

  /**
   * The activity's workout type
   * @return workoutType
   */
  
  @Schema(name = "workout_type", description = "The activity's workout type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workout_type")
  public @Nullable Integer getWorkoutType() {
    return workoutType;
  }

  public void setWorkoutType(@Nullable Integer workoutType) {
    this.workoutType = workoutType;
  }

  public SummaryActivity uploadIdStr(@Nullable String uploadIdStr) {
    this.uploadIdStr = uploadIdStr;
    return this;
  }

  /**
   * The unique identifier of the upload in string format
   * @return uploadIdStr
   */
  
  @Schema(name = "upload_id_str", description = "The unique identifier of the upload in string format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("upload_id_str")
  public @Nullable String getUploadIdStr() {
    return uploadIdStr;
  }

  public void setUploadIdStr(@Nullable String uploadIdStr) {
    this.uploadIdStr = uploadIdStr;
  }

  public SummaryActivity averageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
    return this;
  }

  /**
   * The activity's average speed, in meters per second
   * @return averageSpeed
   */
  
  @Schema(name = "average_speed", description = "The activity's average speed, in meters per second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_speed")
  public @Nullable Float getAverageSpeed() {
    return averageSpeed;
  }

  public void setAverageSpeed(@Nullable Float averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  public SummaryActivity maxSpeed(@Nullable Float maxSpeed) {
    this.maxSpeed = maxSpeed;
    return this;
  }

  /**
   * The activity's max speed, in meters per second
   * @return maxSpeed
   */
  
  @Schema(name = "max_speed", description = "The activity's max speed, in meters per second", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max_speed")
  public @Nullable Float getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(@Nullable Float maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public SummaryActivity hasKudoed(@Nullable Boolean hasKudoed) {
    this.hasKudoed = hasKudoed;
    return this;
  }

  /**
   * Whether the logged-in athlete has kudoed this activity
   * @return hasKudoed
   */
  
  @Schema(name = "has_kudoed", description = "Whether the logged-in athlete has kudoed this activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("has_kudoed")
  public @Nullable Boolean getHasKudoed() {
    return hasKudoed;
  }

  public void setHasKudoed(@Nullable Boolean hasKudoed) {
    this.hasKudoed = hasKudoed;
  }

  public SummaryActivity hideFromHome(@Nullable Boolean hideFromHome) {
    this.hideFromHome = hideFromHome;
    return this;
  }

  /**
   * Whether the activity is muted
   * @return hideFromHome
   */
  
  @Schema(name = "hide_from_home", description = "Whether the activity is muted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hide_from_home")
  public @Nullable Boolean getHideFromHome() {
    return hideFromHome;
  }

  public void setHideFromHome(@Nullable Boolean hideFromHome) {
    this.hideFromHome = hideFromHome;
  }

  public SummaryActivity gearId(@Nullable String gearId) {
    this.gearId = gearId;
    return this;
  }

  /**
   * The id of the gear for the activity
   * @return gearId
   */
  
  @Schema(name = "gear_id", description = "The id of the gear for the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gear_id")
  public @Nullable String getGearId() {
    return gearId;
  }

  public void setGearId(@Nullable String gearId) {
    this.gearId = gearId;
  }

  public SummaryActivity kilojoules(@Nullable Float kilojoules) {
    this.kilojoules = kilojoules;
    return this;
  }

  /**
   * The total work done in kilojoules during this activity. Rides only
   * @return kilojoules
   */
  
  @Schema(name = "kilojoules", description = "The total work done in kilojoules during this activity. Rides only", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("kilojoules")
  public @Nullable Float getKilojoules() {
    return kilojoules;
  }

  public void setKilojoules(@Nullable Float kilojoules) {
    this.kilojoules = kilojoules;
  }

  public SummaryActivity averageWatts(@Nullable Float averageWatts) {
    this.averageWatts = averageWatts;
    return this;
  }

  /**
   * Average power output in watts during this activity. Rides only
   * @return averageWatts
   */
  
  @Schema(name = "average_watts", description = "Average power output in watts during this activity. Rides only", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_watts")
  public @Nullable Float getAverageWatts() {
    return averageWatts;
  }

  public void setAverageWatts(@Nullable Float averageWatts) {
    this.averageWatts = averageWatts;
  }

  public SummaryActivity deviceWatts(@Nullable Boolean deviceWatts) {
    this.deviceWatts = deviceWatts;
    return this;
  }

  /**
   * Whether the watts are from a power meter, false if estimated
   * @return deviceWatts
   */
  
  @Schema(name = "device_watts", description = "Whether the watts are from a power meter, false if estimated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("device_watts")
  public @Nullable Boolean getDeviceWatts() {
    return deviceWatts;
  }

  public void setDeviceWatts(@Nullable Boolean deviceWatts) {
    this.deviceWatts = deviceWatts;
  }

  public SummaryActivity maxWatts(@Nullable Integer maxWatts) {
    this.maxWatts = maxWatts;
    return this;
  }

  /**
   * Rides with power meter data only
   * @return maxWatts
   */
  
  @Schema(name = "max_watts", description = "Rides with power meter data only", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max_watts")
  public @Nullable Integer getMaxWatts() {
    return maxWatts;
  }

  public void setMaxWatts(@Nullable Integer maxWatts) {
    this.maxWatts = maxWatts;
  }

  public SummaryActivity weightedAverageWatts(@Nullable Integer weightedAverageWatts) {
    this.weightedAverageWatts = weightedAverageWatts;
    return this;
  }

  /**
   * Similar to Normalized Power. Rides with power meter data only
   * @return weightedAverageWatts
   */
  
  @Schema(name = "weighted_average_watts", description = "Similar to Normalized Power. Rides with power meter data only", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("weighted_average_watts")
  public @Nullable Integer getWeightedAverageWatts() {
    return weightedAverageWatts;
  }

  public void setWeightedAverageWatts(@Nullable Integer weightedAverageWatts) {
    this.weightedAverageWatts = weightedAverageWatts;
  }

  public SummaryActivity averageHeartrate(@Nullable Float averageHeartrate) {
    this.averageHeartrate = averageHeartrate;
    return this;
  }

  /**
   * Average HR
   * @return averageHeartrate
   */
  
  @Schema(name = "average_heartrate", description = "Average HR", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_heartrate")
  public @Nullable Float getAverageHeartrate() {
    return averageHeartrate;
  }

  public void setAverageHeartrate(@Nullable Float averageHeartrate) {
    this.averageHeartrate = averageHeartrate;
  }

  public SummaryActivity averageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
    return this;
  }

  /**
   * Average cadence
   * @return averageCadence
   */
  
  @Schema(name = "average_cadence", description = "Average cadence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_cadence")
  public @Nullable Float getAverageCadence() {
    return averageCadence;
  }

  public void setAverageCadence(@Nullable Float averageCadence) {
    this.averageCadence = averageCadence;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryActivity summaryActivity = (SummaryActivity) o;
    return Objects.equals(this.id, summaryActivity.id) &&
        Objects.equals(this.externalId, summaryActivity.externalId) &&
        Objects.equals(this.uploadId, summaryActivity.uploadId) &&
        Objects.equals(this.athlete, summaryActivity.athlete) &&
        Objects.equals(this.name, summaryActivity.name) &&
        Objects.equals(this.distance, summaryActivity.distance) &&
        Objects.equals(this.movingTime, summaryActivity.movingTime) &&
        Objects.equals(this.elapsedTime, summaryActivity.elapsedTime) &&
        Objects.equals(this.totalElevationGain, summaryActivity.totalElevationGain) &&
        Objects.equals(this.elevHigh, summaryActivity.elevHigh) &&
        Objects.equals(this.elevLow, summaryActivity.elevLow) &&
        Objects.equals(this.type, summaryActivity.type) &&
        Objects.equals(this.sportType, summaryActivity.sportType) &&
        Objects.equals(this.startDate, summaryActivity.startDate) &&
        Objects.equals(this.startDateLocal, summaryActivity.startDateLocal) &&
        Objects.equals(this.timezone, summaryActivity.timezone) &&
        Objects.equals(this.startLatlng, summaryActivity.startLatlng) &&
        Objects.equals(this.endLatlng, summaryActivity.endLatlng) &&
        Objects.equals(this.achievementCount, summaryActivity.achievementCount) &&
        Objects.equals(this.kudosCount, summaryActivity.kudosCount) &&
        Objects.equals(this.commentCount, summaryActivity.commentCount) &&
        Objects.equals(this.athleteCount, summaryActivity.athleteCount) &&
        Objects.equals(this.photoCount, summaryActivity.photoCount) &&
        Objects.equals(this.totalPhotoCount, summaryActivity.totalPhotoCount) &&
        Objects.equals(this.map, summaryActivity.map) &&
        Objects.equals(this.deviceName, summaryActivity.deviceName) &&
        Objects.equals(this.trainer, summaryActivity.trainer) &&
        Objects.equals(this.commute, summaryActivity.commute) &&
        Objects.equals(this.manual, summaryActivity.manual) &&
        Objects.equals(this._private, summaryActivity._private) &&
        Objects.equals(this.flagged, summaryActivity.flagged) &&
        Objects.equals(this.workoutType, summaryActivity.workoutType) &&
        Objects.equals(this.uploadIdStr, summaryActivity.uploadIdStr) &&
        Objects.equals(this.averageSpeed, summaryActivity.averageSpeed) &&
        Objects.equals(this.maxSpeed, summaryActivity.maxSpeed) &&
        Objects.equals(this.hasKudoed, summaryActivity.hasKudoed) &&
        Objects.equals(this.hideFromHome, summaryActivity.hideFromHome) &&
        Objects.equals(this.gearId, summaryActivity.gearId) &&
        Objects.equals(this.kilojoules, summaryActivity.kilojoules) &&
        Objects.equals(this.averageWatts, summaryActivity.averageWatts) &&
        Objects.equals(this.deviceWatts, summaryActivity.deviceWatts) &&
        Objects.equals(this.maxWatts, summaryActivity.maxWatts) &&
        Objects.equals(this.weightedAverageWatts, summaryActivity.weightedAverageWatts) &&
        Objects.equals(this.averageHeartrate, summaryActivity.averageHeartrate) &&
        Objects.equals(this.averageCadence, summaryActivity.averageCadence);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, externalId, uploadId, athlete, name, distance, movingTime, elapsedTime, totalElevationGain, elevHigh, elevLow, type, sportType, startDate, startDateLocal, timezone, startLatlng, endLatlng, achievementCount, kudosCount, commentCount, athleteCount, photoCount, totalPhotoCount, map, deviceName, trainer, commute, manual, _private, flagged, workoutType, uploadIdStr, averageSpeed, maxSpeed, hasKudoed, hideFromHome, gearId, kilojoules, averageWatts, deviceWatts, maxWatts, weightedAverageWatts, averageHeartrate, averageCadence);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryActivity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    externalId: ").append(toIndentedString(externalId)).append("\n");
    sb.append("    uploadId: ").append(toIndentedString(uploadId)).append("\n");
    sb.append("    athlete: ").append(toIndentedString(athlete)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    movingTime: ").append(toIndentedString(movingTime)).append("\n");
    sb.append("    elapsedTime: ").append(toIndentedString(elapsedTime)).append("\n");
    sb.append("    totalElevationGain: ").append(toIndentedString(totalElevationGain)).append("\n");
    sb.append("    elevHigh: ").append(toIndentedString(elevHigh)).append("\n");
    sb.append("    elevLow: ").append(toIndentedString(elevLow)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sportType: ").append(toIndentedString(sportType)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startDateLocal: ").append(toIndentedString(startDateLocal)).append("\n");
    sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
    sb.append("    startLatlng: ").append(toIndentedString(startLatlng)).append("\n");
    sb.append("    endLatlng: ").append(toIndentedString(endLatlng)).append("\n");
    sb.append("    achievementCount: ").append(toIndentedString(achievementCount)).append("\n");
    sb.append("    kudosCount: ").append(toIndentedString(kudosCount)).append("\n");
    sb.append("    commentCount: ").append(toIndentedString(commentCount)).append("\n");
    sb.append("    athleteCount: ").append(toIndentedString(athleteCount)).append("\n");
    sb.append("    photoCount: ").append(toIndentedString(photoCount)).append("\n");
    sb.append("    totalPhotoCount: ").append(toIndentedString(totalPhotoCount)).append("\n");
    sb.append("    map: ").append(toIndentedString(map)).append("\n");
    sb.append("    deviceName: ").append(toIndentedString(deviceName)).append("\n");
    sb.append("    trainer: ").append(toIndentedString(trainer)).append("\n");
    sb.append("    commute: ").append(toIndentedString(commute)).append("\n");
    sb.append("    manual: ").append(toIndentedString(manual)).append("\n");
    sb.append("    _private: ").append(toIndentedString(_private)).append("\n");
    sb.append("    flagged: ").append(toIndentedString(flagged)).append("\n");
    sb.append("    workoutType: ").append(toIndentedString(workoutType)).append("\n");
    sb.append("    uploadIdStr: ").append(toIndentedString(uploadIdStr)).append("\n");
    sb.append("    averageSpeed: ").append(toIndentedString(averageSpeed)).append("\n");
    sb.append("    maxSpeed: ").append(toIndentedString(maxSpeed)).append("\n");
    sb.append("    hasKudoed: ").append(toIndentedString(hasKudoed)).append("\n");
    sb.append("    hideFromHome: ").append(toIndentedString(hideFromHome)).append("\n");
    sb.append("    gearId: ").append(toIndentedString(gearId)).append("\n");
    sb.append("    kilojoules: ").append(toIndentedString(kilojoules)).append("\n");
    sb.append("    averageWatts: ").append(toIndentedString(averageWatts)).append("\n");
    sb.append("    deviceWatts: ").append(toIndentedString(deviceWatts)).append("\n");
    sb.append("    maxWatts: ").append(toIndentedString(maxWatts)).append("\n");
    sb.append("    weightedAverageWatts: ").append(toIndentedString(weightedAverageWatts)).append("\n");
    sb.append("    averageHeartrate: ").append(toIndentedString(averageHeartrate)).append("\n");
    sb.append("    averageCadence: ").append(toIndentedString(averageCadence)).append("\n");
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

