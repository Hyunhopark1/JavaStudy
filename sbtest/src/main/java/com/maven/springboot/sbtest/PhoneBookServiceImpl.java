package com.maven.springboot.sbtest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {

    private List<IPhoneBook> list = new ArrayList<>();
    private final IPhoneBookRepository<IPhoneBook> phoneBookRepository;

    public PhoneBookServiceImpl(String arg1, String fileName) throws Exception {
        if ("-j".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookJsonRepository(fileName);
        } else if ("-t".equals(arg1)) {
            this.phoneBookRepository = new PhoneBookTextRepository(fileName);
        } else {
            throw new Exception("Error : You need program arguments (-j / -t) (filename) !");
        }
    }


    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public Long getMaxId() {
        Long max = 0L;

        if (!list.isEmpty()) {
            int finishIndex = list.size() - 1;
            Long newmax = list.get(finishIndex).getId();
            return ++newmax;
        }
        return ++max;
    }

    @Override
    public IPhoneBook findById(Long id) {

        int start = 0;
        int finish = list.size() - 1;

        while (start <= finish) {
            int mid = (start + finish) / 2;
            IPhoneBook phoneBook = list.get(mid);

            if (id.equals(phoneBook.getId())) {
                return phoneBook;
            } else if (id < phoneBook.getId()) {
                finish = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }

    private int findIndexById(Long id) {
        int start = 0;
        int finish = list.size() - 1;
        while (start <= finish) {
            int mid = (start + finish) / 2;
            IPhoneBook phoneBook = list.get(mid);

            if (id.equals(phoneBook.getId())) {
                return mid;
            } else if (id < phoneBook.getId()) {
                finish = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(String name, EPhoneGroup group, String phoneNumber, String email) throws Exception {

        if (name == null || name.isEmpty()) {
            throw new Exception("이름이 입력되지 않았습니다.");
        }

        IPhoneBook phoneBook = PhoneBook.builder()
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
    public boolean update(Long id,IPhoneBook beforePhoneBook, IPhoneBook updatePhoneBook) throws Exception {

        int findIndex = this.findIndexById(id);
        if (findIndex < 0) {
            return false;
        }
        if (updatePhoneBook.getName().isEmpty()) {
            updatePhoneBook.setName(beforePhoneBook.getName());
        } if (updatePhoneBook.getGroup()==null) {
            updatePhoneBook.setGroup(beforePhoneBook.getGroup());
        } if (updatePhoneBook.getPhoneNumber().isEmpty()) {
            updatePhoneBook.setPhoneNumber(beforePhoneBook.getPhoneNumber());
        } if (updatePhoneBook.getEmail().isEmpty()) {
            updatePhoneBook.setEmail(beforePhoneBook.getEmail());
        }

        this.list.set(findIndex, updatePhoneBook);
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
        return true;
    }


    @Override
    public List<IPhoneBook> getAllList() {
        return this.list;
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {

        Stream<IPhoneBook> stream = this.list.stream().filter(phoneBook -> phoneBook.getEmail().contains(findEmail));

        return stream.collect(Collectors.toList());


    }

    @Override
    public List<IPhoneBook> getListFromGroup(EPhoneGroup phoneGroup) {

        Stream<IPhoneBook> stream = this.list.stream().filter(phoneBook -> phoneBook.getGroup().equals(phoneGroup));

        return stream.collect(Collectors.toList());
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {

        Stream<IPhoneBook> stream = this.list.stream().filter(phoneBook -> phoneBook.getName().contains(findName));

        return stream.collect(Collectors.toList());
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {

        Stream<IPhoneBook> stream = this.list.stream().filter(phoneBook -> phoneBook.getPhoneNumber().contains(findPhone));

        return stream.collect(Collectors.toList());
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
