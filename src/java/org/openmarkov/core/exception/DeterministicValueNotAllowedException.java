/*
* Copyright 2011 CISIAD, UNED, Spain
*
* Licensed under the European Union Public Licence, version 1.1 (EUPL)
*
* Unless required by applicable law, this code is distributed
* on an "AS IS" basis, WITHOUT WARRANTIES OF ANY KIND.
*/

package org.openmarkov.core.exception;

@SuppressWarnings("serial")
public class DeterministicValueNotAllowedException extends Exception {

	// Constructor
	/** @param message <code>String</code> */
	public DeterministicValueNotAllowedException(String message) {
		super(message);
	}

}
