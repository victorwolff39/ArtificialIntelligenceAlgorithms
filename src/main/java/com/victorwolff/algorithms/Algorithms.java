package com.victorwolff.algorithms;

import com.victorwolff.mapofromania.MapOfRomania;
import com.victorwolff.waterjug.WaterJug;

import java.util.Scanner;

public class Algorithms {

    public static void main(String[] args) {
        System.out.println("""
                Chose which algorithm you would like to test:
                1 - Water Jug Problem
                2 - Map of Romania
                """);

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(WaterJug.start());
            case 2:
                System.out.println(MapOfRomania.start());
        }
    }
}
