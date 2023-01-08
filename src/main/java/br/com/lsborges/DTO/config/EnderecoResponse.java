package br.com.lsborges.DTO.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {
	 private Long id;
	   private String city;
	    private Long zipCode;
	    private String place;
	    private String number;
}
