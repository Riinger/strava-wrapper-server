package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An enumeration of the types an activity may have. Note that this enumeration does not include new sport types (e.g. MountainBikeRide, EMountainBikeRide), activities with these sport types will have the corresponding activity type (e.g. Ride for MountainBikeRide, EBikeRide for EMountainBikeRide)
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public enum ActivityType {
  
  ALPINE_SKI("AlpineSki"),
  
  BACKCOUNTRY_SKI("BackcountrySki"),
  
  CANOEING("Canoeing"),
  
  CROSSFIT("Crossfit"),
  
  E_BIKE_RIDE("EBikeRide"),
  
  ELLIPTICAL("Elliptical"),
  
  GOLF("Golf"),
  
  HANDCYCLE("Handcycle"),
  
  HIKE("Hike"),
  
  ICE_SKATE("IceSkate"),
  
  INLINE_SKATE("InlineSkate"),
  
  KAYAKING("Kayaking"),
  
  KITESURF("Kitesurf"),
  
  NORDIC_SKI("NordicSki"),
  
  RIDE("Ride"),
  
  ROCK_CLIMBING("RockClimbing"),
  
  ROLLER_SKI("RollerSki"),
  
  ROWING("Rowing"),
  
  RUN("Run"),
  
  SAIL("Sail"),
  
  SKATEBOARD("Skateboard"),
  
  SNOWBOARD("Snowboard"),
  
  SNOWSHOE("Snowshoe"),
  
  SOCCER("Soccer"),
  
  STAIR_STEPPER("StairStepper"),
  
  STAND_UP_PADDLING("StandUpPaddling"),
  
  SURFING("Surfing"),
  
  SWIM("Swim"),
  
  VELOMOBILE("Velomobile"),
  
  VIRTUAL_RIDE("VirtualRide"),
  
  VIRTUAL_RUN("VirtualRun"),
  
  WALK("Walk"),
  
  WEIGHT_TRAINING("WeightTraining"),
  
  WHEELCHAIR("Wheelchair"),
  
  WINDSURF("Windsurf"),
  
  WORKOUT("Workout"),
  
  YOGA("Yoga");

  private final String value;

  ActivityType(String value) {
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
  public static ActivityType fromValue(String value) {
    for (ActivityType b : ActivityType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

