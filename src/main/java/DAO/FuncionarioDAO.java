
package DAO;

import Entities.Funcionarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {
    /**
     * Realiza a inserção de um objeto do tipo funcionário no banco de dados.
     * @param funcionario O objeto do tipo funcionário que será inserido no banco de dados.
     */
    public void cadastrarFuncionario(Funcionarios funcionario){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(funcionario);
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
    
    /**
     * Realiza uma busca no banco de dados e retorna uma lista de objetos do tipo funcionário.
     * @return Uma lista de objetos do tipo funcionário.
     */
    public List<Funcionarios> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        
        List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
        try{
            Query consultaFuncionario = em.createQuery("select f from Funcionarios f left join fetch f.cargo c");
            funcionarios  = consultaFuncionario.getResultList();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
        
        return funcionarios;
    }
}
