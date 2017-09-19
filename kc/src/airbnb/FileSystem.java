package airbnb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://tinyurl.com/y7jwpjyo
//https://tinyurl.com/ybfv5be8
//https://tinyurl.com/y8zt49vs
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=244524
//http://www.1point3acres.com/bbs/thread-220338-1-1.html
/**
 * addValue(path, value), setValue(path, value), getValue, watch(path, callback)
 * 
 * 1) 文件系统，每个文件夹或者文件有一个具体的数值，设计一个类，给定key可以update val可以insert val, 要求可以处理exception ?
 * 
 * 2) 大概意思是这样：每个目录对应一个value，比如addDir(/a,1),addDir(/a/b,1),但因为没有/c这个目录，
 *  所以addDir(/c/b,3)就会报错，还可以修改目录的value，比如setDir(/a/b,2)。然后还可以watch(/a/b)，那么修改/a/b的时候就会调用一个Callback function
 *  
 * 3)  也很快做出来了。 Follow up之前也有人提过， 就是要设计一个用于报警的callback类。。这里就迷了。。 怎么写似乎面试官都不满意，
 *  感觉communication又陷入了尴尬。 到了最后发现他好像要考一下OOD知识吧， 设计一个interface，然后再继承两个不同的callback类（虽然干得是同一件事）。
 *  
 * 4) 新题是一个OO Design，很简单，就是实现一个tree。 具体如下：
	configuration tree：	
	三个method：create(path, value), set_value(path, value), get_value(path)

	让你实现一个长成这样的tree：

    	root
	  /     \
	NA       EU
  /    \
 CA     US

	其中root是没有name和value，剩下的每个点都有name和value。
	create（path，value）：给你一个path，比如“NA/MX”，和value，比如“3”。那么你就在NA下面创建一个点叫MX，值是3。
	set_value(path, value): 给你一个path，找到path的叶子，然后set value，如果叶子不存在，返回false；
	get_value(path): 给你一个path，返回叶子的值，没有叶子的话返回NULL。
	非常简单一个OOD，跟Trie很像。

    5) 2. 感觉是做一个hashmap一样……有create(path,value), set_value(path,value), 和 get_value(path) 三个function
	比如先：
	create("eu","")
	create("eu/france","")
	这样就可以，因为你先建了eu了

	但是如果没有create("eu/france","")，直接create("eu/france/paris","")，这样就不行。 反正这个很简单，就一个hashmap

	followup是加一个watch(path, callback)方法，比如：
	watch("eu",callback1)
	watch("eu/france",callback2)

	call set_value("eu/france","eu")时 会同时调用callback1和callback2 （可以理解吧，因为path里有eu也有eu/france）
	我不知道function pointer怎么用在java里，所以跟面试官说改成了string


 */
public class FileSystem {
	// needs to communicate and see if trie should be used 
	Dir root = new Dir(null);

	public void create(String path, String val) throws Exception {
	    if(path==null||path.isEmpty()) throw new Exception();
	    List<String> dirs = getDirs(path);

	    Dir cur = root;
	    for(int i = 0 ; i < dirs.size()-1; i++) {
	        String next = dirs.get(i);
	        if(!cur.subdirs.containsKey(next)) throw new Exception();
	        cur = cur.subdirs.get(next);
	    }

	    String last = dirs.get(dirs.size()-1);
	    if(cur.subdirs.containsKey(last)) throw new Exception();
	    Dir newDir = new Dir(val);
	    cur.subdirs.put(last, newDir);
	}

	public void setValue(String path, String val) throws Exception {
	    if(path==null||path.isEmpty()) throw new Exception();
	    List<String> dirs = getDirs(path);
	    Dir cur = root;
	    for(int i = 0 ; i < dirs.size(); i++) {
	        String str = dirs.get(i);
	        if(cur.callback != null) cur.callback.fireRules();
	        if(!cur.subdirs.containsKey(str)) throw new Exception();
	        cur = cur.subdirs.get(str);
	    }
	    if(cur.callback != null) cur.callback.fireRules();    
	    cur.label = val;
	}

