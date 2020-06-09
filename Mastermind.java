package com.mastermind;

import java.util.Scanner;

public class Mastermind {
    Computer computer = new Computer();
    Scanner scanner = new Scanner(System.in);

    void start(){
        printWelkom();
        computer.genereerComputerCode();
        while (true) {
            System.out.println("Vul jouw code in. Je kunt kiezen uit a,b,c,d,e,f. Wil je stoppen? type dan 'q': ");
            String spelersInput = scanner.nextLine().toLowerCase().
                    replaceAll("[ghijklmnoprstuwvxyz]","").replaceAll("\\d+","");
            //replaceAll etc. negeert alle nummers/letters na de H (behalve Q) in de string en vervangt dit met "".

            if(spelersInput.equals("q")){
                System.out.println("De verborgen code was " + computer.getVerborgenCode());
                break;
            }else if (spelersInput.isEmpty()){
                System.out.println("Het veld is leeg, je hebt nummers ingevoerd " +
                        "en/of letters gekozen die niet mee tellen! Doe nogmaals een poging!");
            }else if(spelersInput.length() != computer.getVerborgenCode().length()) {
                System.out.println("Je moet vier letters kiezen uit a,b,c,d,e of f!");
            }else if(spelersInput.equals(computer.getVerborgenCode())){
                System.out.println("YES! Je hebt de code gekraakt in " + computer.getAantalKeerGeraden()
                        + " pogingen! De code was " + computer.getVerborgenCode());
                break;
            }else computer.checkAntwoordSpeler(spelersInput);
        }
    }

    void printWelkom(){
        System.out.println("Welkom bij Mastermind! Je moet een code, " +
                "bestaande uit vier letters kraken! Gaat dit je lukken?");
        System.out.println("************************************************************************************************");
    }
}
