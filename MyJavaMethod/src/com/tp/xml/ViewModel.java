package com.tp.xml;


/**
 * 
 * view 模板
 * @author tp
 *
 */
public class ViewModel {
	
	private String id;
	private String typeName ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "ViewModel [id=" + id + ", typeName=" + typeName + "]";
	}
	
	
	
	
}
