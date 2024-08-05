package com.maven.springboot.mymustache.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService<ICategory> {
    @Autowired  // SpringBoot �� CategoryMybatisMapper ������������ ��ü�� �ڵ� �����Ѵ�.
    private CategoryMybatisMapper categoryMybatisMapper;

    @Override
    public ICategory findById(Long id) {
        if ( id == null || id <= 0 ) {
            return null;
        }
        CategoryDto find = this.categoryMybatisMapper.findById(id);
        // CategoryMybatisMapper �� ���� XML ������ <select id="findById" ������ ������ ����� ���� �޴´�.
        return find;
    }

    @Override
    public ICategory findByName(String name) {
        if ( name == null || name.isEmpty() ) {
            return null;
        }
        CategoryDto find = this.categoryMybatisMapper.findByName(name);
        // CategoryMybatisMapper �� ���� XML ������ <select id="findByName" ������ ������ ����� ���� �޴´�.
        return find;
    }

    @Override
    public List<ICategory> getAllList() {
        List<ICategory> list = this.getICategoryList(
                this.categoryMybatisMapper.findAll()
                // CategoryMybatisMapper �� ���� XML ������ <select id="findAll" ������ ������ ����� ���� �޴´�.
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
        // stream Java 1.8 ������ ��� : �迭/Collection �ڷ����� ó���Ҷ�
        // stream �� ����Ͽ� ó�� �ӵ��� �����ϰ� ������ �����ϰ� �����.
        // �迭��ü/�÷����ڷ���.stream() ~~~~ ����, ����ȯ, ���Ҹ��� �Ȱ��� ������ ó���Ѵ�.

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
        // CategoryMybatisMapper �� ���� XML ������ <insert id="insert" ������ �����Ѵ�.
        // dto.id �� �ڵ������� id ���� ���ϵȴ�.
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
        // CategoryMybatisMapper �� ���� XML ������ <delete id="deleteById" ������ �����Ѵ�.
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
        // CategoryMybatisMapper �� ���� XML ������ <update id="update" ������ �����Ѵ�.
        return find;
    }

    @Override
    public List<ICategory> findAllByNameContains(SearchCategoryDto dto) {
        if ( dto == null ) {
            //return List.of();
            return new ArrayList<>();
        }
        dto.setOrderByWord( (dto.getSortColumn() != null ? dto.getSortColumn() : "id")
                + " " + (dto.getSortAscDsc() != null ? dto.getSortAscDsc() : "DESC") );
        // SQL select ������ ORDER BY ������ ����� �ִ� ����
        if ( dto.getRowsOnePage() == null ) {
            // �� �������� �����ִ� ���� ����
            dto.setRowsOnePage(10);
        }
        List<ICategory> list = this.getICategoryList(
                this.categoryMybatisMapper.findAllByNameContains(dto)
                // CategoryMybatisMapper �� ���� XML ������ <select id="findAllByNameContains" ������ ������ ����� �����Ѵ�.
        );
        return list;
    }

    @Override
    public int countAllByNameContains(SearchCategoryDto searchCategoryDto) {
        return this.categoryMybatisMapper.countAllByNameContains(searchCategoryDto);
        // CategoryMybatisMapper �� ���� XML ������ <select id="categoryMybatisMapper" ������ ������ ����� �����Ѵ�.
    }
}
