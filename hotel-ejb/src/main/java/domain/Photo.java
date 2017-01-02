package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo implements Serializable {
	
	private long idPhoto ;
	private String lien ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getIdPhoto() {
		return idPhoto;
	}


	public void setIdPhoto(long idPhoto) {
		this.idPhoto = idPhoto;
	}


	public String getLien() {
		return lien;
	}


	public void setLien(String lien) {
		this.lien = lien;
	}


	public Photo() {
	
	}
	
	
	

}
