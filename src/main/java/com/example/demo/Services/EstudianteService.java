package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.EstudianteEntity;

public interface EstudianteService {
	
	public List<EstudianteEntity> listar();
	public EstudianteEntity buscarId(long Id);
	public EstudianteEntity buscarNombre(String Name);
	public void crear(EstudianteEntity Student);
	public void modificar(long Id, EstudianteEntity Student);
	public void eliminar(long Id);

}
