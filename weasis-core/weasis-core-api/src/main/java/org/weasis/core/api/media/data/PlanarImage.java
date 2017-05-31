package org.weasis.core.api.media.data;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.weasis.core.api.image.cv.ImageCV;

public interface PlanarImage extends ImageSize {

    // javadoc: Mat::channels()
    int channels();

    // javadoc: Mat::dims()
    int dims();

    // javadoc: Mat::depth()
    int depth();

    // javadoc: Mat::elemSize()
    long elemSize();

    // javadoc: Mat::elemSize1()
    long elemSize1();

    // javadoc: Mat::release()
    void release();

    // javadoc: Mat::size()
    Size size();

    // javadoc: Mat::type()
    int type();

    // javadoc:Mat::height()
    int height();

    // javadoc:Mat::width()
    int width();

    double[] get(int x, int y);

    int get(int i, int j, byte[] pixelData);

    int get(int i, int j, short[] data);

    int get(int i, int j, int[] data);

    int get(int i, int j, float[] data);

    int get(int i, int j, double[] data);

    void assignTo(Mat dstImg);

    default Mat toMat() {
        if (this instanceof Mat) {
            return (Mat) this;
        } else {
            throw new IllegalAccessError("Not implemented yet");
        }
    }

    default ImageCV toImageCV() {
        if (this instanceof Mat) {
            if (this instanceof ImageCV) {
                return (ImageCV) this;
            }
            ImageCV dstImg = new ImageCV();
            this.assignTo(dstImg);
            return dstImg;
        } else {
            throw new IllegalAccessError("Not implemented yet");
        }
    }

}