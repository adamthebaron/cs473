package cs473;

import org.mongodb.morphia.annotations.Id;

public class Traveller {
    @Id
    private String id;
    private String name;

    public Traveller(String id, String name) {
        this.id 	= id;
        this.name	= name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
