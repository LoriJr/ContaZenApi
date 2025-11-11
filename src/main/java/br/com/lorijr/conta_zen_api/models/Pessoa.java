package br.com.lorijr.conta_zen_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {

    private String nome;
    private Salario salario;
}
