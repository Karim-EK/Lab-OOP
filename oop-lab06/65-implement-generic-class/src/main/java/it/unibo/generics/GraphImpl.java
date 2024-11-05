package it.unibo.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<X> implements Graph<X> {

    // all nodes & edges in the graph
    Set<X> nodeSet;
    Map<X, Set<X>> edges;

    public GraphImpl() {
        this.nodeSet = new HashSet<>();
        this.edges = new HashMap<>();
    }
 
    @Override
    public void addNode(final X node) {
        if (!nodeSet.contains(node)) {
            nodeSet.add(node);
        }
    }

    @Override
    public void addEdge(final X source, final X target) {
        if ( source != null || target != null) {
            if (!nodeSet.contains(source)) {
                addNode(source);
            }
            if (!nodeSet.contains(source)) {
                addNode(target);
            }
            final var sourceEdges = edges.computeIfAbsent(source, new Function<X, Set<X>>() {
                public java.util.Set<X> apply(final X t) {
                    return new HashSet<>();
                };
            });
            sourceEdges.add(target);
        }
    }

    @Override
    public Set<X> nodeSet() {
        return new HashSet<>(nodeSet);
    }

    @Override
    public Set<X> linkedNodes(final X node) {
        return new HashSet<>(edges.get(node));
    }

    @Override
    public List<X> getPath(final X source, final X target) {
        if (!nodeSet.contains(source) || !nodeSet.contains(target)) {
            return null;
        }
        // adasdashfbah
        final Map<X, X> parentMap = new HashMap<>();
        if (!dfs(source, target, parentMap, new HashSet<>())) {
            return null;
        }
        // 
        final List<X> path = new ArrayList<>();
        X current = target;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    private boolean dfs(final X current, final X target, final Map<X, X> parentMap, final Set<X> visited) {
        if (current.equals(target)) {
            return true;
        }

        visited.add(current);
        for (final X neighbor : edges.get(current)) {
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
