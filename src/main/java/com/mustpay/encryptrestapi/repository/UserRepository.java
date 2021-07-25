package com.mustpay.encryptrestapi.repository;

import com.mustpay.encryptrestapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
