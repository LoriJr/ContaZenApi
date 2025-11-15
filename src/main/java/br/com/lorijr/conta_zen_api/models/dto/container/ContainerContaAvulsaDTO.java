package br.com.lorijr.conta_zen_api.models.dto.container;


import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import lombok.Data;

import java.util.List;

@Data
public class ContainerContaAvulsaDTO {
    private List<ItemContaDTO> listaDespesasAvulsas;
    private Double totalDespesasAvulsas;
}
