package prSept17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class RedSocial {
	private Map<String, Cuenta> red;
	private String usuarioActivo;
	
	public RedSocial(){
		red = new TreeMap<>();
		this.usuarioActivo=null;
		crearCuenta("admin");
	}
	
	public void login(String usr){
		if(!red.containsKey(usr)){
			throw new AppException("Usuario no registrado");
		}else{
			this.usuarioActivo=usr;
		}
	}
	
	public void logout(){
		usuarioActivo=null;
	}
	
	public void crearCuenta(String usr){
		if(usr.equals("ADMIN")||red.containsKey(usr)){
			throw new AppException("Cuenta ya existente");
		}else{
			Cuenta c = new Cuenta(usr);
			red.put(usr, c);
		}
	}
	
	public void addMsj(String receptor, String txt){
		Cuenta c = red.get(usuarioActivo);
		c.addMsj(receptor, txt);
	}
	
	public SortedSet<Mensaje> getMsjsCon(String usuario){
		if(!red.containsKey(usuario)){
			throw new AppException("Usuario no existente");
		}else{
			Cuenta c = red.get(usuarioActivo);
			SortedSet<Mensaje> mensajes = new TreeSet<>();
			SortedSet<Mensaje> total = c.getMsj(null);
			
			for(Mensaje m : total){
				if(m.getReceptor().equals(usuario)){
					mensajes.add(m);
				}
			}
			return mensajes;
		}
	}
	
	public SortedSet<Mensaje> getMsjsClaves(Set<String> c){
		SortedSet<Mensaje> nuevo = new TreeSet<>();
		Cuenta c1 = red.get(usuarioActivo);
		
		for(Mensaje s : c1.getMsj(null)){
			if(c.contains(s)){
				nuevo.add(s);
			}
		}
		return nuevo;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(String s : red.keySet()){
			for(Cuenta c : red.get(s)) {
				
			}
		}
		return sb.toString();
	}
	
	public void crearCuentaModerada(String usr, Set<String> c){
		if(usr.equals("ADMIN")||red.containsKey(usr)){
			throw new AppException("Cuenta ya existente");
		}else{
			CuentaModerada cm = new CuentaModerada(usr, c);
			red.put(usr, cm);
		}
	}
	
	public void cargarDeFichero(String n){
		try(Scanner sc = new Scanner(new File(n))){
			sc.useDelimiter(" *[;] *");
			
			while(sc.hasNextLine()){
				try(Scanner scLinea = new Scanner(sc.nextLine())){
					String nombre = scLinea.next();
					String receptor = scLinea.next();
					String mensaje = scLinea.next();
					
					crearCuenta(nombre);
					login(nombre);
					addMsj(receptor, mensaje);
				}
			}
		} catch (FileNotFoundException e) {
			throw new AppException("Fichero no encontrado");
		}
	}
	
	public void guardarEnFichero(String n){
		try(PrintWriter pw = new PrintWriter(new File(n))){
			for(String s : red.keySet()){
				pw.print(s);
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
