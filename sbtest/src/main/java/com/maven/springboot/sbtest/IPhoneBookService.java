package com.maven.springboot.sbtest;

import java.util.List;

public interface IPhoneBookService<T> {
    int size();
    void clear();
    Long getMaxId();
    T findById(Long id);
    List<T> getAllList();
    boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception;
    boolean insert(T phoneBook) throws Exception;
    boolean remove(Long id) throws Exception;
    boolean update(Long id,T PhoneBook, T phoneBook) throws Exception;
    List<T> getListFromName(String findName);
    List<T> getListFromGroup(EPhoneGroup phoneGroup);
    List<T> getListFromPhoneNumber(String findPhone);
    List<T> getListFromEmail(String findEmail);
    boolean loadData() throws Exception;
    boolean saveData() throws Exception;

}
