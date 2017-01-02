package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import domain.Administrateur;
import domain.Hotel;
import interfaces.UtilisateurServiceRemote;


@Stateless
public class UtilisateurService implements UtilisateurServiceRemote {
	@PersistenceContext
	EntityManager entityManager ;
	
	@Override
	public void modifierUser(Administrateur administrateur) {

		entityManager.merge(administrateur);

	}
	
	@Override
	public Administrateur authentification(String email, String password) {
		Administrateur administrateur = null;
		Query query = entityManager.createQuery("select a from Administrateur a  where a.email=:x and a.password=:y");
		query.setParameter("x", email).setParameter("y", password);
		try {
			administrateur =  (Administrateur) query.getSingleResult();
		} catch (Exception e) {
		
		}
		return administrateur;
	}
	@Override
	public Administrateur findUserByEmail(String email) {
		Administrateur administrateur = null;
		Query query = entityManager.createQuery("select a from Administrateur a  where a.email=:x ");
		query.setParameter("x", email);
		try {
			administrateur =  (Administrateur) query.getSingleResult();
		} catch (Exception e) {
		
		}
		return administrateur;
	}

}
