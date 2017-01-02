package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import domain.Hotel;
import domain.Reservation;

@ManagedBean(name="reserverChB")
@ViewScoped
public class Reserver2Bean {
	
	@ManagedProperty("#{identityProject.hotel}")
	private Hotel hotel ;
	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject ;
	
	@ManagedProperty("#{identityProject.reservation}")
	private Reservation reservation ;
	@ManagedProperty("#{identityProject.nb}")
	private int nbr ;
       

	public int getNbr() {
		return nbr;
	}


	public void setNbr(int nbr) {
		this.nbr = nbr;
	}


	public Reserver2Bean() {
		
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String detailHotel() {
		String navigateTo = null;
		float s =0 ;
		
		
		s= s +((hotel.getChambres().get(0).getPrixChambre()*nbr )*reservation.getNuite()) ;
				
		System.out.println("la somme totale"+s);
		reservation.setPrixTotlAvantTax(s);
		identityBeanProject.setReservation(reservation);
		identityBeanProject.setHotel(hotel);
		navigateTo = "reservation2?faces-redirect=true";
		return navigateTo;

	}


	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}


	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	

}
