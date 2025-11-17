package br.com.lorijr.conta_zen_api.models.dto;

import br.com.lorijr.conta_zen_api.models.dto.container.ContainerCartaoDeCreditoDTO;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerContaAvulsaDTO;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerPessoaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FaturaDTO {

    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private LocalDate mesReferencia;
    private ContainerPessoaDTO pessoas;
    private ContainerContaAvulsaDTO contaAvulsa;
    private ContainerCartaoDeCreditoDTO cartaoDeCredito;
    private Double valorTotal;
}
