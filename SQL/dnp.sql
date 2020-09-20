-- DNP user darka87 / qkfka@1102

-- drop table sp_user cascade constraints;
CREATE TABLE sp_user
(
	user_id             VARCHAR2 (20 BYTE) NOT NULL,
	user_pw 		    VARCHAR2 (100 BYTE) NOT NULL,
	user_name			VARCHAR2 (128 BYTE) NULL,
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
	ON sp_user (user_id)
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
	ON sp_user (user_name)
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

COMMENT ON COLUMN sp_user.user_id IS '사용자 ID';
COMMENT ON COLUMN sp_user.user_pw IS '사용자 비밀번호';
COMMENT ON COLUMN sp_user.user_name IS '사용자 이름';
COMMENT ON COLUMN sp_user.author IS '사용자 권한';
COMMENT ON COLUMN sp_user.create_date IS '사용자 생성일자';
COMMENT ON COLUMN sp_user.recently_date IS '최근 접속일자';
COMMENT ON COLUMN sp_user.security_flag IS 'ADMIN:슈퍼권한, MANAGER:운영자권한, USER:사용자권한';
COMMENT ON COLUMN sp_user.status IS 'NORMAL:정상, ABNORMAL:비정상';
COMMENT ON COLUMN sp_user.rating_rank IS '등급(높을수록 높아짐)';

-- drop table sp_product cascade constraints;
CREATE TABLE sp_product
(
	prod_id             VARCHAR2 (20 BYTE) NOT NULL,
	prod_name           VARCHAR2 (200 BYTE) NOT NULL,
    cost                NUMBER (10) DEFAULT 0,
    price               NUMBER (10) DEFAULT 0,
    quantity            NUMBER (10) DEFAULT 0,
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

COMMENT ON COLUMN sp_product.prod_id IS '상품 ID';
COMMENT ON COLUMN sp_product.prod_name IS '상품 이름';
COMMENT ON COLUMN sp_product.cost IS '원가';
COMMENT ON COLUMN sp_product.price IS '판매가';
COMMENT ON COLUMN sp_product.quantity IS '상품 보유 수량';
COMMENT ON COLUMN sp_product.description IS '상품 설명';
COMMENT ON COLUMN sp_product.create_date IS '상품 생성일자';
COMMENT ON COLUMN sp_product.modify_date IS '상품 수정일자';
COMMENT ON COLUMN sp_product.rating_rank_level IS '상품 노출 수준 ex) 5이상';


-- drop table sp_rating_rank cascade constraints;
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

COMMENT ON COLUMN sp_rating_rank.rating_level IS '등급 순위 (숫자가 높을수록 상위)';
COMMENT ON COLUMN sp_rating_rank.rating_name IS '등급 명칭';


-- drop table sp_product_option cascade constraints;
CREATE TABLE sp_product_option
(
    prod_option_item_id     VARCHAR2 (20 BYTE) NOT NULL,
	prod_id                 VARCHAR2 (20 BYTE) NOT NULL,
    prod_option_id          VARCHAR2 (20 BYTE) NOT NULL,
	prod_option_name        VARCHAR2 (200 BYTE) NOT NULL,
    prod_option_item_name   VARCHAR2 (200 BYTE) NOT NULL,
    prod_option_item_cost   NUMBER (10) DEFAULT 0,
    prod_option_item_price  NUMBER (10) DEFAULT 0,
    prod_option_item_order  NUMBER (1) DEFAULT 0,
    prod_option_item_use    CHAR(5) CHECK(prod_option_item_use IN('FALSE', 'TRUE')),
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

CREATE UNIQUE INDEX sp_product_option_1
	ON sp_product_option (prod_option_item_id)
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

CREATE INDEX sp_product_option_2
	ON sp_product_option (prod_id)
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

CREATE INDEX sp_product_option_3
	ON sp_product_option (prod_option_id)
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

COMMENT ON COLUMN sp_product_option.prod_option_item_id IS '옵션 선택항목 ID';
COMMENT ON COLUMN sp_product_option.prod_id IS '연결된 상품 ID';
COMMENT ON COLUMN sp_product_option.prod_option_id IS '옵션 ID';
COMMENT ON COLUMN sp_product_option.prod_option_name IS '옵션 명';
COMMENT ON COLUMN sp_product_option.prod_option_item_name IS '옵션 선택항목 이름';
COMMENT ON COLUMN sp_product_option.prod_option_item_cost IS '옵션 선택항목 원가';
COMMENT ON COLUMN sp_product_option.prod_option_item_price IS '옵션 선택항목 판매가';
COMMENT ON COLUMN sp_product_option.prod_option_item_order IS '옵션 선택항목 노출순위';
COMMENT ON COLUMN sp_product_option.prod_option_item_use IS '옵션 선택항목 구분바';
COMMENT ON COLUMN sp_product_option.remark IS '비고';


-- drop table sp_product_basket cascade constraints;
CREATE TABLE sp_product_basket
(
    prod_id             VARCHAR2 (20 BYTE) NOT NULL,
    user_id             VARCHAR2 (20 BYTE) NOT NULL,
    create_date         TIMESTAMP NOT NULL,
    wishlist_use        CHAR(5) DEFAULT 'FALSE'
    CONSTRAINT basket_wishlist_use_ck CHECK(wishlist_use IN('FALSE', 'TRUE'))
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

CREATE UNIQUE INDEX sp_product_option_1
	ON sp_product_option (prod_option_item_id)
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

CREATE INDEX sp_product_option_2
	ON sp_product_option (prod_id)
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

COMMENT ON COLUMN sp_product_basket.prod_id IS '연결된 상품 ID';
COMMENT ON COLUMN sp_product_basket.user_id IS '사용자 ID';
COMMENT ON COLUMN sp_product_basket.create_date IS '장바구니/위시리스트 생성일자';
COMMENT ON COLUMN sp_product_basket.wishlist_use IS 'TRUE: 위시리스트, FALSE: 장바구니(Default)';