import java.io.File;
import java.util.Scanner;

public class PhonebookEntry {
    public PhonebookEntry(Name name, PhoneNumber phoneNumber) {

        this. name = name;
        this. phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public boolean comparison(PhonebookEntry other) {
        return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
    }

    public void call() {
        if(phoneNumber.isTollFree())
            System.out.println("Dialing (toll free) " + name.getFormal() + ": " + getPhoneNumber());
        else
            System.out.println("Dialing " + getName() + ": " + getPhoneNumber());
    }

    public String toString() {return String.format(getName() + ": " + getPhoneNumber());}

    public static PhonebookEntry read(Scanner scanner){
        if(!scanner.hasNext()) return null;
        String last = scanner.next();
        String first = scanner.next();
        String number = scanner.next();
        return new PhonebookEntry(new Name (last, first), new PhoneNumber(number));
    }


    private Name name;
    private PhoneNumber phoneNumber;

    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\yeepa\\OneDrive\\Documents\\PhoneBookEntry.txt"));
        PhonebookEntry directory = read(scanner);
        PhonebookEntry prevName = null;
        int count = 0;
        while(directory != null) {
            count++;
            // directory = read(scanner);
             if ((prevName != null) && (prevName.name.equals(directory.name)) && !(prevName.phoneNumber.equals(directory.phoneNumber))) {
                 System.out.println("Warning duplicate book entry: \"" + prevName + "\" discovered");
                 System.out.println("phone book entry: " + directory);
                 directory.call();

                 System.out.println();
                 prevName = directory;
                 directory = read(scanner);

             }
            if (prevName != null && directory.getPhoneNumber().equals(prevName.getPhoneNumber())) {
                System.out.println("Duplicate book entry: \"" + directory + "\" discovered -- Palmer");
                prevName = directory;
                directory = read(scanner);

            }
             else {
                System.out.println("phone book entry: " + directory);
                directory.call();

                System.out.println();
                prevName = directory;
                directory = read(scanner);
            }




            }


        System.out.println("----");
        System.out.println(count + " entries process");
    }
}

//            if (prevName != null && (prevName.name.equals(directory.name))) {
//                System.out.println("Warning duplicate book entry: \"" + directory + "\" discovered");
//                System.out.println("phone book entry: " + directory);
//                directory.call();
//                System.out.println();
//            }
//
//            if (prevName != null) {
//                // System.out.println(directory.phoneNumber.equals(duplicate.phoneNumber));
//               System.out.println(directory.phoneNumber);
//                System.out.println(prevName.phoneNumber);
//                //System.out.println();
//                System.out.println(prevName.name);
//                System.out.println(directory.getName());
//                System.out.println();
//
//            }
////                   duplicate = directory;
//                   directory = read(scanner);
