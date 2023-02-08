package personal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface CRUD<T> {
    public ArrayList<T> solicitarTodos() throws FileNotFoundException, IOException;
    public T solicitarUno(int id);
    public T anadir(T data) throws IOException;
    public T actualizar(int id, T data) throws IOException;
    public T borrar(int id) throws IOException;
}
