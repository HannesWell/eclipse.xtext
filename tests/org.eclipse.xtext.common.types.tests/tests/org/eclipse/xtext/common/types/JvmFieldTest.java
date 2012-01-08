/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFieldTest extends JvmFeatureTest {

	private JvmField field;

	@Before
	public void setUp() throws Exception {
		field = TypesFactory.eINSTANCE.createJvmField();
	}
	
	@Override
	protected JvmFeature getObjectUnderTest() {
		return field;
	}
	
	@Test public void testGetIdentifier_02() {
		field.internalSetIdentifier("java.lang.DoesNotExist.fieldName");
		assertEquals("java.lang.DoesNotExist.fieldName", field.getIdentifier());
	}
	
	@Test public void testGetIdentifier_03() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.internalSetIdentifier("java.lang.DoesNotExist");
		type.getMembers().add(field);
		field.setSimpleName("fieldName");
		assertEquals("java.lang.DoesNotExist.fieldName", field.getIdentifier());
	}
	
	@Test public void testGetIdentifier_04() {
		JvmGenericType type = TypesFactory.eINSTANCE.createJvmGenericType();
		type.setSimpleName("SimpleName");
		type.setPackageName("java.lang");
		type.getMembers().add(field);
		field.setSimpleName("fieldName");
		assertEquals("java.lang.SimpleName.fieldName", field.getIdentifier());
	}
	
}
