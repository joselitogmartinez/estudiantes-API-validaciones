package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;

import com.example.demo.Entities.EstudianteEntity;
import com.example.demo.Services.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	 EstudianteService estudianteService;
	
	@GetMapping()
	public List<EstudianteEntity> listadoEstudiantes(){
		
		return estudianteService.listar();
	}
	
	@GetMapping("/{nombre}")
	public EstudianteEntity buscarEstudiante(@PathVariable String e) {
		if(e.matches("-?\\d+")) {
			long Id = Long.parseLong(e);
			
			return estudianteService.buscarId(Id);		
		}else {
			
			return estudianteService.buscarNombre(e);	
		}	
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void crearEstudiante( @RequestBody EstudianteEntity Estudiante) {
		estudianteService.crear(Estudiante);
	}
	
	@PutMapping("/{id}")
	public void actualizarEstudiante(@PathVariable long Id, @RequestBody EstudianteEntity Estudiante) {
		estudianteService.modificar(Id, Estudiante);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarEstudiante(@PathVariable long Id) {
		estudianteService.eliminar(Id);
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex){
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
