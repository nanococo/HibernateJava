<h2>Explicación de puntos del caso</h2>
Este caso se desarroló utilizando la tecnología de Hibernate Java. 
El cuál se basa en el API de JPA y los annotations de Java para manejar el proceso de ORM. 
Para probarlo debe definir lso datos de la conexión a la base de datos en el archivo:
<b>src/main/resources/META-INF/persistence.xml</b>
A continuación la explicación de los puntos del caso:

1. ¿Cómo implementar un objeto que representa una relacion 1 a N?

R/ Para este punto, se utilizaron las tablas de sd_solutions y sd_solutions log. 
Esto porque se puede decir que 1 solution tiene n solution logs (1 a N).
En la clase src/main/java/databaseObjects/SdSolutionsEntity.java se 
declara la entidad de sd_solutions y en la clase
src/main/java/databaseObjects/SdSolutionslogEntity.java se declara la entidad
sd_solutionslog. Hibernate utiliza Java Annotations 
para declarar los mapeos de los objetos a las tablas de la base de datos.
En este caso la anotación que nos interesa es @OneToMany. Esta anotación define el 
tipo de relaciones que comparten las tablas y se encargan de definir sobre qué columna de
la tabla es la que se construye la relación. En el ejemplo se puede ver que la línea 71
de la clase SdSolutionsEntity define esta relación y además con el parámetro mappedBy
define el atributo de la clase SdSolutionslogEntity que genera la asociación a la lista
de elementos de tipo SdSolutionslogEntity.

Para la demostración práctica por favor refiérase al archivo problems/oneToMany/OneToMany.java.
Esta ejecución lo que hace es traer todos los Solutions que se encuentran en la base. Como
existe la asociación @OneToMany definida, Hibernate automáticamente va a buscar los elementos
relacionados a este objeto Solution que compartan el solutionId. Esto devuelve en cada
objeto solution un array de SdSolutionslogEntity. Para esta prueba se limitó este array de
objetos a que su método toString() solo devuelva el solutionlogId para efectos de visualización.

2. ¿Cómo manipular object pooling para reducir la cantidad de conexiones?

R/ Hibernate provee varias formas de manejar Connection Pooling para limitar la cantidad de
conexiones efectivas para una base de datos. Esto se ataca en Hibernate por medio de su configuración.
El módulo de connection pooling se llama C3P0. Este paquete de Hibernate permite la configuración de
el pool de conexiones y garantiza la estandarización de estas conexciones para toda la aplicación.
Puede encontrar la configuración de C3P0 en el archivo src/main/resources/META-INF/persistence.xml

            <property name="hibernate.c3p0.min_size" value="5"/>
            <property name="hibernate.c3p0.max_size" value="20"/>
            <property name="hibernate.c3p0.timeout" value="500"/>
            <property name="hibernate.c3p0.max_statements" value="50"/>
            <property name="hibernate.c3p0.idle_test_period" value="2000"/>

Así se configuran las propiedades para limitar el connection pool. C3P0 y Hibernate garantizan que
este límite es global, pues trabajan con un Singleton para la instaciación del EntityManager, quién
es el que se encarga de configurar la conexión a la base de datos. 

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateJava");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

Estas líneas son las que instancian el EntityManager el cuál utiliza el patrón de diseño Singleton para 
garantizar la existencia de un único pool de conexiones en memoria. Puede utilizar un decompiler como
FernFlower on el decompiler que viene en IntelliJ para navegar las clases del la librería de Hibernate.

3. ¿Como implementar una transacción que afecte a más de una tabla?

R/ Hibernate rodea su código a ejecutar en base de datos con los métodos que se usan en base de datos
para declarar transacciones. Por ejemplo:

        try{
            transaction.begin(); //Apertura del transaction

            //Código que afecte la base

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

Este mecanismo le permite capturar por medio de un try catch cualquier error que retorne la base de datos.
Con esto se puede anular cualquier cambio hecho dentro por medio de un transaction.rollback(). 

Para la demostración práctica por favor refiérase al archivo problems/oneToMany/Transaction.java.
Esta ejecución lo que hace es traer todos los Solutions que se encuentran en la base, luego utiliza
el primer solution parar insertar un nuevo solution log. Luego de eso intenta crear un solution vacío
que tiene valores en nulo e intenta insertarlo. Esto le genera un error pues solutions no acepta
valores en nulo por lo que falla. Al final, el try-catch absorbe el problema y genera un rollback por 
lo que el primer insert nunca ocurre