package com.arquitecturajava.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.arquitecturajava.dominio.Libro;

public class Principal {
	public static void main (String[] args) {
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "biblioteca" );
		EntityManager em = emf.createEntityManager();
		System.out.println( em.find( Libro.class, "1AB" ) );
	}
}