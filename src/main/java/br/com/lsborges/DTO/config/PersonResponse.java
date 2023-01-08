package br.com.lsborges.DTO.config;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private Long id;
    private String name;
    private String birthdate;
    public List<EnderecoResponse> address;

    public String menssage(String txt) {
    	return txt;
    }
}
