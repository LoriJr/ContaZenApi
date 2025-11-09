package br.com.lorijr.conta_zen_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "faturas")
public class Fatura {

    private String id;
    private List<ItemConta> contaAvulsa;
    private CartaoDeCredito cartaoDeCredito;
}
