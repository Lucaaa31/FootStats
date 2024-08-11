-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Thu Aug  8 15:10:56 2024 
-- * LUN file: C:\Users\Luca\Desktop\FootballStats\FootStats.lun 
-- * Schema: logico/SQL 
-- ********************************************* 


-- Database Section
-- ________________ 

create database logico;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table ACCOUNT (
     Nome char(1) not null,
     Cognome char(1) not null,
     Username char(1) not null,
     Email char(1) not null,
     Password char(1) not null,
     constraint ID_ACCOUNT_ID primary key (Username));

create table AMMINISTRATORE (
     Username char(1) not null,
     constraint FKTIPO_ADMIN_ID primary key (Username));

create table CALCIATORE (
     Nome char(1) not null,
     Cognome char(1) not null,
     CF char(1) not null,
     Data_di_nascita numeric(1) not null,
     Altezza numeric(1) not null,
     Luogo_di_nascita char(1) not null,
     Piede_preferito char(1) not null,
     constraint ID_CALCIATORE_ID primary key (CF));

create table COMPETIZIONE (
     AnnoCalcistico char(1) not null,
     Nome char(1) not null,
     codiceCompetizione char(1) not null,
     constraint ID_COMPETIZIONE_ID primary key (AnnoCalcistico, Nome, codiceCompetizione));

create table CONTRATTO (
     CF char(1) not null,
     DataFirma char(1) not null,
     Durata char(1) not null,
     Valore char(1) not null,
     constraint ID_CONTRATTO_ID primary key (CF, DataFirma));

create table GOL (
     COM_AnnoCalcistico char(1) not null,
     COM_Nome char(1) not null,
     COM_codiceCompetizione char(1) not null,
     codicePartita char(1) not null,
     Marcatore char(1) not null,
     Minuto char(1) not null,
     Assistman char(1) not null,
     constraint ID_GOL_ID primary key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita, Marcatore, Minuto, Assistman));

create table PAL_SQUAD (
     Nome char(1) not null,
     NomeTrofeo char(1) not null,
     constraint ID_PAL_SQUAD_ID primary key (NomeTrofeo, Nome));

create table PAL_STAGIONE (
     AnnoCalcistico char(1) not null,
     CF char(1) not null,
     CodiceStatsStagionale char(1) not null,
     NomeTrofeo char(1) not null,
     constraint ID_PAL_STAGIONE_ID primary key (NomeTrofeo, AnnoCalcistico, CF, CodiceStatsStagionale));

create table PARTECIPAZIONE (
     P_C_AnnoCalcistico char(1) not null,
     P_C_Nome char(1) not null,
     P_C_codiceCompetizione char(1) not null,
     Nome char(1) not null,
     Piazzamento char(1) not null,
     constraint ID_PARTECIPAZIONE_ID primary key (P_C_AnnoCalcistico, P_C_Nome, P_C_codiceCompetizione, Nome));

create table PARTITA (
     COM_AnnoCalcistico char(1) not null,
     COM_Nome char(1) not null,
     COM_codiceCompetizione char(1) not null,
     codicePartita char(1) not null,
     Data date not null,
     Stadio char(1) not null,
     Ora numeric(1) not null,
     Nome char(1) not null,
     CAS_Nome char(1) not null,
     constraint ID_PARTITA_ID primary key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita));

create table RICHIESTE (
     Username char(1) not null,
     CodiceRichiesta -- Sequence attribute not implemented -- not null,
     Tipologia char(1) not null,
     Descrizione char(1) not null,
     constraint ID_RICHIESTE_ID primary key (Username, CodiceRichiesta));

create table SQUADRA (
     Nome char(1) not null,
     Nazione char(1) not null,
     TipoSquadra char not null,
     Record_goal numeric(1) not null,
     Record_Presenze numeric(1) not null,
     constraint ID_SQUADRA_ID primary key (Nome));

create table STAGIONE (
     AnnoCalcistico char(1) not null,
     constraint ID_STAGIONE_ID primary key (AnnoCalcistico));

create table STATS_GIOCATORE_PARTITA (
     COM_AnnoCalcistico char(1) not null,
     COM_Nome char(1) not null,
     COM_codiceCompetizione char(1) not null,
     codicePartita char(1) not null,
     CF char(1) not null,
     CodiceStatsPartita char(1) not null,
     Goal char(1) not null,
     Assist char(1) not null,
     Cartellini numeric(1) not null,
     SOM_AnnoCalcistico char(1) not null,
     SOM_CF char(1) not null,
     SOM_CodiceStatsStagionale char(1) not null,
     constraint ID_STATS_GIOCATORE_PARTITA_ID primary key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita, CF, CodiceStatsPartita));

