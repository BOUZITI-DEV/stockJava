package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {

	private int code;
	private Date date;
	private Fournisseur Fournisseur;
	private List<LigneDemande> ligneDemandes;
	
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
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Demande : " + code + " / " + sdf.format(date);
	}
}
