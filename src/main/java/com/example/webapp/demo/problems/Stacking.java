package com.example.webapp.demo.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class Stacking {

    static int n;
    static int k;

    static Map<Integer, Integer> interestingPoints = new HashMap<>();
    static Map<Integer, Integer> stacks = new HashMap<>();


    public static void main(String[] args) throws FileNotFoundException {
        int inputNumber = 10;

        String inputFileName = "DATA/stacking/" + inputNumber + ".in";
        Scanner scanner = new Scanner(new File(inputFileName));

        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();

//        System.out.println(n);
//        System.out.println(k);


        for (int i = 1; i <= k; i++) {
            int begin = scanner.nextInt();
            int end = scanner.nextInt() + 1;
            scanner.nextLine();

            addInterestingPoint(begin, 1);
            addInterestingPoint(end, -1);


//            System.out.println(begin);
//            System.out.println(end);

        }

        System.out.println(interestingPoints);


        List<Integer> allPoints = new ArrayList<>(interestingPoints.keySet());
        Collections.sort(allPoints);
        System.out.println(allPoints);

        int currentPoint = 1;
        int currentAmount = 0;


        for (Integer nextPoint : allPoints) {
            addStacks(currentAmount, nextPoint - currentPoint);
            currentAmount = currentAmount + interestingPoints.get(nextPoint);
            currentPoint = nextPoint;
        }

        addStacks(currentAmount, n - currentPoint + 1);


        int interestingStackNumber = (n + 1) / 2;
        List<Integer> allSizes = new ArrayList<>(stacks.keySet());
        Collections.sort(allSizes);

        int stacksNuberSeen = 0;
        int answer = -1;

        for (int stackSize : allSizes) {
            int newStacks = stacks.get(stackSize);

            stacksNuberSeen = stacksNuberSeen + newStacks;

            if (stacksNuberSeen >= interestingStackNumber) {
                answer = stackSize;
                break;
            }
        }



        System.out.println(answer);

    }

    private static void addStacks(int amount, int difference) {
        if (!stacks.containsKey(amount)) {
            stacks.put(amount, 0);
        }
        int newValue = stacks.get(amount) + difference;
        stacks.put(amount, newValue);
    }

    private static void addInterestingPoint(int position, int difference) {
        if (!interestingPoints.containsKey(position)) {
            interestingPoints.put(position, 0);
        }

        int newValue = interestingPoints.get(position) + difference;
        interestingPoints.put(position, newValue);

    }


}