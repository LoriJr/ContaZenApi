package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Salario;
import br.com.lorijr.conta_zen_api.models.dto.SalarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SalarioMapper {

    @Mapping(source = "somaSalario", target = "somaSalario")
    SalarioDTO toDTO(Salario salario);
    void updateFromDTO(SalarioDTO salarioDTO, @MappingTarget Salario salario);
}
