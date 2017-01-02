package beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import domain.Administrateur;

import interfaces.UtilisateurServiceRemote;


@ManagedBean(name="manageUM")
@ViewScoped
public class ManageUserBean {
	
	@ManagedProperty("#{identity.administrateur}")
	private Administrateur administrateur ;
	@EJB
	private UtilisateurServiceRemote utilisateurServiceRemote ;
	private String rePassword ;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public ManageUserBean() {
		
	}
	
	private ArrayList<SelectItem> genderList;
	private String gender ; //give the default value

	public final ArrayList<SelectItem> getGenderList() {
	    return genderList;
	}

	public final void setGenderList(final ArrayList<SelectItem> genderList) {
	    this.genderList = genderList;
	}

	public String getGender() {
	    return gender;
	}

	public void setGender(String gender) {
	    this.gender = gender;
	}
    @PostConstruct
	public final void loadGender() {
    	gender = administrateur.getSex();
	    genderList = new ArrayList<SelectItem>();
	    genderList.add(new SelectItem("M", "Male"));
	    genderList.add(new SelectItem("F", "Female"));
	}
	public String enregistrerProfil(Administrateur administrateur) {
		String navigateTo = null;
		if(administrateur.getPassword().equals(rePassword)){
			administrateur.setSex(gender);
			utilisateurServiceRemote.modifierUser(administrateur);
			
			}
		else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Les mots de passe de sont pas identiques",
							null

			));
			
			
		}
		
		
		// navigateTo = "edit-hotel?faces-redirect=true";
		return navigateTo;

	}
    
	public String revenir() {
		String navigateTo = null;
		if(administrateur.getPassword().equals(rePassword)){
			administrateur.setSex(gender);
			utilisateurServiceRemote.modifierUser(administrateur);
			navigateTo = "hotels?faces-redirect=true";
			
			}
		else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Les mots de passe de sont pas identiques",
							null

			));
			
			
		}

		
		return navigateTo;

	}


}
