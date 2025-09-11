package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio2 {

	public static void main(String[] args) {
		ArrayList<Edificio> edificios = new ArrayList<>();

        edificios.add(new Polideportivo(1200, "Polideportivo 1", 1)); 
        edificios.add(new Polideportivo(2500, "Polideportivo 2", 2));   
        edificios.add(new Polideportivo(1800, "Polideportivo 3", 1));

        edificios.add(new EdificioDeOficinas(900, 15));
        edificios.add(new EdificioDeOficinas(1500, 30));

        Iterator<Edificio> it = edificios.iterator();
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
    }
}
