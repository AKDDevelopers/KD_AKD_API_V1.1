package org.khmeracademy.akd.services.impl;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.model.post.CommentInput;
import org.khmeracademy.akd.model.put.updateComment;
import org.khmeracademy.akd.repositories.CommentRepository;
import org.khmeracademy.akd.services.CommentService;
import org.khmeracademy.akd.utilities.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	@Override
	public boolean delete(int id) {
		try{
			return commentRepository.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(CommentInput com) {
		
		return commentRepository.insert(com);
		
	}

	@Override
	public boolean update(updateComment com) {
		return commentRepository.update(com);
	}

	@Override
	public ArrayList findAll(Paging pagination) {
		pagination.setTotalCount(commentRepository.count());
		return commentRepository.findAll(pagination);
	}

	@Override
	public Comment findOne(int id) {
		return commentRepository.findOne(id);
	}
	
	@Override
	public ArrayList getAllCommentByDocID(String DocID) {
		return commentRepository.getAllCommentByDocID(DocID);
	}

	@Override
	public ArrayList<Comment> getPageCommentByDocID(String DocID, int limit, int offset) {
		// TODO Auto-generated method stub
		return commentRepository.getPageCommentByDocID(DocID, limit, offset);
	}


}
