SET MODE MYSQL;

DROP TABLE IF EXISTS Products;

CREATE TABLE Products
(
    prod_id     IDENTITY        PRIMARY KEY,
    prod_name   VARCHAR(255)    NOT NULL,
    prod_price  INT             NOT NULL
);

-- OPE_진료시간
DROP TABLE IF EXISTS OPE_TIME;

-- OPE_진료시간
CREATE TABLE "OPE_TIME" (
	"OPE_ID"       IDENTITY        PRIMARY KEY, -- 진료시간식별번호
	"CNC_ST_DT"    DATETIME        NOT NULL, -- 진료시작시간
	"CNC_END_DT"   DATETIME        NOT NULL, -- 진료마감시간
	"LUC_ST_DT"    DATETIME        NULL,     -- 점심시작시간
	"LUC_END_DT"   DATETIME        NULL,     -- 점심마감시간
	"DAY_TP_CD"    VARCHAR(10) NOT NULL, -- 날짜구분코드
	"REG_DT"       DATETIME        NOT NULL, -- 등록일시
	"MOD_DT"       DATETIME        NULL      -- 수정일시
);

-- MB_회원
DROP TABLE IF EXISTS MB_MBR CASCADE;

-- MB_회원
CREATE TABLE "MB_MBR" (
	"MBR_ID"    IDENTITY        PRIMARY KEY, -- 회원식별번호
	"MBR_NM"    VARCHAR(50) NOT NULL, -- 회원이름
	"MBR_CP_NO" VARCHAR(30) NOT NULL, -- 회원연락처
	"REG_DT"    DATETIME        NOT NULL, -- 등록일시
	"MOD_DT"    DATETIME        NULL      -- 수정일시
);

-- DO_의사
DROP TABLE IF EXISTS DO_DOC CASCADE;

-- DO_의사
CREATE TABLE "DO_DOC" (
	"DOC_ID"    IDENTITY        PRIMARY KEY, -- 의사식별번호
	"DOC_NM"    VARCHAR(50) NOT NULL, -- 의사이름
	"DOC_CD"    VARCHAR(10) NOT NULL, -- 진료과목코드
	"DEL_YN"    CHAR(1)     NOT NULL, -- 삭제여부
	"REG_DT"    DATETIME        NOT NULL, -- 등록일시
	"MOD_DT"    DATETIME        NULL      -- 수정일시
);

-- HO_휴무일
DROP TABLE IF EXISTS HO_HOLI CASCADE;

-- HO_휴무일
CREATE TABLE "HO_HOLI" (
	"HOLI_ID" IDENTITY        PRIMARY KEY, -- 휴무일식별번호
	"DOC_ID"  VARCHAR(20) NOT NULL, -- 의사식별번호
	"HOLI_DT" DATETIME        NOT NULL, -- 휴무일
	"DEL_YN"  CHAR(1)     NOT NULL, -- 삭제여부
	"REG_DT"  DATETIME        NOT NULL, -- 등록일시
	"MOD_DT"  DATETIME        NULL      -- 수정일시
);

-- HO_휴무일
ALTER TABLE "HO_HOLI"
	ADD
		CONSTRAINT "FK_DO_DOC_TO_HO_HOLI" -- DO_의사 -> HO_휴무일
		FOREIGN KEY (
			"DOC_ID" -- 의사식별번호
		)
		REFERENCES "DO_DOC" ( -- DO_의사
			"DOC_ID" -- 의사식별번호
		);
		
-- RE_예약
DROP TABLE IF EXISTS RE_RES CASCADE;
CREATE TABLE "RE_RES" (
	"RES_ID"     IDENTITY        PRIMARY KEY, -- 예약식별번호
	"MBR_ID"     VARCHAR(20)        NOT NULL, -- 회원식별번호
	"DOC_ID"     VARCHAR(20)        NOT NULL, -- 의사식별번호
	"REV_DT"     DATETIME               NOT NULL, -- 진료일
	"REV_ST_DT"  DATETIME               NOT NULL, -- 진료시작일시
	"REV_MT"         VARCHAR(5)        NOT NULL, -- 진료사용시간
	"REV_END_DT" DATETIME               NOT NULL, -- 진료마감일시
	"DEL_YN"     CHAR(1)            NOT NULL, -- 삭제여부
	"REG_DT"     DATETIME               NOT NULL, -- 등록일시
	"MOD_DT"     DATETIME               NULL      -- 수정일시
);

-- RE_예약
ALTER TABLE "RE_RES"
	ADD
		CONSTRAINT "FK_MB_MBR_TO_RE_RES" -- MB_회원 -> RE_예약
		FOREIGN KEY (
			"MBR_ID" -- 회원식별번호
		)
		REFERENCES "MB_MBR" ( -- MB_회원
			"MBR_ID" -- 회원식별번호
		);

-- RE_예약
ALTER TABLE "RE_RES"
	ADD
		CONSTRAINT "FK_DO_DOC_TO_RE_RES" -- DO_의사 -> RE_예약
		FOREIGN KEY (
			"DOC_ID" -- 의사식별번호
		)
		REFERENCES "DO_DOC" ( -- DO_의사
			"DOC_ID" -- 의사식별번호
		);

-- CM_달력
DROP TABLE IF EXISTS CM_CLDR;
CREATE TABLE "CM_CLDR" (
	"DE"      DATE          NOT NULL, -- 일자
	"DWK"     INTEGER       NOT NULL, -- 요일
	"HOLI_YN" CHAR(1)       NOT NULL, -- 휴일여부
	"HLDY_YN" CHAR(1)       NOT NULL, -- 명절당일여부
	"NOTE"    VARCHAR(1000) NULL,     -- 비고
	"REG_DT"  DATETIME          NOT NULL  -- 등록일시
);

-- 달력 데이터 생성
DROP TABLE IF EXISTS T;
CREATE TABLE "T" (
	"N" INTEGER
);