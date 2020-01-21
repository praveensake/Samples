package com.sake.core.datastructures;

import java.util.*;

/*
This class implements a graph using adjacency list implementation
Other ways to implement graph are edge list and adjacency matrix
And builds the below graph with nodes and vertices
3--4--5
|  |  |
1--2  6
\ /
 0
 */
public class UndirectedGraph {

    private static LinkedList<GraphNode> adjacencyList;

    public static void main(String[] args) {
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        //Create Graph Nodes
        GraphNode n0 = new GraphNode(0);
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);

        //Add nodes to the graph
        undirectedGraph.addVertex(n0);
        undirectedGraph.addVertex(n1);
        undirectedGraph.addVertex(n2);
        undirectedGraph.addVertex(n3);
        undirectedGraph.addVertex(n4);
        undirectedGraph.addVertex(n5);
        undirectedGraph.addVertex(n6);

        //Add edges to the graph
        undirectedGraph.addEdge(n0, n1);
        undirectedGraph.addEdge(n0, n2);
        undirectedGraph.addEdge(n1, n2);
        undirectedGraph.addEdge(n1, n3);
        undirectedGraph.addEdge(n2, n4);
        undirectedGraph.addEdge(n3, n4);
        undirectedGraph.addEdge(n4, n5);
        undirectedGraph.addEdge(n5, n6);

        //Print the graph nodes and edges
        displayNodes();

    }

    private static void displayNodes() {
        for (GraphNode graphNode : adjacencyList) {
            System.out.println(graphNode.getValue() + "-->" + graphNode.getEdges());
        }
    }

    private UndirectedGraph(){
        adjacencyList = new LinkedList<>();
    }

    private void addVertex(GraphNode graphNode){
        adjacencyList.add(graphNode);
    }

    private void addEdge(GraphNode graphNode1, GraphNode graphNode2){
        graphNode1.addEdge(graphNode2.getValue());
        graphNode2.addEdge(graphNode1.getValue());
    }

    public static class GraphNode {
        int value;
        List<Integer> edges;

        private GraphNode(int value){
            this.value = value;
            this.edges = new ArrayList<>();
        }

        private int getValue(){
            return this.value;
        }

        private void addEdge(Integer value){
            this.edges.add(value);
        }

        private List<Integer> getEdges(){
            return edges;
        }

        @Override
        public String toString() {
            return "GraphNode{" +
                    "value=" + value +
                    ", edges=" + edges +
                    '}';
        }
    }

}
