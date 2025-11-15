package br.com.lorijr.conta_zen_api.models.dto.container;

import br.com.lorijr.conta_zen_api.models.dto.CartaoDeCreditoDTO;
import lombok.Data;

@Data
public class ContainerCartaoDeCreditoDTO {

    private CartaoDeCreditoDTO cartaoDeCredito;
    private Double totalCartoDeCretido;
}
