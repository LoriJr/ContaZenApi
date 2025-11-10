package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.CartaoDeCredito;
import br.com.lorijr.conta_zen_api.models.dto.CartaoDeCreditoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoDeCreditoMapper {
    CartaoDeCreditoDTO toDTO(CartaoDeCredito cartaoDeCredito);
    CartaoDeCredito toEntity(CartaoDeCreditoDTO cartaoDeCreditoDTO);
}
