package com.gade.gps.strava.server.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * CadenceStream
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.16.0")
public class CadenceStream {

  private @Nullable Integer originalSize;

  /**
   * The level of detail (sampling) in which this stream was returned
   */
  public enum ResolutionEnum {
    LOW("low"),
    
    MEDIUM("medium"),
    
    HIGH("high");

    private final String value;

    ResolutionEnum(String value) {
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
    public static ResolutionEnum fromValue(String value) {
      for (ResolutionEnum b : ResolutionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable ResolutionEnum resolution;

  /**
   * The base series used in the case the stream was downsampled
   */
  public enum SeriesTypeEnum {
    DISTANCE("distance"),
    
    TIME("time");

    private final String value;

    SeriesTypeEnum(String value) {
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
    public static SeriesTypeEnum fromValue(String value) {
      for (SeriesTypeEnum b : SeriesTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable SeriesTypeEnum seriesType;

  @Valid
  private List<Integer> data = new ArrayList<>();

  public CadenceStream originalSize(@Nullable Integer originalSize) {
    this.originalSize = originalSize;
    return this;
  }

  /**
   * The number of data points in this stream
   * @return originalSize
   */
  
  @Schema(name = "original_size", description = "The number of data points in this stream", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("original_size")
  public @Nullable Integer getOriginalSize() {
    return originalSize;
  }

  public void setOriginalSize(@Nullable Integer originalSize) {
    this.originalSize = originalSize;
  }

  public CadenceStream resolution(@Nullable ResolutionEnum resolution) {
    this.resolution = resolution;
    return this;
  }

  /**
   * The level of detail (sampling) in which this stream was returned
   * @return resolution
   */
  
  @Schema(name = "resolution", description = "The level of detail (sampling) in which this stream was returned", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resolution")
  public @Nullable ResolutionEnum getResolution() {
    return resolution;
  }

  public void setResolution(@Nullable ResolutionEnum resolution) {
    this.resolution = resolution;
  }

  public CadenceStream seriesType(@Nullable SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
    return this;
  }

  /**
   * The base series used in the case the stream was downsampled
   * @return seriesType
   */
  
  @Schema(name = "series_type", description = "The base series used in the case the stream was downsampled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("series_type")
  public @Nullable SeriesTypeEnum getSeriesType() {
    return seriesType;
  }

  public void setSeriesType(@Nullable SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
  }

  public CadenceStream data(List<Integer> data) {
    this.data = data;
    return this;
  }

  public CadenceStream addDataItem(Integer dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * The sequence of cadence values for this stream, in rotations per minute
   * @return data
   */
  
  @Schema(name = "data", description = "The sequence of cadence values for this stream, in rotations per minute", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public List<Integer> getData() {
    return data;
  }

  public void setData(List<Integer> data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CadenceStream cadenceStream = (CadenceStream) o;
    return Objects.equals(this.originalSize, cadenceStream.originalSize) &&
        Objects.equals(this.resolution, cadenceStream.resolution) &&
        Objects.equals(this.seriesType, cadenceStream.seriesType) &&
        Objects.equals(this.data, cadenceStream.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalSize, resolution, seriesType, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CadenceStream {\n");
    sb.append("    originalSize: ").append(toIndentedString(originalSize)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    seriesType: ").append(toIndentedString(seriesType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

