package graphs;

public List<String> breadthFirstTravel(String label){
        List<String> a= new ArrayList<>();
        Vertex vertex = this.vertices.get(label);
        if(vertex==null) return a;
        Set<String> visited = new HashSet<>();
        Queue<Vertex> q = new LinkedList<>();
        q.add(vertex);

        while(!q.isEmpty()){
            Vertex removedVertex = q.remove();
            if(visited.contains(removedVertex.label))
                continue;
            visited.add(removedVertex.label);
            a.add(removedVertex.label);
            for(String neighbour : removedVertex.neighbours.keySet())
                q.add(this.vertices.get(neighbour));
        }
        return a;
    }
