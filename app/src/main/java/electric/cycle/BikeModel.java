package electric.cycle;

public class BikeModel {

    private String bike_name;
    private int bike_image;

    // Constructor
    public BikeModel(String bike_name, int bike_image) {
        this.bike_name = bike_name;
        this.bike_image = bike_image;
    }

    // Getter and Setter
    public String getBike_name() {
        return bike_name;
    }

    public void setBike_name(String course_name) {
        this.bike_name = course_name;
    }


    public int getBike_image() {
        return bike_image;
    }

    public void setBike_image(int bike_image) {
        this.bike_image = bike_image;
    }
}
