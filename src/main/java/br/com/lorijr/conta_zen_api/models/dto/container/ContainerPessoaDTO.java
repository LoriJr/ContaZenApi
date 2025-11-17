package br.com.lorijr.conta_zen_api.models.dto.container;

import br.com.lorijr.conta_zen_api.models.Pessoa;
import br.com.lorijr.conta_zen_api.models.dto.PessoaDTO;
import lombok.Data;

import java.util.List;

@Data
public class ContainerPessoaDTO {

    private List<PessoaDTO> pessoas;
    private Double totalRenda;
}
