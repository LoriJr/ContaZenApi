package br.com.lorijr.conta_zen_api.models.mapper;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FaturaMapper {

    FaturaDTO toDTO(Fatura fatura);
    List<FaturaDTO> toDTO(List<Fatura> faturas);
    Fatura toEntity(FaturaDTO faturaDTO);
    void updateFromDTO(FaturaDTO faturaDTO, @MappingTarget Fatura fatura);
    }
