-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Wed Sep  4 20:33:31 2024 
-- * LUN file: C:\Users\Luca\Desktop\FootStats\docs\ER\FootStats.lun 
-- * Schema: SQL/SQL1 
-- ********************************************* 


-- Database Section
-- ________________ 

drop database if exists FootStats;
create database FootStats;
use FootStats;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table ACCOUNT (
     Nome varchar(64) not null,
     Cognome varchar(64) not null,
     Username varchar(64) not null,
     Password varchar(256) not null,
     constraint ID_ACCOUNT_ID primary key (Username));

create table AMMINISTRATORE (
     UsernameAmministratore varchar(64) not null,
     constraint ID_AMMIN_ACCOU_ID primary key (UsernameAmministratore));

create table CALCIATORE (
     Nome varchar(64) not null,
     Cognome varchar(64) not null,
     CF char(32) not null,
     Nazionalita varchar(64) not null,
     Data_di_nascita date not null,
     Altezza numeric(64) not null,
     Luogo_di_nascita varchar(64) not null,
     Piede_preferito varchar(64) not null,
     constraint ID_CALCIATORE_ID primary key (CF));

create table COMPETIZIONE (
     AnnoCalcistico varchar(64) not null,
     TipoCompetizione varchar(64) not null,
     CodiceCompetizione varchar(128) not null,
     constraint ID_COMPETIZIONE_ID primary key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione));

create table CONTRATTO (
     CF_Calciatore char(32) not null,
     DataFirma date not null,
     Durata varchar(64) not null,
     Valore numeric(64) not null,
     constraint ID_CONTRATTO_ID primary key (CF_Calciatore, DataFirma));

create table GOL (
     AnnoCalcistico varchar(64) not null,
     TipoCompetizione varchar(64) not null,
     CodiceCompetizione char(128) not null,
     CodicePartita char(32) not null,
     Minuto numeric(32) not null,
     CF_Marcatore char(32) not null,
     CF_Assistman char(32) null,
     constraint ID_GOL_ID primary key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, Minuto));

create table PALMARES_SQUAD (
     NomeTrofeo varchar(64) not null,
     NomeSquadra varchar(64) not null,
     constraint ID_PALMARES_SQUAD_ID primary key (NomeSquadra, NomeTrofeo));

create table PALMARES_STAGIONE_GIOCATORE (
     AnnoCalcistico varchar(64) not null,
     CF_Calciatore char(32) not null,
     CodiceStatsStagionale char(64) not null,
     NomeTrofeo varchar(64) not null,
     constraint ID_PALMARES_STAGIONE_GIOCATORE_ID primary key (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale, NomeTrofeo));

create table PARTECIPAZIONE (
     NomeSquadra varchar(64) not null,
     AnnoCalcistico varchar(64) not null,
     TipoCompetizione varchar(64) not null,
     CodiceCompetizione char(128) not null,
     Piazzamento numeric(32) not null,
     constraint ID_PARTECIPAZIONE_ID primary key (NomeSquadra, AnnoCalcistico, TipoCompetizione, CodiceCompetizione));

create table PARTITA (
     AnnoCalcistico varchar(64) not null,
     TipoCompetizione varchar(64) not null,
     CodiceCompetizione char(128) not null,
     CodicePartita char(64) not null,
     Data date not null,
     Stadio varchar(64) not null,
     Ora char(64) not null,
     SquadraCasa varchar(64) not null,
     SquadraOspite varchar(64) not null,
     constraint ID_PARTITA_ID primary key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita));

create table RICHIESTE (
     Username varchar(64) not null,
     CodiceRichiesta char(64) not null,
     Tipologia varchar(64) not null,
     Descrizione varchar(500) not null,
     Stato varchar(32) not null,
     constraint ID_RICHIESTE_ID primary key (Username, CodiceRichiesta));

create table SQUADRA (
     Nome varchar(64) not null,
     Nazione varchar(64) not null,
     TipoSquadra varchar(64) not null,
     Record_goal numeric(32) not null,
     Record_Presenze numeric(32) not null,
     constraint ID_SQUADRA_ID primary key (Nome));

create table STAGIONE (
     AnnoCalcistico varchar(64) not null,
     constraint ID_STAGIONE_ID primary key (AnnoCalcistico));

