public class Address {
    private int addrId;
    private String city;
    private String street;
    private String building;
    private String apartment;

    //constructor
    public Address(int addrId, String city, String street, String building, String apartment) {
        this.addrId = addrId;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    //getters and setters for all the fields
    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getApartment() {
        return this.apartment;
    }

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    //Methods
    @Override
    public String toString() {
        return this.city + ", " + this.street + ", " + this.building + ", " + this.apartment;
    }

}
