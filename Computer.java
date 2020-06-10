package com.mastermind;

import java.util.Random;

public class Computer {
    String computerCode = "";
    int aantalCorrecteLettersOpJuistePlek = 0;
    int aantalCorrecteLettersOpOnjuistePlek = 0;
    int maxAantalLetters = 4;
    int aantalKeerGeraden = 1;

    void genereerComputerCode() {
        Random rd = new Random();
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 0; i < maxAantalLetters; i++) {
            int kiesLetter = rd.nextInt(letters.length);
            computerCode = computerCode.concat(String.valueOf(letters[kiesLetter]));
        }
    }

    String getVerborgenCode() {
        return computerCode;
    }

    void checkAntwoordSpeler(String spelersCode) {
        for (int i = 0; i < computerCode.length(); i++) {
            if (computerCode.charAt(i) == spelersCode.charAt(i)) { //checken voor dezelfde index plek en letter.
                aantalCorrecteLettersOpJuistePlek++;
            }else if (spelersCode.contains(String.valueOf(computerCode.charAt(i))) && 
                    spelersCode.charAt(i) != computerCode.charAt(i)) { //checken of de letter uberhaupt in het woord voorkomt.
                aantalCorrecteLettersOpOnjuistePlek++;
            }
        }
        computerReactie(aantalCorrecteLettersOpJuistePlek,aantalCorrecteLettersOpOnjuistePlek);

        //resetten naar 0 zodat de vorige waardes niet worden meegenomen
        aantalCorrecteLettersOpJuistePlek = 0;
        aantalCorrecteLettersOpOnjuistePlek = 0;

        aantalKeerGeraden++; //elke keer wanneer de methode wordt aangeroepen in class mastermind, neemt het aantal geraden pogingen met 1 toe.
    }

    int getAantalKeerGeraden(){
        return aantalKeerGeraden;
    }

    void computerReactie(int juisteplek, int onjuisteplek){
        int enkeleLetter = 1;

        if (juisteplek == enkeleLetter) {
            System.out.println("Je hebt " + juisteplek + " correcte letter op de juiste plek staan");
        }else
            System.out.println("Je hebt " + juisteplek + " correcte letters op de juiste plek staan");

        if (onjuisteplek == enkeleLetter) {
            System.out.println("Je hebt " + onjuisteplek + " correcte letter op de onjuiste plek staan");
        }else
            System.out.println("Je hebt "+ onjuisteplek +" correcte letters op een onjuiste plek staan");
    }
}










