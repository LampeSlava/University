public class Teacher extends Person {

    private float hours; //hours per week
    private double tariff; //payment per hour

    //constructors
    public Teacher(String name, String surname, int yearBirth, Address address, String status, float hours, double tariff) {
        super(name, surname, yearBirth, address, status);
        this.hours = hours;
        this.tariff = tariff;
    }

    //getters and setters
    public void setHours(float hours) {
        this.hours = hours;
    }

    public float getHours() {
        return this.hours;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public double getTariff() {
        return this.tariff;
    }

    //Methods
    @Override
    public String toString() {
        return this.getName() + ", " + this.getSurname() + ", " + this.getYear() + ", " + this.getStatus() + ", " + this.getTariff() + ", " + this.getHours() + ", teacher's address: " + this.getAddress();
    }
}
