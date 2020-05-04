package model.negocio;

import model.Cliente;
import model.persistencia.DaoCliente;

public class GestorCliente {
	DaoCliente dc;
	
	public GestorCliente() {
		dc=new DaoCliente();
	}
	/**
	 * 
	 * @param cli Cliente
	 * @param pass1 
	 * @param pass2
	 * @return 0 Nombre blanco 1 Apellidos blanco 2 nif blanco 3 email blanco 4 direccion blanco 5 poblacion blanco 6 codpos blanco 7 pass dife 8 pass blanco 9 error conex 10 email existe 11 oktodo
	 */
	public boolean[] nuevo(Cliente cli,String pass1,String pass2) {
		boolean[] ok=new boolean[12];
		for (int i=0;i<ok.length;i++)
			ok[i]=true;
		ok[11]=false;
		int res=0;
		ok[0]=!cli.getNombre().equals("");
		ok[1]=!cli.getApellidos().equals("");
		ok[2]=!cli.getNifCif().equals("");
		ok[3]=!cli.getEmail().equals("");
		ok[4]=!cli.getDireccion().equals("");
		ok[5]=!cli.getPoblacion().equals("");
		ok[6]=!cli.getCodPost().equals("");
		System.out.println(pass1+"\t"+pass2+"\t"+!pass1.equals(pass2));
		if (!pass1.equals("") && !pass2.equals(""))
			if (!pass1.equals(pass2))
				ok[7]=false;
			else
				cli.setContrasena(pass1.hashCode());
		else 
			ok[8]=false;
		System.out.println("iguales "+ok[7]+" en blanco "+ok[8]);
		boolean todoBien=true;
		for (int i=0;i<9;i++)
			if(!ok[i])
				todoBien=false;
		if (todoBien) {
			res = dc.nuevo(cli);
			System.out.println("res "+res);
			ok[9]=res!=-1;
			ok[10]=res!=-2;
			ok[11]=res==0;
		}
		
		 return ok;
	}
	
	public boolean confirmado(int num) {
		return dc.confirmado(num);
	}
	
	public Cliente buscaEmailPassword(String email,String password) {
		return dc.buscaEmailPassword(email, password);
	}
	
	public Cliente buscaCliente(int numero) {
		return dc.buscaCliente(numero);
	}
}
