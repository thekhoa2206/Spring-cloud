package com.sapo.coffeeshop.models.repository;

public interface CustomizedSave<T> {
    <S extends T> S save(S entity) throws Exception;
}
class CustomizedSaveImpl<T> implements CustomizedSave<T> {

    public <S extends T> S save(S entity) throws Exception {
        if(entity == null){
            System.out.println("null ở đây");;
        }
        return entity;
    }
}