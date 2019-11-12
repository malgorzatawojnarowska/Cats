package test.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import test.course.cats.Cat;

public class Interface {
	
	
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat kot = new Cat();

        System.out.print("Podaj imię kota: ");
        kot.setName(getUserInput());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            try {
                kot.setDateOfBirth(sdf.parse(getUserInput()));
            } catch (ParseException pe) {
                System.out.println("Coś jest nie tak z formatem daty! Przykładowa data: 2014.01.05");
            }
        } while (kot.getDateOfBirth() == null);

        do {
            System.out.print("Podaj wagę kota: ");
            try {
                kot.setWeight(Float.valueOf(getUserInput()));
            } catch (NumberFormatException nfe) {
                System.out.println("Coś jest nie tak z formatem wagi! Przykładowa waga: 10.0");
            }
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
