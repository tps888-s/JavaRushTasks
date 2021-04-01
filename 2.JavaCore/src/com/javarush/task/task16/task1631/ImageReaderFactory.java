package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imgtp){

        if (imgtp==ImageTypes.JPG) return new JpgReader();
        if (imgtp==ImageTypes.PNG) return new PngReader();
        if (imgtp==ImageTypes.BMP) return new BmpReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
