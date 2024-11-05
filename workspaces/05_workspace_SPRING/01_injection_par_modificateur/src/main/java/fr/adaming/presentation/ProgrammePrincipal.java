package fr.adaming.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.Employe;
import fr.adaming.beans.Entreprise;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// R�cup�rer le contexte du conteneur Spring IoC
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");

		// R�cup�rer le bean (objet) empBean
		Employe emp = (Employe) cxt.getBean("empBean");

		System.out.println(emp);

		// R�cup�rer le bean esnBean
		Entreprise esn = (Entreprise) cxt.getBean("esnBean");

		System.out.println(esn);

	}

}
