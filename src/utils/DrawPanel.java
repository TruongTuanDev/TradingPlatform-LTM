package utils;

import javax.swing.JPanel;
import java.awt.GradientPaint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Cursor;

public class DrawPanel extends JPanel {
	
	public DrawPanel(int x, int y,int width,int height) {
		setBounds(x, y, width, height);
		setBackground(new Color(0, 0, 0, 0));
	}
	public DrawPanel() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension arcs = new Dimension(15, 15);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		//#00F260
		//#0575E6
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint color = new GradientPaint(0, 0, Color.decode("#ef32d9"), width, 0, Color.decode("#89fffd"));
		graphics.setPaint(color);
		graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width + 5, arcs.height + 5);
		graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width + 5, arcs.height + 5);
	}

}