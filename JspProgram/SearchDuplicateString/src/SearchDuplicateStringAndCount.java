import java.util.HashMap;
import java.util.Iterator;

public class SearchDuplicateStringAndCount {

	public static void findDuplicateString(String str) {
		HashMap<String, Integer>hm=new HashMap<>();
		//String str="hi wasim im a bad boy wasim";
		String[] s=str.split(" ");
		for(String temp:s) {
			if(hm.get(temp)!=null) {
				//here we are checking for keu availabilty
				//becayse key cant be duplicate but value can be duplicate
				//or override with new one and we ar checking for that only
				hm.put(temp, hm.get(temp)+1);
				
			}
			else {
				//no availabilty of key so it insert the key n value for first time
				hm.put(temp,1);
			}
		}
		Iterator<String>itr=hm.keySet().iterator();
		while(itr.hasNext()) {
			String key=itr.next();
			if(hm.get(key)>1) {
				System.out.println("the word "+key+" apper "+hm.get(key)+" number of times");
			}
		}
		System.out.println(hm);
	}
	public static void findDuplicateCharacter(String str) {
		HashMap<Character, Integer>hm=new HashMap<>();
		for(int i=0;i<str.length();i++) {
		char c=str.charAt(i);
		if(hm.get(c)!=null) {
			hm.put(c, hm.get(c)+1);
			System.out.println("hii"+hm.get(c));
		}
		hm.put(c,1);
		
		}
		Iterator<Character>itr=hm.keySet().iterator();
		while(itr.hasNext()) {
			Character key=itr.next();
			if(hm.get(key)>1) {
				System.out.println("the word "+key+" apper "+hm.get(key)+" number of times");
			}
		}
		System.out.println(hm);
	}
	public static void main(String[] args) {
		findDuplicateString("hi i am am learning java java");
		//findDuplicateCharacter("spjee");
	}
}
