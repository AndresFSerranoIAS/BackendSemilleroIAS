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
            System.out.println("####------Menú principal de clientes-----### ");
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
                    boolean swAdd;
                    swAdd = true;
                    while(swAdd) {
                        String name = inputValidString("Ingrese por favor el nombre del cliente: ");
                        int cedula = inputValidNumber("Ingrese por favor la cédula del cliente: ");
                        User user = new User(name, cedula);
                        if (!arrayUsers.isEmpty()) {
                            for (User element : arrayUsers) {
                                if (element != null) {
                                    String nameUser = element.getName();
                                    int cedulaUser = element.getCedula();
                                    if (cedulaUser == cedula) {
                                        System.out.println("Este cliente ya está registrado en la base de datos, volviendo al menú principal");
                                        swAdd = false;
                                        break;
                                    } else if (cedulaUser != cedula) {
                                        arrayUsers.add(user);
                                        System.out.println("El usuario con nombre " + name + " y con cédula: " + cedula + " fue ingresado exitosamente al sistema");
                                        swAdd = false;
                                        break;
                                    }
                                } else {
                                    swAdd = false;
                                    break;
                                }
                            }
                        }else{
                            arrayUsers.add(user);
                            System.out.println("El usuario con nombre " + name + " y con cédula: " + cedula + " fue ingresado exitosamente al sistema");
                            swAdd= false;
                        }
                    }
                    break;

                case 2:
                        if(!arrayUsers.isEmpty()) {
                            int inputCedula = inputValidNumber("Ingrese por favor la cédula del cliente: ");
                            if (arrayUsers.removeIf(element -> element.getCedula() == inputCedula)) {
                                System.out.println("El cliente fue eliminado satisfactoriamente de la base de datos.");
                                break;
                            } else {
                                System.out.println("Por favor ingrese una cédula que se encuentre en la base de datos");
                            }
                        }else{
                            System.out.println("La base de datos se encuentra vacía, no se puede buscar ningún cliente por favor ingrese al menos uno");
                            break;
                        }
                case 3:
                    boolean swSearch = false;
                    if (!arrayUsers.isEmpty()){
                        int inputCedula = inputValidNumber("Ingrese por favor la cédula del cliente: ");
                        for(User element: arrayUsers){
                            if(inputCedula==element.getCedula()){
                                System.out.println("El cliente que busca está en la posición " + (arrayUsers.indexOf(element)) + ", El cliente se llama "+ element.getName() + " y su cédula es "+ element.getCedula());
                                swSearch = true;
                            }
                        }
                        if(!swSearch){
                            System.out.println("No se encontró ningún elemento en la base de datos con esa cédula");
                        }
                    }else{
                        System.out.println("La base de datos se encuentra vacía, no se puede buscar ningún cliente por favor ingrese al menos uno");
                    }
                    break;
                case 4:
                    if (!arrayUsers.isEmpty()) {
                        for (User user : arrayUsers) {
                            System.out.println("** Cliente número "+ (arrayUsers.indexOf(user)+1) +": El cliente se llama " + user.getName() + " y su cédula es " + user.getCedula()+ " **");
                        }
                    }else{
                        System.out.println("La base de datos está vacía no se puede desplegar ningún elemento");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Esta opción no se encuentra dentro de las disponibles, saliendo del programa");
            }
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