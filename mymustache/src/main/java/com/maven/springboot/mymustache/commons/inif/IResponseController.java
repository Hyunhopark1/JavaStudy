package com.maven.springboot.mymustache.commons.inif;


import com.maven.springboot.mymustache.commons.dto.CUDInfoDto;
import com.maven.springboot.mymustache.commons.dto.IBase;
import com.maven.springboot.mymustache.commons.dto.ResponseCode;
import com.maven.springboot.mymustache.commons.dto.ResponseDto;
import com.maven.springboot.mymustache.commons.exception.LoginAccessException;
import com.maven.springboot.mymustache.member.IMember;
import com.maven.springboot.mymustache.member.MemberRole;
import com.maven.springboot.mymustache.security.config.SecurityConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface IResponseController {
    default CUDInfoDto makeResponseCheckLogin(Model model) {
        IMember loginUser = (IMember) model.getAttribute(SecurityConfig.LOGINUSER);
        if (loginUser == null) {
            throw new LoginAccessException("로그인 필요");
        }
        return new CUDInfoDto(loginUser);
    }

    default CUDInfoDto makeResponseCheckLoginAdmin(Model model) {
        IMember loginUser = (IMember) model.getAttribute(SecurityConfig.LOGINUSER);
        if (loginUser == null) {
            throw new LoginAccessException("로그인 필요");
        } else if (!loginUser.getRole().equals(MemberRole.ADMIN.toString())) {
            throw new LoginAccessException("관리자만 가능");
        }
        return new CUDInfoDto(loginUser);
    }

    default CUDInfoDto makeResponseCheckSelfOrAdmin(Model model, IBase checkObject) {
        IMember loginUser = (IMember) model.getAttribute(SecurityConfig.LOGINUSER);
        if (loginUser == null) {
            throw new LoginAccessException("로그인 필요");
        } else if (!loginUser.getRole().equals(MemberRole.ADMIN.toString()) && !loginUser.getId().equals(checkObject.getCreateId())) {
            throw new LoginAccessException("관리자와 본인만 가능");
        }
        return new CUDInfoDto(loginUser);
    }

    default ResponseEntity<ResponseDto> makeResponseEntity(HttpStatus httpStatus
            , ResponseCode responseCode
            , String message
            , Object responseData) {
        ResponseDto dto = ResponseDto.builder()
                .responseCode(responseCode)
                .message(message)
                .responseData(responseData)
                .build();
        return ResponseEntity.status(httpStatus).body(dto);
    }
}
