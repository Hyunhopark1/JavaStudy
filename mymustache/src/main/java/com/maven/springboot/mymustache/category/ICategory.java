package com.maven.springboot.mymustache.category;

// 메소드 프로토타입만 선언하고 실행하는 몸체는 없는 인터페이스, 일반화, 추상화, 다형성, 객체지향의중심
public interface ICategory {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    // 인터페이스 안에 몸체가 있는 메소드이며, 마치 static 처럼 new 하지 않고 사용 된다.
    //그러나 호출할 때 클래스명.메소드명() 으로 선언하면 안되고
    //객체명.copyFields() 이렇게 사용한다. 객체간에 형변환할 때 사용
    default void copyFields(ICategory from){
        if (from == null) {
            return;
        }
        if (from.getId() != null) {
            this.setId(from.getId());
        }
        if (from.getName() != null && !from.getName().isEmpty()) {
            this.setName(from.getName());
        }
    }
}
