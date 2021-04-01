package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //ByteArrayOutputStream out = new ByteArrayOutputStream();
        Path zipFile = Paths.get(args[1]);
        Path newFile = Paths.get(args[0]);
        String newFileName = args[0].substring(args[0].lastIndexOf("/"));

        // Создаем временный файл
        Path tempZipFile = Files.createTempFile(null, null);
        List<Path> archiveFiles = new ArrayList<>();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {
            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {

                ZipEntry zipEntry = zipInputStream.getNextEntry();
                while (zipEntry != null) {
                    String fileName = zipEntry.getName();

                    if (!fileName.equals("new" + newFileName )) {

                        archiveFiles.add(Paths.get(fileName));

                        zipOutputStream.putNextEntry(new ZipEntry(fileName));

                        byte[] buffer = new byte[8 * 1024];
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            zipOutputStream.write(buffer, 0, len);
                        }

                        zipInputStream.closeEntry();

                        zipOutputStream.closeEntry();
                    }
                zipEntry = zipInputStream.getNextEntry();

                }
            }

            // Архивируем новые файлы

            try (InputStream inputStream = Files.newInputStream(newFile);
                ) {

                ZipEntry entry = new ZipEntry("new/" + newFile.getFileName().toString());

                zipOutputStream.putNextEntry(entry);

                Files.copy(newFile,zipOutputStream);
                /*
                byte[] buffer = new byte[8 * 1024];
                int len;
                while ((len = inputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }

                 */
                zipOutputStream.closeEntry();
            }
        }

        // Перемещаем данные на место оригинального файла
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);

        /*
        try(
        FileOutputStream output = new FileOutputStream(args[1], false);
        ){
            output.write(out.toByteArray());
        }

         */

    }
}
