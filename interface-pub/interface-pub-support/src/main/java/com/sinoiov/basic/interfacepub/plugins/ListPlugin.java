package com.sinoiov.basic.interfacepub.plugins;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("plugins")
public class ListPlugin extends ArrayList<IPlugin> {

	private static final long serialVersionUID = 2677027668874227058L;

}
