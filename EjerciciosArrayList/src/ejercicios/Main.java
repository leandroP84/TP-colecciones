package ejercicios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Ingrese el ejercicio a ejecutar:");
            int ejercicio = sc.nextInt();

            switch (ejercicio) {
                case 1:
                    ejercicio1();
                    break;

                case 2:
                    ejercicio2();
                    break;

                case 3:
                    ejercicio3();
                    break;

                case 4:
                    ejercicio4();
                    break;

                case 5:
                    ejercicio5();
                    break;

                case 6:
                    ejercicio6();
                    break;

                default:
                    System.out.println("Ejerciio no válido. Intente nuevamente.");
            }
            System.out.println();
            System.out.println("¿Ejecutar otro ejercicio?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            int menu = sc.nextInt();
            if (menu == 2) {
                System.out.println("Saliendo del programa...");
                break;
            }
        }
    }

    private static void ejercicio1() {
        // Ejercicio 1: Ingresar valores hasta ingresar uno menor a 0
        Scanner scanner = new Scanner(System.in);
        List<Integer> numE1 = new ArrayList<>();
        int numerE1;

        System.out.println("Ingresa números (ingresa un número menor a 0 para terminar):");

        while (true) {
            numerE1 = scanner.nextInt();
            if (numerE1 < 0) {
                break;
            }
            numE1.add(numerE1);
        }

        System.out.println("Números ingresados: ");
        for (int num : numE1) {
            System.out.println(num);
        }
    }

    private static void ejercicio2() {
        // Ejercicio 2: Leer 20 números y determinar mayor, menor, y rango
        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Ingrese 20 números decimales: ");
        for (int i = 0; i < 20; i++) {
            System.out.println("Número " + (i + 1) + ": ");
            double numDecimal = scanner.nextDouble();
            int numEntero = (int) numDecimal;
            numeros.add(numEntero);
        }

        int numMayor = Collections.max(numeros);
        int numMenor = Collections.min(numeros);
        int rango = numMayor - numMenor;

        System.out.println("Número Mayor: " + numMayor);
        System.out.println("Número Menor: " + numMenor);
        System.out.println("Rango: " + rango);
    }

    private static void ejercicio3() {
        // Ejercicio 3: 20 números enteros positivos pares aleatorios
        ArrayList<Integer> numeros = new ArrayList<>();
        int suma = 0;

        while (numeros.size() < 20) {
            int numeroAleatorio = 2 + (int) (Math.random() * 99);
            if (numeroAleatorio % 2 == 0) {
                numeros.add(numeroAleatorio);
                suma += numeroAleatorio;
            }
        }

        int promedio = suma / numeros.size();
        System.out.println("Números: " + numeros);
        System.out.println("Promedio aritmético: " + promedio);

        long iguales = numeros.stream().filter(n -> n == promedio).count();
        long mayores = numeros.stream().filter(n -> n > promedio).count();
        long menores = numeros.stream().filter(n -> n < promedio).count();

        System.out.println("Iguales al promedio: " + iguales);
        System.out.println("Menores que el promedio: " + menores);
        System.out.println("Mayores que el promedio: " + mayores);

    }

    private static void ejercicio4() {
        // Ejercicio 4: Búsqueda secuencial en una lista de 50 elementos aleatorios
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 50; i++) {
            numeros.add(1 + (int) (Math.random() * 100));
        }

        System.out.println("Ingrese un entero para buscar en la lista:");
        int valor = sc.nextInt();

        int posicion = numeros.indexOf(valor);
        if (posicion != -1) {
            System.out.println("El entero se encontró en la posición " + (posicion + 1));
        } else {
            System.out.println("No se encontró el entero en la lista.");
        }

        System.out.println("Lista completa: " + numeros);
    }

    private static void ejercicio5() {
        // Ejercicio 5: Ordenar una lista en ascendente y descendente
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese 10 dígitos enteros:");
        for (int i = 0; i < 10; i++) {
            int numero = scanner.nextInt();
            listaNumeros.add(numero);
        }

        ArrayList<Integer> listaAscendente = new ArrayList<>(listaNumeros);
        ArrayList<Integer> listaDescendente = new ArrayList<>(listaNumeros);

        Collections.sort(listaAscendente);
        Collections.sort(listaDescendente, Collections.reverseOrder());

        System.out.println("Lista en orden ascendente: " + listaAscendente);
        System.out.println("Lista en orden descendente: " + listaDescendente);
    }

    private static void ejercicio6() {
        // Ejercicio 6: Clase Matriz y Celdas
        Matriz matriz = new Matriz();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese un valor para la celda (o 'FIN' para terminar): ");
            String valor = scanner.nextLine();

            if (valor.equalsIgnoreCase("FIN")) {
                break;
            }

            System.out.print("Ingrese la fila: ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna: ");
            int columna = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            matriz.agregarCelda(fila, columna, valor);
        }

        matriz.mostrarMatriz();

        System.out.print("Ingrese la fila para buscar un valor: ");
        int filaBuscar = scanner.nextInt();
        System.out.print("Ingrese la columna para buscar un valor: ");
        int columnaBuscar = scanner.nextInt();
        String valorEncontrado = matriz.obtenerValor(filaBuscar, columnaBuscar);
        System.out.println("Valor encontrado: " + valorEncontrado);
    }
}

class Matriz {
    public class Celda {
        int fila;
        int columna;
        String valor;

        public Celda(int fila, int columna, String valor) {
            this.fila = fila;
            this.columna = columna;
            this.valor = valor;
        }
        public String toString() {
            return "Celda [fila=" + fila + ", columna=" + columna + ", valor=" + valor + "]";
        }
    }

    ArrayList<Celda> matrizCuadrada = new ArrayList<>();

    public void agregarCelda(int fila, int columna, String valor) {
        Celda nuevaCelda = new Celda(fila, columna, valor);
        matrizCuadrada.add(nuevaCelda);
    }

    public String obtenerValor(int fila, int columna) {
        for (Celda celda : matrizCuadrada) {
            if (celda.fila == fila && celda.columna == columna) {
                return celda.valor;
            }
        }
        return "La fila y columna indicada no ha sido asignada";
    }

    public void mostrarMatriz() {
        if (matrizCuadrada.isEmpty()) {
            System.out.println("La matriz está vacía.");
        } else {
            System.out.println("Valores en la matriz:");
            for (Celda celda : matrizCuadrada) {
                System.out.println(celda);
            }
        }
    }
}
