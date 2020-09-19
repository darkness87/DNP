-- DNP user darka87 / qkfka@1102

-- drop table sp_user cascade constraints;
CREATE TABLE sp_user
(
	id                  VARCHAR2 (20 BYTE) NOT NULL,
	password		    VARCHAR2 (100 BYTE) NOT NULL,
	name			    VARCHAR2 (128 BYTE) NULL,
	author			    VARCHAR2 (10 BYTE) NULL,
	create_date         TIMESTAMP NOT NULL,
    recently_date       TIMESTAMP NULL,
	security_flag	    CHAR (1 BYTE) NULL,
	status			    CHAR (1 BYTE) NULL,
    rating_rank         NUMBER (2) DEFAULT 0
)
PCTFREE 10
PCTUSED 0
INITRANS 1
MAXTRANS 255
STORAGE (INITIAL 1M
		NEXT 10M
		MINEXTENTS 1
		MAXEXTENTS UNLIMITED
		PCTINCREASE 0
		BUFFER_POOL DEFAULT)
NOCACHE
LOGGING;

CREATE UNIQUE INDEX sp_user_1
	ON sp_user (id)
	LOGGING
	PCTFREE 1
	INITRANS 2
	MAXTRANS 255
	STORAGE (INITIAL 1M
			NEXT 10M
			MINEXTENTS 1
			MAXEXTENTS UNLIMITED
			PCTINCREASE 0
			BUFFER_POOL DEFAULT);

CREATE INDEX sp_user_2
	ON sp_user (name)
	LOGGING
	PCTFREE 1
	INITRANS 2
	MAXTRANS 255
	STORAGE (INITIAL 1M
			NEXT 10M
			MINEXTENTS 1
			MAXEXTENTS UNLIMITED
			PCTINCREASE 0
			BUFFER_POOL DEFAULT);

COMMENT ON COLUMN sp_user.id IS '����� ID';
COMMENT ON COLUMN sp_user.password IS '����� ��й�ȣ';
COMMENT ON COLUMN sp_user.name IS '����� �̸�';
COMMENT ON COLUMN sp_user.author IS '����� ����';
COMMENT ON COLUMN sp_user.create_date IS '����� ��������';
COMMENT ON COLUMN sp_user.recently_date IS '�ֱ� ��������';
COMMENT ON COLUMN sp_user.security_flag IS 'ADMIN:���۱���, MANAGER:��ڱ���, USER:����ڱ���';
COMMENT ON COLUMN sp_user.status IS 'NORMAL:����, ABNORMAL:������';
COMMENT ON COLUMN sp_user.rating_rank IS '���';

-- drop table sp_product cascade constraints;
CREATE TABLE sp_product
(
	prod_id             VARCHAR2 (20 BYTE) NOT NULL,
	prod_name           VARCHAR2 (200 BYTE) NOT NULL,
    cost                NUMBER (10) DEFAULT 0,
    price               NUMBER (10) DEFAULT 0,
    description         VARCHAR2 (2000 BYTE) NULL,
    create_date         TIMESTAMP NOT NULL,
    modify_date         TIMESTAMP NULL,
    rating_rank_level   NUMBER (2) DEFAULT 0
)
PCTFREE 10
PCTUSED 0
INITRANS 1
MAXTRANS 255
STORAGE (INITIAL 1M
		NEXT 10M
		MINEXTENTS 1
		MAXEXTENTS UNLIMITED
		PCTINCREASE 0
		BUFFER_POOL DEFAULT)
NOCACHE
LOGGING;

CREATE UNIQUE INDEX sp_product_1
	ON sp_product (prod_id)
	LOGGING
	PCTFREE 1
	INITRANS 2
	MAXTRANS 255
	STORAGE (INITIAL 1M
			NEXT 10M
			MINEXTENTS 1
			MAXEXTENTS UNLIMITED
			PCTINCREASE 0
			BUFFER_POOL DEFAULT);

CREATE INDEX sp_product_2
	ON sp_product (prod_name)
	LOGGING
	PCTFREE 1
	INITRANS 2
	MAXTRANS 255
	STORAGE (INITIAL 1M
			NEXT 10M
			MINEXTENTS 1
			MAXEXTENTS UNLIMITED
			PCTINCREASE 0
			BUFFER_POOL DEFAULT);

COMMENT ON COLUMN sp_product.prod_id IS '��ǰ ID';
COMMENT ON COLUMN sp_product.prod_name IS '��ǰ �̸�';
COMMENT ON COLUMN sp_product.cost IS '����';
COMMENT ON COLUMN sp_product.price IS '�ǸŰ�';
COMMENT ON COLUMN sp_product.description IS '��ǰ ����';
COMMENT ON COLUMN sp_product.create_date IS '��ǰ ��������';
COMMENT ON COLUMN sp_product.modify_date IS '��ǰ ��������';
COMMENT ON COLUMN sp_product.rating_rank_level IS '��ǰ ���� ����';


-- drop table sp_product cascade constraints;
CREATE TABLE sp_rating_rank
(
    rating_level          NUMBER (2) DEFAULT 0,
    rating_name           VARCHAR2 (50 BYTE) NOT NULL
)
PCTFREE 10
PCTUSED 0
INITRANS 1
MAXTRANS 255
STORAGE (INITIAL 1M
		NEXT 10M
		MINEXTENTS 1
		MAXEXTENTS UNLIMITED
		PCTINCREASE 0
		BUFFER_POOL DEFAULT)
NOCACHE
LOGGING;

CREATE UNIQUE INDEX sp_rating_rank_1
	ON sp_rating_rank (rating_level)
	LOGGING
	PCTFREE 1
	INITRANS 2
	MAXTRANS 255
	STORAGE (INITIAL 1M
			NEXT 10M
			MINEXTENTS 1
			MAXEXTENTS UNLIMITED
			PCTINCREASE 0
			BUFFER_POOL DEFAULT);

COMMENT ON COLUMN sp_rating_rank.rating_level IS '��� ����';
COMMENT ON COLUMN sp_rating_rank.rating_name IS '��� ��Ī';

CREATE TABLE sp_product_option
(
    prod_option_item_id     VARCHAR2 (20 BYTE) NOT NULL,
	prod_id                 VARCHAR2 (20 BYTE) NOT NULL,
	prod_option_name        VARCHAR2 (200 BYTE) NOT NULL,
    prod_option_item_name   VARCHAR2 (200 BYTE) NOT NULL,
    prod_option_item_cost   NUMBER (10) DEFAULT 0,
    prod_option_item_price  NUMBER (10) DEFAULT 0,
    remark                  VARCHAR2 (2000 BYTE) NULL
)
PCTFREE 10
PCTUSED 0
INITRANS 1
MAXTRANS 255
STORAGE (INITIAL 1M
		NEXT 10M
		MINEXTENTS 1
		MAXEXTENTS UNLIMITED
		PCTINCREASE 0
		BUFFER_POOL DEFAULT)
NOCACHE
LOGGING;

