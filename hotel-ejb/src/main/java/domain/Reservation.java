package domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation implements Serializable{
	

	public Reservation() {
		
	}
	private long idReservation ;
	private String nom ;
	private Date dateAriv ;
	private Date DateRet ;
	private int nbChambre ;
	private int nbEnfant ;
	private float prixTotal ;
	private String courriel;
	private String titre ;
	private String prenom ;
	private String rue ;
	private String codePostal;
	private String Ville ;
	private String telPostable  ;
	private String telephone ;
	private int nbAdulteParcChambre ;
	private String nomReservation ;
	private String numCarteDeCredit ;
	private Date dateValidation ;
	private float prixTotlAvantTax ;
	private String type ;
	private int nuite ;
	

	
	public int getNuite() {
		return nuite;
	}
	public void setNuite(int nuite) {
		this.nuite = nuite;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(long idReservation) {
		this.idReservation = idReservation;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateAriv() {
		return dateAriv;
	}
	public void setDateAriv(Date dateAriv) {
		this.dateAriv = dateAriv;
	}
	public Date getDateRet() {
		return DateRet;
	}
	public void setDateRet(Date dateRet) {
		DateRet = dateRet;
	}
	public int getNbChambre() {
		return nbChambre;
	}
	public void setNbChambre(int nbChambre) {
		this.nbChambre = nbChambre;
	}
	public int getNbEnfant() {
		return nbEnfant;
	}
	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return Ville;
	}
	public void setVille(String ville) {
		Ville = ville;
	}
	public String getTelPostable() {
		return telPostable;
	}
	public void setTelPostable(String telPostable) {
		this.telPostable = telPostable;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getNbAdulteParcChambre() {
		return nbAdulteParcChambre;
	}
	public void setNbAdulteParcChambre(int nbAdulteParcChambre) {
		this.nbAdulteParcChambre = nbAdulteParcChambre;
	}
	public String getNomReservation() {
		return nomReservation;
	}
	public void setNomReservation(String nomReservation) {
		this.nomReservation = nomReservation;
	}
	public String getNumCarteDeCredit() {
		return numCarteDeCredit;
	}
	public void setNumCarteDeCredit(String numCarteDeCredit) {
		this.numCarteDeCredit = numCarteDeCredit;
	}
	public Date getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}
	
	public float getPrixTotlAvantTax() {
		return prixTotlAvantTax;
	}
	public void setPrixTotlAvantTax(float prixTotlAvantTax) {
		this.prixTotlAvantTax = prixTotlAvantTax;
	}
	public float getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	

}
