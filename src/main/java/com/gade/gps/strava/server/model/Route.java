package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.PolylineMap;
import com.gade.gps.strava.server.model.SummaryAthlete;
import com.gade.gps.strava.server.model.SummarySegment;
import com.gade.gps.strava.server.model.Waypoint;
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
 * Route
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Route {

  private @Nullable SummaryAthlete athlete;

  private @Nullable String description;

  private @Nullable Float distance;

  private @Nullable Float elevationGain;

  private @Nullable Long id;

  private @Nullable String idStr;

  private @Nullable PolylineMap map;

  private @Nullable String name;

  private @Nullable Boolean _private;

  private @Nullable Boolean starred;

  private @Nullable Integer timestamp;

  private @Nullable Integer type;

  private @Nullable Integer subType;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime updatedAt;

  private @Nullable Integer estimatedMovingTime;

  @Valid
  private List<@Valid SummarySegment> segments = new ArrayList<>();

  @Valid
  private List<@Valid Waypoint> waypoints = new ArrayList<>();

  public Route athlete(@Nullable SummaryAthlete athlete) {
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
  public @Nullable SummaryAthlete getAthlete() {
    return athlete;
  }

  public void setAthlete(@Nullable SummaryAthlete athlete) {
    this.athlete = athlete;
  }

  public Route description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the route
   * @return description
   */
  
  @Schema(name = "description", description = "The description of the route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public Route distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The route's distance, in meters
   * @return distance
   */
  
  @Schema(name = "distance", description = "The route's distance, in meters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  public Route elevationGain(@Nullable Float elevationGain) {
    this.elevationGain = elevationGain;
    return this;
  }

  /**
   * The route's elevation gain.
   * @return elevationGain
   */
  
  @Schema(name = "elevation_gain", description = "The route's elevation gain.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elevation_gain")
  public @Nullable Float getElevationGain() {
    return elevationGain;
  }

  public void setElevationGain(@Nullable Float elevationGain) {
    this.elevationGain = elevationGain;
  }

  public Route id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of this route
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of this route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public Route idStr(@Nullable String idStr) {
    this.idStr = idStr;
    return this;
  }

  /**
   * The unique identifier of the route in string format
   * @return idStr
   */
  
  @Schema(name = "id_str", description = "The unique identifier of the route in string format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id_str")
  public @Nullable String getIdStr() {
    return idStr;
  }

  public void setIdStr(@Nullable String idStr) {
    this.idStr = idStr;
  }

  public Route map(@Nullable PolylineMap map) {
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

  public Route name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of this route
   * @return name
   */
  
  @Schema(name = "name", description = "The name of this route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public Route _private(@Nullable Boolean _private) {
    this._private = _private;
    return this;
  }

  /**
   * Whether this route is private
   * @return _private
   */
  
  @Schema(name = "private", description = "Whether this route is private", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("private")
  public @Nullable Boolean getPrivate() {
    return _private;
  }

  public void setPrivate(@Nullable Boolean _private) {
    this._private = _private;
  }

  public Route starred(@Nullable Boolean starred) {
    this.starred = starred;
    return this;
  }

  /**
   * Whether this route is starred by the logged-in athlete
   * @return starred
   */
  
  @Schema(name = "starred", description = "Whether this route is starred by the logged-in athlete", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("starred")
  public @Nullable Boolean getStarred() {
    return starred;
  }

  public void setStarred(@Nullable Boolean starred) {
    this.starred = starred;
  }

  public Route timestamp(@Nullable Integer timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * An epoch timestamp of when the route was created
   * @return timestamp
   */
  
  @Schema(name = "timestamp", description = "An epoch timestamp of when the route was created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public @Nullable Integer getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@Nullable Integer timestamp) {
    this.timestamp = timestamp;
  }

  public Route type(@Nullable Integer type) {
    this.type = type;
    return this;
  }

  /**
   * This route's type (1 for ride, 2 for runs)
   * @return type
   */
  
  @Schema(name = "type", description = "This route's type (1 for ride, 2 for runs)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public @Nullable Integer getType() {
    return type;
  }

  public void setType(@Nullable Integer type) {
    this.type = type;
  }

  public Route subType(@Nullable Integer subType) {
    this.subType = subType;
    return this;
  }

  /**
   * This route's sub-type (1 for road, 2 for mountain bike, 3 for cross, 4 for trail, 5 for mixed)
   * @return subType
   */
  
  @Schema(name = "sub_type", description = "This route's sub-type (1 for road, 2 for mountain bike, 3 for cross, 4 for trail, 5 for mixed)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sub_type")
  public @Nullable Integer getSubType() {
    return subType;
  }

  public void setSubType(@Nullable Integer subType) {
    this.subType = subType;
  }

  public Route createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The time at which the route was created
   * @return createdAt
   */
  @Valid 
  @Schema(name = "created_at", description = "The time at which the route was created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Route updatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The time at which the route was last updated
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updated_at", description = "The time at which the route was last updated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updated_at")
  public @Nullable OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Route estimatedMovingTime(@Nullable Integer estimatedMovingTime) {
    this.estimatedMovingTime = estimatedMovingTime;
    return this;
  }

  /**
   * Estimated time in seconds for the authenticated athlete to complete route
   * @return estimatedMovingTime
   */
  
  @Schema(name = "estimated_moving_time", description = "Estimated time in seconds for the authenticated athlete to complete route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("estimated_moving_time")
  public @Nullable Integer getEstimatedMovingTime() {
    return estimatedMovingTime;
  }

  public void setEstimatedMovingTime(@Nullable Integer estimatedMovingTime) {
    this.estimatedMovingTime = estimatedMovingTime;
  }

  public Route segments(List<@Valid SummarySegment> segments) {
    this.segments = segments;
    return this;
  }

  public Route addSegmentsItem(SummarySegment segmentsItem) {
    if (this.segments == null) {
      this.segments = new ArrayList<>();
    }
    this.segments.add(segmentsItem);
    return this;
  }

  /**
   * The segments traversed by this route
   * @return segments
   */
  @Valid 
  @Schema(name = "segments", description = "The segments traversed by this route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("segments")
  public List<@Valid SummarySegment> getSegments() {
    return segments;
  }

  public void setSegments(List<@Valid SummarySegment> segments) {
    this.segments = segments;
  }

  public Route waypoints(List<@Valid Waypoint> waypoints) {
    this.waypoints = waypoints;
    return this;
  }

  public Route addWaypointsItem(Waypoint waypointsItem) {
    if (this.waypoints == null) {
      this.waypoints = new ArrayList<>();
    }
    this.waypoints.add(waypointsItem);
    return this;
  }

  /**
   * The custom waypoints along this route
   * @return waypoints
   */
  @Valid @Size(min = 0) 
  @Schema(name = "waypoints", description = "The custom waypoints along this route", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("waypoints")
  public List<@Valid Waypoint> getWaypoints() {
    return waypoints;
  }

  public void setWaypoints(List<@Valid Waypoint> waypoints) {
    this.waypoints = waypoints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(this.athlete, route.athlete) &&
        Objects.equals(this.description, route.description) &&
        Objects.equals(this.distance, route.distance) &&
        Objects.equals(this.elevationGain, route.elevationGain) &&
        Objects.equals(this.id, route.id) &&
        Objects.equals(this.idStr, route.idStr) &&
        Objects.equals(this.map, route.map) &&
        Objects.equals(this.name, route.name) &&
        Objects.equals(this._private, route._private) &&
        Objects.equals(this.starred, route.starred) &&
        Objects.equals(this.timestamp, route.timestamp) &&
        Objects.equals(this.type, route.type) &&
        Objects.equals(this.subType, route.subType) &&
        Objects.equals(this.createdAt, route.createdAt) &&
        Objects.equals(this.updatedAt, route.updatedAt) &&
        Objects.equals(this.estimatedMovingTime, route.estimatedMovingTime) &&
        Objects.equals(this.segments, route.segments) &&
        Objects.equals(this.waypoints, route.waypoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(athlete, description, distance, elevationGain, id, idStr, map, name, _private, starred, timestamp, type, subType, createdAt, updatedAt, estimatedMovingTime, segments, waypoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route {\n");
    sb.append("    athlete: ").append(toIndentedString(athlete)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    elevationGain: ").append(toIndentedString(elevationGain)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idStr: ").append(toIndentedString(idStr)).append("\n");
    sb.append("    map: ").append(toIndentedString(map)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    _private: ").append(toIndentedString(_private)).append("\n");
    sb.append("    starred: ").append(toIndentedString(starred)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    estimatedMovingTime: ").append(toIndentedString(estimatedMovingTime)).append("\n");
    sb.append("    segments: ").append(toIndentedString(segments)).append("\n");
    sb.append("    waypoints: ").append(toIndentedString(waypoints)).append("\n");
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

