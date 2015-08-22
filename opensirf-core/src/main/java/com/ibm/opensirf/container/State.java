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

package com.ibm.opensirf.container;

import javax.xml.bind.annotation.XmlTransient;

public class State {

	public State() {
	}

	public State(String containerStateType, String containerStateValue) {
		super();
		this.containerStateType = containerStateType;
		this.containerStateValue = containerStateValue;
	}

	public String getContainerStateType() {
		return containerStateType;
	}

	public String getContainerStateValue() {
		return containerStateValue;
	}

	public void setContainerStateType(String containerStateType) {
		this.containerStateType = containerStateType;
	}

	public void setContainerStateValue(String containerStateValue) {
		this.containerStateValue = containerStateValue;
	}

	private String containerStateType;

	private String containerStateValue;

	@XmlTransient
	public static final String STATE_TYPE_CONTAINER_INITIALIZING = "initializing";

	@XmlTransient
	public static final String STATE_TYPE_CONTAINER_READY = "ready";

	@XmlTransient
	public static final String STATE_TYPE_CONTAINER_MIGRATING = "migrating";

	@XmlTransient
	public static final String STATE_TYPE_CONTAINER_DESTROYED = "destroyed";

	@XmlTransient
	public static final String STATE_TYPE_CONTAINER_CLOSED = "closed";

	@XmlTransient
	public static final String TRUE = "true";

	@XmlTransient
	public static final String FALSE = "false";
}
