
import java.io.OptionalDataException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Creando array de objetos de la clase User
        User arrayUsers[] = new User[4];
        arrayUsers[0] = new User("Juan", 1);
        int maxQuantity = 10;
        while (true) {
            // Declarar el objeto e inicializar con el objeto de entrada estándar predefinido
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
            if (opcion==1) {
                //Comparación de longitud de array
                if(arrayUsers.length<maxQuantity) {
                    String name = inputValidString("Ingrese por favor el nombre del cliente: ");
                    int cedula = inputValidNumber("Ingrese por favor la cédula del ciente: ");
                    User user = new User(name, cedula);
                    for (int i = 0; i < arrayUsers.length; i++) {
                        //Caso de alguna posición vacía en array
                        if (arrayUsers[i] == null) {
                            arrayUsers[i] = user;
                            System.out.println("El usuario con nombre " + name + " y con cédula: " + cedula + " fue ingresado exitosamente al sistema");
                            break;
                        } else if (arrayUsers[arrayUsers.length-1]!=null) {
                            arrayUsers = append(arrayUsers,user);
                            break;
                        }
                    }
                }else{
                    System.out.println("Debe borrar un cliente antes de poder ingresar uno nuevo, alcanzó la cantidad máxima \n");
                }

            } else if (opcion==2) {
                //Petición de documento a cliente
                boolean sw;
                sw = true;
                while(sw) {
                    int inputCedula = inputValidNumber("Ingrese por favor la cédula:");
                    for (int i = 0; i < arrayUsers.length; i++) {
                        if (arrayUsers[i]!=null) {
                            if (arrayUsers[i].getCedula()==inputCedula) {
                                int cedulaUser = arrayUsers[i].getCedula();
                                String nombreUser = arrayUsers[i].getName();
                                System.out.println("Se eliminó el usuario" + " con nombre " + nombreUser + "y con cédula " + cedulaUser);
                                int cantidad = arrayUsers.length-1;
                                User arrayNew[] = new User[cantidad];
                                // copy elements from original array from beginning till index into copyArray
                                System.arraycopy(arrayUsers, 0, arrayNew, 0, i);

                                // copy elements from original array from index+1 till end into copyArray
                                System.arraycopy(arrayUsers, i+1, arrayNew, i, cantidad-i);
                                arrayUsers=arrayNew;
                                sw = false;
                                break;
                            }
                        } else {
                            System.out.println("Ingresó una cédula que no se encuentra en la base de datos, por favor ingrese una válida");
                            break;
                        }
                    }
                }
            } else if (opcion==3) {
                System.out.println("Buscando cliente");
                int inputCedulaSearch = inputValidNumber("Ingrese por favor la cédula:");
                for(int i=0;i<arrayUsers.length;i++){
                    if (arrayUsers[i]!=null) {
                        if (inputCedulaSearch == arrayUsers[i].getCedula()) {
                            System.out.println("El cliente que busca está en la posición " + i + " y el cliente se llama " + arrayUsers[i].getName() + " con cédula " + arrayUsers[i].getCedula());
                            break;
                        } else {
                            System.out.println("El cliente que intenta buscar no se encuentra en la base de datos.");
                        }
                    }
                }
            } else if (opcion==4){
                System.out.println("Mostrando los clientes");
                if (arrayUsers.length<4){
                        switch (arrayUsers.length){

                            case 0:{
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                break;
                            }
                            case 1:{
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                break;
                            }
                            case 2:{
                                arrayUsers = append(arrayUsers,null);
                                arrayUsers = append(arrayUsers,null);
                                break;
                            }
                            case 3:{
                                arrayUsers = append(arrayUsers,null);
                                break;
                            }
                            default:
                        }
                    }
                for (int k = 0; k < arrayUsers.length; k++) {
                    if (arrayUsers[k]!=null) {
                        System.out.println("Cliente número " + (k + 1) + ": El cliente se llama " + arrayUsers[k].getName() + " y su cédula es " + arrayUsers[k].getCedula() + ".");
                    } else if (arrayUsers[k]==null) {
                        System.out.println("Cliente con posición vacia");
                    }
                }
            } else if (opcion==5) {
                System.out.println("Saliendo del programa");
                break;
            }else{
                System.out.println("Opción inválida, saliendo del programa");
                break;
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