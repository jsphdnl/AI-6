package com.ai6.exceptions;

import com.ai6.models.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by bharath on 4/26/17.
 */
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException>{
  /**
   * Map an exception to a {@link Response}. Returning
   * {@code null} results in a {@link Response.Status#NO_CONTENT}
   * response. Throwing a runtime exception results in a
   * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
   *
   * @param exception the exception to map to a response.
   * @return a response mapped from the supplied exception.
   */
  @Override
  public Response toResponse(ResourceNotFoundException exception) {
    ErrorMessage message = new ErrorMessage();
    message.setError(exception.getMessage());
    return Response.serverError().entity(message).status(404).build();
  }
}