package com.maven.springboot.mymustache.member;


import com.maven.springboot.mymustache.commons.dto.SearchAjaxDto;
import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;
import com.maven.springboot.mymustache.security.dto.LoginRequest;


import java.util.List;

public interface IMemberService extends IServiceCRUD<IMember> {
    IMember login(LoginRequest loginRequest);
    Boolean changePassword(IMember dto) throws Exception;
    IMember findByLoginId(String loginId);
    IMember findByNickname(String nickname);
    Integer countAllByNameContains(SearchAjaxDto dto);
    List<IMember> findAllByNameContains(SearchAjaxDto dto);
}
