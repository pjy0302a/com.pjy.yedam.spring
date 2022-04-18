package co.yedam.prj.member.serviceImpl;

import co.yedam.prj.member.service.MemberVO;

public interface MemberMapper {
	MemberVO selectMember(MemberVO vo);
	int insertMember(MemberVO vo);
}
