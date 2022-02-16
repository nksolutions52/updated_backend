package com.org.dentys.uitl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class GateWayResponse<T> {
	 private Boolean isSuccess;
	    private HttpStatus httpStatus;
	    private String message;
	    private T result;
	    private List<String> errors;

	    public GateWayResponse(T result) {
	        this.result = result;
	        this.isSuccess =Boolean.TRUE;
	    }

	    public GateWayResponse(final List<String> errors, final Boolean isSuccses) {
	        this.errors = errors;
	        this.isSuccess = isSuccses;
	    }

	    public GateWayResponse(HttpStatus httpStatus, final String message, final List<String> errors) {
	        super();
	        this.httpStatus = httpStatus;
	        this.message = message;
	        this.errors = errors;
	    }
	    public GateWayResponse(HttpStatus httpStatus, final String message, boolean isSuccess) {
	        super();
	        this.httpStatus = httpStatus;
	        this.message = message;
	        this.isSuccess = isSuccess;
	    }

	    public GateWayResponse(HttpStatus httpStatus, final String message, final String error) {
	        super();
	        this.isSuccess = true;
	        this.httpStatus = httpStatus;
	        this.message = message;
	        this.errors = Arrays.asList(error);
	    }

	    public GateWayResponse(final HttpStatus httpStatus, final T result, String message) {
	        super();
	        this.isSuccess = true;
	        this.result = result;
	        this.httpStatus = httpStatus;
	        this.message = message;
	    }
	    public GateWayResponse(final HttpStatus httpStatus, final T result, String message,boolean isSuccess) {
	        super();
	        this.isSuccess = isSuccess;
	        this.result = result;
	        this.httpStatus = httpStatus;
	        this.message = message;
	    }
	    public GateWayResponse(final HttpStatus httpStatus, String message) {
	        super();
	        this.httpStatus = httpStatus;
	        this.message = message;
	    }

	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public Boolean getIsSuccess() {
	        return isSuccess;
	    }

	    public void setIsSuccess(Boolean success) {
	        isSuccess = success;
	    }

	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public HttpStatus getHttpStatus() {
	        return httpStatus;
	    }

	    public void setHttpStatus(HttpStatus httpStatus) {
	        this.httpStatus = httpStatus;
	    }

	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public T getResult() {
	        return result;
	    }

	    public void setResult(T result) {
	        this.result = result;
	    }

	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    public List<String> getErrors() {
	        return errors;
	    }

	    public void setErrors(List<String> errors) {
	        this.errors = errors;
	    }

	    public void setError(final String error) {
	        errors = Arrays.asList(error);
	    }
}
