package week14;

import java.util.Comparator;

public class StrComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 == o2)
			return 0;
		return ((String)o1).compareTo( ((String) o2));
	}

}
