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
 * An enumeration of the sport types an activity may have. Distinct from ActivityType in that it has new types (e.g. MountainBikeRide)
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public enum SportType {
  
  ALPINE_SKI("AlpineSki"),
  
  BACKCOUNTRY_SKI("BackcountrySki"),
  
  BADMINTON("Badminton"),
  
  CANOEING("Canoeing"),
  
  CROSSFIT("Crossfit"),
  
  E_BIKE_RIDE("EBikeRide"),
  
  ELLIPTICAL("Elliptical"),
  
  E_MOUNTAIN_BIKE_RIDE("EMountainBikeRide"),
  
  GOLF("Golf"),
  
  GRAVEL_RIDE("GravelRide"),
  
  HANDCYCLE("Handcycle"),
  
  HIGH_INTENSITY_INTERVAL_TRAINING("HighIntensityIntervalTraining"),
  
  HIKE("Hike"),
  
  ICE_SKATE("IceSkate"),
  
  INLINE_SKATE("InlineSkate"),
  
  KAYAKING("Kayaking"),
  
  KITESURF("Kitesurf"),
  
  MOUNTAIN_BIKE_RIDE("MountainBikeRide"),
  
  NORDIC_SKI("NordicSki"),
  
  PICKLEBALL("Pickleball"),
  
  PILATES("Pilates"),
  
  RACQUETBALL("Racquetball"),
  
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
  
  SQUASH("Squash"),
  
  STAIR_STEPPER("StairStepper"),
  
  STAND_UP_PADDLING("StandUpPaddling"),
  
  SURFING("Surfing"),
  
  SWIM("Swim"),
  
  TABLE_TENNIS("TableTennis"),
  
  TENNIS("Tennis"),
  
  TRAIL_RUN("TrailRun"),
  
  VELOMOBILE("Velomobile"),
  
  VIRTUAL_RIDE("VirtualRide"),
  
  VIRTUAL_ROW("VirtualRow"),
  
  VIRTUAL_RUN("VirtualRun"),
  
  WALK("Walk"),
  
  WEIGHT_TRAINING("WeightTraining"),
  
  WHEELCHAIR("Wheelchair"),
  
  WINDSURF("Windsurf"),
  
  WORKOUT("Workout"),
  
  YOGA("Yoga");

  private final String value;

  SportType(String value) {
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
  public static SportType fromValue(String value) {
    for (SportType b : SportType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

