import com.uptc.frw.entity.*;
import com.uptc.frw.persistence.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        EntityManager em = PersistenceUtil.getEntityManager();

        Person person1 = new Person(101L, "Laura", "Perez","Cuba");
        Person person2 = new Person(102L, "Isablea", "LDKANC", "Italia");
        Book book = new Book(301L,"100 años de soledad", 999D);
        List<Person> authors = new ArrayList<>();
        authors.add(person1);
        authors.add(person2);
        book.setAuthors(authors);
        em.getTransaction().begin();
        em.persist(person1);
        em.persist(person2);
        em.persist(book);
        em.getTransaction().commit();



        /*EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 2);
        System.out.println(person);
        System.out.println(person.getBooks());
        Book book = entityManager.find(Book.class,1);
        System.out.println(book);
        System.out.println(book.getAuthors());*/

        //probarMapeo();
    }


    public static void createBillPerson(){
        EntityManager em = PersistenceUtil.getEntityManager();
        Person person =new Person();
        person.setId(100L);
        person.setName("Niva");
        person.setLastName("Gonzales");
        person.setNationality("Canada");


        Bill bill = new Bill();
        bill.setId(200L);
        bill.setDate(new Date());
        bill.setPerson(person);
        em.getTransaction().begin();
        em.persist(person);
        em.persist(bill);
        em.getTransaction().commit();

    }
public static void crearLibro(){
    EntityManager em = PersistenceUtil.getEntityManager();
    Book book = new Book();
    book.setTitle("El pricipito");
    book.setPrice(5000D);
    book.setId(2L);

    Edition edition = new Edition();
    edition.setNumber(12);
    edition.setYear(3000);
    edition.setDescription("bla bal");
    edition.setBook(book);
    em.getTransaction().begin();
    em.persist(edition);
    em.getTransaction().commit();
}
    public static void removePerson(){
        createPerson();
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 2);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        person.setLastName("Betancourth");
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }
    public static  void probarMapeo(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 1);
        System.out.println(person);
        System.out.println("");

        Book book = entityManager.find(Book.class,1);
        System.out.println(book);
        System.out.println("");

        Bill bill = entityManager.find(Bill.class, 1);
        System.out.println(bill);
        System.out.println("");

        BillDetail billDetail= entityManager.find(BillDetail.class, 1);
        System.out.println(billDetail);
        System.out.println("");

        Edition edition= entityManager.find(Edition.class, 1);
        System.out.println(edition);
    }
    public static void createPerson(){
        Person person = new Person();
        person.setId(2L);
        person.setName("Juana");
        person.setLastName("Rojas");
        person.setNationality("India");
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

    public static void findPersonWithRefresh(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 1);
        entityManager.getTransaction().begin();
        entityManager.refresh(person);
        person.setLastName("Martinez");

        entityManager.getTransaction().commit();
        System.out.println(person);
    }
    public static void mergePerson(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 2);
        entityManager.getTransaction().begin();
        person.setLastName("Martinez");
        entityManager.detach(person);
        Person person1=entityManager.merge(person);
        entityManager.remove(person1);
        entityManager.getTransaction().commit();
    }
    public static void testBook(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Edition edition = entityManager.find(Edition.class, 1);
        System.out.println(edition);
        System.out.println(edition.getBook());
        System.out.println("");
        Book book = entityManager.find(Book.class,1);
        System.out.println(book);
        System.out.println(book.getEdition());
    }
    public static void testBillPerson(){
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 2);
        System.out.println(person);
        System.out.println(person.getBills().size());
        Bill bill = entityManager.find(Bill.class,1);
        System.out.println(bill);
        System.out.println(bill.getPerson());
    }
}