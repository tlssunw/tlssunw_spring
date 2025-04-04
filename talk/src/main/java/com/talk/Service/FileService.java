package com.talk.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import groovy.util.logging.Log;

@Service
@Log
public class FileService {
	@Value("${filePath}")
	private String filePath;
	
	public String uploadFile(MultipartFile multipartFile) throws IOException {
		//하나를 업로드하는
		String originalName = multipartFile.getOriginalFilename(); //원본 이름
		String fileName="";
		String fileUrl="";
		fileName = fileSave(originalName, multipartFile.getBytes());
		fileUrl = "/files/"+fileName; // 웹(html)에서 사용할 파일 경로
		
		return fileUrl; //fileUrl을 DB에 저장
	}
	public List<String> uploadFile(List<MultipartFile> multipartFiles) throws IOException {
		// 여러개를 업로드하는
		List<String> fileUrls = new ArrayList<>();
		
		for(MultipartFile multipartFile : multipartFiles) {
			String fileurl = uploadFile(multipartFile);
			fileUrls.add(fileurl);
		}
		return fileUrls;
	}
	
	private String fileSave(String originalName, byte[] fileData ) throws IOException { //진짜 업로드 해주는 메서드
		UUID uuid = UUID.randomUUID(); //이름 중복을 방지하기 위한 랜덤 문자열 생성
		// 업로드 하는 파일의 확장자 추출하기 -> .jpg .png .hwp
		String ext = originalName.substring(originalName.lastIndexOf("."));
		// 실제 업로드 해서 저장될 이름
		String saveName = uuid.toString() + ext;
		String fileUploadUrl = filePath+"/"+saveName;
		
		//진짜 파일 업로드 실행
		FileOutputStream fos = new FileOutputStream(fileUploadUrl);
		fos.write(fileData);
		fos.close();
		
		return saveName;
	}
	
	
}
