package entities;

import java.awt.image.BufferedImage;
import java.util.Objects;

public class Produit {

    private int id;
    private String designation;
    private double prixAchat;
    private double tva;
    private BufferedImage photo;
    private Rayon rayon;
    private Categorie categorie;

    public Produit(int id, String designation, double prixAchat, double tva, BufferedImage photo, Rayon rayon, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.tva = tva;
        this.photo = photo;
        this.rayon = rayon;
        this.categorie = categorie;
    }

    public Produit(String designation, double prixAchat, double tva, Rayon rayon, Categorie categorie) {
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.tva = tva;
        this.rayon = rayon;
        this.categorie = categorie;
    }

    public Produit(int id, String designation, double prixAchat, double tva, Rayon rayon, Categorie categorie) {
        this.id = id;
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.tva = tva;
        this.rayon = rayon;
        this.categorie = categorie;
    }

    public Produit(String designation, double prixAchat, double tva, BufferedImage photo, Rayon rayon, Categorie categorie) {
        this.designation = designation;
        this.prixAchat = prixAchat;
        this.tva = tva;
        this.photo = photo;
        this.rayon = rayon;
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public double getTva() {
        return tva;
    }

    public BufferedImage getPhoto() {
        return photo;
    }

    public void setPhoto(BufferedImage photo) {
        this.photo = photo;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return designation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.designation);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.prixAchat) ^ (Double.doubleToLongBits(this.prixAchat) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tva) ^ (Double.doubleToLongBits(this.tva) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.photo);
        hash = 53 * hash + Objects.hashCode(this.rayon);
        hash = 53 * hash + Objects.hashCode(this.categorie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.designation, other.designation)) {
            return false;
        }
        if (Double.doubleToLongBits(this.prixAchat) != Double.doubleToLongBits(other.prixAchat)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tva) != Double.doubleToLongBits(other.tva)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.rayon, other.rayon)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        return true;
    }

}
