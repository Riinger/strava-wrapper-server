package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.AltitudeStream;
import com.gade.gps.strava.server.model.CadenceStream;
import com.gade.gps.strava.server.model.DistanceStream;
import com.gade.gps.strava.server.model.HeartrateStream;
import com.gade.gps.strava.server.model.LatLngStream;
import com.gade.gps.strava.server.model.MovingStream;
import com.gade.gps.strava.server.model.PowerStream;
import com.gade.gps.strava.server.model.SmoothGradeStream;
import com.gade.gps.strava.server.model.SmoothVelocityStream;
import com.gade.gps.strava.server.model.TemperatureStream;
import com.gade.gps.strava.server.model.TimeStream;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * StreamSet
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class StreamSet {

  private @Nullable TimeStream time;

  private @Nullable DistanceStream distance;

  private @Nullable LatLngStream latlng;

  private @Nullable AltitudeStream altitude;

  private @Nullable SmoothVelocityStream velocitySmooth;

  private @Nullable HeartrateStream heartrate;

  private @Nullable CadenceStream cadence;

  private @Nullable PowerStream watts;

  private @Nullable TemperatureStream temp;

  private @Nullable MovingStream moving;

  private @Nullable SmoothGradeStream gradeSmooth;

  public StreamSet time(@Nullable TimeStream time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   */
  @Valid 
  @Schema(name = "time", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("time")
  public @Nullable TimeStream getTime() {
    return time;
  }

  public void setTime(@Nullable TimeStream time) {
    this.time = time;
  }

  public StreamSet distance(@Nullable DistanceStream distance) {
    this.distance = distance;
    return this;
  }

  /**
   * Get distance
   * @return distance
   */
  @Valid 
  @Schema(name = "distance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable DistanceStream getDistance() {
    return distance;
  }

  public void setDistance(@Nullable DistanceStream distance) {
    this.distance = distance;
  }

  public StreamSet latlng(@Nullable LatLngStream latlng) {
    this.latlng = latlng;
    return this;
  }

  /**
   * Get latlng
   * @return latlng
   */
  @Valid 
  @Schema(name = "latlng", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("latlng")
  public @Nullable LatLngStream getLatlng() {
    return latlng;
  }

  public void setLatlng(@Nullable LatLngStream latlng) {
    this.latlng = latlng;
  }

  public StreamSet altitude(@Nullable AltitudeStream altitude) {
    this.altitude = altitude;
    return this;
  }

  /**
   * Get altitude
   * @return altitude
   */
  @Valid 
  @Schema(name = "altitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("altitude")
  public @Nullable AltitudeStream getAltitude() {
    return altitude;
  }

  public void setAltitude(@Nullable AltitudeStream altitude) {
    this.altitude = altitude;
  }

  public StreamSet velocitySmooth(@Nullable SmoothVelocityStream velocitySmooth) {
    this.velocitySmooth = velocitySmooth;
    return this;
  }

  /**
   * Get velocitySmooth
   * @return velocitySmooth
   */
  @Valid 
  @Schema(name = "velocity_smooth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("velocity_smooth")
  public @Nullable SmoothVelocityStream getVelocitySmooth() {
    return velocitySmooth;
  }

  public void setVelocitySmooth(@Nullable SmoothVelocityStream velocitySmooth) {
    this.velocitySmooth = velocitySmooth;
  }

  public StreamSet heartrate(@Nullable HeartrateStream heartrate) {
    this.heartrate = heartrate;
    return this;
  }

  /**
   * Get heartrate
   * @return heartrate
   */
  @Valid 
  @Schema(name = "heartrate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("heartrate")
  public @Nullable HeartrateStream getHeartrate() {
    return heartrate;
  }

  public void setHeartrate(@Nullable HeartrateStream heartrate) {
    this.heartrate = heartrate;
  }

  public StreamSet cadence(@Nullable CadenceStream cadence) {
    this.cadence = cadence;
    return this;
  }

  /**
   * Get cadence
   * @return cadence
   */
  @Valid 
  @Schema(name = "cadence", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cadence")
  public @Nullable CadenceStream getCadence() {
    return cadence;
  }

  public void setCadence(@Nullable CadenceStream cadence) {
    this.cadence = cadence;
  }

  public StreamSet watts(@Nullable PowerStream watts) {
    this.watts = watts;
    return this;
  }

  /**
   * Get watts
   * @return watts
   */
  @Valid 
  @Schema(name = "watts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("watts")
  public @Nullable PowerStream getWatts() {
    return watts;
  }

  public void setWatts(@Nullable PowerStream watts) {
    this.watts = watts;
  }

  public StreamSet temp(@Nullable TemperatureStream temp) {
    this.temp = temp;
    return this;
  }

  /**
   * Get temp
   * @return temp
   */
  @Valid 
  @Schema(name = "temp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("temp")
  public @Nullable TemperatureStream getTemp() {
    return temp;
  }

  public void setTemp(@Nullable TemperatureStream temp) {
    this.temp = temp;
  }

  public StreamSet moving(@Nullable MovingStream moving) {
    this.moving = moving;
    return this;
  }

  /**
   * Get moving
   * @return moving
   */
  @Valid 
  @Schema(name = "moving", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("moving")
  public @Nullable MovingStream getMoving() {
    return moving;
  }

  public void setMoving(@Nullable MovingStream moving) {
    this.moving = moving;
  }

  public StreamSet gradeSmooth(@Nullable SmoothGradeStream gradeSmooth) {
    this.gradeSmooth = gradeSmooth;
    return this;
  }

  /**
   * Get gradeSmooth
   * @return gradeSmooth
   */
  @Valid 
  @Schema(name = "grade_smooth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("grade_smooth")
  public @Nullable SmoothGradeStream getGradeSmooth() {
    return gradeSmooth;
  }

  public void setGradeSmooth(@Nullable SmoothGradeStream gradeSmooth) {
    this.gradeSmooth = gradeSmooth;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StreamSet streamSet = (StreamSet) o;
    return Objects.equals(this.time, streamSet.time) &&
        Objects.equals(this.distance, streamSet.distance) &&
        Objects.equals(this.latlng, streamSet.latlng) &&
        Objects.equals(this.altitude, streamSet.altitude) &&
        Objects.equals(this.velocitySmooth, streamSet.velocitySmooth) &&
        Objects.equals(this.heartrate, streamSet.heartrate) &&
        Objects.equals(this.cadence, streamSet.cadence) &&
        Objects.equals(this.watts, streamSet.watts) &&
        Objects.equals(this.temp, streamSet.temp) &&
        Objects.equals(this.moving, streamSet.moving) &&
        Objects.equals(this.gradeSmooth, streamSet.gradeSmooth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(time, distance, latlng, altitude, velocitySmooth, heartrate, cadence, watts, temp, moving, gradeSmooth);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StreamSet {\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    latlng: ").append(toIndentedString(latlng)).append("\n");
    sb.append("    altitude: ").append(toIndentedString(altitude)).append("\n");
    sb.append("    velocitySmooth: ").append(toIndentedString(velocitySmooth)).append("\n");
    sb.append("    heartrate: ").append(toIndentedString(heartrate)).append("\n");
    sb.append("    cadence: ").append(toIndentedString(cadence)).append("\n");
    sb.append("    watts: ").append(toIndentedString(watts)).append("\n");
    sb.append("    temp: ").append(toIndentedString(temp)).append("\n");
    sb.append("    moving: ").append(toIndentedString(moving)).append("\n");
    sb.append("    gradeSmooth: ").append(toIndentedString(gradeSmooth)).append("\n");
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

