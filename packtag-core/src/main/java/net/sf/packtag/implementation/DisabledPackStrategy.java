/**
 * Project pack:tag >> http://packtag.sf.net
 * 
 * This software is published under the terms of the LGPL License version 2.1, a
 * copy of which has been included with this distribution in the 'lgpl.txt'
 * file.
 * 
 * Last author: $Author: danielgalan $ Last modified: $Date: 2007/09/23 14:37:31 $
 * Revision: $Revision: 1.2 $
 * 
 * $Log: DisabledPackStrategy.java,v $ Revision 1.2 2007/09/23 14:37:31
 * danielgalan Added charset support
 * 
 * Revision 1.1 2007/04/22 19:04:25 danielgalan pack.tag moved from subversion
 * to good old CVS
 * 
 */
package net.sf.packtag.implementation;

import java.io.InputStream;
import java.nio.charset.Charset;

import net.sf.packtag.strategy.CssRewritePackStrategy;
import net.sf.packtag.strategy.PackException;



/**
 * A Strategy that does not do any compression, instead it's simply returning
 * the files content
 * 
 * @author Daniel Gal�n y Martins
 * @version $Revision: 1.2 $
 */
public class DisabledPackStrategy extends CssRewritePackStrategy {

	/**
	 * Just replacing every occurring background image path to an absolute one
	 * (unless it isn't already an absolute one). This ensures working images
	 * when re-mapping the base-path to a different root under the web
	 * application.
	 */
	public String pack(final InputStream resourceAsStream, final Charset charset, final String path) throws PackException {
		String result = resourceToString(resourceAsStream, charset);
		result = rewritePath(result, path);
		return result;
	}

}
