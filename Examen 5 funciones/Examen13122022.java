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
 

}
}
