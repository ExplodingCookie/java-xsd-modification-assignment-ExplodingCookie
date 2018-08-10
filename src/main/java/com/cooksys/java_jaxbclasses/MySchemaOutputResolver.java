package com.cooksys.java_jaxbclasses;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class MySchemaOutputResolver extends SchemaOutputResolver {
	private String fileName;
	
	public MySchemaOutputResolver (String fileName) {
		this.setFileName(fileName);
	}
	
	@Override
	public Result createOutput (String pathname, String suggestedFileName) throws IOException {
		return new StreamResult(new File(suggestedFileName).getAbsolutePath());
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
