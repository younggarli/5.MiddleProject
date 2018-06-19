package pcws.dao.projectDao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

import pcws.vo.MemberVO;
import pcws.vo.ProjectVO;
import pcws.vo.ScheduleVO;

public interface ProjectDaoInf extends Remote{
	/**
	 * 프로젝트 생성(PL) - 로그인 정보를 들고감, 만든이가 PL
	 * @param id, pvo
	 * @return 프로젝트 정보
	 * @throws RemoteException
	 */
	public ProjectVO project_Create(ProjectVO proMap) throws RemoteException;
	
	/**
	 * 프로젝트 삭제(PL)
	 * @param pj_id 프로젝트 아이디
	 * @return false이면 삭제성공, false이면 실패
	 * @throws RemoteException
	 */
	public boolean project_Drop(String pj_id) throws RemoteException;
	
	/**
	 * 유저 아이디로 프로젝트 리스트를 가져옴
	 * @param mem_id
	 * @return 유저의 프로젝트 리스트
	 * @throws RemoteException
	 */
	public List<ProjectVO> chkProjectCount(String mem_id) throws RemoteException;

	/**
	 * 프로젝트 내용을 수정
	 * @param pvo
	 * @return 업데이트 성공시 true, 실패시 false
	 * @throws RemoteException
	 */
	public boolean project_update(ProjectVO pvo) throws RemoteException;
	
	/**
	 * 프로젝트 삭제
	 * @param pvo
	 * @return 삭제 성공시 true, 실패시 false
	 * @throws RemoteException
	 */
	public boolean project_delete(ProjectVO pvo) throws RemoteException;
	
	/**
	 * 프로젝트 생성 시 알람 생성
	 * @param pj_id
	 * @return 생성 성공시 true, 실패시 false
	 * @throws RemoteException
	 */
	public boolean insert_notice(String pj_id) throws RemoteException;
	
	/**
	 * 멤버가 가장 나중에 생성한 프로젝트
	 * @param mem
	 * @return 프로젝트
	 * @throws RemoteException
	 */
	public ProjectVO getProject(MemberVO mem) throws RemoteException;
	
	/**
	 * 모든 프로젝트 리스트 가져오기
	 * @return 모든 프로젝트 리스트
	 * @throws RemoteException
	 */
	public List<ProjectVO> getAllPro() throws RemoteException;
	
	/**
	 * 프로젝트명으로 프로젝트 검색하기
	 * @param proNm 프로젝트 이름
	 * @return 리스트
	 * @throws RemoteException
	 */
	public List<ProjectVO> selectPro(String proNm) throws RemoteException;
	
}
