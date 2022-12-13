package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import dao.IDao;
import entities.Produit;
import java.awt.image.BufferedImage;
import java.sql.Blob;

public class ProduitService implements IDao<Produit> {

    private RayonService rServ;
    private CategorieService cs;

    public ProduitService() {
        rServ = new RayonService();
        cs = new CategorieService();
    }

    @Override
    public boolean create(Produit o) {
        try {
            String req = "INSERT INTO produit VALUES(null, ?, ?, ?, null, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getDesignation());
            ps.setDouble(2, o.getPrixAchat());
            ps.setDouble(3, o.getTva());
            ps.setInt(4, o.getRayon().getId());
            ps.setInt(5, o.getCategorie().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        try {
            String req = "DELETE FROM produit WHERE id = ?";
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
    public boolean update(Produit o) {
        try {
            String req = "UPDATE produit SET designation = ? , prixAchat = ?, TVA = ?, rayon = ?, categorie = ?  WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getDesignation());
            ps.setDouble(2, o.getPrixAchat());
            ps.setDouble(3, o.getTva());
            ps.setInt(4, o.getRayon().getId());
            ps.setInt(5, o.getCategorie().getId());
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        try {
            String sql = "SELECT * FROM produit WHERE id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"), rs.getDouble("TVA"),
                        rServ.findById(rs.getInt("rayon")), cs.findById(rs.getInt("categorie")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<Produit>();
        try {
            String sql = "SELECT * FROM produit";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                produits.add(new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"), rs.getDouble("TVA"),
                        rServ.findById(rs.getInt("rayon")), cs.findById(rs.getInt("categorie"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

}
