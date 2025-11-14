package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.ItemConta;
import br.com.lorijr.conta_zen_api.models.dto.ContainerContaAvulsaDTO;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemContaMapper.class})
public interface FaturaMapper {

    @Mapping(source = "valorTotal", target = "valorTotal")
    @Mapping(target = "contaAvulsa", expression = "java(mapContaAvulsa(fatura))")
    FaturaDTO toDTO(Fatura fatura);

    default ContainerContaAvulsaDTO mapContaAvulsa(Fatura fatura){
        if(fatura == null) return null;

        ItemContaMapper itemContaMapper = Mappers.getMapper(ItemContaMapper.class);
        ContainerContaAvulsaDTO container = new ContainerContaAvulsaDTO();
        container.setListaItens(itemContaMapper.toItemContaDTO(fatura.getContaAvulsa()));

        container.setTotalItensAvulsos(fatura.getTotalContasAvulsas());

        return container;
    }

    // Adicione este método ao FaturaMapper.java
    default List<ItemConta> map(ContainerContaAvulsaDTO container) {
        if (container == null) return null;

        // 1. Pega a lista de DTOs do Container
        List<ItemContaDTO> itensDto = container.getListaItens();

        // 2. Converte a lista de DTOs de volta para Entidades (ItemConta)
        // Usando o mapper auxiliar (acessado via Mappers.getMapper())
        ItemContaMapper itemContaMapper = Mappers.getMapper(ItemContaMapper.class);

        return itemContaMapper.toItemConta(itensDto);
        // OBS: O nome do método no ItemContaMapper deve ser 'toItemConta' e aceitar List<ItemContaDTO>
    }

    List<FaturaDTO> toDTO(List<Fatura> faturas);
    Fatura toEntity(FaturaDTO faturaDTO);
    void updateFromDTO(FaturaDTO faturaDTO, @MappingTarget Fatura fatura);
    }
