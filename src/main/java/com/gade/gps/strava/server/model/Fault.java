package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.gade.gps.strava.server.model.Error;
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
 * Encapsulates the errors that may be returned from the API.
 */

@Schema(name = "Fault", description = "Encapsulates the errors that may be returned from the API.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class Fault {

  @Valid
  private List<@Valid Error> errors = new ArrayList<>();

  private @Nullable String message;

  public Fault errors(List<@Valid Error> errors) {
    this.errors = errors;
    return this;
  }

  public Fault addErrorsItem(Error errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * The set of specific errors associated with this fault, if any.
   * @return errors
   */
  @Valid 
  @Schema(name = "errors", description = "The set of specific errors associated with this fault, if any.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public List<@Valid Error> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid Error> errors) {
    this.errors = errors;
  }

  public Fault message(@Nullable String message) {
    this.message = message;
    return this;
  }

  /**
   * The message of the fault.
   * @return message
   */
  
  @Schema(name = "message", description = "The message of the fault.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public @Nullable String getMessage() {
    return message;
  }

  public void setMessage(@Nullable String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fault fault = (Fault) o;
    return Objects.equals(this.errors, fault.errors) &&
        Objects.equals(this.message, fault.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fault {\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

