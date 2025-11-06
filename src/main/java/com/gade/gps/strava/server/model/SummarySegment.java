package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.SummaryPRSegmentEffort;
import com.gade.gps.strava.server.model.SummarySegmentEffort;
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
 * SummarySegment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummarySegment {

  private @Nullable Long id;

  private @Nullable String name;

  /**
   * Gets or Sets activityType
   */
  public enum ActivityTypeEnum {
    RIDE("Ride"),
    
    RUN("Run");

    private final String value;

    ActivityTypeEnum(String value) {
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
    public static ActivityTypeEnum fromValue(String value) {
      for (ActivityTypeEnum b : ActivityTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable ActivityTypeEnum activityType;

  private @Nullable Float distance;

  private @Nullable Float averageGrade;

  private @Nullable Float maximumGrade;

  private @Nullable Float elevationHigh;

  private @Nullable Float elevationLow;

  @Valid
  private List<Float> startLatlng = new ArrayList<>();

  @Valid
  private List<Float> endLatlng = new ArrayList<>();

  private @Nullable Integer climbCategory;

  private @Nullable String city;

  private @Nullable String state;

  private @Nullable String country;

  private @Nullable Boolean _private;

  private @Nullable SummaryPRSegmentEffort athletePrEffort;

  private @Nullable SummarySegmentEffort athleteSegmentStats;

  public SummarySegment id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of this segment
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of this segment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public SummarySegment name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this segment
   * @return name
   */
  
  @Schema(name = "name", description = "The name of this segment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public SummarySegment activityType(@Nullable ActivityTypeEnum activityType) {
    this.activityType = activityType;
    return this;
  }

  /**
   * Get activityType
   * @return activityType
   */
  
  @Schema(name = "activity_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activity_type")
  public @Nullable ActivityTypeEnum getActivityType() {
    return activityType;
  }

  public void setActivityType(@Nullable ActivityTypeEnum activityType) {
    this.activityType = activityType;
  }

  public SummarySegment distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The segment's distance, in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The segment's distance, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public SummarySegment averageGrade(@Nullable Float averageGrade) {
    this.averageGrade = averageGrade;
    return this;
  }

  /**
   * The segment's average grade, in percents
   * @return averageGrade
   */
  
  @Schema(name = "average_grade", description = "The segment's average grade, in percents", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("average_grade")
  public @Nullable Float getAverageGrade() {
    return averageGrade;
  }

  public void setAverageGrade(@Nullable Float averageGrade) {
    this.averageGrade = averageGrade;
  }

  public SummarySegment maximumGrade(@Nullable Float maximumGrade) {
    this.maximumGrade = maximumGrade;
    return this;
  }

  /**
   * The segments's maximum grade, in percents
   * @return maximumGrade
   */
  
  @Schema(name = "maximum_grade", description = "The segments's maximum grade, in percents", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maximum_grade")
  public @Nullable Float getMaximumGrade() {
    return maximumGrade;
  }

  public void setMaximumGrade(@Nullable Float maximumGrade) {
    this.maximumGrade = maximumGrade;
  }

  public SummarySegment elevationHigh(@Nullable Float elevationHigh) {
    this.elevationHigh = elevationHigh;
    return this;
  }

  /**
   * The segments's highest elevation, in meters
   * @return elevationHigh
   */
  
  @Schema(name = "elevation_high", description = "The segments's highest elevation, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elevation_high")
  public @Nullable Float getElevationHigh() {
    return elevationHigh;
  }

  public void setElevationHigh(@Nullable Float elevationHigh) {
    this.elevationHigh = elevationHigh;
  }

  public SummarySegment elevationLow(@Nullable Float elevationLow) {
    this.elevationLow = elevationLow;
    return this;
  }

  /**
   * The segments's lowest elevation, in meters
   * @return elevationLow
   */
  
  @Schema(name = "elevation_low", description = "The segments's lowest elevation, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elevation_low")
  public @Nullable Float getElevationLow() {
    return elevationLow;
  }

  public void setElevationLow(@Nullable Float elevationLow) {
    this.elevationLow = elevationLow;
  }

  public SummarySegment startLatlng(List<Float> startLatlng) {
    this.startLatlng = startLatlng;
    return this;
  }

  public SummarySegment addStartLatlngItem(Float startLatlngItem) {
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

  public SummarySegment endLatlng(List<Float> endLatlng) {
    this.endLatlng = endLatlng;
    return this;
  }

  public SummarySegment addEndLatlngItem(Float endLatlngItem) {
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

  public SummarySegment climbCategory(@Nullable Integer climbCategory) {
    this.climbCategory = climbCategory;
    return this;
  }

  /**
   * The category of the climb [0, 5]. Higher is harder ie. 5 is Hors catégorie, 0 is uncategorized in climb_category.
   * @return climbCategory
   */
  
  @Schema(name = "climb_category", description = "The category of the climb [0, 5]. Higher is harder ie. 5 is Hors catégorie, 0 is uncategorized in climb_category.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("climb_category")
  public @Nullable Integer getClimbCategory() {
    return climbCategory;
  }

  public void setClimbCategory(@Nullable Integer climbCategory) {
    this.climbCategory = climbCategory;
  }

  public SummarySegment city(@Nullable String city) {
    this.city = city;
    return this;
  }

  /**
   * The segments's city.
   * @return city
   */
  
  @Schema(name = "city", description = "The segments's city.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public @Nullable String getCity() {
    return city;
  }

  public void setCity(@Nullable String city) {
    this.city = city;
  }

  public SummarySegment state(@Nullable String state) {
    this.state = state;
    return this;
  }

  /**
   * The segments's state or geographical region.
   * @return state
   */
  
  @Schema(name = "state", description = "The segments's state or geographical region.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public @Nullable String getState() {
    return state;
  }

  public void setState(@Nullable String state) {
    this.state = state;
  }

  public SummarySegment country(@Nullable String country) {
    this.country = country;
    return this;
  }

  /**
   * The segment's country.
   * @return country
   */
  
  @Schema(name = "country", description = "The segment's country.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("country")
  public @Nullable String getCountry() {
    return country;
  }

  public void setCountry(@Nullable String country) {
    this.country = country;
  }

  public SummarySegment _private(@Nullable Boolean _private) {
    this._private = _private;
    return this;
  }

  /**
   * Whether this segment is private.
   * @return _private
   */
  
  @Schema(name = "private", description = "Whether this segment is private.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("private")
  public @Nullable Boolean getPrivate() {
    return _private;
  }

  public void setPrivate(@Nullable Boolean _private) {
    this._private = _private;
  }

  public SummarySegment athletePrEffort(@Nullable SummaryPRSegmentEffort athletePrEffort) {
    this.athletePrEffort = athletePrEffort;
    return this;
  }

  /**
   * Get athletePrEffort
   * @return athletePrEffort
   */
  @Valid 
  @Schema(name = "athlete_pr_effort", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("athlete_pr_effort")
  public @Nullable SummaryPRSegmentEffort getAthletePrEffort() {
    return athletePrEffort;
  }

  public void setAthletePrEffort(@Nullable SummaryPRSegmentEffort athletePrEffort) {
    this.athletePrEffort = athletePrEffort;
  }

  public SummarySegment athleteSegmentStats(@Nullable SummarySegmentEffort athleteSegmentStats) {
    this.athleteSegmentStats = athleteSegmentStats;
    return this;
  }

  /**
   * Get athleteSegmentStats
   * @return athleteSegmentStats
   */
  @Valid 
  @Schema(name = "athlete_segment_stats", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("athlete_segment_stats")
  public @Nullable SummarySegmentEffort getAthleteSegmentStats() {
    return athleteSegmentStats;
  }

  public void setAthleteSegmentStats(@Nullable SummarySegmentEffort athleteSegmentStats) {
    this.athleteSegmentStats = athleteSegmentStats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummarySegment summarySegment = (SummarySegment) o;
    return Objects.equals(this.id, summarySegment.id) &&
        Objects.equals(this.name, summarySegment.name) &&
        Objects.equals(this.activityType, summarySegment.activityType) &&
        Objects.equals(this.distance, summarySegment.distance) &&
        Objects.equals(this.averageGrade, summarySegment.averageGrade) &&
        Objects.equals(this.maximumGrade, summarySegment.maximumGrade) &&
        Objects.equals(this.elevationHigh, summarySegment.elevationHigh) &&
        Objects.equals(this.elevationLow, summarySegment.elevationLow) &&
        Objects.equals(this.startLatlng, summarySegment.startLatlng) &&
        Objects.equals(this.endLatlng, summarySegment.endLatlng) &&
        Objects.equals(this.climbCategory, summarySegment.climbCategory) &&
        Objects.equals(this.city, summarySegment.city) &&
        Objects.equals(this.state, summarySegment.state) &&
        Objects.equals(this.country, summarySegment.country) &&
        Objects.equals(this._private, summarySegment._private) &&
        Objects.equals(this.athletePrEffort, summarySegment.athletePrEffort) &&
        Objects.equals(this.athleteSegmentStats, summarySegment.athleteSegmentStats);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, activityType, distance, averageGrade, maximumGrade, elevationHigh, elevationLow, startLatlng, endLatlng, climbCategory, city, state, country, _private, athletePrEffort, athleteSegmentStats);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummarySegment {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    activityType: ").append(toIndentedString(activityType)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    averageGrade: ").append(toIndentedString(averageGrade)).append("\n");
    sb.append("    maximumGrade: ").append(toIndentedString(maximumGrade)).append("\n");
    sb.append("    elevationHigh: ").append(toIndentedString(elevationHigh)).append("\n");
    sb.append("    elevationLow: ").append(toIndentedString(elevationLow)).append("\n");
    sb.append("    startLatlng: ").append(toIndentedString(startLatlng)).append("\n");
    sb.append("    endLatlng: ").append(toIndentedString(endLatlng)).append("\n");
    sb.append("    climbCategory: ").append(toIndentedString(climbCategory)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    _private: ").append(toIndentedString(_private)).append("\n");
    sb.append("    athletePrEffort: ").append(toIndentedString(athletePrEffort)).append("\n");
    sb.append("    athleteSegmentStats: ").append(toIndentedString(athleteSegmentStats)).append("\n");
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

