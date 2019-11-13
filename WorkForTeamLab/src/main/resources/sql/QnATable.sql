--------------------------------------------------------
--  DDL for Table QNACONTACT
--------------------------------------------------------

  CREATE TABLE "HR"."QNACONTACT" 
   (	"QNA_NUM" NUMBER, 
	"QNA_ID" VARCHAR2(20 BYTE), 
	"QNA_TITLE" VARCHAR2(100 BYTE), 
	"QNA_CONTENTS" LONG, 
	"QNA_EMAIL" VARCHAR2(50 BYTE), 
	"QNA_WRITEDATE" DATE DEFAULT sysdate, 
	"QNA_STATUS" VARCHAR2(10 BYTE) DEFAULT '1', 
	"QNA_RESOLVEDATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.QNACONTACT
SET DEFINE OFF;
Insert into HR.QNACONTACT (QNA_NUM,QNA_ID,QNA_TITLE,QNA_CONTENTS,QNA_EMAIL,QNA_WRITEDATE,QNA_STATUS,QNA_RESOLVEDATE) values (21,'test1','weq','HhHIahahihaihaiqweqwezxcz','qed@adw.com',to_date('19/10/10','RR/MM/DD'),'1',null);
Insert into HR.QNACONTACT (QNA_NUM,QNA_ID,QNA_TITLE,QNA_CONTENTS,QNA_EMAIL,QNA_WRITEDATE,QNA_STATUS,QNA_RESOLVEDATE) values (41,'test1','adad','this is siisi','qe13d@adw.com',to_date('19/10/13','RR/MM/DD'),'1',null);
Insert into HR.QNACONTACT (QNA_NUM,QNA_ID,QNA_TITLE,QNA_CONTENTS,QNA_EMAIL,QNA_WRITEDATE,QNA_STATUS,QNA_RESOLVEDATE) values (1,'test1','hi','dawdada','emila@maidal.com',to_date('19/10/08','RR/MM/DD'),'1',null);
--------------------------------------------------------
--  DDL for Index SYS_C007091
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007091" ON "HR"."QNACONTACT" ("QNA_NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table QNACONTACT
--------------------------------------------------------

  ALTER TABLE "HR"."QNACONTACT" ADD PRIMARY KEY ("QNA_NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."QNACONTACT" MODIFY ("QNA_EMAIL" NOT NULL ENABLE);
  ALTER TABLE "HR"."QNACONTACT" MODIFY ("QNA_CONTENTS" NOT NULL ENABLE);
  ALTER TABLE "HR"."QNACONTACT" MODIFY ("QNA_TITLE" NOT NULL ENABLE);
  ALTER TABLE "HR"."QNACONTACT" MODIFY ("QNA_ID" NOT NULL ENABLE);