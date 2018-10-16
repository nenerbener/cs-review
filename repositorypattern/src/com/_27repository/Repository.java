package com._27repository;

public interface Repository<T>
{
    void add(T obj);
    void remove(T obj);

    String getAll();
}
