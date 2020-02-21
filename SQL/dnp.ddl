-- 생성자 Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   위치:        2020-02-21 16:10:08 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



CREATE TABLE dnp_user (
    id             VARCHAR2(20 BYTE) NOT NULL,
    password       VARCHAR2(20 BYTE) NOT NULL,
    name           VARCHAR2(20 BYTE),
    auth           VARCHAR2(10 BYTE) NOT NULL,
    recently_date  TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL
);

ALTER TABLE dnp_user
    ADD CHECK ( auth IN (
        'Admin',
        'User'
    ) );

COMMENT ON COLUMN dnp_user.id IS
    '사용자 ID';

COMMENT ON COLUMN dnp_user.password IS
    '사용자 PW';

COMMENT ON COLUMN dnp_user.name IS
    '사용자 명';

COMMENT ON COLUMN dnp_user.auth IS
    '권한 (Admin, User)';

COMMENT ON COLUMN dnp_user.recently_date IS
    '사용자 마지막 로그인 시간';

CREATE UNIQUE INDEX user_1 ON
    dnp_user (
        id
    ASC );

CREATE INDEX user_2 ON
    dnp_user (
        name
    ASC );



-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             1
-- CREATE INDEX                             2
-- ALTER TABLE                              1
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
