package week08;
import java.awt.Point;
public class Main08_ass02 {
	public static void main(String[] args) {
		
		/*
		 *  ������ �Ʒ��� ���� value�� point�� �ٷ� �־�����,
		    pq.insert( Math.sqrt(Math.pow(c.getX(), 2)+Math.pow(c.getY(), 2)), d);
		 * ���� ��½� java.awt.Point[x=3,y=1]�� ���� ���÷� �ֽ� ȭ����� d(3, 1)�� ������ �ʾ�
		 *  value�� "d("+(int) d.getX()+", "+(int) d.getY()+")"); ó�� string Ÿ������ �־����ϴ�.
		 *  (int)�� ȭ������� ���� (3, 1)�� ���߱� ���� �־����ϴ�. ( Point�� getX(), getY()�� ��ȯ���� double�̱� ������ d(3.0, 1.0)ó�� ���ͼ��� )
		 *  pq.insert( Math.sqrt(Math.pow(d.getX(), 2)+Math.pow(d.getY(), 2)), "d("+(int) d.getX()+", "+(int) d.getY()+")");
		 *  ���� �־��� ���:
		pq.insert( Math.sqrt(Math.pow(a.getX(), 2)+Math.pow(a.getY(), 2)), a);
		pq.insert( Math.sqrt(Math.pow(b.getX(), 2)+Math.pow(b.getY(), 2)), b);
		pq.insert( Math.sqrt(Math.pow(c.getX(), 2)+Math.pow(c.getY(), 2)), c);
		pq.insert( Math.sqrt(Math.pow(d.getX(), 2)+Math.pow(d.getY(), 2)), d);
		pq.insert( Math.sqrt(Math.pow(e.getX(), 2)+Math.pow(e.getY(), 2)), e);
		pq.insert( Math.sqrt(Math.pow(f.getX(), 2)+Math.pow(f.getY(), 2)), f);
		pq.insert( Math.sqrt(Math.pow(g.getX(), 2)+Math.pow(g.getY(), 2)), g);
		pq.insert( Math.sqrt(Math.pow(h.getX(), 2)+Math.pow(h.getY(), 2)), h);
		pq.insert( Math.sqrt(Math.pow(i.getX(), 2)+Math.pow(i.getY(), 2)), i);
		pq.insert( Math.sqrt(Math.pow(j.getX(), 2)+Math.pow(j.getY(), 2)), j); 
		 */
		
		IntComparator3 comp1 = new IntComparator3();	// ���� IntComparator�� (int) ���Ŀ� ���� �������� IntComparator3 ����
		IntComparator2 comp2 = new IntComparator2();
		MyPQ pq = new MyPQ(comp1);
		Point a = new Point(5, 4);
		Point b = new Point(2, 7);
		Point c = new Point(9, 5);
		Point d = new Point(3, 1);
		Point e = new Point(7, 2);
		Point f = new Point(9, 7);
		Point g = new Point(1, 4);
		Point h = new Point(4, 3);
		Point i = new Point(8, 2);
		Point j = new Point(4, 8);
		
		System.out.println("[����� ����]");
		pq.insert( Math.sqrt(Math.pow(a.getX(), 2)+Math.pow(a.getY(), 2)), "a("+(int) a.getX()+", "+(int) a.getY()+")");
		pq.insert( Math.sqrt(Math.pow(b.getX(), 2)+Math.pow(b.getY(), 2)), "b("+(int) b.getX()+", "+(int) b.getY()+")");
		pq.insert( Math.sqrt(Math.pow(c.getX(), 2)+Math.pow(c.getY(), 2)), "c("+(int) c.getX()+", "+(int) c.getY()+")");
		pq.insert( Math.sqrt(Math.pow(d.getX(), 2)+Math.pow(d.getY(), 2)), "d("+(int) d.getX()+", "+(int) d.getY()+")");
		pq.insert( Math.sqrt(Math.pow(e.getX(), 2)+Math.pow(e.getY(), 2)), "e("+(int) e.getX()+", "+(int) e.getY()+")");
		pq.insert( Math.sqrt(Math.pow(f.getX(), 2)+Math.pow(f.getY(), 2)), "f("+(int) f.getX()+", "+(int) f.getY()+")");
		pq.insert( Math.sqrt(Math.pow(g.getX(), 2)+Math.pow(g.getY(), 2)), "g("+(int) g.getX()+", "+(int) g.getY()+")");
		pq.insert( Math.sqrt(Math.pow(h.getX(), 2)+Math.pow(h.getY(), 2)), "h("+(int) h.getX()+", "+(int) h.getY()+")");
		pq.insert( Math.sqrt(Math.pow(i.getX(), 2)+Math.pow(i.getY(), 2)), "i("+(int) i.getX()+", "+(int) i.getY()+")");
		pq.insert( Math.sqrt(Math.pow(j.getX(), 2)+Math.pow(j.getY(), 2)), "j("+(int) j.getX()+", "+(int) j.getY()+")");
		
		while(!pq.isEmpty())
			System.out.println(pq.removeMin().getValue());
		
		System.out.println("\n[�ָ� �ִ� ����]");
		pq = new MyPQ(comp2);
		
		pq.insert( Math.sqrt(Math.pow(a.getX(), 2)+Math.pow(a.getY(), 2)), "a("+(int) a.getX()+", "+(int) a.getY()+")");
		pq.insert( Math.sqrt(Math.pow(b.getX(), 2)+Math.pow(b.getY(), 2)), "b("+(int) b.getX()+", "+(int) b.getY()+")");
		pq.insert( Math.sqrt(Math.pow(c.getX(), 2)+Math.pow(c.getY(), 2)), "c("+(int) c.getX()+", "+(int) c.getY()+")");
		pq.insert( Math.sqrt(Math.pow(d.getX(), 2)+Math.pow(d.getY(), 2)), "d("+(int) d.getX()+", "+(int) d.getY()+")");
		pq.insert( Math.sqrt(Math.pow(e.getX(), 2)+Math.pow(e.getY(), 2)), "e("+(int) e.getX()+", "+(int) e.getY()+")");
		pq.insert( Math.sqrt(Math.pow(f.getX(), 2)+Math.pow(f.getY(), 2)), "f("+(int) f.getX()+", "+(int) f.getY()+")");
		pq.insert( Math.sqrt(Math.pow(g.getX(), 2)+Math.pow(g.getY(), 2)), "g("+(int) g.getX()+", "+(int) g.getY()+")");
		pq.insert( Math.sqrt(Math.pow(h.getX(), 2)+Math.pow(h.getY(), 2)), "h("+(int) h.getX()+", "+(int) h.getY()+")");
		pq.insert( Math.sqrt(Math.pow(i.getX(), 2)+Math.pow(i.getY(), 2)), "i("+(int) i.getX()+", "+(int) i.getY()+")");
		pq.insert( Math.sqrt(Math.pow(j.getX(), 2)+Math.pow(j.getY(), 2)), "j("+(int) j.getX()+", "+(int) j.getY()+")");
		
		while(!pq.isEmpty())
			System.out.println(pq.removeMin().getValue());
	}
}
