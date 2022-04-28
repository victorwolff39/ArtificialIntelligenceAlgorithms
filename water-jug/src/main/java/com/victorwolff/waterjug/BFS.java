package com.victorwolff.waterjug;

import com.victorwolff.common.Algorithm;

import java.util.*;

public class BFS implements Algorithm {
    int firstJug;
    int secondJug;
    int target;
    boolean[][] visited;

    public BFS(int firstJug, int secondJug, int target) {
        this.firstJug = firstJug;
        this.secondJug = secondJug;
        this.target = target;
        this.visited = new boolean[firstJug + 1][secondJug + 1];
    }

    @Override
    public String solve() {
        Queue<Jugs> queue = new LinkedList<>();

        // Set queue's initial state
        Jugs initialState = new Jugs(0, 0);
        initialState.path.add(new Jugs(0, 0));
        queue.add(initialState);

        queue.add(new Jugs(0, 0)); //Start the queue with empty jugs
        while (!queue.isEmpty()) {
            Jugs current = queue.poll();

            // Skip if state is already visited or if it is invalid (overflowing)
            if (alreadyVisited(current) || overflow(current)) continue;

            setVisited(current);

            // Check if the current state is valid (if any jugs has the target value)
            List<Jugs> validPath = current.validateState(target);
            if (!validPath.isEmpty()) {
                return pathToString(validPath);
            }

            // Fill one and empty the other
            queue.add(new Jugs(firstJug, 0, current.path));
            queue.add(new Jugs(0, secondJug, current.path));

            // Fill one
            queue.add(new Jugs(firstJug, current.second, current.path));
            queue.add(new Jugs(current.first, secondJug, current.path));

            // Empty one
            queue.add(new Jugs(0, current.second, current.path));
            queue.add(new Jugs(current.first, 0, current.path));

            // Transfer water form firstJug to secondJug
            int emptyJug = secondJug - current.second;
            int amountTransferred = Math.min(current.first, emptyJug);
            int jug1 = current.second + amountTransferred;
            int jug2 = current.first - amountTransferred;
            queue.add(new Jugs(jug2, jug1, current.path));

            //Transfer water form secondJug to firstJug
            emptyJug = firstJug-current.first;
            amountTransferred = Math.min(current.second, emptyJug);
            jug1 = current.second-amountTransferred;
            jug2 = current.first+amountTransferred;
            queue.add(new Jugs(jug2, jug1,current.path));
        }

        return "Impossible operation!";
    }

    // Check if a state has already been visited
    private boolean alreadyVisited(Jugs jugs) {
        return visited[jugs.first][jugs.second];
    }

    // Check if the water is overflowing (Eg: trying to put 5L in a 4L gallon)
    private boolean overflow(Jugs jugs) {
        return jugs.first > firstJug || jugs.second > secondJug;
    }

    private void setVisited(Jugs jugs) {
        visited[jugs.first][jugs.second] = true;
    }

    private String pathToString(List<Jugs> jugs) {
        StringBuilder builder = new StringBuilder();
        jugs.forEach(jug -> {
            builder.append(jug.first);
            builder.append(" , ");
            builder.append(jug.second);
            builder.append("\n");
        });
        return builder.toString();
    }
}
