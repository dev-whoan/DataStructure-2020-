package week08;

import java.util.ArrayList;
import java.util.Comparator;

public class MyPQ {
	private ArrayList<Object> list;
	private Comparator<Object> cpt;
	MyPQ(Comparator<Object> comp){
		this.list = new ArrayList<Object>();
		this.cpt = comp;
	}
	
	MyPQ(int initialCapacity, Comparator<Object> comp){
		this.list = new ArrayList<Object>(initialCapacity);
		this.cpt = comp;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public MyEntry insert(Object k, Object v) {
		MyEntry ent = new MyEntry(k, v);
		
		int pos = 0;
		int size = size();
		for(int i = 0; i < size; i++)
		{
			MyEntry tEnt = (MyEntry)list.get(i);
			if(this.cpt.compare(k, tEnt.getKey()) > 0)
				pos++;
		}
		
		list.add(pos, ent);
		return ent;
	}
	
	public MyEntry removeMin() {
		return (MyEntry)list.remove(0);
	}
	
	public MyEntry min() {
		return (MyEntry)list.get(0);
	}
}
