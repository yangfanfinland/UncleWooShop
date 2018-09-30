package com.unclewoo.web.action.uploadfile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.unclewoo.bean.PageView;
import com.unclewoo.bean.uploadfile.UploadFile;
import com.unclewoo.service.uploadfile.UploadFileService;
import com.unclewoo.web.modeldriven.uploadfile.UploadfileModelDriven;

public class UploadFileAction extends ActionSupport implements ModelDriven<UploadfileModelDriven>{

	UploadfileModelDriven uploadfileModelDriven = new UploadfileModelDriven();
	
	public UploadfileModelDriven getModel() {
		return uploadfileModelDriven;
	}
	
	@Resource(name="uploadFileServiceBean")
	private UploadFileService uploadFileService;
	
	public String execute() throws Exception {
		
		
		PageView<UploadFile> pageView = new PageView<UploadFile>(12, uploadfileModelDriven.getPage());
		int firstindex = (uploadfileModelDriven.getPage()-1)*pageView.getMaxresult();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("id", "desc");
		pageView.setQueryResult(uploadFileService.getScrollData(UploadFile.class, firstindex, pageView.getMaxresult(), orderby));
		ActionContext actionContext = ActionContext.getContext();
		Map<String,Object> request = (Map) actionContext.get("request"); 
		request.put("pageView", pageView);
		return "success";
	}

	
	
}
