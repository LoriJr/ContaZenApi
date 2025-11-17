package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.CartaoDeCredito;
import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.ItemConta;
import br.com.lorijr.conta_zen_api.models.Pessoa;
import br.com.lorijr.conta_zen_api.models.dto.PessoaDTO;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerCartaoDeCreditoDTO;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerContaAvulsaDTO;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import br.com.lorijr.conta_zen_api.models.dto.ItemContaDTO;
import br.com.lorijr.conta_zen_api.models.dto.container.ContainerPessoaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemContaMapper.class, CartaoDeCreditoMapper.class, PessoaMapper.class})
public interface FaturaMapper {

    @Mapping(source = "valorTotal", target = "valorTotal")
    @Mapping(target = "contaAvulsa", expression = "java(mapContaAvulsa(fatura))")
    @Mapping(target = "cartaoDeCredito", expression = "java(mapCartaoDeCredito(fatura))")
    @Mapping(target = "pessoas", expression = "java(mapPessoa(fatura))")
    FaturaDTO toDTO(Fatura fatura);

    default ContainerContaAvulsaDTO mapContaAvulsa(Fatura fatura){
        if(fatura == null) return null;

        ItemContaMapper itemContaMapper = Mappers.getMapper(ItemContaMapper.class);
        ContainerContaAvulsaDTO container = new ContainerContaAvulsaDTO();
        container.setListaDespesasAvulsas(itemContaMapper.toItemContaDTO(fatura.getContaAvulsa()));
        container.setTotalDespesasAvulsas(fatura.getTotalContasAvulsas());
        return container;
    }

    default ContainerCartaoDeCreditoDTO mapCartaoDeCredito(Fatura fatura){
        if(fatura == null) return null;

        CartaoDeCreditoMapper cartaoDeCreditoMapper = Mappers.getMapper(CartaoDeCreditoMapper.class);
        ContainerCartaoDeCreditoDTO containerCartaoDeCreditoDTO = new ContainerCartaoDeCreditoDTO();
        containerCartaoDeCreditoDTO.setCartaoDeCredito(cartaoDeCreditoMapper.toDTO(fatura.getCartaoDeCredito()));
        containerCartaoDeCreditoDTO.setTotalCartoDeCretido(fatura.getTotalCartaoDeCredito());
        return containerCartaoDeCreditoDTO;
    }

    default ContainerPessoaDTO mapPessoa(Fatura fatura){
        if(fatura == null) return null;

        PessoaMapper pessoaMapper = Mappers.getMapper(PessoaMapper.class);
        ContainerPessoaDTO containerPessoaDTO = new ContainerPessoaDTO();
        containerPessoaDTO.setPessoas(pessoaMapper.toDTO(fatura.getPessoas()));
        containerPessoaDTO.setTotalRenda(fatura.getTotalRenda());
        return containerPessoaDTO;
    }

    default List<ItemConta> map(ContainerContaAvulsaDTO container) {
        if (container == null) return null;

        List<ItemContaDTO> itensDto = container.getListaDespesasAvulsas();
        ItemContaMapper itemContaMapper = Mappers.getMapper(ItemContaMapper.class);
        return itemContaMapper.toItemConta(itensDto);
    }

    default CartaoDeCredito map(ContainerCartaoDeCreditoDTO container) {
        if (container == null) return null;

        CartaoDeCreditoMapper cartaoMapper = Mappers.getMapper(CartaoDeCreditoMapper.class);
        return cartaoMapper.toEntity(container.getCartaoDeCredito());
    }

    default List<Pessoa> map(ContainerPessoaDTO container){
        if(container == null) return null;

        List<PessoaDTO> pessoaDTO = container.getPessoas();
        PessoaMapper pessoaMapper = Mappers.getMapper(PessoaMapper.class);
        return pessoaMapper.toEntity(pessoaDTO);
    }

    List<FaturaDTO> toDTO(List<Fatura> faturas);
    Fatura toEntity(FaturaDTO faturaDTO);
    void updateFromDTO(FaturaDTO faturaDTO, @MappingTarget Fatura fatura);
    }
