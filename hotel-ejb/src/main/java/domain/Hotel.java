package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Hotel implements Serializable {
	
	private long id ;
	private Date dateCreationHotel ;
	private String nomHotel ;
	private String descriptionHotel ;
	private String lieuxHotel ;
	private String lienHotel ;
	private float taxHotel ;
	private List<Chambre>chambres ;
	

	public Hotel() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateCreationHotel() {
		return dateCreationHotel;
	}
	public void setDateCreationHotel(Date dateCreationHotel) {
		this.dateCreationHotel = dateCreationHotel;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public String getDescriptionHotel() {
		return descriptionHotel;
	}
	public void setDescriptionHotel(String descriptionHotel) {
		this.descriptionHotel = descriptionHotel;
	}
	public String getLieuxHotel() {
		return lieuxHotel;
	}
	public void setLieuxHotel(String lieuxHotel) {
		this.lieuxHotel = lieuxHotel;
	}
	public String getLienHotel() {
		return lienHotel;
	}
	public void setLienHotel(String lienHotel) {
		this.lienHotel = lienHotel;
	}

	public float getTaxHotel() {
		return taxHotel;
	}

	public void setTaxHotel(float taxHotel) {
		this.taxHotel = taxHotel;
	}
	@OneToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	

}
