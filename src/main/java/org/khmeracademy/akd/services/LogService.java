package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Log;
import org.khmeracademy.akd.model.post.LogInput;
public interface LogService {	
	boolean delete(int id);
	
	boolean insert(LogInput feed);
	
	boolean update(Log feed);
	
	ArrayList<Object> findAll();
	ArrayList<Log> findAllByUser(int userID);
	
	Log findOne(int id);
	boolean deleteAllLogByUserID(int userID);
	
}
