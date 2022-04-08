package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.notice.service.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Repository("noticeDao")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper map;
	
	@Override
	public List<NoticeVO> noticeSelectList(int page) {
		return map.noticeSelectList(page);
	}

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		return map.noticeSearchList(key, val);
	}

}
