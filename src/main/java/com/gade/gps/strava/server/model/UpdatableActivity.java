package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.ActivityType;
import com.gade.gps.strava.server.model.SportType;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdatableActivity
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class UpdatableActivity {

  private @Nullable Boolean commute;

  private @Nullable Boolean trainer;

  private @Nullable Boolean hideFromHome;

  private @Nullable String description;

  private @Nullable String name;

  private @Nullable ActivityType type;

  private @Nullable SportType sportType;

  private @Nullable String gearId;

  public UpdatableActivity commute(@Nullable Boolean commute) {
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

  public UpdatableActivity trainer(@Nullable Boolean trainer) {
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

  public UpdatableActivity hideFromHome(@Nullable Boolean hideFromHome) {
    this.hideFromHome = hideFromHome;
    return this;
  }

  /**
   * Whether this activity is muted
   * @return hideFromHome
   */
  
  @Schema(name = "hide_from_home", description = "Whether this activity is muted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hide_from_home")
  public @Nullable Boolean getHideFromHome() {
    return hideFromHome;
  }

  public void setHideFromHome(@Nullable Boolean hideFromHome) {
    this.hideFromHome = hideFromHome;
  }

  public UpdatableActivity description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the activity
   * @return description
   */
  
  @Schema(name = "description", description = "The description of the activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public UpdatableActivity name(@Nullable String name) {
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

  public UpdatableActivity type(@Nullable ActivityType type) {
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

  public UpdatableActivity sportType(@Nullable SportType sportType) {
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

  public UpdatableActivity gearId(@Nullable String gearId) {
    this.gearId = gearId;
    return this;
  }

  /**
   * Identifier for the gear associated with the activity. ‘none’ clears gear from activity
   * @return gearId
   */
  
  @Schema(name = "gear_id", description = "Identifier for the gear associated with the activity. ‘none’ clears gear from activity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gear_id")
  public @Nullable String getGearId() {
    return gearId;
  }

  public void setGearId(@Nullable String gearId) {
    this.gearId = gearId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatableActivity updatableActivity = (UpdatableActivity) o;
    return Objects.equals(this.commute, updatableActivity.commute) &&
        Objects.equals(this.trainer, updatableActivity.trainer) &&
        Objects.equals(this.hideFromHome, updatableActivity.hideFromHome) &&
        Objects.equals(this.description, updatableActivity.description) &&
        Objects.equals(this.name, updatableActivity.name) &&
        Objects.equals(this.type, updatableActivity.type) &&
        Objects.equals(this.sportType, updatableActivity.sportType) &&
        Objects.equals(this.gearId, updatableActivity.gearId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commute, trainer, hideFromHome, description, name, type, sportType, gearId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatableActivity {\n");
    sb.append("    commute: ").append(toIndentedString(commute)).append("\n");
    sb.append("    trainer: ").append(toIndentedString(trainer)).append("\n");
    sb.append("    hideFromHome: ").append(toIndentedString(hideFromHome)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sportType: ").append(toIndentedString(sportType)).append("\n");
    sb.append("    gearId: ").append(toIndentedString(gearId)).append("\n");
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

