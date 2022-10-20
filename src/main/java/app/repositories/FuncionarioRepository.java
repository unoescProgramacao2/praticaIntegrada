package app.repositories;

import app.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

    public Funcionario findById(Long id);

    public Funcionario findByNome(String nome);

    public List<Funcionario> findAll();
}
