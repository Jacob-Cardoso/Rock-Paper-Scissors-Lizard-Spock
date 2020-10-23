import java.util.Scanner;
import java.util.Random;

class Calculations {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    
    int playerNumber, computerNumber, mod;
    String playerString, computerString, resultString;
    
    int[] playerChoice = {0, 0, 0, 0, 0};
    int[] computerChoice = {0, 0, 0, 0, 0};
    
    int gameCalc() {
        System.out.print("0:Rock, 1:Spock, 2:Paper, 3:Lizard, 4:Scissors: ");     

        playerNumber = scan.nextInt();
        computerNumber = rand.nextInt(5); 
        
        mod = playerNumber - computerNumber;

        playerString = resultCalc(playerNumber);
        computerString = resultCalc(computerNumber);

        for(int i=0; i < 5; i++) {
            if (playerNumber == i) {
                playerChoice[i] += 1;
            }
            if (computerNumber == i) {
                computerChoice[i] += 1;
            }
        }

        statement();

        if (playerNumber == computerNumber) {
            System.out.println("\nTie!");
            System.out.println(playerString + resultString + computerString);
            return 0;
        }
        else if (Math.floorMod(mod, 5) < 3){
            System.out.println("\nPlayer Wins This Round!");
            System.out.println(playerString + resultString + computerString);
            return 1;
        }    
        else if (Math.floorMod(mod, 5) >= 3) {
            System.out.println("\nComputer Wins This Round!");
            System.out.println(playerString + resultString + computerString);
            return 2;
        }
        else{return 5;} 
    }

    String resultCalc(int i) {

        switch(i) {
            case 0:
                playerChoice[0] += 1;
                return "Rock";
            case 1:
                return "Spock";
            case 2:
                return "Paper";
            case 3:
                return "Lizard";
            case 4:
                return "Scissors";
            default:
                return "Invalid Input";
            }
    }
    void statement() {
        String results[][] = {
            { " Loves ", " Vaporized By ", " Coverd By ", " Crushes ", " Crushes "  },
            { " Vaporizes ", " Loves ", " Is disproved By ", " Poisoned By ", " Smashes " },
            { " Covers ", " Disproves ", " Loves ", " Eaten By ", " Cut By " },
            { " Crushed By ", " Poisons ", " Eats ", " Loves ", " Decapitated By " },
            { " Crushed By ", " Smashed By ", " Cuts ", " Decapitates ", " Loves " }
        };
        resultString = results[playerNumber][computerNumber];
    }
}       

public class JacobCardosoRPSLZ {
    public static void main(String[] args) {
        int pWins, cWins;
        int tpWins, tcWins, tTies;
        int n, temp;
        String cont;
        boolean val;

        val = true;

        pWins = cWins = 0;
        tpWins = tcWins = tTies = 0;

        Scanner scan1 = new Scanner(System.in);
        Calculations myCalc = new Calculations();
        
        while (true) {

        System.out.print("Best Of One Press: 1. Best Of Three Press: 2. Best Of Five Press: 3. View Stats Press: 4: ");
        
        n = scan1.nextInt();
            switch(n) {
                case 1:
                    pWins = cWins = 0;
                    while (val) {
                    temp = myCalc.gameCalc();
                    
                        if (temp == 0) {tTies += 1;}
                        if (temp == 1) {pWins += 1;}
                        if (temp == 2) {cWins += 1;}

                        if (cWins == 1) {
                            System.out.println("\nComputer Wins The Match!");
                            tcWins += 1;
                            val = false;
                        }
                        if (pWins == 1) {
                            System.out.println("\nPlayer Wins The Match!");
                            tpWins += 1;
                            val = false;
                        }
                    }
                    break;

                case 2:
                    pWins = cWins = 0;

                    while (val) {
                        temp = myCalc.gameCalc();
                    
                        if (temp == 0) {tTies += 1;}
                        if (temp == 1) {pWins += 1;}
                        if (temp == 2) {cWins += 1;}
                    
                        if (cWins == 2) {
                            System.out.println("\nComputer Wins The Match " + cWins + " to " + pWins);
                            tcWins += 1;
                            val = false;
                        }
                        if (pWins == 2) {
                            System.out.println("\nPlayer Wins The Match " + pWins + " to " + cWins);
                            tpWins += 1;
                            val = false;
                        }
                    }
                    break;
                case 3:
                    pWins = cWins = 0;

                    while (val) {
                        temp = myCalc.gameCalc();
                        
                        if (temp == 0) {tTies += 1;}
                        if (temp == 1) {pWins += 1;}
                        if (temp == 2) {cWins += 1;}

                        if (cWins == 3) {
                            System.out.println("\nComputer Wins The Match " + cWins + " to " + pWins);
                            tcWins += 1;
                            val = false;
                        }
                        else if (pWins == 3) {
                            System.out.println("\nPlayer Wins The Match " + pWins + " to " + cWins);
                            tpWins += 1;
                            val = false;
                        }
                    }
                    break;
                case 4:
                // change to usee arrays.
                    System.out.println("\nStats: \nTotal Player Match Wins: " + tpWins + "\nTotal Computer Match Wins: " + tcWins + "\nTotal Round Ties: " + tTies);
                    System.out.println("\nPlayer Choices: Rock: " + myCalc.playerChoice[0] + " Paper: " + myCalc.playerChoice[1] + " Scissors: " + myCalc.playerChoice[2] + " Lizard " + myCalc.playerChoice[3] + " Spock: " + myCalc.playerChoice[4]);
                    System.out.println("Computer Choices: Rock: " + myCalc.computerChoice[0] + " Paper: " + myCalc.computerChoice[1] + " Scissors: " + myCalc.computerChoice[2] + " Lizard " + myCalc.computerChoice[3] + " Spock: " + myCalc.computerChoice[4] + "\n");
                    continue;
            }    

            System.out.println("Enter N To Quit Or Y To Play Again: ");
            cont = scan1.next();

            if (cont.equals("N") | cont.equals("n")) {
                scan1.close();
                break;
            }
            else {val = true; continue;}    
        }


        scan1.close();

    }
}
