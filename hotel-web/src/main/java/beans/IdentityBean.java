package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.Administrateur;
import domain.Hotel;

@SessionScoped
@ManagedBean(name="identity")
public class IdentityBean {
	
	private Administrateur administrateur ;
	private Hotel hotel ;
	

	public IdentityBean() {
		
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
	
	

}
