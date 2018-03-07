package org.mycompany.myname.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class UploadPhotoServlet extends HttpServlet {
    private static final String ROOT_FILE_PATH = "src/main/webapp";
    private static final String UPLOAD_IMAGES_PATH = "uploadImages";
    private static final int maxFileSize = 1024 * 1024 * 40; // 40MB
    private static final int maxMemSize = 1024 * 1024 * 100; // 500MB

    private File file;
    private boolean isMultipart;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            writer.print("Incorrect request!!!");
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        File tempPath = new File("temp");
        System.out.println(tempPath.getAbsolutePath());
        factory.setRepository(tempPath);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);
        String pathToImage = "";
        String pathForSaving = "";
       // JDBCDisplayPhoto photo = new JDBCDisplayPhoto();


        try {
            // Parse the request to get file items.
            List<FileItem> fileItems = upload.parseRequest(req);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();


                    // Write the file
                    UUID uuid = UUID.randomUUID();
                    pathForSaving = uuid + "/" + fileName;
                    //photo.savePhoto();
                    pathToImage = UPLOAD_IMAGES_PATH + "/" + pathForSaving;
                    file = new File(ROOT_FILE_PATH + "/" + UPLOAD_IMAGES_PATH + "/" + uuid);
                    checkDir(file);
                    file = new File(file + "/" + fileName);
                    fi.write(file);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //writer.print(pathToImage);
        writer.print(pathToImage);
    }

    private void checkDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}