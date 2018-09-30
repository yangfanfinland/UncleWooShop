package com.unclewoo.service.uploadfile;

import java.util.List;

import com.unclewoo.service.base.DAO;

public interface UploadFileService extends DAO{
	/**
	 * 获取文件路径
	 * @param ids
	 * @return
	 */
	public List<String> getFilepath(Integer[] ids);
}
