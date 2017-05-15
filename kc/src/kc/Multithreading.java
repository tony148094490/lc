package kc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Multithreading {
    /**
     * @param url a url of root page
     * @return all urls
     */
    
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

    public static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
    public static List<String> results = new ArrayList<String>();
    
    public List<String> crawler(String url) {
        try {
			queue.put(url);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for(int i = 0 ; i < 9; i++) {
            executor.submit(new TaskRunner());
        }
        
        
        try {
            Thread.sleep(900);
        } catch (InterruptedException e){
            // e.printStackTrace();
        }

        executor.shutdownNow();
        
        return results;   
        
    }
}

class TaskRunner implements Runnable {
    @Override
    public void run() {
        while (true) {
            String url = "";
            try {
                url = Multithreading.queue.take();
            } catch (Exception e) {
                // e.printStackTrace(); 
                break;
            }

            String domain = "";
            try {
                URL netUrl = new URL(url);
                domain = netUrl.getHost();
            } catch (MalformedURLException e) {
                // e.printStackTrace(); 
            }
            if (!Multithreading.mp.containsKey(url) && domain.endsWith("wikipedia.org")) {
            	Multithreading.mp.put(url, true);
            	Multithreading.results.add(url);
                List<String> urls = new ArrayList<>(); //HtmlHelper.parseUrls(url);
                for (String u : urls) {
                    try {
                    	Multithreading.queue.put(u);
                    } catch (InterruptedException e) {
                        // e.printStackTrace(); 
                    }
                }
            }
        }
    }
}