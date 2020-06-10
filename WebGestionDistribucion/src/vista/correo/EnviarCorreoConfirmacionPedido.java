package vista.correo;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import entidades.FilasPedidosCliente;
import entidades.PedidoCliente;
/**
 * Correo al cliente con la confirmación del pedido
 * @author Jose Carlos
 *
 */
public class EnviarCorreoConfirmacionPedido implements Runnable{
	private Properties props;
	private Session session;
	private String para;
	private PedidoCliente ped;
	private NumberFormat formatoEuro = NumberFormat.getCurrencyInstance();
	private DateFormat formatoFecha;
	/**
	 * El constructor recibe un objeto PedidoCliente
	 * @param ped objeto PedidoCliente
	 */
	public EnviarCorreoConfirmacionPedido(PedidoCliente ped) {
		formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		this.para=ped.getClienteBean().getEmail();
		this.ped=ped;
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
	/**
	 * Hilo que envia el correo
	 */
	@Override
	public void run() {
		String web="<head>"+
	 			"<style type=\"text/css\">" +
                "table{"+ 
                "	width:50%;"
                + "border-collapse: collapse;"
                + "border:solid;"+ 
                "	border-spacing: 10px 20px;" + 
                "	margin:auto;" + 
                "	box-shadow: 2px 2px 7px  #2A3F55;" + 
                "	background: -webkit-linear-gradient(top, #cceeff 0%,#ffffff 100%);" + 
                "}"
                + ".der{text-align: right;}"+
                

                "</style>" +
	 			"</head>"+
	 			"<body><h1>GESTIÓN DISTRIBUCIÓN</h1>"+
	 			"<h1>Pedido número "+ped.getNum()+" fecha "+formatoFecha.format(ped.getFecha())+" para "+ped.getClienteBean().getNombre()+"</h1>"
	 			+ "<table id='pedido'>" + 
	 			"		<tr><th>Código</th><th>Descripción</th><th class='der'>Cantidad</th><th class='der'>Precio</th><th class='der'>Total</th></tr>\r\n";
	 			
		List<FilasPedidosCliente> filas=ped.getFilasPedidosClientes();
		double base=0;
		for (FilasPedidosCliente fila:filas) {
			web+="<tr><td>"+fila.getArticuloBean().getCod()+"</td>"
					+ "<td>"+fila.getArticuloBean().getNombre()+"</td>"
					+ "<td class='der'>"+fila.getCantidad()+"</td>"
					+ "<td class='der'>"+formatoEuro.format(fila.getPrecio())+" €</td>"
					+ "<td class='der'>"+formatoEuro.format(fila.getCantidad()*fila.getPrecio())+"</td></tr>"
							+ "";
			base+=fila.getCantidad()*fila.getPrecio();
		}
		web+="<tr><td colspan='3'></td><td class='der'>Base</td><td class='der'>"+formatoEuro.format(base)+"</td></tr>"
				+ "<tr><td colspan='3'></td><td class='der'>IVA</td><td class='der'>"+formatoEuro.format(base*0.1)+"</td></tr>"
				+ "<tr><td colspan='3'></td><td class='der'>Total</td><td class='der'>"+formatoEuro.format(base*1.1)+"</td></tr>"
				+ "</table><h2>En breve recibirá su pedido junto con su albarán y factura.</h2><h2>Un saludo</h2></body>";
		try {
			 
	            MimeMessage mensaje = new MimeMessage(session);
	            mensaje.setFrom(new InternetAddress("cursillos2002@gmail.com"));
	            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));
	            mensaje.setSubject("Confirmación del pedido número "+ped.getNum());
	            mensaje.setContent(web,"text/html; charset=utf-8");
	            Transport t = session.getTransport("smtp");
	            t.connect("cursillos2002@gmail.com", decodif("%pssfQ3tjN$"));
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
