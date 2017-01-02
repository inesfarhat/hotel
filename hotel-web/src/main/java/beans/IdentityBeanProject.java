package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.Chambre;
import domain.Hotel;
import domain.Reservation;

@SessionScoped
@ManagedBean(name="identityProject")
public class IdentityBeanProject {
	
	private Hotel hotel ;
	private Reservation reservation ;
	private String date ;
	private Chambre chambre ;
	private Chambre chambre1 ;
	private Chambre chambre2 ;
	private Chambre chambre3 ;
	private Chambre chambre4 ;
	private Chambre chambre5 ;
	private Chambre chambre6 ;
	private Chambre chambre7 ;
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

	private int nb ;
	private int nb1 ;
	private int nb2 ;
	private int nb3 ;
	private int nb4 ;
	private int nb5 ;
	private int nb6 ;
	private int nb7 ;
	private int nb8 ;
	public int getNb1() {
		return nb1;
	}

	public void setNb1(int nb1) {
		this.nb1 = nb1;
	}

	public int getNb2() {
		return nb2;
	}

	public void setNb2(int nb2) {
		this.nb2 = nb2;
	}

	public int getNb3() {
		return nb3;
	}

	public void setNb3(int nb3) {
		this.nb3 = nb3;
	}

	public int getNb4() {
		return nb4;
	}

	public void setNb4(int nb4) {
		this.nb4 = nb4;
	}

	public int getNb5() {
		return nb5;
	}

	public void setNb5(int nb5) {
		this.nb5 = nb5;
	}

	public int getNb6() {
		return nb6;
	}

	public void setNb6(int nb6) {
		this.nb6 = nb6;
	}

	public int getNb7() {
		return nb7;
	}

	public void setNb7(int nb7) {
		this.nb7 = nb7;
	}

	public int getNb8() {
		return nb8;
	}

	public void setNb8(int nb8) {
		this.nb8 = nb8;
	}

	private int disponible ;
	private int disponible1 ;
	private int disponible2 ;
	private int disponible3 ;
	private int disponible4 ;
	private int disponible5 ;
	private int disponible6 ;
	private int disponible7 ;
	private int disponible8 ;
	

	public int getDisponible1() {
		return disponible1;
	}

	public void setDisponible1(int disponible1) {
		this.disponible1 = disponible1;
	}

	public int getDisponible2() {
		return disponible2;
	}

	public void setDisponible2(int disponible2) {
		this.disponible2 = disponible2;
	}

	public int getDisponible3() {
		return disponible3;
	}

	public void setDisponible3(int disponible3) {
		this.disponible3 = disponible3;
	}

	public int getDisponible4() {
		return disponible4;
	}

	public void setDisponible4(int disponible4) {
		this.disponible4 = disponible4;
	}

	public int getDisponible5() {
		return disponible5;
	}

	public void setDisponible5(int disponible5) {
		this.disponible5 = disponible5;
	}

	public int getDisponible6() {
		return disponible6;
	}

	public void setDisponible6(int disponible6) {
		this.disponible6 = disponible6;
	}

	public int getDisponible7() {
		return disponible7;
	}

	public void setDisponible7(int disponible7) {
		this.disponible7 = disponible7;
	}

	public int getDisponible8() {
		return disponible8;
	}

	public void setDisponible8(int disponible8) {
		this.disponible8 = disponible8;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IdentityBeanProject() {
		
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
	
	

}
