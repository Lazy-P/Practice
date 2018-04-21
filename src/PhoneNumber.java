import java.io.File;
import java.util.Scanner;

public class PhoneNumber {
    public PhoneNumber(String number) {
        this.number = number;
    };

    public String getAreaCode() {
        return number.substring(1,4);
    }

    public String getExchange() {
        return number.substring(5,8);
    }

    public String getLineNumber() {
        return number.substring(9,13);
    }

    public boolean isTollFree() {
        if(number.substring(1,2).equals("8")) {
            System.out.println("Is toll free: true");
            return true;
        } else
            System.out.println("is toll free: false");
        return false;
    }

    public String toString() {
        return String.format(number);
    }

    public static PhoneNumber read(Scanner scanner) {
        if(!scanner.hasNext()) return null;
        String number = scanner.next();
        return new PhoneNumber(number);
    }
    private String number;

    public static void main(String [] args) throws Exception {
        int count = 0;
        Scanner scanner = new Scanner (new File("C:\\Users\\yeepa\\OneDrive\\Documents\\PhoneDigits.txt"));
        PhoneNumber digits = read(scanner);     //phone number object used the read method
        PhoneNumber previousNumber = null;
        while(digits != null) {
            count++;
//            if (previousNumber != null) {
//                System.out.println(digits.number);
//                System.out.println(previousNumber.number);
//            }
            if (previousNumber != null && (digits.number.equals(previousNumber.number))) {
                System.out.println("Duplicate phone number " + "\"" + previousNumber + "\"" + " discovered");
                previousNumber = digits;
                digits = read(scanner);
            } else {
                System.out.println("Phone number " + digits);
                System.out.println("Area code: " + digits.getAreaCode());
                System.out.println("Exchange line: " + digits.getExchange());
                System.out.println("Line number: " + digits.getLineNumber());
                digits.isTollFree();
                System.out.println();
                previousNumber = digits;
                digits = read(scanner);
            }
        }
        System.out.println("---");
        System.out.println(count + " number process");
    }
}
