package com.example.clase02.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase02.model.Paciente;
import com.example.clase02.service.PacienteServiceImpl;



@RestController
@RequestMapping("api")
public class PacienteController {
	
	@Autowired
	private PacienteServiceImpl pacienteimplement;
	
	@PostMapping("/save")
	public ResponseEntity<Paciente> save(@RequestBody Paciente p){
		try {
			Paciente paci = pacienteimplement.create(new Paciente(p.getDni(),p.getNombres(),p.getApellidos(),p.getDireccion(),p.getTelefono()));
			return new ResponseEntity<>(paci,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/paciente")
	public ResponseEntity<List<Paciente>> getPaciente(){
		try {
			List<Paciente> list = new ArrayList<>();
			list=pacienteimplement.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/paciente/{id}")
	public ResponseEntity<Paciente> getPacienteID(@PathVariable("id") int id){
		Paciente p = pacienteimplement.read(id);
		if (p.getId()>0) {
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/id")
		public ResponseEntity<Paciente> delete(@PathVariable("id")int id){
			try {
				pacienteimplement.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/paciente/update/id")
	public ResponseEntity<Paciente> update(@RequestBody Paciente p, @PathVariable("id") int id){
		try {
			Paciente ul = pacienteimplement.read(id);
			if(ul.getId()>0) {
				ul.setNombres(p.getNombres());
				ul.setApellidos(p.getApellidos());
				ul.setDni(p.getDni());
				ul.setTelefono(p.getTelefono());
				ul.setDireccion(p.getDireccion());
				return new ResponseEntity<>(pacienteimplement.update(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
