package com.arielc.osyf.federacionformosa.models.dao.IRegistersDao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.arielc.osyf.federacionformosa.models.entity.entitys.Farmacia;

public interface IFarmaciaDao extends CrudRepository<Farmacia, Long>{

    Farmacia save(Optional<Farmacia> farmaciaEdit);
    
}
