import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person_registration {


    private final String nombre;
    private final String identificacion;
    private final int edad;
    private final String correo;
    private final String telefono;
    private final LocalDateTime fechaRegistro;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    public Person_registration(String nombre, String identificacion, int edad, String correo, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaRegistro = LocalDateTime.now();
    }

    // =Convierte la información a línea para archivo
     public String toLine() {
        return String.join("|",
                identificacion,
                nombre,
                String.valueOf(edad),
                correo,
                telefono,
                fechaRegistro.format(FORMATO)
        );
    }

    // Muestra los datos 
    @Override
    public String toString() {
        return "\n Registro Exitoso\n" +
                "Nombre: " + nombre + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Edad: " + edad + "\n" +
                "Correo: " + correo + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Fecha de registro: " + fechaRegistro.format(FORMATO);
    }

    //Guarda el registro en archivo 
    public void guardarEnArchivo() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("personas.txt", true))) {
            bw.write(this.toLine());
            bw.newLine();
        }
    }

    
    public static String leerTexto(Scanner sc, String prompt) {
        String texto;
        do {
            System.out.print(prompt);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("⚠️ No puede estar vacío. Intente nuevamente.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static int leerEnteroPositivo(Scanner sc, String prompt) {
        int valor = -1;
        do {
            System.out.print(prompt);
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                if (valor <= 0) {
                    System.out.println("⚠️ Debe ingresar un número positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número entero.");
            }
        } while (valor <= 0);
        return valor;
    }

    public static String leerEmail(Scanner sc, String prompt) {
        String correo;
        do {
            System.out.print(prompt);
            correo = sc.nextLine().trim();
            if (!correo.contains("@")) {
                System.out.println("⚠️ Correo inválido. Debe contener '@'.");
                correo = "";
            }
        } while (correo.isEmpty());
        return correo;
    }

    public static String leerTelefono(Scanner sc, String prompt) {
        String tel;
        do {
            System.out.print(prompt);
            tel = sc.nextLine().trim();
            if (!tel.matches("\\d{8,}")) {
                System.out.println("⚠️ Teléfono inválido. Solo dígitos y al menos 8 números.");
                tel = "";
            }
        } while (tel.isEmpty());
        return tel;
    }
}
