package br.com.lorijr.conta_zen_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemConta {

    private String descricao;
    private double valor;
    private LocalDate dataVencimento;
}
