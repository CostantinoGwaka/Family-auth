package com.isofttz.family.auth.family_auth.repository;

import com.isofttz.family.auth.family_auth.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserName(String userName);

    Boolean existsByPhone(String phone);

    boolean existsById(Long userId);

    Optional<Users> findByPhone(String phone);


}
