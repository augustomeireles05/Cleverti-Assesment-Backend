package pt.com.assesment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import pt.com.assesment.domain.dto.NormaliserDto;

public interface NormaliserService {

	public ResponseEntity<NormaliserDto> save(NormaliserDto form, UriComponentsBuilder uriBuilder);

	public List<NormaliserDto> toList(String jobName);
	
}
