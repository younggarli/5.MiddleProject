package pcws.dao.totalSearchDao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import pcws.dao.taskDao.TaskDao;
import pcws.dao.taskDao.TaskDaoInf;
import pcws.service.taskService.TaskService;
import pcws.vo.MemberVO;
import pcws.vo.ProjectVO;

public class TotalSearchDao implements TotalSearchDaoInf {
	private static TotalSearchDao dao = new TotalSearchDao();
	private SqlMapClient smc;
	
	public TotalSearchDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static TotalSearchDao getInstance() {
		return dao;
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
