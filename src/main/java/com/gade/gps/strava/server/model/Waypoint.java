package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Waypoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Waypoint {

  @Valid
  private List<Float> latlng = new ArrayList<>();

  @Valid
  private List<Float> targetLatlng = new ArrayList<>();

  @Valid
  private List<String> categories = new ArrayList<>();

  private @Nullable String title;

  private @Nullable String description;

  private @Nullable Integer distanceIntoRoute;

  public Waypoint latlng(List<Float> latlng) {
    this.latlng = latlng;
    return this;
  }

  public Waypoint addLatlngItem(Float latlngItem) {
    if (this.latlng == null) {
      this.latlng = new ArrayList<>();
    }
    this.latlng.add(latlngItem);
    return this;
  }

  /**
   * A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.
   * @return latlng
   */
  @Size(min = 2, max = 2) 
  @Schema(name = "latlng", description = "A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("latlng")
  public List<Float> getLatlng() {
    return latlng;
  }

  public void setLatlng(List<Float> latlng) {
    this.latlng = latlng;
  }

  public Waypoint targetLatlng(List<Float> targetLatlng) {
    this.targetLatlng = targetLatlng;
    return this;
  }

  public Waypoint addTargetLatlngItem(Float targetLatlngItem) {
    if (this.targetLatlng == null) {
      this.targetLatlng = new ArrayList<>();
    }
    this.targetLatlng.add(targetLatlngItem);
    return this;
  }

  /**
   * A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.
   * @return targetLatlng
   */
  @Size(min = 2, max = 2) 
  @Schema(name = "target_latlng", description = "A pair of latitude/longitude coordinates, represented as an array of 2 floating point numbers.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("target_latlng")
  public List<Float> getTargetLatlng() {
    return targetLatlng;
  }

  public void setTargetLatlng(List<Float> targetLatlng) {
    this.targetLatlng = targetLatlng;
  }

  public Waypoint categories(List<String> categories) {
    this.categories = categories;
    return this;
  }

  public Waypoint addCategoriesItem(String categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Categories that the waypoint belongs to
   * @return categories
   */
  @Size(min = 0) 
  @Schema(name = "categories", description = "Categories that the waypoint belongs to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categories")
  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public Waypoint title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * A title for the waypoint
   * @return title
   */
  
  @Schema(name = "title", description = "A title for the waypoint", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public Waypoint description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * A description of the waypoint (optional)
   * @return description
   */
  
  @Schema(name = "description", description = "A description of the waypoint (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public Waypoint distanceIntoRoute(@Nullable Integer distanceIntoRoute) {
    this.distanceIntoRoute = distanceIntoRoute;
    return this;
  }

  /**
   * The number meters along the route that the waypoint is located
   * @return distanceIntoRoute
   */
  
  @Schema(name = "distance_into_route", description = "The number meters along the route that the waypoint is located", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("distance_into_route")
  public @Nullable Integer getDistanceIntoRoute() {
    return distanceIntoRoute;
  }

  public void setDistanceIntoRoute(@Nullable Integer distanceIntoRoute) {
    this.distanceIntoRoute = distanceIntoRoute;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Waypoint waypoint = (Waypoint) o;
    return Objects.equals(this.latlng, waypoint.latlng) &&
        Objects.equals(this.targetLatlng, waypoint.targetLatlng) &&
        Objects.equals(this.categories, waypoint.categories) &&
        Objects.equals(this.title, waypoint.title) &&
        Objects.equals(this.description, waypoint.description) &&
        Objects.equals(this.distanceIntoRoute, waypoint.distanceIntoRoute);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latlng, targetLatlng, categories, title, description, distanceIntoRoute);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Waypoint {\n");
    sb.append("    latlng: ").append(toIndentedString(latlng)).append("\n");
    sb.append("    targetLatlng: ").append(toIndentedString(targetLatlng)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    distanceIntoRoute: ").append(toIndentedString(distanceIntoRoute)).append("\n");
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

