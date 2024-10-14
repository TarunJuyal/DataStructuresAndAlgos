package Graphs;

/*  Cycle Detection - Directed Graph
     *   For Directed graph just testing already visited doesn't work.
     *   eg a->b->c and d->b->c is we check for already visited it will give true but still cycle doesn't exist
     *   For directed we keep 2 set of nodes visited and currently visiting
     *   If we visit a node and all its neighbours then we put it in visited set
     *   Else we keep it in visiting set
     *   If we encounter a neighbour to current vertex that's still in visiting set then there is a cycle.
     */
    public boolean hasCycle(){
        if(this.vertices.isEmpty())
            return false;
        Set<String> visiting = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(Map.Entry<String,Vertex> vertex : this.vertices.entrySet())
            if(hasCycle(vertex.getValue(),visiting,visited))
                return true;
        return false;
    }
    private boolean hasCycle(Vertex vertex, Set<String> visiting, Set<String> visited) {
        //  add to visiting
        visiting.add(vertex.label);

        for(String neighbour: vertex.neighbours.keySet()){
            if(visited.contains(neighbour))
                continue;
            //  if neighbour in visiting then there is cycle.
            if(visiting.contains(neighbour) || hasCycle(this.vertices.get(neighbour),visiting,visited))
                return true;
        }

        //  after all neighbour visited remove from visiting.
        visiting.remove(vertex.label);
        visited.add(vertex.label);
        return false;
    }
