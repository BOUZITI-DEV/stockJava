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
import entities.Commande;
import entities.LigneCommande;

public class CommandeService implements IDao<Commande> {

	private ClientService cs;

	public CommandeService() {
		cs = new ClientService();
	}

	@Override
	public boolean create(Commande o) {
		try {
			String req = "INSERT INTO commande VALUES(null, ?, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setObject(2, o.getClient());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Commande o) {
		try {
			String req = "DELETE FROM commande WHERE code = ?";
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
	public boolean update(Commande o) {
		try {
			String req = "UPDATE commande SET date = ? , client = ? WHERE code = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setDate(1, new Date(o.getDate().getTime()));
			ps.setObject(2, o.getClient());
			ps.setInt(3, o.getCode());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Commande findById(int code) {
		try {
			String sql = "SELECT * FROM commande WHERE code = " + code;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				Commande cmd = new Commande(rs.getInt("code"), rs.getDate("date"), cs.findById(rs.getInt("client")));
				return cmd;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			String sql = "SELECT * FROM commande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"), cs.findById(rs.getInt("client"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commandes;
	}

	public double getTotalPrix(int code) {
		double total = 0;
		for (LigneCommande lc : findById(code).getLigneCommandes()) {
			total += lc.getPrixVente() * lc.getQuantite();
		}
		return total;
	}
}
