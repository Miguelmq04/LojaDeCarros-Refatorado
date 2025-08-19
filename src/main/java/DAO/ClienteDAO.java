
package DAO;

import Entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


public class ClienteDAO {
    /**
     * Realiza a inserção de um objeto do tipo Cliente no banco de dados.
     * @param cliente O objeto tipo cliente que será inserido no banco de dados.
     */
    public void cadastrarCliente(Cliente cliente){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cliente);
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
     * Realiza a busca no banco de dados e retorna uma lista de objetos do tipo Cliente.
     * @return Uma lista de objetos do tipo Cliente.
     */
    public List<Cliente> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select c from Cliente c");
            List<Cliente> listaCliente = consulta.getResultList();
            return listaCliente;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
}
