DELETE FROM PALMARES_STAGIONE_GIOCATORE;
DELETE FROM PALMARES_SQUAD;
DELETE FROM STORICO_PARTECIPAZIONI;
DELETE FROM PARTECIPAZIONE;
DELETE FROM STATS_GIOCATORE_STAGIONE;
DELETE FROM STATS_GIOCATORE_PARTITA;
DELETE FROM CONTRATTO;
DELETE FROM GOL;
DELETE FROM PARTITA;
DELETE FROM COMPETIZIONE;
DELETE FROM SQUADRA;
DELETE FROM CALCIATORE;
DELETE FROM AMMINISTRATORE;
DELETE FROM STAGIONE;
DELETE FROM TIPO_COMPETIZIONE;
DELETE FROM RICHIESTE;
DELETE FROM UTENTE;
DELETE FROM TROFEO;
DELETE FROM ACCOUNT;

INSERT INTO ACCOUNT (Nome, Cognome, Username, Password) VALUES
('Luca', 'Camillini', 'a', '123'),
('Mario', 'Rossi', 'mario.rossi', 'password123'),
('Luigi', 'Bianchi', 'luigi.bianchi', 'securepass'),
('Giovanni', 'Verdi', 'giovanni.verdi', 'password456'),
('Marco', 'Violi', 'marco.violi', 'password789');

INSERT INTO AMMINISTRATORE (UsernameAmministratore) VALUES
('mario.rossi');

INSERT INTO CALCIATORE (Nome, Cognome, CF, Data_di_nascita, Nazionalita, Altezza, Luogo_di_nascita, Piede_preferito) VALUES
('Francesco', 'Totti', 'CF001', '1976-09-27', 'Italiano', 1.80, 'Roma', 'Destro'),
('Alessandro', 'Del Piero', 'CF002', '1974-11-09', 'Italiano', 1.73, 'Conegliano', 'Destro'),
('Roberto', 'Baggio', 'CF003', '1967-02-18', 'Italiano',  1.74, 'Caldogno', 'Destro'),
('Paolo', 'Maldini', 'CF004', '1968-06-26', 'Italiano',  1.87, 'Milano', 'Sinistro'),
('Gianluigi', 'Buffon', 'CF005', '1978-01-28', 'Italiano',  1.92, 'Carrara', 'Destro');

INSERT INTO SQUADRA (Nome, Nazione, TipoSquadra, Record_goal, Record_Presenze) VALUES
('AS Roma', 'Italia', 'Club', 1234, 890),
('Juventus', 'Italia', 'Club', 1450, 950),
('AC Milan', 'Italia', 'Club', 1320, 910);

INSERT INTO STAGIONE (AnnoCalcistico) VALUES
('2022/2023'),
('2023/2024');

INSERT INTO TIPO_COMPETIZIONE (Nome, Descrizione_, Numero_partecipanti) VALUES
('Serie A', 'Campionato italiano di calcio', 20),
('Coppa Italia', 'Competizione ad eliminazione diretta', 42);

INSERT INTO COMPETIZIONE (TipoCompetizione, AnnoCalcistico, CodiceCompetizione) VALUES
('Serie A', '2023/2024', 'COMP001'),
('Serie A', '2022/2023', 'COMP002'),
('Coppa Italia', '2023/2024', 'COMP003');

INSERT INTO PARTITA (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, Data, Stadio, Ora, SquadraCasa, SquadraOspite) VALUES
('2023/2024', 'Serie A', 'COMP001', 'P001', '2023-08-20', 'Stadio Olimpico', '20:00', 'AS Roma', 'Juventus');

INSERT INTO GOL (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, Marcatore, Minuto, Assistman) VALUES
('2023/2024', 'Serie A', 'COMP001', 'P001', 'Francesco Totti', 34, 'ff'),
('2023/2024', 'Serie A', 'COMP001', 'P001', 'Alessandro Del Piero', 58, 'dd');


INSERT INTO CONTRATTO (CF_Calciatore, DataFirma, Durata, Valore) VALUES
('CF001', '2022-07-01', '2 anni', 5000000),
('CF002', '2023-06-15', '3 anni', 6000000);

INSERT INTO STATS_GIOCATORE_PARTITA (CF_Calciatore, AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, CodiceStatsPartita, Goal, Assist, Cartellini) VALUES
('CF001', '2023/2024', 'Serie A', 'COMP001', 'P001', 'StatsPart1', 1, 1, 0),
('CF002', '2023/2024', 'Serie A', 'COMP001', 'P001', 'StatsPart1', 1, 1, 0);

INSERT INTO STATS_GIOCATORE_STAGIONE (CF_Calciatore, AnnoCalcistico, CodiceStatsStagionale, Goal_stagionali, Assist_stagionali, Valore_di_mercato, Presenze, Numero_maglia, Cartellini_stagionali, Ruolo) VALUES
('CF001', '2023/2024', 'Stats1', 10, 5, 2000000, 30, 10, 3, 'Attaccante'),
('CF002', '2023/2024', 'Stats2', 15, 7, 1550000, 32, 9, 5, 'Centrocampista'),
('CF003', '2023/2024', 'Stats3', 23, 5, 1233333, 45, 10, 2, 'Trequartista');

INSERT INTO Trofeo (NomeTrofeo, Quantita) VALUES
('Scudetto', 1),
('Coppa Italia', 1);

INSERT INTO PALMARES_SQUAD (NomeSquadra, NomeTrofeo) VALUES
('AS Roma', 'Scudetto'),
('Juventus', 'Coppa Italia');

INSERT INTO PALMARES_STAGIONE_GIOCATORE (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale, NomeTrofeo) VALUES
('2023/2024', 'CF001', 'Stats1', 'Scudetto'),
('2023/2024', 'CF002', 'Stats2', 'Coppa Italia');

INSERT INTO PARTECIPAZIONE (NomeSquadra, AnnoCalcistico, TipoCompetizione, CodiceCompetizione, Piazzamento) VALUES
('AS Roma', '2023/2024', 'Serie A', 'COMP001', '1º posto'),
('Juventus', '2023/2024', 'Serie A', 'COMP001', '2º posto'),
('AC Milan', '2023/2024', 'Serie A', 'COMP001', '3º posto');

INSERT INTO STORICO_PARTECIPAZIONI (CF_Calciatore, AnnoCalcistico, CodiceStorico, NomeSquadra) VALUES
('CF001', '2023/2024', 'ST001', 'AS Roma'),
('CF002', '2023/2024', 'ST002', 'Juventus'),
('CF003', '2023/2024', 'ST003', NULL);

INSERT INTO UTENTE (Username, Targhetta) VALUES
('a', NULL),
('luigi.bianchi', 'Attendibile'),
('giovanni.verdi', 'Non Attendibile'),
('marco.violi', NULL);

INSERT INTO RICHIESTE (UsernameUtente, CodiceRichiesta, Tipologia, Stato, Descrizione) VALUES
('luigi.bianchi', 1, 'Modifica', 'Non visionata', 'Questa stagione il calciatore Francesco Totti ha segnato 10 gol e non 5');