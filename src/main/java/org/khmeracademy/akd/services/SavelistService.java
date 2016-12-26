package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Savelist;
import org.khmeracademy.akd.model.post.SavelistDetailInput;
import org.khmeracademy.akd.model.post.SavelistInput;
import org.khmeracademy.akd.model.post.SavelistOnlyInput;
import org.khmeracademy.akd.model.put.updateSaveList;
import org.khmeracademy.akd.utilities.Paging;
public interface SavelistService {	
	boolean updateToDisable(int id);
	
	boolean insert(SavelistInput list);
	boolean update(updateSaveList list);
	boolean insertDetail(SavelistDetailInput list);
	boolean insertSavelistOnly(SavelistOnlyInput list);
	boolean deleteSavelistDetail(String docID);
	
	ArrayList<Object> findAll(Paging pagination);
	
	ArrayList<Savelist> findSavelistByUserID(int userID);
	ArrayList<Savelist> findSavelistMenuByUserID(int userID);
	ArrayList<Savelist> findEachSavelistByUserID(int userID,int savelistID);
	
	Savelist findOne(int id);
	boolean deleteSavelist(int id);
	
}
