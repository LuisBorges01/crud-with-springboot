package br.com.lsborges.DTO.Mapper;

import java.util.stream.Collectors;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lsborges.DTO.config.PersonRequest;
import br.com.lsborges.DTO.config.PersonResponse;
import br.com.lsborges.model.Person;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class PersonMapper {
	@Autowired
	private ModelMapper mapper;

    public Person toPerson(PersonRequest request) { /*Request to Person*/
        return mapper.map(request, Person.class);
    }

    public PersonResponse toPersonResponse(Person person) {/*Person to PersonResponse(getters)*/
        return mapper.map(person, PersonResponse.class);
    }

    public List<PersonResponse> toPersonResponseList(List<Person> person) {
        return person.stream() /*ListPerson for listPacienteResponse*/
                .map(this::toPersonResponse)
                .collect(Collectors.toList());
    }

}
