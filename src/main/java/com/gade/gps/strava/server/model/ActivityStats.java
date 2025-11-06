package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.ActivityTotal;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A set of rolled-up statistics and totals for an athlete
 */

@Schema(name = "ActivityStats", description = "A set of rolled-up statistics and totals for an athlete")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class ActivityStats {

  private @Nullable Double biggestRideDistance;

  private @Nullable Double biggestClimbElevationGain;

  private @Nullable ActivityTotal recentRideTotals;

  private @Nullable ActivityTotal recentRunTotals;

  private @Nullable ActivityTotal recentSwimTotals;

  private @Nullable ActivityTotal ytdRideTotals;

  private @Nullable ActivityTotal ytdRunTotals;

  private @Nullable ActivityTotal ytdSwimTotals;

  private @Nullable ActivityTotal allRideTotals;

  private @Nullable ActivityTotal allRunTotals;

  private @Nullable ActivityTotal allSwimTotals;

  public ActivityStats biggestRideDistance(@Nullable Double biggestRideDistance) {
    this.biggestRideDistance = biggestRideDistance;
    return this;
  }

  /**
   * The longest distance ridden by the athlete.
   * @return biggestRideDistance
   */
  
  @Schema(name = "biggest_ride_distance", description = "The longest distance ridden by the athlete.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("biggest_ride_distance")
  public @Nullable Double getBiggestRideDistance() {
    return biggestRideDistance;
  }

  public void setBiggestRideDistance(@Nullable Double biggestRideDistance) {
    this.biggestRideDistance = biggestRideDistance;
  }

  public ActivityStats biggestClimbElevationGain(@Nullable Double biggestClimbElevationGain) {
    this.biggestClimbElevationGain = biggestClimbElevationGain;
    return this;
  }

  /**
   * The highest climb ridden by the athlete.
   * @return biggestClimbElevationGain
   */
  
  @Schema(name = "biggest_climb_elevation_gain", description = "The highest climb ridden by the athlete.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("biggest_climb_elevation_gain")
  public @Nullable Double getBiggestClimbElevationGain() {
    return biggestClimbElevationGain;
  }

  public void setBiggestClimbElevationGain(@Nullable Double biggestClimbElevationGain) {
    this.biggestClimbElevationGain = biggestClimbElevationGain;
  }

  public ActivityStats recentRideTotals(@Nullable ActivityTotal recentRideTotals) {
    this.recentRideTotals = recentRideTotals;
    return this;
  }

  /**
   * Get recentRideTotals
   * @return recentRideTotals
   */
  @Valid 
  @Schema(name = "recent_ride_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recent_ride_totals")
  public @Nullable ActivityTotal getRecentRideTotals() {
    return recentRideTotals;
  }

  public void setRecentRideTotals(@Nullable ActivityTotal recentRideTotals) {
    this.recentRideTotals = recentRideTotals;
  }

  public ActivityStats recentRunTotals(@Nullable ActivityTotal recentRunTotals) {
    this.recentRunTotals = recentRunTotals;
    return this;
  }

  /**
   * Get recentRunTotals
   * @return recentRunTotals
   */
  @Valid 
  @Schema(name = "recent_run_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recent_run_totals")
  public @Nullable ActivityTotal getRecentRunTotals() {
    return recentRunTotals;
  }

  public void setRecentRunTotals(@Nullable ActivityTotal recentRunTotals) {
    this.recentRunTotals = recentRunTotals;
  }

  public ActivityStats recentSwimTotals(@Nullable ActivityTotal recentSwimTotals) {
    this.recentSwimTotals = recentSwimTotals;
    return this;
  }

  /**
   * Get recentSwimTotals
   * @return recentSwimTotals
   */
  @Valid 
  @Schema(name = "recent_swim_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recent_swim_totals")
  public @Nullable ActivityTotal getRecentSwimTotals() {
    return recentSwimTotals;
  }

  public void setRecentSwimTotals(@Nullable ActivityTotal recentSwimTotals) {
    this.recentSwimTotals = recentSwimTotals;
  }

  public ActivityStats ytdRideTotals(@Nullable ActivityTotal ytdRideTotals) {
    this.ytdRideTotals = ytdRideTotals;
    return this;
  }

  /**
   * Get ytdRideTotals
   * @return ytdRideTotals
   */
  @Valid 
  @Schema(name = "ytd_ride_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ytd_ride_totals")
  public @Nullable ActivityTotal getYtdRideTotals() {
    return ytdRideTotals;
  }

  public void setYtdRideTotals(@Nullable ActivityTotal ytdRideTotals) {
    this.ytdRideTotals = ytdRideTotals;
  }

  public ActivityStats ytdRunTotals(@Nullable ActivityTotal ytdRunTotals) {
    this.ytdRunTotals = ytdRunTotals;
    return this;
  }

  /**
   * Get ytdRunTotals
   * @return ytdRunTotals
   */
  @Valid 
  @Schema(name = "ytd_run_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ytd_run_totals")
  public @Nullable ActivityTotal getYtdRunTotals() {
    return ytdRunTotals;
  }

  public void setYtdRunTotals(@Nullable ActivityTotal ytdRunTotals) {
    this.ytdRunTotals = ytdRunTotals;
  }

  public ActivityStats ytdSwimTotals(@Nullable ActivityTotal ytdSwimTotals) {
    this.ytdSwimTotals = ytdSwimTotals;
    return this;
  }

  /**
   * Get ytdSwimTotals
   * @return ytdSwimTotals
   */
  @Valid 
  @Schema(name = "ytd_swim_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ytd_swim_totals")
  public @Nullable ActivityTotal getYtdSwimTotals() {
    return ytdSwimTotals;
  }

  public void setYtdSwimTotals(@Nullable ActivityTotal ytdSwimTotals) {
    this.ytdSwimTotals = ytdSwimTotals;
  }

  public ActivityStats allRideTotals(@Nullable ActivityTotal allRideTotals) {
    this.allRideTotals = allRideTotals;
    return this;
  }

  /**
   * Get allRideTotals
   * @return allRideTotals
   */
  @Valid 
  @Schema(name = "all_ride_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("all_ride_totals")
  public @Nullable ActivityTotal getAllRideTotals() {
    return allRideTotals;
  }

  public void setAllRideTotals(@Nullable ActivityTotal allRideTotals) {
    this.allRideTotals = allRideTotals;
  }

  public ActivityStats allRunTotals(@Nullable ActivityTotal allRunTotals) {
    this.allRunTotals = allRunTotals;
    return this;
  }

  /**
   * Get allRunTotals
   * @return allRunTotals
   */
  @Valid 
  @Schema(name = "all_run_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("all_run_totals")
  public @Nullable ActivityTotal getAllRunTotals() {
    return allRunTotals;
  }

  public void setAllRunTotals(@Nullable ActivityTotal allRunTotals) {
    this.allRunTotals = allRunTotals;
  }

  public ActivityStats allSwimTotals(@Nullable ActivityTotal allSwimTotals) {
    this.allSwimTotals = allSwimTotals;
    return this;
  }

  /**
   * Get allSwimTotals
   * @return allSwimTotals
   */
  @Valid 
  @Schema(name = "all_swim_totals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("all_swim_totals")
  public @Nullable ActivityTotal getAllSwimTotals() {
    return allSwimTotals;
  }

  public void setAllSwimTotals(@Nullable ActivityTotal allSwimTotals) {
    this.allSwimTotals = allSwimTotals;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityStats activityStats = (ActivityStats) o;
    return Objects.equals(this.biggestRideDistance, activityStats.biggestRideDistance) &&
        Objects.equals(this.biggestClimbElevationGain, activityStats.biggestClimbElevationGain) &&
        Objects.equals(this.recentRideTotals, activityStats.recentRideTotals) &&
        Objects.equals(this.recentRunTotals, activityStats.recentRunTotals) &&
        Objects.equals(this.recentSwimTotals, activityStats.recentSwimTotals) &&
        Objects.equals(this.ytdRideTotals, activityStats.ytdRideTotals) &&
        Objects.equals(this.ytdRunTotals, activityStats.ytdRunTotals) &&
        Objects.equals(this.ytdSwimTotals, activityStats.ytdSwimTotals) &&
        Objects.equals(this.allRideTotals, activityStats.allRideTotals) &&
        Objects.equals(this.allRunTotals, activityStats.allRunTotals) &&
        Objects.equals(this.allSwimTotals, activityStats.allSwimTotals);
  }

  @Override
  public int hashCode() {
    return Objects.hash(biggestRideDistance, biggestClimbElevationGain, recentRideTotals, recentRunTotals, recentSwimTotals, ytdRideTotals, ytdRunTotals, ytdSwimTotals, allRideTotals, allRunTotals, allSwimTotals);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityStats {\n");
    sb.append("    biggestRideDistance: ").append(toIndentedString(biggestRideDistance)).append("\n");
    sb.append("    biggestClimbElevationGain: ").append(toIndentedString(biggestClimbElevationGain)).append("\n");
    sb.append("    recentRideTotals: ").append(toIndentedString(recentRideTotals)).append("\n");
    sb.append("    recentRunTotals: ").append(toIndentedString(recentRunTotals)).append("\n");
    sb.append("    recentSwimTotals: ").append(toIndentedString(recentSwimTotals)).append("\n");
    sb.append("    ytdRideTotals: ").append(toIndentedString(ytdRideTotals)).append("\n");
    sb.append("    ytdRunTotals: ").append(toIndentedString(ytdRunTotals)).append("\n");
    sb.append("    ytdSwimTotals: ").append(toIndentedString(ytdSwimTotals)).append("\n");
    sb.append("    allRideTotals: ").append(toIndentedString(allRideTotals)).append("\n");
    sb.append("    allRunTotals: ").append(toIndentedString(allRunTotals)).append("\n");
    sb.append("    allSwimTotals: ").append(toIndentedString(allSwimTotals)).append("\n");
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

