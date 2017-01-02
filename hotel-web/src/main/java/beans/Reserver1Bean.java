package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import domain.Chambre;
import domain.Hotel;

@ManagedBean(name="reserver1M")
@ViewScoped
public class Reserver1Bean {
	@ManagedProperty("#{identityProject.hotel}")
	private Hotel hotel ;
	
	@ManagedProperty("#{identityProject.chambre}")
	private Chambre chambre ;
	
	  public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	private List<String> images;
	     
	    @PostConstruct
	    public void init() {
	    	
	        images = new ArrayList<String>();
	        for (int i = 1; i <= 2; i++) {
	            images.add("nature" + i + ".jpg");
	        }
	    }
	 
	    public List<String> getImages() {
	        return images;
	    }

	public Reserver1Bean() {


	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	

}
