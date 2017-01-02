package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import domain.Chambre;
import interfaces.HotelServiceRemote;

@ManagedBean(name = "dispoM")
@ViewScoped
public class EditDispo {
	@EJB
	private HotelServiceRemote hotelServiceRemote;
	@ManagedProperty("#{identityProject.chambre}")
	private Chambre chambre;

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@ManagedProperty("#{identityProject}")
	private IdentityBeanProject identityBeanProject;

	public IdentityBeanProject getIdentityBeanProject() {
		return identityBeanProject;
	}

	public void setIdentityBeanProject(IdentityBeanProject identityBeanProject) {
		this.identityBeanProject = identityBeanProject;
	}

	public EditDispo() {

	}

	public String enregistrerDispo(Chambre chambre) {
		String navigateTo = null;
		hotelServiceRemote.modifierChambre(chambre);
		// navigateTo = "edit-hotel?faces-redirect=true";
		return navigateTo;

	}

	public String revenir() {
		String navigateTo = null;

		navigateTo = "edit-hotel?faces-redirect=true";
		return navigateTo;

	}

}
