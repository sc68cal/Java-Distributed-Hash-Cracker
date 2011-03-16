/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientcracker;

/**
 *
 * @author scollins
 */
public class DHTKey implements de.uniba.wiai.lspi.chord.service.Key{

	private byte[] theData;


	public DHTKey(byte[] theData){
		this.theData = theData;
	}

	public byte[] getBytes(){
		return this.theData;
	}


}
