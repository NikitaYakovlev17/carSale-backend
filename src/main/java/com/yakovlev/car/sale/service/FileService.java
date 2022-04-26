package com.yakovlev.car.sale.service;

import com.dropbox.core.DbxException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    private final DropboxService dropboxService;

    public String saveFile(String extension, String path, MultipartFile file) throws IOException, DbxException {
        extension = "." + extension;
        path = "/" + path;
        String dropBoxName = UUID.randomUUID().toString();
        saveFileLocally(dropBoxName, extension, file);
        FileInputStream inputStream = new FileInputStream(getPath(dropBoxName, extension));
        dropboxService.upload(inputStream, path, dropBoxName + extension);

        removeFileLocally(dropBoxName, extension);
        return dropBoxName;
    }

    public void saveFileLocally(String fileName, String extension, MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(getPath(fileName, extension)));
        stream.write(bytes);
        stream.close();
    }

    public void removeFileLocally(String fileName, String extension) {
        File file = new File(getPath(fileName, extension));
        file.delete();
    }

    public String getPath(String fileName, String extension) {
        return FileSystems.getDefault().getPath("").toAbsolutePath() + "/materials/" + fileName + extension;
    }
}