	public String getValue(String path) throws Exception {
	    if(path==null||path.isEmpty()) throw new Exception();
	    List<String> dirs = getDirs(path);
	    Dir cur = root;
	    for(int i = 0 ; i < dirs.size(); i++) {
	        String str = dirs.get(i);
	        if(!cur.subdirs.containsKey(str)) throw new Exception();
	        cur = cur.subdirs.get(str);
	    }
	    return cur.label;
	}

	public void watch(String path, Callback callback) throws Exception {
	    if(path==null||path.isEmpty()) throw new Exception();
	    List<String> dirs = getDirs(path);
	    Dir cur = root;
	    for(int i = 0 ; i < dirs.size(); i++) {
	        String str = dirs.get(i);
	        if(!cur.subdirs.containsKey(str)) throw new Exception();
	        cur = cur.subdirs.get(str);
	    }
	    cur.callback = callback;
	}

	private List<String> getDirs(String path) throws Exception {
	    if (path== null || path.isEmpty()) {
	        throw new Exception("Invalid input");
	    }

	    List<String> res = new ArrayList<>();
	    String[] tokens = path.split("/");
	    for(String str : tokens) {
	        if(!str.isEmpty()) res.add(str);
	    }
	    return res;
	}

	public class Dir {
	    String label;
	    Map<String, Dir> subdirs;
	    Callback callback;
	    public Dir(String l) {
	        label = l;
	        subdirs = new HashMap<>();
	    }
	}

	
	// need to discuss Callback subclass design: multiple instances or multiple implementations
	
	public interface Callback {
		public void fireRules();
		public void notifyReceiver();
	}
	
	public class CallbackPathImpl implements Callback {
		String receiver;
		String path;
		public CallbackPathImpl(String receiver, String path) {
			this.receiver = receiver;
			this.path = path;
		}
		
		public void fireRules() {
			System.out.println(path + " changed value");
		}
		
		public void notifyReceiver() {
			// notify(receiver)...
		}
	}
	
	public class CallbackReceiverImpl implements Callback {
		String receiver;
		String path;
		public CallbackReceiverImpl(String receiver, String path) {
			this.receiver = receiver;
			this.path = path;
		}
		
		public void fireRules() {
			System.out.println(path + " changed value and receiver is " + receiver);
		}
		
		public void notifyReceiver() {
			// notify(receiver)...
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		FileSystem fs = new FileSystem();
		fs.create("/a", "1");
		System.out.println("/a value is " + fs.getValue("/a"));
		
		try {
			fs.create("/b/c", "2");
		} catch (Exception e) {
			System.out.println("error while processing creating path /b/c");
		}
		
		fs.create("/a/b", "123");
		
		fs.setValue("/a/", "c");
		System.out.println("/a value is " + fs.getValue("/a"));
		
		try {
			fs.setValue("/b/c", "2");
		} catch (Exception e) {
			System.out.println("error while processing setting path /b/c");
		}
		
		fs.setValue("/a/b", "456");
		System.out.println("/a/b value is " + fs.getValue("/a/b"));

		
		fs.watch("/a", fs.new CallbackPathImpl("zhaowz", "/a"));
		System.out.println("/a value is " + fs.getValue("/a"));
		fs.setValue("/a/", "d");
		System.out.println("/a value is " + fs.getValue("/a"));
		
		fs.watch("/a/b", fs.new CallbackReceiverImpl("zhaowz", "/a/b"));
		System.out.println("/a/b value is " + fs.getValue("/a/b"));
		fs.setValue("/a/b", "e");
		System.out.println("/a/b value is " + fs.getValue("/a/b"));
	}
}
/*
 * Callback Example:
Define an interface, and implement it in the class that will receive the callback.

Have attention to the multi-threading in your case.

Code example from http://cleancodedevelopment-qualityseal.blogspot.com.br/2012/10/understanding-callbacks-with-java.html

interface CallBack {
    void methodToCallBack();
}

class CallBackImpl implements CallBack {
    public void methodToCallBack() {
        System.out.println("I've been called back");
    }
}

class Caller {

    public void register(CallBack callback) {
        callback.methodToCallBack();
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        CallBack callBack = new CallBackImpl();
        caller.register(callBack);
    }
}

*/ 
