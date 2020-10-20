package com.algo.graph;

import java.util.*;

public class CheapestFlightsWithKStops {

   /* Here's a compilation of 4 graph algorithms.

    DFS
    Pretty straightforward implementation. keep a global answer and traverse all the children of the source upto k stops. If at any point we reach the destination,store the min of the naswer and the current cost.
            Code:
*/
    int ans_dfs;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        ans_dfs=Integer.MAX_VALUE;
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] i:flights)
        {
            map.putIfAbsent(i[0],new ArrayList<>());
            map.get(i[0]).add(new int[]{i[1],i[2]});
        }
        dfs(map,src,dst,K+1,0);
        return ans_dfs==Integer.MAX_VALUE?-1:ans_dfs;
    }
    public void dfs(Map<Integer,List<int[]>> map, int src, int dst, int k, int cost)
    {

        if(!map.containsKey(src))
            return;
        if(k<0)
            return;
        if(src==dst)
        {
            ans_dfs=cost;
            return;
        }

        for(int[] i:map.get(src))
        {
            if(cost+i[1]>ans_dfs)               //Pruning, check the sum of current price and next cost. If it's greater then the ans so far, continue
                continue;
            dfs(map,i[0],dst,k-1,cost+i[1]);
        }
    }
    /*A few caveats, pruning the path based on the cost of next children will improve performance, remove the need of a visited set and solve the annoying TLE issue.
*/
       /*     BFS
    Unlike BFS, now we simultaneously traverse all the possible path going out from source for upto k steps. If the ans is found in between, we store the min of the current ans with the newly found one. A modification to the standard bfs design, we pass the starting cost a 0 to the queue as well and go on adding to it.
            Code :*/
    public int findCheapestPriceBFS(int n, int[][] flights, int src, int dst, int K)
    {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] i:flights)
        {
            map.putIfAbsent(i[0],new ArrayList<>());
            map.get(i[0]).add(new int[]{i[1],i[2]});
        }
        int step=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] curr=q.poll();
                if(curr[0]==dst)
                    ans=Math.min(ans,curr[1]);
                if(!map.containsKey(curr[0]))
                    continue;
                for(int[] f:map.get(curr[0]))
                {
                    if(curr[1]+f[1]>ans)      //Pruning
                        continue;
                    q.offer(new int[]{f[0],curr[1]+f[1]});
                }
            }
            if(step++>K)
                break;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
 /*   Similar to DFS, I used pruning to avoid TLE and remove the need of a visited set.

            3.Bellman Ford
    Much like BFS, run the algorithm K times, if the answer exists, it should be stored in the helper matrix

    Code*/

    public int findCheapestPriceBELLMANFORS(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr]==Integer.MAX_VALUE)
                    continue;
                temp[next]=Math.min(temp[next],cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
/*4.Dijkstra's
    Much like BFS, but use a PriorityQueue based on the cheapest cost. Incorporate the stop limit to individual paths to traverse upto k stops.
    credit to @lee215 for the solution*/

    public int findCheapestPriceDIJKSTRA(int n, int[][] flights, int src, int dst, int K)
    {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        q.offer(new int[]{0,src,K+1});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int cost=c[0];
            int curr=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>0)
            {
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{cost+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }
}
