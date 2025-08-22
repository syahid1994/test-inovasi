package id.co.syahid.testinovasi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.co.syahid.testinovasi.exception.ResponseCodeException;
import id.co.syahid.testinovasi.response.ErrorRes;

@RestControllerAdvice
public class HandlerAdvice {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRes> handleException(Exception ex) {
		ErrorRes res = new ErrorRes();
		res.setMessage(ex.getMessage());
		res.setResponseCode("99");
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(ResponseCodeException.class)
    public ResponseEntity<ErrorRes> handleException(ResponseCodeException ex) {
		ErrorRes res = new ErrorRes();
		res.setMessage(ex.getMessage());
		res.setResponseCode(ex.getCode());
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }
}
