/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import DAO.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author daniel
 */
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();
    
    public Usuario getUsuario() {
        
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        
        this.usuario = usuario;
    }
    
    public String verificarDatos() throws Exception {
        
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario usr;
        String resultado;
        
        try {
            usr = usuDAO.verificarDatos(this.usuario);
            
            if(usr != null){
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usr);
                
                resultado = "exito";
            } else {
                resultado = "error";
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
