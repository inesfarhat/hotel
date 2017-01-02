package beans;

import javax.ejb.EJB;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import domain.Administrateur;
import interfaces.UtilisateurServiceRemote;


@ManagedBean(name="utilisM")
@ViewScoped
public class UtilisateurBean {

	@EJB
	public UtilisateurServiceRemote utilisateurServiceRemote;
	private String email;
	private String password;
	private String pwd ;
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@ManagedProperty("#{identity}")
	private IdentityBean identityBean;

	public UtilisateurBean() {

	}

	public String Login() {
		String navigateTo = null;

		Administrateur administrateur = utilisateurServiceRemote.authentification(email, password);
		identityBean.setAdministrateur(administrateur);
		if (!(administrateur == null)) {
			navigateTo = "hotels?faces-redirect=true";
			
			return navigateTo;
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Une ou plusieurs erreurs ont été détectées. Veuillez corriger les champs indiqués ci-dessous.",
							null

			));
		}
		return navigateTo;

	}
	
	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		navigateTo = "dashboard?faces-redirect=true";
		return navigateTo;
	}
	
	public String forgotPwd(){	String navigateTo = null;

	Administrateur administrateur = utilisateurServiceRemote.findUserByEmail(pwd);
	navigateTo = "";
	//identityBean.setAdministrateur(administrateur);
	if (!(administrateur == null)) {
		//navigateTo = "dashboard?faces-redirect=true";
		Mailing mailing = new Mailing(administrateur);
		
			
			try {
				mailing.generateAndSendForgotPassword();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Une ou plusieurs erreurs ont été détectées. Veuillez corriger les champs indiqués ci-dessous.",
						null

		));
		
		return navigateTo;
	} else {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Une ou plusieurs erreurs ont été détectées. Veuillez corriger les champs indiqués ci-dessous.",
						null

		));
	}
	return navigateTo;

	
	}
	
	
	public String revenir() {
		String navigateTo = null;

		navigateTo = "dashboard?faces-redirect=true";
		return navigateTo;

	}


	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

}
