
package DAO;

import Entities.TipoCargo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class CargoDAO {
    /**
     * Realiza uma consulta no banco de dados, retornando uma lista de objetos do TipoCargo.
     * @return uma lista do tipo TipoCargo
     */
    public List<TipoCargo> getCargo(){
        EntityManager em = JPAUtil.getEntityManager();
        
        List<TipoCargo> listaCargo = new ArrayList<TipoCargo>();
        
        try{
            Query consultaCargo = em.createQuery("select t from TipoCargo t");
             listaCargo = consultaCargo.getResultList();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
        finally{
            JPAUtil.closeEntityManager();
        }
        return listaCargo;
    }
}
