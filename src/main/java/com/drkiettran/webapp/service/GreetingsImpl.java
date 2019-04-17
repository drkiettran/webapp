package com.drkiettran.webapp.service;

import java.net.UnknownHostException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("${com.drkiettran.webapp.service.base-path:/api/v1}")
public class GreetingsImpl implements GreetingsAPI {
	private static final Logger logger = LoggerFactory.getLogger(GreetingsImpl.class);
	@ApiOperation(value = "", nickname = "put", notes = "", response = String.class, tags = {})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = String.class) })
	@RequestMapping(value = "/greetings/sayHello", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestHeader HttpHeaders headers,
			@ApiParam(value = "Simple Greetings", required = true) @Valid @RequestBody String greetingsMessage) {
		logger.info(greetingsMessage);
		Greetings greetings = new Greetings();
		String returnGreetingsMessage = "ERROR";
		try {
			returnGreetingsMessage = greetings.hello(greetingsMessage);
		} catch (UnknownHostException e) {
			logger.error("ERROR: ", e);
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "application/json");
		logger.info(returnGreetingsMessage);
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(returnGreetingsMessage);
	}
}
