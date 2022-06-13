public class Teacher extends Person {

    private float hours; //hours per week
    private double tariff; //payment per hour

    //constructors
    public Teacher(int persId, String name, String surname, int yearBirth, Address address, String pStatus, float hours, double tariff) {
        super(persId, name, surname, yearBirth, address, pStatus);
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
        return this.getPersId() + ", " + this.getName() + ", " + this.getSurname() + ", " + this.getYear() + ", " + this.getPstatus() + ", " + this.getTariff() + ", " + this.getHours() + ", teacher's address: " + this.getAddress();
    }

}
