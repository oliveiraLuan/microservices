INSERT INTO tb_user (email, name, password) VALUES ('luan@gmail.com', 'Luan de Oliveira', '$2a$10$GBCiF99oj1e5Xbh0ws/n5OT66Dee8.grHeTMLZnAisztAnTrKygdW');
INSERT INTO tb_user (email, name, password) VALUES ('wagner@gmail.com', 'Wagner Moura', '$2a$10$o5m3LABmpDqZYw2NHgdNNu0nGHOskvCXvi/xnY79EHxoFEPh.gvKm');

INSERT INTO tb_role(role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role(role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role(user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role(user_id, role_id) VALUES (2, 1);