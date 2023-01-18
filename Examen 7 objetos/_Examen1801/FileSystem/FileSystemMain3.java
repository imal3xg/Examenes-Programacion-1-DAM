package FileSystem;
import java.util.Scanner;
public class FileSystemMain3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        FileSystem fs = new FileSystem();
        int opcion = 0;
        String nombre;
        do {
            System.out.println("1. Listar directorio acutal");
            System.out.println("2. Crear un directorio");
            System.out.println("3. Borrar un directorio");
            System.out.println("4. Añadir un archivo");
            System.out.println("5. Entrar en directorio");
            System.out.println("6. Salir del directorio actual");
            System.out.println("7. Terminar");
            System.out.print("("+fs.getPrompt()+")");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("tree .");
                    fs.tree();
                    break;
                case 2:
                    System.out.print("Introduzca el nombre del directorio: ");
                    nombre = sc.nextLine();
                    System.out.println("mkdir "+nombre);
                    fs.mkDir(nombre);
                    break;
                case 3:
                    System.out.print("Introduzca el nombre del directorio: ");
                    nombre = sc.nextLine();
                    System.out.print("¿Recursivamente? (S/N)");
                    boolean recursive=(sc.nextLine()).equals("S");
                    System.out.println("rmDir "+(recursive?"-R":""));
                    fs.rmDir(nombre, recursive);
                    break;
                case 4:
                    System.out.print("Introduzca el nombre del archivo: ");
                    nombre = sc.nextLine();
                    System.out.println("touch "+nombre);
                    fs.touch(nombre);
                    break;
                case 5:
                    System.out.print("Introduzca el nombre del directorio: ");
                    nombre = sc.nextLine();
                    System.out.println("cd "+nombre);
                    fs.cd(nombre);
                    break;
                case 6:
                    System.out.println("cd .. ");
                    fs.cdDotDot();
                    break;
            }
        } while (opcion!=7);
        sc.close();

    }
}