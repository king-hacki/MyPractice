package com.test.demo;


public class PetStoreServiceImpl {

    private JpaAccountDao accountDao;

    private JpaItemDao itemDao;

    static final PetStoreServiceImpl pet = new PetStoreServiceImpl();

    private PetStoreServiceImpl() {}

    public static PetStoreServiceImpl createInstance() {
        return pet;
    }

    public void setAccountDao(JpaAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(JpaItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public String toString() {
        return "PetStoreServiceImpl"    ;
    }
}
