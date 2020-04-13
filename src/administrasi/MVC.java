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
public class MVC {
    ModelAdmin modelAdmin = new ModelAdmin();
    ViewAdmin viewAdmin= new ViewAdmin();
    ControllerAdmin controllerAdmin = new ControllerAdmin(modelAdmin, viewAdmin);
    
    
}
