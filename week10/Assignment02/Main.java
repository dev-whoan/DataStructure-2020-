package week10.Assignment02;

public class Main {
	public static void main(String[] args) {
		MyHashTable hashTable = new MyHashTable(13, 0.9f);
		String[] id = {
			"201611253",
			"202012345",
			"202012346",
			"202012347",
			"202012348",
			"202012349",
			"202012350",
			"202012351",
			"202012352",
			"202012353",
			"202012354",
			"202012355",
			"202012356",
			"202012357",
			"202012358"
		};
		
		String[] name = {
			"���ȯ",
			"ȫ�浿",
			"��ö��",
			"�ڿ���",
			"����",
			"�糪",
			"�Ѽ���",
			"�ڻＺ",
			"�̾���",
			"�躥��",
			"���缮",
			"������",
			"������",
			"��â��",
			"����"
		};
		
		
		for(int i = 0; i < id.length; i++)
		{
			hashTable.put(id[i], name[i]);
			System.out.println((i+1) + "��° ������ ���� Load Factor: " + hashTable.getLoadFactor());
		}
		for(int i = 0; i < id.length; i++)
		{
			System.out.println(hashTable.get(id[i]));
		}
	}
}
