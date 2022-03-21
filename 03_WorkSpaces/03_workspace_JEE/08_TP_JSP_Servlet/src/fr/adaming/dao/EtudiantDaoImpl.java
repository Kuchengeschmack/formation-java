package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.entites.Etudiant;
import fr.adaming.entites.Formateur;
import fr.adaming.utils.DbUtil;

public class EtudiantDaoImpl implements IEtudiantDao {

	private Connection cx = null;
	private PreparedStatement ps = null;

	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {

		try {
			// Étape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			// Étape 3 : construire la requête SQL
			String req = "SELECT * FROM etudiants WHERE f_id=?";

			// Récupérer le ps
			ps = cx.prepareStatement(req);

			// Passage des paramètres
			ps.setInt(1, fIn.getId());

			// Envoyer la requête
			ResultSet rs = ps.executeQuery();

			// Exploiter le résultat
			List<Etudiant> liste = new ArrayList<Etudiant>();

			while (rs.next()) {
				Etudiant eOut = new Etudiant(rs.getInt("id_e"), rs.getString("nom_e"), rs.getString("prenom_e"),
						rs.getInt("age_e"));
				liste.add(eOut);
			}

			return liste;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.fermerConnexion(cx, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public int addEtudiant(Etudiant eIn) {
		try {
			// Étape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			String req = "INSERT INTO etudiants (nom_e, prenom_e,age_e,f_id) values (?,?,?,?)";
			// Récupérer le ps
			ps = cx.prepareStatement(req);

			// Passage des paramètres
			ps.setString(1, eIn.getNom());
			ps.setString(2, eIn.getPrenom());
			ps.setInt(3, eIn.getAge());
			ps.setInt(4, eIn.getFormateur().getId()); // Obtenir l'ID du formateur

			// Envoyer la requête
			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.fermerConnexion(cx, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int updateEtudiant(Etudiant eIn) {
		try {
			// Étape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();
			String req = "UPDATE etudiants SET nom_e=?,prenom_e=?,age_e=? WHERE id_e = ? AND f_id=?";
			// Récupérer le ps
			ps = cx.prepareStatement(req);

			// Passage des paramètres
			ps.setString(1, eIn.getNom());
			ps.setString(2, eIn.getPrenom());
			ps.setInt(3, eIn.getAge());
			ps.setInt(4, eIn.getId());
			ps.setInt(5, eIn.getFormateur().getId()); // Obtenir l'ID du formateur

			// Envoyer la requête
			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.fermerConnexion(cx, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	@Override
	public int deleteEtudiantById(Etudiant eIn) {
		try {
			// Étape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			// Étape 3 : construire la requête SQL
			String req = "DELETE FROM etudiants WHERE id_e=? AND f_id=?"; // Il ne faut pas qu'un étudiant supprime les
																			// étudiants d'un autre formateur

			// Récupérer le ps
			ps = cx.prepareStatement(req);

			// Passage des paramètres
			ps.setInt(1, eIn.getId());
			ps.setInt(2, eIn.getFormateur().getId()); // On récupère l'identifiant du formateur

			// Envoyer la requête
			return ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.fermerConnexion(cx, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;

	}

	/* Doit-on retourner l'identifiant du formateur avec l'Etudiant ? */
	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		try {
			// Étape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			// Étape 3 : construire la requête SQL
			String req = "SELECT * FROM etudiants WHERE id_e=? AND f_id=?";

			// Récupérer le ps
			ps = cx.prepareStatement(req);

			// Passage des paramètres
			ps.setInt(1, eIn.getId());
			ps.setInt(2, eIn.getFormateur().getId()); // On récupère l'id du formateur

			// Envoyer la requête
			ResultSet rs = ps.executeQuery();
			
			// Déplacer le curseur
			rs.next();

			// Exploiter le résultat
			Etudiant eOut = new Etudiant(rs.getInt("id_e"), rs.getString("nom_e"), rs.getString("prenom_e"),
					rs.getInt("age_e"));

			return eOut;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.fermerConnexion(cx, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
