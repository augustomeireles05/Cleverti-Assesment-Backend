package pt.com.assesment.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pt.com.assesment.domain.Normaliser;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NormaliserDto {
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("jobName")
	private String jobName;
	@JsonProperty("jobDescription")
	private String jobDescription;
	
	public NormaliserDto(Normaliser normaliser) {
		this.id = normaliser.getId();
		this.jobName = normaliser.getJobName();
		this.jobDescription = normaliser.getJobDescription();
	}
	
	public Normaliser converter() {
		return new Normaliser(id, jobName, jobDescription);
	}

	public static List<NormaliserDto> convert(List<Normaliser> normaliser) {
//		return normaliser.map(NormaliserDto::new);
		return normaliser.stream().map(NormaliserDto::new).collect(Collectors.toList());
	}
	
}
