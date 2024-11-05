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

	// D�claration des constantes de la connexion � la bd
	public static final String URL = "jdbc:mysql://localhost:3306/tp_jdbc";
	public static final String LOGIN = "root";
	public static final String MDP = "root";

	// D�claration des attributs de la classe
	private Connection cx = null;
	private Statement st = null;
	private PreparedStatement ps = null;

	// red�finition des constantes de la connexion � la bd
	@Override
	public void addEtudiantDao(Etudiant eIn) {

		// �tape 1 : chargement du driver
		// retourne l'objet de la classe associ�e � la classe, il s'agit d'une partie de
		// l'op�rateur new
		// L�ve une exception qu'il faudra soit traiter, soit d�l�guer
		try {
			// �tape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �tape 2 : ouvrir une connexion � la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette m�thode d�l�gue une exception

			// �tape 3 : ins�rer une ligne dans la table etudiants
			String req = "insert into etudiants(nom_e,prenom_e,age_e)" + "values ('" + eIn.getNom() + "','"
					+ eIn.getPrenom() + "'," + eIn.getAge() + ");"; // Attention aux apostrophes !

			// �tape 4 et 5 : Envoyer la requ�te sql � la bd et r�cup�rer le r�ultat
			// 4-a : r�cuperer un objet de type statement (le bus pour envoyer la requ�te
			// SQL)
			st = cx.createStatement();

			// 4-b et 5 : envoyer concr�tement la requ�te et r�cup�rer le r�sultat
			int verif = st.executeUpdate(req);

			// �tape 6 : exploiter le r�sultat en java
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

		// �tape 1 : chargement du driver
		// retourne l'objet de la classe associ�e � la classe, il s'agit d'une partie de
		// l'op�rateur new
		// L�ve une exception qu'il faudra soit traiter, soit d�l�guer
		try {
			// �tape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �tape 2 : ouvrir une connexion � la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette m�thode d�l�gue une exception

			// �tape 3 : ins�rer une ligne dans la table etudiants
			// Ici on �crit une requ�te param�tr�e
			String req = "update etudiants set nom_e = ?, prenom_e = ?, age_e = ? where id_e = ?;";

			// �tape 4 et 5 : Envoyer la requ�te sql � la bd et r�cup�rer le r�ultat
			// 4-a : r�cuperer un objet de type statement (le bus pour envoyer la requ�te
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux param�tres de la requ�te
			ps.setString(1, eIn.getNom());
			ps.setString(2, eIn.getPrenom());
			ps.setInt(3, eIn.getAge());
			ps.setInt(4, eIn.getId());

			// 4-c et 5 : envoyer concr�tement la requ�te et r�cup�rer le r�sultat
			int verif = ps.executeUpdate();

			// �tape 6 : exploiter le r�sultat en java
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

		// �tape 1 : chargement du driver
		// retourne l'objet de la classe associ�e � la classe, il s'agit d'une partie de
		// l'op�rateur new
		// L�ve une exception qu'il faudra soit traiter, soit d�l�guer
		try {
			// �tape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �tape 2 : ouvrir une connexion � la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette m�thode d�l�gue une exception

			// �tape 3 : ins�rer une ligne dans la table etudiants
			// Ici on �crit une requ�te param�tr�e
			String req = "DELETE FROM `etudiants` where `id_e` = ?;";

			// �tape 4 et 5 : Envoyer la requ�te sql � la bd et r�cup�rer le r�ultat
			// 4-a : r�cuperer un objet de type statement (le bus pour envoyer la requ�te
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux param�tres de la requ�te
			ps.setInt(1, eId);

			// 4-c et 5 : envoyer concr�tement la requ�te et r�cup�rer le r�sultat
			int verif = ps.executeUpdate();

			// �tape 6 : exploiter le r�sultat en java
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
			// �tape 1 : chargement du piloe
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �tape 2 : ouvrir une connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// �tape 3 : �crire la requ�te SQL
			String req = "SELECT * FROM etudiants";

			// �tape 4 et 5 : envoyer la requ�te � la BD et r�cup�rer le r�sultat
			// 4a : r�cup�rer l'objet ps
			ps = cx.prepareStatement(req);

			// 4b et 5 : envoyer la requ�te et r�cup�rer le r�sultat
			ResultSet rs = ps.executeQuery();

			// �tape 6 : exploiter le r�sultat (transformer le r�sultat en une liste

			List<Etudiant> liste = new ArrayList<Etudiant>();

			// On ne conna�t pas le nombre d'it�rations, on utilise alors une boucle while
			while (rs.next()) {

				// r�cup�rer les valeurs des colonnes de la ligne actuelle
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
		// �tape 1 : chargement du driver
		// retourne l'objet de la classe associ�e � la classe, il s'agit d'une partie de
		// l'op�rateur new
		// L�ve une exception qu'il faudra soit traiter, soit d�l�guer
		try {
			// �tape 1 : chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �tape 2 : ouvrir une connexion � la bd
			cx = DriverManager.getConnection(URL, LOGIN, MDP); // Cette m�thode d�l�gue une exception

			// �tape 3 : ins�rer une ligne dans la table etudiants
			// Ici on �crit une requ�te param�tr�e
			String req = "SELECT * FROM etudiants where `id_e` = ?;";

			// �tape 4 et 5 : Envoyer la requ�te sql � la bd et r�cup�rer le r�ultat
			// 4-a : r�cuperer un objet de type statement (le bus pour envoyer la requ�te
			// SQL)
			ps = cx.prepareStatement(req);

			// 4-b : assigner des valeurs aux param�tres de la requ�te
			ps.setInt(1, eId);

			// 4-c et 5 : envoyer concr�tement la requ�te et r�cup�rer le r�sultat
			ResultSet rs = ps.executeQuery();

			// �tape 6 : exploiter le r�sultat (transformer le r�sultat en une liste

			// On a un tableau avec le header des champs et une ligne. On se place � la
			// deuxi�me ligne

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