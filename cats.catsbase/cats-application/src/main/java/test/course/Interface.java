package test.course;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.cats.domain.Cat;

public class Interface {
	
	
    static Scanner inputScanner = new Scanner(System.in);
    static CatDAO kotDao = new CatDAO();

    public static void main(String[] args) {
        
    		String menuVariable;
    		do {
    			showMenu();
    			menuVariable = getUserInput();
    			
    			if(menuVariable.equals("1"))
    				addCat();
    			else if(menuVariable.equals("2"))
    				showCats();
    			
    		}while (!menuVariable.equalsIgnoreCase("x"));
    		
    		
    }
    
    public static void showMenu() {
   		System.out.println();
    		System.out.println("Witaj w programie, co chcesz zrobić?");
    		System.out.println("1 - dodaj kota");
    		System.out.println("2 - pokaż koty");
    		System.out.println("x - zamknij program");
    		System.out.println();
    }
    
    public static void showCats() {
    		
    		System.out.println();
    	
    		for(int i=0;i<kotDao.getCats().size();i++)
    			System.out.println(i+": "+kotDao.getCats().get(i).getName());
    		
    		System.out.println();
    		
    		Pattern catNumberPattern = Pattern.compile("[0-9]+");
    		String catNumberInput;
    		do {
    			System.out.println("Wybierz numer kota: ");
    			catNumberInput = getUserInput();
    			
    		}while(!catNumberPattern.matcher(catNumberInput).matches());
    		
    		System.out.println();
    		Integer catNumber = Integer.parseInt(catNumberInput);
    		if(catNumber <= kotDao.getCats().size())
    			System.out.println(kotDao.getCats().get(catNumber).getInfo());
    		else System.out.println("Nie ma kota o takim numerze, spróbuj ponownie!");
    		
    		System.out.println();
    		
    }
    
    public static void addCat() {
    		kotDao.addCat(createCat());
    		System.out.println();
    }
    
    public static Cat createCat() {
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
        
        return kot;
    }

    /**
     * Pomocnicza metoda pozwalająca pobrać jedną linijkę wpisaną przez użytkownika.
     * @return Wczytana linijka.
     */
    public static String getUserInput() {
        return inputScanner.nextLine().trim();
    }

}
