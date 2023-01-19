import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Creando arrayList de objetos de la clase User
        ArrayList<User> arrayUsers = new ArrayList<User>();
        while(true){
            Scanner lectura = new Scanner(System.in);
            System.out.println("####------Menú inicial historial de clientes-----### ");
            System.out.println("1. Añadir nuevo cliente.");
            System.out.println("2. Borrar un cliente.");
            System.out.println("3. Buscar un cliente.");
            System.out.println("4. Mostrar los clientes.");
            System.out.println("5. Salir.\n");
            //Menú inicial
            int opcion = inputValidNumber("Seleccione por favor una de las opciones:");
            System.out.println("Has seleccionado la opción " + opcion);
            switch (opcion){
                case 1:
                    String name = inputValidString("Ingrese por favor el nombre del cliente: ");
                    int cedula = inputValidNumber("Ingrese por favor la cédula del ciente: ");
                    User user = new User(name, cedula);
                    arrayUsers.add(user);
                    System.out.println("El usuario con nombre " + name + " y con cédula: " + cedula + " fue ingresado exitosamente al sistema");
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Esta opción no se encuentra dentro de las disponibles, saliendo del programa");
            }
            break;
        }

    }
    //Funciones de uso
    public static int inputValidNumber(String mensaje){
        Scanner s = new Scanner(System.in);
        int numero;
        while (true) {
            System.out.println(mensaje);
            if (s.hasNextInt()) {
                numero = s.nextInt();
                return numero;
            } else {
                System.out.println ("Ingrese un tipo de dato válido (sólo números).");
                s.next();
            }
        }
    }

    public static String inputValidString(String mensaje) {
        Scanner s = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[A-Za-z]*");
        String string;
        while (true) {
            System.out.println(mensaje);
            if (s.hasNext(pattern)) {
                string = s.next();
                return string;
            } else {
                System.out.println("¡ERROR, ESTÁ INGRESANDO CARACTERES QUE NO PERTENECEN AL ALFABETO");
                s.next();
            }
        }
    }
    private static <T> T[] append(T[] arr, T element)
    {
        T[] array = Arrays.copyOf(arr, arr.length + 1);
        array[arr.length] = element;
        return array;
    }

}