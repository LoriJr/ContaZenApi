package br.com.lorijr.conta_zen_api.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class FaturaDTO {

    private List<ItemContaDTO> contaAvulsa;
    private CartaoDeCreditoDTO cartaoDeCredito;
}