create table STATS_GIOCATORE_PARTITA (
	 AnnoCalcistico varchar(64) not null,
	 TipoCompetizione varchar(64) not null,
	 CodiceCompetizione char(128) not null,
     CF_Calciatore char(32) not null,
     CodicePartita char(64) not null,
     CodiceStatsPartita char(64) not null,
     Goal numeric(32) not null,
     Assist numeric(32) not null,
     Cartellini numeric(32) not null,
     constraint ID_STATS_GIOCATORE_PARTITA_ID primary key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, CF_Calciatore));

create table STATS_GIOCATORE_STAGIONE (
     CF_Calciatore char(32) not null,
     AnnoCalcistico varchar(64) not null,
     CodiceStatsStagionale char(64) not null,
     Goal_stagionali numeric(32) not null,
     Assist_stagionali numeric(32) not null,
     Valore_di_mercato numeric(64) not null,
     Presenze numeric(64) not null,
     Numero_maglia numeric(32),
     Cartellini_stagionali numeric(32) not null,
     Ruolo varchar(64) not null,
     constraint ID_STATS_GIOCATORE_STAGIONE_ID primary key (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale));

create table STORICO_PARTECIPAZIONI (
     AnnoCalcistico varchar(64) not null,
     CF_Calciatore char(32) not null,
     CodiceStorico char(64) not null,
     NomeSquadra varchar(64) null,
     constraint ID_STORICO_PARTECIPAZIONI_ID primary key (CF_Calciatore, AnnoCalcistico, CodiceStorico));

create table TIPO_COMPETIZIONE (
     Nome varchar(64) not null,
     Descrizione varchar(256) not null,
     Numero_partecipanti numeric(10) not null,
     constraint ID_TIPO_COMPETIZIONE_ID primary key (Nome));

create table TROFEO (
     NomeTrofeo varchar(64) not null,
     constraint ID_TROFEO_ID primary key (NomeTrofeo));

create table UTENTE (
     Username varchar(64) not null,
     Targhetta varchar(64) null,
     constraint ID_UTENT_ACCOU_ID primary key (Username));


-- Constraints Section
-- ___________________ 

alter table AMMINISTRATORE add constraint ID_AMMIN_ACCOU_FK
     foreign key (UsernameAmministratore)
     references ACCOUNT(Username);

alter table COMPETIZIONE add constraint REF_COMPE_TIPO__FK
     foreign key (TipoCompetizione)
     references TIPO_COMPETIZIONE(Nome);

alter table COMPETIZIONE add constraint REF_COMPE_STAGI
     foreign key (AnnoCalcistico)
     references STAGIONE(AnnoCalcistico);

alter table CONTRATTO add constraint REF_CONTR_CALCI
     foreign key (CF_Calciatore)
     references CALCIATORE(CF);

alter table GOL add constraint REF_GOL_CALCI_1_FK
     foreign key (CF_Marcatore)
     references CALCIATORE(CF);

alter table GOL add constraint REF_GOL_CALCI_FK
     foreign key (CF_Assistman)
     references CALCIATORE(CF);

alter table GOL add constraint REF_GOL_PARTI
     foreign key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita)
     references PARTITA(AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita);

alter table PALMARES_SQUAD add constraint REF_PAL_S_SQUAD
     foreign key (NomeSquadra)
     references SQUADRA(Nome);

alter table PALMARES_SQUAD add constraint REF_PAL_S_Trofe_1_FK
     foreign key (NomeTrofeo)
     references TROFEO(NomeTrofeo);

alter table PALMARES_STAGIONE_GIOCATORE add constraint REF_PAL_S_Trofe_FK
     foreign key (NomeTrofeo)
     references TROFEO(NomeTrofeo);

alter table PALMARES_STAGIONE_GIOCATORE add constraint REF_PAL_S_STATS
     foreign key (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale)
     references STATS_GIOCATORE_STAGIONE(AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale);

alter table PARTECIPAZIONE add constraint REF_PARTE_COMPE_FK
     foreign key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione)
     references COMPETIZIONE(AnnoCalcistico, TipoCompetizione, CodiceCompetizione);

alter table PARTECIPAZIONE add constraint REF_PARTE_SQUAD
     foreign key (NomeSquadra)
     references SQUADRA(Nome);

alter table PARTITA add constraint REF_PARTI_SQUAD_1_FK
     foreign key (SquadraCasa)
     references SQUADRA(Nome);

