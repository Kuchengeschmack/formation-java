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
			// �tape 1 et 2 : chargement du pilote et ouverture d'une connection � la bd
			cx = DbUtil.ouvrirConnexion();

			// �tape 3 : construire la requ�te SQL
			String req = "SELECT * FROM formateurs WHERE mail_f=? AND password_f=?";

			// �tape 4-a : r�cup�rer le ps
			ps = cx.prepareStatement(req);

			// �tape 4-b : passage des param�tres de la requ�te SQL
			ps.setString(1, fIn.getMail());
			ps.setString(2, fIn.getPassword());

			// �tape 4-c et 5 : envoyer la requ�te et r�cup�rer le r�sultat
			ResultSet rs = ps.executeQuery();

			// �tape 6 : exploiter le r�sultat
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
