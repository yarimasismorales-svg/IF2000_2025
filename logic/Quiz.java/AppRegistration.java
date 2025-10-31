
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" SISTEMA DE REGISTRO ");

        String nombre = Person_registration.leerTexto(sc, "Nombre: ");
        String id = Person_registration.leerTexto(sc, "Identificación: ");
        int edad =  Person_registration.leerEnteroPositivo(sc, "Edad: ");
        String correo = Person_registration.leerEmail(sc, "Correo: ");
        String telefono =  Person_registration.leerTelefono(sc, "Teléfono: ");

         Person_registration persona = new Person_registration (nombre, id, edad, correo, telefono);

        try {
            persona.guardarEnArchivo();
            String hora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println(persona);
            System.out.println("\n Guardado correctamente a las " + hora);
        } catch (IOException e) {
            System.out.println(" Error al guardar en el archivo.");
        }

        sc.close();
    }
}
