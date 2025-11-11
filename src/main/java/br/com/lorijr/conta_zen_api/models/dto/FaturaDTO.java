package br.com.lorijr.conta_zen_api.models.dto;

import br.com.lorijr.conta_zen_api.models.Pessoa;
import lombok.Data;

import java.util.List;

@Data
public class FaturaDTO {
    private String id;
    private List<Pessoa> pessoas;
    private List<ItemContaDTO> contaAvulsa;
    private CartaoDeCreditoDTO cartaoDeCredito;
    private Double valorTotal;
}
