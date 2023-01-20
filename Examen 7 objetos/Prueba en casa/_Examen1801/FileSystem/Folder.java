package FileSystem;

/**
 * clase Folder
 ***** Hereda de la clase File e implementa la interfaz FolderEntry
 * 
 ***** La clase Folder mantiene una lista de archivos/carpetas así como una
 ***** referencia a la carpeta que la contiene
 * 
 ***** La clase Folder al heredar de la clase File hereda sus propiedades
 ***** name, level y createdAt
 * 
 ***** Además dispondrá de un array donde se irán añadiendo los archivos que están
 ***** dentro de la carpeta
 * 
 ***** Debe implementar la interfaz FolderEntry
 * 
 ***** Debe tener un constructor que recibirá la carpeta que la contiene, en el caso
 * de que sea la carpeta raiz, recibirá null en la referencia a la carpeta padre
 * Además el constructor recibirá el nombre de la carpeta así como el nivel en
 * el que se encuentra la carpeta (Nivel 0 es la carpeta raiz, Nivel 1 las
 * carpetas hijas de la carpeta raiz, y así sucesivamente)
 * 
 * Ejemplo de llamada al constructor:
 * Folder root = new Folder(null, "Raiz", 0);
 * 
 */

public class Folder extends File implements FolderEntry {
	private File[] list = new File[100];
	private Folder parent;

	public Folder(Folder parent, String folderName, int level) {
		super(folderName, level);
		this.parent = parent;
	}

	@Override
	public Folder getParent() {
		return parent;
	}

	@Override
	public boolean isFolderFull() {
		if (this.getFileCount() == 100)
			return true;
		return false;
	}

	@Override
	public int getFileCount() {
		int cont = 0;
		for (int i = 0; i < 100; i++) {
			if (list[i] != null)
				cont++;
		}
		return cont;
	}

	@Override
	public boolean isFileInFolder(String fileName) {
		boolean isFile = false;
		for (int i = 0; i < 100 && !isFile; i++) {
			if (list[i].getFileName().equals(fileName)) {
				isFile = true;
			}
		}
		return isFile;
	}

	@Override
	public Folder addFolder(String folderName) throws FolderIsFullException, FileAlreadyExistsException {
		Folder newFolder = new Folder(this, folderName, this.getLevel() + 1);
		int space = this.findSpace();
		if (space != -1)
			list[space] = newFolder;
		return this;
	}

	@Override
	public File addFile(String fileName) throws FolderIsFullException, FileAlreadyExistsException {
		File newFile = new File(fileName, this.getLevel());
		int space = this.findSpace();
		if (space != -1)
			list[space] = newFile;
		return null;
	}

	@Override
	public File removeFile(String fileName) throws FileDoesNotExistsException {
		int i = 0;
		boolean deleted = false;
		while (i < 100 && !deleted) {
			if (list[i].getFileName().equals(fileName)) {
				list[i] = null;
			}
		}
		return null;
	}

	@Override
	public File removeFolder(String folderName, boolean recursive)
			throws FileDoesNotExistsException, FolderIsNotEmptyException {
		int i = 0;
		boolean deleted = false;
		while (i < 100 && !deleted) {
			if (list[i].getFileName().equals(folderName)) {
				list[i] = null;
			}
		}
		return null;
	}

	@Override
	public Folder getFolder(String folderName) throws FileDoesNotExistsException {
		int i = 0;
		boolean find = false;
		while (i < 100 && !find) {
			if (list[i].getFileName().equals(folderName)) {
				return (Folder) list[i];
			}
			i++;
		}
		return null;
	}

	@Override
	public String toString() {
		String spaces = "";
		for (int i = 0; i <= this.getLevel(); i++)
			spaces += " ";
		return spaces + "|_[" + this.getFileName() + "]";
	}

	private int findSpace() {
		int pos = -1;
		for (int i = 0; i < 100 && pos == -1; i++) {
			if (list[i] == null)
				pos = i;
		}
		return pos;
	}
}