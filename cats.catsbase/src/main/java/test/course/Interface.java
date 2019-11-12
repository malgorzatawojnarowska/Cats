package test.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import test.course.cats.Cat;

public class Interface {
	
	
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat kot = new Cat();

        System.out.print("Podaj imię kota: ");
        kot.setName(getUserInput());
        
        
        Pattern datePattern= Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String dateOfBirth;
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            dateOfBirth = getUserInput();
            if (datePattern.matcher(dateOfBirth).matches()) {
            	try {
            		kot.setDateOfBirth(sdf.parse(dateOfBirth));
            	} catch (ParseException pe) {
            		System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
            	}
            }
        } while (kot.getDateOfBirth() == null);

        Pattern weightPattern = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String weight;
        do {
            System.out.print("Podaj wagę kota: ");
            weight = getUserInput();
            if(weightPattern.matcher(weight).matches())
                kot.setWeight(Float.valueOf(weight));
        } while (kot.getWeight() == null);
            

        System.out.print("Podaj, kto jest opiekunem kota: ");
        kot.setOwnerName(getUserInput());
        

        System.out.println("Dziękuję, teraz już wiem wszystko o kocie!");
    }

    /**
     * Pomocnicza metoda pozwalająca pobrać jedną linijkę wpisaną przez użytkownika.
     * @return Wczytana linijka.
     */
    public static String getUserInput() {
        return inputScanner.nextLine().trim();
    }

}
