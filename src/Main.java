import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Address> addresses = new ArrayList<>(10);
        ArrayList<Person> people = new ArrayList<>(10);

        FilePlay.loadStudents(people, addresses);

        //interface loop
        boolean exitProgram = false;
        String opLetter;
        char opChar;
        char sortOrder = 'd'; //default sort order - by ID
        Scanner input = new Scanner(System.in);

        //main software cycle
        while (!exitProgram) {
            listStudents(people, sortOrder);

            System.out.print("Enter operation code (letter in brackets): ");
            try {
                opLetter = input.nextLine();
                opChar = Character.toLowerCase(opLetter.charAt(0));
            } catch (StringIndexOutOfBoundsException e) {
                opChar = 'z';
            }

            switch (opChar) {
                case 'e':
                    exitProgram = true;
                    break;
                case 'l':
                    sortOrder = getSortOrder();
                    break;
                case 'n':
                    addStudent(addresses, people);
                    break;
                case 'u':
                    System.out.println("Update student! Not implemented yet!");
                    break;
                case 'd':
                    deleteStudent(people, addresses);
                    break;
                case 's':
                    FilePlay.saveStudents(people, addresses);
                    break;
                default:
                    System.out.println("Enter correct letter!");
            }
        }
        input.close();
    }

    static char getSortOrder() {

        Scanner input_s = new Scanner(System.in);
        String opLetter;
        char opChar;
        System.out.print("Enter sort order code (letter in brackets) (D)efault by ID, (S)urname, (Y)ear of birth: ");
        try {
            opLetter = input_s.nextLine();
            opChar = Character.toLowerCase(opLetter.charAt(0));
        } catch (StringIndexOutOfBoundsException e) {
            opChar = 'd';
        }

        return switch (opChar) {
            case 's' -> 's';
            case 'y' -> 'y';
            default -> 'd';
        };
    }

    static void listStudents(ArrayList<Person> students, char sortOrder) {

        System.out.println(" ");
        System.out.println("+----------------------------------------------------------------------------------------------+");
        System.out.println("| (L)ist order  | (N)ew student  | (U)pdate student  | (D)elete student | (S)ave data | (E)xit |");
        System.out.println("+----------------------------------------------------------------------------------------------+");

        switch (sortOrder) {
            case 's':
                surnameComparator surnameComparator = new surnameComparator();
                students.stream()
                        .sorted(surnameComparator)
                        .forEach(System.out::println);
                break;
            case 'y':
                yearComparator yearComparator = new yearComparator();
                students.stream()
                        .sorted(yearComparator)
                        .forEach(System.out::println);
                break;
            default:
                idComparator idComparator = new idComparator();
                students.stream()
                        .sorted(idComparator)
                        .forEach(System.out::println);
        }
        System.out.println("+----------------------------------------------------------------------------------------------+");
    }

    static void deleteStudent(ArrayList<Person> students, ArrayList<Address> addresses) {

        int studentToDelete;

        //input block
        System.out.print("Enter number of student to delete: ");
        Scanner input = new Scanner(System.in);
        studentToDelete = input.nextInt();

        //find, if correct student ID specified
        Person realPos = new Person();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPersId() == studentToDelete) {
                realPos = students.get(i);
            }
        }
        //?!?! DOESN'T WORK! WHY???
//        students.stream()
//                .filter(s -> s.getPersId() == 5)
//                .count();

        if ((studentToDelete < 0) || (realPos.getAddress() == null)) {
            System.out.println("ERROR! Wrong student number!");
            return;
        }
        //input - OK

        //address of the student must be deleted also!
        addresses.remove(realPos);
        students.remove(realPos);
    }

    static void addStudent(ArrayList<Address> addresses, ArrayList<Person> people) {

        //input block
        Scanner input_add = new Scanner(System.in);

        System.out.println("PERSONAL DATA: ");
        System.out.print("Enter surname: ");
        String surname = input_add.nextLine();

        System.out.print("Enter name: ");
        String name = input_add.nextLine();

        System.out.print("Enter year of birth: ");
        String yearBirth = input_add.nextLine();

        System.out.print("Enter status - (T) for teacher, any other letter - for student: ");
        //String opLetter = input_add.nextLine();
        String pStatus;

        try {
            String opLetter = input_add.nextLine();
            char opChar = Character.toLowerCase(opLetter.charAt(0));
            if (Character.toLowerCase(opLetter.charAt(0)) == 't') {
                pStatus = "Teacher";
            } else {
                pStatus = "Student";
            }
        } catch (StringIndexOutOfBoundsException e) {
            pStatus = "Student";
        }

        System.out.println("ADDRESS DATA: ");
        System.out.print("Enter city: ");
        String city = input_add.nextLine();

        System.out.print("Enter street: ");
        String street = input_add.nextLine();

        System.out.print("Enter building: ");
        String building = input_add.nextLine();

        System.out.print("Enter apartment: ");
        String apartment = input_add.nextLine();

        //find next free id
        int addrId = addresses.get(0).getAddrId();

        for (int i = 1; i < addresses.size(); i++) {
            if (addresses.get(i).getAddrId() > addrId) {
                addrId = addresses.get(i).getAddrId();
            }
        }
        addrId++;
        int persId = addrId;

        //adding block
        addresses.add(new Address(addrId, city, street, building, apartment));
        //!?!? not sure, that correct address will be added, but it is correct! How to obtain pointer to newly added address?
        people.add(new Person(persId, surname, name, Integer.parseInt(yearBirth), addresses.get(addresses.size() - 1), pStatus));
    }
}
