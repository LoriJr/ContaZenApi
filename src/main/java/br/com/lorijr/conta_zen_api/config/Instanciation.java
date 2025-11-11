package br.com.lorijr.conta_zen_api.config;

import br.com.lorijr.conta_zen_api.models.CartaoDeCredito;
import br.com.lorijr.conta_zen_api.models.Fatura;
import br.com.lorijr.conta_zen_api.models.ItemConta;
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

        ItemConta itemConta = new ItemConta("Conta de Gas", 56.00, data);

        ItemConta item1 = new ItemConta("Conta de luz", 56.00, data);
        ItemConta item2 = new ItemConta("Conta de agua", 56.00, data);
        ItemConta item3 = new ItemConta("Conta de internet", 56.00, data);

        List<ItemConta> list = List.of(item1, item2, item3);

        CartaoDeCredito cartao = new CartaoDeCredito(list);

        Fatura fatura = new Fatura("1", List.of(itemConta), cartao);

        faturaRepository.save(fatura);

    }
}
