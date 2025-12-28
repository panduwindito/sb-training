package id.example.training.repository;

import id.example.training.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//class for handle query to database
//class should implement JpaRepository interface
//that already has a common query like save, findById, findAll, deleteById, etc
//jparepository has generic type <T, ID>; T = entity class, ID = primary key type
//we want to set this repository to handle UserEntity so we set UserEntity as generic type
//and UUID as primary key type because UserEntity has UUID as primary key
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
