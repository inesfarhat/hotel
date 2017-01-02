package beans;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import domain.Hotel;
import domain.Reservation;

@ManagedBean(name="confirmationMB")
@ViewScoped
public class Reserver4Bean {
	@ManagedProperty("#{identityProject.hotel}")
	private Hotel hotel ;
	@ManagedProperty("#{identityProject.reservation}")
	private Reservation reservation ;
	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject ;

	public Reserver4Bean() {
		
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
		
	public String detailHotel() {
		String navigateTo = null;
		
		
		if(reservation.getCourriel().equals(null)){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Veuillez renseigner les champs obligatoires (Courriel,Titre,Nom,Prénom,Téléphone Portable).",
							null

			));}
			else{
				
				navigateTo = "reservation4?faces-redirect=true";
				identityBeanProject.setReservation(reservation);
			}
	
			
		
		return navigateTo;

	}

	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}

	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}
	public String click() {
		String navigateTo = null;

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Une ou plusieurs erreurs ont été détectées. Veuillez corriger les champs indiqués ci-dessous.",
							null

			));
	
		return navigateTo;

	}

}
