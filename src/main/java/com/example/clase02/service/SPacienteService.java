package com.example.clase02.service;

import java.util.List;

import com.example.clase02.model.Paciente;

public interface SPacienteService {
	Paciente create(Paciente p);
	List<Paciente> readAll();
	Paciente read(int id);
	void delete(int id);
	Paciente update(Paciente p);
}
