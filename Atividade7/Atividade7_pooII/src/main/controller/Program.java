package main.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.management.PersistentMBean;

import main.entities.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf = PersistentMBean.createEntityManagerFactory("lojaCarros");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Marca ma1 = new Marca(1,"Confort");
		Modelo m1 = new Modelo(1,"ModelosFlex",20,ma1.getId());
		Automovel a1 = new Automovel(1,2015,2010,"Carro1",55000,0,m1.getId());
		
		em.persist(ma1);
		em.persist(m1);
		em.persist(a1);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();

	}

}
