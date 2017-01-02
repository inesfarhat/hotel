package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import domain.Chambre;
import domain.Hotel;
import domain.Reservation;
import interfaces.HotelServiceRemote;

@ManagedBean(name = "hotelM")
@ViewScoped
public class HotelsBean {

	@EJB
	private HotelServiceRemote hotelServiceRemote;
	private List<Hotel> hotels;
	private  List<Chambre> chambres;
	private Chambre chambre;
	private Hotel hotel;
	private Reservation reservation ;
	private String debDate ;
	private String finDate ;
	private String debDat  ;
	private int disponible ;
	private int disponible1 ;
	private int disponible2 ;
	private int disponible3 ;
	private int disponible4 ;
	private int disponible5 ;
	private int disponible6 ;
	private int disponible7 ;
	private int disponible8 ;
	private String clientId ;
	
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

	@ManagedProperty("#{identityProject.hotel}")
	private Hotel hotelH ;
	
	



	public Hotel getHotelH() {
		return hotelH;
	}

	public void setHotelH(Hotel hotelH) {
		this.hotelH = hotelH;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public String getDebDat() {
		return debDat;
	}

	public void setDebDat(String debDat) {
		this.debDat = debDat;
	}

	@ManagedProperty("#{identiy}")
	private IdentityBean identityBean;
	
	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject ;
	

	public HotelsBean() {
		reservation = new Reservation() ;

	}

	@PostConstruct
	private void initModel() {
		debDat = new Date().toString();
		hotel= hotelServiceRemote.findHotelById(1) ;
        identityBeanProject.setHotel(hotel);
		hotels = hotelServiceRemote.affichierHotels();
		

	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String suppHotel(Hotel hotel) {
		String navigateTo = null;

		hotelServiceRemote.supprimerHotel(hotel);
		hotels = hotelServiceRemote.affichierHotels();
		navigateTo = "hotels?faces-redirect=true";
		return navigateTo;

	}
	
	public String modifHotel(Hotel hotel) {
		String navigateTo = null;
        identityBeanProject.setHotel(hotel);
		navigateTo = "edit-hotel?faces-redirect=true";
		return navigateTo;

	}
	public String voirDispo() {
		String navigateTo = null;
		navigateTo = "reservation?faces-redirect=true";
		return navigateTo;

	}



	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String ajoutNouvHotel() {
		
		hotel.setChambres(new ArrayList<Chambre>());
		hotel.setChambres(chambres);
		
		hotelServiceRemote.ajoutHotel(hotel);
	

		return "";
	}
	

	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public void ajoutchambre() {
		//
		
		chambres.add(chambre);
		chambre = new Chambre();
		

	}

	public String detailHotel(Hotel hotel) {
		String navigateTo = null;
		identityBeanProject.setHotel(hotel);
		navigateTo = "hotel-detail?faces-redirect=true";
		return navigateTo;

	}
	public String reserverHotel(Hotel hotel) {
		String navigateTo = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date datestrt = formatter.parse(debDate);
			Date dateend = formatter.parse(finDate);
			reservation.setDateAriv(datestrt);
			reservation.setDateRet(dateend);
			System.out.println("Date changed noussa");
		} catch (Exception e) {
			System.out.println("Date changed" + e.getMessage());
		}
		
		identityBeanProject.setHotel(hotel);
		navigateTo = "reservation?faces-redirect=true";
		return navigateTo;

	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}

	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}
	public String ajoutReservation(){
		String navigateTo = null ;
		//Calendar calendar = Calendar.getInstance();
		disponible = hotelH.getChambres().get(0).getDispoChambre();
		disponible1 = hotelH.getChambres().get(1).getDispoChambre();
		disponible2 = hotelH.getChambres().get(2).getDispoChambre();
		disponible3 = hotelH.getChambres().get(3).getDispoChambre();
		disponible4 = hotelH.getChambres().get(4).getDispoChambre();
		disponible5 = hotelH.getChambres().get(5).getDispoChambre();
		disponible6 = hotelH.getChambres().get(6).getDispoChambre();
		disponible7 = hotelH.getChambres().get(7).getDispoChambre();
		disponible8 = hotelH.getChambres().get(8).getDispoChambre();
		
		identityBeanProject.setDisponible(disponible);
		identityBeanProject.setDisponible1(disponible1);
		identityBeanProject.setDisponible2(disponible2);
		identityBeanProject.setDisponible3(disponible3);
		identityBeanProject.setDisponible4(disponible4);
		identityBeanProject.setDisponible5(disponible5);
		identityBeanProject.setDisponible6(disponible6);
		identityBeanProject.setDisponible7(disponible7);
		identityBeanProject.setDisponible8(disponible8);

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date aujourdhui = new Date();
			SimpleDateFormat formater = null;
			formater = new SimpleDateFormat("yyyy-MM-dd");
		
			Date datestrt = formatter.parse(debDate);
	
		   System.out.println("comparer"+formater.format(aujourdhui)+"    "+datestrt);
			if(new Date().before(datestrt)||(formater.format(aujourdhui).equals(debDate)))
			{
			System.out.println("bien");
			reservation.setDateAriv(datestrt);
			identityBeanProject.setReservation(reservation);
			hotelServiceRemote.ajoutReservation(reservation);
			navigateTo = "reservation1?faces-redirect=true";
			}
			else{
			
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Date Invalide.",
									null

					));
				
			}
			
			//reservation.setDateRet(dateend);
			//System.out.println("Date changed");
		} catch (Exception e) {
			System.out.println("Date changed" + e.getMessage());
			System.out.println("Date changed" + debDate.toString());
		}
		
		return navigateTo ;
		
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getDebDate() {
		return debDate;
	}

	public void setDebDate(String debDate) {
		this.debDate = debDate;
	}

	public String getFinDate() {
		return finDate;
	}

	public void setFinDate(String finDate) {
		this.finDate = finDate;
	}

}
