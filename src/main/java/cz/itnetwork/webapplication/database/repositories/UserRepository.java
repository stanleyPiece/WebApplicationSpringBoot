package cz.itnetwork.webapplication.database.repositories;

import cz.itnetwork.webapplication.database.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email); //metoda k nalezení uživatele podle e-mailu
}
