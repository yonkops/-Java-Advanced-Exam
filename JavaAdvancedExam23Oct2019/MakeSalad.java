package JavaAdvancedExam23Oct2019;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MakeSalad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedList<String> vegetables = new LinkedList<>();
        LinkedList<String> calories = new LinkedList<>();
        Collections.addAll(vegetables, scanner.nextLine().split(" "));
        Collections.addAll(calories, scanner.nextLine().split(" "));

        while (!vegetables.isEmpty() || !calories.isEmpty()){
            makeSalad(vegetables, calories);
        }

        System.out.println();
        while (!vegetables.isEmpty()){
            System.out.print(vegetables.pollFirst() + " ");
        }
        while (!calories.isEmpty()){
            System.out.print(calories.pollLast() + " ");
        }

    }
    private static void makeSalad(LinkedList vegetables, LinkedList calories){

        if (!calories.isEmpty()) {
            int bowl = Integer.parseInt(calories.pollLast().toString());
            System.out.print(bowl + " ");
            while (!vegetables.isEmpty() && bowl > 0){
                switch (vegetables.pollFirst().toString()){
                    case "carrot":
                        bowl -= 136;
                        break;
                    case "lettuce" :
                        bowl -= 109;
                        break;
                    case "potato" :
                        bowl -= 215;
                        break;
                    case "tomato" :
                        bowl -= 80;
                        break;
                }
            }
        }

    }
}
