/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clientcracker;

import java.security.*;
import java.math.*;

/**
 *
 * @author scollins
 */
public class Digester {

	private MessageDigest md;

	public Digester(){
		try{
			md = MessageDigest.getInstance("MD5");

		}catch(java.security.NoSuchAlgorithmException ex){
			System.out.println(ex);

		}

	}

	public void Digester(String hashtype){
		try{
			md = MessageDigest.getInstance(hashtype);

		}catch(java.security.NoSuchAlgorithmException ex){
			System.out.println(ex);

		}

	}

	public byte[] digest(String toDigest){
	    md.update(toDigest.getBytes());

		return md.digest();
	}


}
