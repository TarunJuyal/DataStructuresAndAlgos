package Graphs;

//  Works only on Directed Acyclic Graphs
    public List<String> topologicalSort(){
        //  Stack to keep track of nodes that are visited having no child
        Stack<String> s = new Stack<>();
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, Vertex> vertex : this.vertices.entrySet())
            topologicalSort(vertex.getValue(), s, visited);

        while(!s.empty())
            result.add(s.pop());

        return result;
    }
    private void topologicalSort(Vertex vertex, Stack<String> s, Set<String> visited){
        if(visited.contains(vertex.label))
            return;
        visited.add(vertex.label);

        for(String node: vertex.neighbours.keySet())
            topologicalSort(this.vertices.get(node),s,visited);

        //  if no more children add to stack
        s.push(vertex.label);
    }
