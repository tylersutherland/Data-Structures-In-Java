package tstructs.graph;

import java.util.Set;

public abstract class Graph<T> {
	Set<Vertex>	verts;
	Set<Edge>	edges;

	public abstract boolean addEdge(Vertex from, Vertex to);

	public abstract boolean addVertex(Vertex v);

	public Set<Edge> edges() {
		return edges;
	}

	public Set<Vertex> verts() {
		return verts;
	}

	class Vertex {
		T	val;

		Vertex(T val) {
			this.val = val;
		}
	}

	class Edge {
		Vertex	from;
		Vertex	to;

		Edge(Vertex from, Vertex to) {
			this.from = from;
			this.to = to;
		}
	}
}
