package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import java.util.NoSuchElementException;
import java.util.Optional;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException {
        Optional<ImageTypes> optional = Optional.ofNullable(imageType);
        try {
            imageType = optional.get();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e);
        }
        switch (imageType) {
            case JPG:
                return new JpgReader();
            case BMP:
                return new BmpReader();
            case PNG:
                return new PngReader();
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
