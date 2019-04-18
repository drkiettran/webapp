package com.drkiettran.webapp.service;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.drkiettran.webapp.model.Message;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Specification for greeting message exchange.
 * 
 * @author ktran
 *
 */
@Validated
@Api(value = "greetings")
public interface GreetingsAPI {
	@ApiOperation(value = "", nickname = "put", notes = "", response = Message.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Message.class) })
	@RequestMapping(value = "/greetings/sayHello", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Message> put(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Greetings", required = true) @Valid @RequestBody Message greetingsMessage) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
