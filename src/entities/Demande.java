package entities;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Demande {

    private int code;
    private Date date;
    private Fournisseur Fournisseur;
    private List<LigneDemande> ligneDemandes;

    public Demande(Date date, Fournisseur Fournisseur) {
        this.date = date;
        this.Fournisseur = Fournisseur;
        this.ligneDemandes = new ArrayList<>();
    }

    public Demande(int code, Date date, Fournisseur Fournisseur) {
        this.code = code;
        this.date = date;
        this.Fournisseur = Fournisseur;
        this.ligneDemandes = new ArrayList<LigneDemande>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Fournisseur getFournisseur() {
        return Fournisseur;
    }

    public void setFournisseur(Fournisseur Fournisseur) {
        this.Fournisseur = Fournisseur;
    }

    public List<LigneDemande> getLigneDemandes() {
        return ligneDemandes;
    }

    public void setLigneDemandes(List<LigneDemande> ligneDemandes) {
        this.ligneDemandes = ligneDemandes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.code;
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + Objects.hashCode(this.Fournisseur);
        hash = 79 * hash + Objects.hashCode(this.ligneDemandes);
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
        final Demande other = (Demande) obj;
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.Fournisseur, other.Fournisseur)) {
            return false;
        }
        if (!Objects.equals(this.ligneDemandes, other.ligneDemandes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return code + " / " + sdf.format(date);
    }
}
