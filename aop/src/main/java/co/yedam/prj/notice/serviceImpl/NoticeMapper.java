package co.yedam.prj.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(int page);
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
}
