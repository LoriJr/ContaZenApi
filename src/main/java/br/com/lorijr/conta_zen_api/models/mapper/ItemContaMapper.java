package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.ItemConta;
import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemContaMapper {
    ItemContaDTO toItemContaDTO(ItemConta itemConta);
    ItemConta toItemConta(ItemContaDTO itemContaDTO);
}
