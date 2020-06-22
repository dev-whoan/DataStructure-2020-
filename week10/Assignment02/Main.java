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
			"±è¹ÎÈ¯",
			"È«±æµ¿",
			"±èÃ¶¼ö",
			"¹Ú¿µÈñ",
			"´ÙÇö",
			"»ç³ª",
			"ÇÑ¼ÒÈñ",
			"¹Ú»ï¼º",
			"ÀÌ¾ÖÇÃ",
			"±èº¥Ã÷",
			"À¯Àç¼®",
			"Á¤Çüµ·",
			"±èÁ¾±¹",
			"ÀÓÃ¢Á¤",
			"³ëÀ»"
		};
		
		
		for(int i = 0; i < id.length; i++)
		{
			hashTable.put(id[i], name[i]);
			System.out.println((i+1) + "¹øÂ° µ¥ÀÌÅÍ »ðÀÔ Load Factor: " + hashTable.getLoadFactor());
		}
		for(int i = 0; i < id.length; i++)
		{
			System.out.println(hashTable.get(id[i]));
		}
	}
}
