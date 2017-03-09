package org.khmeracademy.akd.services.impl;

import org.khmeracademy.akd.entities.LogV2;
import org.khmeracademy.akd.repositories.LogRepositoryV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.services.LogServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogServiceV2Impl implements LogServiceV2 {

	@Autowired
	private LogRepositoryV2 dao;
	@Override
	public boolean deleteLog(int userId, String DocId) {
		return dao.delete(userId, DocId);
	}

	@Override
	public boolean deleteLogs(int userId) {
		return dao.deletes(userId);
	}

	@Override
	public ArrayList<LogV2> getLogs(PageForm pageForm) {
		try{
			
			ArrayList<LogV2> arr = dao.getLogV2(pageForm, LogRepositoryV2.SELECT, LogRepositoryV2.FROM);
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public PageForm countLogs(PageForm pageForm) {
		try{
			long totalRecord = dao.countLogV2(pageForm, LogRepositoryV2.FROM);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			return pageForm;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
