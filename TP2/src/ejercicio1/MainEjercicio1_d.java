package ejercicio1;

import java.time.LocalDate;
import java.util.HashSet;

public class MainEjercicio1_d {

	public static void main(String[] args) {
		
		HashSet<Persona> personas = new HashSet<Persona>();
		
		personas.add(new Persona("22343578", "Jorge", "Helera",
                LocalDate.of(1990, 5, 12), "Masculino", "Av. General Paz 123",
                "1132424223", "jorge.helera@gmail.com"));
		personas.add(new Persona("32413231", "Juan", "Perez",
                LocalDate.of(1990, 12, 17), "Masculino", "San Martin 463",
                "1197836234", "juan.perez@gmail.com"));
		personas.add(new Persona("12352354", "Camila", "Gonzales",
                LocalDate.of(2001, 2, 9), "Femenino", "Rivadavia 873",
                "1159394843", "cami.gonzales@gmail.com"));
		personas.add(new Persona("34255323", "Maria", "Lopez",
                LocalDate.of(1978, 7, 6), "Masculino", "Belgrano 433",
                "1186656532", "maria.lopez@gmail.com"));
		personas.add(new Persona("24535325", "Pablo", "Martinez",
                LocalDate.of(1997, 5, 22), "Masculino", "Avellaneda 224",
                "1123412458", "pablo.martinez@gmail.com"));
		

	}

}
