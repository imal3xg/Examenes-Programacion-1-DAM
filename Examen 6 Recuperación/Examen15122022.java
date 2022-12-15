import java.util.Scanner;

public class Examen15122022 {
    public static final int CARTAS_MAZO = 40; // Número de cartas del mazo
    public static final int MAX_CARTAS_EN_JUGADA = 8; // Máximo número de cartas que puede tener el jugador o la banca

    /**
     * muestraBienvenida
     * Muestra por pantalla un mensaje de bienvenida del juego
     */
    public static void muestraBienvenida() {
        System.out.println("********************** 7 Y MEDIA **********************");
        System.out.println("*            Un juego divertido y adictivo            *");
        System.out.println("*******************************************************");
    }

    /**
     * baraja
     * Recibe una array de 40 elementos y debe rellenarlo con valores
     * aleatorios entre 0 y 39 ambos inclusive. No se pueden repetir
     * los valores en el array de manera que estén los 40 diferentes
     * valores en el array
     *
     * @param cartas array de enteros que contendrán las cartas
     */
    public static void baraja(int[] cartas) {
        int i = 0;
        while (i < cartas.length) {
            boolean correcto = true;
            int num = (int) (Math.random() * 40);
            for (int j = 0; j < i && correcto; j++) {
                if (num == cartas[j])
                    correcto = false;
            }
            if (correcto)
                cartas[i++] = num;
        }
    }

    /**
     * inicializaCartas
     * Recibe un array y almacena un -1 en cada posición
     *
     * @param array Array de enteros
     */
    public static void inicializaCartas(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = -1;
    }

    /**
     * pideApuesta
     * Debe solicitar la cantidad de dinero que se quiere apostar
     * y debe controlar que se introduce una cantidad
     * igual o inferior de la del monedero y que sea mayor que 0
     * 
     * @param sc       Scanner para leer los datos
     * @param monedero Cantidad en el monedero
     * @return Cantidad de dinero que se quiere apostar
     */
    public static int pideApuesta(Scanner sc, int monedero) {
        int apuesta;
        do {
            System.out.printf("Tienes %s euros. ¿Cuánto dinero quieres apostar?: ", monedero);
            apuesta = sc.nextInt();
            if (apuesta < 0 || apuesta > monedero) {
                System.out.println("************************************");
                System.out.println("* Error en la cantidad introducida *");
                System.out.println("************************************");
            }
        } while (apuesta < 0 || apuesta > monedero);
        return apuesta;
    }

    /**
     * sacaUnaCarta
     * Devuelve el valor del array (mazo) en la posición dada y
     * almacena un -1 en su lugar para indicar que la carta ya no se
     * encuentra en el mazo
     * 
     * @param mazo     Array conteniendo las cartas del mazo
     * @param posicion Posición de la carta que se quiere obtener
     * @return Devuelve el contenido del array en dicha posición
     */
    public static int sacaUnaCarta(int[] mazo, int posicion) {
        int aux = mazo[posicion];
        mazo[posicion] = -1;
        return aux;
    }

    /**
     * imprimeCartas
     * Imprime por pantalla las cartas contenidas en el array
     * suministrado. Escribirá un título que indica de que jugador
     * se trata.
     * 
     * @param titulo          Título para mostrar antes de imprimir las cartas
     * @param cartas          Array conteniendo las cartas a mostrar
     * @param numerosYFiguras Array conteniendo los textos de cada
     *                        una de las cartas posibles (Uno, Dos, Tres, …,Siete,
     *                        Sota,
     *                        Caballo, Rey)
     * @param palos           Array conteniendo los nombres de los cuatro
     *                        palos (Oros, Copas, Espadas, Bastos)
     */
    public static void imprimeCartas(String titulo, int[] cartas, String[] numerosYFiguras, String[] palos) {
        System.out.printf("***** %s *****\n", titulo);
        for (int i = 0; i < cartas.length && cartas[i] != -1; i++) {
            String num = numerosYFiguras[cartas[i] % 10];
            String palo = palos[cartas[i] / 10];
            System.out.printf("%s de %s\n", num, palo);
        }
        System.out.println("***************************");
    }

