package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Chambre implements Serializable {
	private long idChambre ;
	private String nomChambre ;
	private String descriptionChambre ;
	private float prixChambre ;
	private int dispoChambre ;
	private int nbChClient ;
	private List<Photo>photos ;
	private String lienPhoto ;
	
	public String getLienPhoto() {
		return lienPhoto;
	}
	public void setLienPhoto(String lienPhoto) {
		this.lienPhoto = lienPhoto;
	}
	@OneToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Chambre() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(long idChambre) {
		this.idChambre = idChambre;
	}
	public String getNomChambre() {
		return nomChambre;
	}
	public void setNomChambre(String nomChambre) {
		this.nomChambre = nomChambre;
	}
	public String getDescriptionChambre() {
		return descriptionChambre;
	}
	public void setDescriptionChambre(String descriptionChambre) {
		this.descriptionChambre = descriptionChambre;
	}
	public float getPrixChambre() {
		return prixChambre;
	}
	public void setPrixChambre(float prixChambre) {
		this.prixChambre = prixChambre;
	}
	public int getDispoChambre() {
		return dispoChambre;
	}
	public void setDispoChambre(int dispoChambre) {
		this.dispoChambre = dispoChambre;
	}
	public int getNbChClient() {
		return nbChClient;
	}
	public void setNbChClient(int nbChClient) {
		this.nbChClient = nbChClient;
	}
	
	

}
