package FileSystem;

public interface FileEntry {
    /**
     * Indica si el archivo es un directorio
     * @return si es un objeto de la clase File devuelve false
     * si es un objeto de la clase Folder devuelve true
     */
    public boolean isDirectory();
    /**
     * Devuelve el nombre del archivo
     * @return cadena conteniendo el nombre del archivo
     */
    public String getName();

    /**
     * Imprime el archivo en pantalla con el siguiente formato:
     * dependiendo del nivel se imprimirán 2*level espacios 
     * y a continuación el nombre del archivo y la fecha de creación
     * La fecha de creación sale con el formato Tue Jan 17 19:54:28 CET 2023 cuando se convierte a String
     * Ej: (archivo juan en el nivel 0)
     * |_juan Tue Jan 17 19:54:28 CET 2023
     * 
     * Otro Ej. (archivo juan en el nivel 2)
     *     |_pepe Tue Jan 17 19:54:28 CET 2023
     * 
     * @return cadena de texto que representa al archivo
     */
    public String toString();
}
