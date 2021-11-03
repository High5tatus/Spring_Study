package com.mycom.myapp06;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

	@GetMapping("uploadForm")
	public void uploadForm() {	}
	
	@PostMapping("fileAction")
	public String upload(MultipartFile[] uploads, Model model, HttpSession session) {
		String uploadFolder = session.getServletContext().getRealPath("/");
		uploadFolder+="resources\\img\\";
		System.out.println("uploadFolder : " + uploadFolder);
		ArrayList<String> mfiles = new ArrayList<String>();
		ArrayList<String> imgfiles = new ArrayList<String>();
		for(MultipartFile multipartFile : uploads) {
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString()+"_" + multipartFile.getOriginalFilename();
			try {
				//multipartFile.transferTo(new File(uploadFolder, uploadFileName));
				FileCopyUtils.copy(multipartFile.getBytes(), new File(uploadFolder,uploadFileName));
				mfiles.add(multipartFile.getOriginalFilename());
				imgfiles.add(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}//for
		model.addAttribute("uploadFileName", mfiles);	
		model.addAttribute("imgUpload",imgfiles);
		return "fileResult";
	}
}
