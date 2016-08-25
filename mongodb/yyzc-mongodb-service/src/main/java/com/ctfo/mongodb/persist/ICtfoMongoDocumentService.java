package com.ctfo.mongodb.persist;

import java.util.Collection;
import java.util.List;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.ctfo.mongodb.exception.YyzcMongoException;

public interface ICtfoMongoDocumentService<T extends Object> {
	
	public void insert(T entity) throws YyzcMongoException;
	
	public void insertBatch(Class<T> clazz, Collection<T> it) throws YyzcMongoException;
	
	public T get(Class<T> clazz, Object id) throws YyzcMongoException;
	
	public void delete(Class<T> clazz, Object id) throws YyzcMongoException;
	
	public void update(Class<T> clazz, Object id, UpdateOperations<T> update) throws YyzcMongoException;
	
	public List<T> query(Class<T> clazz, Query query, int skip, int limit) throws YyzcMongoException;

}
