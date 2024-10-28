package it.unibo.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<X> implements Graph<X> {

    // all nodes & edges in the graph
    Set<X> nodeSet;
    Map<X,Set<X>> edges;

    public GraphImpl() {
        this.nodeSet = new HashSet<>();
        this.edges = new HashMap<>();
    }
 
    @Override
    public void addNode(X node) {
        if (!nodeSet.contains(node)) {
            nodeSet.add(node);
        }
    }

    @Override
    public void addEdge(X source, X target) {
        if ( source != null || target != null) {
            if (!nodeSet.contains(source)) {
                addNode(source);
            }
            if (!nodeSet.contains(source)) {
                addNode(target);
            }
            if (edges.containsKey(source)) {
                edges.get(source).add(target);
            } else {
                Set<X> adiacents = new HashSet<>();
                adiacents.add(target);
                edges.put(source, adiacents);
            }
        }
    }

    @Override
    public Set<X> nodeSet() {
        return new HashSet<>(nodeSet);
    }

    @Override
    public Set<X> linkedNodes(X node) {
        return new HashSet<>(edges.get(node));
    }

    @Override
    public List<X> getPath(X source, X target) {
        if (!nodeSet.contains(source) || !nodeSet.contains(target)) {
            return null; // Source or target node not found
        }

        Map<X, X> parentMap = new HashMap<>();
        Set<X> visited = new HashSet<>();
        if (!dfs(source, target, parentMap, visited)) {
            return null; // No path found
        }

        // Reconstruct the path
        List<X> path = new ArrayList<>();
        X current = target;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private boolean dfs(X current, X target, Map<X, X> parentMap, Set<X> visited) {
        if (current.equals(target)) {
            return true;
        }

        visited.add(current);
        for (X neighbor : edges.get(current)) {
            if (!visited.contains(neighbor)) {
                parentMap.put(neighbor, current);
                if (dfs(neighbor, target, parentMap, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

}
