package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.SummaryAthlete;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Comment
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Comment {

  private @Nullable Long id;

  private @Nullable Long activityId;

  private @Nullable String text;

  private @Nullable SummaryAthlete athlete;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  public Comment id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of this comment
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of this comment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public Comment activityId(@Nullable Long activityId) {
    this.activityId = activityId;
    return this;
  }

  /**
   * The identifier of the activity this comment is related to
   * @return activityId
   */
  
  @Schema(name = "activity_id", description = "The identifier of the activity this comment is related to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activity_id")
  public @Nullable Long getActivityId() {
    return activityId;
  }

  public void setActivityId(@Nullable Long activityId) {
    this.activityId = activityId;
  }

  public Comment text(@Nullable String text) {
    this.text = text;
    return this;
  }

  /**
   * The content of the comment
   * @return text
   */
  
  @Schema(name = "text", description = "The content of the comment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("text")
  public @Nullable String getText() {
    return text;
  }

  public void setText(@Nullable String text) {
    this.text = text;
  }

  public Comment athlete(@Nullable SummaryAthlete athlete) {
    this.athlete = athlete;
    return this;
  }

  /**
   * Get athlete
   * @return athlete
   */
  @Valid 
  @Schema(name = "athlete", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("athlete")
  public @Nullable SummaryAthlete getAthlete() {
    return athlete;
  }

  public void setAthlete(@Nullable SummaryAthlete athlete) {
    this.athlete = athlete;
  }

  public Comment createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The time at which this comment was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "created_at", description = "The time at which this comment was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Comment comment = (Comment) o;
    return Objects.equals(this.id, comment.id) &&
        Objects.equals(this.activityId, comment.activityId) &&
        Objects.equals(this.text, comment.text) &&
        Objects.equals(this.athlete, comment.athlete) &&
        Objects.equals(this.createdAt, comment.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, activityId, text, athlete, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Comment {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    athlete: ").append(toIndentedString(athlete)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

