/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashserver;


import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author scollins
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		Server main = new Server();
		ArrayList wordlist = new ArrayList();

		try{
			BufferedReader in = new BufferedReader(new FileReader("/usr/share/dict/words"));

			String line;
			while((line = in.readLine())!= null){
				wordlist.add(line);
			}
			ServerSocket ss = new ServerSocket(8080);


			for(;;){
				Socket client = ss.accept();
				PrintWriter out = new PrintWriter( new OutputStreamWriter(client.getOutputStream()));

				for(int i=0;i<5;i++){
					out.println(wordlist.get(0));
					wordlist.remove(0);
				}

				out.close();
				client.close();

			}

		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}

}


