package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Fournisseur;

public class FournisseurService implements IDao<Fournisseur> {

	@Override
	public boolean create(Fournisseur o) {
		try {
			String req = "INSERT INTO fournisseur VALUES(null, ?, ?, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getTelephone());
			ps.setString(3, o.getEmail());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Fournisseur o) {
		try {
			String req = "DELETE FROM fournisseur WHERE id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Fournisseur o) {
		try {
			String req = "UPDATE fournisseur SET nom = ?, telephone = ?, email = ? WHERE id = " + o.getId();
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getTelephone());
			ps.setString(3, o.getEmail());

			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Fournisseur findById(int id) {
		try {
			String sql = "SELECT * FROM fournisseur WHERE id = " + id;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return new Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Fournisseur> findAll() {
		List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
		try {
			String sql = "SELECT * FROM fournisseur";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				fournisseurs.add(new Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
						rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fournisseurs;
	}

}
