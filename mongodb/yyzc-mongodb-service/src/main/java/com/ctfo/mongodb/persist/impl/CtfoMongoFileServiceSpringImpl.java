package com.ctfo.mongodb.persist.impl;

import java.io.File;

import com.ctfo.mongodb.entity.ImageSizeEntity;
import com.ctfo.mongodb.exception.YyzcMongoException;
import com.ctfo.mongodb.persist.ICtfoMongoFileService;
import com.mongodb.gridfs.GridFSDBFile;

public class CtfoMongoFileServiceSpringImpl implements ICtfoMongoFileService {

	public String uploadFile(String url) throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadFile(File file) throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadFile(String url, String fileName)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadFile(File file, String fileName)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadFile(File file, ImageSizeEntity size, String fileName)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String uploadFile(String url, ImageSizeEntity size, String fileName)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeFile(String fileName) throws YyzcMongoException {
		// TODO Auto-generated method stub
		
	}

	public GridFSDBFile getFile(String fileName) throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFileURL(String fileName) throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFileURL(String fileName, String IMAGE_MODE)
			throws YyzcMongoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
