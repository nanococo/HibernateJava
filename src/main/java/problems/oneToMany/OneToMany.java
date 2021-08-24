package problems.oneToMany;

import databaseObjects.SdSolutionsEntity;

import javax.persistence.*;

public class OneToMany {
    public static void main(String[] args) {
        //Creación del Entity Manager y el pool de conexiones con el persistence
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJava");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin(); //Apertura del transaction

            //Select de todos los solutions que hay en el sistema
            TypedQuery<SdSolutionsEntity> solutions = entityManager.createQuery("FROM SdSolutionsEntity", SdSolutionsEntity.class);
            System.out.println(solutions.getResultList().size());
            for (SdSolutionsEntity sdOwnersEntity : solutions.getResultList()) {
                //Por cada iteración se llama al método .toString() de la clase SdSolutionsEntity.
                //Este array viene poblado de la asociación 1-N que se define en los modelos y por ende trae una
                //lista de SdSolutionslogEntity que por cada uno llamará a su método .toString()
                System.out.println(sdOwnersEntity);
            }

            transaction.commit(); //Cierre del transaction
        } catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
