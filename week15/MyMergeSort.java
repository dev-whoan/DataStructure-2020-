package week15;
import java.util.ArrayList;
import java.util.Comparator;
public class MyMergeSort {
	private ArrayList L1;
	private ArrayList L2;
	private Comparator comp;
	private int step = 1;

	MyMergeSort(Comparator c){
		L1 = null;
		L2 = null;
		step = 1;
		comp = c;
	}

	/*
	public void mergeSort() {
		int tSize = this.L1.size();
		for(int i = 0; i < tSize; i+= this.step) {
			//각 스텝에 대한 시작점
			int start = i;
			//각 스텝에 대한 마지막 원소
			int last = (start + this.step)-1;
			if(last >= tSize)
				last = tSize-1;

			//각 스텝에 대한 중앙
			int middle = (start + last)/2;
			//각 스텝에 대한 비교 대상
			int q = middle + 1;
			int idx = i;

			while((start <= middle || q <= last)) {


				if(q > last || ( start <= middle && comp.compare(L1.get(start), L1.get(q)) < 0)) {
					L2.set(idx++, L1.get(start++));
				}else {
					L2.set(idx++, L1.get(q++));
				}
			}
			for(int j = start; j <= last; j++) {
				L1.set(j, L2.get(j));
			}

		}

		for(int i = 0; i < this.L2.size(); i++) {
			System.out.print(L2.get(i) + " ");
		}
		System.out.println("Done");
	}
	
*/
	
	public void mSort(ArrayList arr1, ArrayList arr2, int n) {
		for(int i = 1; i < n; i = 2 * i) {
			for(int j = 0; j < n; j = j + 2 * i) {
				//왼쪽 셋트와 우측 셋트를 나눠야 함
				// j는 고정 좌측 위치
				// left는 계산을 위한 좌측 변수
				int left = j;
				//절반으로 정확히 나눠버리면 2^n만 가능함. 따라서 나머지 연산을 해야함
				//2^n이 아닌것을 구분하기 위해 사이즈와 비교, 더 작은걸로 함
				//고정 우측 위치
				int right = Math.min(j+i, n);
				//우측 계산을 위한 변수
				int r = Math.min(j+i, n);
				//우측의 끝의 경우 j+i가 아닌, j+ 2해줘야함. 아래 step처럼.
				int last = Math.min(j+2*i, n);
				for(int k = j; k < last; k++) {
					if(left < right && ( r >= last || comp.compare(arr1.get(left), arr1.get(r)) < 0)) {
						arr2.set(k,  arr1.get(left++));
					}else {
						arr2.set(k, arr1.get(r++));
					}
				}
			}
			
			//합쳐줌
			for(int j = 0; j < n; j++) {
				arr1.set(j, arr2.get(j));
			}
		}
	}
	
	public void sort(ArrayList l) {
		L1 = null;
		L2 = null;
		step = 1;
		L1 = l;
		L2 = new ArrayList<>();
		for(int i = 0; i < L1.size(); i++)
			L2.add(null);

		int tSize = l.size();
		mSort(L1, L2, tSize);
	}
		/*
		 * 2^n은 되는데 그 이외가 아노딤..
		while(step <= l.size() ) {

			for(int i = 0; i < tSize; i += this.step*2) {
				//왼쪽 셋트와 우측 셋트
				int leftStart = i;
				int leftLast = (leftStart + this.step)-1;
				if(leftLast >= tSize-1)
					continue;
				
				int rightStart = i + this.step;
				int rightLast = (rightStart + this.step)-1;
				
				if(rightStart >= tSize)
					rightStart = tSize - 1;
				
				int idx = i;
			//	System.out.println("step : " + step + " || idx : " + idx + " || leftStart : " + leftStart + " || rightStart : " + rightStart);
			//	System.out.println("step : " + step + " || idx : " + idx + " || leftEnd : " + leftLast + " || rightEnd : " + rightLast);
			//	System.out.println();
				boolean leftEnd = false;
				boolean rightEnd = false;
				//문제점 : : left가 다 돌아도 right가 남아있으면 돌아야하는데 안돎.
				//지금 계속 똑같으니 새 코드로
				while(!leftEnd && !rightEnd) {
					
					if(leftStart+1 > leftLast) {
						leftEnd = true;
						leftStart = leftLast;
					}
					if(rightStart+1 > rightLast) {
						rightEnd = true;
						rightStart = rightLast;
					}
					
					System.out.println("leftStart : " + leftStart + " || rightStart : " + rightStart + " || idx : " + idx);
					Object a = L1.get(leftStart++);
					Object b = L1.get(rightStart++);
					
					if(comp.compare ( a, b ) < 0 ) {
						rightStart--;
						
						L2.set(idx++, a);
						L2.set(idx, b);
					}else {
						leftStart--;
						L2.set(idx++, b);
						L2.set(idx, a);
					}
				}
			}
			
			for(int i = 0; i < L1.size(); i++) {
				L1.set(i, L2.get(i));
			}
			System.out.println("============================");
			for(int j = 0; j < L1.size(); j++) {
				System.out.print(L1.get(j) + " ");
			}
			System.out.println("\n============================");
			
			step *= 2;
		}	
		
	}
	*/
	public Comparator setComparator(Comparator c) {
		this.comp = c;
		return c;
	}
}
