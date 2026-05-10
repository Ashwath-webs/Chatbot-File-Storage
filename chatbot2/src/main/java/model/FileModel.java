package model;

public class FileModel {

    private int id;
    private String fileName;
    private String fileType;

    // Empty constructor
    public FileModel() {
    }

    // Parameterized constructor (optional)
    public FileModel(int id, String fileName, String fileType) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for File Name
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // Getter and Setter for File Type
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    // To display object info (useful for debugging)
    @Override
    public String toString() {
        return "FileModel [id=" + id +
               ", fileName=" + fileName +
               ", fileType=" + fileType + "]";
    }
}