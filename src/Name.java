import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Name {
    public Name(String last, String first) {
        this.last = last;
        this.first = first;
    }

    ;

    public Name(String first) {
        this("", first);
    }

    public String getFormal() {
        return first + " " + last;
    }

    public String getOfficial() {
        return last + ", " + first;
    }

    public String getInitial() {
        char f_initial = first.charAt(0);   //initializes a character value with the element in the string
        char l_initial = last.charAt(0);
        return f_initial + "." + l_initial + ".";
    }

    public String toString() {
        return first + " " + last;
    }

    public boolean equals(Name other) {
        return first.equals(other.first) && last.equals(other.last);
    }

    public static Name read(Scanner scanner) { //static to allow me to call read object
        if (!scanner.hasNextLine()) return null;
        String last = scanner.next();
        String first = scanner.next();
        return new Name(last, first);
    }

    private String first, last;


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\yeepa\\OneDrive\\Documents\\names.txt"));
        int count = 0;
        Name object = read(scanner);
        Name previousName = null;
        while (object != null) {
            count++;
            if ((previousName != null && object.first.equals(previousName.first) && (object.last.equals(previousName.last)))) {
                System.out.println("Duplicate name " + "\"" + previousName + "\"" + " discovered");
                previousName = object;
                object = read(scanner);
            } else {
                System.out.println("name: " + object);
                System.out.println("formal: " + object.getFormal());
                System.out.println("Official " + object.getOfficial());
                System.out.println("initials: " + object.getInitial());
                System.out.println();

                previousName = object;  // must assign class object to this class object
                object = read(scanner);
            }
        }
            System.out.println("---");
            System.out.println(count + " names process");
        }
    }
