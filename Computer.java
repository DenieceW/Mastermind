package com.mastermind;

import java.util.Random;

public class Computer {
    String computerCode = "";
    int aantalCorrecteLettersOpJuistePlek = 0;
    int aantalCorrecteLettersOpOnjuistePlek = 0;
    int aantalDubbeleCorrecteLettersOpOnjuistePlek = 0;
    int maxAantalLetters = 4;
    int aantalKeerGeraden = 1;
    String dubbeleLetter = "";
    String dubbeleLetterSpeler = "";

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
       checkVoorDubbeleLetters();//hier checken of de speler//computer dubbele letters hebben
       checkVoorDubbeleLettersSpeler(spelersCode);

        for (int i = 0; i < computerCode.length(); i++) {
            if ((computerCode.charAt(i) == spelersCode.charAt(i))) { //checken voor dezelfde  plek en letter.
                aantalCorrecteLettersOpJuistePlek++;
            }
            if(spelersCode.charAt(i) != computerCode.charAt(i)
                     && spelersCode.contains(String.valueOf(computerCode.charAt(i)))) {
                aantalCorrecteLettersOpOnjuistePlek++;
            }

            //onderstaande zorgt ervoor dat de dubbele letter niet meer meegeteld wordt.
            if(getDubbeleLetter().contains(String.valueOf(spelersCode.charAt(i)))){
                    aantalCorrecteLettersOpOnjuistePlek--;
                if(getDubbeleLetter().equals(getDubbeleLetterSpeler())){ //
                    aantalCorrecteLettersOpOnjuistePlek++;
                }
            }
        }

        computerReactie(aantalCorrecteLettersOpJuistePlek,aantalCorrecteLettersOpOnjuistePlek);
        //resetten naar 0 zodat de vorige waardes niet worden meegenomen
        aantalCorrecteLettersOpJuistePlek = 0;
        aantalCorrecteLettersOpOnjuistePlek = 0;
        aantalDubbeleCorrecteLettersOpOnjuistePlek = 0;
        aantalKeerGeraden++; //elke keer wanneer de methode wordt aangeroepen in class mastermind, neemt het aantal geraden pogingen met 1 toe.
    }

    int getAantalKeerGeraden(){
        return aantalKeerGeraden;
    }

    private boolean checkVoorDubbeleLetters(){
        char[] pcCode = computerCode.toCharArray();
        //hier checken of de computer dubbele letters heeft.
        for (int i = 0; i < pcCode.length; i++) {
            for (int j = 0; j < pcCode.length; j++) {
                if (i != j) {
                    if (pcCode[i] == pcCode[j]) {
                        dubbeleLetter = String.valueOf(pcCode[i]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String getDubbeleLetter(){
        return dubbeleLetter;
    }

    private boolean checkVoorDubbeleLettersSpeler(String spelerscode){
        char[] code = spelerscode.toCharArray();
        //hier checken of de speler dubbele letters heeft.
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (i != j) {
                    if (code[i] == code[j]) {
                        dubbeleLetterSpeler = String.valueOf(code[i]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String getDubbeleLetterSpeler(){
        return dubbeleLetterSpeler;
    }

    void computerReactie(int juisteplek, int onjuisteplek){
        int enkeleLetter = 1;

        if (juisteplek == enkeleLetter) {
            System.out.println("Je hebt " + juisteplek + " correcte letter op de juiste plek staan");
        }else
            System.out.println("Je hebt " + juisteplek + " correcte letters op de juiste plek staan");

        if (onjuisteplek == enkeleLetter) {
            System.out.println("Je hebt " + onjuisteplek + " correcte letter op de onjuiste plek staan");
        }
        if (onjuisteplek < enkeleLetter){ //zodat de min getallen door de dubbele letter methode niet worden meegenomen.
            System.out.println("Je hebt 0 correcte letters op de onjuiste plek staan");

        } else if (onjuisteplek > enkeleLetter) {
            System.out.println("Je hebt " + onjuisteplek + " correcte letters op een onjuiste plek staan");
        }
    }
}













