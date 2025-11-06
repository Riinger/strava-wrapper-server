package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * SummaryAthlete
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummaryAthlete {

  private @Nullable Long id;

  private @Nullable Integer resourceState;

  private @Nullable String firstname;

  private @Nullable String lastname;

  private @Nullable String profileMedium;

  private @Nullable String profile;

  private @Nullable String city;

  private @Nullable String state;

  private @Nullable String country;

  /**
   * The athlete's sex.
   */
  public enum SexEnum {
    M("M"),
    
    F("F");

    private final String value;

    SexEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable SexEnum sex;

  private @Nullable Boolean premium;

  private @Nullable Boolean summit;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime updatedAt;

  public SummaryAthlete id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the athlete
   * @return id
   */
  
  @Schema(name = "id", description = "The unique identifier of the athlete", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  public void setId(@Nullable Long id) {
    this.id = id;
  }

  public SummaryAthlete resourceState(@Nullable Integer resourceState) {
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

  public SummaryAthlete firstname(@Nullable String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * The athlete's first name.
   * @return firstname
   */
  
  @Schema(name = "firstname", description = "The athlete's first name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstname")
  public @Nullable String getFirstname() {
    return firstname;
  }

  public void setFirstname(@Nullable String firstname) {
    this.firstname = firstname;
  }

  public SummaryAthlete lastname(@Nullable String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * The athlete's last name.
   * @return lastname
   */
  
  @Schema(name = "lastname", description = "The athlete's last name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastname")
  public @Nullable String getLastname() {
    return lastname;
  }

  public void setLastname(@Nullable String lastname) {
    this.lastname = lastname;
  }

  public SummaryAthlete profileMedium(@Nullable String profileMedium) {
    this.profileMedium = profileMedium;
    return this;
  }

  /**
   * URL to a 62x62 pixel profile picture.
   * @return profileMedium
   */
  
  @Schema(name = "profile_medium", description = "URL to a 62x62 pixel profile picture.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profile_medium")
  public @Nullable String getProfileMedium() {
    return profileMedium;
  }

  public void setProfileMedium(@Nullable String profileMedium) {
    this.profileMedium = profileMedium;
  }

  public SummaryAthlete profile(@Nullable String profile) {
    this.profile = profile;
    return this;
  }

  /**
   * URL to a 124x124 pixel profile picture.
   * @return profile
   */
  
  @Schema(name = "profile", description = "URL to a 124x124 pixel profile picture.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profile")
  public @Nullable String getProfile() {
    return profile;
  }

  public void setProfile(@Nullable String profile) {
    this.profile = profile;
  }

  public SummaryAthlete city(@Nullable String city) {
    this.city = city;
    return this;
  }

  /**
   * The athlete's city.
   * @return city
   */
  
  @Schema(name = "city", description = "The athlete's city.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public @Nullable String getCity() {
    return city;
  }

  public void setCity(@Nullable String city) {
    this.city = city;
  }

  public SummaryAthlete state(@Nullable String state) {
    this.state = state;
    return this;
  }

  /**
   * The athlete's state or geographical region.
   * @return state
   */
  
  @Schema(name = "state", description = "The athlete's state or geographical region.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public @Nullable String getState() {
    return state;
  }

  public void setState(@Nullable String state) {
    this.state = state;
  }

  public SummaryAthlete country(@Nullable String country) {
    this.country = country;
    return this;
  }

  /**
   * The athlete's country.
   * @return country
   */
  
  @Schema(name = "country", description = "The athlete's country.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("country")
  public @Nullable String getCountry() {
    return country;
  }

  public void setCountry(@Nullable String country) {
    this.country = country;
  }

  public SummaryAthlete sex(@Nullable SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * The athlete's sex.
   * @return sex
   */
  
  @Schema(name = "sex", description = "The athlete's sex.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sex")
  public @Nullable SexEnum getSex() {
    return sex;
  }

  public void setSex(@Nullable SexEnum sex) {
    this.sex = sex;
  }

  public SummaryAthlete premium(@Nullable Boolean premium) {
    this.premium = premium;
    return this;
  }

  /**
   * Deprecated.  Use summit field instead. Whether the athlete has any Summit subscription.
   * @return premium
   */
  
  @Schema(name = "premium", description = "Deprecated.  Use summit field instead. Whether the athlete has any Summit subscription.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("premium")
  public @Nullable Boolean getPremium() {
    return premium;
  }

  public void setPremium(@Nullable Boolean premium) {
    this.premium = premium;
  }

  public SummaryAthlete summit(@Nullable Boolean summit) {
    this.summit = summit;
    return this;
  }

  /**
   * Whether the athlete has any Summit subscription.
   * @return summit
   */
  
  @Schema(name = "summit", description = "Whether the athlete has any Summit subscription.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("summit")
  public @Nullable Boolean getSummit() {
    return summit;
  }

  public void setSummit(@Nullable Boolean summit) {
    this.summit = summit;
  }

  public SummaryAthlete createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The time at which the athlete was created.
   * @return createdAt
   */
  @Valid 
  @Schema(name = "created_at", description = "The time at which the athlete was created.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public SummaryAthlete updatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * The time at which the athlete was last updated.
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updated_at", description = "The time at which the athlete was last updated.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updated_at")
  public @Nullable OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(@Nullable OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryAthlete summaryAthlete = (SummaryAthlete) o;
    return Objects.equals(this.id, summaryAthlete.id) &&
        Objects.equals(this.resourceState, summaryAthlete.resourceState) &&
        Objects.equals(this.firstname, summaryAthlete.firstname) &&
        Objects.equals(this.lastname, summaryAthlete.lastname) &&
        Objects.equals(this.profileMedium, summaryAthlete.profileMedium) &&
        Objects.equals(this.profile, summaryAthlete.profile) &&
        Objects.equals(this.city, summaryAthlete.city) &&
        Objects.equals(this.state, summaryAthlete.state) &&
        Objects.equals(this.country, summaryAthlete.country) &&
        Objects.equals(this.sex, summaryAthlete.sex) &&
        Objects.equals(this.premium, summaryAthlete.premium) &&
        Objects.equals(this.summit, summaryAthlete.summit) &&
        Objects.equals(this.createdAt, summaryAthlete.createdAt) &&
        Objects.equals(this.updatedAt, summaryAthlete.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, firstname, lastname, profileMedium, profile, city, state, country, sex, premium, summit, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryAthlete {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceState: ").append(toIndentedString(resourceState)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    profileMedium: ").append(toIndentedString(profileMedium)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    premium: ").append(toIndentedString(premium)).append("\n");
    sb.append("    summit: ").append(toIndentedString(summit)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

