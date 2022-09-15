import base.Alpinist;
import base.GroupAlpinist;
import base.Mount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Alpinist alpinist1 = new Alpinist("Paul", "America");
        Alpinist alpinist2 = new Alpinist("Merry", "America");
        Alpinist alpinist3 = new Alpinist("Ivan", "Ukraine");
        Alpinist alpinist4 = new Alpinist("Alex", "Russia");
        Alpinist alpinist5 = new Alpinist("Calvin", "Great Britain");
        Alpinist alpinist6 = new Alpinist("Sean", "America");
        Alpinist alpinist7 = new Alpinist("Agnesa", "Poland");
        Alpinist alpinist8 = new Alpinist("Laila", "Egypt");
        Alpinist alpinist9 = new Alpinist("Garry", "England");
        Alpinist alpinist10 = new Alpinist("John", "England");
        Alpinist alpinist11 = new Alpinist("James", "England");

        Mount mount1 = new Mount("Calamaga", "Russia", 120);
        Mount mount2 = new Mount("Balamaga", "America", 1000);
        Mount mount3 = new Mount("Talamaga", "Japan", 1700);


        GroupAlpinist group1 = new GroupAlpinist(mount1);
        GroupAlpinist group2 = new GroupAlpinist(mount2);
        GroupAlpinist group3 = new GroupAlpinist(mount3);

        group1.addAlpinist(alpinist1, alpinist2, alpinist3, alpinist8);
        group2.addAlpinist(alpinist4, alpinist5, alpinist9, alpinist10);
        group3.addAlpinist(alpinist6, alpinist7, alpinist11);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AlpinistJPA");

        EntityManager manager = factory.createEntityManager();


        manager.getTransaction().begin();
        manager.persist(mount1);
        manager.persist(mount2);
        manager.persist(mount3);

        manager.persist(group1);
        manager.persist(group2);
        manager.persist(group3);
        manager.getTransaction().commit();

        manager.close();
    }
}
