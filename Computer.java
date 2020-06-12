package com.mastermind;

import java.util.Random;

public class Computer {
    String computerCode = "";
    int aantalCorrecteLettersOpJuistePlek = 0;
    int aantalCorrecteLettersOpOnjuistePlek = 0;
    int aantalDubbeleCorrecteLettersOpOnjuistePlek = 0;
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
        //werkt soms voor dubbele letters, soms ook niet, but hey its something.
        if(checkVoorDubbeleLetters()) {
            System.out.println("pc code heeft dubbele letters");
            for (int i = 0; i < computerCode.length(); i++) {
                if ((computerCode.charAt(i) == spelersCode.charAt(i))) { //checken voor dezelfde  plek en letter.
                    aantalCorrecteLettersOpJuistePlek++;
                }
                if (spelersCode.contains(String.valueOf(computerCode.charAt(i))) &&
                        spelersCode.charAt(i) != computerCode.charAt(i)) {
                    aantalCorrecteLettersOpOnjuistePlek++;
                    System.out.println("check 1");
                }else if (spelersCode.substring(i).equals(computerCode.substring(i))) { //als speler toevallig de dezelfde dubbele volgorde invoert als pccode met dubbele letters.
                    aantalCorrecteLettersOpOnjuistePlek--;
                    System.out.println("check 2");
                 }
            }
        }
        //hieronder werkt voor vier en twee verschillende letters in de code
        else
            for (int i = 0; i < computerCode.length(); i++) {
                if ((computerCode.charAt(i) == spelersCode.charAt(i))) { //checken voor dezelfde  plek en letter.
                    aantalCorrecteLettersOpJuistePlek++;
                    System.out.println("pc code heeft geen dubbele letters");
                } else if (spelersCode.contains(String.valueOf(computerCode.charAt(i))) && //als de code deze juist letter bevat, maar niet op de correcte plek.
                        spelersCode.charAt(i) != computerCode.charAt(i)) {
                    aantalCorrecteLettersOpOnjuistePlek++;
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
        for (var i = 0; i < pcCode.length; i++) {
            for (var j = 0; j < pcCode.length; j++) {
                if (i != j) {
                    if (pcCode[i] == pcCode[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
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













