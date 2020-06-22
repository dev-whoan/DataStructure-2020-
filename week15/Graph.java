package week15;

import java.io.*;
import java.util.*;

public class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	
	Graph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	void DFS(int v) {
		boolean visited[] = new boolean[V];
		
		DFSUtil(v, visited);
	}
	
	void DFS() {
		boolean visited[] = new boolean[V];
		
		for(int i = 0; i < V; ++i) {
			if(!visited[i])
				DFSUtil(i, visited);
		}
	}
}
