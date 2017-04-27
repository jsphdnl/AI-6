package com.ai6.models;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bharath on 4/26/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage {
  private String error;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
