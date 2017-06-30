package airbnb;
/**
 * Often, we want to encode raw IDs in our database by hiding them behind some
2-way decodeable hash. So, a URL which would have at one time been:.

https://www.airbnb.com/rooms/848662. 

becomes. 
https://www.airbnb.com/rooms/kljJJ324hjkS_.

We decode the ID kljJJ324hjkS_ to 848662 on our backend and serve the
relevant content. at some point, we start getting 404 errors from clients
requesting a certain URL of the form

https://www.airbnb.com/rooms/kljjj324hjks_

This can happen if certain clients, email services, or url shorteners 
"sanitize" the url. Unfortunately, this change breaks decoding and the
resource cannot be found.
To assess how big of a deal this is, we may want to recover the IDs of the
targets that were 404ing..
Your task:
Given a method decode(testEncStr) which will return the decoded int id if
testEncStr is decodeable or will throw an exception or return null 
(depending on the language) if not, implement a new method decodeFind(String
badEncStr) which takes a string and returns the decoded int id.

 *http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=131724
 */
public class DecodeString {
	// make assumptions about input and output
	// e.g would EaA and eAa match the same id ? why is that acceptable? 
	// ask what does it mean by 'sanitize' is it just the letter can be changed ?
	// or there could be extra stuff in it
	
	public Integer decodeFind(String badEncStr) {
		if(badEncStr == null || badEncStr.isEmpty()) return null;
		return dfs(badEncStr, 0, new StringBuilder());
	}
	
	private Integer dfs(String str, int index, StringBuilder path) {
		if(index == str.length()) {
			return decode(path.toString());
		} else {
			if(!Character.isLetter(str.charAt(index))) {
				// assume other chars won't be tampered by the 'sanitize' process
				path.append(str.charAt(index));
				Integer res = dfs(str, index+1, path);
				if(res != null) return res;
				path.deleteCharAt(path.length()-1);
			} else {
				char lowerCase = Character.toLowerCase(str.charAt(index));
				path.append(lowerCase);
				Integer lowerRes = dfs(str, index+1, path);
				if(lowerRes != null) return lowerRes;
				path.deleteCharAt(path.length()-1);
				path.append(Character.toUpperCase(str.charAt(index)));
				Integer upperRes = dfs(str, index+1, path);
				if(upperRes != null) return upperRes;
				path.deleteCharAt(path.length()-1);
			}
		}
		return null;
	}
	
	private Integer decode(String testEncStr) {
		if("kijssI126GG_".equals(testEncStr)) {
			return 123;
		}
		return null;
	}
	
	public static void main(String[] args) {
		DecodeString s = new DecodeString();
		System.out.println(s.decodeFind("KiJsSi126gG_"));
		System.out.println(s.decodeFind("KiJsSg126gG_"));
	}
}
