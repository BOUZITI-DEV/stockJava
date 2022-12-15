/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IDao;
import entities.LigneCommande;
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
public class LigneCommandeService implements IDao<LigneCommande> {

    private CommandeService cmds;
    private ProduitService prods;

    public LigneCommandeService() {
        cmds = new CommandeService();
        prods = new ProduitService();
    }

    @Override
    public boolean create(LigneCommande o) {
        try {
            String sql = "INSERT INTO lignecommande VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getCommande().getCode());
            ps.setInt(2, o.getProduit().getId());
            ps.setInt(3, o.getQuantite());
            ps.setDouble(4, o.getPrixVente());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(LigneCommande o) {
        try {
            String sql = "DELETE FROM lignecommande WHERE commande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getCommande().getCode());
            ps.setInt(2, o.getProduit().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(LigneCommande o) {
        try {
            String sql = "UPDATE lignecommande SET quantite = ?, prixVente = ? WHERE commande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getQuantite());
            ps.setDouble(2, o.getPrixVente());
            ps.setInt(3, o.getCommande().getCode());
            ps.setInt(4, o.getProduit().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public LigneCommande findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LigneCommande findById(LigneCommande o) {
        try {
            String sql = "SELECT * FROM lignecommande WHERE commande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getCommande().getCode());
            ps.setInt(2, o.getProduit().getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LigneCommande(cmds.findById(rs.getInt("commande")), prods.findById(rs.getInt("produit")), rs.getInt("quatite"), rs.getDouble("prixVente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<LigneCommande> findAll() {
        List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
        try {
            String sql = "SELECT * FROM lignecommande";
            Statement st = connexion.Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lignesCommande.add(new LigneCommande(cmds.findById(rs.getInt("commande")), prods.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixVente")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lignesCommande;
    }

}
