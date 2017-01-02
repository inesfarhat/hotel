package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.mail.MessagingException;

import domain.Chambre;
import domain.Hotel;
import domain.Reservation;
import interfaces.HotelServiceRemote;

@ManagedBean(name = "comfirmationFinal")
@ViewScoped
public class Reserver5Bean {
    @EJB
	private HotelServiceRemote hotelServiceRemote ;
    
	@ManagedProperty("#{identityProject.hotel}")
    private Hotel hotel ;
	@ManagedProperty("#{identityProject.chambre}")
    private Chambre chambre ;
	@ManagedProperty("#{identityProject.chambre1}")
    private Chambre chambre1 ;
	@ManagedProperty("#{identityProject.chambre2}")
    private Chambre chambre2 ;
	@ManagedProperty("#{identityProject.chambre3}")
    private Chambre chambre3 ;
	@ManagedProperty("#{identityProject.chambre4}")
    private Chambre chambre4 ;
	@ManagedProperty("#{identityProject.chambre5}")
    private Chambre chambre5 ;
	@ManagedProperty("#{identityProject.chambre6}")
    private Chambre chambre6 ;
	@ManagedProperty("#{identityProject.chambre7}")
    private Chambre chambre7;
	@ManagedProperty("#{identityProject.chambre8}")
    private Chambre chambre8 ;
	
	
	public Chambre getChambre1() {
		return chambre1;
	}

	public void setChambre1(Chambre chambre1) {
		this.chambre1 = chambre1;
	}

	public Chambre getChambre2() {
		return chambre2;
	}

	public void setChambre2(Chambre chambre2) {
		this.chambre2 = chambre2;
	}

	public Chambre getChambre3() {
		return chambre3;
	}

	public void setChambre3(Chambre chambre3) {
		this.chambre3 = chambre3;
	}

	public Chambre getChambre4() {
		return chambre4;
	}

	public void setChambre4(Chambre chambre4) {
		this.chambre4 = chambre4;
	}

	public Chambre getChambre5() {
		return chambre5;
	}

	public void setChambre5(Chambre chambre5) {
		this.chambre5 = chambre5;
	}

	public Chambre getChambre6() {
		return chambre6;
	}

	public void setChambre6(Chambre chambre6) {
		this.chambre6 = chambre6;
	}

	public Chambre getChambre7() {
		return chambre7;
	}

	public void setChambre7(Chambre chambre7) {
		this.chambre7 = chambre7;
	}

	public Chambre getChambre8() {
		return chambre8;
	}

	public void setChambre8(Chambre chambre8) {
		this.chambre8 = chambre8;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@ManagedProperty("#{identityProject.reservation}")
	private Reservation reservation;
	
	Reservation reservationCreate ;

	public Reserver5Bean() {

	}

	public String envoyerEmail() {

		reservationCreate = hotelServiceRemote.modifierReservation(reservation) ;
		
		Mailing mailing = new Mailing( "ines",reservationCreate, hotel);
		String navigateTo = null;
		try {
			mailing.generateAndSendAcceptEmail();
			mailing.generateAndSendAcceptEmailPourAdmin();
			hotelServiceRemote.modifierHotel(hotel);
			hotelServiceRemote.modifierChambre(chambre);
			hotelServiceRemote.modifierChambre(chambre1);
			hotelServiceRemote.modifierChambre(chambre2);
			hotelServiceRemote.modifierChambre(chambre3);
			hotelServiceRemote.modifierChambre(chambre4);
			hotelServiceRemote.modifierChambre(chambre5);
			hotelServiceRemote.modifierChambre(chambre6);
			hotelServiceRemote.modifierChambre(chambre7);
			hotelServiceRemote.modifierChambre(chambre8);
			
			
			navigateTo = "reservation5?faces-redirect=true";
			return navigateTo ;

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navigateTo;

	}
	
	
	public String envoyerEmailCarte() {

		reservationCreate = hotelServiceRemote.modifierReservation(reservation) ;
		Mailing mailing = new Mailing( "ines",reservationCreate, hotel);
	
		String navigateTo = null;
		try {
			mailing.generateAndSendAcceptEmailAvecCarte();
			mailing.generateAndSendAcceptEmailPourAdminAvecCarte();
			navigateTo = "reservation5?faces-redirect=true";
			return navigateTo;
	

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return navigateTo;
		

	}
	public String nouvReservation() {
		String navigateTo = null;

		navigateTo = "index?faces-redirect=true";
		return navigateTo;

	}
	
	

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Reservation getReservationCreate() {
		return reservationCreate;
	}

	public void setReservationCreate(Reservation reservationCreate) {
		this.reservationCreate = reservationCreate;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
