package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.SummaryClub;
import com.gade.gps.strava.server.model.SummaryGear;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * DetailedAthlete
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class DetailedAthlete {

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

  private @Nullable Integer followerCount;

  private @Nullable Integer friendCount;

  /**
   * The athlete's preferred unit system.
   */
  public enum MeasurementPreferenceEnum {
    FEET("feet"),
    
    METERS("meters");

    private final String value;

    MeasurementPreferenceEnum(String value) {
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
    public static MeasurementPreferenceEnum fromValue(String value) {
      for (MeasurementPreferenceEnum b : MeasurementPreferenceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable MeasurementPreferenceEnum measurementPreference;

  private @Nullable Integer ftp;

  private @Nullable Float weight;

  @Valid
  private List<SummaryClub> clubs = new ArrayList<>();

  @Valid
  private List<@Valid SummaryGear> bikes = new ArrayList<>();

  @Valid
  private List<@Valid SummaryGear> shoes = new ArrayList<>();

  public DetailedAthlete id(@Nullable Long id) {
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

  public DetailedAthlete resourceState(@Nullable Integer resourceState) {
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

  public DetailedAthlete firstname(@Nullable String firstname) {
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

  public DetailedAthlete lastname(@Nullable String lastname) {
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

  public DetailedAthlete profileMedium(@Nullable String profileMedium) {
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

  public DetailedAthlete profile(@Nullable String profile) {
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

  public DetailedAthlete city(@Nullable String city) {
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

  public DetailedAthlete state(@Nullable String state) {
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

  public DetailedAthlete country(@Nullable String country) {
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

  public DetailedAthlete sex(@Nullable SexEnum sex) {
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

  public DetailedAthlete premium(@Nullable Boolean premium) {
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

  public DetailedAthlete summit(@Nullable Boolean summit) {
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

  public DetailedAthlete createdAt(@Nullable OffsetDateTime createdAt) {
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

  public DetailedAthlete updatedAt(@Nullable OffsetDateTime updatedAt) {
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

  public DetailedAthlete followerCount(@Nullable Integer followerCount) {
    this.followerCount = followerCount;
    return this;
  }

  /**
   * The athlete's follower count.
   * @return followerCount
   */
  
  @Schema(name = "follower_count", description = "The athlete's follower count.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("follower_count")
  public @Nullable Integer getFollowerCount() {
    return followerCount;
  }

  public void setFollowerCount(@Nullable Integer followerCount) {
    this.followerCount = followerCount;
  }

  public DetailedAthlete friendCount(@Nullable Integer friendCount) {
    this.friendCount = friendCount;
    return this;
  }

  /**
   * The athlete's friend count.
   * @return friendCount
   */
  
  @Schema(name = "friend_count", description = "The athlete's friend count.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("friend_count")
  public @Nullable Integer getFriendCount() {
    return friendCount;
  }

  public void setFriendCount(@Nullable Integer friendCount) {
    this.friendCount = friendCount;
  }

  public DetailedAthlete measurementPreference(@Nullable MeasurementPreferenceEnum measurementPreference) {
    this.measurementPreference = measurementPreference;
    return this;
  }

  /**
   * The athlete's preferred unit system.
   * @return measurementPreference
   */
  
  @Schema(name = "measurement_preference", description = "The athlete's preferred unit system.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("measurement_preference")
  public @Nullable MeasurementPreferenceEnum getMeasurementPreference() {
    return measurementPreference;
  }

  public void setMeasurementPreference(@Nullable MeasurementPreferenceEnum measurementPreference) {
    this.measurementPreference = measurementPreference;
  }

  public DetailedAthlete ftp(@Nullable Integer ftp) {
    this.ftp = ftp;
    return this;
  }

  /**
   * The athlete's FTP (Functional Threshold Power).
   * @return ftp
   */
  
  @Schema(name = "ftp", description = "The athlete's FTP (Functional Threshold Power).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("ftp")
  public @Nullable Integer getFtp() {
    return ftp;
  }

  public void setFtp(@Nullable Integer ftp) {
    this.ftp = ftp;
  }

  public DetailedAthlete weight(@Nullable Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * The athlete's weight.
   * @return weight
   */
  
  @Schema(name = "weight", description = "The athlete's weight.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("weight")
  public @Nullable Float getWeight() {
    return weight;
  }

  public void setWeight(@Nullable Float weight) {
    this.weight = weight;
  }

  public DetailedAthlete clubs(List<SummaryClub> clubs) {
    this.clubs = clubs;
    return this;
  }

  public DetailedAthlete addClubsItem(SummaryClub clubsItem) {
    if (this.clubs == null) {
      this.clubs = new ArrayList<>();
    }
    this.clubs.add(clubsItem);
    return this;
  }

  /**
   * The athlete's clubs.
   * @return clubs
   */
  @Valid 
  @Schema(name = "clubs", description = "The athlete's clubs.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clubs")
  public List<SummaryClub> getClubs() {
    return clubs;
  }

  public void setClubs(List<SummaryClub> clubs) {
    this.clubs = clubs;
  }

  public DetailedAthlete bikes(List<@Valid SummaryGear> bikes) {
    this.bikes = bikes;
    return this;
  }

  public DetailedAthlete addBikesItem(SummaryGear bikesItem) {
    if (this.bikes == null) {
      this.bikes = new ArrayList<>();
    }
    this.bikes.add(bikesItem);
    return this;
  }

  /**
   * The athlete's bikes.
   * @return bikes
   */
  @Valid 
  @Schema(name = "bikes", description = "The athlete's bikes.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bikes")
  public List<@Valid SummaryGear> getBikes() {
    return bikes;
  }

  public void setBikes(List<@Valid SummaryGear> bikes) {
    this.bikes = bikes;
  }

  public DetailedAthlete shoes(List<@Valid SummaryGear> shoes) {
    this.shoes = shoes;
    return this;
  }

  public DetailedAthlete addShoesItem(SummaryGear shoesItem) {
    if (this.shoes == null) {
      this.shoes = new ArrayList<>();
    }
    this.shoes.add(shoesItem);
    return this;
  }

  /**
   * The athlete's shoes.
   * @return shoes
   */
  @Valid 
  @Schema(name = "shoes", description = "The athlete's shoes.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("shoes")
  public List<@Valid SummaryGear> getShoes() {
    return shoes;
  }

  public void setShoes(List<@Valid SummaryGear> shoes) {
    this.shoes = shoes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedAthlete detailedAthlete = (DetailedAthlete) o;
    return Objects.equals(this.id, detailedAthlete.id) &&
        Objects.equals(this.resourceState, detailedAthlete.resourceState) &&
        Objects.equals(this.firstname, detailedAthlete.firstname) &&
        Objects.equals(this.lastname, detailedAthlete.lastname) &&
        Objects.equals(this.profileMedium, detailedAthlete.profileMedium) &&
        Objects.equals(this.profile, detailedAthlete.profile) &&
        Objects.equals(this.city, detailedAthlete.city) &&
        Objects.equals(this.state, detailedAthlete.state) &&
        Objects.equals(this.country, detailedAthlete.country) &&
        Objects.equals(this.sex, detailedAthlete.sex) &&
        Objects.equals(this.premium, detailedAthlete.premium) &&
        Objects.equals(this.summit, detailedAthlete.summit) &&
        Objects.equals(this.createdAt, detailedAthlete.createdAt) &&
        Objects.equals(this.updatedAt, detailedAthlete.updatedAt) &&
        Objects.equals(this.followerCount, detailedAthlete.followerCount) &&
        Objects.equals(this.friendCount, detailedAthlete.friendCount) &&
        Objects.equals(this.measurementPreference, detailedAthlete.measurementPreference) &&
        Objects.equals(this.ftp, detailedAthlete.ftp) &&
        Objects.equals(this.weight, detailedAthlete.weight) &&
        Objects.equals(this.clubs, detailedAthlete.clubs) &&
        Objects.equals(this.bikes, detailedAthlete.bikes) &&
        Objects.equals(this.shoes, detailedAthlete.shoes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, firstname, lastname, profileMedium, profile, city, state, country, sex, premium, summit, createdAt, updatedAt, followerCount, friendCount, measurementPreference, ftp, weight, clubs, bikes, shoes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedAthlete {\n");
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
    sb.append("    followerCount: ").append(toIndentedString(followerCount)).append("\n");
    sb.append("    friendCount: ").append(toIndentedString(friendCount)).append("\n");
    sb.append("    measurementPreference: ").append(toIndentedString(measurementPreference)).append("\n");
    sb.append("    ftp: ").append(toIndentedString(ftp)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    clubs: ").append(toIndentedString(clubs)).append("\n");
    sb.append("    bikes: ").append(toIndentedString(bikes)).append("\n");
    sb.append("    shoes: ").append(toIndentedString(shoes)).append("\n");
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

