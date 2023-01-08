package br.com.lsborges.DTO.config;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private Long id;

    @NotBlank(message = "Nome do paciente é obrigatório")
    private String name;
    @NotBlank(message = "A data de nascimento do paciente é obrigatório")
    private String birthdate;
    @NotBlank(message = "Endereço do paciente é obrigatório")
    private EnderecoResponse address;
}
