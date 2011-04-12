/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class DependentElementsCalculatorTest extends AbstractXtextTests {

	private XtextResource resource;

	private Element elementA;

	private Element elementB;

	private Element elementC;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
		resource = getResourceFromString("A { B { C } } D");
		elementA = (Element) resource.getContents().get(0).eContents().get(0);
		elementB = elementA.getContained().get(0);
		elementC = elementB.getContained().get(0);
	}

	public void testContentDependentElements() throws Exception {
		Iterable<URI> dependentElementURIs = get(DefaultDependentElementsCalculator.class)
				.getDependentElementURIs(elementA, null);
		assertEquals(2, size(dependentElementURIs));
		assertTrue(contains(dependentElementURIs, EcoreUtil.getURI(elementB)));
		assertTrue(contains(dependentElementURIs, EcoreUtil.getURI(elementC)));
	}

	public void testNullDependentElements() throws Exception {
		Iterable<URI> dependentElementRenameInfos = get(IDependentElementsCalculator.Null.class)
				.getDependentElementURIs(elementA, null);
		assertTrue(isEmpty(dependentElementRenameInfos));
	}

}
