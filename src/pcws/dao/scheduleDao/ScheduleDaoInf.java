package pcws.dao.scheduleDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import pcws.vo.ScheduleVO;

public interface ScheduleDaoInf extends Remote {

	/**
	 * 선택한 날짜와 메모내용을 저장
	 * @param svo 사용자id, 날짜, 메모내용
	 * @return 성공적으로 저장하면 true, 실패하면 false
	 * @throws RemoteException
	 */
	public boolean memoSave(ScheduleVO svo) throws RemoteException;
	
	/**
	 * 선택한 날짜와 메모내용을 삭제
	 * @param svo 사용자id, 날짜, 메모내용
	 * @return 성공적으로 삭제하면 true, 실패하면 false
	 * @throws RemoteException
	 */
	public boolean memoDelete(ScheduleVO svo) throws RemoteException;
	
	/**
	 * 사용자가 선택한 날짜의 메모내용 출력
	 * @param memoMap 사용자id와 메모내용을 가진 Map
	 * @return 메모내용
	 * @throws RemoteException
	 */
	public String showMemo(HashMap<String, String> memoMap) throws RemoteException;
}
