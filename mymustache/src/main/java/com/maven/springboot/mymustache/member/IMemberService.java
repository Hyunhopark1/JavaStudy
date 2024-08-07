package com.maven.springboot.mymustache.member;

import com.maven.springboot.mymustache.ICommonService;
import com.maven.springboot.mymustache.SearchAjaxDto;
import com.maven.springboot.mymustache.security.dto.LoginRequest;
import com.maven.springboot.mymustache.security.dto.SignUpRequest;

import java.util.List;

public interface IMemberService extends ICommonService<MemberDto> {
    IMember login(LoginRequest dto);
    IMember addMember(SignUpRequest dto);
    IMember findByLoginId(String loginId);
    List<IMember> findAllByLoginIdContains(SearchAjaxDto dto);
    int countAllByLoginIdContains(SearchAjaxDto dto);
}
