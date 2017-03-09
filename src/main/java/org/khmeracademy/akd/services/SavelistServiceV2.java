package org.khmeracademy.akd.services;

import org.khmeracademy.akd.entities.SavelistV2;

import java.util.ArrayList;

public interface SavelistServiceV2 {
	ArrayList<SavelistV2> getSaveList(int userId);
	
}
