package br.com.lorijr.conta_zen_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salario {

    private Double salarioQuinzenaUm;
    private Double salarioQuinzenaDois;

    public Double getSomaSalario(){
        return this.salarioQuinzenaUm + this.salarioQuinzenaDois;
    }
}
