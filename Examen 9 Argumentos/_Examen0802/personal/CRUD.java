package personal;

import java.io.IOException;
import java.util.ArrayList;

public interface CRUD<T> {
    public ArrayList<T> solicitarTodos() throws IOException;
    public T solicitarUno(int id) throws IOException;
    public T anadir(T data);
    public T actualizar(int id, T data) throws IOException;
    public T borrar(int id);
}
