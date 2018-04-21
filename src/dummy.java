import java.io.File;
import java.util.Scanner;

class dummy { //A constructor that accepts the object and assign to private
    public dummy(String first, String last, String number) {

        name = new Name(first, last);
        phoneNumber = new PhoneNumber(number);
        //this.name = name;
        //this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name.getOfficial();
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    public String toString() {
        return String.format(getName() + ": " + getPhoneNumber());
    }

    public boolean equals(dummy other) {
        return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
    }

    public void call() {
        if (phoneNumber.isTollFree()) {
            System.out.println("Dialing (toll-free) " + name + " " + phoneNumber);

        } else {
            System.out.println("Dialing " + name + " " + phoneNumber);
        }

    }

    public static dummy read(Scanner scanner) {
        if (!scanner.hasNext()) return null;
        String last = scanner.next();
        String first = scanner.next();
        String number = scanner.next();
        return new dummy(last, first, number);
    }


    private Name name;
    private PhoneNumber phoneNumber;


    public static void main(String[] arg) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\yeepa\\OneDrive\\Documents\\PhoneBookEntry.txt"));
        dummy list = read(scanner);

        //   PhoneBookEntry duplicate = null;


        //PhoneBookEntry PreviusName = null;
        dummy warning = null;
        int count = 0;

        while (list != null) {
            count++;


            if ((warning != null && (list.name.equals(warning.name)) && !(list.getPhoneNumber().equals(warning.getPhoneNumber())))) {
                // if ((warning != null && (list.name.getOfficial().equals(warning.name.getOfficial()) && !(list.getPhoneNumber().equals(warning.getPhoneNumber()))))) {
                System.out.println("Warning duplicate book entry: \"" + list + "\" discovered");
                System.out.println("phone book entry: " + list);
                list.call();

                System.out.println();
                warning = list;
                list = read(scanner);

            } //else {
            // if ((warning != null && (list.name.getOfficial().equals(warning.name.getOfficial())))) {
            if (warning != null && list.getPhoneNumber().equals(warning.getPhoneNumber())) {
                System.out.println("Duplicate book entry: \"" + list + "\" discovered");
                count++;

                warning = list;
                list = read(scanner);
            } else {
                System.out.println("phone book entry: " + list);


                list.call();
                System.out.println();

                warning = list;
                list = read(scanner);
            }


        }


        System.out.println("---");
        System.out.println( count + " entries processed.");


    }
}