package com.victorwolff.mapofromania;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AStarSearchTest {

    @Test
    void shouldSolveASearchCorrectly() {
        String expected = """
                1
                2
                3
                4
                5
                """;

        AStarNode aradNode = new AStarNode("1", 366);
        AStarNode bucharestNode = new AStarNode("5", 0);

        // Node list
        AStarNode sibiuNode = new AStarNode("2", 253);
        AStarNode rimnicuNode = new AStarNode("3", 193);
        AStarNode pitestiNode = new AStarNode("4", 100);
        AStarNode craiovaNode = new AStarNode("WrongAnswer1", 160);
        AStarNode fagarasNode = new AStarNode("WrongAnswer2", 176);
        AStarNode oradeaNode = new AStarNode("WrongAnswer3", 380);
        AStarNode timisoaraNode = new AStarNode("WrongAnswer4", 329);
        AStarNode zerindNode = new AStarNode("WrongAnswer5", 374);

        // Branches (simplified)
        aradNode.addBranch(sibiuNode, 140);
        aradNode.addBranch(timisoaraNode, 118);
        aradNode.addBranch(zerindNode, 75);

        sibiuNode.addBranch(aradNode, 280);
        sibiuNode.addBranch(fagarasNode, 239);
        sibiuNode.addBranch(oradeaNode, 291);
        sibiuNode.addBranch(rimnicuNode, 220);

        rimnicuNode.addBranch(craiovaNode, 526);
        rimnicuNode.addBranch(pitestiNode, 317);
        rimnicuNode.addBranch(sibiuNode, 300);

        pitestiNode.addBranch(bucharestNode, 418);
        pitestiNode.addBranch(craiovaNode, 455);
        pitestiNode.addBranch(rimnicuNode, 414);


        String result = new AStarSearch(aradNode, bucharestNode).solve();

        assertEquals(expected, result);
    }
}
