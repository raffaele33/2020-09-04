package it.polito.tdp.imdb.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	private ImdbDAO dao;
	private Graph<Movie,DefaultWeightedEdge> grafo;
	private Map<Integer,Movie> map= new HashMap<Integer,Movie>();
	public Model() {
		dao= new ImdbDAO();
		dao.listVert(map);
	}
	public void CreaGrafo(double r) {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	
		Graphs.addAllVertices(this.grafo, map.values());
		
		for(Adiacenza a: this.dao.listAllAdi(r)) {
			Graphs.addEdgeWithVertices(this.grafo, map.get(a.getM1()), map.get(a.getM2()), a.getC());
		}
		
	}
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public FilmW getBest() {
		int p;
		int best=0;
		Movie bes=null;
		for(Movie m : this.grafo.vertexSet()) {
			p=0;
			for(DefaultWeightedEdge d : this.grafo.incomingEdgesOf(m)) {
				p+=this.grafo.getEdgeWeight(d);
			}
			if(p>best) {
				best=p;
				bes=m;
			}
		}
		FilmW f= new FilmW(bes,best);
		return f;
		
	}
}
