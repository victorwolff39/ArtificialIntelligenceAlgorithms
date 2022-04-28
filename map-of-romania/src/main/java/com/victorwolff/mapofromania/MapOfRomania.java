package com.victorwolff.mapofromania;

public class MapOfRomania {

    public static String start() {
        AStarNode aradNode = new AStarNode("Arad", 366);
        AStarNode bucharestNode = new AStarNode("Bucharest", 0);

        // Node list
        AStarNode craiovaNode = new AStarNode("Craiova", 160);
        AStarNode dobretaNode = new AStarNode("Dobreta", 242);
        AStarNode eforieNode = new AStarNode("Eforie", 161);
        AStarNode fagarasNode = new AStarNode("Fagaras", 176);
        AStarNode giurgiuNode = new AStarNode("Giurgiu", 77);
        AStarNode hirsowaNode = new AStarNode("Hirsowa", 151);
        AStarNode lasiNode = new AStarNode("Lasi", 226);
        AStarNode lugojNode = new AStarNode("Lugoj", 244);
        AStarNode mehadiaNode = new AStarNode("Mehadia", 241);
        AStarNode neamtNode = new AStarNode("Neamt", 234);
        AStarNode oradeaNode = new AStarNode("Oradea", 380);
        AStarNode pitestiNode = new AStarNode("Pitesti", 100);
        AStarNode rimnicuNode = new AStarNode("Rimnicu", 193);
        AStarNode sibiuNode = new AStarNode("Sibiu", 253);
        AStarNode timisoaraNode = new AStarNode("Timisoara", 329);
        AStarNode urziceniNode = new AStarNode("Urziceni", 80);
        AStarNode vasluiNode = new AStarNode("Vaslui", 199);
        AStarNode zerindNode = new AStarNode("Zerind", 374);

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


        return new AStarSearch(aradNode, bucharestNode).solve();
    }
}
