package Graphs;

//  traverses all
public List<String> depthFirstTraversal() {
        List<String> a= new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (Map.Entry<String, Vertex> vertex : this.vertices.entrySet()) {
            if (!visited.contains(vertex.getKey()))
                depthFirstTraversal(vertex.getValue(), visited,a);
        }
        return a;
    }
private void depthFirstTraversal(Vertex vertex, Set<String> visited, List<String> a) {
        a.add(vertex.label);
        visited.add(vertex.label);
        for(String neighbour : vertex.neighbours.keySet())
            if(!visited.contains(neighbour))
                depthFirstTraversal(this.vertices.get(neighbour),visited,a);
    }
//  traverses all interconnected starting from provided nodevalue
public List<String> depthFirstTraversalGivenAVertex(String label) {
        List<String> a= new ArrayList<>();
        Vertex vertex = this.vertices.get(label);
        if(vertex==null) return a;
        Set<String> visited = new HashSet<>();
        depthFirstTraversal(vertex, visited,a);
        return a;
    }
