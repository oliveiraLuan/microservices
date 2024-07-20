INSERT INTO tb_user (email, name, password) VALUES ('luan@gmail.com', 'Luan de Oliveira', 'y0u4r3cur10us');
INSERT INTO tb_user (email, name, password) VALUES ('wagner@gmail.com', 'Wagner Moura', 'florida');

INSERT INTO tb_role(role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role(role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2, 1);