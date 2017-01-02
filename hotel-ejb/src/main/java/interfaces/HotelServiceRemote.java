package interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.Chambre;
import domain.Hotel;
import domain.Reservation;

@Remote
public interface HotelServiceRemote {

	List<Hotel> affichierHotels();

	Chambre findFichierById(long id);

	Hotel chercherHotelParId(long id);

	void removeChambre(Chambre chambre);

	void modifierChambre(Chambre chambre);

	void supprimerHotel(Hotel hotel);

	void ajoutHotel(Hotel hotel);

	void ajoutChambre(Chambre chambre);

	void modifierHotel(Hotel hotel);

	Hotel findHotelById(long id);

	void ajoutReservation(Reservation reservation);

	Reservation modifierReservation(Reservation reservation);



}
