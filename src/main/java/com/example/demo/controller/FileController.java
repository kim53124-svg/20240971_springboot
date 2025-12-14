package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadFolder;

    @PostMapping("/upload-email")
    public String uploadEmail(@RequestParam("email") String email,
                              @RequestParam("subject") String subject,
                              @RequestParam("message") String message,
                              RedirectAttributes redirectAttributes) {


        String fileName = subject.replaceAll("[^a-zA-Z0-9.-]", "_") + ".txt";
        String fileContent = "Email: " + email + "\n" +
                             "Subject: " + subject + "\n" +
                             "Message:\n" + message;

        File uploadDir = new File(uploadFolder);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File fileToSave = new File(uploadFolder, fileName);

        try (FileWriter writer = new FileWriter(fileToSave)) {
            writer.write(fileContent);
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "File upload failed: " + e.getMessage());
            return "redirect:/"; 
        }

        return "upload_end";
    }
}