/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.internal;

import org.eclipse.ui.*;
import org.eclipse.ui.help.*;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.*;

/**
 * Reset the layout within the active perspective.
 */
public class ResetPerspectiveAction extends Action {
	private IWorkbenchWindow window;	
/**
 * This default constructor allows the the action to be called from the welcome page.
 */
public ResetPerspectiveAction() {
	this(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
}
/**
 *	Create an instance of this class
 */
public ResetPerspectiveAction(IWorkbenchWindow window) {
	super(WorkbenchMessages.getString("ResetPerspective.text")); //$NON-NLS-1$
	setToolTipText(WorkbenchMessages.getString("ResetPerspective.toolTip")); //$NON-NLS-1$
	setEnabled(false);
	WorkbenchHelp.setHelp(this, IHelpContextIds.RESET_PERSPECTIVE_ACTION);
	this.window = window;
}
/**
 *	The user has invoked this action
 */
public void run() {
	IWorkbenchPage page = this.window.getActivePage();
	if (page != null && page.getPerspective() != null) {
		String message = WorkbenchMessages.format("ResetPerspective.message", new Object[] { page.getPerspective().getLabel() }); //$NON-NLS-1$
		String [] buttons= new String[] { 
			IDialogConstants.OK_LABEL,
			IDialogConstants.CANCEL_LABEL
		};
		MessageDialog d= new MessageDialog(
			this.window.getShell(),
			WorkbenchMessages.getString("ResetPerspective.title"), //$NON-NLS-1$
			null,
			message,
			MessageDialog.QUESTION,
			buttons,
			0
		);
		if (d.open() == 0)
			page.resetPerspective();
	}
}
}
