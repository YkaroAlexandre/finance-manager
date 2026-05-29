package com.ykaro.financemanager.repository;

import com.ykaro.financemanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
