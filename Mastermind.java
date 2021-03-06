package com.mastermind;
//soms buggy met dubbele letters,deze worden twee x meegeteld als correcte letter.

import java.util.Scanner;

public class Mastermind {
    Computer computer = new Computer();
    Scanner scanner = new Scanner(System.in);

    void start(){
        printWelkom();
        computer.genereerComputerCode();
        while (true) {
            meldingInvoerCode();
            String spelersInput = scanner.nextLine().toLowerCase().replaceAll("[ghijklmnoprstuwvxyz]","").
                    replaceAll("\\d+","");
            //replaceAll etc. negeert alle nummers/letters na de G (behalve Q) in de string en vervangt dit met "".
            if(spelersInput.equals("q")){
                meldingStopSpel();
                break;
            }else if (spelersInput.isEmpty()){
                meldingOngeldigeInvoer();
            }else if(spelersInput.length() != computer.getVerborgenCode().length()) {
                meldingOnvolledigeInvoer(spelersInput);
            }else if(spelersInput.equals(computer.getVerborgenCode())){
               meldingGewonnen();
                break;
            }else computer.checkAntwoordSpeler(spelersInput);
        }
    }

    void printWelkom(){
        System.out.println("Welkom bij Mastermind! Je moet een code, " +
                "bestaande uit vier letters kraken! Gaat dit je lukken?");
        System.out.println("************************************************************************************************");
    }

    void meldingInvoerCode(){
        System.out.println("Vul jouw code in. Je kunt kiezen uit a,b,c,d,e,f " +
                "(houd er rekening mee dat 1 letter vaker kan voorkomen). Wil je stoppen? type dan 'q': ");
    }

    void meldingStopSpel(){
        System.out.println("De verborgen code was " + computer.getVerborgenCode());
    }

    void meldingOngeldigeInvoer(){
        System.out.println("Het veld is leeg, je hebt nummers ingevoerd " +
                "en/of letters gekozen die niet mee tellen! Doe nogmaals een poging!");
    }
    void meldingOnvolledigeInvoer(String invoer){
        System.out.println("Je hebt " + (invoer.length()) +  " " +
                "karakters ingevoerd. Je mag maximaal vier letters invoeren (a,b,c,d,e of f).");
    }
    void meldingGewonnen(){
        System.out.println("YES! Je hebt de code gekraakt in " + computer.getAantalKeerGeraden()
                + " pogingen! De code was " + computer.getVerborgenCode());

    }
}
