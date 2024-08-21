package com.maven.springboot.mymustache.sbfile;


import com.maven.springboot.mymustache.board.BoardDto;
import com.maven.springboot.mymustache.board.IBoard;
import com.maven.springboot.mymustache.commons.inif.IServiceCRUD;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISbFileService extends IServiceCRUD<ISbFile> {
    List<ISbFile> findAllByTblBoardId(ISbFile search);
    Boolean insertFiles(IBoard boardDto, List<MultipartFile> files);
    Boolean updateFiles(List<SbFileDto> sbFileDtoList);
    byte[] getBytesFromFile(ISbFile down);
}
