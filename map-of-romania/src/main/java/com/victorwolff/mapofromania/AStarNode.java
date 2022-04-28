package com.victorwolff.mapofromania;

import java.util.ArrayList;
import java.util.List;

public class AStarNode implements Comparable<AStarNode> {
    private final String name;

    // Parent in the path
    AStarNode parent = null;

    List<Edge> neighbors;

    double f = Double.MAX_VALUE;
    double g = Double.MAX_VALUE;
    double h;

    AStarNode(String name, double h) {
        this.h = h;
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public int compareTo(AStarNode n) {
        return Double.compare(this.f, n.f);
    }

    public static class Edge {
        Edge(int weight, AStarNode node) {
            this.weight = weight;
            this.node = node;
        }

        int weight;
        AStarNode node;
    }

    public void addBranch(AStarNode node, int weight) {
        Edge newEdge = new Edge(weight, node);
        neighbors.add(newEdge);
    }

    public double calculateHeuristic(AStarNode target) {
        // TODO: improve heuristic using Manhattan or Chebyshev distance
        return this.h;
    }

    public String getName() {
        return name;
    }
}