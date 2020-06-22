package week08;
import java.util.Comparator;

public class IntComparator implements Comparator{
	public int compare(Object o1, Object o2) {
		return (int)o1 > (int)o2 ? 1 : -1;
	}
}
