package br.com.lorijr.conta_zen_api.repository;

import br.com.lorijr.conta_zen_api.models.Fatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends MongoRepository<Fatura, String> {
}
