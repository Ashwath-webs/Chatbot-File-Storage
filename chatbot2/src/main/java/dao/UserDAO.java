package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class UserDAO {

    public boolean register(String username, String password) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(username, password) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            int row = ps.executeUpdate();
            if(row > 0) status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean login(String username, String password) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}