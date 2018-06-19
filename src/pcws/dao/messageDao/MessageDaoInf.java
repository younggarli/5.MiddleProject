package pcws.dao.messageDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import pcws.vo.MessageVO;
/**
 * 사용자가 메시지를 생성하여 다른 사용자에게 발송할 수 있도록 해주는 인터페이스 기능
 * @author UmSoHyun
 * @since 2018-04-04
 */
public interface MessageDaoInf {

	/**
	 * Message 테이블에서 수신자 id로  List를 가져오기 위한 메서드
	 * @param msg_rect
	 * @return Message List
	 * @throws RemoteException
	 */
//	public List<MessageVO> getMessage(String msg_rect) throws RemoteException;
	
	/**
	 * Message 테이블에 발신자 id로 새로운 데이터를 저장하기 위한 메서드
	 * @param msg_wt
	 * @return DB에 작업이 성공하면 true, 실패하면 false를 반환
	 * @throws RemoteException
	 */
//	public boolean create_Message(MessageVO msgVO) throws RemoteException;
	
	/**
	 * 쪽지함
	 * @param id 사용자 아이디
	 * @return 쪽지정보 리스트
	 * @throws RemoteException
	 */
	public List<MessageVO> getAllmsg(String id) throws RemoteException;
	
	/**
	 * 쪽지 보내기
	 * @param 쪽지번호, 작성자o, 내용o, 수신자o, 보낸날짜o
	 * @return 성공적으로 보내면 true, 그렇지 않으면 false
	 * @throws RemoteException
	 */
	public boolean sendMsg(HashMap<String, String> msgMap) throws RemoteException;
	
	public String getMsgId(HashMap<String, String> msgMap) throws RemoteException;
	
	/**
	 * 메세지 생성시 알람 생성
	 * @param msg_id
	 * @return 생성 성공시 true, 실패시 false
	 * @throws RemoteException
	 */
	public boolean insert_notice(String msg_id) throws RemoteException;
}
