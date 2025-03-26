
package DAO;

import Entities.LoginFuncionario;
import jakarta.persistence.EntityManager;


public class LoginFuncionarioDAO {
    /**
     * Realiza a inserção dos dados de login do funcionario no banco de dados.
     * @param loginFuncionario O objeto tipo loginFuncionario que será inserido no banco de dados.
     */
    public void cadastrarLogin(LoginFuncionario loginFuncionario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(loginFuncionario);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
}
