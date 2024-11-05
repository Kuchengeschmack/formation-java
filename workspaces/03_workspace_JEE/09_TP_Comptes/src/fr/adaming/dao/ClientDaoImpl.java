package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.adaming.entities.Client;
import fr.adaming.entities.CompteCourant;
import fr.adaming.entities.CompteEpargne;
import fr.adaming.service.CompteCourantServiceImpl;
import fr.adaming.service.CompteEpargneServiceImpl;
import fr.adaming.service.ICompteCourantService;
import fr.adaming.service.ICompteEpargneService;
import fr.adaming.utils.DbUtil;

public class ClientDaoImpl implements IClientDao {

	private Connection cx = null;
	private PreparedStatement ps = null;

	private ICompteCourantService compteCourantService = new CompteCourantServiceImpl();
	private ICompteEpargneService compteEpargneService = new CompteEpargneServiceImpl();

	@Override
	public Client isExist(Client clientIn) {

		try {
			// �tape 1 et 2 : chargement du pilote et ouverture d'une connection � la bd
			cx = DbUtil.ouvrirConnexion();

			// �tape 3 : construire la requ�te SQL
			String req = "SELECT * FROM clients WHERE courriel=? AND mdp=?";

			// �tape 4-a : r�cup�rer le ps
			ps = cx.prepareStatement(req);

			// �tape 4-b : passage des param�tres de la requ�te SQL
			ps.setString(1, clientIn.getCourriel());
			ps.setString(2, clientIn.getMdp());

			// �tape 4-c et 5 : envoyer la requ�te et r�cup�rer le r�sultat
			ResultSet rs = ps.executeQuery();

			// �tape 6 : exploiter le r�sultat
			rs.next();

			// Ou cr�� le client � partir des premi�res colonnes de la BDD clients
			Client clientOut = new Client(rs.getInt("id"), rs.getString("courriel"), rs.getString("mdp"),
					rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getInt("code_postal"),
					rs.getString("ville"), rs.getInt("telephone"));

			int compteCourantId = rs.getInt("compte_courant_id");
			int compteEpargneId = rs.getInt("compte_epargne_id");

			// On ajoute les objets Compte dans Java � partir de leurs identifiants dans la
			// BDD clients
			CompteCourant compteCourantIn = new CompteCourant(compteCourantId);
			CompteEpargne compteEpargneIn = new CompteEpargne(compteEpargneId);

			CompteCourant compteCourant = compteCourantService.getCompteById(clientOut, compteCourantIn);
			CompteEpargne compteEpargne = compteEpargneService.getCompteById(clientOut, compteEpargneIn);

			clientOut.setCompteCourant(compteCourant);
			clientOut.setCompteEpargne(compteEpargne);

			// On retourne le Client complet
			return clientOut;

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
	public int ajouterClient(Client client) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			String req = "INSERT INTO clients (courriel, mdp) values (?,?)";
			// R�cup�rer le ps
			ps = cx.prepareStatement(req);

			// Passage des param�tres
			ps.setString(1, client.getCourriel());
			ps.setString(2, client.getMdp());

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
	public int modifierClient(Client client) {
		try {
			// �tape 1 et 2 chargement du pilote et ouvrir une connexion
			cx = DbUtil.ouvrirConnexion();

			String req = "UPDATE clients SET (courriel, mdp, nom, prenom, adresse, code_postal, ville, telephone) values (?,?,?,?,?,?,?,?) "
					+ "WHERE id=?";
			// R�cup�rer le ps
			ps = cx.prepareStatement(req);

			// Passage des param�tres
			ps.setString(1, client.getCourriel());
			ps.setString(2, client.getMdp());
			ps.setString(3, client.getNom());
			ps.setString(4, client.getPrenom());
			ps.setString(5, client.getAdresse());
			ps.setInt(6, client.getCodePostal());
			ps.setString(7, client.getVille());
			ps.setInt(8, client.getTelephone());
			ps.setInt(9, client.getId());

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
