package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.ItemConta;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerContaAvulsaDTO;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

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
        container.setListaDespesasAvulsas(itemContaMapper.toItemContaDTO(fatura.getContaAvulsa()));

        container.setTotalDespesasAvulsas(fatura.getTotalContasAvulsas());

        return container;
    }

    default List<ItemConta> map(ContainerContaAvulsaDTO container) {
        if (container == null) return null;

        List<ItemContaDTO> itensDto = container.getListaDespesasAvulsas();
        ItemContaMapper itemContaMapper = Mappers.getMapper(ItemContaMapper.class);

        return itemContaMapper.toItemConta(itensDto);
    }

    List<FaturaDTO> toDTO(List<Fatura> faturas);
    Fatura toEntity(FaturaDTO faturaDTO);
    void updateFromDTO(FaturaDTO faturaDTO, @MappingTarget Fatura fatura);
    }
