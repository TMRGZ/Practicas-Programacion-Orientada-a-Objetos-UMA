package prParking;
import java.io.FileNotFoundException;
import java.util.*;


public class TestParking {

	public static void main(String[] args) {
		
		try{
			Vehiculo v1= new Vehiculo("2145FSS",new Posicion(1,1), 10, 14);
			Vehiculo v2= new Vehiculo("2245FSS",new Posicion(3,2), 10, 14);
			Vehiculo v3= new Vehiculo("2345FSS",new Posicion(4,2), 11, 14);
			
			System.out.println(v1.toString()+'\n');
			System.out.println(v2.toString()+'\n');
			System.out.println(v3.toString()+'\n');
			
			Parking pq = new Parking("Parking_0",new Posicion(0,0),1);
			
			System.out.println(pq.toString()+'\n');
			
			int pz1 = pq.buscarPlaza(v1);
			if (pz1 >= 0) {
				System.out.println("puedo reservar para v1\n");
				pq.reservarPlaza(v1, pz1);
			}
			int pz2 = pq.buscarPlaza(v3);
			if (pz2 >= 0) {
				System.out.println("puedo reservar para v3\n");
				pq.reservarPlaza(v3, pz2);
			}
			
			System.out.println(pq.toString()+'\n');
			
			
			ServicioDeReserva sdr = new ServicioDeReserva("parkings.txt");
							
			List<Vehiculo> lv = new ArrayList<>();
			lv.add(v1);
			lv.add(v2);
			lv.add(v3);
		
			System.out.println(sdr.parkingLibreMasProximo(v1).getId()+'\n');
			System.out.println(sdr.parkingLibreMasProximo(v2).getId()+'\n');
			System.out.println(sdr.parkingLibreMasProximo(v3).getId()+'\n');
		
		
			Map<String,String> mss = sdr.reservaDePlazas(lv);
			System.out.println(mss.toString()+'\n');
		
			System.out.println(sdr);
				
	 } catch (FileNotFoundException e){
		System.out.println("No se encuentra el fichero");
	 } catch (ParkingException e){
			System.out.println(e.getMessage());
	 } 
	}

}

