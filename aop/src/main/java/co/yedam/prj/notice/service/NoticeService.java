package co.yedam.prj.notice.service;

import java.util.List;

import co.yedam.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(int page);
	List<NoticeVO> noticeSearchList(String key, String val);
}
