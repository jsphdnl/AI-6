package com.ai6.wrapper;

import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.java.document.json.JsonObject;

import java.io.IOException;

/**
 * Created by bharath on 4/24/17.
 */
public interface ICouchBaseWrapper {
  public <T> void set(String key, T jsonObject) throws JsonProcessingException;
  public <T> T get(String key, Class<T> clazz) throws IOException;
  public void delete(String key);
}
