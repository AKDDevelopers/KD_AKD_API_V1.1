package org.khmeracademy.akd.controller.user;

import org.khmeracademy.akd.entities.LogV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.response.Response;
import org.khmeracademy.akd.response.ResponseCode;
import org.khmeracademy.akd.response.ResponseList;
import org.khmeracademy.akd.response.ResponseObject;
import org.khmeracademy.akd.services.LogServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2")
public class LogControllerV2 {
	
	@Autowired
	private LogServiceV2 service;
	
	@RequestMapping(value="/log/{user_id}/{doc_id}",method=RequestMethod.DELETE)
	public Response delete(@PathVariable("user_id") int user_id, @PathVariable("doc_id") String doc_id)
	{
	
		boolean status=service.deleteLog(user_id, doc_id);
		Response res=new Response();
		if(status){
			res.setCode(ResponseCode.DELETE_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.DELETE_FAIL);
			res.setMessage();
		}
		return res;
	}
	
	@RequestMapping(value="/log/{user_id}",method=RequestMethod.DELETE)
	public Response deletes(@PathVariable("user_id") int user_id)
	{
	
		boolean status=service.deleteLogs(user_id);
		Response res=new Response();
		if(status){
			res.setCode(ResponseCode.DELETE_SUCCESS);
			res.setMessage();
		}
		else{
			res.setCode(ResponseCode.DELETE_FAIL);
			res.setMessage();
		}
		return res;
	}
	
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ResponseList<LogV2> getDocuments(@RequestBody PageForm pagination)
	{
		ArrayList<LogV2> doc=service.getLogs(pagination);
		ResponseList<LogV2> res=new ResponseList<LogV2>();
		
		if(doc != null){
			if(doc.size()>0){
				res.setCode(ResponseCode.RECORD_FOUND);
				res.setMessage();
				res.setData(doc);
				//res.setPaging(pagination);
			}
			else{
				res.setCode(ResponseCode.RECORD_NOT_FOUND);
				res.setMessage();
			}
		}else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/count-log",method=RequestMethod.POST)
	public ResponseObject<PageForm> countLog(@RequestBody PageForm pagination)
	{
		//ArrayList<DocumentV2> doc=documentService.getDocumentsV2(pagination);
		pagination = service.countLogs(pagination);
		ResponseObject<PageForm> res=new ResponseObject<PageForm>();
		
		if(pagination != null){
			if(pagination.getTotalRecord() > 0){
				res.setCode(ResponseCode.RECORD_FOUND);
				res.setMessage();
				res.setData(pagination);
				//res.setPaging(pagination);
			}
			else{
				res.setCode(ResponseCode.RECORD_NOT_FOUND);
				res.setMessage();
			}
		}else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}

}
