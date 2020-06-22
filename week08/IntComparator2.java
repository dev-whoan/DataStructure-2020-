package week08;
import java.util.Comparator;
public class IntComparator2 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return (double)o2 > (double)o1 ? 1 : -1;
	}

}
