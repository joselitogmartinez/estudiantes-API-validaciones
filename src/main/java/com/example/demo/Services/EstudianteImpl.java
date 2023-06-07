package com.example.demo.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DAO.DAOInterface;
import com.example.demo.Entities.EstudianteEntity;

public class EstudianteImpl implements EstudianteService {
	
	@Autowired
	DAOInterface EstudianteDAO;

	@Override
	public List<EstudianteEntity> listar() {
		// TODO Auto-generated method stub
		return (List<EstudianteEntity>) EstudianteDAO.findAll();
	}

	@Override
	public EstudianteEntity buscarId(long Id) {
		// TODO Auto-generated method stub
		Optional<EstudianteEntity> opstudent = EstudianteDAO.findById(Id);
		if(opstudent.isPresent()) {
			return opstudent.get();
		}
		return null;
	}

	@Override
	public EstudianteEntity buscarNombre(String Nombre) {
		Optional<EstudianteEntity> opName = EstudianteDAO.findByName(Nombre);
		if(opName.isPresent()) {
			return opName.get();
		}
		return null;
	}

	@Override
	public void crear(EstudianteEntity Estudiante) {
		// TODO Auto-generated method stub
		EstudianteDAO.save(Estudiante);
	}

	@Override
	public void modificar(long Id, EstudianteEntity Student) {
		// TODO Auto-generated method stub
		if(EstudianteDAO.existsById(Id)){
			Student.setId(Id);;
			EstudianteDAO.save(Student);
		}
	}

	@Override
	public void eliminar(long Id) {
		// TODO Auto-generated method stub
		if(EstudianteDAO.existsById(Id)) {
			EstudianteDAO.deleteById(Id);	
		}
	}
}
