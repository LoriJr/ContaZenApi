package br.com.lorijr.conta_zen_api.models.dto;

import lombok.Data;

@Data
public class PessoaDTO {
    private String nome;
    private SalarioDTO salario;
    private Double salarioTotal;
}
