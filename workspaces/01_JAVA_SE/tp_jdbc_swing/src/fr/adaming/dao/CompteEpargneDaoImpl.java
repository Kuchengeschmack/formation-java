package fr.adaming.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.adaming.modele.Compte;
import fr.adaming.modele.CompteEpargne;

public class CompteEpargneDaoImpl implements ICompteEpargneDao {

	// D�claration des constantes de la connexion � la bd
	public static final String URL = "jdbc:mysql://localhost:3306/tp_jdbc";
	public static final String LOGIN = "root";
	public static final String MDP = "root";

	@Override
	public int supprimerCompteDao(int idC) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "DELETE FROM `compte_epargne` where `num_compte` = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, idC);

			// Envoi de la requ�te
			int verif = ps.executeUpdate();

			// Renvoyer le r�sultat de la requ�te
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
	public int modifierCompteDao(Compte c) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "UPDATE compte_epargne SET `solde` = ?, `num_client` = ? WHERE `num_compte` = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setDouble(1, c.getSolde());
			ps.setInt(2, c.getNumClient());
			ps.setInt(3, c.getNumCompte());

			// Envoi de la requ�te
			int verif = ps.executeUpdate();

			// Renvoyer le r�sultat de la requ�te
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
	public List<Compte> getAllCompteDao() {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "SELECT * FROM compte_epargne;";

			// D�claration du bus
			ps = cx.prepareStatement(req);

			// Envoi de la requ�te
			ResultSet rs = ps.executeQuery();

			// Cr�ation de la liste
			List<Compte> liste = new ArrayList<Compte>();

			int numCompte;
			Double solde;
			int numClient;
			Compte cOut;

			// Renvoyer le r�sultat de la requ�te
			while (rs.next()) {
				numCompte = rs.getInt("num_compte");
				solde = rs.getDouble("solde");
				numClient = rs.getInt("num_client");

				cOut = new CompteEpargne(numCompte, solde, numClient); // Compte est une classe abstraite
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
	public Compte chercherIdCompteDao(int idC) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "SELECT * FROM compte_epargne WHERE num_compte = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, idC);

			// Envoi de la requ�te
			ResultSet rs = ps.executeQuery();

			// Instanciation du compte
			Compte cOut = new CompteEpargne();

			int numCompte;
			Double solde;
			int numClient;

			// Renvoyer le r�sultat de la requ�te
			if (rs.next()) {
				numCompte = rs.getInt("num_compte");
				solde = rs.getDouble("solde");
				numClient = rs.getInt("num_client");

				cOut = new CompteEpargne(numCompte, solde, numClient); // Compte est une classe abstraite
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

	@Override
	public Compte chercherIdClientCompteDao(int idCl) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "SELECT * FROM compte_epargne WHERE num_client = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, idCl);

			// Envoi de la requ�te
			ResultSet rs = ps.executeQuery();

			// Instanciation du compte
			Compte cOut = new CompteEpargne();

			int numCompte;
			Double solde;
			int numClient;

			// Renvoyer le r�sultat de la requ�te
			if (rs.next()) {
				numCompte = rs.getInt("num_compte");
				solde = rs.getDouble("solde");
				numClient = rs.getInt("num_client");

				cOut = new CompteEpargne(numCompte, solde, numClient); // Compte est une classe abstraite
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

	@Override
	public int attribuerCompteDao(Compte c) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "INSERT INTO compte_epargne (num_compte, solde, num_client) values (?, ?, ?);";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setInt(1, c.getNumCompte());
			ps.setDouble(2, c.getSolde());
			ps.setInt(3, c.getNumClient());

			// Envoi de la requ�te
			int verif = ps.executeUpdate();

			// Renvoyer le r�sultat de la requ�te
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
	public int retirerCompteDao(int idC, double montant) { // Varie selon le type de compte
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "UPDATE compte_epargne SET `solde` = ? WHERE `num_compte` = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setDouble(1, chercherIdCompteDao(idC).getSolde() - montant); // Rajouter la v�rification avec le
																			// d�couvert
			ps.setInt(2, idC);

			// Envoi de la requ�te
			int verif = ps.executeUpdate();

			// Renvoyer le r�sultat de la requ�te
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
	public int deposerCompteDao(int idC, double montant) {
		Connection cx = null;
		PreparedStatement ps = null;
		try {
			// Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Ouverture de la connexion
			cx = DriverManager.getConnection(URL, LOGIN, MDP);

			// Ecriture de la requ�te
			String req = "UPDATE compte_epargne SET `solde` = ? WHERE `num_compte` = ?;";

			// D�claration du bus
			ps = cx.prepareStatement(req);
			ps.setDouble(1, chercherIdCompteDao(idC).getSolde() + montant); // Rajouter la v�rification avec le
																			// d�couvert
			ps.setInt(2, idC);

			// Envoi de la requ�te
			int verif = ps.executeUpdate();

			// Renvoyer le r�sultat de la requ�te
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
	public boolean virerCompteDao(int idDebit, int idCredit, double montant) { // Appeler les m�thodes retirer et
																				// deposer
		int verif1 = retirerCompteDao(idDebit, montant);
		int verif2;

		if (verif1 != 0) {
			verif2 = deposerCompteDao(idCredit, montant);
			if (verif2 != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

}
