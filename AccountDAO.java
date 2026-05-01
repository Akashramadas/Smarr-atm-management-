package dao;
import java.sql.*;
import util.DBConnection;

public class AccountDAO {

    public void createAccount(String name, int pin, double balance) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO accounts(name, pin, balance) VALUES (?, ?, ?)");
        ps.setString(1, name);
        ps.setInt(2, pin);
        ps.setDouble(3, balance);
        ps.executeUpdate();
        con.close();
    }

    public double getBalance(int acc, int pin) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT balance FROM accounts WHERE acc_no=? AND pin=?");
        ps.setInt(1, acc);
        ps.setInt(2, pin);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) return rs.getDouble("balance");
        return -1;
    }
}
