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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Validated
@Api(value = "greetings")
public interface GreetingsAPI {
	@ApiOperation(value = "", nickname = "put", notes = "", response = String.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class) })
	@RequestMapping(value = "/greetings/sayHello", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<String> put(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Greetings", required = true) @Valid @RequestBody String greetingsMessage) {
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
