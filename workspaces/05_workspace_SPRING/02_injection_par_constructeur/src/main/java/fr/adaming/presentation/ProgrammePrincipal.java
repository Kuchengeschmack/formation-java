package fr.adaming.presentation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.beans.Employe;

public class ProgrammePrincipal {

	public static void main(String[] args) {
		// R�cup�rer le contexte de Spring IoC
		ApplicationContext cxt = new ClassPathXmlApplicationContext("application-context.xml");

		// R�cup�rer l'objet empBean pour l'utiliser dans mon code
		Employe emp = (Employe) cxt.getBean("empBean");

		System.out.println(emp);
	}
}
