package br.com.lorijr.conta_zen_api.controller;

import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.dto.FaturaDTO;
import br.com.lorijr.conta_zen_api.service.FaturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<FaturaDTO>> listarFatura(){
        List<FaturaDTO> lista = faturaService.listarFatura();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaturaDTO> listarPorId(@PathVariable String id){
        FaturaDTO fatura = faturaService.listarPorId(id);
        return ResponseEntity.ok(fatura);
    }

    @PostMapping
    public ResponseEntity<FaturaDTO> salvar(@RequestBody FaturaDTO faturaDTO){
        FaturaDTO faturaSalva = faturaService.salvarFatura(faturaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(faturaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaturaDTO> atualizar(@PathVariable String id, @RequestBody FaturaDTO dadosAtualizados){
        FaturaDTO faturaAtualizada = faturaService.atualizarFatura(id, dadosAtualizados);
        return ResponseEntity.ok(faturaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        faturaService.deletarFatura(id);
        return ResponseEntity.noContent().build();
    }
}
