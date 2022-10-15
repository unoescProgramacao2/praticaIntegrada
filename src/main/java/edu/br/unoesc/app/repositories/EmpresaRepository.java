package edu.br.unoesc.app.repositories;

import edu.br.unoesc.app.entities.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, String> {

    public Empresa findById(Long id);

    public List<Empresa> findAll();
}
