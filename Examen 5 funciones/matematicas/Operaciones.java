package matematicas;

public class Operaciones {

    /**
     * suma: Realiza la suma de dos valores
     *
     * @param a Sumando 1
     * @param b Sumando 2
     * @return long
     */
    public static long suma(long a, long b) {
        return (a + b);
    }

    /**
     * suma: Realiza la suma de dos valores
     *
     * @param a Sumando 1
     * @param b Sumando 2
     * @return int
     */
    public static int suma(int a, int b) {
        return ((int) suma((long) a, (long) b));
    }

    /**
     * inc: Incrementa el valor de un valor en uno
     *
     * @param a Número a incrementar
     * @return long
     */
    public static long inc(long a) {
        return (suma(a, 1));
    }

    /**
     * inc: Incrementa el valor de un valor en uno
     *
     * @param a Número a incrementar
     * @return int
     */
    public static int inc(int a) {
        return ((int) inc((long) a));
    }

    /**
     * resta: Realiza la resta de dos número, a - b
     *
     * @param a Número 1
     * @param b Número 2
     * @return long
     */
    public static long resta(long a, long b) {
        return (suma(a, -b));
    }

    /**
     * resta: Realiza la resta de dos número, a - b
     *
     * @param a Número 1
     * @param b Número 2
     * @return int
     */
    public static int resta(int a, int b) {
        return ((int) resta((long) a, (long) b));
    }

    /**
     * dec: Decrece el número pasado por parámetro en 1
     *
     * @param a Número a decrecer
     * @return long
     */
    public static long dec(long a) {
        return (resta(a, 1));
    }

    /**
     * dec: Decrece el número pasado por parámetro en 1
     *
     * @param a Número a decrecer
     * @return long
     */
    public static int dec(int a) {
        return ((int) dec((long) a));
    }

    /**
     * esMayor: Compara dos números y dice si el primer parámetro es mayor que el
     * segundo
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esMayor(long a, long b) {
        return (resta(a, b) > 0 ? true : false);
    }

    /**
     * esMayor: Compara dos números y dice si el primer parámetro es mayor que el
     * segundo
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esMayor(int a, int b) {
        return (esMayor((long) a, (long) b));
    }

    /**
     * esMenor: Compara dos números y dice si el primer parámetro es menor que el
     * segundo
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esMenor(long a, long b) {
        return (resta(b, a) > 0 ? true : false);
    }

    /**
     * esMenor: Compara dos números y dice si el primer parámetro es menor que el
     * segundo
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esMenor(int a, int b) {
        return ((int) resta((long) b, (long) a) > 0 ? true : false);
    }

    /**
     * esIgual: Compara si dos números son iguales
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esIgual(long a, long b) {
        return (!esMayor(a, b) && !esMenor(a, b) ? true : false);
    }

    /**
     * esIgual: Compara si dos números son iguales
     *
     * @param a Número 1 a comparar
     * @param b Número 2 a comparar
     * @return boolean
     */
    public static boolean esIgual(int a, int b) {
        return (!esMayor((long) a, (long) b) && !esMenor((long) a, (long) b) ? true : false);
    }

    /**
     * multiplica: Multiplica dos números
     *
     * @param a Número 1
     * @param b Número 2
     * @return long
     */
    public static long multiplica(long a, long b) {
        long res = 0;
        /*
         * int signo = 0;
         * if (esMenor(a, 0))
         * signo = dec(signo);
         * if (esMenor(b, 0))
         */
        /********** controlar las multiplicaciones de números negativos **********/

        while (esMayor(b, 0)) {
            res = suma(res, a);
            b = dec(b);
        }

        return (res);
    }

    /**
     * multiplica: Multiplica dos números
     *
     * @param a Número 1
     * @param b Número 2
     * @return int
     */
    public static int multiplica(int a, int b) {
        return ((int) multiplica((long) a, (long) b));
    }

    /**
     * divide: Divide dos números
     *
     * @param a Número 1
     * @param b Número 2
     * @return long
     */
    public static long divide(long a, long b) {
        long res = 0;
        while (esMayor(a, b) || esIgual(a, b)) {
            res = inc(res);
            a = resta(a, b);
        }
        return (res);
    }

    /**
     * divide: Divide dos números
     *
     * @param a Número 1
     * @param b Número 2
     * @return int
     */
    public static int divide(int a, int b) {
        return ((int) divide((long) a, (long) b));
    }

    /**
     * resto
     * Devuelve el resto de la división entera
     * 
     * @param a Dividendo
     * @param b Divisor
     * @return Devuelve el resto de la división entera de a entre b
     */
    public static long resto(long a, long b) {
        long res = 0;
        while (esMayor(a, b) || esIgual(a, b)) {
            res = inc(res);
            a = resta(a, b);
        }
        return (a);
    }

    /**
     * resto
     * Devuelve el resto de la división entera
     * 
     * @param a Dividendo
     * @param b Divisor
     * @return Devuelve el resto de la división entera de a entre b
     */
    public static int resto(int a, int b) {
        return ((int) resto((long) a, (long) b));
    }