alter table PARTITA add constraint REF_PARTI_SQUAD_FK
     foreign key (SquadraOspite)
     references SQUADRA(Nome);

alter table PARTITA add constraint EQU_PARTI_COMPE
     foreign key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione)
     references COMPETIZIONE(AnnoCalcistico, TipoCompetizione, CodiceCompetizione);

alter table RICHIESTE add constraint REF_RICHI_UTENT
     foreign key (Username)
     references UTENTE(Username);

alter table STATS_GIOCATORE_PARTITA add constraint REF_STATS_PARTI
     foreign key (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita)
     references PARTITA(AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita);

alter table STATS_GIOCATORE_PARTITA add constraint REF_STATS_CALCI_1_FK
     foreign key (CF_Calciatore)
     references CALCIATORE(CF);

alter table STATS_GIOCATORE_STAGIONE add constraint REF_STATS_STAGI
     foreign key (AnnoCalcistico)
     references STAGIONE(AnnoCalcistico);

alter table STATS_GIOCATORE_STAGIONE add constraint REF_STATS_CALCI_FK
     foreign key (CF_Calciatore)
     references CALCIATORE(CF);

alter table STORICO_PARTECIPAZIONI add constraint REF_STORI_CALCI
     foreign key (CF_Calciatore)
     references CALCIATORE(CF);

alter table STORICO_PARTECIPAZIONI add constraint REF_STORI_SQUAD_FK
     foreign key (NomeSquadra)
     references SQUADRA(Nome);

alter table STORICO_PARTECIPAZIONI add constraint REF_STORI_STAGI_FK
     foreign key (AnnoCalcistico)
     references STAGIONE(AnnoCalcistico);

alter table UTENTE add constraint ID_UTENT_ACCOU_FK
     foreign key (Username)
     references ACCOUNT(Username);

DELIMITER //

CREATE TRIGGER controllo_marcatore_e_assistman BEFORE INSERT ON GOL
FOR EACH ROW
BEGIN
    DECLARE marcatoreValido BOOLEAN;
    DECLARE assistmanvalido BOOLEAN;

    -- Verifica che il marcatore appartenga alla squadra di casa o ospite
    SELECT COUNT(*) INTO marcatoreValido
    FROM PARTITA
    WHERE PARTITA.AnnoCalcistico = NEW.AnnoCalcistico
    AND PARTITA.TipoCompetizione = NEW.TipoCompetizione
    AND PARTITA.CodiceCompetizione = NEW.CodiceCompetizione
    AND PARTITA.CodicePartita = NEW.CodicePartita
    AND (
        PARTITA.SquadraCasa = (
            SELECT NomeSquadra 
            FROM STORICO_PARTECIPAZIONI 
            WHERE CF_Calciatore = NEW.CF_Marcatore
        )
        OR PARTITA.SquadraOspite = (
            SELECT NomeSquadra 
            FROM STORICO_PARTECIPAZIONI 
            WHERE CF_Calciatore = NEW.CF_Marcatore
        )
    );

    -- Verifica che l'assistman (se non è NULL) appartenga alla squadra di casa o ospite
    IF NEW.CF_Assistman IS NOT NULL THEN
        SELECT COUNT(*) INTO assistmanvalido
        FROM PARTITA
        WHERE PARTITA.AnnoCalcistico = NEW.AnnoCalcistico
        AND PARTITA.TipoCompetizione = NEW.TipoCompetizione
        AND PARTITA.CodiceCompetizione = NEW.CodiceCompetizione
        AND PARTITA.CodicePartita = NEW.CodicePartita
        AND (
            PARTITA.SquadraCasa = (
                SELECT NomeSquadra 
                FROM STORICO_PARTECIPAZIONI 
                WHERE CF_Calciatore = NEW.CF_Assistman
            )
            OR PARTITA.SquadraOspite = (
                SELECT NomeSquadra 
                FROM STORICO_PARTECIPAZIONI 
                WHERE CF_Calciatore = NEW.CF_Assistman
            )
        );
    ELSE
        SET assistmanvalido = 1;  -- Se CF_Assistman è NULL, consideralo valido
    END IF;

    IF marcatoreValido = 0 OR assistmanvalido = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Il marcatore o l\'assistman non appartengono ad una delle due squadre';
    END IF;
END //



