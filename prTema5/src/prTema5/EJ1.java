package prTema5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class EJ1 {
	public static void main(String [] args){
		/*List<Integer> list= new ArrayList<>();
		
		for(int i=0; i<10; i++){
			list.add(i);
		}
		System.out.println(list);
		System.out.println(inmutable(list));*/
	}
	
	List<String> ls = Arrays.asList("Hola", "que", "ta");
	System.out.println(ls);
	estrella(ls);
	System.out.println();
	
	public static void mutable(List<Integer> lista){
		ListIterator<Integer> li = lista.listIterator();
		
		while(li.hasNext()){
			int e=li.next();
			li.set(e*e+1);
		}
		Iterator<Integer> it = lista.iterator();
		
		while(it.hasNext()){
			int n=it.next();
			
			if(n%5==0){
				it.remove();
			}
		}
	}
	
	public static List<Integer> inmutable(List<Integer> lista){
		List<Integer> ecm1 = new ArrayList<>();
		
		for(int i: lista){
			ecm1.add(i*i+1);
		}
		
		List <Integer> nm5 = new ArrayList<>();
		
		for(int i:ecm1){
			if(i%5!=0){
				nm5.add(i);
			}
		}
		return nm5;
	}
	
	public static void estrella(List<String> lista){
		int i=0;
		/*
		while(i<lista.size()){
			if(lista.get(i).length()==4){
				lista.add(i+1, "****");
				i++;
			}
		i++;
		*/
		
		ListIterator<String> is = lista.listIterator();
		
		while(is.hasNext()){
			if(is.next().length()==4){
				is.add("****");
			}
		}
	}
	
	public static List<String> estrella(List<String> lista){
		List<String> sol = new ArrayList<>();
		
		for(String s : lista){
			sol.add(s);
			if(s.length())
		}
	}
	
	
}
