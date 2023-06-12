package Plasma.Dynamics.repos;

import Plasma.Dynamics.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
