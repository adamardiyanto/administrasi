/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasi;

/**
 *
 * @author ADAM ARDI
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelAdmin {
     static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kuispbo";
    static final String USER = "root";
    static final String PASS = "qwerty123";
    
    Connection koneksi;
    Statement statement;
    int d =0;
    public ModelAdmin () {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
        }
    public int getBanyakData() {
        
        try{
            int jmlData = 0;
            statement = koneksi.createStatement();
            String query = "SELECT *from `admin`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }
    
String[][] readAdmin() {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakData()][8];
            String query = "Select * from `admin`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("#");
                data[jmlData][1] = resultSet.getString("ID");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tipe");
                data[jmlData][4] = resultSet.getString("Episode");
                data[jmlData][5] = resultSet.getString("Genre");
                data[jmlData][6] = resultSet.getString("Status");
                data[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }
    

 public void insertAdmin(String judul, String tipe, String episode, String genre, String status, String rating) {
          int banyak = getBanyakData();
          d++;
     try{
        String query = "INSERT INTO `admin`(`#`,`ID`,`Judul`,`Tipe`,`Episode`,`Genre`,`Status`,`Rating`) VALUES ('"+banyak+"','"+d+"','"+judul+"','"+tipe+"','"+episode+"','"+genre+"','"+status+"','"+rating+"')";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil Ditambahkan");
        JOptionPane.showMessageDialog(null,"data berhasil ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }
 
 
void deleteAdmin(String id) {
        try{
            String query = "DELETE FROM `admin` WHERE `ID` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "berhasil dihapus");
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }


 int getBanyakCari(String cari) {
        
        try{
            int jmlData = 0;
            statement = koneksi.createStatement();
            String query = "SELECT *from `admin` WHERE `Judul` = '%"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return 0;
        }
    }

String[][] searchAdmin(String cari) {
        try{
            int jmlData = 0;
            String data[][]=new String[getBanyakCari(cari)][8];
            String query = "Select * from `admin` WHERE `Judul` LIKE '%"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[jmlData][0] = resultSet.getString("#");
                data[jmlData][1] = resultSet.getString("ID");
                data[jmlData][2] = resultSet.getString("Judul");
                data[jmlData][3] = resultSet.getString("Tipe");
                data[jmlData][4] = resultSet.getString("Episode");
                data[jmlData][5] = resultSet.getString("Genre");
                data[jmlData][6] = resultSet.getString("Status");
                data[jmlData][7] = resultSet.getString("Rating");
                jmlData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL error");
            return null;
        }
    }

    public void updateAdmin(String id,String judul, String tipe, String episode, String genre, String status, String rating) {
          
     try{
        String query = "UPDATE `admin` SET `Judul`='"+judul+"', `Tipe`='"+tipe+"',`Episode`='"+episode+"',`Genre`='"+genre+"',`Status`='"+status+"',`Rating`='"+rating+"' WHERE `ID` = '"+id+"'";
        statement = (Statement) koneksi.createStatement();
        statement.executeUpdate(query);
        System.out.println("Berhasil diupdate");
        JOptionPane.showMessageDialog(null,"data berhasil diupdate");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
        
    }


}
