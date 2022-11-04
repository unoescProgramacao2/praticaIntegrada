package app.repositories;

import app.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {

    public Item findById(Long id);

    public Item findByNome(String nome);

    public List<Item> findAll();
}
