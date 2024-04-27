package com.arielc.osyf.federacionformosa.models.service.userServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;


@Service
public interface IUserService {

    public List<userEntity> findAll();

    public userEntity findByCorreo(String correo);
    
    public userEntity findById(Long id);

    public userEntity save(userEntity user);

   public boolean existsByCorreo(String correo);

   void forgotPassword(String email);
}
