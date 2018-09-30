package com.unclewoo.web.action.privilege;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EnumType;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.unclewoo.bean.privilege.Department;
import com.unclewoo.bean.privilege.Employee;
import com.unclewoo.bean.privilege.IDCard;
import com.unclewoo.bean.privilege.PrivilegeGroup;
import com.unclewoo.bean.product.ProductStyle;
import com.unclewoo.bean.user.Gender;
import com.unclewoo.service.privilege.DepartmentService;
import com.unclewoo.service.privilege.EmployeeService;
import com.unclewoo.service.privilege.PrivilegeGroupService;
import com.unclewoo.utils.SiteUrl;
/**
 * 员工管理
 * @author King
 *
 */
public class EmployeeManageAction extends ActionSupport implements ServletRequestAware{
	@Resource DepartmentService departmentService;
	@Resource EmployeeService employeeService;
	@Resource PrivilegeGroupService groupService;
	
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
		
	private String username;
	private String password;
	private String realname;
	private String gender;
	private File picture;
	private String pictureFileName;
	private String cardno;
	private String birthday;
	private String address;
	private String phone;
	private String email;
	private String degree;
	private String school;
	private String departmentid;
	private String[] groupids;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public File getPicture() {
		return picture;
	}
	public void setPicture(File picture) {
		this.picture = picture;
	}
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}
	public String[] getGroupids() {
		return groupids;
	}
	public void setGroupids(String[] groupids) {
		this.groupids = groupids;
	}
	
	/**
	 * 设置员工权限组
	 * @return
	 */
	public String privilegeGroupSet(){
		Employee employee = employeeService.find(username);
		employee.getGroups().clear();
		for(String groupid : groupids){
			employee.addPrivilegeGroup(new PrivilegeGroup(groupid));
		}
		employeeService.update(employee);
		
		request.setAttribute("message", "员工权限组设置成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		return "message";
	}
	
	/**
	 * 员工权限组设置界面
	 * @return
	 */
	public String privilegeGroupSetUI(){
		
		request.setAttribute("groups", groupService.getScrollData().getResultlist());
		request.setAttribute("usergroups", employeeService.find(username).getGroups());
		return "success";
	}
	
	/**
	 * 员工查询界面
	 * @return
	 */
	public String query(){
		request.setAttribute("departments", departmentService.getScrollData().getResultlist());
		return "success";
	}
	
	/**
	 * 员工离职设置
	 * @return
	 */
	public String leave(){
		employeeService.delete((Serializable)username);
		
		request.setAttribute("message", "员工离职设置成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		return "message";
	}
	
	/**
	 * 修改员工信息
	 * @return
	 */
	public String editEmployee(){
		Employee employee = employeeService.find(username);
		employee.setGender(Enum.valueOf(Gender.class, gender));
		employee.setRealname(realname);
		employee.setDegree(degree);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setSchool(school);
		if(departmentid!=null && !"".equals(departmentid.trim()))
			employee.setDepartment(new Department(departmentid.trim()));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday1 = null;
		try {
			birthday1 = format.parse(birthday);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		employee.getIdCard().setCardno(cardno);
		employee.getIdCard().setAddress(address);
		employee.getIdCard().setBirthday(birthday1);
		
		if(picture!=null){
			String ext = pictureFileName.substring(pictureFileName.lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + ext;
			String pathdir ="/images/employee/"+username;//构建文件保存的目录
			String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);//得到图片保存目录的真实路径
			
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();//如果目录不存在就创建
			String path = pathdir + "/" + fileName;
			File savefile = new File(savedir,fileName);
			try {
				FileUtils.copyFile(picture, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			employee.setImageName(fileName);
			
			System.out.println(path);
			System.out.println(realpathdir+"/"+fileName);
		}
			
		employeeService.save(employee);
		
		request.setAttribute("message", "员工修改成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		
		return "message";
	}
	
	/**
	 * 用户信息修改界面
	 * @return
	 */
	public String editEmployeeUI(){
		Employee employee = employeeService.find(username);
		
		request.setAttribute("realname", employee.getRealname());
		//request.setAttribute("gender", "");
		request.setAttribute("imagePath", employee.getImagePath());
		request.setAttribute("cardno", employee.getIdCard().getCardno());
		request.setAttribute("birthday", employee.getIdCard().getBirthday().toString());
		request.setAttribute("address", employee.getIdCard().getAddress());
		request.setAttribute("phone", employee.getPhone());
		request.setAttribute("email", employee.getEmail());
		request.setAttribute("degree", employee.getDegree());
		request.setAttribute("school", employee.getSchool());
		
		if(employee.getDepartment()!=null)
			request.setAttribute("selectdepartmentid", employee.getDepartment().getDepartmentid());
		request.setAttribute("departments", departmentService.getScrollData().getResultlist());
		return "success";
	}
	
	/**
	 * 检验用户是否存在
	 * @return
	 */
	public String exist(){
		if(employeeService.exist(username.trim())){
			request.setAttribute("message", "用户名已经存在");
		}else{
			request.setAttribute("message", "用户名可以使用");
		}
		return "message";
	}
	
	
	/**
	 * 员工添加界面
	 * @return
	 */
	public String regEmployeeUI(){
		request.setAttribute("departments", departmentService.getScrollData().getResultlist());
		return "success";
	}
	/**
	 * 添加员工
	 * @return
	 */
	public String regEmployee(){
		Employee employee = new Employee();
		employee.setUsername(username.trim());
		employee.setPassword(password.trim());
		employee.setGender(Enum.valueOf(Gender.class, gender));
		employee.setRealname(realname);
		employee.setDegree(degree);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setSchool(school);
		if(departmentid!=null && !"".equals(departmentid.trim()))
			employee.setDepartment(new Department(departmentid.trim()));
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday1 = null;
		try {
			birthday1 = format.parse(birthday);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		employee.setIdCard(new IDCard(cardno, address, birthday1));
		if(picture!=null){
			String ext = pictureFileName.substring(pictureFileName.lastIndexOf("."));
			String fileName = UUID.randomUUID().toString() + ext;
			String pathdir ="/images/employee/"+username;//构建文件保存的目录
			String realpathdir = ServletActionContext.getServletContext().getRealPath(pathdir);//得到图片保存目录的真实路径
			
			File savedir = new File(realpathdir);
			if(!savedir.getParentFile().exists())
				savedir.mkdirs();//如果目录不存在就创建
			String path = pathdir + "/" + fileName;
			File savefile = new File(savedir,fileName);
			try {
				FileUtils.copyFile(picture, savefile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			employee.setImageName(fileName);
			
			System.out.println(path);
			System.out.println(realpathdir+"/"+fileName);
		}
			
		employeeService.save(employee);
				
		request.setAttribute("message", "员工添加成功");
		request.setAttribute("urladdress", SiteUrl.readUrl("control.employee.list"));
		
		return "message";
	}
}
