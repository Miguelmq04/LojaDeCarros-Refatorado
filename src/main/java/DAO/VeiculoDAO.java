
package DAO;


import Entities.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


public class VeiculoDAO {
    /**
     * Realiza a inserção de um bojeto do tipo veículo no banco de dados.
     * @param veiculo O objeto do tipo veículo que será inserido no banco de dados.
     */
    public void cadastrarVeiculo(Veiculo veiculo){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(veiculo);
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
     * Realiza uma consulta no banco de dados e retorna uma lista de objeto do tipo veículo.
     * @return Uma lista de objeto do tipo veículo
     */
    public List<Veiculo> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Query consulta = em.createQuery("select v from Veiculo v left join fetch v.registroVeiculo r");
            List<Veiculo> veiculoLista = consulta.getResultList();
            return veiculoLista;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    public void excluirVeiculo(int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Veiculo veiculo = em.find(Veiculo.class, id);
            if(veiculo != null){
                em.getTransaction().begin();
                em.remove(veiculo);
                em.getTransaction().commit();
            }
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
