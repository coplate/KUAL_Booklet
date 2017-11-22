package com.mobileread.ixtab.kindlelauncher.ui.v1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.amazon.kindle.kindlet.ui.KLabel;

public class KualLabel extends KLabel implements KualPaintable {

	private static final long serialVersionUID = 1L;

	public KualLabel(String text) {
		super(text);
	}

	public void paint(Graphics g) {
		KualPainter.paint(g, this);
	}

	public void paintBorder(Graphics g) {
	}

	public Color getTextColor() {
		return COLOR_FOREGROUND;
	}

	public float getTextAlignmentX() {
		return Component.LEFT_ALIGNMENT;
	}

	public float getTextAlignmentY() {
		return Component.CENTER_ALIGNMENT;
	}

}
