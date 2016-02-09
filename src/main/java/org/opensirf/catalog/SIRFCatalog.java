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

package org.opensirf.catalog;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.opensirf.container.ContainerIdentifier;
import org.opensirf.container.ContainerInformation;
import org.opensirf.container.ContainerProvenanceReference;
import org.opensirf.container.SIRFContainer;
import org.opensirf.container.State;
import org.opensirf.obj.DigestInformation;
import org.opensirf.obj.FixityInformation;
import org.opensirf.obj.PreservationObjectIdentifier;
import org.opensirf.obj.PreservationObjectInformation;
import org.opensirf.obj.PreservationObjectLogicalIdentifier;
import org.opensirf.obj.PreservationObjectName;
import org.opensirf.obj.PreservationObjectParentIdentifier;
import org.opensirf.obj.PreservationObjectVersionIdentifier;
import org.opensirf.obj.Retention;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class SIRFCatalog {

	public SIRFCatalog() {
	}

	public SIRFCatalog(String catalogId, String containerName) {
		this.catalogId = catalogId;
		objectInformation = new IndexedObjectInformationSet();

		// Creating the provenance PO and adding it to the catalog
		PreservationObjectInformation provenanceInfo = new PreservationObjectInformation("none");
		PreservationObjectIdentifier provenanceId = new PreservationObjectIdentifier();
		String provenanceLogicalIdentifier = "http://snia.org/sirf/" + containerName + "-" + SIRFContainer.SIRF_DEFAULT_PROVENANCE_MANIFEST_FILE;
		String provenanceVersionIdentifier = provenanceLogicalIdentifier + "-1.0";
		provenanceId.setObjectLogicalIdentifier(new PreservationObjectLogicalIdentifier("logicalIdentifier", "en", provenanceLogicalIdentifier));
		provenanceId.setObjectParentIdentifier(new PreservationObjectParentIdentifier("parentIdentifier", "en", "null"));
		provenanceId.setObjectVersionIdentifier(new PreservationObjectVersionIdentifier("versionIdentifier", "en", provenanceVersionIdentifier));
		provenanceId.putObjectName(new PreservationObjectName("name", "en", SIRFContainer.SIRF_DEFAULT_PROVENANCE_MANIFEST_FILE));
		provenanceInfo.addObjectIdentifier(provenanceId);
		// UNIT TEST
		DigestInformation di = new DigestInformation("ObjectApi", "SHA-1", "7bec3092783ac1cffe4ff4b0c98958e2b776a4e2");
		provenanceInfo.setObjectFixity(new FixityInformation(di));
		
		Retention r = new Retention("time_period", "forever");
		provenanceInfo.setObjectRetention(r);
		
		//END OF UNIT TEST
		//objectInformation.add(provenanceInfo);
		objectInformation.put(provenanceInfo);

		// Creating the container information
		containerInformation = new ContainerInformation();
		containerInformation.setContainerIdentifier(new ContainerIdentifier("containerIdentifier", "en", containerName));
		containerInformation.setContainerState(new State(State.STATE_TYPE_CONTAINER_READY, State.TRUE));
//		containerInformation.setContainerProvenance(new Provenance(SIRFContainer.SIRF_DEFAULT_PROVENANCE_MANIFEST_FILE, provenanceId));
		containerInformation.setContainerProvenanceReference(new ContainerProvenanceReference("internal", "Provenance", provenanceVersionIdentifier));
	}

	public String getCatalogId() {
		return catalogId;
	}

	public ContainerInformation getContainerInformation() {
		return containerInformation;
	}
	
	public IndexedObjectInformationSet getSirfObjects() {
		return objectInformation;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public void setContainerInformation(ContainerInformation containerInformation) {
		this.containerInformation = containerInformation;
	}

	private String catalogId;
	
	private ContainerInformation containerInformation;

	@XmlElementWrapper(name="objectsSet")
	private IndexedObjectInformationSet objectInformation;

}
