
/**
 * Examen13122022 
 *
 * @author: Marina Ruiz Artacho
 **/

import matematicas.Operaciones;

public class Examen13122022 {

    public static String showTrace(String msg) {
        if (msg.equals("__LINE__"))
            return (String.valueOf(new Throwable().getStackTrace()[1].getLineNumber()));
        else {
            String print = switch (msg) {
                case "__FILE__" -> new Throwable().getStackTrace()[1].getFileName();
                case "__CLASS__" -> new Throwable().getStackTrace()[1].getClassName();
                case "__METHOD__" -> new Throwable().getStackTrace()[1].getMethodName();
                default -> "";
            };
            return (print);
        }
    }

    public static void printResult(int result, String trace) {
        if (result == 1)
            System.out.printf("\033[1;92mCONGRATS! %s OK!\033[0;97m\n", trace);
        else
            System.out.printf("\033[1;91m%s IS WRONG!\033[0;97m\n", trace);
    }

    public static int test_suma(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.suma(a[i], b[j]) != (a[i] + b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d + %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.suma(a[i], b[j]), (a[i] + b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_inc(int[] a) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (Operaciones.inc(a[i]) != (a[i] + 1)) {
                System.out.printf(
                        "\033[31mError in: %s %d++\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                        showTrace("__METHOD__"), a[i], Operaciones.inc(a[i]), (a[i] + 1));
                result = 0;
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_resta(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.resta(a[i], b[j]) != (a[i] - b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d - %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.resta(a[i], b[j]), (a[i] - b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_dec(int[] a) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (Operaciones.dec(a[i]) != (a[i] - 1)) {
                System.out.printf(
                        "\033[31mError in: %s %d--\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                        showTrace("__METHOD__"), a[i], Operaciones.dec(a[i]), (a[i] - 1));
                result = 0;
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_esMayor(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.esMayor(a[i], b[j]) != (a[i] > b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d > %d\n\033[36mYour result: %b \nExpected result %b \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.esMayor(a[i], b[j]), (a[i] > b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_esMenor(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.esMenor(a[i], b[j]) != (a[i] < b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d < %d\n\033[36mYour result: %b \nExpected result %b \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.esMenor(a[i], b[j]), (a[i] < b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_esIgual(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.esIgual(a[i], b[j]) != (a[i] == b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d == %d\n\033[36mYour result: %b \nExpected result %b \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.esIgual(a[i], b[j]), (a[i] == b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_multiplica(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.multiplica(a[i], b[j]) != (a[i] * b[j])) {
                    System.out.printf(
                            "\033[31mError in: %s %d * %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.multiplica(a[i], b[j]), (a[i] * b[j]));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_divide(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.divide(a[i], b[j]) != (b[j] != 0 ? (a[i] / b[j]) : 0)) {
                    System.out.printf(
                            "\033[31mError in: %s %d / %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.divide(a[i], b[j]),
                            (b[j] != 0 ? (a[i] / b[j]) : 0));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_resto(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.resto(a[i], b[j]) != (b[j] != 0 ? (a[i] % b[j]) : 0)) {
                    System.out.printf(
                            "\033[31mError in: %s %d %% %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.resto(a[i], b[j]),
                            (b[j] != 0 ? (a[i] % b[j]) : 0));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_potencia(int[] a, int[] b) {
        long c = 0;
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] > 25) {
                    c = b[j] < 0 ? 0 : (long) Math.pow((double) a[i], (double) b[j]);
                    if (Operaciones.potencia(a[i], b[j]) != c) {
                        System.out.printf(
                                "\033[31mError in: %s %d^%d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                                showTrace("__METHOD__"), a[i], b[j], Operaciones.potencia(a[i], b[j]), c);
                        result = 0;
                    }
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_cuadrado(int[] a) {
        long c = 0;
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 46340) {
                c = (long) Math.pow((double) a[i], (double) 2);
                if (Operaciones.cuadrado(a[i]) != c) {
                    System.out.printf(
                            "\033[31mError in: %s %d^2\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], Operaciones.cuadrado(a[i]), c);
                    result = 0;
                }
            }

        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_cubo(int[] a) {
        long c = 0;
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 46340) {
                c = (long) Math.pow((double) a[i], (double) 3);
                if (Operaciones.cubo(a[i]) != c) {
                    System.out.printf(
                            "\033[31mError in: %s %d^3\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], Operaciones.cubo(a[i]), c);
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_esMultiplo(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.esMultiplo(a[i], b[j]) != (b[j] > 0 ? (a[i] % b[j] == 0) : false)) {
                    System.out.printf(
                            "\033[31mError in: %s %d es múltiplo de %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.esMultiplo(a[i], b[j]),
                            (b[j] > 0 ? (a[i] % b[j] == 0) : false));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static int test_esDivisor(int[] a, int[] b) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Operaciones.esDivisor(a[i], b[j]) != (a[i] > 0 ? (b[j] % a[i] == 0) : false)) {
                    System.out.printf(
                            "\033[31mError in: %s %d es divisor de %d\n\033[36mYour result: %d \nExpected result %d \033[97m\n\n",
                            showTrace("__METHOD__"), a[i], b[j], Operaciones.esDivisor(a[i], b[j]),
                            (a[i] > 0 ? (b[j] % a[i] == 0) : false));
                    result = 0;
                }
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static boolean ft_esPrimo(int a) {
        if (a < 2)
            return false;
        for (int j = 2; j <= (a / 2); j++)
            if (a % j == 0)
                return false;
        return true;
    }

    public static int test_esPrimo(int[] a) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (Operaciones.esPrimo(a[i]) != ft_esPrimo(a[i])) {
                System.out.printf(
                        "\033[31mError in: %s %d %ses primo\n\033[36mYour result: %b \nExpected result %b \033[97m\n\n",
                        showTrace("__METHOD__"), a[i], (ft_esPrimo(a[i]) == false ? "NO " : ""),
                        Operaciones.esPrimo(a[i]), ft_esPrimo(a[i]));
                result = 0;
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static boolean ft_esCuadradoPerfecto(int a) {
        long i = 0;
        while (i < a) {
            if ((int) Math.pow((double) i, (double) 2) == a)
                return true;
            i++;
        }
        return false;
    }

    public static int test_esCuadradoPerfecto(int[] a) {
        int result = 1;
        for (int i = 0; i < a.length; i++) {
            if (Operaciones.esCuadradoPerfecto(a[i]) != ft_esCuadradoPerfecto(a[i])) {
                System.out.printf(
                        "\033[31mError in: %s %d %ses cuadrado perfecto\n\033[36mYour result: %b \nExpected result %b \033[97m\n\n",
                        showTrace("__METHOD__"), a[i], (ft_esCuadradoPerfecto(a[i]) == false ? "NO " : ""),
                        Operaciones.esCuadradoPerfecto(a[i]), ft_esCuadradoPerfecto(a[i]));
                result = 0;
            }
        }
        printResult(result, showTrace("__METHOD__"));
        return result;
    }

    public static void main(String[] args) {
        int[] a = { -25, -3, 0, 1, 2, 3, 4, 5, 7, 8, 9, 25 };
        int[] b = { -25, -3, 0, 1, 2, 3, 4, 5, 7, 8, 9, 25 };

        int[] results = new int[17];
        String[] tests = { "suma", "inc", "resta", "dec", "esMayor", "esMenor", "esIgual", "multiplica", "divide",
                "resto", "potencia", "cuadrado", "cubo", "esMultiplo", "esDivisor", "esPrimo", "esCuadradoPerfecto" };

        System.out.println("  Pruebas unitarias");
        System.out.println("**********************");
        results[0] = test_suma(a, b);
        results[1] = test_inc(a);
        results[2] = test_resta(a, b);
        results[3] = test_dec(a);
        results[4] = test_esMayor(a, b);
        results[5] = test_esMenor(a, b);
        results[6] = test_esIgual(a, b);
        results[7] = test_multiplica(a, b);
        results[8] = test_divide(a, b);
        results[9] = test_resto(a, b);
        results[10] = test_potencia(a, b);
        results[11] = test_cuadrado(a);
        results[12] = test_cubo(a);
        results[13] = test_esMultiplo(a, b);
        results[14] = test_esDivisor(a, b);
        results[15] = test_esPrimo(a);
        results[16] = test_esCuadradoPerfecto(a);

        boolean correct = true;
        for (int i = 0; i < results.length; i++) {
            if (results[i] == 0)
                correct = false;
        }
        if (!correct) {
            System.out.print("Test que han fallado: ");
            for (int i = 0; i < results.length; i++) {
                if (results[i] == 0 && i < 16)
                    System.out.printf("%s, ", tests[i]);
                else if (results[i] == 0)
                    System.out.printf("%s", tests[i]);
            }
            System.out.println();
            System.out.println();
        } else {
            System.out.print("\n\033[1;93mCONGRATULATIONS!! ALL TESTS PASSED\033[0;97m\n");
        }
    }
}
