package EJERCICIO1;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		
		Empleado e1 = new Empleado();
        e1.setPuesto("Administrativo");

        Empleado e2 = new Empleado("12345678", "Juan", "Perez", LocalDate.of(1990, 5, 10), "Masculino",
                                    "Calle 123", "123456789", "juan@mail.com", "Gerente");
        
        Empleado e3 = new Empleado();
        e3.setPuesto("Cajero");

        Empleado e4 = new Empleado("87654321", "Ana", "Lopez", LocalDate.of(1985, 3, 20), "Femenino",
                                    "Calle Falsa 456", "987654321", "ana@mail.com", "Vendedora");

        Empleado e5 = new Empleado("11223344", "Carlos", "Gomez", LocalDate.of(2000, 12, 1), "Masculino",
                                    "San Martin 789", "555555555", "carlos@mail.com", "Supervisor");
        
        // Mostrar empleados
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);
        System.out.println(e5);

        // Mostrar próximo legajo
        System.out.println("El próximo legajo será el " + Empleado.devuelveProximoLegajo());

	}

}
