package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Pessoa;
import br.com.lorijr.conta_zen_api.models.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaDTO toDTO(Pessoa pessoa);
    Pessoa toEntity(PessoaDTO pessoaDTO);
}
