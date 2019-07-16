package com.bridjit.learning.learning.sof.q1;

import java.util.List;

public class DataEntry {
	private final String name;
	private final List<String> data;

	public String getName() {
		return name;
	}

	public List<String> getData() {
		return data;
	}

	DataEntry(String name, List<String> data) {
		this.name = name;
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataEntry [name=" + name + ", data=" + data + "]";
	}
	
	
}
