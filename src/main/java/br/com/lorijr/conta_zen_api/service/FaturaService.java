package br.com.lorijr.conta_zen_api.service;

import br.com.lorijr.conta_zen_api.exception.ResourceNotFoundException;
import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import br.com.lorijr.conta_zen_api.models.mapper.FaturaMapper;
import br.com.lorijr.conta_zen_api.repository.FaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FaturaService {

    private final FaturaRepository faturaRepository;
    private final FaturaMapper faturaMapper;

    public FaturaDTO salvarFatura(FaturaDTO faturaDTO)
    {
        Fatura fatura = faturaMapper.toEntity(faturaDTO);
        Fatura faturaSalva = faturaRepository.save(fatura);
        return faturaMapper.toDTO(faturaSalva);
    }

    public List<FaturaDTO> listarFatura(){
        List<Fatura> faturas = faturaRepository.findAll();
        faturas.getFirst().getContaAvulsa().sort(Collections.reverseOrder());
        faturas.getFirst().getCartaoDeCredito().getCompras().sort(Collections.reverseOrder());
        return faturaMapper.toDTO(faturas);
    }

    public FaturaDTO listarPorId(String id){
        Fatura fatura = faturaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fatura não encontrada"));
        return faturaMapper.toDTO(fatura);
    }

    public FaturaDTO atualizarFatura(String id, FaturaDTO dadosAtualizadosDTO){
        // 1. Busca a entidade que já existe no banco
        Fatura faturaAtual = faturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fatura não encontrada"));

        // 2. Usa o mapper para ATUALIZAR a entidade existente ('faturaAtual')
        //    com os dados do DTO. O ID da 'faturaAtual' é preservado.
        faturaMapper.updateFromDTO(dadosAtualizadosDTO, faturaAtual);

        // 3. Salva a entidade atualizada
        Fatura faturaSalva = faturaRepository.save(faturaAtual);

        // 4. Retorna o DTO correspondente
        return faturaMapper.toDTO(faturaSalva);
    }

    public void deletarFatura(String id){
        faturaRepository.deleteById(id);
    }
}
