/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1_game;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 *
 * @author Lan
 */
public class Bai1_game {

    /**
     * @param args the command line arguments
     */
    public static void join(String inputPath, String outputPath, int size) throws IOException {
        File directory = new File(inputPath);
        File[] files = directory.listFiles();

        BufferedImage sprite = ImageIO.read(files[0]);

        int width = sprite.getWidth();
        int height = sprite.getHeight();

        for (File file : files) {
            BufferedImage bufferedImage = ImageIO.read(file);
            if (bufferedImage.getWidth() > width) {
                width = bufferedImage.getWidth();
            }
            if (bufferedImage.getHeight() > height) {
                height = bufferedImage.getHeight();
            }
        }

        int maxwidth = width * size;
        int maxheight = height * size;
        BufferedImage spritemap = new BufferedImage(maxwidth, maxheight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = spritemap.createGraphics();

        int x = 0;
        int y = 0;
        int i = 0;
        for (File file : files) {
            sprite = ImageIO.read(file);
            g2d.drawImage(sprite, null, x, y);
            x += width;
            i++;
            if (i % size == 0) {
                y += height;
                x = 0;
            }
            if (i > size * size) {
                break;
            }
        }

        ImageIO.write(spritemap, "png", new File(outputPath));
    }
    public static void main(String[] args) {
         try {
            // TODO code application logic here
            Bai1_game.join("C:\\Users\\Lan\\Documents\\NetBeansProjects\\Bai1_game\\src\\img", "C:\\Users\\Lan\\Documents\\NetBeansProjects\\Bai1_game\\src\\outputimg.png", 2);
         } catch (IOException ex) {
            Logger.getLogger(Bai1_game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
