package vista.correo;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreoSolicitudConfirmacion implements Runnable{
	private Properties props;
	private Session session;
	private String para;
	private int num;
	
	public EnviarCorreoSolicitudConfirmacion(String para,int num) {
		this.para=para;
		this.num=(String.valueOf(num)+para).hashCode();
		props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user", "cursillos2002@gmail.com");
	    props.put("mail.smtp.clave", decodif("%pssfQ3tjN$"));
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587");
	    
	    session = Session.getDefaultInstance(props);
	    Thread hilo=new Thread(this);
		hilo.start();
       
	    
	}

	@Override
	public void run() {
		 try {
			 	String web="<head>"+
			 			"<style type=\"text/css\">" +
		                "  .campo { display: none; }" +
		                "</style>" +
			 			"</head>"+
			 			"<body>"+
			 				"<p>Pulse en el enlace para confirmar su correo</p>"+
			 				"<a href=\"http://localhost:8080/WebGestionDistribucio/Confirmacion?num="+num+"\" >Confirmar</a>"+
				 				
				 		"</body>";
	            MimeMessage mensaje = new MimeMessage(session);
	            mensaje.setFrom(new InternetAddress("cursillos2002@gmail.com"));
	            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
	            mensaje.setSubject("Confirme su correo");
	            mensaje.setContent(web,"text/html; charset=utf-8");
	            Transport t = session.getTransport("smtp");
	            t.connect("cursillos2002@gmail.com", "#Mis2Perro$");
	            t.sendMessage(mensaje, mensaje.getAllRecipients());
	            t.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static String decodif(String cadena) {
		String deco="";
		for (int i=cadena.length()-1;i>=0;i--)
			deco=deco.concat(Character.toString((char)(int)(cadena.charAt(i)-1)));
		return deco;
	}
}
