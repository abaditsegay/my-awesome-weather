package com.weather.assignment.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by abadi on 5/25/17 in com.weather.assignment.exception.
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{
    @Override
    public Response toResponse(DataNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage("Data not found", 404, "some link here");

        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
