package javaDataStructures.JavaAdvancedExam23Oct2019;

import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        scan.nextLine();
        String[] rowsArray = new String[rows];
        int cols = 0;
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int moleAttaks = 0;


        for (int i = 0; i < rows ; i++) {
            rowsArray[i] = scan.nextLine().replaceAll("\\s", "");
            if(cols < rowsArray[i].length()) {
                cols = rowsArray[i].length();
            }
        }
        char[][] garden = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            garden[i] = rowsArray[i].toCharArray();
        }
        String nextLineInput = scan.nextLine();
        while (!nextLineInput.equals("End of Harvest")){
            String action[] = nextLineInput.split("\\s");
            int row = Integer.parseInt(action[1]);
            int col = Integer.parseInt(action[2]);
            if (row < garden.length && col < garden[row].length){
                switch (action[0]){
                    case "Harvest" :
                        switch (garden[row][col]){
                            case 'C' :
                                garden[row][col] = ' ';
                                carrots++;
                                break;
                            case 'P' :
                                garden[row][col] = ' ';
                                potatoes++;
                                break;
                            case 'L' :
                                garden[row][col] = ' ';
                                lettuce++;
                                break;
                        }
                        break;
                    case "Mole" :
                        switch (action[3]){
                            case "up" :
                                while ((row < garden.length && row >= 0) && (col < garden[row].length && col >= 0)){
                                    if(garden[row][col] == 'C' || garden[row][col] == 'P' || garden[row][col] == 'L'){
                                        garden[row][col] = ' ';
                                        moleAttaks++;
                                    }
                                    row -= 2;
                                }
                                break;
                            case "down" :
                                while ((row < garden.length && row >= 0) && (col < garden[row].length && col >= 0)){
                                    if(garden[row][col] == 'C' || garden[row][col] == 'P' || garden[row][col] == 'L'){
                                        garden[row][col] = ' ';
                                        moleAttaks++;
                                    }
                                    row += 2;
                                }

                                break;
                            case "left" :
                                while ((row < garden.length && row >= 0) && (col < garden[row].length && col >= 0)){
                                    if(garden[row][col] == 'C' || garden[row][col] == 'P' || garden[row][col] == 'L'){
                                        garden[row][col] = ' ';
                                        moleAttaks++;
                                    }
                                    col -= 2;
                                }
                                break;
                            case "right" :
                                while ((row < garden.length && row >= 0) && (col < garden[row].length && col >= 0)){
                                    if(garden[row][col] == 'C' || garden[row][col] == 'P' || garden[row][col] == 'L'){
                                        garden[row][col] = ' ';
                                        moleAttaks++;
                                    }
                                    col += 2;
                                }
                                break;
                        }
                        break;
                }
            }

            nextLineInput = scan.nextLine();
        }
        printCharArray(garden);
        System.out.println("Carrots: "+carrots);
        System.out.println("Potatoes: "+potatoes);
        System.out.println("Lettuce: "+lettuce);
        System.out.println("Harmed vegetables: "+moleAttaks);
    }

    private static void printCharArray(char[][] charArray){
        for (int i = 0; i < charArray.length; ++i) {
            for(int j = 0; j < charArray[i].length; ++j) {
                System.out.print(charArray[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
