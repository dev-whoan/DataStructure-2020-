package week10.Assignment01;

public class Main {
	public static void main(String[] args) {
		MyHashTable hashTable = new MyHashTable(13);
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
			"202012353"
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
			"�躥��"
		};
		
		for(int i = 0; i < id.length; i++)
		{
			hashTable.put(id[i], name[i]);
		}
		for(int i = 0; i < id.length; i++)
		{
			System.out.println(hashTable.get(id[i]));
		}
	}
}
