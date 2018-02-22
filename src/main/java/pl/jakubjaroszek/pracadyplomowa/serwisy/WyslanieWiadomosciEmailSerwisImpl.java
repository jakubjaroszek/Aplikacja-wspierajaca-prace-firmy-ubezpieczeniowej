package pl.jakubjaroszek.pracadyplomowa.serwisy;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import pl.jakubjaroszek.pracadyplomowa.model.WiadomoscEmail;

@Service
public class WyslanieWiadomosciEmailSerwisImpl implements WyslanieWiadomosciEmailSerwis {

	protected String uwierzytelnieniePoczty = "true";
	protected String hostPoczty = "smtp.gmail.com";
	protected String portPoczty = "587";
	protected String protokolTlsPoczty = "true";
	protected String adresEmailPoczty = "insurancegrouppl@gmail.com";
	protected String hasloPoczty = "uczelnia";

	public boolean wyslijWiadomoscEmail(WiadomoscEmail wiadomoscEmail) {
		Properties wlasciwosci = new Properties();
		wlasciwosci.put("mail.smtp.auth", uwierzytelnieniePoczty);
		wlasciwosci.put("mail.smtp.starttls.enable", protokolTlsPoczty);
		wlasciwosci.put("mail.smtp.host", hostPoczty);
		wlasciwosci.put("mail.smtp.port", portPoczty);
		wlasciwosci.put("mail.smtp.ssl.trust", hostPoczty);

		Session sesja = Session.getInstance(wlasciwosci, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(adresEmailPoczty, hasloPoczty);
			}
		});

		try {
			Message wiadomosc = new MimeMessage(sesja);
			wiadomosc.setFrom(new InternetAddress(wiadomoscEmail.getNadawca()));
			wiadomosc.setRecipients(Message.RecipientType.TO, InternetAddress.parse(wiadomoscEmail.getOdbiorca()));
			wiadomosc.setSubject(wiadomoscEmail.getTemat());
			wiadomosc.setText("" + wiadomoscEmail.getPoczatekWiadomosci() + wiadomoscEmail.getAdresResetujacyHaslo()
					+ wiadomoscEmail.getKoniecWiadomosci());

			Transport.send(wiadomosc);
			return true;
		} catch (MessagingException wyjatek) {
			wyjatek.printStackTrace();
			return false;
		}
	}
}
