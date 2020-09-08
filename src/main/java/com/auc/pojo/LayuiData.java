package com.auc.pojo;



import java.util.List;

/**
 * layui表格的实体类
 */

public class LayuiData<T>
{
	private Integer currPage;
	private Integer prePage;
	private Integer nextPage;
	private Integer totalPage;
	private Integer totalRecords;
	private Integer pageSize;
	//返回码 0成功
	private int code;
	//返回提示信息 可以省略
	private String msg = "";
	//数据总数
	private int count;
	//当前页数据
	private List<T> data;

	public LayuiData() {
	}
	public LayuiData(Integer curpage, Integer totalrecords, Integer pagesize){
		this.currPage = curpage;
		this.totalRecords = totalrecords;
		this.pageSize = pagesize;
		this.totalPage = totalrecords%pagesize==0?totalrecords/pagesize:totalrecords/pagesize+1;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
