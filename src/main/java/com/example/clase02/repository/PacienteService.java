package com.example.clase02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clase02.model.Paciente;

@Repository
public interface PacienteService extends JpaRepository<Paciente, Integer>{

}
