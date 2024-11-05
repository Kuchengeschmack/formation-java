package fr.adaming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.adaming.entites.Formateur;
import fr.adaming.utils.DbUtil;

public class FormateurDaoImpl implements IFormateurDao {

	private Connection cx = null;
	private PreparedStatement ps = null;

	@Override
	public Formateur isExist(Formateur fIn) {

		try {
			// Étape 1 et 2 : chargement du pilote et ouverture d'une connection à la bd
			cx = DbUtil.ouvrirConnexion();

			// Étape 3 : construire la requête SQL
			String req = "SELECT * FROM formateurs WHERE mail_f=? AND password_f=?";

			// Étape 4-a : récupérer le ps
			ps = cx.prepareStatement(req);

			// Étape 4-b : passage des paramètres de la requête SQL
			ps.setString(1, fIn.getMail());
			ps.setString(2, fIn.getPassword());

			// Étape 4-c et 5 : envoyer la requête et récupérer le résultat
			ResultSet rs = ps.executeQuery();

			// Étape 6 : exploiter le résultat
			rs.next();

			Formateur fOut = new Formateur(rs.getInt("id_f"), rs.getString("mail_f"), rs.getString("password_f"));

			return fOut;

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
