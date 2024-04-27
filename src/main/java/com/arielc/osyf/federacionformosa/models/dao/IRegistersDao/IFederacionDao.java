package com.arielc.osyf.federacionformosa.models.dao.IRegistersDao;

import org.springframework.data.repository.CrudRepository;

import com.arielc.osyf.federacionformosa.models.entity.entitys.Federation;

public interface IFederacionDao extends CrudRepository<Federation, Long>{
    
}
