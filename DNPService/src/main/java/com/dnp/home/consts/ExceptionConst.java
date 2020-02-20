package com.dnp.home.consts;

public class ExceptionConst {
	public static final int SUCCESS								= 0;
	public static final int FAIL								= 9999;

	// SYSTEM (0~199)
	public static final int SESSION_EXPIRED						= 20;
	public static final int ACCESS_DENIED						= 31;
	public static final int AUTHENTICATION_NEEDED				= 32;
	public static final int INVALID_LOGINID						= 101;
	public static final int INVALID_PASSWORD					= 102;
	public static final int UNREGISTERED_USER					= 103;
	public static final int UNREGISTERED_IP						= 104;
	public static final int LOCKED_USER							= 105;
	public static final int SERVICE_EXPIRED						= 106;
	public static final int DUPLICATE_USER						= 107;

	// AUTH (2xx)
	public static final int CANNOT_FOUND_PRIVATE_KEY			= 200;
	public static final int NOT_SYSTEM_ADMIN					= 201;

	// FILE (3xx)
	public static final int FILE_MOVE_FAILURE					= 300;
	public static final int FILE_NOT_EXISTS						= 301;
	public static final int FILE_NOT_ACCESS						= 302;
	public static final int DELETE_FILE_FAILED					= 303;
	public static final int PROPERTIES_READ_FAIL				= 304;
	public static final int PROPERTIES_WRITE_FAIL				= 305;

	// NETWORK (5xx)
	public static final int UNKNOWN_HOST						= 501;

	// COMMON (6xx)
	public static final int COMMON_JSON_PARSING_FAIL			= 601;

	// LOGIC
	public static final int RSA_NO_SUCH_ALGORITHM				= 1401;
	public static final int RSA_INVALID_KEY_SPEC				= 1402;
	public static final int RSA_ENCRYPTION_ERROR				= 1403;
	public static final int RSA_DECRYPTION_ERROR				= 1404;

	// VALIDATION (15xx)
	public static final int VALIDATION_COMMON					= 1500;
	public static final int VALIDATION_PARAMETER				= 1501;
	public static final int VALIDATION_MEMBER					= 1502;
	public static final int VALIDATION_DATE						= 1503;
	public static final int VALIDATION_WORK_END					= 1504;

	// DB (20xx)
	public static final int DB_COMMIT_FAILURE					= 2000;
	public static final int TRANSACTION_WAS_NOT_STARTED			= 2001;
	public static final int DELETE_NEWS_QUEUE_FAILED			= 2002;
	public static final int SELECT_ALL_SUBCONTENTS_FAILED		= 2003;
	public static final int SELECT_CONTENTS_CONTENTSID_FAILED	= 2004;
	public static final int SELECT_SUBCONTENTS_DETAIL_FAILED	= 2005;
	public static final int INSERT_FAVORITE_ADD_FAILED			= 2006;
	public static final int INSERT_CONTENTS_FAILED				= 2007;
	public static final int UPDATE_LAST_COMMENTINFO_FAILED		= 2008;
	public static final int INSERT_SQUARE_MEMBER_FAILED			= 2009;
	public static final int DELETE_FAVORITE_FAILED				= 2010;
	public static final int DELETE_ATTACH_FAILED				= 2011;
	public static final int SELECT_CONTENTSLIST_FAILED			= 2012;
	public static final int SELECT_DATA_ACCESS_FAILED			= 2013;
	public static final int INSERT_MYGROUP_FAILED				= 2014;
	public static final int UPDATE_MYGROUP_FAILED				= 2015;
	public static final int DELETE_MYGROUP_FAILED				= 2016;
	public static final int INSERT_MENTION_FAILED				= 2017;
	public static final int DELETE_MENTION_FAILED				= 2018;
	public static final int INSERT_TAG_FAILED					= 2019;
	public static final int DELETE_TAG_FAILED					= 2020;
	public static final int PROCESS_MENTION_FAILED				= 2021;
	public static final int PROCESS_TAG_FAILED					= 2022;
	public static final int INVALID_TAG_NAME					= 2023;

	// DNP Service 환경변수 유효성 (26xx) --> dnp.properties
}