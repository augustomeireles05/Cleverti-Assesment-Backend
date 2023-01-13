package pt.com.assesment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import pt.com.assesment.domain.dto.NormaliserDto;
import pt.com.assesment.service.NormaliserService;

@RestController
@RequestMapping("/v1/api/clevertiassesment")
public class NormaliserController {
	
	@Autowired
	NormaliserService normaliserService;
	
	@ApiOperation(value = "Save a new job")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successful Request."),
			@ApiResponse(code = 401, message = "Access denied."),
			@ApiResponse(code = 500, message = "Unkown error.")})
	@PostMapping(value = "/jobs")
	public ResponseEntity<ResponseEntity<NormaliserDto>> save(@Valid @RequestBody final NormaliserDto form, UriComponentsBuilder uriBuilder) {
		return ResponseEntity.ok().body(normaliserService.save(form, uriBuilder));
	}
	
	@ApiOperation(value = "List of an advanted seach of job.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfull Request"),
			@ApiResponse(code = 404, message = "Datas not found."),
			@ApiResponse(code = 500, message = "Unkown error.")})
	@GetMapping("/tolistby")
	public List<NormaliserDto> toList(
			@RequestParam(required = false) String jobName) {
		return normaliserService.toList(jobName);
	}
}
