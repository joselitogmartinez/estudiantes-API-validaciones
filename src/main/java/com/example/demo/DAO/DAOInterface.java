package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.EstudianteEntity;
import java.util.Optional;;

public interface DAOInterface extends CrudRepository<EstudianteEntity, Long>{
	public Optional<EstudianteEntity> findByName(String Name);
}
