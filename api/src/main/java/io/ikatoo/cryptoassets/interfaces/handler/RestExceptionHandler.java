/**
 * @author Milton Carlos Katoo
 * @email mckatoo@gmail.com
 * @create date 2019-02-10 13:33:04
 * @modify date 2019-02-10 13:33:04
 * @desc [description]
 */

package io.ikatoo.cryptoassets.interfaces.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.ikatoo.cryptoassets.interfaces.error.ResourceNotFoundDetails;
import io.ikatoo.cryptoassets.interfaces.error.ResourceNotFoundException;

/**
 * RestExceptionHandler
 */
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder.newBuilder()
                .timestamp(new Date().getTime()).status(HttpStatus.NOT_FOUND.value()).title("Resource not found")
                .detail(rnfException.getMessage()).developerMessage(rnfException.getClass().getName()).build();

        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }
}