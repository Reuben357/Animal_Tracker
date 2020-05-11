package models;

public class Animal {
    public int id;
    public String name;
    public String age;
    public boolean is_endangered;
    public String health_status;
    public String sighting;

    public Animal(){}

    public Animal(String name,
                  String age,
                  String health_status,
                  boolean is_endangered,
                  String sighting) {
        this.name = name;
        this.age = age;
        this.health_status = health_status;
        this.is_endangered = is_endangered;
        this.sighting = sighting;
    }

    public String getSighting() {
        return sighting;
    }

    public void setSighting(String sighting) {
        this.sighting = sighting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isEndangered() {
        return is_endangered;
    }

    public void setEndangered(boolean is_endangered) {
        this.is_endangered = is_endangered;
    }

    public String getHealthStatus() {
        return health_status;
    }

    public void setHealthStatus(String health_status) {
        this.health_status = health_status;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", isEndangered=" + is_endangered +
                ", healthStatus='" + health_status + '\'' +
                ",sighting='" +sighting+ '\''+
                '}';
    }


}
