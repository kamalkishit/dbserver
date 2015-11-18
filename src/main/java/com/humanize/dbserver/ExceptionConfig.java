package com.humanize.dbserver;

public class ExceptionConfig {
	
	public static final int USER_CREATION_ERROR_CODE = 10001;
	public static final int USER_UPDATION_ERROR_CODE = 10002;
	public static final int USER_NOT_FOUND_ERROR_CODE = 10003;
	public static final int USER_DELETION_ERROR_CODE = 10004;
	
	public static final int NULL_PAPER_ERROR_CODE = 10005;
	public static final int NULL_PAPER_DATE_ERROR_CODE = 10005;
	public static final int PAPER_CREATION_ERROR_CODE = 10005;
	public static final int PAPER_UPDATION_ERROR_CODE = 10006;
	public static final int PAPER_NOT_FOUND_ERROR_CODE = 10007;
	public static final int PAPER_DELETION_ERROR_CODE = 10008;
	
	public static final int NULL_CONTENT_ERROR_CODE = 10011;
	public static final int CONTENT_CREATION_ERROR_CODE = 10012;
	public static final int CONTENT_UPDATION_ERROR_CODE = 10013;
	public static final int CONTENT_NOT_FOUND_ERROR_CODE = 10014;
	public static final int CONTENT_DELETION_ERROR_CODE = 10015;
	
	public static final String USER_CREATION_EXCEPTION = "User not created successfully";
	public static final String USER_UPDATION_EXCEPTION = "User not updated successfully";
	public static final String USER_NOT_FOUND_EXCEPTION = "User not found";
	public static final String USER_DELETION_EXCEPTION = "User not deleted successfully";
	
	public static final String NULL_PAPER_EXCEPTION = "Paper is null";
	public static final String NULL_PAPER_DATE_EXCEPTION = "Paper date is null";
	public static final String PAPER_CREATION_EXCEPTION = "Paper not created successfully";
	public static final String PAPER_UPDATION_EXCEPTION = "Paper not updated successfully";
	public static final String PAPER_NOT_FOUND_EXCEPTION = "Paper not found";
	public static final String PAPER_DELETION_EXCEPTION = "Paper not deleted successfully";
	
	public static final String NULL_CONTENT_EXCEPTION = "Content is null";
	public static final String CONTENT_CREATION_EXCEPTION = "Content not created successfully";
	public static final String CONTENT_UPDATION_EXCEPTION = "Content not updated successfully";
	public static final String CONTENT_NOT_FOUND_EXCEPTION = "Content not found";
	public static final String CONTENT_DELETION_EXCEPTION = "Content not deleted successfully";

}
