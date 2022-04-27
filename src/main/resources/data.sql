INSERT INTO ASSOCIADO(nome, cpf) VALUES ('LoFi Girl', '123456789101');
INSERT INTO ASSOCIADO(nome, cpf) VALUES ('Jackson do Pandeiro', '123456789102');
INSERT INTO ASSOCIADO(nome, cpf) VALUES ('Alcione', '123456789103');
INSERT INTO ASSOCIADO(nome, cpf) VALUES ('Riachao', '123456789104');

INSERT INTO PAUTA(titulo, descricao, status_votacao) VALUES ('O samba deve morrer?', 'Nao deixe o samba morrer, Nao deixe o samba acabar', 'CRIADA');
INSERT INTO PAUTA(titulo, descricao, status_votacao) VALUES ('Faculdade e importante para a carreira dev?', 'Tretas da internet invadindo a API', 'CRIADA');
INSERT INTO PAUTA(titulo, descricao, status_votacao) VALUES ('Cafe e a melhor bebida do mundo?', 'Se o nao ganhar, ta faltando programador na votacao', 'CRIADA');

INSERT INTO SESSAO(pauta_id, inicio_da_sessao, fim_da_sessao) VALUES ('1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP  + INTERVAL '2' MINUTE);
INSERT INTO SESSAO(pauta_id, inicio_da_sessao, fim_da_sessao) VALUES ('2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP  + INTERVAL '2' MINUTE);
INSERT INTO SESSAO(pauta_id, inicio_da_sessao, fim_da_sessao) VALUES ('3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP  + INTERVAL '2' MINUTE);

INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('1', '1', CURRENT_TIMESTAMP, 'NAO');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('2', '1', CURRENT_TIMESTAMP, 'NAO');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('3', '1', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('1', '2', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('2', '2', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('3', '2', CURRENT_TIMESTAMP, 'NAO');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('4', '2', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('1', '3', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('2', '3', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('3', '3', CURRENT_TIMESTAMP, 'SIM');
INSERT INTO VOTO(associado_id, sessao_id, hora_do_voto, valor_voto) VALUES ('4', '3', CURRENT_TIMESTAMP, 'SIM');

