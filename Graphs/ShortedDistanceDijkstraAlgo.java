package Graphs;

import java.util.*;

public class MyGraph {
    private class Vertex{
        private String label;
        private Map<String,Integer> neighbours;

        public Vertex(String label) {
            this.label = label;
            this.neighbours = new HashMap<>();
        }
    }

    private class VertexQueuePriority{
        private Vertex vertex;
        private int priority;

        public VertexQueuePriority(Vertex vertex, int priority) {
            this.vertex = vertex;
            this.priority = priority;
        }
    }

    private Map<String,Vertex> vertices = new HashMap<>();

    public int shortestDistanceDijkstraAlgo(String from, String to){
        Vertex fromVertex = this.vertices.get(from);
        Vertex toVertex = this.vertices.get(to);
        if(fromVertex == null || toVertex == null) throw new IllegalArgumentException("One of the node don;t exist");

        //  Crete a distances hashmap with distances set to max value except source
        Map<String, Integer> distances = new HashMap<>();
        for(Map.Entry<String,Vertex> vertex: this.vertices.entrySet())
            distances.put(vertex.getKey(),Integer.MAX_VALUE);
        distances.replace(fromVertex.label,0);

        Set<String> visited = new HashSet<>();
        //  priorityqueue to fetch neighbour by weight priority
        PriorityQueue<VertexQueuePriority> pq = new PriorityQueue<>(Comparator.comparingInt(vqp->vqp.priority));

        //  add first vertex to queue
        pq.add(new VertexQueuePriority(fromVertex,0));

        while(!pq.isEmpty()){
            Vertex removed = pq.remove().vertex;
            visited.add(removed.label);

            for(Map.Entry<String,Integer> neighbour: removed.neighbours.entrySet()){
                if(visited.contains(neighbour.getKey()))
                    continue;
                //  newDistance is distance till current + new edge weight
                int newDistance = distances.get(removed.label) + neighbour.getValue();
                //  if newDistance < old value of distance to current node update it and add to queue
                if(newDistance < distances.get(neighbour.getKey())){
                    distances.replace(neighbour.getKey(),newDistance);
                    pq.add(new VertexQueuePriority(this.vertices.get(neighbour.getKey()),newDistance));
                }
            }
        }
        return distances.get(toVertex.label);
    }
}
