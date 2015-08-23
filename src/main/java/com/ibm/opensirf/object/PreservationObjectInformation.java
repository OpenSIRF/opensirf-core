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
package com.ibm.opensirf.object;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.ibm.opensirf.audit.PreservationObjectAuditLog;

@XmlType(propOrder={"objectIdentifiers", "objectCreationDate", "objectLastModifiedDate", "objectLastAccessedDate", "objectRelatedObjects", "packagingFormat", "objectFixity", "objectRetention", "objectAuditLog", "objectExtension", "versionIdentifierUUID"})

/* 
 * 
	@XmlTransient
	private String versionIdentifierUUID;

	private HashSet<PreservationObjectIdentifier> objectIdentifiers;

	private HashSet<RelatedObjects> objectRelatedObjects;

	private HashSet<Extension> objectExtension;

	@XmlElement(name="objectAuditLog")
	private HashSet<PreservationObjectAuditLog> objectAuditLogs;

	private String objectCreationDate;

	private String objectLastModifiedDate;

	private String objectLastAccessedDate;

	private PackagingFormat packagingFormat;
	
	private FixityInformation objectFixity;
	
	private Retention objectRetention;
 */

public class PreservationObjectInformation {
	public PreservationObjectInformation() {
	}

	public PreservationObjectInformation(String packagingFormat) {
		objectIdentifiers = new HashSet<PreservationObjectIdentifier>();
		final String currentTimestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'").format(new GregorianCalendar().getTime());
		objectCreationDate = currentTimestamp;
		objectLastAccessedDate = currentTimestamp;
		objectLastModifiedDate = currentTimestamp;
		versionIdentifierUUID = null;
		objectFixity = null;
		objectRelatedObjects = new HashSet<RelatedObjects>();
		objectAuditLog = new HashSet<PreservationObjectAuditLog>();
		objectExtension = new HashSet<Extension>();
		this.packagingFormat = new PackagingFormat(packagingFormat);
	}

	public HashSet<Extension> getObjectExtension() {
		return objectExtension;
	}

	public void setObjectExtension(HashSet<Extension> objectExtension) {
		this.objectExtension = objectExtension;
	}

	public HashSet<PreservationObjectIdentifier> getObjectIdentifiers() {
		return objectIdentifiers;
	}

	public boolean addObjectIdentifier(PreservationObjectIdentifier objectIdentifier) {
		if (versionIdentifierUUID == null)
			versionIdentifierUUID = objectIdentifier.getObjectVersionIdentifier().getObjectIdentifierValue();
		return objectIdentifiers.add(objectIdentifier);
	}

	public FixityInformation getObjectFixity() {
		return objectFixity;
	}

	public void setObjectFixity(FixityInformation objectFixity) {
		this.objectFixity = objectFixity;
	}

	public PackagingFormat getPackagingFormat() {
		return packagingFormat;
	}

	public void setPackagingFormat(PackagingFormat packagingFormat) {
		this.packagingFormat = packagingFormat;
	}

	public HashSet<PreservationObjectAuditLog> getObjectAuditLog() {
		return objectAuditLog;
	}

	public void setObjectAuditLog(HashSet<PreservationObjectAuditLog> objectAuditLogObjectIds) {
		this.objectAuditLog = objectAuditLogObjectIds;
	}

	public void setObjectIdentifiers(HashSet<PreservationObjectIdentifier> objectIdentifiers) {
		this.objectIdentifiers = objectIdentifiers;
	}

	public String getObjectCreationDate() {
		return objectCreationDate;
	}

	public void setObjectCreationDate(String objectCreationDate) {
		this.objectCreationDate = objectCreationDate;
	}

	public String getObjectLastModifiedDate() {
		return objectLastModifiedDate;
	}

	public void setObjectLastModifiedDate(String modificationDate) {
		this.objectLastModifiedDate = modificationDate;
	}

	public String getObjectLastAccessedDate() {
		return objectLastAccessedDate;
	}

	public void setObjectLastAccessedDate(String lastAccessDate) {
		this.objectLastAccessedDate = lastAccessDate;
	}

	public String getVersionIdentifierUUID() {
		return versionIdentifierUUID;
	}

	public void setVersionIdentifierUUID(String versionIdentifierUUID) {
		this.versionIdentifierUUID = versionIdentifierUUID;
	}

	public HashSet<RelatedObjects> getObjectRelatedObjects() {
		return objectRelatedObjects;
	}

	public void setObjectRelatedObjects(HashSet<RelatedObjects> objectRelatedObjects) {
		this.objectRelatedObjects = objectRelatedObjects;
	}
	
	public Retention getObjectRetention() {
		return objectRetention;
	}

	public void setObjectRetention(Retention objectRetention) {
		this.objectRetention = objectRetention;
	}

	@XmlTransient
	private String versionIdentifierUUID;

	private HashSet<PreservationObjectIdentifier> objectIdentifiers;

	private HashSet<RelatedObjects> objectRelatedObjects;

	private HashSet<Extension> objectExtension;

	private HashSet<PreservationObjectAuditLog> objectAuditLog;

	private String objectCreationDate;

	private String objectLastModifiedDate;

	private String objectLastAccessedDate;

	private PackagingFormat packagingFormat;
	
	private FixityInformation objectFixity;
	
	private Retention objectRetention;
	
	
}
