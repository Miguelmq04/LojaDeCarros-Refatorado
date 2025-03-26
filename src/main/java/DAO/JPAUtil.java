package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "ProjetoPI";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    /**
     * Obtém a instância do EntityManager e do EntityManagerFactory. 
     * Caso eles sejam nulos ou estejam fechados, este método cria novas instâncias.  
     * 
     * @return Uma instância do EntityManager para se comunicar com o banco de dados.
     */
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen())
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        
        if(em == null || !em.isOpen())
            em = fabrica.createEntityManager();
        
        return em;
    }
    
    /**
     * Fecha o EntityManager e o EntityManagerFactory, se ambos estiverem aberto.
     * Esse método deve ser chamado apos a utilização de EntityManager para liberar os recursos utilizados.
     */
    public static void closeEntityManager(){
        if(em.isOpen() && em != null){
            em.close();
            fabrica.close();
        }
    }
}
