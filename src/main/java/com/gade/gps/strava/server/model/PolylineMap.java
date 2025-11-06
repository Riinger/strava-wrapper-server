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
 * PolylineMap
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class PolylineMap {

  private @Nullable String id;

  private @Nullable String polyline;

  private @Nullable String summaryPolyline;

  public PolylineMap id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of the map
   * @return id
   */
  
  @Schema(name = "id", description = "The identifier of the map", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public PolylineMap polyline(@Nullable String polyline) {
    this.polyline = polyline;
    return this;
  }

  /**
   * The polyline of the map, only returned on detailed representation of an object
   * @return polyline
   */
  
  @Schema(name = "polyline", description = "The polyline of the map, only returned on detailed representation of an object", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("polyline")
  public @Nullable String getPolyline() {
    return polyline;
  }

  public void setPolyline(@Nullable String polyline) {
    this.polyline = polyline;
  }

  public PolylineMap summaryPolyline(@Nullable String summaryPolyline) {
    this.summaryPolyline = summaryPolyline;
    return this;
  }

  /**
   * The summary polyline of the map
   * @return summaryPolyline
   */
  
  @Schema(name = "summary_polyline", description = "The summary polyline of the map", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("summary_polyline")
  public @Nullable String getSummaryPolyline() {
    return summaryPolyline;
  }

  public void setSummaryPolyline(@Nullable String summaryPolyline) {
    this.summaryPolyline = summaryPolyline;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolylineMap polylineMap = (PolylineMap) o;
    return Objects.equals(this.id, polylineMap.id) &&
        Objects.equals(this.polyline, polylineMap.polyline) &&
        Objects.equals(this.summaryPolyline, polylineMap.summaryPolyline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, polyline, summaryPolyline);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolylineMap {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    polyline: ").append(toIndentedString(polyline)).append("\n");
    sb.append("    summaryPolyline: ").append(toIndentedString(summaryPolyline)).append("\n");
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

