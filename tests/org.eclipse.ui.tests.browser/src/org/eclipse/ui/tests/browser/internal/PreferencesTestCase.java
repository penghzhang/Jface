/*******************************************************************************
 * Copyright (c) 2000, 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.tests.browser.internal;

import org.eclipse.jface.dialogs.Dialog;
import org.junit.Test;


public class PreferencesTestCase {

	@Test
	public void testInternetPreferencePage() {
		Dialog dialog = UITestHelper.getPreferenceDialog("org.eclipse.internet");
		UITestHelper.assertDialog(dialog);
	}

	@Test
	public void testWebBrowserPreferencePage() {
		Dialog dialog = UITestHelper.getPreferenceDialog("org.eclipse.wst.internet.webbrowser.preferencePage");
		UITestHelper.assertDialog(dialog);
	}
}