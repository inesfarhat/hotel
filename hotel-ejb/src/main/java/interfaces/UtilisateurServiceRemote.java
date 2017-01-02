package interfaces;

import javax.ejb.Remote;
import domain.Administrateur;


@Remote
public interface UtilisateurServiceRemote {

	Administrateur authentification(String email, String password);

	void modifierUser(Administrateur administrateur);

	Administrateur findUserByEmail(String email);


	
	

}
