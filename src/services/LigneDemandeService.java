/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IDao;
import entities.LigneDemande;
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
public class LigneDemandeService implements IDao<LigneDemande>{
    
    private DemandeService dmds;
    private ProduitService prods;

    public LigneDemandeService() {
        dmds = new DemandeService();
        prods = new ProduitService();
    }

    @Override
    public boolean create(LigneDemande o) {
        try {
            String sql = "INSERT INTO lignedemande VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getDemande().getCode());
            ps.setInt(2, o.getProduit().getId());
            ps.setInt(3, o.getQuantite());
            ps.setDouble(4, o.getPrixVente());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(LigneDemande o) {
        try {
            String sql = "DELETE FROM lignedemande WHERE demande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getDemande().getCode());
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
    public boolean update(LigneDemande o) {
        try {
            String sql = "UPDATE lignedemande SET quantite = ?, prixVente = ? WHERE demande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getQuantite());
            ps.setDouble(2, o.getPrixVente());
            ps.setInt(3, o.getDemande().getCode());
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
    public LigneDemande findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LigneDemande findById(LigneDemande o) {
        try {
            String sql = "SELECT * FROM lignedemande WHERE demande = ? AND produit = ?";
            PreparedStatement ps = connexion.Connexion.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getDemande().getCode());
            ps.setInt(2, o.getProduit().getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new LigneDemande(dmds.findById(rs.getInt("demande")), prods.findById(rs.getInt("produit")), rs.getInt("quatite"), rs.getDouble("prixVente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<LigneDemande> findAll() {
        List<LigneDemande> lignesDemande = new ArrayList<LigneDemande>();
        try {
            String sql = "SELECT * FROM lignedemande";
            Statement st = connexion.Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                lignesDemande.add(new LigneDemande(dmds.findById(rs.getInt("demande")), prods.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixVente")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lignesDemande;
    }
}
