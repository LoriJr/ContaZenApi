package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.CartaoDeCredito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoDeCreditoDTO {
    CartaoDeCreditoDTO toDTO(CartaoDeCredito cartaoDeCredito);
    CartaoDeCredito toEntity(CartaoDeCreditoDTO cartaoDeCreditoDTO);
}
