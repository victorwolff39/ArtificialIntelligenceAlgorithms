package com.victorwolff.waterjug;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WaterJug {
    static final String INVALID_VALUE = "Invalid value!";

    private WaterJug() {
    }

    public static String start() {
        Scanner scanner = new Scanner(System.in);
        int firstJug;
        int secondJug;
        int target;

        System.out.println("\n \n \n \n \n");
        System.out.println("First jug capacity: ");
        try {
            firstJug = scanner.nextInt();
        } catch (InputMismatchException e) {
            return INVALID_VALUE;
        }

        System.out.println("Second jug capacity: ");
        try {
            secondJug = scanner.nextInt();
        } catch (InputMismatchException e) {
            return INVALID_VALUE;
        }

        System.out.println("Target value: ");
        try {
            target = scanner.nextInt();
        } catch (InputMismatchException e) {
            return INVALID_VALUE;
        }

        BFS bfs = new BFS(firstJug, secondJug, target);

        System.out.println("\n \n \n \n \n");
        System.out.printf("Solving the Water Jug Problem with a %sL and %sL Jug. Target set for %sL: %n %n", firstJug, secondJug, target);
        return bfs.solve();
    }
}
