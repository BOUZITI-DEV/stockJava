/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author info
 */
public class CategorieService implements IDao<Categorie> {

    @Override
    public boolean create(Categorie o) {
        try {
            String sql = "INSERT INTO categorie VALUES(null, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(1, o.getLibelle());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Categorie o) {
        try {
            String sql = "DELETE FROM categorie WHERE id = " + o.getId();
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            if (ps.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean update(Categorie o) {
        try {
            String sql = "UPDATE categorie SET libelle = ? WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(1, o.getLibelle());
            ps.setInt(2, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public Categorie findById(int id) {
        try {
            String sql = "SELECT * FROM categorie WHERE id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Categorie(id, rs.getNString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Categorie> findAll() {
        List<Categorie> categories = new ArrayList<Categorie>();
        try {
            String sql = "SELECT * FROM categorie";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                categories.add(new Categorie(rs.getInt("id"), rs.getString("libelle")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
