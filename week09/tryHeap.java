package week09;

import java.util.ArrayList;
import java.util.List;

public class tryHeap {
	List<Integer> heap;
	public tryHeap() {
		heap = new ArrayList<Integer>();
		heap.add(0);
	}
	
	public void insert(int n) {
		heap.add(n);
		int p = heap.size() - 1;
		while(p < 1 || heap.get(p / 2) > heap.get(p)) {
			int tmp = heap.get(p / 2);
			heap.set(p/2,  heap.get(p));
			heap.set(p,  tmp);
			p = p / 2;
		}
	}
	
	public int delete() {
		if (heap.size() <= 1)
			return 0;
		
		int deleteItem = heap.get(1);
		
		heap.set(1,  heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int pos = 1;
		
		while((pos*2) < heap.size()) {
			int min = heap.get(pos*2);
			int minPos = pos*2;
			
			if(((pos*2+1) < heap.size()) && min > heap.get(pos*2+1)) {
				min = heap.get(pos*2+1);
				minPos = pos*2+1;
			}
			
			if (heap.get(pos) < min)
				break;
			
			int tmp = heap.get(pos);
			heap.set(pos,  heap.get(minPos));
			heap.set(minPos,  tmp);
			pos = minPos;
		}
		return deleteItem;
	}
}
