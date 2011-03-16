/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hashserver;
import de.uniba.wiai.lspi.chord.service.*;
import de.uniba.wiai.lspi.chord.data.*;

/**
 *
 * @author scollins
 */
public class Server {

	private Chord chord;

	public Server(){
		de.uniba.wiai.lspi.chord.service.PropertiesLoader.loadPropertyFile();
		String protocol = URL.KNOWN_PROTOCOLS.get(URL.SOCKET_PROTOCOL);
		URL localurl;

		try{
			 localurl = new URL(protocol + "://localhost:1337/");

		}catch(Exception e){
			throw new RuntimeException(e);

		}

		chord = new de.uniba.wiai.lspi.chord.service.impl.ChordImpl();

		try{
			chord.create(localurl);

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}


}
