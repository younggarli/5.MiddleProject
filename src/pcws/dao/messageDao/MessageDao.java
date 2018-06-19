package pcws.dao.messageDao;

import java.io.IOException;
import java.io.Reader;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.vo.MessageVO;

public class MessageDao implements MessageDaoInf {
	private static MessageDao messageDao = new MessageDao();
	private SqlMapClient smc;
	
	private MessageDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static MessageDao getInstance() {
		return messageDao;
	}
	
	@Override
	public List<MessageVO> getAllmsg(String id) throws RemoteException {
		List<MessageVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("message.showMsg", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public boolean sendMsg(HashMap<String, String> msgMap) throws RemoteException {
		boolean result = false;
		try {
			smc.insert("message.sendMsg", msgMap);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public boolean insert_notice(String msg_id) throws RemoteException {
		boolean result = false;
		try {
			Object obj = smc.insert("notice.insertMessage", msg_id);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String getMsgId(HashMap<String, String> msgMap) throws RemoteException {
		String msgID = "";
		try {
			msgID = (String)smc.queryForObject("message.getID", msgMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msgID;
	}
	
	
//	@Override
//	public List<MessageVO> getMessage(String msg_rect) throws RemoteException {
//		List<MessageVO> message = null;
//		try {
//			message = smc.queryForList("message.getMessage", msg_rect);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return message;
//	}
//
//	@Override
//	public boolean create_Message(MessageVO msgVO) throws RemoteException {
//		boolean result = false;
//		try {
//			Object obj = smc.insert("message.create_Message", msgVO);
//			if(obj != null) {
//				result = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}


}
