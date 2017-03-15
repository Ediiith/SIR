/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.ShortLookupTable;
import javax.swing.JPanel;


public class TraitementImage extends JPanel {

    private Image displayImage;
    private BufferedImage bi;
    private Graphics2D big;
    private LookupTable lookupTable;

    /**
     * Constructeur
     *
     * @param img l'image à traiter
     */
    public TraitementImage(Image img) {
        loadImage(img);
        if (displayImage.getWidth(this) > displayImage.getHeight(this)) {
            setSize(displayImage.getWidth(this), displayImage.getWidth(this)); // panel
        } else if (displayImage.getWidth(this) < displayImage.getHeight(this)) {
            setSize(displayImage.getHeight(this), displayImage.getHeight(this)); // panel
        } else if (displayImage.getWidth(this) == displayImage.getHeight(this)) {
            setSize(displayImage.getHeight(this), displayImage.getHeight(this)); // panel
        }
        createBufferedImage();
    }

    /**
     * Charger une image
     *
     * @param img l'image à charger
     */
    public void loadImage(Image img) {

        displayImage = img;
        MediaTracker mt = new MediaTracker(this);

        mt.addImage(displayImage, 1);
        try {
            mt.waitForAll();
        } catch (Exception e) {
            System.out.println("Exception while loading.");
        }

        if (displayImage.getWidth(this) == -1) {
            System.out.println("No jpg file");
        }

    }

    /**
     * Crée une BufferedImage.
     */
    public void createBufferedImage() {
        if (displayImage.getWidth(this) > displayImage.getHeight(this)) {
            bi = new BufferedImage(displayImage.getWidth(this), displayImage
                    .getWidth(this), BufferedImage.TYPE_INT_ARGB);
        } else if (displayImage.getWidth(this) < displayImage.getHeight(this)) {
            bi = new BufferedImage(displayImage.getHeight(this), displayImage
                    .getHeight(this), BufferedImage.TYPE_INT_ARGB);
        } else if (displayImage.getWidth(this) == displayImage.getHeight(this)) {
            bi = new BufferedImage(displayImage.getWidth(this), displayImage
                    .getHeight(this), BufferedImage.TYPE_INT_ARGB);
        }

        big = bi.createGraphics();
        big.drawImage(displayImage, 0, 0, this);
    }

    /**
     * Eclairci l'image.
     */
    public void brightenLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i + 10);
            if (pixelValue > 255) {
                pixelValue = 255;
            } else if (pixelValue < 0) {
                pixelValue = 0;
            }
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    /**
     * Augmente le contraste.
     */
    public void contrastIncLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i * 1.2);
            if (pixelValue > 255) {
                pixelValue = 255;
            } else if (pixelValue < 0) {
                pixelValue = 0;
            }
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    /**
     * Diminue le contraste.
     */
    public void contrastDecLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i / 1.2);
            if (pixelValue > 255) {
                pixelValue = 255;
            } else if (pixelValue < 0) {
                pixelValue = 0;
            }
            brighten[i] = pixelValue;
        }
        lookupTable = new ShortLookupTable(0, brighten);
    }

    /**
     * Inverse les niveaux de gris.
     */
    public void reverseLUT() {
        byte reverse[] = new byte[256];
        for (int i = 0; i < 256; i++) {
            reverse[i] = (byte) (255 - i);
        }
        lookupTable = new ByteLookupTable(0, reverse);
    }

    /**
     * Réinitialise l'image.
     */
    public void reset() {
        big.setColor(Color.black);
        big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
        big.drawImage(displayImage, 0, 0, this);
    }

    /**
     * Effectue une rotation de 90°.
     */
    public void rotation() {
        AffineTransform transformer = new AffineTransform();
        transformer.rotate(Math.toRadians(90), bi.getWidth() / 2, bi.getHeight() / 2);
        AffineTransformOp op = new AffineTransformOp(transformer,
                AffineTransformOp.TYPE_BILINEAR);
        bi = op.filter(bi, null);
    }

    /**
     * Effectue une symétrie par un axe vertical de l'image.
     */
    public void symetrieVerticale() {
        AffineTransform transformer = AffineTransform.getScaleInstance(1, -1);
        transformer.translate(0, -bi.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(transformer, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bi = op.filter(bi, null);
    }

    /**
     * Effectue une symétrie par un axe horizontal de l'image.
     */
    public void symetrieHorizontale() {
        AffineTransform transformer = AffineTransform.getScaleInstance(-1, 1);
        transformer.translate(-bi.getHeight(null), 0);
        AffineTransformOp op = new AffineTransformOp(transformer, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bi = op.filter(bi, null);
    }

    public void applyFilter() {
        LookupOp lop = new LookupOp(lookupTable, null);
        lop.filter(bi, bi);
    }
    
    public void zoomIn() {
        AffineTransform transformer = new AffineTransform();
        transformer.scale(1.1, 1.1);
        AffineTransformOp op = new AffineTransformOp(transformer, AffineTransformOp.TYPE_BILINEAR);
        bi = op.filter(bi, null);
    }
    
    public void zoomOut() {
        AffineTransform transformer = new AffineTransform();
        transformer.scale(0.9, 0.9);
        AffineTransformOp op = new AffineTransformOp(transformer, AffineTransformOp.TYPE_BILINEAR);
        bi = op.filter(bi, null);
    }

    @Override
    public void update(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        paintComponent(g);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(bi, 0, 0, this);
    }

    /**
     * 
     * @return l'image affichée
     */
    public Image getDisplayImage() {
        return displayImage;
    }

    public BufferedImage getBi() {
        return bi;
    }
    
}
