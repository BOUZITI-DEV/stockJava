package entities;

public class Fournisseur {

    private int id;
    private String nom;
    private String telephone;
    private String email;

    public Fournisseur(String nom, String telephone, String email) {
        super();
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }

    public Fournisseur(int id, String nom, String telephone, String email) {
        super();
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "fournisseur : " + nom + " telephone : " + telephone + " email : " + email;
    }
}
