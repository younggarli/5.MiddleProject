package pcws.service.messageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

import pcws.dao.messageDao.MessageDao;
import pcws.vo.MessageVO;

// 서비스를 제공하는 RMI
public class MessageService extends UnicastRemoteObject implements MessageServiceInf {
	private MessageDao messageDao;
	
	public MessageService() throws RemoteException{
		messageDao = MessageDao.getInstance();
	}

	@Override
	public List<MessageVO> getAllmsg(String id) throws RemoteException {
		return messageDao.getAllmsg(id);
	}

	@Override
	public boolean sendMsg(HashMap<String, String> msgMap) throws RemoteException {
		return messageDao.sendMsg(msgMap);
	}

	String dir = "C:\\Temp\\";
	@Override
	public MessageVO setFiles(MessageVO msgFile) throws RemoteException {
		FileOutputStream fout = null;
		MessageVO msgvo = new MessageVO();
		msgvo.setFileData(msgFile.getFileData());
		msgvo.setMsg_filenm(msgFile.getMsg_filenm());
		try {
			fout = new FileOutputStream(dir + msgFile.getMsg_filenm());
			
			fout.write(msgFile.getFileData());
//			System.out.println("filedata" + msgFile.getFileData().length);
			fout.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgvo;
	}

	@Override
	public MessageVO getFile(String fileNm) throws RemoteException {
		FileInputStream fin = null;
		MessageVO msgvo = new MessageVO();
		try {
			File file = new File(dir + fileNm);
			fin = new FileInputStream(file);
			int len = (int)file.length();
			byte[] data = new byte[len];
			
			fin.read(data);
			msgvo.setFileData(data);
			msgvo.setMsg_filenm(fileNm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msgvo;
	}

	@Override
	public boolean insert_notice(String msg_id) throws RemoteException {
		return messageDao.insert_notice(msg_id);
	}

	@Override
	public String getMsgId(HashMap<String, String> msgMap) throws RemoteException {
		return messageDao.getMsgId(msgMap);
	}
	
//	@Override
//	public List<MessageVO> getMessage(String msg_rect) throws RemoteException {
//		return messageDao.getMessage(msg_rect);
//	}
//
//	@Override
//	public boolean create_Message(MessageVO msgVO) throws RemoteException {
//		return messageDao.create_Message(msgVO);
//	}

}