CREATE TRIGGER controllo_storico_completo BEFORE INSERT ON STORICO_PARTECIPAZIONI
FOR EACH ROW
BEGIN
    DECLARE esistenti INT;

    -- Conta il numero di stagioni nel database
    SELECT COUNT(*) INTO esistenti 
    FROM STAGIONE;

    -- Verifica che ci sia una riga in STORICO_PARTECIPAZIONI per ogni stagione
    IF (SELECT COUNT(*) FROM STORICO_PARTECIPAZIONI
        WHERE CF_Calciatore = NEW.CF_Calciatore) + 1 <> esistenti THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Ogni calciatore deve avere uno storico partecipazione per ogni stagione disponibile';
    END IF;
END //



DELIMITER ;

-- Index Section
-- _____________ 

create unique index ID_ACCOUNT_IND
     on ACCOUNT (Username);

create unique index ID_AMMIN_ACCOU_IND
     on AMMINISTRATORE (UsernameAmministratore);

create unique index ID_CALCIATORE_IND
     on CALCIATORE (CF);

create unique index ID_COMPETIZIONE_IND
     on COMPETIZIONE (AnnoCalcistico, TipoCompetizione, CodiceCompetizione);

create index REF_COMPE_TIPO__IND
     on COMPETIZIONE (TipoCompetizione);

create unique index ID_CONTRATTO_IND
     on CONTRATTO (CF_Calciatore, DataFirma);

create unique index ID_GOL_IND
     on GOL (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, Minuto);

create index REF_GOL_CALCI_1_IND
     on GOL (CF_Marcatore);

create index REF_GOL_CALCI_IND
     on GOL (CF_Assistman);

create unique index ID_PALMARES_SQUAD_IND
     on PALMARES_SQUAD (NomeSquadra, NomeTrofeo);

create index REF_PAL_S_Trofe_1_IND
     on PALMARES_SQUAD (NomeTrofeo);

create unique index ID_PALMARES_STAGIONE_GIOCATORE_IND
     on PALMARES_STAGIONE_GIOCATORE (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale, NomeTrofeo);

create index REF_PAL_S_Trofe_IND
     on PALMARES_STAGIONE_GIOCATORE (NomeTrofeo);

create unique index ID_PARTECIPAZIONE_IND
     on PARTECIPAZIONE (NomeSquadra, AnnoCalcistico, TipoCompetizione, CodiceCompetizione);

create index REF_PARTE_COMPE_IND
     on PARTECIPAZIONE (AnnoCalcistico, TipoCompetizione, CodiceCompetizione);

create unique index ID_PARTITA_IND
     on PARTITA (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita);

create index REF_PARTI_SQUAD_1_IND
     on PARTITA (SquadraCasa);

create index REF_PARTI_SQUAD_IND
     on PARTITA (SquadraOspite);

create unique index ID_RICHIESTE_IND
     on RICHIESTE (Username, CodiceRichiesta);

create unique index ID_SQUADRA_IND
     on SQUADRA (Nome);

create unique index ID_STAGIONE_IND
     on STAGIONE (AnnoCalcistico);

create unique index ID_STATS_GIOCATORE_PARTITA_IND
     on STATS_GIOCATORE_PARTITA (AnnoCalcistico, TipoCompetizione, CodiceCompetizione, CodicePartita, CF_Calciatore);

create index REF_STATS_CALCI_1_IND
     on STATS_GIOCATORE_PARTITA (CF_Calciatore);

create unique index ID_STATS_GIOCATORE_STAGIONE_IND
     on STATS_GIOCATORE_STAGIONE (AnnoCalcistico, CF_Calciatore, CodiceStatsStagionale);

create index REF_STATS_CALCI_IND
     on STATS_GIOCATORE_STAGIONE (CF_Calciatore);

create unique index ID_STORICO_PARTECIPAZIONI_IND
     on STORICO_PARTECIPAZIONI (CF_Calciatore, AnnoCalcistico, CodiceStorico);

create index REF_STORI_SQUAD_IND
     on STORICO_PARTECIPAZIONI (NomeSquadra);

create index REF_STORI_STAGI_IND
     on STORICO_PARTECIPAZIONI (AnnoCalcistico);

create unique index ID_TIPO_COMPETIZIONE_IND
     on TIPO_COMPETIZIONE (Nome);

create unique index ID_TROFEO_IND
     on TROFEO (NomeTrofeo);

create unique index ID_UTENT_ACCOU_IND
     on UTENTE (Username);

