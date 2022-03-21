package fr.adaming.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.Employe;
import fr.adaming.beans.Entreprise;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// Récupérer le contexte du conteneur Spring IoC
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");

		// Récupérer le bean (objet) empBean
		Employe emp = (Employe) cxt.getBean("empBean");

		System.out.println(emp);

		// Récupérer le bean esnBean
		Entreprise esn = (Entreprise) cxt.getBean("esnBean");

		System.out.println(esn);

	}

}
