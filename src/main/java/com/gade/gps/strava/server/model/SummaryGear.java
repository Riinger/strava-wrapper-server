package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SummaryGear
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummaryGear {

  private @Nullable String id;

  private @Nullable Integer resourceState;

  private @Nullable Boolean primary;

  private @Nullable String name;

  private @Nullable Float distance;

  public SummaryGear id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * The gear's unique identifier.
   * @return id
   */
  
  @Schema(name = "id", description = "The gear's unique identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public SummaryGear resourceState(@Nullable Integer resourceState) {
    this.resourceState = resourceState;
    return this;
  }

  /**
   * Resource state, indicates level of detail. Possible values: 2 -> \"summary\", 3 -> \"detail\"
   * @return resourceState
   */
  
  @Schema(name = "resource_state", description = "Resource state, indicates level of detail. Possible values: 2 -> \"summary\", 3 -> \"detail\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resource_state")
  public @Nullable Integer getResourceState() {
    return resourceState;
  }

  public void setResourceState(@Nullable Integer resourceState) {
    this.resourceState = resourceState;
  }

  public SummaryGear primary(@Nullable Boolean primary) {
    this.primary = primary;
    return this;
  }

  /**
   * Whether this gear's is the owner's default one.
   * @return primary
   */
  
  @Schema(name = "primary", description = "Whether this gear's is the owner's default one.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("primary")
  public @Nullable Boolean getPrimary() {
    return primary;
  }

  public void setPrimary(@Nullable Boolean primary) {
    this.primary = primary;
  }

  public SummaryGear name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The gear's name.
   * @return name
   */
  
  @Schema(name = "name", description = "The gear's name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public SummaryGear distance(@Nullable Float distance) {
    this.distance = distance;
    return this;
  }

  /**
   * The distance logged with this gear.
   * @return distance
   */
  
  @Schema(name = "distance", description = "The distance logged with this gear.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance")
  public @Nullable Float getDistance() {
    return distance;
  }

  public void setDistance(@Nullable Float distance) {
    this.distance = distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryGear summaryGear = (SummaryGear) o;
    return Objects.equals(this.id, summaryGear.id) &&
        Objects.equals(this.resourceState, summaryGear.resourceState) &&
        Objects.equals(this.primary, summaryGear.primary) &&
        Objects.equals(this.name, summaryGear.name) &&
        Objects.equals(this.distance, summaryGear.distance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, primary, name, distance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryGear {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceState: ").append(toIndentedString(resourceState)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
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

