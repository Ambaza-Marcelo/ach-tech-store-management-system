create database gestion_societe;

create table client(
	clientID int primary key auto_increment,
	nom varchar(20),
	prenom varchar(20),
	adresse varchar(100),
	telephone varchar(15),
	produitID int(6) not null,
	
	foreign key client(produitID) references produit(produitID)
)ENGINE="innodb";


create table produit(
	produitID int primary key auto_increment,
	nom varchar(50),
	prix_unitaire int,
	quantite int
)ENGINE="innodb";

create table achat(
	achatID int primary key auto_increment,
	description varchar(255)
)ENGINE="innodb";

create table vente(
	venteID int primary key auto_increment,
	description varchar(255)
)ENGINE="innodb";