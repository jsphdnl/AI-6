package com.ai6.exceptions;

/**
 * Created by bharath on 4/26/17.
 */
public class InternalServerException extends RuntimeException{
  /**
   * Constructs a new runtime exception with the specified detail message.
   * The cause is not initialized, and may subsequently be initialized by a
   * call to {@link #initCause}.
   *
   * @param message the detail message. The detail message is saved for
   *                later retrieval by the {@link #getMessage()} method.
   */
  public InternalServerException(String message) {
    super(message);
  }
}