    /**
     * potencia
     * Devuelve la potencia de un número elevado a otro
     * 
     * @param base      base
     * @param exponente exponente
     * @return Devuelve la potencia de un número elevado a otro usando
     *         multiplicaciones
     */
    public static long potencia(long a, long b) {
        long res = 1;
        while (esMayor(b, 0)) {
            res = multiplica(res, a);
            b = dec(b);
        }
        return (res);
    }

    /**
     * potencia
     * Devuelve la potencia de un número elevado a otro
     * 
     * @param base      base
     * @param exponente exponente
     * @return Devuelve la potencia de un número elevado a otro usando
     *         multiplicaciones
     */
    public static int potencia(int a, int b) {
        return ((int) potencia((long) a, (long) b));
    }

    /**
     * cuadrado
     * Devuelve la potencia de un número elevado a 2
     * 
     * @param a número a calcular su cuadrado
     * @return Devuelve la potencia de un número elevado a 2
     */
    public static long cuadrado(long a) {
        return (potencia(a, 2));
    }

    /**
     * cuadrado
     * Devuelve la potencia de un número elevado a 2
     * 
     * @param a número a calcular su cuadrado
     * @return Devuelve la potencia de un número elevado a 2
     */
    public static int cuadrado(int a) {
        return ((int) cuadrado((long) a));
    }

    /**
     * cubo
     * Devuelve la potencia de un número elevado a 3
     * 
     * @param a número a calcular su cubo
     * @return Devuelve la potencia de un número elevado a 3
     */
    public static long cubo(long a) {
        return (potencia(a, 3));
    }

    /**
     * cubo
     * Devuelve la potencia de un número elevado a 3
     * 
     * @param a número a calcular su cubo
     * @return Devuelve la potencia de un número elevado a 3
     */
    public static int cubo(int a) {
        return ((int) cubo((long) a));
    }

    /**
     * esMultiplo
     * Indica si un número es múltiplo de otro dado
     * 
     * @param a valor a comprobar si es múltiplo
     * @param b valor con el que comprobar si a es múltiplo de él
     * @return true si a es múltiplo y false en caso contrario
     */
    public static boolean esMultiplo(long a, long b) {
        return (esIgual(resto(a, b), 0));
    }

    /**
     * esMultiplo
     * Indica si un número es múltiplo de otro dado
     * 
     * @param a valor a comprobar si es múltiplo
     * @param b valor con el que comprobar si a es múltiplo de él
     * @return true si a es múltiplo y false en caso contrario
     */
    public static boolean esMultiplo(int a, int b) {
        return (esMultiplo((long) a, (long) b));
    }

    /**
     * esDivisor
     * Indica si un número es divisor de otro dado
     * 
     * @param a valor a comprobar si es divisor
     * @param b valor con el que comprobar si a es divisor de él
     * @return true si a es divisor y false en caso contrario
     */
    public static boolean esDivisor(long a, long b) {
        return (esIgual(resto(b, a), 0));
    }

    /**
     * esDivisor
     * Indica si un número es divisor de otro dado
     * 
     * @param a valor a comprobar si es divisor
     * @param b valor con el que comprobar si a es divisor de él
     * @return true si a es divisor y false en caso contrario
     */
    public static boolean esDivisor(int a, int b) {
        return (esDivisor((long) a, (long) b));
    }

    /**
     * esPrimo
     * Indica si un número es primo
     * 
     * @param a número a comprobar si es primo
     * @return true si a es primo y false en caso contrario
     */
    public static boolean esPrimo(long a) {
        if (esMenor(a, 2))
            return false;
        boolean primo = true;
        long cont = a;
        cont = dec(cont);
        while (esMayor(cont, 1) && primo) {
            if (esIgual(resto(a, cont), 0)) {
                primo = false;
            }
            cont = dec(cont);
        }
        return (primo);
    }

    /**
     * esPrimo
     * Indica si un número es primo
     * 
     * @param a número a comprobar si es primo
     * @return true si a es primo y false en caso contrario
     */
    public static boolean esPrimo(int a) {
        return (esPrimo((long) a));
    }

    /**
     * esCuadradoPerfecto
     * Indica si un número es cuadrado perfecto
     * Un número es cuadrado perfecto si es el resultado del cuadrado de otro número
     * 
     * @param a número a comprobar si cuadrado perfecto
     * @return true si a es cuadrado perfecto y false en caso contrario
     */
    public static boolean esCuadradoPerfecto(long a) {
        if (esMenor(a, 0))
            return false;
        boolean cuadradoPerfecto = false;
        long cont = a;
        cont = dec(cont);
        while (esMayor(cont, 0) && !cuadradoPerfecto) {
            if (esIgual(cuadrado(cont), a)) {
                cuadradoPerfecto = true;
            }
            cont = dec(cont);
        }
        return (cuadradoPerfecto);
    }

    /**
     * esCuadradoPerfecto
     * Indica si un número es cuadrado perfecto
     * Un número es cuadrado perfecto si es el resultado del cuadrado de otro número
     * 
     * @param a número a comprobar si cuadrado perfecto
     * @return true si a es cuadrado perfecto y false en caso contrario
     */
    public static boolean esCuadradoPerfecto(int a) {
        return (esCuadradoPerfecto((long) a));
    }
}
