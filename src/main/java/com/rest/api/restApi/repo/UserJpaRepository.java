package com.rest.api.restApi.repo;

import com.rest.api.restApi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<Users,Long> {
    Users findByName(String name);
}
