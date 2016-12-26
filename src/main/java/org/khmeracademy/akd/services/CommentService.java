package org.khmeracademy.akd.services;

import java.util.ArrayList;
import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.model.post.CommentInput;
import org.khmeracademy.akd.model.put.updateComment;
import org.khmeracademy.akd.utilities.Paging;
public interface CommentService {	
	boolean delete(int id);
	
	boolean insert(CommentInput com);
	
	boolean update(updateComment com);
	
	ArrayList<Object> findAll(Paging pagination);
	
	Comment findOne(int id);
	
	ArrayList<Comment> getAllCommentByDocID(String DocID);
	
}
