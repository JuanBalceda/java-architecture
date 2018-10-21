package com.balceda.archj.ws.interfaces;

import java.util.List;

import javax.jws.WebService;

@WebService
public interface GenericWebService<T> {
	public List<T> selectAll();
}
