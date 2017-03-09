package org.khmeracademy.akd.services.impl;

import org.khmeracademy.akd.entities.SavelistV2;
import org.khmeracademy.akd.repositories.SavelistRepositoryV2;
import org.khmeracademy.akd.services.SavelistServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SavelistServiceV2Impl implements SavelistServiceV2 {
	
	@Autowired
	private SavelistRepositoryV2 savelistRepository;

	@Override
	public ArrayList<SavelistV2> getSaveList(int userId) {
		try {
			return savelistRepository.findSavelistByUserID(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
