import matematicas.Operaciones;

public class Examen13122022 {
    public static void main(String[] args) {
        System.out.println("  Pruebas unitarias");
        System.out.println("**********************");
        System.out.printf("Función suma: %s\n", Operaciones.suma(5,3)==8 && Operaciones.suma(-5,-3)==-8?"correcto":"fallo");
        System.out.printf("Función inc: %s\n", Operaciones.inc(5)==6 && Operaciones.inc(-5)==-4?"correcto":"fallo");
        System.out.printf("Función resta: %s\n", Operaciones.resta(5,3)==2 && Operaciones.resta(-5, -3)==-2?"correcto":"fallo");
        System.out.printf("Función dec: %s\n", Operaciones.dec(5)==4 && Operaciones.dec(-5)==-6?"correcto":"fallo");
        System.out.printf("Función esMayor: %s\n", Operaciones.esMayor(5,4) && !Operaciones.esMayor(4, 5) && !Operaciones.esMayor(5,5)?"correcto":"falso");
        System.out.printf("Función esMenor: %s\n", Operaciones.esMenor(4,5) && !Operaciones.esMenor(5, 4) && !Operaciones.esMenor(5,5)?"correcto":"falso");
        System.out.printf("Función esIgual: %s\n", Operaciones.esIgual(5,5)?"correcto":"falso");
        System.out.printf("Función multiplica: %s\n", Operaciones.multiplica(5,2)==10?"correcto":"falso");
        System.out.printf("Función divide: %s\n", Operaciones.divide(10,2)==5?"correcto":"falso");
        System.out.printf("Función resto: %s\n", Operaciones.resto(10,3)==1 && Operaciones.resto(10, 2)==0?"correcto":"falso");
        System.out.printf("Función potencia: %s\n", Operaciones.potencia(2,3)==8?"correcto":"falso");
        System.out.printf("Función cuadrado: %s\n", Operaciones.cuadrado(3)==9?"correcto":"falso");
        System.out.printf("Función cubo: %s\n", Operaciones.cubo(3)==27?"correcto":"falso");
        System.out.printf("Función esMultiplo: %s\n", Operaciones.esMultiplo(25, 5) && !Operaciones.esMultiplo(25, 3)?"correcto":"falso");
        System.out.printf("Función esDivisor: %s\n", Operaciones.esDivisor(5, 25) && !Operaciones.esDivisor(3, 25)?"correcto":"falso");
        System.out.printf("Función esPrimo: %s\n", Operaciones.esPrimo(13) && !Operaciones.esPrimo(4) && !Operaciones.esPrimo(-5) && !Operaciones.esPrimo(1) && !Operaciones.esPrimo(0)?"correcto":"falso");
        System.out.printf("Función esCuadradoPerfecto: %s\n", Operaciones.esCuadradoPerfecto(25) && !Operaciones.esCuadradoPerfecto(8)?"correcto":"falso");



    System.out.println("\n**********************");
    System.out.println("  Pruebas unitarias");
    System.out.println("**********************");
    System.out.printf("Función suma: %s\n", Operaciones.suma((long) 5,(long) 3)==8 && Operaciones.suma((long)-5,(long)-3)==-8?"correcto":"fallo");
    System.out.printf("Función inc: %s\n", Operaciones.inc((long)5)==6 && Operaciones.inc((long)-5)==-4?"correcto":"fallo");
    System.out.printf("Función resta: %s\n", Operaciones.resta((long)5,(long)3)==2 && Operaciones.resta((long)-5,(long) -3)==-2?"correcto":"fallo");
    System.out.printf("Función dec: %s\n", Operaciones.dec((long)5)==4 && Operaciones.dec((long)-5)==-6?"correcto":"fallo");
    System.out.printf("Función esMayor: %s\n", Operaciones.esMayor((long)5,(long)4) && !Operaciones.esMayor((long)4, (long)5) && !Operaciones.esMayor((long)5,(long)5)?"correcto":"falso");
    System.out.printf("Función esMenor: %s\n", Operaciones.esMenor((long)4,(long)5) && !Operaciones.esMenor((long)5, (long)4) && !Operaciones.esMenor((long)5,(long)5)?"correcto":"falso");
    System.out.printf("Función esIgual: %s\n", Operaciones.esIgual((long)5,(long)5)?"correcto":"falso");
    System.out.printf("Función multiplica: %s\n", Operaciones.multiplica((long)5,(long)2)==10?"correcto":"falso");
        System.out.printf("Función divide: %s\n", Operaciones.divide((long)10,(long)2)==5?"correcto":"falso");
        System.out.printf("Función resto: %s\n", Operaciones.resto((long)10,(long)3)==1 && Operaciones.resto((long)10, (long)2)==0?"correcto":"falso");
        System.out.printf("Función potencia: %s\n", Operaciones.potencia((long)2,(long)3)==8?"correcto":"falso");
        System.out.printf("Función cuadrado: %s\n", Operaciones.cuadrado((long)3)==9?"correcto":"falso");
        System.out.printf("Función cubo: %s\n", Operaciones.cubo((long)3)==27?"correcto":"falso");
        System.out.printf("Función esMultiplo: %s\n", Operaciones.esMultiplo((long)25, (long)5) && !Operaciones.esMultiplo((long)25, (long)3)?"correcto":"falso");
        System.out.printf("Función esDivisor: %s\n", Operaciones.esDivisor((long)5, (long)25) && !Operaciones.esDivisor((long)3, (long)25)?"correcto":"falso");
        System.out.printf("Función esPrimo: %s\n", Operaciones.esPrimo((long)13) && !Operaciones.esPrimo((long)4) && !Operaciones.esPrimo((long)-5) && !Operaciones.esPrimo((long)1) && !Operaciones.esPrimo((long)0)?"correcto":"falso");
        System.out.printf("Función esCuadradoPerfecto: %s\n", Operaciones.esCuadradoPerfecto((long)25) && !Operaciones.esCuadradoPerfecto((long)8)?"correcto":"falso");

}
}
