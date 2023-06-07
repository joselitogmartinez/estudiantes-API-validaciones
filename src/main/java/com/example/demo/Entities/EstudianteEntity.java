package com.example.demo.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
public class EstudianteEntity {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "name")
	private String Name;
	@Column(name = "email")
	private String Email;
	@Column(name = "carnet")
	private String Carnet;
	@Column(name = "average")
	private int average;
	@Column(name = "createAt")
	@Temporal(TemporalType.DATE)
	private Date createat;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCarnet() {
		return Carnet;
	}
	public void setCarnet(String carnet) {
		Carnet = carnet;
	}
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public Date getCreateat() {
		return createat;
	}
	public void setCreateat(Date createat) {
		this.createat = createat;
	}
	
}
