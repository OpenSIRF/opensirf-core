/*
 * OpenSIRF Core
 * 
 * Copyright IBM Corporation 2015.
 * All Rights Reserved.
 * 
 * MIT License:
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * Except as contained in this notice, the name of a copyright holder shall not
 * be used in advertising or otherwise to promote the sale, use or other
 * dealings in this Software without prior written authorization of the
 * copyright holder.
 */

package org.opensirf.container;

import org.opensirf.catalog.SIRFCatalog;

public class SIRFContainer {

	public SIRFContainer(String containerName) {
		this.magicObject = new MagicObject(CONTAINER_SPECIFICATION, SIRF_LEVEL, SIRF_DEFAULT_CATALOG_ID);
		this.catalog = new SIRFCatalog(SIRF_DEFAULT_CATALOG_ID, containerName);
	}

	public SIRFCatalog getCatalog() {
		return catalog;
	}

	public MagicObject getMagicObject() {
		return magicObject;
	}

	public void setMagicObject(MagicObject magicObject) {
		this.magicObject = magicObject;
	}

	private SIRFCatalog catalog;
	private MagicObject magicObject;

	public static final String CONTAINER_SPECIFICATION = "1.0";
	public static final String SIRF_LEVEL = "1";
	public static final String SIRF_DEFAULT_CATALOG_ID = "catalog.json";
	public static final String SIRF_DEFAULT_PROVENANCE_MANIFEST_FILE = "provenance.po.json";
}
