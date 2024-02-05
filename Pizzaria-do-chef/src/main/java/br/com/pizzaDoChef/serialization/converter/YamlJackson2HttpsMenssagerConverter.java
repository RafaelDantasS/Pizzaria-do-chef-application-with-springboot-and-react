package br.com.pizzaDoChef.serialization.converter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlJackson2HttpsMenssagerConverter extends AbstractJackson2HttpMessageConverter {
	 
	public YamlJackson2HttpsMenssagerConverter() {
		super( new YAMLMapper().setSerializationInclusion(Include.NON_NULL),
					MediaType.parseMediaType("application/x-yaml")
				);
		
	}
		

}
