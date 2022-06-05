package ru.vsu.cs.course1.graph.demo;

import ru.vsu.cs.course1.graph.GraphAlgorithms;
import ru.vsu.cs.course1.graph.WeightedGraph;

public class Task {
    static int getVertex(WeightedGraph graph){
        double minS = Double.MAX_VALUE;
        int indexOfVertex = -1;
        for (int i = 0; i < graph.vertexCount(); i++) {
            GraphAlgorithms.MinDistanceSearchResult result = new GraphAlgorithms.MinDistanceSearchResult();
            result = GraphAlgorithms.bellmanFord(graph,i);
            double s = 0;
            for (Double pathLength : result.d) {
                if (Double.MAX_VALUE - pathLength < 1){
                    s = Double.MAX_VALUE;
                    continue;
                }
                s+=pathLength;
            }
            if ( s < minS){
                minS = s;
                indexOfVertex = i;
            }
        }
        return indexOfVertex;

    }
}
