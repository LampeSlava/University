import java.util.Comparator;

public class Person { //implements Comparable<Person>{
    private int persId;
    private String name;
    private String surname;
    private int yearBirth;
    private Address address;
    private String pStatus; //student, teacher, etc.
    private boolean opFlag; //true, if something need to be done with current person

    //constructors
    public Person(int persId, String name, String surname, int yearBirth, Address address, String pStatus) {
        this.persId = persId;
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
        this.address = address;
        this.pStatus = pStatus;
    }

    public Person(int persId, String name, String surname, int yearBirth, Address address) {
        this.persId = persId;
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
        this.address = address;
        this.pStatus = "Student"; //create default
    }

    public Person() {
    }

    //setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setYear(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getYear() {
        return this.yearBirth;
    }

    public void setPstatus(String pstatus) {
        this.pStatus = pStatus;
    }

    public String getPstatus() {
        return pStatus;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    public int getPersId() {
        return persId;
    }

    public void setPersId(int persId) {
        this.persId = persId;
    }

    @Override
    public String toString() {
        return this.persId + ", " + this.getName() + ", " + this.getSurname() + ", " + this.getYear() + ", " + this.getPstatus() + ", address: " + this.address;
    }

//    @Override
//    public int compareTo(Person o) {
//        //return 0;
//        //if (sortOrder == 'd') {
//            return this.getPersId() - o.getPersId();
//        //}
//    }
}
