package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import domain.Hotel;

@ManagedBean(name="editM")
public class HotelEdit {
	
	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject ;
	
	@ManagedProperty("#{identityBeanProject.hotel}")
	private Hotel hotel ;
	
	
	public HotelEdit() {
		
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String modifHote(Hotel hotel) {
		String navigateTo = null;
        identityBeanProject.setHotel(hotel);
		navigateTo = "edit-hotel?faces-redirect=true";
		return navigateTo;

	}

	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}

	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}

}
