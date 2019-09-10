package collections;

public class Dogs {
    // fields - attributes - values of all fields (state of the object)
    private String breed;
    private int avgWeight;
    private boolean apartment;

    // constructor
    public Dogs(String breed, int avgWeight, boolean apartment) {
        this.breed = breed;
        this.avgWeight = avgWeight;
        this.apartment = apartment;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(int avgWeight) {
        this.avgWeight = avgWeight;
    }

    public boolean isApartment() {
        return apartment;
    }

    public void setApartment(boolean apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Dogs{" + "breed='" + breed + '\'' + ", avgWeight=" + avgWeight + ", apartment=" + apartment + '}';
    }
}
