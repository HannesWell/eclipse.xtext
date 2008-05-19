/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.core.service;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.xtext.ui.core.language.ILanguageService;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public interface ISyntaxColorer extends ILanguageService {
	/**
	 * @param token
	 * @return TextAttribute for given token
	 */
	TextAttribute color(Object token);
}
