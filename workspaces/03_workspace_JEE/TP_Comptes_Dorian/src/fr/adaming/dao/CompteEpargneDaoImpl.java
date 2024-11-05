package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.utils.DbUtil;


public class CompteEpargneDaoImpl implements ICompteEpargneDao {

	private String tableSql = "compte_epargne";
	private PreparedStatement ps;
	private Connection cx;

	@Override
	public List<CompteEpargne> getAllCompte(Client clientIn) {

		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			if (clientIn.getCompteEpargne() != null) {

				// �tape 3 : construire la requ�te SQL
				String req = "SELECT * FROM " + tableSql + " WHERE id = ?";

				// R�cup�rer le ps
				ps = cx.prepareStatement(req);

				ps.setInt(1, clientIn.getCompteEpargne().getId());

				// Envoyer la requ�te
				ResultSet rs = ps.executeQuery();

				if (rs != null) {
					// Exploiter le r�sultat
					List<CompteEpargne> liste = new ArrayList<CompteEpargne>();

					while (rs.next()) {
						CompteEpargne cOut = new CompteEpargne(rs.getInt("id"), rs.getDouble("solde"));
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

	public int addCompte(Client client, CompteEpargne compte) {

		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			String req = "INSERT INTO " + tableSql + " (solde) values (?)";
			// R�cup�rer le ps
			ps = cx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

			// Passage des param�tres
			ps.setDouble(1, compte.getSolde());

			int verif = ps.executeUpdate();

			// On r�cup�re l'id du compte d�finie en SQL comme int primary key
			// auto_increment
			ResultSet generatedKeys = ps.getGeneratedKeys();
			generatedKeys.next();
			compte.setId((int) generatedKeys.getLong(1));

			// Attribution de la valeur null � la clef �trang�re de clients
			req = "UPDATE clients SET " + tableSql + "_id=? WHERE id=?";
			ps = cx.prepareStatement(req);
			ps.setInt(1, compte.getId());
			ps.setInt(2, client.getId());
			ps.executeUpdate();

			// Envoyer la requ�te
			return verif;

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

	public int updateCompte(Client client, CompteEpargne compte) {

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

	public CompteEpargne getCompteById(Client client, CompteEpargne compteIn) {

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
				CompteEpargne compteOut = new CompteEpargne(rs.getInt("id"), rs.getDouble("solde"));

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

	public int deleteCompteById(Client client, CompteEpargne compte) {

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
