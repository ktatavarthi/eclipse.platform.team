/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.team.internal.ccvs.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Image;
import org.eclipse.team.internal.ui.*;

/**
 * Maintains a cache of OverlayIcons.
 */
public class OverlayIconCache {
	private Map /*from OverlayIcon to Image*/ cache = new HashMap();
	
	/**
	 * Returns and caches an image corresponding to the specified icon.
	 * @param icon the icon
	 * @return the image
	 */
	public Image getImageFor(OverlayIcon icon) {
		Image image = (Image) cache.get(icon);
		if (image == null) {
			image = icon.createImage();
			cache.put(icon, image);
		}
		return image;
	}
	
	/**
	 * Disposes of all images in the cache.
	 */
	public void disposeAll() {
		for (Iterator it = cache.values().iterator(); it.hasNext();) {
			Image image = (Image) it.next();
			image.dispose();
		}
		cache.clear();
	}
}
