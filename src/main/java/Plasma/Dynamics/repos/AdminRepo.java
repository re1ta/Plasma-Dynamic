package Plasma.Dynamics.repos;

import Plasma.Dynamics.Dto.AdminField;
import Plasma.Dynamics.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<AdminField, Integer> {
    @Query(value = "UPDATE admin_field SET one = ?1 WHERE id = 1", nativeQuery = true)
    @Modifying
    void updateInfoOne(int price);

    @Query(value = "UPDATE admin_field SET two = ?1 WHERE id = 2", nativeQuery = true)
    @Modifying
    void updateInfoTwo(int price);
}