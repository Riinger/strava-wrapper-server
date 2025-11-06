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
 * MetaClub
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class MetaClub {

  private @Nullable Long id;

  private @Nullable Integer resourceState;

  private @Nullable String name;

  public MetaClub id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The club's unique identifier.
   * @return id
   */
  
  @Schema(name = "id", description = "The club's unique identifier.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public MetaClub resourceState(@Nullable Integer resourceState) {
    this.resourceState = resourceState;
    return this;
  }

  /**
   * Resource state, indicates level of detail. Possible values: 1 -> \"meta\", 2 -> \"summary\", 3 -> \"detail\"
   * @return resourceState
   */
  
  @Schema(name = "resource_state", description = "Resource state, indicates level of detail. Possible values: 1 -> \"meta\", 2 -> \"summary\", 3 -> \"detail\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resource_state")
  public @Nullable Integer getResourceState() {
    return resourceState;
  }

  public void setResourceState(@Nullable Integer resourceState) {
    this.resourceState = resourceState;
  }

  public MetaClub name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * The club's name.
   * @return name
   */
  
  @Schema(name = "name", description = "The club's name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetaClub metaClub = (MetaClub) o;
    return Objects.equals(this.id, metaClub.id) &&
        Objects.equals(this.resourceState, metaClub.resourceState) &&
        Objects.equals(this.name, metaClub.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetaClub {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceState: ").append(toIndentedString(resourceState)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

