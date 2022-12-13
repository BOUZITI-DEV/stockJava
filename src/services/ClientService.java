package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Client;

public class ClientService implements IDao<Client> {

    @Override
    public boolean create(Client o) {
        try {
            String req = "INSERT INTO client VALUES(null, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Client o) {
        try {
            String req = "DELETE FROM client WHERE id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Client o) {
        try {
            String req = "UPDATE client SET nom = ?, telephone = ?, email = ? WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client findById(int id) {
        try {
            String sql = "SELECT * FROM client WHERE id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<Client>();
        try {
            String sql = "SELECT * FROM client";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
