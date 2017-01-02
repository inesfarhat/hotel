package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import domain.Chambre;
import domain.Hotel;
import domain.Reservation;
import interfaces.HotelServiceRemote;
@Stateless
public class HotelServices implements HotelServiceRemote{
	@PersistenceContext
	EntityManager entityManager;
    
	@Override
	public void ajoutHotel(Hotel hotel) {

		entityManager.merge(hotel);

	}
	@Override
	public void ajoutChambre(Chambre chambre) {

		entityManager.persist(chambre);

	}
	
	@Override
	public void ajoutReservation(Reservation reservation) {

		entityManager.persist(reservation);

	}
	
	
	@Override
	public void modifierHotel(Hotel hotel) {

		entityManager.merge(hotel);

	}
	@Override
	public void modifierChambre(Chambre chambre) {

		entityManager.merge(chambre);

	}
	@Override
	public Reservation modifierReservation(Reservation reservation) {

	return entityManager.merge(reservation);

	}
	@Override
	public void supprimerHotel(Hotel hotel) {
		entityManager.remove(entityManager.merge(hotel));
	}
	@Override
	public void removeChambre(Chambre chambre) {
		entityManager.remove(entityManager.merge(chambre));
	}
	@Override
	public Hotel chercherHotelParId(long id) {
		return entityManager.find(Hotel.class, id);
	}
	@Override
	public Chambre findFichierById(long id) {
		return entityManager.find(Chambre.class, id);
	}
	
	@Override
	public Hotel findHotelById(long id) {
		return entityManager.find(Hotel.class, id);
	}
	
	
	@Override
	public List<Hotel> affichierHotels() {

		String jpql = "select h from Hotel h";
		TypedQuery<Hotel> query = entityManager.createQuery(jpql, Hotel.class);
		List<Hotel> allHotels = query.getResultList();

		return allHotels;

	}
	
	
	

}
