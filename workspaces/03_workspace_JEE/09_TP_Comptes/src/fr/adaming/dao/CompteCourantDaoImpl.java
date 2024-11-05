package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.utils.DbUtil;

public class CompteCourantDaoImpl implements ICompteCourantDao {

	private String tableSql = "compte_courant";
	private Connection cx;
	private PreparedStatement ps;

	@Override
	public List<CompteCourant> getAllCompte(Client clientIn) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			if (clientIn.getCompteCourant() != null) {

				// �tape 3 : construire la requ�te SQL
				String req = "SELECT * FROM " + tableSql + " WHERE id = ?";

				// R�cup�rer le ps
				ps = cx.prepareStatement(req);

				ps.setInt(1, clientIn.getCompteCourant().getId());

				// Envoyer la requ�te
				ResultSet rs = ps.executeQuery();

				if (rs != null) {
					// Exploiter le r�sultat
					List<CompteCourant> liste = new ArrayList<CompteCourant>();

					while (rs.next()) {
						CompteCourant cOut = new CompteCourant(rs.getInt("id"), rs.getDouble("solde"));
						liste.add(cOut);
					}

					return liste;
				}
			}

		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
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

	public int addCompte(Client client, CompteCourant compte) {

		// 1- Cr�ation de l'EntityManagerFactory (la ligne)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

		// 2- Cr�ation d'un EntityManager � partir de emf (le wagon)
		EntityManager em = emf.createEntityManager();

		// 3- Cr�ation d'une EntityTransaction (le voyage)
		EntityTransaction tx = em.getTransaction();

		// 4- Rendre le compte en entr�e persistant dans le contexte de persistance
		em.persist(compte);

		// 5- Soumettre la transaction pour �crire dans la BD MySQL
		tx.commit();

		// Fermer les flux
		em.close();
		emf.close();

		return 1; // Pas de v�rification � ce stade de d�veloppement. � voir

	}

	public int updateCompte(Client client, CompteCourant compte) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();
			String req = "UPDATE " + tableSql + " SET solde=? WHERE id = ?";

			// R�cup�rer le ps
			ps = cx.prepareStatement(req);

			// Passage des param�tres
			ps.setDouble(1, compte.getSolde());
			ps.setInt(2, compte.getId());

			// Envoyer la requ�te
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

	public CompteCourant getCompteById(Client client, CompteCourant compteIn) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			// �tape 3 : construire la requ�te SQL
			String req = "SELECT * FROM " + tableSql + " WHERE id=?";

			// R�cup�rer le ps
			ps = cx.prepareStatement(req);

			// Passage des param�tres
			ps.setInt(1, compteIn.getId());

			// Envoyer la requ�te
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// Exploiter le r�sultat
				CompteCourant compteOut = new CompteCourant(rs.getInt("id"), rs.getDouble("solde"));

				return compteOut;
			}

		} catch (ClassNotFoundException | SQLException | NullPointerException e) {
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

	public int deleteCompteById(Client client, CompteCourant compte) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			// Attribution de la valeur null � la clef �trang�re de clients
			String req = "UPDATE clients SET " + tableSql + "_id=null WHERE id=?";
			ps = cx.prepareStatement(req);
			ps.setInt(1, client.getId());
			ps.executeUpdate();

			// �tape 3 : construire la requ�te SQL
			req = "DELETE FROM " + tableSql + " WHERE id=?";

			// R�cup�rer le ps
			ps = cx.prepareStatement(req);

			// Passage des param�tres
			ps.setInt(1, compte.getId()); // On r�cup�re l'identifiant du formateur

			// Envoyer la requ�te
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
}
