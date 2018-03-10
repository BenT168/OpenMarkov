/*
* Copyright 2012 CISIAD, UNED, Spain
*
* Licensed under the European Union Public Licence, version 1.1 (EUPL)
*
* Unless required by applicable law, this code is distributed
* on an "AS IS" basis, WITHOUT WARRANTIES OF ANY KIND.
*/
package org.openmarkov.core.exception;

@SuppressWarnings("serial")
public class UnexpectedInferenceException extends Exception {
	
	// Constructor
		/** @param message */
		public UnexpectedInferenceException(String message) {
			super(message);
		}
}