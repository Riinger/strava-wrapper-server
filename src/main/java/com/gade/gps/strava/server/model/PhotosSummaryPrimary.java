package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.HashMap;
import java.util.Map;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PhotosSummaryPrimary
 */

@JsonTypeName("PhotosSummary_primary")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class PhotosSummaryPrimary {

  private @Nullable Long id;

  private @Nullable Integer source;

  private @Nullable String uniqueId;

  @Valid
  private Map<String, String> urls = new HashMap<>();

  public PhotosSummaryPrimary id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public PhotosSummaryPrimary source(@Nullable Integer source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   */
  
  @Schema(name = "source", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("source")
  public @Nullable Integer getSource() {
    return source;
  }

  public void setSource(@Nullable Integer source) {
    this.source = source;
  }

  public PhotosSummaryPrimary uniqueId(@Nullable String uniqueId) {
    this.uniqueId = uniqueId;
    return this;
  }

  /**
   * Get uniqueId
   * @return uniqueId
   */
  
  @Schema(name = "unique_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("unique_id")
  public @Nullable String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(@Nullable String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public PhotosSummaryPrimary urls(Map<String, String> urls) {
    this.urls = urls;
    return this;
  }

  public PhotosSummaryPrimary putUrlsItem(String key, String urlsItem) {
    if (this.urls == null) {
      this.urls = new HashMap<>();
    }
    this.urls.put(key, urlsItem);
    return this;
  }

  /**
   * Get urls
   * @return urls
   */
  
  @Schema(name = "urls", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("urls")
  public Map<String, String> getUrls() {
    return urls;
  }

  public void setUrls(Map<String, String> urls) {
    this.urls = urls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhotosSummaryPrimary photosSummaryPrimary = (PhotosSummaryPrimary) o;
    return Objects.equals(this.id, photosSummaryPrimary.id) &&
        Objects.equals(this.source, photosSummaryPrimary.source) &&
        Objects.equals(this.uniqueId, photosSummaryPrimary.uniqueId) &&
        Objects.equals(this.urls, photosSummaryPrimary.urls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, source, uniqueId, urls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhotosSummaryPrimary {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    uniqueId: ").append(toIndentedString(uniqueId)).append("\n");
    sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
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