create table STATS_GIOCATORE_STAGIONE (
     AnnoCalcistico char(1) not null,
     CF char(1) not null,
     CodiceStatsStagionale char(1) not null,
     Goal_stagionali numeric(1) not null,
     Assist_stagionali numeric(1) not null,
     Valore_di_mercato numeric(1) not null,
     Presenze numeric(1) not null,
     Numero_maglia numeric(1),
     Cartellini_stagionali char(1) not null,
     Ruolo char(1),
     constraint ID_STATS_GIOCATORE_STAGIONE_ID primary key (AnnoCalcistico, CF, CodiceStatsStagionale));

create table STORICO_PARTECIPAZIONI (
     CF char(1) not null,
     AnnoCalcistico char(1) not null,
     CodiceStorico char(1) not null,
     Nome char(1),
     constraint ID_STORICO_PARTECIPAZIONI_ID primary key (CF, AnnoCalcistico, CodiceStorico));

create table TIPO_COMPETIZIONE (
     Nome char(1) not null,
     Descrizione_ char(1) not null,
     Numero_partecipanti numeric(1) not null,
     constraint ID_TIPO_COMPETIZIONE_ID primary key (Nome));

create table Trofeo (
     NomeTrofeo char(1) not null,
     Quantita char(1) not null,
     constraint ID_Trofeo_ID primary key (NomeTrofeo));

create table UTENTE (
     Username char(1) not null,
     Targhetta char(1),
     constraint FKTIPO_USER_ID primary key (Username));


-- Constraints Section
-- ___________________ 

alter table AMMINISTRATORE add constraint FKTIPO_ADMIN_FK
     foreign key (Username)
     references ACCOUNT;

alter table COMPETIZIONE add constraint ID_COMPETIZIONE_CHK
     check(exists(select * from PARTITA
                  where PARTITA.COM_AnnoCalcistico = AnnoCalcistico and PARTITA.COM_Nome = Nome and PARTITA.COM_codiceCompetizione = codiceCompetizione)); 

alter table COMPETIZIONE add constraint FKCATEGORIZZAZIONE_FK
     foreign key (Nome)
     references TIPO_COMPETIZIONE;

alter table COMPETIZIONE add constraint FKCALENDARIZZAZIONE
     foreign key (AnnoCalcistico)
     references STAGIONE;

alter table CONTRATTO add constraint FKSTIPENDIO
     foreign key (CF)
     references CALCIATORE;

alter table GOL add constraint FKMARCATORE
     foreign key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita)
     references PARTITA;

alter table PAL_SQUAD add constraint FKPAL_Tro_1
     foreign key (NomeTrofeo)
     references Trofeo;

alter table PAL_SQUAD add constraint FKPAL_SQU_FK
     foreign key (Nome)
     references SQUADRA;

alter table PAL_STAGIONE add constraint FKPAL_Tro
     foreign key (NomeTrofeo)
     references Trofeo;

alter table PAL_STAGIONE add constraint FKPAL_STA_FK
     foreign key (AnnoCalcistico, CF, CodiceStatsStagionale)
     references STATS_GIOCATORE_STAGIONE;

alter table PARTECIPAZIONE add constraint FKPAR_SQU_FK
     foreign key (Nome)
     references SQUADRA;

alter table PARTECIPAZIONE add constraint FKPAR_COM
     foreign key (P_C_AnnoCalcistico, P_C_Nome, P_C_codiceCompetizione)
     references COMPETIZIONE;

alter table PARTITA add constraint FKOSPITE_FK
     foreign key (Nome)
     references SQUADRA;

alter table PARTITA add constraint FKCASA_FK
     foreign key (CAS_Nome)
     references SQUADRA;

alter table PARTITA add constraint FKCOMPOSIZIONE
     foreign key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione)
     references COMPETIZIONE;

alter table RICHIESTE add constraint FKINVIO
     foreign key (Username)
     references UTENTE;

alter table STATS_GIOCATORE_PARTITA add constraint FKOTTENERE_FK
     foreign key (CF)
     references CALCIATORE;

alter table STATS_GIOCATORE_PARTITA add constraint FKSOMMA_FK
     foreign key (SOM_AnnoCalcistico, SOM_CF, SOM_CodiceStatsStagionale)
     references STATS_GIOCATORE_STAGIONE;

