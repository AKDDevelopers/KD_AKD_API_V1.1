package org.khmeracademy.akd.controller.socket.io;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.khmeracademy.akd.entities.Comment;
import org.khmeracademy.akd.model.post.CommentInput;
import org.khmeracademy.akd.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;



@Component
public class CommentSocketController {
	
	private SocketIONamespace nspComment;
	
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	public CommentSocketController(SocketIOServer server) {
		
		System.out.println("=>Constructing CommentSocketController...");
		
		//TODO: creating /feed name space
		this.nspComment = server.addNamespace("/comment");
		
		System.out.println("=>Initializing event listener...");
		
		//TODO: onConnect event listener
		this.nspComment.addConnectListener(onConnect);
		
		//TODO: onDisconnect event listener
		this.nspComment.addDisconnectListener(onDisconnect);
		
		//TODO: onCustom event listener "add new comment"
		this.nspComment.addEventListener("new comment", CommentInput.class, onComment);
		
		//TODO: listening on "remove comment" event
				this.nspComment.addEventListener("remove comment", Integer.class, onRemoveComment);
	}
	
	private ConnectListener onConnect = new ConnectListener() {
		@Override
		public void onConnect(SocketIOClient client) {
			System.out.println("Connected to /comment namespace : " + client.getSessionId());
			
			List<Comment> comments = commentService.getAllCommentByDocID("0B3xn0pv8IJtzalJkVzkxWUNfUEk");
			if(!comments.isEmpty()){
				System.out.println("Sending!!!");
				System.out.println("Comment: " + comments);
				
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						nspComment.getClient(client.getSessionId()).sendEvent("all comments", comments);
					}
				}, 1000);
			}
			
			System.out.println("onConnect - getTransport: "+ client.getTransport());
		}
	};
	
	private DisconnectListener onDisconnect = new DisconnectListener() {
		@Override
		public void onDisconnect(SocketIOClient client) {
			System.out.println("Disonnected to /comment namespace : " + client.getSessionId());
		}
	};
	
	private DataListener<CommentInput> onComment = new DataListener<CommentInput>() {
		@Override
		public void onData(SocketIOClient client, CommentInput comment, AckRequest ackSender) throws Exception {
			
			//TODO: save to database
			if(commentService.insert(comment)){
				
				//TODO: broadcast "new post" to all connected client
				nspComment.getBroadcastOperations().sendEvent("new comment", comment);
				
				//TODO: response back to sender
				ackSender.sendAckData("Status Posted!");
			}
			
			System.out.println("Comment /comment : " + comment);
			System.out.println("onComment - getTransport: "+ client.getTransport());
		}
	};
	
	//TODO: remove comment handler
	private DataListener<Integer> onRemoveComment = new DataListener<Integer>() {
		@Override
		public void onData(SocketIOClient client, Integer id, AckRequest ackSender) throws Exception {
			if(commentService.delete(id)){
				//send to all connected client
				nspComment.getBroadcastOperations().sendEvent("removed comment", id);
			}
		}
	};
	
	
	
//	private DataListener<String> onJoinRoom = new DataListener<String>() {
//		@Override
//		public void onData(SocketIOClient client, String room, AckRequest ackSender) throws Exception {
//			System.out.println("Client joining room: " + room);
//			client.joinRoom(room);
//			client.getNamespace().getRoomOperations(room).sendEvent("joined", "somebody joined room!");
//			ackSender.sendAckData("Joined!");
//		}
//	};
	
//	private DataListener<String> onSendMessageToRoom = new DataListener<String>() {
//		@Override
//		public void onData(SocketIOClient client, String message, AckRequest ackSender) throws Exception {
//			System.out.println("Sending message to [Android Room]...");
//			client.getNamespace().getRoomOperations("Android Room").sendEvent("room-message", message);
//			ackSender.sendAckData("Sent!");
//		}
//	};
	
//	private DataListener<String> onLeaveRoom = new DataListener<String>() {
//		@Override
//		public void onData(SocketIOClient client, String room, AckRequest ackSender) throws Exception {
//			System.out.println("Leaving [Android Room]...");
//			client.leaveRoom(room);
//			client.getNamespace().getRoomOperations(room).sendEvent("left", "somebody left room!");
//			ackSender.sendAckData("Left!");
//		}
//	};
	
//	private DataListener<byte[]> onBinaryHandler = new DataListener<byte[]>() {
//		@Override
//		public void onData(SocketIOClient client, byte[] data, AckRequest ackSender) throws Exception {
//			System.out.println("binary data: " + data);
//			
//			/*FileOutputStream fos = new FileOutputStream("test.html");
//			fos.write(data);
//			fos.close();*/
//			
//			/*BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("test.png")));
//			bos.write(data);
//			bos.close();*/
//		}
//			
//	};
	
//	private DataListener<UploadFile> onBinaryObjectHandler = new DataListener<UploadFile>() {
//		@Override
//		public void onData(SocketIOClient client, UploadFile uploadFile, AckRequest ackSender) throws Exception {
//			System.out.println("binary data: " + uploadFile);
//			nspFeed.getBroadcastOperations().sendEvent("test", uploadFile.getFile());
//		}
//			
//	};
	
//	@PostConstruct
//	public void init(){
//		
//		System.out.println("=>Initializing event listener...");
//		
//		//TODO: onConnect event listener
//		this.nspComment.addConnectListener(onConnect);
//		
//		//TODO: onDisconnect event listener
//		this.nspComment.addDisconnectListener(onDisconnect);
//		
//		//TODO: onCustom event listener
//		this.nspComment.addEventListener("comment", CommentInput.class, onComment);
//
//	}
}
