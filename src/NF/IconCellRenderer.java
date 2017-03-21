/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author RISE
 */
public class IconCellRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;
    private int size;
    private BufferedImage icon;

    /**
     * Constructeur par défaut. Crée un icône de taille 100
     */
    public IconCellRenderer() {
        this(100);
    }

    /**
     * Constructeur. Crée un icône avec la taille définie en paramètre
     *
     * @param size taille de la cellule
     */
    public IconCellRenderer(int size) {
        this.size = size;
        icon = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (c instanceof JLabel && value instanceof BufferedImage) {
            JLabel l = (JLabel) c;
            l.setText("");
            BufferedImage i = (BufferedImage) value;
            l.setIcon(new ImageIcon(icon));

            Graphics2D g = icon.createGraphics();
            g.setColor(new Color(0, 0, 0, 0));
            g.clearRect(0, 0, size, size);
            g.drawImage(i, 0, 0, size, size, this);

            g.dispose();
        }
        return c;
    }

}
