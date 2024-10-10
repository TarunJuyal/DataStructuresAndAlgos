package Graphs;

import java.util.HashMap;
import java.util.Map;

public class MyGraph {
    private class Vertex{
        private String label;
        private Map<String,Integer> neighbours;

        public Vertex(String label) {
            this.label = label;
            this.neighbours = new HashMap<>();
        }
    }

    private Map<String,Vertex> vertices = new HashMap<>();

    public int size(){
        return this.vertices.size();
    }
    public int noOfEdges(){
        int count=0;
        for(Map.Entry<String,Vertex> currentVertex: this.vertices.entrySet())
            count+=currentVertex.getValue().neighbours.size();
        return count;
    }

    public void addVertex(String label){
        if(label==null || label.trim().isEmpty()) throw new IllegalArgumentException("String is either null or Empty");
        Vertex vertex = new Vertex(label);
        this.vertices.putIfAbsent(label,vertex);
    }

    private boolean doesEdgeExist(Vertex from, Vertex to){
        return from!=null && to!=null && from.neighbours.containsKey(to.label);
    }
    public void addEdge(String from, String to, int weight){
        Vertex fromVertex=vertices.get(from);
        Vertex toVertex=vertices.get(to);
        if(fromVertex==null || toVertex==null) throw new IllegalArgumentException("One of the Vertex Don't Exist");

        if(doesEdgeExist(fromVertex,toVertex)) return;

        fromVertex.neighbours.put(toVertex.label,weight);
    }

    public void removeVertex(String label){
        if(label==null || label.trim().isEmpty()) throw new IllegalArgumentException("String is either null or Empty");
        if(this.vertices.isEmpty()) return;
        Vertex vertex=vertices.get(label);
        if(vertex == null) throw new IllegalArgumentException("This Vertex doesn't exist");

        //  remove edge if it's neighbour of any other vertex
        for(Map.Entry<String,Vertex> currentVertex: this.vertices.entrySet()){
            if(currentVertex.getValue().neighbours.containsKey(label))
                currentVertex.getValue().neighbours.remove(label);
        }
        //  remove vertex from vertices Map
        this.vertices.remove(label);
    }

    public void removeEdge(String from, String to){
        Vertex fromVertex=vertices.get(from);
        Vertex toVertex=vertices.get(to);
        if(fromVertex==null || toVertex==null) throw new IllegalArgumentException("One of the Vertex Don't Exist");

        if(!doesEdgeExist(fromVertex,toVertex)) return;

        fromVertex.neighbours.remove(toVertex.label);
    }

    public void print(){
        for(Map.Entry<String,Vertex> vertex : this.vertices.entrySet()){
            System.out.println("Vertex:"+vertex.getKey()+" => Neighbours:"+vertex.getValue().neighbours);
        }
    }
}
