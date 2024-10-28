package it.unibo.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<X> implements Graph<X> {

    Set<List<X>> nodeSet;

    public GraphImpl() {
        this.nodeSet = new HashSet<>();
    }

    @Override
    public void addNode(X node) {
        var newNode = new ArrayList<>()
        nodeSet.add();
    }

    @Override
    public void addEdge(X source, X target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public Set<X> nodeSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodeSet'");
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
