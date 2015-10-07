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

import java.util.HashSet;

import javax.xml.bind.annotation.XmlType;

import org.opensirf.audit.ContainerAuditLog;

@XmlType(propOrder={"containerSpecification", "containerIdentifier", "containerState", "containerProvenanceReference", "containerAuditLog"})

public class ContainerInformation {

	public ContainerInformation() {
		containerAuditLog = new HashSet<ContainerAuditLog>();
		containerSpecification = new ContainerSpecification();
	}

	public ContainerSpecification getContainerSpecification() {
		return containerSpecification;
	}

	public void setContainerSpecification(ContainerSpecification containerSpecification) {
		this.containerSpecification = containerSpecification;
	}

	public ContainerIdentifier getContainerIdentifier() {
		return containerIdentifier;
	}

	public void setContainerIdentifier(ContainerIdentifier containerIdentifier) {
		this.containerIdentifier = containerIdentifier;
	}

	public State getContainerState() {
		return containerState;
	}

	public void setContainerState(State containerState) {
		this.containerState = containerState;
	}

	public HashSet<ContainerAuditLog> getContainerAuditLog() {
		return containerAuditLog;
	}

	public void setContainerAuditLog(HashSet<ContainerAuditLog> containerAuditLogObjectIds) {
		this.containerAuditLog = containerAuditLogObjectIds;
	}
	
	public ContainerProvenanceReference getContainerProvenanceReference() {
		return containerProvenanceReference;
	}

	public void setContainerProvenanceReference(ContainerProvenanceReference provenanceReference) {
		this.containerProvenanceReference = provenanceReference;
	}

	private ContainerSpecification containerSpecification;

	private ContainerIdentifier containerIdentifier;

	private State containerState;

	private ContainerProvenanceReference containerProvenanceReference;
		
	private HashSet<ContainerAuditLog> containerAuditLog;

}
