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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ControllerAdmin {
    ModelAdmin modelAdmin;
    ViewAdmin viewAdmin;
    
    
    public ControllerAdmin(ModelAdmin modelAdmin, ViewAdmin viewAdmin){
        this.modelAdmin = modelAdmin;
        this.viewAdmin = viewAdmin;
        
        if (modelAdmin.getBanyakData() != 0) { 
            String dataAdmin[][] = modelAdmin.readAdmin(); 
            viewAdmin.table.setModel((new JTable(dataAdmin, viewAdmin.namaKolom)).getModel());
        
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        viewAdmin.btnCreate.addActionListener((ActionEvent e) -> {
            if (viewAdmin.getJudul().equals("") || viewAdmin.getTipe().equals("") ||viewAdmin.getEpisode().equals("")||viewAdmin.getGenre().equals("") || viewAdmin.getStatus().equals("") ||viewAdmin.getRating().equals("")) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String judul = viewAdmin.getJudul();
                String tipe = viewAdmin.getTipe();
                String episode = viewAdmin.getEpisode();
                String genre = viewAdmin.getGenre();
                String status = viewAdmin.getStatus();
                String rating = viewAdmin.getRating();
                
                modelAdmin.insertAdmin(judul,  tipe,  episode,  genre,  status,  rating);
                
                viewAdmin.tfJudul.setText("");
                viewAdmin.tfTipe.setText("");
                viewAdmin.tfEpisode.setText("");
                viewAdmin.tfGenre.setText("");
                viewAdmin.tfRating.setText("");
                
            
            }
        });
        
        viewAdmin.table.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e){ 
               int baris = viewAdmin.table.getSelectedRow();
               int kolom = viewAdmin.table.getSelectedColumn();
               String dataterpilih = viewAdmin.table.getValueAt(baris, 1).toString();
               
              String judul = viewAdmin.table.getValueAt(baris, 2).toString();
              viewAdmin.tfJudul.setText(judul);
              String tipe = viewAdmin.table.getValueAt(baris, 3).toString();
              viewAdmin.tfTipe.setText(tipe);
              String episode = viewAdmin.table.getValueAt(baris, 4).toString();
              viewAdmin.tfEpisode.setText(episode);
              String genre = viewAdmin.table.getValueAt(baris, 5).toString();
              viewAdmin.tfGenre.setText(episode);
              String status = viewAdmin.table.getValueAt(baris, 6).toString();
              viewAdmin.cmbStatus.setSelectedItem(status);
              String rating = viewAdmin.table.getValueAt(baris, 7).toString();
              viewAdmin.tfRating.setText(rating);
              
              viewAdmin.btnUpdate.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent f) {
                       String id= dataterpilih;
                       
                       String judulU = viewAdmin.getJudul();
                       String tipeU = viewAdmin.getTipe();
                       String episodeU = viewAdmin.getEpisode();
                       String genreU = viewAdmin.getGenre();
                       String statusU = viewAdmin.getStatus();
                       String ratingU = viewAdmin.getRating();
                       
                       modelAdmin.updateAdmin(id, judulU, tipeU, episodeU, genreU, statusU, ratingU);
                       
                 
                       
                     
                   }
               });
              
               
               viewAdmin.btnDelete.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent f) {
                       int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus ini "+ dataterpilih+"?", "Pilih Opsi...",JOptionPane.CANCEL_OPTION);
//
                            if(input == 0) {
                                modelAdmin.deleteAdmin(dataterpilih);
                                    String dataterpilih="";
                            } else {
                             JOptionPane.showMessageDialog(null,"Tidak Jadi Dihapus");
                        }   }
               });
//              
           }
          
        });
        
        
        
        viewAdmin.btnRefresh.addActionListener((ActionEvent e) -> {
            String dataAdmin[][] = modelAdmin.readAdmin();
                   viewAdmin.table.setModel(new JTable(dataAdmin, viewAdmin.namaKolom).getModel());
                   
                   viewAdmin.tfJudul.setText("");
                       viewAdmin.tfTipe.setText("");
                       viewAdmin.tfEpisode.setText("");
                       viewAdmin.tfGenre.setText("");
                       viewAdmin.tfRating.setText("");
                       
                   
        });
        
         viewAdmin.btnSearch.addActionListener((ActionEvent e) -> {
             String cari = viewAdmin.tfSearch.getText();
            String dataCariAdmin[][] = modelAdmin.searchAdmin(cari);
                   viewAdmin.table.setModel(new JTable(dataCariAdmin, viewAdmin.namaKolom).getModel());
        });
        
        
    }
    

}
