package it.unibo.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<X> implements Graph<X> {

    // all nodes & edges in the graph
    Set<X> nodeSet;
    Set<List<X>> edgeSet;

    public GraphImpl() {
        this.nodeSet = new HashSet<>();
        this.edgeSet = new HashSet<>();
    }

    @Override
    public void addNode(X node) {
        nodeSet.add(node);
    }

    @Override
    public void addEdge(X source, X target) {
        if ( source != null || target != null) {
            List<X> edge = new ArrayList<>();
            edge.add(source);
            edge.add(target);
            // TODO: Controllo se nodo già presente per estendere grafo
            if (!edgeSet.contains(edge)) {
                edgeSet.add(edge);
            }
        }
    }

    @Override
    public Set<X> nodeSet() {
        return new HashSet<>(nodeSet);
    }

    @Override
    public Set<X> linkedNodes(X node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List<X> getPath(X source, X target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}
