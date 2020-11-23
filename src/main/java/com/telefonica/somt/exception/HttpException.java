package com.telefonica.somt.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpException extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private String     httpStatusCode;
    private String     message;

    public HttpException(HttpStatus httpStatus, String httpStatusCode, String message) {
	super();
	this.httpStatus = httpStatus;
	this.httpStatusCode = httpStatusCode;
	this.message = message;
    }

    public HttpException() {
	super();
    }

    public HttpException(HttpException e) {
	this.httpStatus = e.getHttpStatus();
	this.httpStatusCode = e.getHttpStatusCode();
	this.message = e.getMessage();
    }

    public static HttpException HttpExceptionResponse(Exception e) {

	HttpException httpException = new HttpException();
	String message = e.getMessage();

	if (message.equals("1")) {
	    httpException.setHttpStatusCode("404");
	    httpException.setHttpStatus(HttpStatus.NOT_FOUND);
	    httpException.setMessage("Cliente no aplica a oferta Sugerida");

	} else {
	    httpException.setHttpStatusCode("500");
	    httpException.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	    httpException.setMessage(e.getMessage());
	}

	return httpException;

    }

}
