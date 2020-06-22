package week08;
import java.util.Comparator;
public class IntComparator3 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return (double)o1 > (double)o2 ? 1 : -1;
	}

}
