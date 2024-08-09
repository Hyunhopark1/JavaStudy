package com.softagape.mustacheajax.board;

import com.softagape.mustacheajax.commons.dto.CUDInfoDto;
import com.softagape.mustacheajax.commons.dto.SearchAjaxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {
    @Autowired
    private IBoardMybatisMapper boardMybatisMapper;

    @Override
    public void insert(CUDInfoDto info, IBoard dto) {
        if (dto == null) {
            return;
        }
        BoardDto insert = BoardDto.builder()
                .viewQty(0).likeQty(0)
                .build();
        insert.copyFields(dto);
        info.setCreateInfo(insert);
        this.boardMybatisMapper.insert(insert);
    }

    @Override
    public void update(CUDInfoDto info, IBoard dto) {
        if ( dto == null || dto.getId() == null || dto.getId() <= 0 ) {
            return;
        }
        BoardDto find = this.boardMybatisMapper.findById(dto.getId());
        if (find == null) {
            return;
        }
        if ( !find.getCreateId().equals(info.getLoginUser().getLoginId()) ) {
            return;
        }
        find.copyFields(dto);
        info.setUpdateInfo(find);
        this.boardMybatisMapper.update(find);
    }

    @Override
    public void deleteFlag(CUDInfoDto info, IBoard dto) {
        if (dto == null) {
            return;
        }
        BoardDto find = this.boardMybatisMapper.findById(dto.getId());
        if (find == null) {
            return;
        }
        if ( !find.getCreateId().equals(info.getLoginUser().getLoginId()) ) {
            return;
        }
        info.setDeleteInfo(find);
        this.boardMybatisMapper.deleteFlag(find);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0 ) {
            return;
        }
        BoardDto find = this.boardMybatisMapper.findById(id);
        if (find == null) {
            return;
        }
        this.boardMybatisMapper.deleteById(id);
    }

    @Override
    public IBoard findById(Long id) {
        if (id == null || id <= 0 ) {
            return null;
        }
        BoardDto find = this.boardMybatisMapper.findById(id);
        return find;
    }

    @Override
    public int countByCreateId(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return 0;
        }
        int count = this.boardMybatisMapper.countByCreateId(searchDto);
        return count;
    }

    @Override
    public List<IBoard> findPagesByCreateId(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return List.of();
        }
        searchDto.setOrderByWord( (searchDto.getSortColumn() != null ? searchDto.getSortColumn() : "id")
                + " " + (searchDto.getSortAscDsc() != null ? searchDto.getSortAscDsc() : "DESC") );
        if ( searchDto.getRowsOnePage() == null ) {
            searchDto.setRowsOnePage(10);
        }
        List<IBoard> list = this.getIterfaceList(
                this.boardMybatisMapper.findPagesByCreateId(searchDto)
        );
        return list;
    }

    @Override
    public int countByNameContains(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return 0;
        }
        int count = this.boardMybatisMapper.countByNameContains(searchDto);
        return count;
    }

    @Override
    public List<IBoard> findPagesByNameContains(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return List.of();
        }
        searchDto.setOrderByWord( (searchDto.getSortColumn() != null ? searchDto.getSortColumn() : "id")
                + " " + (searchDto.getSortAscDsc() != null ? searchDto.getSortAscDsc() : "DESC") );
        if ( searchDto.getRowsOnePage() == null ) {
            searchDto.setRowsOnePage(10);
        }
        List<IBoard> list = this.getIterfaceList(
                this.boardMybatisMapper.findPagesByNameContains(searchDto)
        );
        return list;
    }

    @Override
    public int countByContentContains(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return 0;
        }
        int count = this.boardMybatisMapper.countByContentContains(searchDto);
        return count;
    }

    @Override
    public List<IBoard> findPagesByContentContains(SearchAjaxDto searchDto) {
        if (searchDto == null) {
            return List.of();
        }
        searchDto.setOrderByWord( (searchDto.getSortColumn() != null ? searchDto.getSortColumn() : "id")
                + " " + (searchDto.getSortAscDsc() != null ? searchDto.getSortAscDsc() : "DESC") );
        if ( searchDto.getRowsOnePage() == null ) {
            searchDto.setRowsOnePage(10);
        }
        List<IBoard> list = this.getIterfaceList(
                this.boardMybatisMapper.findPagesByContentContains(searchDto)
        );
        return list;
    }

    private List<IBoard> getIterfaceList(List<BoardDto> list) {
        if ( list == null || list.size() <= 0 ) {
            return List.of();
        }
        List<IBoard> result = list.stream()
                .map(entity -> (IBoard)entity)
                .toList();
        return result;
    }
}
