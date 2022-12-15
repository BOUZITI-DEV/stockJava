package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import dao.IDao;
import entities.Demande;
import entities.LigneDemande;

public class DemandeService implements IDao<Demande> {

	private FournisseurService fs;

	public DemandeService() {
		fs = new FournisseurService();
	}

	@Override
	public boolean create(Demande o) {
		try {
			String req = "INSERT INTO demande VALUES(null, ?, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setInt(2, o.getFournisseur().getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Demande o) {
		try {
			String req = "DELETE FROM demande WHERE code = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCode());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Demande o) {
		try {
			String req = "UPDATE demande SET date = ? , fournisseur = ? WHERE code = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setInt(2, o.getFournisseur().getId());
			ps.setInt(3, o.getCode());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Demande findById(int code) {
		try {
			String sql = "SELECT * FROM demande WHERE code = " + code;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Demande dmd = new Demande(rs.getInt("code"), rs.getDate("date"), fs.findById(rs.getInt("fournisseur")));
				return dmd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Demande> findAll() {
		List<Demande> demandes = new ArrayList<Demande>();
		try {
			String sql = "SELECT * FROM demande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				demandes.add(new Demande(rs.getInt("code"), rs.getDate("date"), fs.findById(rs.getInt("fournisseur"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return demandes;
	}

	public double getTotalPrix(int code) {
		double total = 0;
		for (LigneDemande lc : findById(code).getLigneDemandes()) {
			total += lc.getPrixVente() * lc.getQuantite();
		}
		return total;
	}
}
