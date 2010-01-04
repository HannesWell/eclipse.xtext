/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("rawtypes")
public interface INFATransition<S extends INFAState, T extends INFATransition> {
	public int getPrecedence();

	public S getTarget();

	public boolean isRuleCall();
}
