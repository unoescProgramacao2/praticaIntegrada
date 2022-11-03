package app.repositories;

import java.util.List;
import java.util.Optional;

import app.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String username);

    public List<User> findAll();
}
