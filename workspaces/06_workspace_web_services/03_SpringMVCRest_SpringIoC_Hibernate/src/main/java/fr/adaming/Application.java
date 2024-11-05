package fr.adaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Cette classe doit être à la racine des
// packages

// Cette annotation englobe un ensemble d'annotations
// Configuration, EnableAutoConfiguration et ComponentScan
// Elle permet la configuration automatique du projet

@SpringBootApplication
public class Application {

	// La fonction main est le point d'entrée de l'application Spring Boot
	public static void main(String[] args) {

		// Le lancement du projet Spring Boot
		SpringApplication.run(Application.class, args);
	}

}
