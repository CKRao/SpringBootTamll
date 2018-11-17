package com.clarkrao.springboottmall.util;

import org.aspectj.weaver.ast.Var;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * @Author: ClarkRao
 * @Date: 2018/11/17 22:13
 * @Description:
 */

public class ImageUtil {
    /**
     * 确保图片文件的二进制格式是jpg。
     * @param file
     * @return
     */
    public static BufferedImage change2jpg(File file) {
        try {
            Image image = Toolkit.getDefaultToolkit().createImage(file.getAbsolutePath());
            PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, true);
            pixelGrabber.grabPixels();
            int width = pixelGrabber.getWidth();
            int height = pixelGrabber.getHeight();
            final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};
            final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
            DataBuffer buffer = new DataBufferInt((int[]) pixelGrabber.getPixels(),
                    pixelGrabber.getWidth() * pixelGrabber.getHeight());
            WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
            BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
            return img;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 重设图片大小的方法
     * @param srcFile
     * @param width
     * @param height
     * @param destFile
     */
    public static void resizeImage(File srcFile, int width, int height, File destFile) {
        try {
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            Image image = ImageIO.read(srcFile);
            image = resizeImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重设图片大小的方法
     * @param srcImage
     * @param width
     * @param height
     * @return
     */
    private static Image resizeImage(Image srcImage, int width, int height) {
        try {
            BufferedImage bufferedImage = null;
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(
                    srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
