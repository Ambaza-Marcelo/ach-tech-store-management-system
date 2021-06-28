//creation de la base de donnees gestionsociete
create database gestion_societe;
/*
 * creation de la table client
 */
create table client(
	clientID int primary key auto_increment,
	nom varchar(20),
	prenom varchar(20),
	adresse varchar(100),
	telephone varchar(15),
	produitID int(6) not null,
	/*
	 * la cle etrangere
	 */
	foreign key client(produitID) references produit(produitID)
)ENGINE="innodb";

/*
 * creation de la table produit
 */
create table produit(
	produitID int primary key auto_increment,
	nom varchar(50),
	prix_unitaire int,
	quantite int
)ENGINE="innodb";
/*
 * table achat
 */
create table achat(
	achatID int primary key auto_increment,
	description varchar(255)
)ENGINE="innodb";
/*
 * craetion de la table vente
 */
create table vente(
	venteID int primary key auto_increment,
	description varchar(255)
)ENGINE="innodb";