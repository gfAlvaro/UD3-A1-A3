package com.arquitecturajava.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

import com.arquitecturajava.dominio.Libro;

public class Principal3Borrar {
	public static void main (String[] args) {
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "biblioteca" );
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove( em.find( Libro.class, "2AC" ) );
			em.getTransaction().commit();
		} catch ( IllegalArgumentException e ){ e.printStackTrace(); }
		  catch ( IllegalStateException e ){ e.printStackTrace(); }
		  catch ( RollbackException e ){ e.printStackTrace(); }
		  catch ( TransactionRequiredException e ){ e.printStackTrace(); }
	}
}