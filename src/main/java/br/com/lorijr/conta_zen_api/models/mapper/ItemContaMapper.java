package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.ItemConta;
import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemContaMapper {
    List<ItemContaDTO> toItemContaDTO(List<ItemConta> itemConta);
    List<ItemConta> toItemConta(List<ItemContaDTO> itemContaDTO);
}
