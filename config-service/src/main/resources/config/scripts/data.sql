
DELETE FROM ms_user;

INSERT INTO ms_user ("user_id", "first_name", "name") VALUES (nextval('msuserseq'), 'marc', 'michieli');

INSERT INTO ms_user ("user_id", "first_name", "name") VALUES (nextval('msuserseq'), 'justine', 'turczynski');

INSERT INTO ms_user ("user_id", "first_name", "name") VALUES (nextval('msuserseq'), 'jean', 'dupont ');

INSERT INTO ms_user ("user_id", "first_name", "name") VALUES (nextval('msuserseq'), 'raphael', 'poubelle');
