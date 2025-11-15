package br.com.lorijr.conta_zen_api.models.dto.container;

import br.com.lorijr.conta_zen_api.models.CartaoDeCredito;
import lombok.Data;

@Data
public class ContainerCartaoDeCretidoDTO {

    private CartaoDeCredito cartaoDeCredito;
    private Double totalCartoDeCretido;
}
