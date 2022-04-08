package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(int page);
	List<NoticeVO> noticeSearchList(String key, String val);
}
