package org.khmeracademy.akd.controller.user;

import org.khmeracademy.akd.entities.SavelistV2;
import org.khmeracademy.akd.response.ResponseCode;
import org.khmeracademy.akd.response.ResponseObject;
import org.khmeracademy.akd.services.SavelistServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2")
public class SavelistControllerV2 {
	@Autowired
	private SavelistServiceV2 savelistService;
	
	@RequestMapping(value="/getuserSavelist/{userID}",method=RequestMethod.GET)
	public ResponseObject<SavelistV2> findSavelistByUserID (@PathVariable("userID") int userID)
	{
		ArrayList<SavelistV2> list=savelistService.getSaveList(userID);
		ResponseObject<SavelistV2> res=new ResponseObject<SavelistV2>();
		if(list!=null){
			if(list.size() > 0){
				res.setCode(ResponseCode.RECORD_FOUND);
				res.setMessage();
				res.setData(list);
			}else{
				res.setCode(ResponseCode.RECORD_NOT_FOUND);
				res.setMessage();
			}
		}
		else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
}
