package com.victorwolff.waterjug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugs {
    int first;
    int second;
    List<Jugs> path;

    Jugs(int firstJug, int secondJug) {
        first = firstJug;
        second = secondJug;
        path = new ArrayList<>();
    }

    Jugs(int firstJug, int secondJug, List<Jugs> newPath) {
        first = firstJug;
        second = secondJug;

        path = new ArrayList<>();
        path.addAll(newPath);
        path.add(new Jugs(first, second));
    }

    /**
     *
     * @param target Target jug value
     * @return {@link List} of {@link Jugs}, or empty {@link List} if state is not validated
     */
    public List<Jugs> validateState(int target) {
        if (first == target || second == target) {
            if (first == target && second != 0) {
                path.add(new Jugs(first, 0));
            } else if (second == target && first != 0){
                path.add(new Jugs(0, second));
            }
            return path;
        }

        return Collections.emptyList();
    }

}
