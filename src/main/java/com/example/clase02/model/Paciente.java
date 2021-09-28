package com.example.clase02.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		private String dni;
		
		private String nombres;
		
		private String apellidos;
		
		private String direccion;
		
		private String telefono;

		public Paciente(String dni, String nombres, String apellidos, String direccion, String telefono) {
			this.dni = dni;
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.direccion = direccion;
			this.telefono = telefono;
		}
		
		
		
	
		
		
	
}
