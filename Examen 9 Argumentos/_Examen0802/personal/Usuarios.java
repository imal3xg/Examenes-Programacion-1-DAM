package personal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Usuarios implements CRUD<Usuario> {
    private String file;
    private int nextId;

    public Usuarios(String file) throws Exception {
        this.file = file;
        File _file = new File(file);
        if (!_file.exists())
            _file.createNewFile();
        // (5 puntos) TODO tienes que leer el archivo para obtener el siguiente id
        // disponible...
        // nextId almacena el siguiente id a configurar para cuando se añada un nuevo
        // usuario
        // Por ejempo: Si tienes x usuarios y el último es el usuario 8 entonces nextId
        // debe valer 9
        // Podrías hacer uso de la función solicitarTodos "es solo una sugerencia"
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<Usuario> userList = new ArrayList<>();
            userList = solicitarTodos();
            int max = 0;
            for (Usuario user : userList) {
                if (user.getId() > max)
                    max = user.getId();
            }
            nextId = max + 1;
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getFile() {
        return file;
    }

    @Override
    public ArrayList<Usuario> solicitarTodos() throws IOException {
        // (10 puntos) TODO Tienes que devolver un ArrayList conteniendo todos los
        // usuarios del archivo

        ArrayList<Usuario> userList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            do {
                Usuario user = new Usuario(line);
                userList.add(user);
                line = br.readLine();
            } while (line != null);
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public Usuario solicitarUno(int id) {
        // (10 puntos) TODO Tienes que poder buscar en el archivo al usuario cuyo id se
        // suministra
        // y devolver un objeto Usuario
        // si el usuario no está debe devolver null
        ArrayList<Usuario> userList = new ArrayList<>();
        try {
            userList = solicitarTodos();
            for (Usuario user : userList) {
                if (user.getId() == id)
                    return user;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Usuario anadir(Usuario datos) {
        // (20 puntos) TODO Tienes que poder añadir un usuario al archivo
        // Debes comprobar que el usuario no existe (no puede haber dos usuarios con el
        // mismo email)
        // En el caso de que ya existiera debe devolver un null
        // Si el usuario no existe entonces podemos añadir al usuario
        // Para que puedas añadir al usuario al final del archivo debes pasar un true
        // cuando llames
        // al constructor de new FileWriter(nombre, true)
        ArrayList<Usuario> userList = new ArrayList<>();
        try {
            userList = solicitarTodos();
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.file, true));
            if (userList.contains(datos))
                System.out.println("Ya está creado ese usuario previamente");
            else {
                datos.setId(nextId);
                nextId++;
                bw.write("\n" + datos.serializar());
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }

    @Override
    public Usuario actualizar(int id, Usuario data) throws IOException {
        // (25 puntos) TODO Tienes que devolver los datos del usuario actualizados
        // Devolverá null si el usuario no existe en el fichero (si no se encuentra ese
        // id)
        // Si el usuario se encuentra en el archivo entonces modificamos ese usuario en
        // esa posición
        // del archivo.
        // Ayuda: Tienes que renombrar el archivo original añadiéndole .tmp al final
        // Luego abres en modo lectura el archivo temporal y abres en modo escritura el
        // archivo original
        // Vas escribiendo las líneas del archivo temporal y cuando llegues al usaurio
        // que quieres
        // modificar escribes los datos de ese usuario
        // Sigue hasta que consumas todas las líneas del archivo temporal
        // Al final del proceso debes borrar el archivo temporal
        // Con esto habrás modificado los datos de ese usuario
        try {
            File temp = new File(file);
            temp.renameTo(new File(this.file + "_temp"));
            temp = new File(file + "_temp");
            BufferedReader br = new BufferedReader(new FileReader(temp));
            File newFile = new File(file);
            newFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            String line = br.readLine();
            do {
                Usuario actualUser = new Usuario(line);
                if (actualUser.getId() == id)
                    bw.write(line + "\n");
                else
                    bw.write(data.serializar() + "\n");
                line = br.readLine();
            } while (line != null);
            bw.close();
            br.close();
            temp.delete();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Usuario borrar(int id) {
        // (25 puntos) TODO Tienes que devolver los datos del usuario borrado
        // Devolverá null si el usuario no existe en el fichero (si no se encuentra ese
        // id)
        // Si el usuario se encuentra en el archivo entonces eliminamos esa línea del
        // archivo
        // Ayuda: Tienes que renombrar el archivo original añadiéndole .tmp al final
        // Luego abres en modo lectura el archivo temporal y abres en modo escritura el
        // archivo original
        // Vas escribiendo las líneas del archivo temporal y cuando llegues al usaurio
        // que quieres
        // borrar te saltas la escritura de esa línea
        // Sigue hasta que consumas todas las líneas del archivo temporal
        // Al final del proceso debes borrar el archivo temporal
        // Con esto habrás borrado al usuario
        try {
            try {
                File temp = new File(file);
                temp.renameTo(new File(this.file + "_temp"));
                temp = new File(file + "_temp");
                BufferedReader br = new BufferedReader(new FileReader(temp));
                File newFile = new File(file);
                newFile.createNewFile();
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                String line = br.readLine();
                do {
                    Usuario actualUser = new Usuario(line);
                    if (actualUser.getId() != id)
                        bw.write(line + "\n");
                    line = br.readLine();
                } while (line != null);
                bw.close();
                br.close();
                temp.delete();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
