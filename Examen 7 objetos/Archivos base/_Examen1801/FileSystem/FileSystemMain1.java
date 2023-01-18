package FileSystem;
import java.util.Scanner;
public class FileSystemMain1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        File[] files = new File[100];
        int filesInArray = 0;
        int opcion = 0;
        String nombre;
        do {
            System.out.println("1. Añadir archivo");
            System.out.println("2. Listar archivos");
            System.out.println("3. Terminar");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre del archivo: ");
                    nombre = sc.nextLine();
                    files[filesInArray++] = new File(nombre, 0);
                    break;
                case 2:
                    for(File file: files){
                        if(file!=null)
                            System.out.println(file);
                    }
                    break;
            }
        } while (opcion!=3);
        

        sc.close();

    }
}