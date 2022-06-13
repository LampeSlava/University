import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FilePlay {

    public static void loadStudents(ArrayList<Person> people, ArrayList<Address> addresses) throws IOException {

        FileReader myfile_p = null;
        FileReader myfile_a = null;
        try {
            //files init
            String filepath_a = Paths.get("").toAbsolutePath().toString();
            myfile_a = new FileReader(filepath_a + "\\src\\addresses.txt");
            BufferedReader reader_a = new BufferedReader(myfile_a);

            String filepath_p = Paths.get("").toAbsolutePath().toString();
            myfile_p = new FileReader(filepath_p + "\\src\\persons.txt");
            BufferedReader reader_p = new BufferedReader(myfile_p);

            String textLine;

            //data reading
            while ((textLine = reader_a.readLine()) != null) {
                //addresses
                String[] dataFields_a = textLine.split("\t"); //array of text line elements
                addresses.add(new Address(Integer.parseInt(dataFields_a[0]), dataFields_a[1], dataFields_a[2], dataFields_a[3], dataFields_a[4]));

                //people
                textLine = reader_p.readLine();
                String[] dataFields_p = textLine.split("\t"); //array of text line elements
                people.add(new Person(Integer.parseInt(dataFields_p[0]), dataFields_p[2], dataFields_p[1], Integer.parseInt(dataFields_p[3]), addresses.get(addresses.size() - 1), dataFields_p[4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(2);
        } catch (IOException e) {
            System.out.println("Error reading file");
            System.out.println(e.getMessage());
            System.exit(3);
        } finally {
            if (myfile_p != null) {
                myfile_p.close();
            }
        }
    }

    public static void saveStudents(ArrayList<Person> people, ArrayList<Address> addresses) {

        FileWriter myfile = null;
        try {
            String filepath = Paths.get("").toAbsolutePath().toString();
            myfile = new FileWriter(filepath + "\\src\\persons.txt");
            BufferedWriter writer = new BufferedWriter(myfile);

            for (Person student : people) {
                String dataLine = String.join("\t", Integer.toString(student.getPersId()), student.getName(), student.getSurname(), Integer.toString(student.getYear()), student.getPstatus()) + "\n";
                try {
                    writer.write(dataLine);
                } catch (IOException e) {
                    System.out.println("Error writing to file 'persons.txt'!");
                    e.getCause();
                }
            }
            writer.flush();
            writer.close();
            System.out.println(" ");
            System.out.println("Data file 'persons.txt' saved!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter myfile_w = null;
        try {
            String filepath = Paths.get("").toAbsolutePath().toString();
            myfile_w = new FileWriter(filepath + "\\src\\addresses.txt");
            BufferedWriter writer = new BufferedWriter(myfile_w);

            for (Address address : addresses) {
                String dataLine = String.join("\t", Integer.toString(address.getAddrId()), address.getCity(), address.getStreet(), address.getBuilding(), address.getApartment()) + "\n";
                try {
                    writer.write(dataLine);
                } catch (IOException e) {
                    System.out.println("Error writing to file 'addresses.txt'!");
                    e.getCause();
                }
            }
            writer.flush();
            writer.close();
            System.out.println(" ");
            System.out.println("Data file 'addresses.txt' saved!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
