package socket;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
 
public class TestSocket {
 
    public static void main(String[] args) throws IOException {
    	
        InetAddress host = InetAddress.getLocalHost();
        String ip = host.getHostAddress();
        String ipalt = ip.substring(0,ip.lastIndexOf(".")+1);
        List<String> ippool = new ArrayList<String>();
        List<String> badip = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        int end = 0 ;
        boolean check = true;
        
        while(check) {
        	end++;
        	String iptest = ipalt + end;
        Process p = Runtime.getRuntime().exec("ping " + iptest);
        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        int rep = 0;
        while (rep < 2 && (line = br.readLine())!=null) {
        	rep++;
        	if(line != null) {
        		sb.append(line + "\r\n");
        	}
        }
        while((line = br.readLine())!=null) {
        	System.out.println("ping " + iptest);
        	if(line.contains("timeout")) {
        		badip.add(iptest);
        	}
        	if(end == 225) {
        		check = false;
        		break;
        	}
        	if(line.contains("ttl")) {
        		ippool.add(iptest);
        		break;
        		}
        	break;
        }
        br.close();
        } 
        
        
        System.out.println(ippool);
        System.out.println("可用ip有" + ippool.size());
       
}
}