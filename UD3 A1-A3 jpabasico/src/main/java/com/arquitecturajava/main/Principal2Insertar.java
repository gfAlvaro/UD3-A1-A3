package com.arquitecturajava.main;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import com.arquitecturajava.dominio.Libro;

public class Principal2Insertar {
	public static void main( String[] args ){
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "biblioteca" );
		EntityManager em = emf.createEntityManager();
		
		SimpleDateFormat ffecha = new SimpleDateFormat( "d/M/yyyy" );

		try {
			Date fecha = ffecha.parse( "1/01/2020" );
			Libro l1 = new Libro( "2A", "JPA", "Ana", fecha, 3 );
			
			em.getTransaction().begin();
			em.persist(l1);
			em.getTransaction().commit();
		} catch ( IllegalArgumentException e ) { e.printStackTrace(); }
		  catch ( IllegalStateException e ) { e.printStackTrace(); }
		  catch (ParseException e ) { e.printStackTrace(); }
		  catch (EntityExistsException e ) { e.printStackTrace(); }
		  catch (TransactionRequiredException e ) { e.printStackTrace(); }
	}
}