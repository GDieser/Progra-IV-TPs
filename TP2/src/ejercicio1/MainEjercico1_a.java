package ejercicio1;

public class MainEjercico1_a {

	public static void main(String[] args) {

		String [] dnis = new String[2];
		dnis[0] = "AA20202020";
		dnis[1] = "20202020";

        for (String dni : dnis) {
            try {
                Persona p = new Persona();
                p.setDni(dni);
                Persona.verificarDNI(dni);
                System.out.println("Persona agregada correctamente");
            } catch (ExVerificarDNI e) {
                System.out.println("Persona no agregada por no verificar el DNI");
                e.printStackTrace();
            }
        }

	}

}
