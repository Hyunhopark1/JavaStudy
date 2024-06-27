package com.maven.springboot.sbtest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook>{

    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ("-j".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ("-t".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        }else{
            throw new Exception("Error : You need program arguments (-j / -t) (filename) !");
        }
    }



    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Long getMaxId() {
        Long max=0L;

        for (IPhoneBook list : list) {
            if (max < list.getId()) {
                max=list.getId();
            }
        }
        return ++max;
    }

    @Override
    public IPhoneBook findById(Long id) {

        for (IPhoneBook list : list) {
            if (id.equals(list.getId())) {
                return list;
            }
        }
        return null;
    }
    private int findIndexById(Long id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {

        String phoneNumberPattern = "\\d{3}-\\d{4}-\\d{4}";

        if (!Pattern.matches(phoneNumberPattern, phoneNumber)) {
            System.out.println("000-0000-0000 형식으로 입력");
            return false;
        }

        IPhoneBook phoneBook =PhoneBook.builder()
                .id(this.getMaxId())
                .name(name)
                .group(group)
                .phoneNumber(phoneNumber)
                .email(email).build();

        list.add(phoneBook);
        return true;
    }

    @Override
    public boolean insert(IPhoneBook phoneBook) throws Exception {
        list.add(phoneBook);
        return true;
    }
    @Override
    public boolean update(Long id, IPhoneBook phoneBook) throws Exception {

        int index = this.findIndexById(id);
        if (index < 0) {
            return false;
        }
        phoneBook.setId(id);
        this.list.set(index, phoneBook);
        return true;
    }

    @Override
    public boolean remove(Long id) throws Exception {
        IPhoneBook phoneBook = findById(id);
        if (phoneBook == null) {
            System.out.println("입력하신 id에 해당하는 연락처가 없습니다");
            return false;
        }

        list.remove(phoneBook);
        reassignId();
        return true;
    }

    // 연락처가 삭제될 때 ID값을 다시 할당
    private void reassignId() {
        long id = 1L;
        for (IPhoneBook phoneBook : list) {
            phoneBook.setId(id++);
        }
    }


    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getEmail().contains(findEmail)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneGroup.equals(phoneBook.getGroup())) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getName().contains(findName)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        List<IPhoneBook> findArr = new ArrayList<>();
        for ( IPhoneBook phoneBook : this.list ) {
            if (phoneBook.getPhoneNumber().contains(findPhone)) {
                findArr.add(phoneBook);
            }
        }
        return findArr;
    }

    @Override
    public boolean loadData() throws Exception {
        return phoneBookRepository.loadData(list);
    }
    @Override
    public boolean saveData() throws Exception {
        return phoneBookRepository.saveData(list);
    }


}
