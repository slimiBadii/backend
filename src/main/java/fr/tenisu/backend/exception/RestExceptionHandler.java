package fr.tenisu.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
   //other exception handlers
  
   @ExceptionHandler(DataNotFoundException.class)
   protected ResponseEntity<Object> handleEntityNotFound( DataNotFoundException ex) { ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
       apiError.setMessage(ex.getMessage());
       return buildResponseEntity(apiError);
   }

   @ExceptionHandler(Exception.class)
   protected ResponseEntity<Object> handleEntityNotFound( Exception ex) { ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
       apiError.setMessage(ex.getMessage());
       return buildResponseEntity(apiError);
   }
private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	
	return new ResponseEntity<>(apiError, apiError.getStatus());
}


}