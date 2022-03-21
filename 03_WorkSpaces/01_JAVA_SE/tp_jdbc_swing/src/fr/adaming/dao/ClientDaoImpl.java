package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.modele.Client;

public class ClientDaoImpl implements IClientDao {

	// Déclaration des constantes de la connexion à la bd
	public static final String URL = "jdbc:mysql://localhost:3306/tp_jdbc";
	public static final String LOGIN = "root";
	public static final String MDP = "root";

	// Déclaration des attributs de la classe
	private Connection cx = null;
	private PreparedStatement ps = null;

	@Override
	public int ajouterClientDao(Client c) {
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requête
			String req = "INSERT INTO client (num_client,nom,prenom,adresse,code_postal,ville,num_telephone) values (?,?,?,?,?,?,?);";

			// Déclaration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, c.getNumClient());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4, c.getAdresse());
			ps.setInt(5, c.getCodePostal());
			ps.setString(6, c.getVille());
			ps.setInt(7, c.getNumTelephone());

			// Envoi de la requête
			int verif = ps.executeUpdate();

			// Renvoyer le résultat de la requête
			return verif;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (ps != null) {
					ps.close();
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
	public int supprimerClientDao(int idC) {
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requête
			String req = "DELETE FROM `client` where `num_client` = ?;";

			// Déclaration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, idC);

			// Envoi de la requête
			int verif = ps.executeUpdate();

			// Renvoyer le résultat de la requête
			return verif;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (ps != null) {
					ps.close();
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
	public int modifierClientDao(Client c) {
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requête
			String req = "UPDATE client SET `nom` = ?, `prenom` = ?, `adresse` = ?, "
					+ "`code_postal` = ?, `ville` = ?, `num_telephone` = ? where `num_client` = ?;";

			// Déclaration du bus
			ps = cx.prepareStatement(req);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getAdresse());
			ps.setInt(4, c.getCodePostal());
			ps.setString(5, c.getVille());
			ps.setInt(6, c.getNumTelephone());
			ps.setInt(7, c.getNumClient());

			// Envoi de la requête
			int verif = ps.executeUpdate();

			// Renvoyer le résultat de la requête
			return verif;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (ps != null) {
					ps.close();
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
	public List<Client> getAllClientDao() {
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requête
			String req = "SELECT * FROM client;";

			// Déclaration du bus
			ps = cx.prepareStatement(req);

			// Envoi de la requête
			ResultSet rs = ps.executeQuery();

			// Création de la liste
			List<Client> liste = new ArrayList<Client>();

			int numClient;
			String nom;
			String prenom;
			String adresse;
			int codePostal;
			String ville;
			int numTelephone;

			// Renvoyer le résultat de la requête
			while (rs.next()) {
				numClient = rs.getInt("num_client");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				adresse = rs.getString("adresse");
				codePostal = rs.getInt("code_postal");
				ville = rs.getString("ville");
				numTelephone = rs.getInt("num_telephone");

				Client cOut = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);
				liste.add(cOut);
			}

			return liste;

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (ps != null) {
					ps.close();
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

	@Override
	public Client chercherClientDao(int Idc) {
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requête
			String req = "SELECT * FROM client WHERE num_client = ?;";

			// Déclaration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, Idc);

			// Envoi de la requête
			ResultSet rs = ps.executeQuery();

			// Création du client
			Client cOut = new Client();

			int numClient;
			String nom;
			String prenom;
			String adresse;
			int codePostal;
			String ville;
			int numTelephone;

			// Renvoyer le résultat de la requête
			if (rs.next()) {
				numClient = rs.getInt("num_client");
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				adresse = rs.getString("adresse");
				codePostal = rs.getInt("code_postal");
				ville = rs.getString("ville");
				numTelephone = rs.getInt("num_telephone");

				cOut = new Client(numClient, nom, prenom, adresse, codePostal, ville, numTelephone);
				return cOut;
			} else {
				return null;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			// fermer les flux
			try {
				if (ps != null) {
					ps.close();
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
