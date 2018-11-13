# Graph

## Shortest path

- Bellman-Ford algorithm
    - Single data source, based on the principle of `relaxation`, in which an approximation to the correct distance is gradually replaced by more accurate values until eventually reaching the optimum solution.

    - Implementation:
        - Initialize all vertices distance to Integer.MAX_VALUE
        - Loop through each edge and update vertex distance. Do this |V| times. 
        - Time complexity: O(|V| * |E|)
    
    - **Check for negative-weight cycle:**
        - For each edge (u, v) with weight w, if distance[u] + w < distance[v], graph contains a negative-weight cycle.

- Dijkstra's algorithm
    - Single data source, `relaxation`

    - Uses a `priority queue` to greedily select the closest vertex that has not yet been processed, and performs this relaxation process on all of its outgoing edges.

    - Implementation: 
        - Uses PriorityQueue to store array int[] v where v[0] is the vertex index and v[1] is the distance to data source.
        - **When v[1] is updated, create a new arary int[] u where u[0] is the vertex index and u[1] is the updated value of v[0]**.
        - **Push u to PriorityQueue**.
        - **When poll array int[] e from PriorityQueue, if e[0] was visited, continue**.

    - Time Complexity: O(|E| + |V| log |V| )

- Floyd-Warshall algorithm

    - Find the lengths of shortest paths between all pairs of vertices

    - Implementation: 
        - Keep an array d[|V|][|V|]
        - v in (0, |V|), i in (0, |V|), j in (0, |V|) d[i][j] = Math.max(d[i][j], d[i][v] + d[v][j])

    - Time Complexity: O(|V| ^ 3)

- Johnson's algorithm

## Minimum Spanning Tree

- Kruskal's algorithm
    - Sort edges

    - Loop through edges, use union find

    - Compexity: O(|E| log |E|)

- Prim's algorithm
    - Start from any vertex

    - Put related edges to PriorityQueue

    - Poll from PriorityQueue
        - If edge has 1 unvisited vertex, visit that vertex and update PriorityQueue
        - Else continue
    
    - Complexity: O(|E| log |V|)
