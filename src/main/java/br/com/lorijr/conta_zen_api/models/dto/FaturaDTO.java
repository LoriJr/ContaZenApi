package br.com.lorijr.conta_zen_api.models.dto;

import br.com.lorijr.conta_zen_api.models.Pessoa;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerContaAvulsaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FaturaDTO {

    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yyyy")
    private LocalDate mesReferencia;
    private List<Pessoa> pessoas;
    private ContainerContaAvulsaDTO contaAvulsa;
    private ContainerContaAvulsaDTO cartaoDeCredito;
    private Double valorTotal;
}
