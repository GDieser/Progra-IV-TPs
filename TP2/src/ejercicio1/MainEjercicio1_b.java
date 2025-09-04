package ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainEjercicio1_b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Persona> empleados = new ArrayList<>();

        empleados.add(new Empleado("12345678", "Jorge", "Pérez",
                LocalDate.of(1990, 5, 12), "Masculino", "Av. Siempre Viva 123",
                "3624001111", "jorge.perez@mail.com", "Analista"));

        empleados.add(new Empleado("23456789", "María", "Gómez",
                LocalDate.of(1985, 8, 3), "Femenino", "Calle San Martín 456",
                "3624002222", "maria.gomez@mail.com", "Gerente"));

        empleados.add(new Empleado("34567890", "Carlos", "López",
                LocalDate.of(1995, 1, 25), "Masculino", "Mitre 789",
                "3624003333", "carlos.lopez@mail.com", "Programador"));

        empleados.add(new Empleado("45678901", "Ana", "Fernández",
                LocalDate.of(1992, 12, 15), "Femenino", "Belgrano 147",
                "3624004444", "ana.fernandez@mail.com", "Diseñadora"));

        empleados.add(new Empleado("56789012", "Lucía", "Martínez",
                LocalDate.of(1988, 7, 20), "Femenino", "Rivadavia 258",
                "3624005555", "lucia.martinez@mail.com", "Administrativa"));

        Iterator<Persona> it = empleados.iterator();
        
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
