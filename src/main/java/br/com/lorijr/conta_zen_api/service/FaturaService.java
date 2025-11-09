package br.com.lorijr.conta_zen_api.service;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.repository.FaturaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FaturaService {

    private final FaturaRepository faturaRepository;

    public Fatura salvarFatura(Fatura fatura){
        return faturaRepository.save(fatura);
    }

    public List<Fatura> listarFatura(){
        return faturaRepository.findAll();
    }

    public Optional<Fatura> listarPorId(String id){
        return faturaRepository.findById(id);
    }

    public Fatura atualizarFatura(String id, Fatura dadosAtualizados){
Fatura faturaAtual = faturaRepository.findById(id)
        .orElseThrow(() ->new RuntimeException("Fatura não encontrada"));
        faturaAtual.setContaAvulsa(dadosAtualizados.getContaAvulsa());
        faturaAtual.setCartaoDeCredito(dadosAtualizados.getCartaoDeCredito());
        return faturaRepository.save(faturaAtual);
    }

    public void deletarFatura(String id){
        faturaRepository.deleteById(id);
    }
}
