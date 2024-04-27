package com.arielc.osyf.federacionformosa.models.dao.IAuthDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arielc.osyf.federacionformosa.models.security.PasswordResetToken;

@Repository
public interface PasswordResetTokenDao extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
