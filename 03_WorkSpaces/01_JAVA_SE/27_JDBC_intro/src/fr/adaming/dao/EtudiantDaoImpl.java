package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.modele.Etudiant;

public class EtudiantDaoImpl implements IEtudiantDao {

	// Déclaration des constantes de la connexion à la bd
	public static final String URL = "jdbc:mysql://localhost:3306/tp_jdbc";
	public static final String LOGIN = "root";
	public static final String MDP = "root";

	// Déclaration des attributs de la classe
	private Connection cx = null;
	private Statement st = null;
	private PreparedStatement ps = null;

	// redéfinition des constantes de la connexion à la bd
	@Override
	public void addEtudiantDao(Etudiant eIn) {

		// étape 1 : chargement du driver
		// retourne l'objet de la classe associée à la classe, il s'agit d'une partie de
		// l'opérateur new
		// Lève une exception qu'il faudra soit traiter, soit déléguer
		try {
			// étape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// étape 2 : ouvrir une connexion à la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette méthode délègue une exception

			// étape 3 : insérer une ligne dans la table etudiants
			String req = "insert into etudiants(nom_e,prenom_e,age_e)" + "values ('" + eIn.getNom() + "','"
					+ eIn.getPrenom() + "'," + eIn.getAge() + ");"; // Attention aux apostrophes !

			// étape 4 et 5 : Envoyer la requête sql à la bd et récupérer le réultat
			// 4-a : récuperer un objet de type statement (le bus pour envoyer la requête
			// SQL)
			st = cx.createStatement();

			// 4-b et 5 : envoyer concrètement la requête et récupérer le résultat
			int verif = st.executeUpdate(req);

			// étape 6 : exploiter le résultat en java
			if (verif != 0) {
				System.out.println("----- L'ajout est OK");
			} else {
				System.out.println("----- L'ajout est KO!");
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (st != null) {
					st.close();
				}

				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int updateEtudiantDao(Etudiant eIn) {

		// étape 1 : chargement du driver
		// retourne l'objet de la classe associée à la classe, il s'agit d'une partie de
		// l'opérateur new
		// Lève une exception qu'il faudra soit traiter, soit déléguer
		try {
			// étape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// étape 2 : ouvrir une connexion à la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette méthode délègue une exception

			// étape 3 : insérer une ligne dans la table etudiants
			// Ici on écrit une requête paramétrée
			String req = "update etudiants set nom_e = ?, prenom_e = ?, age_e = ? where id_e = ?;";

			// étape 4 et 5 : Envoyer la requête sql à la bd et récupérer le réultat
			// 4-a : récuperer un objet de type statement (le bus pour envoyer la requête
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux paramètres de la requête
			ps.setString(1, eIn.getNom());
			ps.setString(2, eIn.getPrenom());
			ps.setInt(3, eIn.getAge());
			ps.setInt(4, eIn.getId());

			// 4-c et 5 : envoyer concrètement la requête et récupérer le résultat
			int verif = ps.executeUpdate();

			// étape 6 : exploiter le résultat en java
			return verif;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (st != null) {
					st.close();
				}

				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int deleteEtudiantDao(int eId) {

		// étape 1 : chargement du driver
		// retourne l'objet de la classe associée à la classe, il s'agit d'une partie de
		// l'opérateur new
		// Lève une exception qu'il faudra soit traiter, soit déléguer
		try {
			// étape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// étape 2 : ouvrir une connexion à la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette méthode délègue une exception

			// étape 3 : insérer une ligne dans la table etudiants
			// Ici on écrit une requête paramétrée
			String req = "DELETE FROM `etudiants` where `id_e` = ?;";

			// étape 4 et 5 : Envoyer la requête sql à la bd et récupérer le réultat
			// 4-a : récuperer un objet de type statement (le bus pour envoyer la requête
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux paramètres de la requête
			ps.setInt(1, eId);

			// 4-c et 5 : envoyer concrètement la requête et récupérer le résultat
			int verif = ps.executeUpdate();

			// étape 6 : exploiter le résultat en java
			return verif;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (st != null) {
					st.close();
				}

				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public List<Etudiant> getAllEtudiantsDao() {
		try {
			// étape 1 : chargement du piloe
			Class.forName("com.mysql.cj.jdbc.Driver");

			// étape 2 : ouvrir une connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// étape 3 : écrire la requête SQL
			String req = "SELECT * FROM etudiants";

			// étape 4 et 5 : envoyer la requête à la BD et récupérer le résultat
			// 4a : récupérer l'objet ps
			ps = cx.prepareStatement(req);

			// 4b et 5 : envoyer la requête et récupérer le résultat
			ResultSet rs = ps.executeQuery();

			// étape 6 : exploiter le résultat (transformer le résultat en une liste

			List<Etudiant> liste = new ArrayList<Etudiant>();

			// On ne connaît pas le nombre d'itérations, on utilise alors une boucle while
			while (rs.next()) {

				// récupérer les valeurs des colonnes de la ligne actuelle
				int idOut = rs.getInt("id_e"); // soit on utilise nom colonne ou index colonne
				String nomOut = rs.getString("nom_e");
				String prenomOut = rs.getString("prenom_e");
				int ageOut = rs.getInt("age_e");

				// instancier un etudiant avec ses valeurs
				Etudiant eOut = new Etudiant(idOut, nomOut, prenomOut, ageOut);
				liste.add(eOut);
			}

			System.out.println("Le select est OK");

			return liste;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// fermer les flux
			try {
				if (st != null) {
					st.close();
				}

				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Etudiant getEtudiantDao(int eId) {
		// étape 1 : chargement du driver
		// retourne l'objet de la classe associée à la classe, il s'agit d'une partie de
		// l'opérateur new
		// Lève une exception qu'il faudra soit traiter, soit déléguer
		try {
			// étape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// étape 2 : ouvrir une connexion à la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette méthode délègue une exception

			// étape 3 : insérer une ligne dans la table etudiants
			// Ici on écrit une requête paramétrée
			String req = "SELECT * FROM etudiants where `id_e` = ?;";

			// étape 4 et 5 : Envoyer la requête sql à la bd et récupérer le réultat
			// 4-a : récuperer un objet de type statement (le bus pour envoyer la requête
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux paramètres de la requête
			ps.setInt(1, eId);

			// 4-c et 5 : envoyer concrètement la requête et récupérer le résultat
			ResultSet rs = ps.executeQuery();

			// étape 6 : exploiter le résultat (transformer le résultat en une liste

			// On a un tableau avec le header des champs et une ligne. On se place à la
			// deuxième ligne

			if (rs.next()) {
				int idOut = rs.getInt("id_e"); // soit on utilise nom colonne ou index colonne
				String nomOut = rs.getString("nom_e");
				String prenomOut = rs.getString("prenom_e");
				int ageOut = rs.getInt("age_e");
				Etudiant eOut = new Etudiant(idOut, nomOut, prenomOut, ageOut);

				return eOut;
			}

			return null;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (st != null) {
					st.close();
				}

				if (cx != null) {
					cx.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}