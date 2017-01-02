package beans;

import java.util.Properties;

import javax.annotation.PostConstruct;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import domain.Administrateur;
import domain.Hotel;
import domain.Reservation;

public class Mailing {
	private int numeroReservation;

	private int numR;
	private String type;
	private String numero;
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	private Reservation reservationCreate;
	private Hotel hotelModif;
	private Administrateur administrateur;

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	@PostConstruct
	public void initModel() {

	}

	public Mailing() {

	}

	public Mailing(String name, Reservation reservation, Hotel hotel) {
		super();

		reservationCreate = reservation;
		hotelModif = hotel;

	}

	public Mailing(Administrateur administrateur) {
		super();

		this.administrateur = administrateur;

	}

	public void generateAndSendForgotPassword() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");

		getMailSession = Session.getInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ines.farhat@esprit.tn"));
		generateMailMessage.setSubject("Vos Infos");
		String emailBody = "<p style='color:blue;font-size:200%;'><br>R�servation N�" + "" + " </br><p/>";
		emailBody += "<p ><table><tr><td><span style='color:red;font-size:150%;'>BONJOUR, &nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td><span style='color:black;font-size:150%;'>Vos coordonn�es d'acc�s</span><br/>"
				+ "<span style='color:black;font-size:150%;'></span></td></tr><p/>";

		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>votre email: :&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>votre email: " + administrateur.getEmail()
				+ "</span><td/></tr><p/>";

		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + "Votre Mot de passe :" + ","
				+ administrateur.getPassword() + "<br/>" + "" + "</span></td></tr></table><p/>";

		emailBody += "</td></tr></p>";

