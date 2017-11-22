package com.mobileread.ixtab.kindlelauncher.ui.v1;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.amazon.kindle.kindlet.KindletContext;
import com.amazon.kindle.kindlet.event.KindleKeyCodes;
import com.amazon.kindle.kindlet.ui.KButton;
import com.amazon.kindle.kindlet.ui.KLabel;
import com.amazon.kindle.kindlet.ui.KPanel;
import com.mobileread.ixtab.kindlelauncher.ui.UIAdapter;
import com.mobileread.ixtab.kindlelauncher.resources.KualEntry;

public class KUIAdapter extends UIAdapter {

	private static String userFontFamily;
	private static int userFontStyle;

	// Allow user-configured Fonts, even if it's not terribly useful on KDK-1
	public void setupUserFont(Container root, String fontFamily, int fontStyle) {
		// KualFonts will need that later...
		userFontFamily = fontFamily;
		userFontStyle = fontStyle;
	}

	public static String getUserFontFamily() {
		return userFontFamily;
	}

	public static int getUserFontStyle() {
		return userFontStyle;
	}

	public Container newPanel(LayoutManager layout) {
		return layout != null ? new KPanel(layout) : new KPanel();
	}

	public Component newLabel(String text) {
		return new KualLabel(text);
	}

	public Component newButton(String text, ActionListener listener, KeyListener keyListener, KualEntry kualEntry) {
		KButton button = new KualButton(text, kualEntry);
		if (listener != null) {
			button.setName(text);
			button.addActionListener(listener);
		}
		if (keyListener != null)
			button.addKeyListener(keyListener);
		return button;
	}

	public void setText(Component component, String text) {
		if (component instanceof KLabel) {
			((KLabel) component).setText(text);
			component.repaint();
		}
		if (component instanceof KButton) {
			((KButton) component).setLabel(text);
		}
	}

	public void suicide(KindletContext context) {
		int code = KindleKeyCodes.VK_BACK;
		//code = 61442;
		KeyEvent k = new KeyEvent(context.getRootContainer(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, code, (char)0);
		context.getRootContainer().dispatchEvent(k);
	}

	public int getDefaultPageSize() {
		// these are non-touch models, so it's tedious to scroll.
		return 5;
	}

	public KualEntry getKualEntry(Component component) {
		if (component instanceof KualButton)
			return ((KualButton) component).getKualEntry();
		return null;
	}
}
