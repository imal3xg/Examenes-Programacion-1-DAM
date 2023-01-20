package FileSystem;
import java.util.Scanner;
public class FileSystemMain2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        File[] files = new File[100];
        int filesInArray = 0;
        int opcion = 0;
        String nombre;
        do {
            System.out.println("1. Añadir archivo");
            System.out.println("2. Añadir carpeta");
            System.out.println("3. Listar archivos");
            System.out.println("4. Terminar");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre del archivo: ");
                    nombre = sc.nextLine();
                    files[filesInArray++] = new File(nombre, 0);
                    break;
                case 2:
                    System.out.print("Introduzca el nombre de la carpeta: ");
                    nombre = sc.nextLine();
                    files[filesInArray++] = new Folder(null, nombre,0);
                    break;
                case 3:
                    for(File file: files){
                        if(file!=null){
                            System.out.print(file);
                            if(!file.isDirectory())
                                System.out.println();
                        }
                    }
                    break;
            }
        } while (opcion!=4);
        

        sc.close();

    }
}