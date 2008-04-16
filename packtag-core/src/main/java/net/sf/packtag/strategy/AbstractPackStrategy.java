/**
 * Project pack:tag >> http://packtag.sf.net
 *
 * This software is published under the terms of the LGPL
 * License version 2.1, a copy of which has been included with this
 * distribution in the 'lgpl.txt' file.
 * 
 * Last author:   $Author: danielgalan $
 * Last modified: $Date: 2007/09/23 14:37:31 $
 * Revision:      $Revision: 1.2 $
 * 
 * $Log: AbstractPackStrategy.java,v $
 * Revision 1.2  2007/09/23 14:37:31  danielgalan
 * Added charset support
 *
 * Revision 1.1  2007/04/22 19:04:23  danielgalan
 * pack.tag moved from subversion to good old CVS
 *
 */
package net.sf.packtag.strategy;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;



/**
 * A super Strategy with supporting methods.
 * 
 * @author Daniel Gal�n y Martins
 * @version $Revision: 1.2 $
 */
public abstract class AbstractPackStrategy implements PackStrategy {

	protected static final String LINE_SEPARATOR = System.getProperty("line.separator");


	protected String resourceToString(final InputStream resourceAsStream, final Charset charset) throws PackException {
		StringBuffer result = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream, charset));
		try {
			boolean firstLine = true;
			String line = br.readLine();
			while(line != null) {
				if (firstLine) {
					firstLine = false;
				}
				else {
					result.append(LINE_SEPARATOR);
				}
				result.append(line);
				line = br.readLine();
			}
			br.close();
		}
		catch (Exception ex) {
			throw new PackException(ex);
		}
		return result.toString();
	}

}
