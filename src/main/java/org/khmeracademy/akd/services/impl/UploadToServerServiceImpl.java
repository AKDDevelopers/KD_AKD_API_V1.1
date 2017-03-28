package org.khmeracademy.akd.services.impl;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.khmeracademy.akd.services.UploadToDBService;
import org.khmeracademy.akd.services.UploadToServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class UploadToServerServiceImpl implements UploadToServerService{
	
	@Autowired
	private UploadToDBService uploadToDBService;

	@Value("${akd.api.url}")
	private String AKD_API_URL;

	@Override
	public String uploadDocument(MultipartFile files, String folder) throws IOException {
		String filePath = null;
		if(files==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
//			folder = "D:/KSHRD/ALL KHMER DOCS/AKD File";
			folder = "/Data/PROJECTS/FILES_MANAGEMENT/ALL_KHMER_DOCS/UPLOAD";
		// I change to this path right or not ?? RIGHT HOW HOUY TA
	//	String UPLOAD_PATH = "file" + folder;
		String UPLOAD_PATH =folder;

		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		System.out.print("PATH =>"+path);

		String fileName = files.getOriginalFilename();
        byte[] bytes = files.getBytes();
		fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("File Type: "+fileName.substring(fileName.lastIndexOf('.')+1,fileName.length() ));
		
		//fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.print("FULL PATH=> "+UPLOAD_PATH+fileName);
		try{
			long fileSize = files.getSize();
			System.out.print("FILE SIZE=> "+fileSize);
		}catch (Exception e){

		}

		try {


			//Files.copy(files.getInputStream(),Paths.get(UPLOAD_PATH,fileName, String.valueOf(REPLACE_EXISTING)));
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File(UPLOAD_PATH + File.separator + fileName)));
            stream.write(bytes);
            stream.close();
//			Files.copy(files.getInputStream(),Paths.get(UPLOAD_PATH,fileName),)
			filePath = UPLOAD_PATH + "/" + fileName;
			System.out.println("MY FILE PATH=>"+filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		filePath = UPLOAD_PATH + "/" + fileName;


		System.out.println("FILE PATH AFTER UPLOAD TO SERVER ==> " + filePath);
		return filePath;
	}

	@Override
	public String uploadUserProfile(MultipartFile files, String folder) {
		String filePath = null;
		if(files==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
		//	folder = "src/main/webapp/resources/img/user-profile";
			folder = "/Data/PROJECTS/FILES_MANAGEMENT/ALL_KHMER_DOCS/USER-PROFILE/";
		
	//	String UPLOAD_PATH = "file" + folder;
		String UPLOAD_PATH =folder;
		
		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		String fileName = files.getOriginalFilename();
		fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("Original Name: "+fileName);
		System.out.println("File Type: "+fileName.substring(fileName.lastIndexOf('.')+1,fileName.length() ));
		
		//fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		

		try {
			Files.copy(files.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
			filePath = UPLOAD_PATH + fileName;
			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.print("FILE PATH=> "+filePath);
		return AKD_API_URL+"/assets/upload/"+fileName;//
	}

	@Override
	public String uploadDocThumbnail(MultipartFile files, String folder) {
		String filePath = null;
		if(files==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
			folder = "src/main/webapp/resources/img/doc-thumbnail";
		
	//	String UPLOAD_PATH = "file" + folder;
		String UPLOAD_PATH =folder;
		
		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		String fileName = files.getOriginalFilename();
		fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("Original Name: "+fileName);
		System.out.println("File Type: "+fileName.substring(fileName.lastIndexOf('.')+1,fileName.length() ));
		
		//fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		
		
		try {
			Files.copy(files.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
			filePath = UPLOAD_PATH + "/" + fileName;
			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return filePath;
	}

	@Override
	public String uploadCateThumbnail(MultipartFile files, String folder) {
		String filePath = null;
		if(files==null){
			System.out.println("file empty");
			return null;
		}
		if(folder=="" || folder==null)
			folder = "src/main/webapp/resources/img/maincate-thumbnail";
		
	//	String UPLOAD_PATH = "file" + folder;
		String UPLOAD_PATH =folder;
		
		java.io.File path = new java.io.File(UPLOAD_PATH);
		if(!path.exists())
			path.mkdirs();
		
		String fileName = files.getOriginalFilename();
		fileName = UUID.randomUUID().toString() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		System.out.println("Original Name: "+fileName);
		System.out.println("File Type: "+fileName.substring(fileName.lastIndexOf('.')+1,fileName.length() ));
		
		//fileName = fileName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
		
		
		try {
			Files.copy(files.getInputStream(), Paths.get(UPLOAD_PATH, fileName));
			filePath = UPLOAD_PATH + "/" + fileName;
			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return filePath;

		
	}	

}