    /**
     * sumaCartas
     * Suma la puntuación de las cartas contenidas en el array
     * teniendo en cuenta que las figuras puntúan medio punto y el
     * resto de cartas el valor de la carta
     * 
     * @param cartas Array conteniendo las cartas
     * @return Devuelve la puntuación (puede contener decimales)
     */
    public static float sumaCartas(int[] cartas) {
        float suma = 0;
        for (int i = 0; i < cartas.length && cartas[i] != -1; i++) {
            if (cartas[i] % 10 > 6)
                suma += 0.5;
            else
                suma += (cartas[i] % 10) + 1;
        }
        return suma;
    }

    /**
     * esSieteYMedia
     * Devuelve si la puntuación de las cartas en el array
     * suministrado es 7 y media
     * 
     * @param cartas Array conteniendo las cartas
     * @return Devuelve true si la puntuación es 7 y media y false
     *         en caso contrario
     */
    public static boolean esSieteYMedia(int[] cartas) {
        if (sumaCartas(cartas) == 7.5)
            return true;
        return false;
    }

    /**
     * puedeSeguirJugando
     * Con las cartas actuales del array suministrado devuelve si es
     * posible seguir jugando o no
     * 
     * @param cartas Array conteniendo las cartas
     * @return Devuelve true si se puede seguir jugando y false en
     *         caso contrario
     */
    public static boolean puedeSeguirJugando(int[] cartas) {
        if (sumaCartas(cartas) < 7.5)
            return true;
        return false;
    }

    /**
     * quieresPlantarte
     * Devuelve si el jugador quiere plantarse o no. Tendrá que pedir
     * a través de un menú si quiere plantarse o seguir jugando
     * 
     * @param sc Scanner para poder solicitar datos por teclado
     * @return Devuelve true si se quiere plantar y false en caso
     *         contrario
     */
    public static boolean quieresPlantarte(Scanner sc) {

        int opcion = sc.nextInt();
        if (opcion == 2)
            return true;
        return false;
    }

