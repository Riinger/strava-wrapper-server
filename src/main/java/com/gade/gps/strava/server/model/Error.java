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
 * Error
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Error {

  private @Nullable String code;

  private @Nullable String field;

  private @Nullable String resource;

  public Error code(@Nullable String code) {
    this.code = code;
    return this;
  }

  /**
   * The code associated with this error.
   * @return code
   */
  
  @Schema(name = "code", description = "The code associated with this error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public @Nullable String getCode() {
    return code;
  }

  public void setCode(@Nullable String code) {
    this.code = code;
  }

  public Error field(@Nullable String field) {
    this.field = field;
    return this;
  }

  /**
   * The specific field or aspect of the resource associated with this error.
   * @return field
   */
  
  @Schema(name = "field", description = "The specific field or aspect of the resource associated with this error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("field")
  public @Nullable String getField() {
    return field;
  }

  public void setField(@Nullable String field) {
    this.field = field;
  }

  public Error resource(@Nullable String resource) {
    this.resource = resource;
    return this;
  }

  /**
   * The type of resource associated with this error.
   * @return resource
   */
  
  @Schema(name = "resource", description = "The type of resource associated with this error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resource")
  public @Nullable String getResource() {
    return resource;
  }

  public void setResource(@Nullable String resource) {
    this.resource = resource;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.field, error.field) &&
        Objects.equals(this.resource, error.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, field, resource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
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

