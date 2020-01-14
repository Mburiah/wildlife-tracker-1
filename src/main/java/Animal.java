import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private String animal_name;
    private int animal_age;

    public Animal(String animal_name, int animal_age) {
        this.animal_name = animal_name;
        this.animal_age = animal_age;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public int getAnimal_age() {
        return animal_age;
    }

    public void add() {
        try (Connection conn = DB.sql2o.open()) {
            conn.createQuery("insert into animals(animal_name, animal_age) VALUES(:animal_name, :animal_age)")
                    .addParameter("animal_name", this.animal_name)
                    .addParameter("animal_age", this.animal_age)
                    .executeUpdate();
        }
    }
    public static List<Animal> getAll() {
        try (Connection conn = DB.sql2o.open()) {
            return conn.createQuery("select *from animals").executeAndFetch(Animal.class);
        }
    }
}
