package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.FileModel;
import util.DBConnection;

public class FileDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Upload File
    public boolean uploadFile(String fileName, String fileType, InputStream inputStream) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query = "INSERT INTO files(file_name, file_type, file_data) VALUES (?, ?, ?)";

            ps = con.prepareStatement(query);

            ps.setString(1, fileName);
            ps.setString(2, fileType);
            ps.setBlob(3, inputStream);

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Get Single File
    public ResultSet getFileByName(String fileName) {

        try {

            con = DBConnection.getConnection();

            String query = "SELECT * FROM files WHERE file_name=?";

            ps = con.prepareStatement(query);

            ps.setString(1, fileName);

            rs = ps.executeQuery();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    // Delete File
    public boolean deleteFile(String fileName) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();

            String query = "DELETE FROM files WHERE file_name=?";

            ps = con.prepareStatement(query);

            ps.setString(1, fileName);

            int row = ps.executeUpdate();

            if(row > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Show All Files
    public List<FileModel> getAllFiles() {

        List<FileModel> list = new ArrayList<FileModel>();

        try {

            con = DBConnection.getConnection();

            String query = "SELECT * FROM files";

            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next()) {

                FileModel file = new FileModel();

                file.setId(rs.getInt("id"));
                file.setFileName(rs.getString("file_name"));
                file.setFileType(rs.getString("file_type"));

                list.add(file);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Check File Exists
    public boolean fileExists(String fileName) {

        boolean exists = false;

        try {

            con = DBConnection.getConnection();

            String query = "SELECT * FROM files WHERE file_name=?";

            ps = con.prepareStatement(query);

            ps.setString(1, fileName);

            rs = ps.executeQuery();

            if(rs.next()) {
                exists = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return exists;
    }
}