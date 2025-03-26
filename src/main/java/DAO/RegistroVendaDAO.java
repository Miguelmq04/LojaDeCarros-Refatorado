
package DAO;

import Entities.RegistroVenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


public class RegistroVendaDAO {
    /**
     * Realiza a operação de inserção de um objeto do tipo RegistroVenda no banco de dados.
     * @param registroVenda O objeto registrovenda que será registrado no banco de dados.
     */
    public void cadastrarVenda(RegistroVenda registroVenda){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(registroVenda);
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
     * Realiza uma consulta no banco deados, retornando uma lista de objetos do tipo RegistroVenda.
     * @return uma lista de objetos do tipo RegistroVenda.
     */
    public List<RegistroVenda> getVenda(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select rv from RegistroVenda rv join fetch rv.veiculos");
            List<RegistroVenda> veiculoVendaLista = consulta.getResultList();
            return veiculoVendaLista;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
}
