package bdbt_bada_project.SpringApplication.Entities;

public class Attractions {

    public int id_attraction;
    private String name;
    private String duration;
    private int min_age;
    private String description;

    public Attractions(){

    }

    public Attractions(int id, String name, String duration, int min_age, String description) {
        super();
        this.id_attraction = id;
        this.name = name;
        this.duration = duration;
        this.min_age = min_age;
        this.description = description;
    }

    public int getId_attraction() {
        return id_attraction;
    }

    public void setId_attraction(int id_attraction) {
        this.id_attraction = id_attraction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Attractions{" +
                "id_attraction=" + id_attraction +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", min_age=" + min_age +
                ", description='" + description + '\'' +
                '}';
    }
}
