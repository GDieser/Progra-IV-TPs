package ejercicio1;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MainEjercicio1_c {

	public static void main(String[] args) {
		
		Set<Empleado> empleados = new TreeSet<>();
		
        empleados.add(new Empleado("15555666", "Juan", "Pérez", LocalDate.of(1990, 5, 10), "Masculino", "Calle 123", "35222111", "juan@mail.com", "Gerente"));
        
        empleados.add(new Empleado("15222444", "Ana", "García", LocalDate.of(1985, 8, 20), "Femenino", "Calle 456", "31444999", "ana@mail.com", "Secretaria"));
        
        empleados.add(new Empleado("15999888", "Luis", "Martínez", LocalDate.of(1992, 3, 15), "Masculino", "Calle 789", "33888777", "luis@mail.com", "Vendedor"));
        
        empleados.add(new Empleado("15444222", "María", "López", LocalDate.of(1995, 11, 5), "Femenino", "Calle 321", "39111333", "maria@mail.com", "Analista"));
        
        empleados.add(new Empleado("15151515", "Carlos", "Fernández", LocalDate.of(1988, 1, 25), "Masculino", "Calle 654", "30888777", "carlos@mail.com", "Supervisor"));

        Iterator<Empleado> it = empleados.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
		
	}

}
