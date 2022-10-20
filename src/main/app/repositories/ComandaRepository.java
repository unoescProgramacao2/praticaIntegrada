package edu.br.unoesc.app.repositories;

import edu.br.unoesc.app.entities.Comanda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda, String> {

    public Comanda findById(Long id);

    public List<Comanda> findAll();

}
