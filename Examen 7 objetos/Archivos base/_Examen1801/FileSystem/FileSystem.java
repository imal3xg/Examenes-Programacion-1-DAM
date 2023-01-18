package FileSystem;

public class FileSystem {
    private Folder root = new Folder(null, "root", 0);
    private Folder currentFolder = root;

    public String getPrompt(){
        return this.currentFolder.getName();
    }
    public void cd(String folderName){
        try {
            var folder = this.currentFolder.getFolder(folderName);    
            this.currentFolder = folder;
        } catch (FileDoesNotExistsException e) {
            System.out.println("Error. El directorio no existe");
        }
    }

    public void cdDotDot(){
        if(this.currentFolder.getParent()!=null)
            this.currentFolder = this.currentFolder.getParent();
        else
            System.out.println("Error. Ya estás en el directorio raiz");
    }

    public void mkDir(String folderName){
        try {
            this.currentFolder.addFolder(folderName);
        } 
        catch(FileAlreadyExistsException e){
            System.out.println("Error. El directorio ya existe");
        }
        catch (FolderIsFullException e) {
            System.out.println("Error. El directorio está completo");
        }
    }

    public void rmDir(String folderName, boolean recursive){
        try {
            this.currentFolder.removeFolder(folderName, recursive);    
        } catch (FileDoesNotExistsException e) {
            System.out.println("Error. El directorio no existe");
        } catch (FolderIsNotEmptyException e){
            System.out.println("Error. El directorio no está vacío");
        }
    }

    public void touch(String fileName){
        try {
            this.currentFolder.addFile(fileName);
        } catch (FolderIsFullException e) {
            System.out.println("Error. El directorio está lleno");
        } catch (FileAlreadyExistsException e) {
            System.out.println("Error. El archivo ya existe");
        }
    }

    public void tree(){
        System.out.print(this.currentFolder);
    }

}
