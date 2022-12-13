/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import entities.Categorie;
import entities.Produit;
import entities.Rayon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CategorieService;
import services.ProduitService;
import services.RayonService;

/**
 *
 * @author info
 */
public class ProduitForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProduitForm
     */
    private ProduitService ps;
    private RayonService rs;
    private CategorieService cs;
    private static int id;
    private DefaultTableModel model;

    public ProduitForm() {
        initComponents();
        this.setTitle("Gestions des produits");
        ps = new ProduitService();
        rs = new RayonService();
        cs = new CategorieService();
        model = (DefaultTableModel) listProduit.getModel();
        loadRayon();
        loadCategorie();
        loadProduit();
    }

    public void loadProduit() {
        model.setRowCount(0);
        for (Produit p : ps.findAll()) {
            model.addRow(new Object[]{p.getId(), p.getDesignation(), p.getPrixAchat(), p.getTva(), p.getRayon(), p.getCategorie()});
        }
    }

    public void loadRayon() {
        for (Rayon r : rs.findAll()) {
            listRayon.addItem(r);
        }
    }

    public void loadCategorie() {
        for (Categorie c : cs.findAll()) {
            listCategorie.addItem(c);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDesignation = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrixAchat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAjouter = new javax.swing.JButton();
        btnModifer = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        listRayon = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtTva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        listCategorie = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProduit = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informations des produits"));

        jLabel1.setText("Désignation");

        jLabel2.setText("Prix d'achat");

        jLabel3.setText("Rayon");

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });

        btnModifer.setText("Modifier");
        btnModifer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModiferActionPerformed(evt);
            }
        });

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        jLabel4.setText("TVA");

        jLabel5.setText("Catégorie");

        jLabel6.setText("Photo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTva)
                            .addComponent(txtDesignation, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtPrixAchat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModifer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAjouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSupprimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listRayon, 0, 204, Short.MAX_VALUE)
                            .addComponent(listCategorie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjouter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrixAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModifer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSupprimer)
                    .addComponent(jLabel4)
                    .addComponent(txtTva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(listRayon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(listCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Liste des produits"));

        listProduit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Désignation", "Prix d'achat", "TVA", "Rayon", "Catégorie"
            }
        ));
        listProduit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProduitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listProduit);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listProduitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProduitMouseClicked
        // TODO add your handling code here:
        id = Integer.parseInt(model.getValueAt(listProduit.getSelectedRow(), 0).toString());
        txtDesignation.setText(model.getValueAt(listProduit.getSelectedRow(), 1).toString());
        txtPrixAchat.setText(model.getValueAt(listProduit.getSelectedRow(), 2).toString());
        txtTva.setText(model.getValueAt(listProduit.getSelectedRow(), 3).toString());
        listRayon.setSelectedItem((Rayon) model.getValueAt(listProduit.getSelectedRow(), 4));
        listCategorie.setSelectedItem((Categorie) model.getValueAt(listProduit.getSelectedRow(), 5));

    }//GEN-LAST:event_listProduitMouseClicked

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        // TODO add your handling code here:
        String designation = txtDesignation.getText();
        double prixAchat = Double.parseDouble(txtPrixAchat.getText());
        double tva = Double.parseDouble(txtTva.getText());
        Rayon rayon = (Rayon) listRayon.getSelectedItem();
        Categorie categorie = (Categorie) listCategorie.getSelectedItem();

        if (ps.create(new Produit(designation, prixAchat, tva, rayon, categorie))) {
            loadProduit();
            JOptionPane.showMessageDialog(this, "Succès !");
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        // TODO add your handling code here:
        if (id != 0) {
            int rep = JOptionPane.showConfirmDialog(this, "Voulez vous vraimment supprimer cet élément ?");
            if (rep == 0) {
                if (ps.delete(ps.findById(id))) {
                    loadProduit();
                    JOptionPane.showMessageDialog(this, "Succès !");
                } else {
                    JOptionPane.showMessageDialog(this, "Echec !");
                }
            }
        }
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnModiferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModiferActionPerformed
        // TODO add your handling code here:
        String designation = txtDesignation.getText();
        double prixAchat = Double.parseDouble(txtPrixAchat.getText());
        double tva = Double.parseDouble(txtTva.getText());
        Rayon rayon = (Rayon) listRayon.getSelectedItem();
        Categorie categorie = (Categorie) listCategorie.getSelectedItem();
        if (ps.update(new Produit(id, designation, prixAchat, tva, rayon, categorie))) {
            loadProduit();
            JOptionPane.showMessageDialog(this, "Succès !");
        }
    }//GEN-LAST:event_btnModiferActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnModifer;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listCategorie;
    private javax.swing.JTable listProduit;
    private javax.swing.JComboBox listRayon;
    private javax.swing.JTextField txtDesignation;
    private javax.swing.JTextField txtPrixAchat;
    private javax.swing.JTextField txtTva;
    // End of variables declaration//GEN-END:variables
}
