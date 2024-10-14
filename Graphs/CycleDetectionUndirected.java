package Graphs;

/*  Cycle Detection - Undirected Graph
    *   For undirected graph if a vertex have a neighbour that is already visited
    *   and not the parent of current vertex it means there is a cycle
    */
    public boolean isCycleDetected(){
        if(this.vertices.isEmpty())
            return false;
        Set<String> visited = new HashSet<>();
        for(Map.Entry<String,Vertex> vertex : this.vertices.entrySet())
            if(!visited.contains(vertex.getKey()) && isCycleHelper(vertex.getValue(),visited,null))
                return true;
        return false;
    }
    private boolean isCycleHelper(Vertex vertex, Set<String> visited, Vertex parent) {
        //  add to visited set
        visited.add(vertex.label);
        for(String neighbour: vertex.neighbours.keySet()) {
            //  if neighbour is already traversed and it's not the current vertex parent than cycle exist
            if (visited.contains(neighbour) && parent != null && !neighbour.equals(parent.label))
                return true;
            //  if neighbour don't exist do dfs
            if(!visited.contains(neighbour))
                return isCycleHelper(this.vertices.get(neighbour),visited,this.vertices.get(vertex.label));
        }
        return false;
    }
