package com.maven.springboot.mymustache.member;

import com.maven.springboot.mymustache.SearchAjaxDto;
import com.maven.springboot.mymustache.security.dto.LoginRequest;
import com.maven.springboot.mymustache.security.dto.SignUpRequest;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMybatisMapper memberMybatisMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public MemberDto findById(Long id) {
        MemberDto find = this.memberMybatisMapper.findById(id);
        return find;
    }
    @Override
    public IMember insert(IMember dto) throws Exception {
        return null;
    }

    @Override
    public IMember login(LoginRequest dto) {
        IMember find = this.memberMybatisMapper.findByLoginId(dto.getLoginId());
        if ( encoder.matches(dto.getPassword(), find.getPassword()) ) {
            return find;
        }
        return null;
    }

    @Override
    public IMember addMember(SignUpRequest dto) {
        MemberDto insert = MemberDto.builder().build();
        insert.copyFields(dto);
        insert.setPassword(encoder.encode(dto.getPassword()));
        insert.setRole(MemberRole.USER.toString());
        this.memberMybatisMapper.insert(insert);
        return dto;
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        this.memberMybatisMapper.delete(id);
        return true;
    }

    @Override
    public IMember update(Long id, IMember dto) throws Exception {
        dto.setId(id);
        MemberDto member = MemberDto.builder().build();
        member.copyFields(dto);
        this.memberMybatisMapper.update(member);
        return null;
    }

    @Override
    public IMember findByLoginId(String loginId) {
        IMember find = this.memberMybatisMapper.findByLoginId(loginId);
        return find;
    }

    @Override
    public List<IMember> findAllByLoginIdContains(SearchAjaxDto dto) {
        List<IMember> list = this.memberMybatisMapper.findAllByLoginIdContains(dto);
        return list;
    }

    @Override
    public int countAllByLoginIdContains(SearchAjaxDto dto) {
        int count = this.memberMybatisMapper.countAllByLoginIdContains(dto);
        return 0;
    }
}
