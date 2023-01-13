package pt.com.assesment.service.impl;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import pt.com.assesment.domain.Normaliser;
import pt.com.assesment.domain.dto.NormaliserDto;
import pt.com.assesment.repository.AdvancedConsultRepository;
import pt.com.assesment.repository.NormaliserRepository;
import pt.com.assesment.service.NormaliserService;

@Slf4j
@Service
public class NormaliserServiceImpl implements NormaliserService {
	
	private static final String SAVE_ERROR = "It happened something wrong when you wanted to save it: ";
	private static final String GET_LIST_ERROR = "It happened something wrong when you requested to get the advanced list: ";
	
	@Autowired
	private NormaliserRepository normaliserRepository;
	
	@Autowired
	private AdvancedConsultRepository advancedConsultRepository;

	@Override
	public ResponseEntity<NormaliserDto> save( NormaliserDto form, UriComponentsBuilder uriBuilder) {
		
		try {
			Normaliser normaliser = form.converter();
			normaliserRepository.save(normaliser);
			URI uri = uriBuilder.path("/normaliser/{id}").buildAndExpand(normaliser.getId()).toUri();
			return ResponseEntity.created(uri).body(new NormaliserDto());
		} catch (Exception e) {
			log.error(SAVE_ERROR + e.getMessage());
			log.info("Something got wrong: " +  e.getStackTrace());
			return null;
		}
				
	}

	@Override
	public List<NormaliserDto> toList(String jobName) {
		
		try {	
				
			if(jobName == null) {
				List<Normaliser> normaliser = normaliserRepository.findAll();
				return NormaliserDto.convert(normaliser);
			} else {
				List<Normaliser> normaiser = advancedConsultRepository.getByJobName(jobName);
				return NormaliserDto.convert(normaiser);
			}
					
		} catch (Exception e) {
			log.error(GET_LIST_ERROR + e.getMessage());
			e.getStackTrace();
			return null;
		}
	}
	
	

}
