package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Pessoa;
import br.com.lorijr.conta_zen_api.models.dto.PessoaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    List<PessoaDTO> toDTO(List<Pessoa> pessoa);
    List<Pessoa> toEntity(List<PessoaDTO> pessoaDTO);
}
