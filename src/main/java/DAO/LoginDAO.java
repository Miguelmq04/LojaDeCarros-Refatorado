
package DAO;

import Entities.LoginFuncionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;


public class LoginDAO {
    EntityManager em = JPAUtil.getEntityManager();
    
    public LoginFuncionario loginFuncionario(LoginFuncionario login){
        LoginFuncionario usuario = null;
        try{
            Query loginQuery = em.createQuery("SELECT u FROM LoginFuncionario u WHERE u.login = :login AND u.senha = :senha");
            loginQuery.setParameter("login", login.getLogin());
            loginQuery.setParameter("senha", login.getSenha());
            
            usuario = (LoginFuncionario) loginQuery.getSingleResult();
        }
        catch(NoResultException e){
            System.out.println("Usuário ou senha inválidos.");
        }
        catch(Exception e){
            System.out.println("Erro ao tentar logar usuário: " + e.getMessage());
            usuario = null;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
        
        return usuario;
    }
}

