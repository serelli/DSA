package com.algo.graph;

import java.util.*;

public class Graph {

    int verties;
    LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.verties = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {

        this.adjacencyList[u].add(v);
    }


    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */

            //create an empty HashMap where key of String type and value as String type
            Map<String, String> map = new HashMap<>();

            for(String str : args){
                String[] s = str.split("-");
                map.put(s[0], s[1]);
            }

        }


    public void dfs(int v) {
        boolean[] visited = new boolean[this.verties];
        // call the recursive helper function to print dfs traversal
        dfsUtil(v, visited);

    }

    public void dfsUtil(int v, boolean[] visited) {

        try {
            if (adjacencyList[v] == null || visited[v]) {
                return;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please check the passed vertex");
            return;
        }

        System.out.println(v);
        visited[v] = true;

        ListIterator<Integer> listIterator = adjacencyList[v].listIterator();
        while (listIterator.hasNext()) {
            Integer node = listIterator.next();
            dfsUtil(node, visited);
        }
    }


    public void dfsUtilUsingStack(int vertex){

        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[this.verties];

        stack.push(vertex);
        visited[vertex] = true;


        while(!stack.isEmpty()){
            Integer temp = stack.pop();
                System.out.println(temp);
            ListIterator<Integer> listIterator = adjacencyList[temp].listIterator();
            while (listIterator.hasNext()){
                int next = listIterator.next();
                if(!visited[next]){
                    visited[next]= true;
                    stack.push(next);
                }
            }
        }

    }

    public void disconnectedDFSUtilUsingStack(int vertex,boolean[] visited){

        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);


        while(!stack.isEmpty()){
            Integer temp = stack.pop();
            if(!visited[temp]) {
                System.out.println(temp);
                visited[temp] = true;
            }
            ListIterator<Integer> listIterator = adjacencyList[temp].listIterator();
            while (listIterator.hasNext()){
                int next = listIterator.next();
                if(!visited[next]){
                    stack.push(next);
                }
            }
        }

    }

    // to dfs a disconnected graph following is the logic

    public void disconnectedDFS(){
        boolean[] visited = new boolean[this.verties];

        for(int i =0 ; i<this.verties;i++){
            if(!visited[i]){
                disconnectedDFSUtilUsingStack(i,visited);
            }
        }
    }

    public void bfs(int vertex){

        boolean[] visited = new boolean[this.verties];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vertex);
        visited[vertex]= true;

        while (!queue.isEmpty()){
            Integer temp = queue.poll();
            System.out.println(temp);


            ListIterator<Integer> listIterator = adjacencyList[temp].listIterator();

            while (listIterator.hasNext()) {
                Integer val = listIterator.next();
                if (!visited[val]) {
                    visited[val]= true;
                    queue.offer(val);
                }
            }
        }

    }

    // to bfs a disconnected graph following is the logic

    public void disconnectedBFS(){
        boolean[] visited = new boolean[this.verties];

        for(int i =0 ; i<this.verties;i++){
            if(!visited[i]){
                disconnectedBFS(i,visited);
            }
        }
    }

    public void disconnectedBFS(int vertex, boolean[] visited ){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vertex);
        visited[vertex]= true;

        while (!queue.isEmpty()){
            Integer temp = queue.poll();
            System.out.println(temp);


            ListIterator<Integer> listIterator = adjacencyList[temp].listIterator();

            while (listIterator.hasNext()) {
                Integer val = listIterator.next();
                if (!visited[val]) {
                    visited[val]= true;
                    queue.offer(val);
                }
            }
        }

    }

    //Time Complexity: O(V+E)
    public void topologicalSorting() {
        boolean[] visited = new boolean[this.verties];
        Stack<Integer> stack = new Stack<>();
        //visit from each node if not already visited
        for (int i = 0; i < this.verties; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        System.out.println("Topological Sort: ");
        int size = stack.size();
        for (int i = 0; i <size ; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack) {
        visited[start] = true;
        ListIterator<Integer> listIterator = adjacencyList[start].listIterator();
        while (listIterator.hasNext()) {
            int vertex = listIterator.next();
            if (!visited[vertex])
                topologicalSortUtil(vertex, visited, stack);
        }

        stack.push(start);
    }

    // DFS can be used to detect a cycle in a graph. DFS for a connected graph produces a tree.
    // there is a cycle in a graph only if there is a backedge present in the graph, A backedge is an edge that is from a
    // node to itself(self loop) or one of its ancestor in the tree produced by dfs.


    public boolean isCyclicDirectedGraph(){

        boolean[] visited = new boolean[this.verties];
        boolean[] recStack = new boolean[this.verties];

        // call the recursive helper function to detect cycle in different dfs trees.
        // check from each vertex if there exists any cycle in the graph.
        for(int i=0; i<this.verties;i++){

            if(isCyclicDirectedGraphUtils(i,visited,recStack)){
                return true;
            }
        }
        return false;

    }

    

    public boolean isCyclicDirectedGraphUtils(int start, boolean[] visited, boolean[] recStack){

        if(recStack[start])
            return true;
        if(visited[start])
            return false;

        recStack[start]= true;
        visited[start] = true;

        ListIterator<Integer> listIterator = this.adjacencyList[start].listIterator();
        while(listIterator.hasNext()){
            int val = listIterator.next();
            if(isCyclicDirectedGraphUtils(val, visited, recStack))
                return true;
        }

        recStack[start] = false;

        return false;
    }



    // A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
    Boolean foundCycleInUndirectedGraphUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = this.adjacencyList[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i])
            {
                if (foundCycleInUndirectedGraphUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    Boolean foundCycleInUndirectedGraph()
    {
        // Mark all the vertices as not visited and not part of
        // recursion stack
        Boolean visited[] = new Boolean[this.verties];
        for (int i = 0; i < verties; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < verties; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (foundCycleInUndirectedGraphUtil(u, visited, -1))
                    return true;

        return false;
    }


}
