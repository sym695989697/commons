package com.ctfo.mongodb.persist;

import java.io.File;

import com.ctfo.mongodb.entity.ImageSizeEntity;
import com.ctfo.mongodb.exception.YyzcMongoException;
import com.mongodb.gridfs.GridFSDBFile;

public interface ICtfoMongoFileService {
	
	public static final String IMAGE_MAX = "max_";
	
	public static final String IMAGE_MID = "mid_";
	
	public static final String IMAGE_MIN = "min_";

	public String uploadFile(String url) throws YyzcMongoException;

	public String uploadFile(File file) throws YyzcMongoException;
	
	public String uploadFile(String url, String fileName) throws YyzcMongoException;

	public String uploadFile(File file, String fileName) throws YyzcMongoException;

	public String uploadFile(File file, ImageSizeEntity size, String fileName) throws YyzcMongoException;

	public String uploadFile(String url, ImageSizeEntity size, String fileName) throws YyzcMongoException;
	
	public void removeFile(String fileName) throws YyzcMongoException;
	
	public GridFSDBFile getFile(String fileName) throws YyzcMongoException;
	
	public String getFileURL(String fileName) throws YyzcMongoException;
	
	public String getFileURL(String fileName, String IMAGE_MODE) throws YyzcMongoException;
	
}
