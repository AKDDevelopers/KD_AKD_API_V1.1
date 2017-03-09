package org.khmeracademy.akd.services;

import org.khmeracademy.akd.entities.LogV2;
import org.khmeracademy.akd.repositories.provider.PageForm;

import java.util.ArrayList;

public interface LogServiceV2 {

	public boolean deleteLog(int userId, String DocId);
	public boolean deleteLogs(int userId);
	public ArrayList<LogV2> getLogs(PageForm pageForm);
	public PageForm countLogs(PageForm pageForm);
}
