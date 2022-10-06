package edu.br.unoesc.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.br.unoesc.app.entities.Ordem;

@Repository
public interface OrdemRepository extends CrudRepository<Ordem, String> {
    public Ordem findById(Long id);

    public List<Ordem> findAll();
}
