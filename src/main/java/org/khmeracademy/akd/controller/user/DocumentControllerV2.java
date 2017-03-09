package org.khmeracademy.akd.controller.user;

import org.khmeracademy.akd.entities.DocumentSeggestionTitle;
import org.khmeracademy.akd.entities.DocumentV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.response.ResponseCode;
import org.khmeracademy.akd.response.ResponseList;
import org.khmeracademy.akd.response.ResponseObject;
import org.khmeracademy.akd.services.DocumentServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2")
public class DocumentControllerV2 {
	

	@Autowired
	private DocumentServiceV2 documentService;
	
	@RequestMapping(value="/document/{docId}",method=RequestMethod.GET)
	public ResponseObject<DocumentV2> getDocuments(@PathVariable("docId") String docId)
	{
		DocumentV2 doc=documentService.getDocumentV2(docId);
		ResponseObject<DocumentV2> res=new ResponseObject<DocumentV2>();
		
		if(doc != null){
			res.setCode(ResponseCode.RECORD_FOUND);
			res.setMessage();
			res.setData(doc);
			//res.setPaging(pagination);
		}else{
			res.setCode(ResponseCode.RECORD_NOT_FOUND);
			res.setMessage();
		}
		
		return res;
	}
	
	@RequestMapping(value="/document",method=RequestMethod.POST)
	public ResponseList<DocumentV2> getDocuments(@RequestBody PageForm pagination)
	{
		ArrayList<DocumentV2> doc=documentService.getDocumentsV2(pagination);
		
		ResponseList<DocumentV2> res=new ResponseList<DocumentV2>();
		res.setPageForm(pagination);
		
		
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
	
	@RequestMapping(value="/count-document",method=RequestMethod.POST)
	public ResponseObject<PageForm> countDocuments(@RequestBody PageForm pagination)
	{
		//ArrayList<DocumentV2> doc=documentService.getDocumentsV2(pagination);
		pagination = documentService.countDocumentsV2(pagination);
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
	
	@RequestMapping(value="/savelist-document",method=RequestMethod.POST)
	public ResponseList<DocumentV2> getSaveListDocuments(@RequestBody PageForm pagination)
	{
		ArrayList<DocumentV2> doc=documentService.getSaveListDocumentsV2(pagination);
		ResponseList<DocumentV2> res=new ResponseList<DocumentV2>();
		
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
	
	@RequestMapping(value="/count-savelist-document",method=RequestMethod.POST)
	public ResponseObject<PageForm> countSaveListDocuments(@RequestBody PageForm pagination)
	{
		//ArrayList<DocumentV2> doc=documentService.getDocumentsV2(pagination);
		pagination = documentService.countSaveListDocumentsV2(pagination);
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
	
	
	
	@RequestMapping(value="/seggestion-document-name",method=RequestMethod.POST)
	public ResponseObject<DocumentSeggestionTitle> getSeggestionDocumentName(@RequestBody PageForm pagination)
	{
		DocumentSeggestionTitle title = new DocumentSeggestionTitle();
		title.setDocumentTitle(documentService.getSeggestionDocumentNames(pagination));
		title.setPageForm(pagination);
		
		ResponseObject<DocumentSeggestionTitle> res=new ResponseObject<DocumentSeggestionTitle>();
		
		if(title.getDocumentTitle() != null){
			if(title.getDocumentTitle().size()>0){
				res.setCode(ResponseCode.RECORD_FOUND);
				res.setMessage();
				res.setData(title);
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
	
	@RequestMapping(value="/history-document-name",method=RequestMethod.POST)
	public ResponseObject<DocumentSeggestionTitle> getHistoryDocumentName(@RequestBody PageForm pagination)
	{
		DocumentSeggestionTitle title = new DocumentSeggestionTitle();
		title.setDocumentTitle(documentService.getHistoryDocumentNames(pagination));
		title.setPageForm(pagination);
		
		ResponseObject<DocumentSeggestionTitle> res=new ResponseObject<DocumentSeggestionTitle>();
		
		if(title.getDocumentTitle() != null){
			if(title.getDocumentTitle().size()>0){
				res.setCode(ResponseCode.RECORD_FOUND);
				res.setMessage();
				res.setData(title);
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
