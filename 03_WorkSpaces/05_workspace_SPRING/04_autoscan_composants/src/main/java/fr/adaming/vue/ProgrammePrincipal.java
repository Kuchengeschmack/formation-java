package fr.adaming.vue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.model.Adresse;
import fr.adaming.model.Employe;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Récupérer le context de Spring IoC
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application-context.xml");

		// Récupérer le bean adresse
		Adresse adresse = (Adresse) cxt.getBean("adresseBean");

		System.out.println(adresse);

		Employe emp = (Employe) cxt.getBean("empBean");

		System.out.println(emp);
	}
}
