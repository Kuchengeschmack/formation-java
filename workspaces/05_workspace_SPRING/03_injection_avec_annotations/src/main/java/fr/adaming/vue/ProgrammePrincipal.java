package fr.adaming.vue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.model.Adresse;

public class ProgrammePrincipal {

	public static void main(String[] args) {

		// R�cup�rer le contexte du conteneur Spring IoC
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application-context.xml");

		// R�cup�rer le bean adresse
		Adresse adresse = (Adresse) cxt.getBean("adresseBean");

		System.out.println(adresse);

	}

}
