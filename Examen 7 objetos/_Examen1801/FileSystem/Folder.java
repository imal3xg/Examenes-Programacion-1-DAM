package FileSystem;

/**
 * clase Folder
 * Hereda de la clase File e implementa la interfaz FolderEntry
 * La clase Folder mantiene una lista de archivos/carpetas así como una
 * referencia a la carpeta que la contiene
 * La clase Folder al heredar de la clase File hereda sus propiedades
 * name, level y createdAt
 * Además dispondrá de un array donde se irán añadiendo los archivos que están
 * dentro de la carpeta
 * Debe implementar la interfaz FolderEntry
 * Debe tener un constructor que recibirá la carpeta que la contiene, en el caso
 * de que sea la carpeta raiz, recibirá null en la referencia a la carpeta padre
 * Además el constructor recibirá el nombre de la carpeta así como el nivel en
 * el que se encuentra la carpeta (Nivel 0 es la carpeta raiz, Nivel 1 las
 * carpetas hijas de la carpeta raiz, y así sucesivamente)
 * Ejemplo de llamada al constructor:
 * Folder root = new Folder(null, "Raiz", 0);
 * 
 */
public class Folder extends File implements FolderEntry {
    private Folder parent;
    private File[] files = new File[100];

    public Folder(String name) {
        super(name);

    }

    public Folder(Folder parent, String name, int level) {
        super(name, level);
        this.parent = parent;
    }

    @Override
    public String toString() {
        String spaces = "";
        for (int i = 0; i <= this.getLevel(); i++) {
            spaces += "_";
        }
        String ret = "|" + spaces + "[" + this.getName() +
                "]";
        return ret;
    }

    @Override
    public Folder getParent() {
        return this.parent;
    }

    @Override
    public boolean isFolderFull() {
        return false;
    }

    @Override
    public int getFileCount() {
        return 0;
    }

    @Override
    public boolean isFileInFolder(String fileName) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Folder addFolder(String folderName) throws FolderIsFullException, FileAlreadyExistsException {
        Folder newFolder;
        newFolder = new Folder(this, folderName, this.getLevel() + 1);
        int space = freeSpace();
        if (space != -1) {
            files[space] = newFolder;
            return newFolder;
        }
        return null;
    }

    @Override
    public File addFile(String fileName) throws FolderIsFullException, FileAlreadyExistsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public File removeFile(String fileName) throws FileDoesNotExistsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public File removeFolder(String folderName, boolean recursive)
            throws FileDoesNotExistsException, FolderIsNotEmptyException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Folder getFolder(String folderName) throws FileDoesNotExistsException {
        // TODO Auto-generated method stub
        return null;
    }

    private int freeSpace() {
        int i = 0;
        while (i < 100 && this.files[i] != null) {
            i++;
        }
        return (i >= 0 && i < 100) ? i : -1;
    }
}