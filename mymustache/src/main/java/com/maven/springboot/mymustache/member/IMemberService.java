package com.maven.springboot.mymustache.member;

import com.maven.springboot.mymustache.SearchAjaxDto;
import com.maven.springboot.mymustache.security.dto.SignUpRequest;

import java.util.List;

public interface IMemberService {
    IMember findById(Long id);
    IMember insert(IMember dto) throws Exception;
    Boolean delete(Long id) throws Exception;
    IMember update(Long id, IMember dto) throws Exception;
    IMember addMember(SignUpRequest dto);
    IMember findByLoginId(String loginId);
    List<IMember> findAllByLoginIdContains(SearchAjaxDto dto);
    int countAllByLoginIdContains(SearchAjaxDto searchMemberDto);
}
