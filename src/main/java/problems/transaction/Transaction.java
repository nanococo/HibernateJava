package problems.transaction;

import databaseObjects.SdSolutionsEntity;
import databaseObjects.SdSolutionslogEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
    public static void main(String[] args) {
        //Creación del Entity Manager y el pool de conexiones con el persistence
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJava");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            //Prepara la creacion de un nuevo objeto para insertar
            SdSolutionslogEntity solutionslogEntity1 = new SdSolutionslogEntity();
            solutionslogEntity1.setPosttime(new Timestamp(new Date().getTime()));
            solutionslogEntity1.setActiontypeid(Short.parseShort("1"));

            //Aca el programa obtiene el solution a quien se le asigna el log
            TypedQuery<SdSolutionsEntity> solutions = entityManager.createQuery("FROM SdSolutionsEntity", SdSolutionsEntity.class);
            SdSolutionsEntity solutionsEntity = solutions.getResultList().get(0); //obtiene el primer resultado por motivos del ejemplo
            solutionsEntity.getSdSolutionslogsBySolutionid().add(solutionslogEntity1); //le asigna al solution un log

            entityManager.persist(solutionsEntity); //Aqui se inserta el log en base de datos

            //Aca se inserta un solution nuevo mal hecho en base de datos
            SdSolutionsEntity solutionsEntity1 = new SdSolutionsEntity();

            entityManager.persist(solutionsEntity1); //aca se genera un error pues lleva valores en nulo


            transaction.commit(); //nunca llega al commit porque falla antes
        } catch (Exception e){
            transaction.rollback(); //El rollback debe anular el insert del primer log
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
