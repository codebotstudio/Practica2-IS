/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Util.HibernateUtil;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author daniel
 */
public class UsuarioDAO {
    
    private Session session;
    
    public Usuario verificarDatos(Usuario usuario) throws Exception {
        Usuario usr = null;
        
        try {
            
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Usuario WHERE username = '" + usuario.getUsername() + "' AND password = '" + usuario.getPassword() + "'";
            Query query = session .createQuery(hql);
            
            if (!query.list().isEmpty()) {
                usr = (Usuario) query.list().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usr;
    }
}
