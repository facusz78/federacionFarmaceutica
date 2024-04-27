package com.arielc.osyf.federacionformosa.models.service.userServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arielc.osyf.federacionformosa.models.dao.IAuthDao.IUserDao;
import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;
import com.arielc.osyf.federacionformosa.models.security.jwt;




@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwt jwtUtil;

    @Autowired
    private EmailService emailService;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<userEntity> findAll() {
        return (List<userEntity>) userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public userEntity findByCorreo(String correo) {
       return userDao.findByCorreo(correo);
    }

    @Override
    public userEntity save(userEntity user) {
        // Verifica si la contraseña es nueva o ya está codificada
        String plainPassword = user.getPassword();
        if (plainPassword != null && !plainPassword.startsWith("$2a$")) {
            // La contraseña no está codificada, así que la codificamos
            user.setPasswordEncoded(passwordEncoder, plainPassword);
        }
        return userDao.save(user);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return userDao.existsByCorreo(correo);
    }

    @SuppressWarnings("null")
    @Override
    @Transactional(readOnly = true)
    public userEntity findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void forgotPassword(String email) {
        userEntity user = userDao.findByCorreo(email);
        if (user == null) {
            throw new UsernameNotFoundException("No se encontró un usuario con el correo electrónico: " + email);
        }
    
        // Genera el token de restablecimiento de contraseña usando jwt.generateTokenDetail
        String resetToken = jwtUtil.generateTokenDetail(user.getCorreo());
    
        // Envía el correo electrónico
        String resetUrl = "https://intranet.caritaschiclayo.org.pe/auth/reset-password?token=" + resetToken;
        emailService.sendResetPasswordEmail(user.getCorreo(), resetUrl);
    }
    
}
