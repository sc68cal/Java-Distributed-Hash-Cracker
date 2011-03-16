/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientcracker;

import java.net.Socket;
import java.io.*;
import de.uniba.wiai.lspi.chord.service.*;
import de.uniba.wiai.lspi.chord.data.*;


/**
 *
 * @author scollins
 */
public class Main {


	public static void main(String[] args){
		Digester md = new Digester();

		String[] wordlist = new String[5];


		String protocol = URL.KNOWN_PROTOCOLS.get(URL.SOCKET_PROTOCOL);


		// Arg 1 is the server where the wordlist is located
		String hostname = "localhost"; //args[1];
		int portnum = 1337;

		try{

			// DHT initialization
			URL localURL = new URL(protocol+ "://localhost:1477/");
			de.uniba.wiai.lspi.chord.service.PropertiesLoader.loadPropertyFile();
			URL bootstrapURL = new URL(protocol + "://" + hostname + ":" + portnum + "/");
			Chord chord = new de.uniba.wiai.lspi.chord.service.impl.ChordImpl();
			chord.join(localURL,bootstrapURL);

			
			// Wordlist initialization


			for(;;){
				for(int i=0;i<5;i++){
					Socket wordsocket = new Socket(hostname,8080);
					InputStream sin= wordsocket.getInputStream();
					BufferedReader fromServer = new BufferedReader(new InputStreamReader(sin));
					String tmp = fromServer.readLine();
					DHTKey myKey = new DHTKey(md.digest(tmp));
					chord.insert(myKey,tmp);
				}
			}


		}catch(Exception ex){
			System.out.println(ex);
		}





	}
}
