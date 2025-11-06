package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.gade.gps.strava.server.model.ActivityType;
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
 * SummaryClub
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class SummaryClub {

  private @Nullable Long id;

  private @Nullable Integer resourceState;

  private @Nullable String name;

  private @Nullable String profileMedium;

  private @Nullable String coverPhoto;

  private @Nullable String coverPhotoSmall;

  /**
   * Deprecated. Prefer to use activity_types.
   */
  public enum SportTypeEnum {
    CYCLING("cycling"),
    
    RUNNING("running"),
    
    TRIATHLON("triathlon"),
    
    OTHER("other");

    private final String value;

    SportTypeEnum(String value) {
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
    public static SportTypeEnum fromValue(String value) {
      for (SportTypeEnum b : SportTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable SportTypeEnum sportType;

  @Valid
  private List<ActivityType> activityTypes = new ArrayList<>();

  private @Nullable String city;

  private @Nullable String state;

  private @Nullable String country;

  private @Nullable Boolean _private;

  private @Nullable Integer memberCount;

  private @Nullable Boolean featured;

  private @Nullable Boolean verified;

  private @Nullable String url;

  public SummaryClub id(@Nullable Long id) {
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

  public SummaryClub resourceState(@Nullable Integer resourceState) {
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

  public SummaryClub name(@Nullable String name) {
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

  public SummaryClub profileMedium(@Nullable String profileMedium) {
    this.profileMedium = profileMedium;
    return this;
  }

  /**
   * URL to a 60x60 pixel profile picture.
   * @return profileMedium
   */
  
  @Schema(name = "profile_medium", description = "URL to a 60x60 pixel profile picture.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("profile_medium")
  public @Nullable String getProfileMedium() {
    return profileMedium;
  }

  public void setProfileMedium(@Nullable String profileMedium) {
    this.profileMedium = profileMedium;
  }

  public SummaryClub coverPhoto(@Nullable String coverPhoto) {
    this.coverPhoto = coverPhoto;
    return this;
  }

  /**
   * URL to a ~1185x580 pixel cover photo.
   * @return coverPhoto
   */
  
  @Schema(name = "cover_photo", description = "URL to a ~1185x580 pixel cover photo.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cover_photo")
  public @Nullable String getCoverPhoto() {
    return coverPhoto;
  }

  public void setCoverPhoto(@Nullable String coverPhoto) {
    this.coverPhoto = coverPhoto;
  }

  public SummaryClub coverPhotoSmall(@Nullable String coverPhotoSmall) {
    this.coverPhotoSmall = coverPhotoSmall;
    return this;
  }

  /**
   * URL to a ~360x176  pixel cover photo.
   * @return coverPhotoSmall
   */
  
  @Schema(name = "cover_photo_small", description = "URL to a ~360x176  pixel cover photo.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cover_photo_small")
  public @Nullable String getCoverPhotoSmall() {
    return coverPhotoSmall;
  }

  public void setCoverPhotoSmall(@Nullable String coverPhotoSmall) {
    this.coverPhotoSmall = coverPhotoSmall;
  }

  public SummaryClub sportType(@Nullable SportTypeEnum sportType) {
    this.sportType = sportType;
    return this;
  }

  /**
   * Deprecated. Prefer to use activity_types.
   * @return sportType
   */
  
  @Schema(name = "sport_type", description = "Deprecated. Prefer to use activity_types.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sport_type")
  public @Nullable SportTypeEnum getSportType() {
    return sportType;
  }

  public void setSportType(@Nullable SportTypeEnum sportType) {
    this.sportType = sportType;
  }

  public SummaryClub activityTypes(List<ActivityType> activityTypes) {
    this.activityTypes = activityTypes;
    return this;
  }

  public SummaryClub addActivityTypesItem(ActivityType activityTypesItem) {
    if (this.activityTypes == null) {
      this.activityTypes = new ArrayList<>();
    }
    this.activityTypes.add(activityTypesItem);
    return this;
  }

  /**
   * The activity types that count for a club. This takes precedence over sport_type.
   * @return activityTypes
   */
  @Valid 
  @Schema(name = "activity_types", description = "The activity types that count for a club. This takes precedence over sport_type.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("activity_types")
  public List<ActivityType> getActivityTypes() {
    return activityTypes;
  }

  public void setActivityTypes(List<ActivityType> activityTypes) {
    this.activityTypes = activityTypes;
  }

  public SummaryClub city(@Nullable String city) {
    this.city = city;
    return this;
  }

  /**
   * The club's city.
   * @return city
   */
  
  @Schema(name = "city", description = "The club's city.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("city")
  public @Nullable String getCity() {
    return city;
  }

  public void setCity(@Nullable String city) {
    this.city = city;
  }

  public SummaryClub state(@Nullable String state) {
    this.state = state;
    return this;
  }

  /**
   * The club's state or geographical region.
   * @return state
   */
  
  @Schema(name = "state", description = "The club's state or geographical region.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public @Nullable String getState() {
    return state;
  }

  public void setState(@Nullable String state) {
    this.state = state;
  }

  public SummaryClub country(@Nullable String country) {
    this.country = country;
    return this;
  }

  /**
   * The club's country.
   * @return country
   */
  
  @Schema(name = "country", description = "The club's country.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("country")
  public @Nullable String getCountry() {
    return country;
  }

  public void setCountry(@Nullable String country) {
    this.country = country;
  }

  public SummaryClub _private(@Nullable Boolean _private) {
    this._private = _private;
    return this;
  }

  /**
   * Whether the club is private.
   * @return _private
   */
  
  @Schema(name = "private", description = "Whether the club is private.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("private")
  public @Nullable Boolean getPrivate() {
    return _private;
  }

  public void setPrivate(@Nullable Boolean _private) {
    this._private = _private;
  }

  public SummaryClub memberCount(@Nullable Integer memberCount) {
    this.memberCount = memberCount;
    return this;
  }

  /**
   * The club's member count.
   * @return memberCount
   */
  
  @Schema(name = "member_count", description = "The club's member count.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("member_count")
  public @Nullable Integer getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(@Nullable Integer memberCount) {
    this.memberCount = memberCount;
  }

  public SummaryClub featured(@Nullable Boolean featured) {
    this.featured = featured;
    return this;
  }

  /**
   * Whether the club is featured or not.
   * @return featured
   */
  
  @Schema(name = "featured", description = "Whether the club is featured or not.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("featured")
  public @Nullable Boolean getFeatured() {
    return featured;
  }

  public void setFeatured(@Nullable Boolean featured) {
    this.featured = featured;
  }

  public SummaryClub verified(@Nullable Boolean verified) {
    this.verified = verified;
    return this;
  }

  /**
   * Whether the club is verified or not.
   * @return verified
   */
  
  @Schema(name = "verified", description = "Whether the club is verified or not.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("verified")
  public @Nullable Boolean getVerified() {
    return verified;
  }

  public void setVerified(@Nullable Boolean verified) {
    this.verified = verified;
  }

  public SummaryClub url(@Nullable String url) {
    this.url = url;
    return this;
  }

  /**
   * The club's vanity URL.
   * @return url
   */
  
  @Schema(name = "url", description = "The club's vanity URL.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("url")
  public @Nullable String getUrl() {
    return url;
  }

  public void setUrl(@Nullable String url) {
    this.url = url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryClub summaryClub = (SummaryClub) o;
    return Objects.equals(this.id, summaryClub.id) &&
        Objects.equals(this.resourceState, summaryClub.resourceState) &&
        Objects.equals(this.name, summaryClub.name) &&
        Objects.equals(this.profileMedium, summaryClub.profileMedium) &&
        Objects.equals(this.coverPhoto, summaryClub.coverPhoto) &&
        Objects.equals(this.coverPhotoSmall, summaryClub.coverPhotoSmall) &&
        Objects.equals(this.sportType, summaryClub.sportType) &&
        Objects.equals(this.activityTypes, summaryClub.activityTypes) &&
        Objects.equals(this.city, summaryClub.city) &&
        Objects.equals(this.state, summaryClub.state) &&
        Objects.equals(this.country, summaryClub.country) &&
        Objects.equals(this._private, summaryClub._private) &&
        Objects.equals(this.memberCount, summaryClub.memberCount) &&
        Objects.equals(this.featured, summaryClub.featured) &&
        Objects.equals(this.verified, summaryClub.verified) &&
        Objects.equals(this.url, summaryClub.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceState, name, profileMedium, coverPhoto, coverPhotoSmall, sportType, activityTypes, city, state, country, _private, memberCount, featured, verified, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryClub {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceState: ").append(toIndentedString(resourceState)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    profileMedium: ").append(toIndentedString(profileMedium)).append("\n");
    sb.append("    coverPhoto: ").append(toIndentedString(coverPhoto)).append("\n");
    sb.append("    coverPhotoSmall: ").append(toIndentedString(coverPhotoSmall)).append("\n");
    sb.append("    sportType: ").append(toIndentedString(sportType)).append("\n");
    sb.append("    activityTypes: ").append(toIndentedString(activityTypes)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    _private: ").append(toIndentedString(_private)).append("\n");
    sb.append("    memberCount: ").append(toIndentedString(memberCount)).append("\n");
    sb.append("    featured: ").append(toIndentedString(featured)).append("\n");
    sb.append("    verified: ").append(toIndentedString(verified)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