		generateMailMessage.setContent(emailBody, "text/html");

		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "reservation.hotel.hotel@gmail.com", "1mathrecepteur");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	////
	public void generateAndSendAcceptEmail() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");

		getMailSession = Session.getInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(reservationCreate.getCourriel()));
		generateMailMessage.setSubject("Confirmation de R�servation");
		String emailBody;

		emailBody = "<p align='center'><img  src='http://s28.postimg.org/5zyyhav0t/logo.png' alt='' /></p>";
		emailBody += "<p align='center' style='font-size:140%;font-family:Verdana'><b>Confirmation de R�servation</b><br/><br/></p>";
		emailBody += "<p><b>Monsieur/Madame / Mademoiselle,</b></p>";
		emailBody += "<p>Merci d�avoir choisi <b>Royal Tulip Skikda H�tel - Alg�rie</b</b><hr/></p>";

		emailBody += "<p><br>Nous sommes heureux de comfirmer votre r�servation avec les d�tails suivants:</br><p/>";

		emailBody += "<p><table style='border=1;'><tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; Nom de client�: &nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Mrs/</span></td></tr>" ;
				

		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Num�ro de confirmation�:</span></td>" + "	<td><span>"
				+"&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;"+ reservationCreate.getIdReservation() + "</span><td/></tr>";

		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Num�ro de confirmation�:</span></td>" + "	<td><span>"
				+"&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;"+reservationCreate.getIdReservation() + "</span><td/></tr>";
		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Date d�arriv�e�:</span></td>" + "	<td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;" + reservationCreate.getDateAriv()
				+ "</span><td/></tr>";
		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Nombre de nuit�es�:</span></td>" + "	<td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;" + reservationCreate.getNuite()
				+ "</span><td/></tr>";
		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Les d�tails du vol:</span></td>" + "	<td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;" + "N/D" + "</span><td/></tr>";
		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Nombre d�adulte:</span></td>" + "	<td><span>"
				+ reservationCreate.getNbAdulteParcChambre() + "</span><td/></tr>";
		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Nombre D�enfant :</span></td>" + "	<td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;" + reservationCreate.getNbEnfant()
				+ "</span><td/></tr>";

		emailBody += "<tr><td><span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;Type de chambre:</span></td><td>";
		for (int i = 0; i < hotelModif.getChambres().size(); i++) {
			if (hotelModif.getChambres().get(i).getNbChClient() > 0) {
				emailBody += "<span>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;" + hotelModif.getChambres().get(i).getNomChambre() + "</span>";
			}
		}
		emailBody += "</td></tr></table><br/><br/><hr/></p>";

		emailBody += "<p style='color:black;font-size:90%; font-family:Verdana'><b>Politique de Check-In et Check-Out</b><br/>Veuillez noter que le Check-in est � partir de 14h00. Toute arriv�e anticip�e avant <b>09h00 doivent �tre r�serv�s<br/> � partir de la journ�e pr�c�dente.</b></p>";
		emailBody += "<p style='color:black;font-size:90%; font-family:Verdana'><b>L�Heure de d�part est � 12h00.</b> D�parts entre <b>12h00</b> et <b>18h00</b> seront factur�s � <b>50%</b> du tarif de la chambre.<br/><b>Apr�s 18h00, charge compl�te</b> sera applicable.<hr/></p>";

		emailBody += "<p style='color:black;font-size:90%; font-family:Verdana'><b>Annulation &amp; non-pr�sentation</b><br/>Dans le cas o� vous �tes incapable de garder votre r�servation, vous devez l�annuler avant <b>16h00 - Un (1) jour<br/>avant la date d&#39;arriv�e</b> pour �viter la p�nalit� d&#39;une nuit selon le tarif mentionn� ci-dessus.<br/></p>";
		emailBody += "<p style='color:black;font-size:90%; font-family:Verdana'>En cas de No Show, une (1) <b>nuit sera factur�e</b> selon le tarif mentionn� ci-dessus.<br/>avant la date d&#39;arriv�e pour �viter la p�nalit� d&#39;une nuit selon le tarif mentionn� ci-dessus.<br/></p>";

		emailBody += "<p style='color:black;font-size:90%; font-family:Verdana'>Si vous avez besoin d�aide suppl�mentaire concernant votre r�servation n�h�sitez � contacter notre service de<br/>r�servation par e-mail ou par t�l�phone.<br/></p>";

		emailBody += "<p font-size:100%>R�servation D�partement<br/>Ligne Directe: +213 (0) 38 723 030<br/>Fax: +213 (0) 38 723�004<br/>Email: reservation@royaltulipserenada.com<br/><br/><br/></p>";
		emailBody += "<p font-size:100%>Cordialement,<br/>Sarah MANAA<br/>Agent de R�servation</p><br/><br/><br/>";
		emailBody += "<p align='center'><img  src='http://s29.postimg.org/alwmrpx87/logo2.png' alt='' /></p>";
		emailBody += "<p align='center'><img  src='http://s28.postimg.org/5zyyhav0t/logo.png' alt='' /></p>";

		generateMailMessage.setContent(emailBody, "text/html");

		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "reservation.hotel.hotel@gmail.com", "1mathrecepteur");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
	////

	public void generateAndSendAcceptEmailPourAdmin() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");

		getMailSession = Session.getInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ines.farhat@esprit.tn"));
		generateMailMessage.setSubject("R�servation sans carte de cr�dit");
		String emailBody = "<p style='color:blue;font-size:200%;'><br>R�servation N�"
				+ reservationCreate.getIdReservation() + " </br><p/>";
		emailBody += "<p ><table><tr><td><span style='color:red;font-size:150%;'>BONJOUR, &nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td><span style='color:black;font-size:150%;'>R�servation sans carte de cr�dit</span><br/>"
				+ "<span style='color:black;font-size:150%;'></span></td></tr><p/>";

		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>R�SERVATION&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>N� de confirmation de r�servation"
				+ reservationCreate.getIdReservation() + "</span><td/></tr><p/>";

		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>S�JOUR CLIENT &nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + ","
				+ reservationCreate.getPrenom() + "<br/>" + reservationCreate.getCourriel()
				+ "</span></td></tr></table><p/>";
		emailBody += "<p style='color:blue;font-size:200%;'>R�servation de Chambre<p/>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>S�JOUR CLIENT&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>Arriv�e:" + reservationCreate.getDateAriv()
				+ "<br/>Nombre de nuit�es:" + reservationCreate.getNuite() + "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>R�SERV�E POUR &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + " ,"
				+ reservationCreate.getPrenom() + "</span>  &nbsp; &nbsp; &nbsp;"
				+ "<span style='color:black;font-size:150%;'>Personnes:(Adultes:"
				+ reservationCreate.getNbAdulteParcChambre() + ", Enfants:" + reservationCreate.getNbEnfant() + ")"
				+ "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>CHAMBRES</span></td><td>";
		for (int i = 0; i < hotelModif.getChambres().size(); i++) {
			if (hotelModif.getChambres().get(i).getNbChClient() > 0) {
				emailBody += "<span style='color:black;font-size:150%;'>"
						+ hotelModif.getChambres().get(i).getNomChambre() + "</span>";
			}
		}
		emailBody += "</td></tr></p>";

		generateMailMessage.setContent(emailBody, "text/html");

		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "reservation.hotel.hotel@gmail.com", "1mathrecepteur");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	////
	public void generateAndSendAcceptEmailAvecCarte() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");

		getMailSession = Session.getInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(reservationCreate.getCourriel()));
		generateMailMessage.setSubject("Confirmation de votre réservation");
		String emailBody = "<p style='color:blue;font-size:200%;'><br>Nous sommes heureux de vous accueillir à notre Hotel</br><p/>";
		emailBody += "&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;<p ><table><tr><td><span style='color:red;font-size:150%;'>BONJOUR, &nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td><span style='color:black;font-size:150%;'>Nous sommes heureux de votre int�r�t pour le </span><br/>"
				+ "<span style='color:black;font-size:150%;'>Nous confirmons volontiers votre r�servation avec les d�tails suivants:</span></td></tr><p/>";

		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>VOTRE R�SERVATION&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>N� de confirmation de votre r�servation:"
				+ reservationCreate.getIdReservation() + "</span><td/></tr><p/>";

		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>PAIEIMENT&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>Par carte de cr�dit</span><td/></tr>"
				+ "<tr><td><span style='color:black;font-size:150%;'>Nom</span></td><td><span style='color:black;font-size:150%;'>"
				+ reservationCreate.getNomReservation() + "</span></td></tr>" + "<tr><td>Nr de carte de cr�dit</td><td>"
				+ reservationCreate.getNumCarteDeCredit() + "</td></tr>" + "<tr><td>Date de validation</td><td>"
				+ reservationCreate.getDateValidation() + "</td></tr><p/>";

		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>VOTRE S�JOUR &nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + ","
				+ reservationCreate.getPrenom() + "<br/>" + reservationCreate.getCourriel()
				+ "</span></td></tr></table><p/>";
		emailBody += "<p style='color:blue;font-size:200%;'>R�servation de Chambre<p/>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>VOTRE S�JOUR&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>Arriv�e:" + reservationCreate.getDateAriv()
				+ "<br/>D�part:" + reservationCreate.getDateRet() + "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>R�SERV�E POUR &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + " ,"
				+ reservationCreate.getPrenom() + "</span>  &nbsp; &nbsp; &nbsp;"
				+ "<span style='color:black;font-size:150%;'>Personnes:(Adultes:"
				+ reservationCreate.getNbAdulteParcChambre() + ", Enfants:" + reservationCreate.getNbEnfant() + ")"
				+ "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>VOTRE CHAMBRE</span></td><td>";
		for (int i = 0; i < hotelModif.getChambres().size(); i++) {
			if (hotelModif.getChambres().get(i).getNbChClient() > 0) {
				emailBody += "<span style='color:black;font-size:150%;'>"
						+ hotelModif.getChambres().get(i).getNomChambre() + "</span>";
			}
		}
		emailBody += "</td></tr></p>";

		generateMailMessage.setContent(emailBody, "text/html");

		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "reservation.hotel.hotel@gmail.com", "1mathrecepteur");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	////
	public void generateAndSendAcceptEmailPourAdminAvecCarte() throws AddressException, MessagingException {

		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");

		getMailSession = Session.getInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO,
				new InternetAddress(reservationCreate.getCourriel()));
		generateMailMessage.setSubject("R�servation avec carte de cr�dit");
		String emailBody = "<p style='color:blue;font-size:200%;'><br>R�servation N�"
				+ reservationCreate.getIdReservation() + " </br><p/>";
		emailBody += "<p ><table><tr><td><span style='color:red;font-size:150%;'>BONJOUR, &nbsp;&nbsp;&nbsp;</span></td>"
				+ "<td><span style='color:black;font-size:150%;'>R�servation sans carte de cr�dit</span><br/>"
				+ "<span style='color:black;font-size:150%;'></span></td></tr><p/>";

		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>R�SERVATION&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>N� de confirmation de r�servation"
				+ reservationCreate.getIdReservation() + "</span><td/></tr><p/>";
		emailBody += "<p ><tr><td><span style='color:red;font-size:150%;'>PAIEIMENT&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>Par carte de cr�dit</span><td/></tr>"
				+ "<tr><td><span style='color:black;font-size:150%;'>Nom</span></td><td><span style='color:black;font-size:150%;'>"
				+ reservationCreate.getNomReservation() + "</span></td></tr>" + "<tr><td>Nr de carte de cr�dit</td><td>"
				+ reservationCreate.getNumCarteDeCredit() + "</td></tr>" + "<tr><td>Date de validation</td><td>"
				+ reservationCreate.getDateValidation() + "</td></tr><p/>";

		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>S�JOUR CLIENT &nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + ","
				+ reservationCreate.getPrenom() + "<br/>" + reservationCreate.getCourriel()
				+ "</span></td></tr></table><p/>";
		emailBody += "<p style='color:blue;font-size:200%;'>R�servation de Chambre<p/>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>S�JOUR CLIENT&nbsp;&nbsp;&nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>Arriv�e:" + reservationCreate.getDateAriv()
				+ "<br/>D�part:" + reservationCreate.getDateRet() + "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>R�SERV�E POUR &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;</span></td>"
				+ "	<td><span style='color:black;font-size:150%;'>" + reservationCreate.getNom() + " ,"
				+ reservationCreate.getPrenom() + "</span>  &nbsp; &nbsp; &nbsp;"
				+ "<span style='color:black;font-size:150%;'>Personnes:(Adultes:"
				+ reservationCreate.getNbAdulteParcChambre() + ", Enfants:" + reservationCreate.getNbEnfant() + ")"
				+ "</span></td></tr>";
		emailBody += "<p><tr><td><span style='color:red;font-size:150%;'>CHAMBRES</span></td><td>";
		for (int i = 0; i < hotelModif.getChambres().size(); i++) {
			if (hotelModif.getChambres().get(i).getNbChClient() > 0) {
				emailBody += "<span style='color:black;font-size:150%;'>"
						+ hotelModif.getChambres().get(i).getNomChambre() + "</span>";
			}
		}
		emailBody += "</td></tr></p>";

		generateMailMessage.setContent(emailBody, "text/html");

		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "reservation.hotel.hotel@gmail.com", "1mathrecepteur");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	public int getNumeroReservation() {
		return numeroReservation;
	}

	public void setNumeroReservation(int numeroReservation) {
		this.numeroReservation = numeroReservation;
	}

	public int getNumR() {
		return numR;
	}

	public void setNumR(int numR) {
		this.numR = numR;
	}

	/**
	 * @return the num
	 */

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
