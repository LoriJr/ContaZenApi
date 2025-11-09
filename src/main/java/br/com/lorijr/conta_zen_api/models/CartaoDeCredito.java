package br.com.lorijr.conta_zen_api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CartaoDeCredito extends ItemConta{

    private List<ItemConta> compras;

    public CartaoDeCredito(String descricao, double valor, LocalDate dataVencimento, List<ItemConta> compras){
        super(descricao, valor, dataVencimento);
        this.compras = new ArrayList<>();
    }
}
