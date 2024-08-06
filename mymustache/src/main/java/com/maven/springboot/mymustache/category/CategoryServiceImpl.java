package com.maven.springboot.mymustache.category;

import com.maven.springboot.mymustache.SearchAjaxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService<ICategory> {
    @Autowired  // SpringBoot 가 CategoryMybatisMapper 데이터형으로 객체를 자동 생성한다.
    private CategoryMybatisMapper categoryMybatisMapper;

    @Override
    public ICategory findById(Long id) {
        if ( id == null || id <= 0 ) {
            return null;
        }
        CategoryDto find = this.categoryMybatisMapper.findById(id);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <select id="findById" 臾몄옣�쓣 �떎�뻾�븳 寃곌낵瑜� 由ы꽩 諛쏅뒗�떎.
        return find;
    }

    @Override
    public ICategory findByName(String name) {
        if ( name == null || name.isEmpty() ) {
            return null;
        }
        CategoryDto find = this.categoryMybatisMapper.findByName(name);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <select id="findByName" 臾몄옣�쓣 �떎�뻾�븳 寃곌낵瑜� 由ы꽩 諛쏅뒗�떎.
        return find;
    }

    @Override
    public List<ICategory> getAllList() {
        List<ICategory> list = this.getICategoryList(
                this.categoryMybatisMapper.findAll()
                // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <select id="findAll" 臾몄옣�쓣 �떎�뻾�븳 寃곌낵瑜� 由ы꽩 諛쏅뒗�떎.
        );
        return list;
    }

    private List<ICategory> getICategoryList(List<CategoryDto> list) {
        if ( list == null || list.size() <= 0 ) {
            return new ArrayList<>();
        }
        // input : [CategoryDto|CategoryDto|CategoryDto|CategoryDto|CategoryDto]
//        List<ICategory> result = new ArrayList<>();
//        for( CategoryDto entity : list ) {
//            result.add( (ICategory)entity );
//        }
        // output : [ICategory|ICategory|ICategory|ICategory|ICategory]
        List<ICategory> result = list.stream()
                .map(entity -> (ICategory)entity)
                .toList();
        // stream Java 1.8 �벑�옣�븳 諛⑸쾿 : 諛곗뿴/Collection �옄猷뚰삎�쓣 泥섎━�븷�븣
        // stream �쓣 �궗�슜�븯�뿬 泥섎━ �냽�룄�룄 利앷���븯怨� 臾몃쾿�룄 媛꾧껐�븯寃� 留뚮뱺�떎.
        // 諛곗뿴媛앹껜/而щ젆�뀡�옄猷뚰삎.stream() ~~~~ �젙�젹, �삎蹂��솚, �썝�냼留덈떎 �삊媛숈�� �룞�옉�쓣 泥섎━�븳�떎.

        return result;
    }

    @Override
    public ICategory insert(ICategory category) throws Exception {
        if ( !isValidInsert(category) ) {
            return null;
        }
        CategoryDto dto = new CategoryDto();
        dto.copyFields(category);
        dto.setId(0L);
        this.categoryMybatisMapper.insert(dto);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <insert id="insert" 臾몄옣�쓣 �떎�뻾�븳�떎.
        // dto.id �뒗 �옄�룞利앷���맂 id 媛믪씠 由ы꽩�맂�떎.
        return dto;
    }

    private boolean isValidInsert(ICategory category) {
        if ( category == null ) {
            return false;
        } else if ( category.getName() == null || category.getName().isEmpty() ) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(Long id) throws Exception {
        ICategory find = this.findById(id);
        if ( find == null ) {
            return false;
        }
        this.categoryMybatisMapper.deleteById(id);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <delete id="deleteById" 臾몄옣�쓣 �떎�뻾�븳�떎.
        return true;
    }

    @Override
    public ICategory update(Long id, ICategory category) throws Exception {
        ICategory find = this.findById(id);
        if ( find == null ) {
            return null;
        }
        find.copyFields(category);
        this.categoryMybatisMapper.update((CategoryDto) find);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <update id="update" 臾몄옣�쓣 �떎�뻾�븳�떎.
        return find;
    }

    @Override
    public List<ICategory> findAllByNameContains(SearchAjaxDto dto) {
        if ( dto == null ) {
            //return List.of();
            return new ArrayList<>();
        }
        dto.setOrderByWord( (dto.getSortColumn() != null ? dto.getSortColumn() : "id")
                + " " + (dto.getSortAscDsc() != null ? dto.getSortAscDsc() : "DESC") );
        // SQL select 臾몄옣�쓽 ORDER BY 援щЦ�쓣 留뚮뱾�뼱 二쇰뒗 �뿭�븷
        if ( dto.getRowsOnePage() == null ) {
            // �븳 �럹�씠吏��떦 蹂댁뿬二쇰뒗 �뻾�쓽 媛��닔
            dto.setRowsOnePage(10);
        }
        List<ICategory> list = this.getICategoryList(
                this.categoryMybatisMapper.findAllByNameContains(dto)
                // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <select id="findAllByNameContains" 臾몄옣�쓣 �떎�뻾�븳 寃곌낵瑜� 由ы꽩�븳�떎.
        );
        return list;
    }

    @Override
    public int countAllByNameContains(SearchAjaxDto searchAjaxDto) {
        return this.categoryMybatisMapper.countAllByNameContains(searchAjaxDto);
        // CategoryMybatisMapper �쓽 荑쇰━ XML �뙆�씪�쓽 <select id="categoryMybatisMapper" 臾몄옣�쓣 �떎�뻾�븳 寃곌낵瑜� 由ы꽩�븳�떎.
    }
}
