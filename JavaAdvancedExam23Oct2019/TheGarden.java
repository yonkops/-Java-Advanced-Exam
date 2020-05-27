package JavaAdvancedExam23Oct2019;

import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        String garden[][] = new String[rows][];

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int moleAttacks = 0;

        for (int i = 0; i < rows; i++) {
            String[] input = scan.nextLine().split(" ");
            garden[i] = input;
        }
        String str = "";

        String nextLineInput = scan.nextLine();
        while (!nextLineInput.equals("End of Harvest")){
            String action[] = nextLineInput.split(" ");
            int row = Integer.parseInt(action[1]);
            int col = Integer.parseInt(action[2]);
            if (row < garden.length && col < garden[row].length ){
                if (action[0].equals("Harvest")){
                    // Harvesting vegetables
                    switch (garden[row][col]){
                        case "C" :
                            garden[row][col] = " ";
                            carrots++;
                            break;
                        case "P" :
                            garden[row][col] = " ";
                            potatoes++;
                            break;
                        case "L" :
                            garden[row][col] = " ";
                            lettuce++;
                            break;
                    }
                } else if (action[0].equals("Mole")){
                    if (action[3].equals("up")){
                        // Eat every vegetables in this direction by 2
                        while ( row >= 0 && col < garden[row].length){
                            // check if is on valid field
                            if(!garden[row][col].equals(" ")){
                                garden[row][col] = " ";
                                moleAttacks++;
                            }
                            row -= 2;
                        }
                    } else if(action[3].equals("down")){
                        while (row < garden.length && col < garden[row].length){
                            if(!garden[row][col].equals(" ")){
                                garden[row][col] = " ";
                                moleAttacks++;
                            }
                            row += 2;
                        }
                    } else if(action[3].equals("left")){
                        while ((col >= 0)){
                            if(!garden[row][col].equals(" ")){
                                garden[row][col] = " ";
                                moleAttacks++;
                            }
                            col -= 2;
                        }
                    } else if(action[3].equals("right")){
                        while (col < garden[row].length){
                            if(!garden[row][col].equals(" ")){
                                garden[row][col] = " ";
                                moleAttacks++;
                            }
                            col += 2;
                        }
                    }
                }
            }
            nextLineInput = scan.nextLine();
        }

        printGarden(garden);
        System.out.println("Carrots: "+carrots);
        System.out.println("Potatoes: "+potatoes);
        System.out.println("Lettuce: "+lettuce);
        System.out.println("Harmed vegetables: "+moleAttacks);
    }

    private static void printGarden(String[][] charArray){
        for (int i = 0; i < charArray.length; ++i) {
            for(int j = 0; j < charArray[i].length; ++j) {
                System.out.print(charArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
