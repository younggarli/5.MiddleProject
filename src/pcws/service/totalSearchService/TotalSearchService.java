package pcws.service.totalSearchService;

import java.util.List;

import pcws.dao.totalSearchDao.TotalSearchDao;
import pcws.dao.totalSearchDao.TotalSearchDaoInf;
import pcws.vo.MemberVO;
import pcws.vo.ProjectVO;

public class TotalSearchService implements TotalSearchServiceInf {
	private static TotalSearchService service = new TotalSearchService();
	private TotalSearchDaoInf dao;
	
	public TotalSearchService() {
		dao = TotalSearchDao.getInstance();
	}
	
	public static TotalSearchService getInstance() {
		return service;
	}
	@Override
	public List<MemberVO> memberSearch(String mem_id) {
		return dao.memberSearch(mem_id);
	}

	@Override
	public List<ProjectVO> projectSearch(String prj_id) {
		return dao.projectSearch(prj_id);
	}

}
