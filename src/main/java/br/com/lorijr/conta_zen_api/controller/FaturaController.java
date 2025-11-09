package br.com.lorijr.conta_zen_api.controller;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.service.FaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/faturas")
public class FaturaController {

    private final FaturaService faturaService;

    @GetMapping
    public List<Fatura> listarFatura(){
        return faturaService.listarFatura();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fatura> listarPorId(@PathVariable String id){
        return faturaService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fatura salvar(@RequestBody Fatura fatura){
        return faturaService.salvarFatura(fatura);
    }

    @PatchMapping
    public Fatura atualizar(@PathVariable String id, @RequestBody Fatura dadosAtualizados){
        return faturaService.atualizarFatura(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        faturaService.deletarFatura(id);
    }
}
