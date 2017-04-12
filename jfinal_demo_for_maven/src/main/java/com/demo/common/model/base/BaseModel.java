package com.demo.common.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;


@SuppressWarnings("serial")
public abstract class BaseModel<M extends Model<M>> extends Model<M> implements IBean{
	public Page<M> paginate(int pageNumber, int pageSize , String select, String sqlExceptSelect) {
		return paginate(pageNumber, pageSize, select, sqlExceptSelect);
	}
}	
