package br.com.lorijr.conta_zen_api.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartaoDeCredito{

    private List<ItemConta> compras;

    public CartaoDeCredito(List<ItemConta> compras){

        this.compras = compras;
    }
}
