package com.victorwolff.mapofromania;

import com.victorwolff.common.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearch implements Algorithm {
    private final AStarNode start;
    private final AStarNode target;

    public AStarSearch(AStarNode start, AStarNode target) {
        this.start = start;
        this.target = target;
    }

    @Override
    public String solve() {
        AStarNode result = start();
        return printPath(result);
    }

    private AStarNode start() {
        PriorityQueue<AStarNode> closedList = new PriorityQueue<>();
        PriorityQueue<AStarNode> openList = new PriorityQueue<>();

        start.f = start.g + start.calculateHeuristic(target);
        openList.add(start);

        while (!openList.isEmpty()) {
            AStarNode n = openList.peek();
            if (n == target) {
                return n;
            }

            for (AStarNode.Edge edge : n.neighbors) {
                AStarNode m = edge.node;
                double totalWeight = n.g + edge.weight;

                if (!openList.contains(m) && !closedList.contains(m)) {
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openList.add(m);
                } else {
                    if (totalWeight < m.g) {
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);

                        if (closedList.contains(m)) {
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }

            openList.remove(n);
            closedList.add(n);
        }
        return null;
    }

    private static String printPath(AStarNode target) {
        AStarNode n = target;

        if (n == null)
            return "No suitable solution found";

        List<String> path = new ArrayList<>();

        while (n.parent != null) {
            path.add(n.getName());
            n = n.parent;
        }
        path.add(n.getName());
        Collections.reverse(path);

        StringBuilder builder = new StringBuilder();
        for (String node : path) {
            builder.append(node);
            builder.append("\n");
        }
        return builder.toString();
    }
}
