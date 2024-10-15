/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author Muzime
 */
public class BDConection implements Serializable{
    private  String Host;
    private  String BD;
    private  String user;
    private  String password;
    private  String porta;

    public BDConection() {
        this.Host = "localhost"; // 127.0.0.1 = localhost
        this.porta = "3306";
        this.BD = "estudante";
        this.user = "root";
        this.password = "4567";
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        BDConection bDconexao = new BDConection();
        return DriverManager.getConnection("jdbc:mysql://" + bDconexao.Host + ":" + bDconexao.porta + "/" + bDconexao.BD + "?user="+bDconexao.user+"&password="+bDconexao.password+"&noAccessToProcedureBodies=true");
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
    
    
}
