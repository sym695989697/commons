package com.sinoiov.yyzc.commons.mongodb.supports;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;

import com.sinoiov.yyzc.commons.mongodb.beans.PoiBean;
import com.sinoiov.yyzc.commons.mongodb.exceptions.ErrorCodes;
import com.sinoiov.yyzc.commons.mongodb.exceptions.YyzcMongoException;

public class DocumentSupport<T> extends MongoSupport {

	private Class<T> clazz;
	private String datasourceName;
	private String dbName;

	private DocumentSupport(Class<T> clazz, String datasourceName) {
		this.clazz = clazz;
		this.datasourceName = datasourceName;
	}

	public DocumentSupport<T> getInstance(Class<T> clazz) {
		return getInstance(clazz, getDefaultDatasource());
	}

	public DocumentSupport<T> getInstance(Class<T> clazz, String datasourceName) {
		return new DocumentSupport<T>(clazz, datasourceName);
	}

	public void insert(T entity) {
		Datastore ds = new Morphia().createDatastore(
				mongoClients.get(datasourceName), dbName);
		ds.save(entity);
	}

	public T get(Object id) {
		if (clazz == null)
			throw new YyzcMongoException(ErrorCodes.ERROR_CLASS_NULL,
					"Class is necessary, but it's null now.");
		Datastore ds = new Morphia().createDatastore(
				mongoClients.get(datasourceName), dbName);
		return ds.getByKey(clazz, new Key<T>(clazz, id));
	}

	public static void main(String[] args) {
		DocumentSupport<PoiBean> ds = new DocumentSupport<PoiBean>(null, null);
		ds.insert(null);
	}
}
