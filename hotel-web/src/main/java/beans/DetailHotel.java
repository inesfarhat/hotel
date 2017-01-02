package beans;

import java.util.ArrayList;
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

@ManagedBean(name = "detailHotelM")
@ViewScoped
public class DetailHotel {
	@EJB
	private HotelServiceRemote hotelServiceRemote;

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	private int nbr;
	private String option;

	private int nb1;
	private String option1;

	private int nb2;
	private String option2;

	private int nb3;
	private String option3;

	private int nb4;
	private String option4;

	private int nb5;
	private String option5;

	private int nb6;
	private String option6;

	private int nb7;
	private String option7;

	private int nb8;
	private String option8;

	public int getNb1() {
		return nb1;
	}

	public void setNb1(int nb1) {
		this.nb1 = nb1;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public int getNb2() {
		return nb2;
	}

	public void setNb2(int nb2) {
		this.nb2 = nb2;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public int getNb3() {
		return nb3;
	}

	public void setNb3(int nb3) {
		this.nb3 = nb3;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public int getNb4() {
		return nb4;
	}

	public void setNb4(int nb4) {
		this.nb4 = nb4;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public int getNb5() {
		return nb5;
	}

	public void setNb5(int nb5) {
		this.nb5 = nb5;
	}

	public String getOption5() {
		return option5;
	}

	public void setOption5(String option5) {
		this.option5 = option5;
	}

	public int getNb6() {
		return nb6;
	}

	public void setNb6(int nb6) {
		this.nb6 = nb6;
	}

	public String getOption6() {
		return option6;
	}

	public void setOption6(String option6) {
		this.option6 = option6;
	}

	public int getNb7() {
		return nb7;
	}

	public void setNb7(int nb7) {
		this.nb7 = nb7;
	}

	public String getOption7() {
		return option7;
	}

	public void setOption7(String option7) {
		this.option7 = option7;
	}

	public int getNb8() {
		return nb8;
	}

	public void setNb8(int nb8) {
		this.nb8 = nb8;
	}

	public String getOption8() {
		return option8;
	}

	public void setOption8(String option8) {
		this.option8 = option8;
	}

	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();
	ArrayList<String> list4 = new ArrayList<String>();
	ArrayList<String> list5 = new ArrayList<String>();
	ArrayList<String> list6 = new ArrayList<String>();
	ArrayList<String> list7 = new ArrayList<String>();
	ArrayList<String> list8 = new ArrayList<String>();

	public ArrayList<String> getList1() {
		return list1;
	}

	public void setList1(ArrayList<String> list1) {
		this.list1 = list1;
	}

	public ArrayList<String> getList2() {
		return list2;
	}

	public void setList2(ArrayList<String> list2) {
		this.list2 = list2;
	}

	public ArrayList<String> getList3() {
		return list3;
	}

	public void setList3(ArrayList<String> list3) {
		this.list3 = list3;
	}

	public ArrayList<String> getList4() {
		return list4;
	}

	public void setList4(ArrayList<String> list4) {
		this.list4 = list4;
	}

	public ArrayList<String> getList5() {
		return list5;
	}

	public void setList5(ArrayList<String> list5) {
		this.list5 = list5;
	}

	public ArrayList<String> getList6() {
		return list6;
	}

	public void setList6(ArrayList<String> list6) {
		this.list6 = list6;
	}

	public ArrayList<String> getList7() {
		return list7;
	}

	public void setList7(ArrayList<String> list7) {
		this.list7 = list7;
	}

	public ArrayList<String> getList8() {
		return list8;
	}

	public void setList8(ArrayList<String> list8) {
		this.list8 = list8;
	}

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

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@PostConstruct
	private void init() {
		hotel = hotelServiceRemote.findHotelById(1);
		identityBeanProject.setHotel(hotel);

		disponible = identityBeanProject.getDisponible();
		disponible1 = identityBeanProject.getDisponible1();
		disponible2 = identityBeanProject.getDisponible2();
		disponible3 = identityBeanProject.getDisponible3();
		disponible4 = identityBeanProject.getDisponible4();
		disponible5 = identityBeanProject.getDisponible5();
		disponible6 = identityBeanProject.getDisponible6();
		disponible7 = identityBeanProject.getDisponible7();
		disponible8 = identityBeanProject.getDisponible8();

		for (Integer i = 0; i <= disponible; i++) {

			list.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible1; i++) {

			list1.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible2; i++) {

			list2.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible3; i++) {

			list3.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible4; i++) {

			list4.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible5; i++) {

			list5.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible6; i++) {

			list6.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible7; i++) {

			list7.add(Integer.toString(i));

		}
		for (Integer i = 0; i <= disponible8; i++) {

			list8.add(Integer.toString(i));

		}

	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@ManagedProperty("#{identityProject.reservation}")
	private Reservation reservation;

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	@ManagedProperty("#{identityProject.disponible}")
	private int disponible;

	@ManagedProperty("#{identityProject.disponible1}")
	private int disponible1;
	@ManagedProperty("#{identityProject.disponible2}")
	private int disponible2;
	@ManagedProperty("#{identityProject.disponible3}")
	private int disponible3;
	@ManagedProperty("#{identityProject.disponible4}")
	private int disponible4;
	@ManagedProperty("#{identityProject.disponible5}")
	private int disponible5;
	@ManagedProperty("#{identityProject.disponible6}")
	private int disponible6;
	@ManagedProperty("#{identityProject.disponible7}")
	private int disponible7;
	@ManagedProperty("#{identityProject.disponible8}")
	private int disponible8;

	private boolean showForm = true;
	Chambre chambre = new Chambre();

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public String detailHotel() {
		String navigateTo = null;
		float s = 0;
		System.out.println("ss" + option);
		if ((option.equals("0")) && (option1.equals("0")) && (option2.equals("0"))
				&& (option3.equals("0")) && (option4.equals("0")) && (option5.equals("0"))
				&&( option6.equals("0")) && (option7.equals("0")) && (option8.equals("0"))) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vous devez choisir au moins une chambre", null

			));
		} else {
			if (!(option.equals("0"))) {
				System.out.println("noussadomba"+(hotel.getChambres().get(0).getDispoChambre() - Integer.parseInt(option)));
				hotel.getChambres().get(0)
						.setDispoChambre(hotel.getChambres().get(0).getDispoChambre() - Integer.parseInt(option));
				s = s + ((hotel.getChambres().get(0).getPrixChambre() * Integer.parseInt(option))
						* reservation.getNuite());
			}
			if (!(option1.equals("0"))) {
			hotel.getChambres().get(1)
					.setDispoChambre(hotel.getChambres().get(1).getDispoChambre() - Integer.parseInt(option1));
			s = s + ((hotel.getChambres().get(1).getPrixChambre() * Integer.parseInt(option1))
					* reservation.getNuite());
			}
			if (!(option2.equals("0"))) {
			hotel.getChambres().get(2)
					.setDispoChambre(hotel.getChambres().get(2).getDispoChambre() - Integer.parseInt(option2));
			s = s + ((hotel.getChambres().get(2).getPrixChambre() * Integer.parseInt(option2))
					* reservation.getNuite());
			}
			if (!(option3.equals("0"))) {
			hotel.getChambres().get(3)
					.setDispoChambre(hotel.getChambres().get(3).getDispoChambre() - Integer.parseInt(option3));
			s = s + ((hotel.getChambres().get(3).getPrixChambre() * Integer.parseInt(option3))
					* reservation.getNuite());
			}
			if (!(option4.equals("0"))) {
			hotel.getChambres().get(4)
					.setDispoChambre(hotel.getChambres().get(4).getDispoChambre() - Integer.parseInt(option4));
			s = s + ((hotel.getChambres().get(4).getPrixChambre() * Integer.parseInt(option4))
					* reservation.getNuite());
			}
			if (!(option5.equals("0"))) {
			hotel.getChambres().get(5)
					.setDispoChambre(hotel.getChambres().get(5).getDispoChambre() - Integer.parseInt(option5));
			s = s + ((hotel.getChambres().get(5).getPrixChambre() * Integer.parseInt(option5))
					* reservation.getNuite());
			}
			if (!(option6.equals("0"))) {
			hotel.getChambres().get(6)
					.setDispoChambre(hotel.getChambres().get(6).getDispoChambre() - Integer.parseInt(option6));
			s = s + ((hotel.getChambres().get(6).getPrixChambre() * Integer.parseInt(option6))
					* reservation.getNuite());
			}
			if (!(option7.equals("0"))) {
			hotel.getChambres().get(7)
					.setDispoChambre(hotel.getChambres().get(7).getDispoChambre() - Integer.parseInt(option7));
			s = s + ((hotel.getChambres().get(7).getPrixChambre() * Integer.parseInt(option7))
					* reservation.getNuite());
			}
			if (!(option8.equals("0"))) {
			hotel.getChambres().get(8)
					.setDispoChambre(hotel.getChambres().get(8).getDispoChambre() - Integer.parseInt(option8));
			s = s + ((hotel.getChambres().get(8).getPrixChambre() * Integer.parseInt(option8))
					* reservation.getNuite());
			}

			identityBeanProject.setHotel(hotel);
			identityBeanProject.setChambre(hotel.getChambres().get(0));
			identityBeanProject.setChambre1(hotel.getChambres().get(1));
			identityBeanProject.setChambre2(hotel.getChambres().get(2));
			identityBeanProject.setChambre3(hotel.getChambres().get(3));
			identityBeanProject.setChambre4(hotel.getChambres().get(4));
			identityBeanProject.setChambre5(hotel.getChambres().get(5));
			identityBeanProject.setChambre6(hotel.getChambres().get(6));
			identityBeanProject.setChambre7(hotel.getChambres().get(7));
			identityBeanProject.setChambre8(hotel.getChambres().get(8));
			
			identityBeanProject.setNb(nbr);
			

			reservation.setPrixTotlAvantTax(s);
			identityBeanProject.setReservation(reservation);
			identityBeanProject.setHotel(hotel);
			
			navigateTo = "reservation2?faces-redirect=true";
		}
		return navigateTo;

	}

	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject;

	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}

	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}

	public int getNbr() {
		return nbr;
	}

	public void plus() {
		System.out.println(nbr + "plus");

	}

	public void moins() {
		if (nbr > 0) {
			nbr--;
			hotel.getChambres().get(0).setDispoChambre(hotel.getChambres().get(0).getDispoChambre() + 1);
			identityBeanProject.setHotel(hotel);
		}

	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public String detailChambre(Chambre chambre) {
		String navigateTo = null;
		identityBeanProject.setChambre(chambre);
		;
		navigateTo = "chambre-detail?faces-redirect=true";
		return navigateTo;

	}

	private Hotel hotel;

	public DetailHotel() {

	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String modifDispo(Chambre chambre) {
		String navigateTo = null;
		identityBeanProject.setChambre(chambre);
		navigateTo = "edit-dispo?faces-redirect=true";
		return navigateTo;

	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
