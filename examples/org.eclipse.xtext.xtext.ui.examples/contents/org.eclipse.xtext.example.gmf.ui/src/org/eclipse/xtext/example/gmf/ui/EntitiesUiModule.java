/*
 * generated by Xtext
 */
package org.eclipse.xtext.example.gmf.ui;

import org.eclipse.xtext.ui.editor.info.ResourceForResourceWorkingCopyEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EntitiesUiModule extends org.eclipse.xtext.example.gmf.ui.AbstractEntitiesUiModule {

	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return ResourceForResourceWorkingCopyEditorInputFactory.class;
	}

}
