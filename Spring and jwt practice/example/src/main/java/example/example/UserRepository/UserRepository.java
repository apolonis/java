package example.example.UserRepository;

import example.example.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

    String deleteByUuid(String uuid);
    User findByUuid(String uuid);
    User findByEmail(String email);


}
