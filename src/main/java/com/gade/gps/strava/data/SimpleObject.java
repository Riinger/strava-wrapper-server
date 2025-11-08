package com.gade.gps.strava.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("field-1")
	private String f1;
	@JsonProperty("field-2")
	private String f2;
}
