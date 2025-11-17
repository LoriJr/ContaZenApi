package br.com.lorijr.conta_zen_api.config;

import br.com.lorijr.conta_zen_api.models.*;
import br.com.lorijr.conta_zen_api.repository.FaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class Instanciation implements CommandLineRunner {

    @Autowired
    private FaturaRepository faturaRepository;

    @Override
    public void run(String... args) throws Exception {

        faturaRepository.deleteAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse("09/09/2023", formatter);

        Pessoa pessoa1 = new Pessoa("Junior", new Salario(1300.0, 1500.0));
        Pessoa pessoa2 = new Pessoa("Louri", new Salario(0.0, 1500.0));

        ItemConta itemConta1 = new ItemConta("Conta de Gas", 156.00, data);
        ItemConta itemConta2 = new ItemConta("IPTU", 70.0, data);

        ItemConta item1 = new ItemConta("Conta de luz", 210, data);
        ItemConta item2 = new ItemConta("Conta de agua", 56.00, data);
        ItemConta item3 = new ItemConta("Conta de internet", 320.0, data);

        List<ItemConta> list = List.of(item1, item2, item3);

        CartaoDeCredito cartao = new CartaoDeCredito(list);

        Fatura fatura = new Fatura("1", data, List.of(pessoa1, pessoa2), List.of(itemConta1, itemConta2), cartao);

        faturaRepository.save(fatura);

    }
}
