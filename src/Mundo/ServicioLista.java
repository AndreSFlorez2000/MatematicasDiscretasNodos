package Mundo;

import java.util.Scanner;

public class ServicioLista {

    private static Estudiante cabecera;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * cabecera = null
     */
    public ServicioLista() {
        cabecera = null;
    }

    /**
     * @return the cabecera
     */
    public static Estudiante getCabecera() {
        return cabecera;
    }

    /**
     * @param cabecera the cabecera to set
     */
    public static void setCabecera(Estudiante cabecera) {
        ServicioLista.cabecera = cabecera;
    }

    public static void agregarNodos() {


        System.out.println("¿Desea añadir nodos en la lista? (Y/N)");
        String opcion = scanner.nextLine();

        if (opcion.toLowerCase().equals("y")) {
            System.out.println("¿Cuantos nodos desea agregar?");
            int cantidad = scanner.nextInt();


            Estudiante ultimo = null;


            for (int i = 0; i < cantidad; i++) {
                System.out.println("Digite el código del estudiante: ");
                int codigo = scanner.nextInt();

                System.out.println("Digite el nombre del estudiante: ");
                String nombre = scanner.next();

                Estudiante nuevo = new Estudiante(codigo, nombre);

                if (ultimo == null) {
                    cabecera = nuevo;
                    ultimo = nuevo;

                } else {
                    ultimo.setSgte(nuevo);
                    nuevo.setAnt(ultimo);
                    ultimo = nuevo;
                }
            }
        }

    }

    public static void mostrarLista() {
        Estudiante temporal = cabecera;

        if (temporal == null) {
            System.out.println("Lista vacia ");
            return;
        }
        while (temporal != null) {
            System.out.println("Código: " + temporal.getCodigo() + "   Nombre: " + temporal.getNombre());
            temporal = temporal.getSgte();
        }
    }

    public static void agregarInicio() {


        System.out.println("Digite el código del estudiante: ");
        int codigo = scanner.nextInt();
        System.out.println("Digite el nombre del estudiante: ");
        String nombre = scanner.next();

        Estudiante nuevo = new Estudiante(codigo, nombre);

        if (cabecera != null) {
            cabecera.setAnt(nuevo);
            nuevo.setSgte(cabecera);
            cabecera = nuevo;
        } else {
            cabecera = nuevo;
        }
    }

    public static void agregarFinal() {
        Estudiante temporal = cabecera;


        System.out.println("Digite el código del estudiante: ");
        int codigo = scanner.nextInt();
        System.out.println("Digite el nombre del estudiante: ");
        String nombre = scanner.next();

        Estudiante nuevo = new Estudiante(codigo, nombre);

        if (cabecera == null) {
            System.out.println("No hay elementos en la lista, el nodo pasará a ser la cabecera.");
            cabecera = nuevo;
        } else {
            while (temporal.getSgte() != null) {
                temporal = temporal.getSgte();
            }
            nuevo.setAnt(temporal);
            temporal.setSgte(nuevo);
        }


    }

    public static void agregarNodoPosicion() {

        System.out.println("¿En qué posición desea inserta el nuevo nodo?");
        int posicion = scanner.nextInt();

        System.out.println("Digite el código del estudiante: ");
        int codigo = scanner.nextInt();

        System.out.println("Digite el nombre del estudiante: ");
        String nombre = scanner.next();

        Estudiante nuevo = new Estudiante(codigo, nombre);


        if (cabecera == null) {
            System.out.println("No hay elementos en la lista. El nodo pasará a ser la cabecera.");
            cabecera = nuevo;
        } else {
            int i = 0;
            Estudiante actual = cabecera;
            while (actual != null) {
                if (i == posicion) {

                    break;
                }
                actual = actual.getSgte();
                i++;
            }
            if (i < posicion || actual == null) {
                System.out.println("La posición que digitó excede el tamaño de la lista actual.");
            } else {
                nuevo.setSgte(actual);
                if (actual.getAnt() != null) {
                    actual.getAnt().setSgte(nuevo);
                }
                nuevo.setAnt(actual.getAnt());
                actual.setAnt(nuevo);
            }
            if (posicion == 0) {
                cabecera = nuevo;
            }


        }

    }

    public static void eliminarNodoPosicion() {

        System.out.println("¿En qué posición eliminar el nodo?");
        int posicion = scanner.nextInt();

        int i = 0;
        Estudiante actual = cabecera;
        if(posicion==0){
            if (cabecera!=null){
                cabecera=cabecera.getSgte();
                if(cabecera!=null){
                    cabecera.setAnt(null);
                }
            }
            return;
        }
        while (actual != null) {
            if (i == posicion) {
                if (actual.getAnt()!=null){
                    actual.getAnt().setSgte(actual.getSgte());
                }
                if(actual.getSgte()!=null){
                    actual.getSgte().setAnt(actual.getAnt());
                }
                break;
            }
            actual = actual.getSgte();
            i++;
        }
    }


    public static void main(String[] args) {
        ServicioLista.agregarNodos();
        ServicioLista.mostrarLista();
        System.out.println("se va agregar al inicio de la lista");
        ServicioLista.agregarInicio();
        ServicioLista.mostrarLista();
        System.out.println("se va agregar al final de la lista");
        ServicioLista.agregarFinal();
        ServicioLista.mostrarLista();
        System.out.println("se va agregar por pocision en la lista");
        ServicioLista.agregarNodoPosicion();
        ServicioLista.mostrarLista();
        System.out.println("se va agregar por pocision en la lista");
        ServicioLista.eliminarNodoPosicion();
        ServicioLista.mostrarLista();
        scanner.close();
        System.out.println("hola");

    }

}