alter table STATS_GIOCATORE_PARTITA add constraint FKCONTENERE
     foreign key (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita)
     references PARTITA;

alter table STATS_GIOCATORE_STAGIONE add constraint FKPOSSEDERE_FK
     foreign key (CF)
     references CALCIATORE;

alter table STATS_GIOCATORE_STAGIONE add constraint FKPERFORMANCE
     foreign key (AnnoCalcistico)
     references STAGIONE;

alter table STORICO_PARTECIPAZIONI add constraint FKSTR_STAGIONE_FK
     foreign key (AnnoCalcistico)
     references STAGIONE;

alter table STORICO_PARTECIPAZIONI add constraint FKSTR_SQUADRA_FK
     foreign key (Nome)
     references SQUADRA;

alter table STORICO_PARTECIPAZIONI add constraint FKSTR_CALCIATORE
     foreign key (CF)
     references CALCIATORE;

alter table UTENTE add constraint FKTIPO_USER_FK
     foreign key (Username)
     references ACCOUNT;


-- Index Section
-- _____________ 

create unique index ID_ACCOUNT_IND
     on ACCOUNT (Username);

create unique index FKTIPO_ADMIN_IND
     on AMMINISTRATORE (Username);

create unique index ID_CALCIATORE_IND
     on CALCIATORE (CF);

create unique index ID_COMPETIZIONE_IND
     on COMPETIZIONE (AnnoCalcistico, Nome, codiceCompetizione);

create index FKCATEGORIZZAZIONE_IND
     on COMPETIZIONE (Nome);

create unique index ID_CONTRATTO_IND
     on CONTRATTO (CF, DataFirma);

create unique index ID_GOL_IND
     on GOL (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita, Marcatore, Minuto, Assistman);

create unique index ID_PAL_SQUAD_IND
     on PAL_SQUAD (NomeTrofeo, Nome);

create index FKPAL_SQU_IND
     on PAL_SQUAD (Nome);

create unique index ID_PAL_STAGIONE_IND
     on PAL_STAGIONE (NomeTrofeo, AnnoCalcistico, CF, CodiceStatsStagionale);

create index FKPAL_STA_IND
     on PAL_STAGIONE (AnnoCalcistico, CF, CodiceStatsStagionale);

create unique index ID_PARTECIPAZIONE_IND
     on PARTECIPAZIONE (P_C_AnnoCalcistico, P_C_Nome, P_C_codiceCompetizione, Nome);

create index FKPAR_SQU_IND
     on PARTECIPAZIONE (Nome);

create unique index ID_PARTITA_IND
     on PARTITA (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita);

create index FKOSPITE_IND
     on PARTITA (Nome);

create index FKCASA_IND
     on PARTITA (CAS_Nome);

create unique index ID_RICHIESTE_IND
     on RICHIESTE (Username, CodiceRichiesta);

create unique index ID_SQUADRA_IND
     on SQUADRA (Nome);

create unique index ID_STAGIONE_IND
     on STAGIONE (AnnoCalcistico);

create unique index ID_STATS_GIOCATORE_PARTITA_IND
     on STATS_GIOCATORE_PARTITA (COM_AnnoCalcistico, COM_Nome, COM_codiceCompetizione, codicePartita, CF, CodiceStatsPartita);

create index FKOTTENERE_IND
     on STATS_GIOCATORE_PARTITA (CF);

create index FKSOMMA_IND
     on STATS_GIOCATORE_PARTITA (SOM_AnnoCalcistico, SOM_CF, SOM_CodiceStatsStagionale);

create unique index ID_STATS_GIOCATORE_STAGIONE_IND
     on STATS_GIOCATORE_STAGIONE (AnnoCalcistico, CF, CodiceStatsStagionale);

create index FKPOSSEDERE_IND
     on STATS_GIOCATORE_STAGIONE (CF);

create unique index ID_STORICO_PARTECIPAZIONI_IND
     on STORICO_PARTECIPAZIONI (CF, AnnoCalcistico, CodiceStorico);

create index FKSTR_STAGIONE_IND
     on STORICO_PARTECIPAZIONI (AnnoCalcistico);

create index FKSTR_SQUADRA_IND
     on STORICO_PARTECIPAZIONI (Nome);

create unique index ID_TIPO_COMPETIZIONE_IND
     on TIPO_COMPETIZIONE (Nome);

create unique index ID_Trofeo_IND
     on Trofeo (NomeTrofeo);

create unique index FKTIPO_USER_IND
     on UTENTE (Username);

