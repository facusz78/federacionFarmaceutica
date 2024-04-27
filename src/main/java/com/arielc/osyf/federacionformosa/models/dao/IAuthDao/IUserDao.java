package com.arielc.osyf.federacionformosa.models.dao.IAuthDao;

import org.springframework.data.repository.CrudRepository;

import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;



public interface IUserDao extends CrudRepository<userEntity, Long>{
     boolean existsByCorreo(String correo);
     userEntity findByCorreo(String correo);
}
