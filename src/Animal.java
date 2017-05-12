import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihnea on 10.05.2017.
 */
public class Animal implements Serializable{
    private String name;
    private int age;
    private String type;

    public Animal(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return "\n"+type+"'s name is "+name+" and age is "+age;
    }
}

class ObjectStreamSampleAnimals {
    public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while(true) {
                Object object = in.readObject();
                if(object instanceof Animal)
                    animals.add((Animal)object);
            }
        }catch (EOFException e) {}
        return animals;
    }

    public static void createAnimals(List<Animal> animals, File dataFile) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for(Animal animal : animals) {
                out.writeObject(animal);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Tom", 12,"Lion"));
        animals.add(new Animal("Banjo",4,"Penguin"));
        animals.add(new Animal("Dolores",7,"Dog"));
        animals.add(new Animal("Lola",2,"Cat"));
        File dataFile = new File("animals.data");
        createAnimals(animals,dataFile);
        System.out.println(getAnimals(dataFile));
    }
}