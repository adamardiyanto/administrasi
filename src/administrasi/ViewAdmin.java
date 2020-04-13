/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasi;

import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADAM ARDI
 */
public class ViewAdmin extends JFrame {
    
JTable table;
DefaultTableModel tableModel;
JScrollPane scrollPane;
Object namaKolom[] = {"#","ID","Judul","Tipe","Episode","Genre","Status","Rating"};

JLabel lJudul = new JLabel("Judul");
JTextField tfJudul = new JTextField();
JTextField tfSearch = new JTextField();
JButton btnSearch = new JButton("cari");
JLabel lTipe = new JLabel("Tipe");
JTextField tfTipe = new JTextField();
JLabel lStatus = new JLabel("Status");
String[] namaStatus =
            {"selesai","Belum Selesai"};
JComboBox cmbStatus = new JComboBox(namaStatus);
JLabel lEpisode = new JLabel("Episode");
JTextField tfEpisode = new JTextField();
JLabel lRating = new JLabel("Rating");
JTextField tfRating = new JTextField();
JLabel lGenre = new JLabel("Genre");
JTextField tfGenre = new JTextField();
JButton btnRefresh = new JButton("Refresh");
JButton btnCreate = new JButton("Create");
JButton btnUpdate = new JButton("Update");
JButton btnDelete = new JButton("Delete");
JButton btnExit= new JButton("Exit");

public ViewAdmin(){
tableModel = new DefaultTableModel(namaKolom,0);
table = new JTable(tableModel);
scrollPane = new JScrollPane(table);

setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
setLayout(null);
setSize(800, 600);

add(scrollPane);
scrollPane.setBounds(20,20,760,200);
scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

add(lJudul);
lJudul.setBounds(20, 225, 100, 20);
add(tfJudul);
tfJudul.setBounds(20, 250, 200, 20);
add(tfSearch);
tfSearch.setBounds(420, 250, 200, 20);
add(btnSearch);
btnSearch.setBounds(620, 250, 80, 20);
add(lTipe);
lTipe.setBounds(20, 280, 100, 20);
add(tfTipe);
tfTipe.setBounds(20, 310, 100, 20);
add(lStatus);
lStatus.setBounds(140, 280, 100, 20);
add(cmbStatus);
cmbStatus.setBounds(140, 310, 100, 20);
add(lEpisode);
lEpisode.setBounds(20, 340, 100, 20);
add(tfEpisode);
tfEpisode.setBounds(20, 370, 100, 20);
add(lRating);
lRating.setBounds(140, 340, 100, 20);
add(tfRating);
tfRating.setBounds(140, 370, 100, 20);
add(lGenre);
lGenre.setBounds(20, 410, 100, 20);
add(tfGenre);
tfGenre.setBounds(20, 440, 130, 20);
add(btnRefresh);
btnRefresh.setBounds(220, 440, 80, 20);
add(btnCreate);
btnCreate.setBounds(320, 440, 80, 20);
add(btnUpdate);
btnUpdate.setBounds(420, 440, 80, 20);
add(btnDelete);
btnDelete.setBounds(520, 440, 80, 20);
add(btnExit);
btnExit.setBounds(620, 440, 80, 20);


}

public String getJudul(){
    return tfJudul.getText();
}
public String getTipe(){
    return tfTipe.getText();
}
public String getStatus(){
    return (String) cmbStatus.getSelectedItem();
}
public String getEpisode(){
    return tfEpisode.getText();
}
public String getRating(){
    return tfRating.getText();
}
public String getGenre(){
    return tfGenre.getText();
}



}
