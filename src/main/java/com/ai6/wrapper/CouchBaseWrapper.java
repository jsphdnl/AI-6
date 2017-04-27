package com.ai6.wrapper;

import com.ai6.exceptions.DocumentNotFoundException;
import com.couchbase.client.deps.com.fasterxml.jackson.core.JsonProcessingException;
import com.couchbase.client.deps.com.fasterxml.jackson.core.type.TypeReference;
import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

import java.io.IOException;

/**
 * Created by bharath on 4/24/17.
 */
public class CouchBaseWrapper implements ICouchBaseWrapper{

  private Bucket bucket;
  private ObjectMapper objectMapper;

  public CouchBaseWrapper(Bucket bucket, ObjectMapper mapper){
    this.bucket = bucket;
    this.objectMapper = mapper;
  }

  @Override
  public <T>void set(String key, T jsonObject) throws JsonProcessingException {
    String value =  objectMapper.writeValueAsString(jsonObject);
    this.bucket.upsert(RawJsonDocument.create(key, value));
  }

  @Override
  public <T> T get(String key, Class<T> clazz) throws IOException {
    RawJsonDocument jsonDocument = RawJsonDocument.create(key);
    jsonDocument =  bucket.get(jsonDocument);
    if(null == jsonDocument){
      throw new DocumentNotFoundException("Cannot find doument with key " + key);
    }
    String value = objectMapper.writeValueAsString(jsonDocument.content());
    return objectMapper.readValue(value, clazz);
  }

  @Override
  public void delete(String key) {
    bucket.remove(key);
  }


  public synchronized String getNextUid(String className ){
      String counterName = className + "Counter";
      JsonLongDocument val = bucket.counter(counterName, 1, 1);
      String keyPrefix = className;
      String nextKey = keyPrefix + val.content().longValue();
      return nextKey;

    }
}
