package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import domain.Hotel;
import domain.Reservation;

@ManagedBean(name="reserverProfilMB")
@ViewScoped
public class Reserver3Bean {
	
	@ManagedProperty("#{identityProject.hotel}")
	private Hotel hotel ;
	@ManagedProperty("#{identityProject.reservation}")
	private Reservation reservation ;
	@ManagedProperty("#{identityProject}")
    private IdentityBeanProject identityBeanProject ;
	@ManagedProperty("#{identityProject.nb}")
	private int nbr ;
	
	


	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public Reserver3Bean() {
		
	}
	@PostConstruct
	public void initModel(){
		
		
	}


	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public String detailHotel() {
		String navigateTo = null;
		float s = (reservation.getNbAdulteParcChambre()+reservation.getNbEnfant())*hotel.getTaxHotel()+reservation.getPrixTotlAvantTax();
		reservation.setPrixTotal(s);
		identityBeanProject.setReservation(reservation);	
		navigateTo = "reservation3?faces-redirect=true";
		return navigateTo;

	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}
	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}
	
	

}
