/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class CachingReflectionTypeProviderTest extends ReflectionTypeProviderTest {

	@Inject
	private CachingReflectionTypeProviderFactory typeProviderFactory;
	
	@Override
	protected ReflectionTypeProvider createTypeProvider() {
		return typeProviderFactory.createTypeProvider(getResourceSet());
	}
	
}
