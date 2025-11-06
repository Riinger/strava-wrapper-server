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
 * DetailedGear
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class DetailedGear {

  private @Nullable String id;

  private @Nullable Integer resourceState;

  private @Nullable Boolean primary;

  private @Nullable String name;

  private @Nullable Float distance;

  private @Nullable String brandName;

  private @Nullable String modelName;

  private @Nullable Integer frameType;

  private @Nullable String description;

  public DetailedGear id(@Nullable String id) {
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

  public DetailedGear resourceState(@Nullable Integer resourceState) {
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

  public DetailedGear primary(@Nullable Boolean primary) {
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

  public DetailedGear name(@Nullable String name) {
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

  public DetailedGear distance(@Nullable Float distance) {
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

  public DetailedGear brandName(@Nullable String brandName) {
    this.brandName = brandName;
    return this;
  }

  /**
   * The gear's brand name.
   * @return brandName
   */
  
  @Schema(name = "brand_name", description = "The gear's brand name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("brand_name")
  public @Nullable String getBrandName() {
    return brandName;
  }

  public void setBrandName(@Nullable String brandName) {
    this.brandName = brandName;
  }

  public DetailedGear modelName(@Nullable String modelName) {
    this.modelName = modelName;
    return this;
  }

  /**
   * The gear's model name.
   * @return modelName
   */
  
  @Schema(name = "model_name", description = "The gear's model name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("model_name")
  public @Nullable String getModelName() {
    return modelName;
  }

  public void setModelName(@Nullable String modelName) {
    this.modelName = modelName;
  }

  public DetailedGear frameType(@Nullable Integer frameType) {
    this.frameType = frameType;
    return this;
  }

  /**
   * The gear's frame type (bike only).
   * @return frameType
   */
  
  @Schema(name = "frame_type", description = "The gear's frame type (bike only).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("frame_type")
  public @Nullable Integer getFrameType() {
    return frameType;
  }

  public void setFrameType(@Nullable Integer frameType) {
    this.frameType = frameType;
  }

  public DetailedGear description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * The gear's description.
   * @return description
   */
  
  @Schema(name = "description", description = "The gear's description.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedGear detailedGear = (DetailedGear) o;
    return Objects.equals(this.id, detailedGear.id) &&
        Objects.equals(this.resourceState, detailedGear.resourceState) &&
        Objects.equals(this.primary, detailedGear.primary) &&
        Objects.equals(this.name, detailedGear.name) &&
        Objects.equals(this.distance, detailedGear.distance) &&
        Objects.equals(this.brandName, detailedGear.brandName) &&
        Objects.equals(this.modelName, detailedGear.modelName) &&
        Objects.equals(this.frameType, detailedGear.frameType) &&
        Objects.equals(this.description, detailedGear.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, primary, name, distance, brandName, modelName, frameType, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedGear {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceState: ").append(toIndentedString(resourceState)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    brandName: ").append(toIndentedString(brandName)).append("\n");
    sb.append("    modelName: ").append(toIndentedString(modelName)).append("\n");
    sb.append("    frameType: ").append(toIndentedString(frameType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

