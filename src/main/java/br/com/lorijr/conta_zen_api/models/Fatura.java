package br.com.lorijr.conta_zen_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "faturas")
public class Fatura {

    private String id;
    private LocalDate mesReferencia;
    private List<Pessoa> pessoas;
    private List<ItemConta> contaAvulsa;
    private CartaoDeCredito cartaoDeCredito;

    public Double getValorTotal() {
        Double totalContasAvulsas = Optional.ofNullable(contaAvulsa)
                .orElseGet(Collections::emptyList)
                .stream()
                .mapToDouble(ItemConta::getValor)
                .sum();

        Double totalCartaoDeCredito = 0.0;

        if (Objects.nonNull(cartaoDeCredito)) {
            totalCartaoDeCredito = Optional.ofNullable(cartaoDeCredito.getCompras())
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .mapToDouble(ItemConta::getValor)
                    .sum();
        }
        return totalContasAvulsas + totalCartaoDeCredito;
    }

    public Double getTotalContasAvulsas(){
        return Optional.ofNullable(contaAvulsa)
                .orElseGet(Collections::emptyList)
                .stream()
                .mapToDouble(ItemConta::getValor)
                .sum();
    }

    public Double getTotalCartaoDeCretido(){
        return Optional.ofNullable(cartaoDeCredito.getCompras())
                .orElseGet(Collections::emptyList)
                .stream()
                .mapToDouble(ItemConta::getValor)
                .sum();
    }
}
