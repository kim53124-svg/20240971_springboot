package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileController {

    @Value("${spring.servlet.multipart.location}")
    private String uploadFolder;

    @PostMapping("/upload-email")
    public String uploadEmail(
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            RedirectAttributes redirectAttributes) {

        try {
            Path uploadPath = Paths.get(uploadFolder).toAbsolutePath();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String sanitizedEmail = email.replaceAll("[^a-zA-Z0-9.-]", "_");
            Path filePath = uploadPath.resolve(sanitizedEmail + ".txt");
            System.out.println("File Path: " + filePath);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                writer.write("메일 제목: " + subject);
                writer.newLine();
                writer.write("요청 메시지");
                writer.newLine();
                writer.write(message);
            }

            redirectAttributes.addFlashAttribute("message", "메일 내용이 성공적으로 업로드되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "업로드 중 오류가 발생했습니다.");
                return "/error_page/article_error";
            }
            



        // String fileName = subject.replaceAll("[^a-zA-Z0-9.-]", "_") + ".txt";
        // String fileContent = "Email: " + email + "\n" +
        //                      "Subject: " + subject + "\n" +
        //                      "Message:\n" + message;

        // File uploadDir = new File(uploadFolder);
        // if (!uploadDir.exists()) {
        //     uploadDir.mkdirs();
        // }

        // File fileToSave = new File(uploadFolder, fileName);

        // try (FileWriter writer = new FileWriter(fileToSave)) {
        //     writer.write(fileContent);
        //     redirectAttributes.addFlashAttribute("message", "File uploaded successfully: " + fileName);
        // } catch (IOException e) {
        //     e.printStackTrace();
        //     redirectAttributes.addFlashAttribute("error", "File upload failed: " + e.getMessage());
        //     return "redirect:/"; 
        // }

        return "upload_end";
    }
}