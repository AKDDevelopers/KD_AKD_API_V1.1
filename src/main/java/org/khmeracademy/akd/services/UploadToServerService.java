package org.khmeracademy.akd.services;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadToServerService {
	public String uploadDocument(MultipartFile files, String folder) throws IOException;
	public String uploadUserProfile(MultipartFile files, String folder);
	public String uploadDocThumbnail(MultipartFile files, String folder);
	public String uploadCateThumbnail(MultipartFile files, String folder);
	
}
