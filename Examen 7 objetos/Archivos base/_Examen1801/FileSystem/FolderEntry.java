package FileSystem;

public interface FolderEntry {
    /**
     * Función que devuelve la carpeta que contiene a dicha carpeta
     * Es un getter de la propiedad parent de la clase Folder
     * @return devuelve un objeto de tipo Folder
     * 
     */
    public Folder getParent();

    /**
     * Indica si la carpeta está llena
     * El máximo número de elementos que una carpeta puede tener es 100
     * @return true si está llena, false si no está llena
     */
    public boolean isFolderFull();

    /**
     * Devuelve el número de elementos que contiene la carpeta
     * @return devuelve un entero conteniendo el número de elementos que contienee
     */
    public int getFileCount();

    /**
     * Devuelve si un archivo/carpeta está en la carpeta
     * @param fileName nombre del archivo/carpeta
     * @return true, si la carpeta contiene un archivo/carpeta con ese nombre
     */
    public boolean isFileInFolder(String fileName);

    /**
     * Añade una carpeta a la carpeta
     * @param folderName nombre de la carpeta a añadir
     * @return devuelve la carpeta que ha añadido
     * @throws FolderIsFullException lanza esta excepción cuando la carpeta está llena
     * @throws FileAlreadyExistsException lanza esta excepción si la carpeta ya existe
     */
    public Folder addFolder(String folderName) throws FolderIsFullException, FileAlreadyExistsException;

    /**
     * Añade un archivo a la carpeta
     * @param fileName nombre del archivo a añadir
     * @return Devuelve el archivo que se ha añadido
     * @throws FolderIsFullException lanza esta excepción si la carpeta está llena
     * @throws FileAlreadyExistsException lanza esta excepción si el archivo ya existe en la carpeta
     */
    public File addFile(String fileName) throws FolderIsFullException, FileAlreadyExistsException;

    /**
     * Borra un archivo de la carpeta
     * @param fileName nombre del archivo a borrar
     * @return Devuelve el archivo que se ha borrado de la carpeta
     * @throws FileDoesNotExistsException lanza esta excepción si el archivo no existe en la carpeta
     */
    public File removeFile(String fileName) throws FileDoesNotExistsException;

    /**
     * Borra una carpeta de la carpeta
     * @param folderName nombre de la carpeta a borrar
     * @param recursive si es true, se borra la carpeta, si es false solo se borra si no contiene archivos
     * @return Devuelve la carpeta que se ha borrado
     * @throws FileDoesNotExistsException lanza esta excepción si no existe la carpeta
     * @throws FolderIsNotEmptyException lanza esta excepción si la carpeta no está vacía y se intenta
     * borrar pasando recursive a false
     */
    public File removeFolder(String folderName, boolean recursive) throws FileDoesNotExistsException, FolderIsNotEmptyException;

    /**
     * Devuelve la carpeta cuyo nombre se suministra
     * @param folderName nombre de la carpeta a devolver
     * @return devuelve la carpeta 
     * @throws FileDoesNotExistsException lanza esta excepción si la carpeta no existe
     */
    public Folder getFolder(String folderName) throws FileDoesNotExistsException;

    /**
     * Devuelve una cadena de texto indicando el nombre de la carpeta así como los elementos que contiene
     * De la siguiente forma versión 1 (A incluir en la fase 2):
     * Ej: Carpeta folder1 en el nivel 0
     * |_(folder1) 
     * Otro Ej: Carpeta folder2 en el nivel 2
     *     |_(folder2)
     * Versión 2 (A incluir en la fase 3):
     * Si la carpeta tiene elementos (archivos y carpetas tendrá que mostrarlos también de la siguiente
     * forma:
     * Ej:
     * |_(folder1)   <-- Date cuenta que está en el nivel 0
     *   |_file1 Tue Jan 17 19:54:28 CET 2023   <-- Date cuenta que está en el nivel 1
     *   |_(folder2) <-- Date cuenta que está en el nivel 1
     *     |_file2 Tue Jan 17 19:54:28 CET 2023  <-- Date cuenta que está en el nivel 2
     *     |_file3 Tue Jan 17 19:54:28 CET 2023  <-- Date cuenta que está en el nivel 2
     *   |_(folder3)  <-- Date cuenta que está en el nivel 1
     *     |_file4 Tue Jan 17 19:54:28 CET 2023  <-- Date cuenta que está en el nivel 2
     *     |_file5 Tue Jan 17 19:54:28 CET 2023  <-- Date cuenta que está en el nivel 2
     * @return una cadena de texto conteniendo la estructura de la carpeta
     */
    public String toString();
}
