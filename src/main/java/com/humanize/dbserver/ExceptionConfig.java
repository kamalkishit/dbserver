package com.humanize.dbserver;

public class ExceptionConfig {
	
	public static final int USER_CREATION_ERROR_CODE = 10001;
	public static final int USER_UPDATION_ERROR_CODE = 10002;
	public static final int USER_NOT_FOUND_ERROR_CODE = 10003;
	public static final int USER_DELETION_ERROR_CODE = 10004;
	
	public static final int PAPER_CREATION_ERROR_CODE = 10005;
	public static final int PAPER_UPDATION_ERROR_CODE = 10006;
	public static final int PAPER_NOT_FOUND_ERROR_CODE = 10007;
	public static final int PAPER_DELETION_ERROR_CODE = 10008;
	
	public static final String USER_CREATION_EXCEPTION = "User not created successfully";
	public static final String USER_UPDATION_EXCEPTION = "User not updated successfully";
	public static final String USER_NOT_FOUND_EXCEPTION = "User not found";
	public static final String USER_DELETION_EXCEPTION = "User not deleted successfully";
	
	public static final String PAPER_CREATION_EXCEPTION = "Paper not created successfully";
	public static final String PAPER_UPDATION_EXCEPTION = "Paper not updated successfully";
	public static final String PAPER_NOT_FOUND_EXCEPTION = "Paper not found";
	public static final String PAPER_DELETION_EXCEPTION = "Paper not deleted successfully";

}
