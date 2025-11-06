package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.PhotosSummaryPrimary;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PhotosSummary
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class PhotosSummary {

  private @Nullable Integer count;

  private @Nullable PhotosSummaryPrimary primary;

  public PhotosSummary count(@Nullable Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The number of photos
   * @return count
   */
  
  @Schema(name = "count", description = "The number of photos", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public @Nullable Integer getCount() {
    return count;
  }

  public void setCount(@Nullable Integer count) {
    this.count = count;
  }

  public PhotosSummary primary(@Nullable PhotosSummaryPrimary primary) {
    this.primary = primary;
    return this;
  }

  /**
   * Get primary
   * @return primary
   */
  @Valid 
  @Schema(name = "primary", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("primary")
  public @Nullable PhotosSummaryPrimary getPrimary() {
    return primary;
  }

  public void setPrimary(@Nullable PhotosSummaryPrimary primary) {
    this.primary = primary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhotosSummary photosSummary = (PhotosSummary) o;
    return Objects.equals(this.count, photosSummary.count) &&
        Objects.equals(this.primary, photosSummary.primary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, primary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhotosSummary {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
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

