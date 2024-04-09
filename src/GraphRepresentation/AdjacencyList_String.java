package GraphRepresentation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
27th Feb 2024 : https://learn.innoskrit.in/graph/graph-representation-using-adjacency-list-string/
Problem Statement: Given a list of edges which represents the connection between different cities. Create an adjacency list to represent the Graph.
 === Note: This time, you are not given numbers to represent the nodes. Instead, you're given strings to represent each node. ==

Example:
Input:
edges = [
    ["DEL", "BOM"],
    ["DEL", "KNP"],
    ["DEL", "BLR"],
    ["DEL", "HYD"],
    ["DEL", "PNQ"],
    ["BLR", "HYD"],
    ["BLR", "PNQ"],
    ["BLR", "BOM"]
]
Output:
DEL : BOM KNP BLR HYD PNQ
BOM : DEL BLR
KNP : DEL
BLR : DEL HYD PNQ BOM
HYD : DEL BLR
PNQ : DEL BLR

 */
public class AdjacencyList_String {

    public static void main(String[] args) {

        String[][] edges = {
                {"DEL", "BOM"},
                {"DEL", "KNP"},
                {"DEL", "BLR"},
                {"DEL", "HYD"},
                {"DEL", "PNQ"},
                {"BLR", "HYD"},
                {"BLR", "PNQ"},
                {"BLR", "BOM"}
        };
        Map<String, List<String>> graph = new HashMap<>();

        for(int i=0; i<edges.length; i++) {
            String src = edges[i][0];
            String dest = edges[i][1];
//            System.out.println("Source : "+src+" Destination : "+dest);
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            graph.get(src).add(dest);
            if (!graph.containsKey(dest)) {
                graph.put(dest, new ArrayList<>());
            }
            graph.get(dest).add(src);
//            for (Object objectName : graph.keySet()) {
//                System.out.print(objectName + ": ");
//                System.out.println(graph.get(objectName));
//            }

        }
            /*
                edges[0] = ["DEL","BOM"]
                src -- edges[0][0] = "DEL", dest -- edges[0][1] = "BOM"
                node = "DEL"

                add dest to src list and vice-versa
                if (src.equals(node)) {
                    graph.get(src).add(dest);
                } // simmilarly check for dest and add
            */
        for (Object objectName : graph.keySet()) {
            System.out.print(objectName + ": ");
            System.out.println(graph.get(objectName));
        }


        /*
            Time Complexity: O(V+E) , worse case - O(V^2)
            Space Complexity: O((V + E) * K),
            where V is the number of vertex, E is the number of edges,
            and K is the average length of each string. This space is contributed by Adjacency List.
            You might ignore K because the length of each string will almost be constant like 10 to 20.
         */

    }
}
