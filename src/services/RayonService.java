package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Rayon;

public class RayonService implements IDao<Rayon> {

    @Override
    public boolean create(Rayon o) {
        try {
            String req = "INSERT INTO rayon VALUES(null, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Rayon o) {
        try {
            String req = "DELETE FROM rayon WHERE id = ?";
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
    public boolean update(Rayon o) {
        try {
            String req = "UPDATE rayon SET nom = ? WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setInt(3, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Rayon findById(int id) {
        try {
            String sql = "SELECT * FROM rayon WHERE id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Rayon ray = new Rayon(rs.getInt("id"), rs.getString("nom"));
                return ray;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rayon> findAll() {
        List<Rayon> rayons = new ArrayList<Rayon>();
        try {
            String sql = "SELECT * FROM rayon";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rayons.add(new Rayon(rs.getInt("id"), rs.getString("nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rayons;
    }
}