    /**
     * quieresSeguirJugando
     * Devuelve si el jugador quiere seguir jugando o no. Tendrá que
     * pedir a través de un menú si quiere seguir jugando o por el
     * contrario quiere salir del juego.
     * 
     * @param sc Scanner para poder solicitar datos por teclado
     * @return Devuelve true si quiere seguir jugando y false en caso
     *         contrario
     */
    public static boolean quieresSeguirJugando(Scanner sc) {
        System.out.println("¿Quieres seguir jugando?");
        System.out.println("1. Si");
        System.out.println("2. No");
        int opcion = sc.nextInt();
        if (opcion == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        final int SIN_GANADOR = 0;
        final int GANA_JUGADOR = 1; // Gana el jugador
        final int GANA_BANCA = 2; // Gana la banca
        final int MONEDERO_JUGADOR = 1000; // importe inicial del monedero
        Scanner sc = new Scanner(System.in);
        String[] numerosYFiguras = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Sota", "Caballo",
                "Rey" };
        String[] palos = { "Oros", "Copas", "Espadas", "Bastos" };
        int[] mazo = new int[CARTAS_MAZO]; // El mazo con las cartas que contiene valores int indicando la carta
                                           // correspondiente
                                           // Si una carta no está se debe almacenar un -1
                                           // 0 -> 1 de Oros
                                           // 1 -> 2 de Oros
                                           // ...
                                           // 9 -> Rey de Oros
                                           // 10 -> 1 de Copas
                                           // ...
                                           // 19 -> Rey de Copas
                                           // 20 -> 1 de Espadas
                                           // ...
                                           // 29 -> Rey de Espadas
                                           // 30 -> 1 de Bastos
                                           // ...
                                           // 39 -> Rey de Bastos
        int[] cartasJugador = new int[MAX_CARTAS_EN_JUGADA]; // Cartas del jugador
                                                             // Como máximo podrá tener 8 cartas
                                                             // Se deben inicializar a -1 todas las cartas
                                                             // -1 indica que no hay carta
                                                             // p.ej.
                                                             // 1, 9, 29, 17, -1, -1, -1, -1
                                                             // 2 de Oros, Rey de Oros, Rey de Espadas, Sota de Copas,
                                                             // Sin carta, Sin Carta, Sin Carta
        int[] cartasBanca = new int[MAX_CARTAS_EN_JUGADA]; // Cartas de la banca
                                                           // Como máximo podrá tener 8 cartas
                                                           // Se deben inicializar a -1 todas las cartas
                                                           // -1 indica que no hay carta
                                                           // 1, 9, 29, 17, -1, -1, -1, -1
                                                           // 2 de Oros, Rey de Oros, Rey de Espadas, Sota de Copas, Sin
                                                           // carta, Sin Carta, Sin Carta
        int monedero = MONEDERO_JUGADOR; // Este es el monedero del jugador con la cantidad actual de dinero que tiene
        boolean finJuego = false;
        muestraBienvenida();
        do {
            baraja(mazo); // Se rellena el array de cartas del mazo con posiciones aleatorias de 0 a 39
                          // sin repetir las cartas.
            inicializaCartas(cartasJugador); // Se inicializa el array de cartas del jugador a -1
            inicializaCartas(cartasBanca); // Se inicializa el array de cartas de la banca a -1
            int numCartasJugador = 0; // Indica el número de cartas que tiene el jugador
                                      // En el array de cartas del jugador las n primeras posiciones del array
                                      // contendrán la
                                      // carta asignada en cada momento

            int numCartasBanca = 0; // Indica el número de cartas que tiene la banca
                                    // En el array de cartas de la banca las n primeras posiciones del array
                                    // contendrán la
                                    // carta asignada en cada momento
            int ganador = SIN_GANADOR; // Se indica que no hay ganador
            int apuesta = pideApuesta(sc, monedero); // Se le pide al jugador la apuesta a realizar
            boolean finPartidaJugador = false;
            cartasJugador[numCartasJugador++] = sacaUnaCarta(mazo, 0);

            /******************* jugador ***************** */
            do {
                imprimeCartas("TUS CARTAS", cartasJugador, numerosYFiguras, palos);
                System.out.println("¿Qué vas a hacer?");
                System.out.println("1. Quiero otra carta");
                System.out.println("2. Me planto");
                boolean opcion = quieresPlantarte(sc);
                if (opcion)
                    finPartidaJugador = true;
                else {
                    cartasJugador[numCartasJugador] = sacaUnaCarta(mazo, numCartasJugador);
                    numCartasJugador++;
                }
                if (!puedeSeguirJugando(cartasJugador))
                    finPartidaJugador = true;
            } while (!finPartidaJugador && numCartasJugador < 8);
            imprimeCartas("TUS CARTAS", cartasJugador, numerosYFiguras, palos);
            if (sumaCartas(cartasJugador) > 7.5)
                ganador = GANA_BANCA;

            /******************* banca ***************** */
            if (ganador == SIN_GANADOR) {
                do {
                    cartasBanca[numCartasBanca] = sacaUnaCarta(mazo, numCartasJugador + numCartasBanca++);
                } while (sumaCartas(cartasBanca) < 7.5 && sumaCartas(cartasBanca) < sumaCartas(cartasJugador));
                imprimeCartas("BANCA", cartasBanca, numerosYFiguras, palos);
                ganador = sumaCartas(cartasBanca) <= 7.5 ? GANA_BANCA : GANA_JUGADOR;
            }
            switch (ganador) {
                case GANA_JUGADOR:
                    monedero += apuesta;
                    System.out.printf("Enhorabuena has ganado %d euros. Ahora tienes %d\n", apuesta, monedero);
                    break;
                case GANA_BANCA:
                    monedero -= apuesta;
                    System.out.printf("La banca gana %d euros. Ahora tienes %d\n", apuesta, monedero);
                    break;
            }
            if (monedero > 0) {
                if (!quieresSeguirJugando(sc))
                    finJuego = true;
            } else {
                System.out.print("Estás en bancarrota.\nGracias por jugar.\nFin del Juego");
                finJuego = true;
            }
        } while (!finJuego);
    }
}