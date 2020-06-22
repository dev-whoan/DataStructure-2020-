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
			"±è¹ÎÈ¯",
			"È«±æµ¿",
			"±èÃ¶¼ö",
			"¹Ú¿µÈñ",
			"´ÙÇö",
			"»ç³ª",
			"ÇÑ¼ÒÈñ",
			"¹Ú»ï¼º",
			"ÀÌ¾ÖÇÃ",
			"±èº¥Ã÷"
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
