package com.ctfo.mongodb.persist.impl;

import java.util.Collection;
import java.util.List;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.ctfo.mongodb.exception.YyzcMongoException;
import com.ctfo.mongodb.persist.ICtfoMongoDocumentService;

public class CtfoMongoDocumentServiceSpringImpl<T extends Object> implements ICtfoMongoDocumentService<T> {

	public void insert(T entity) throws YyzcMongoException {
		// TODO Auto-generated method stub
		
	}

	public void insertBatch(Class<T> clazz, Collection<T> it)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		
	}

	public T get(Class<T> clazz, Object id) throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Class<T> clazz, Object id) throws YyzcMongoException {
		// TODO Auto-generated method stub
		
	}

	public void update(Class<T> clazz, Object id, UpdateOperations<T> update)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		
	}

	public List<T> query(Class<T> clazz, Query query, int skip, int limit)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
