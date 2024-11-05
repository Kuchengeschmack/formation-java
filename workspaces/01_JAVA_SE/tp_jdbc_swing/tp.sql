create table client (
num_client int primary key, 
nom varchar(50), 
prenom varchar(50), 
adresse varchar(50), 
code_postal int, 
ville varchar(50), 
num_telephone int);

create table compte_courant (num_compte int primary key, 
solde double, 
num_client int, 
foreign key (num_client) 
references client (num_client));

create table compte_epargne (num_compte int primary key, 
solde double, 
num_client int, 
foreign key (num_client) references client (num_client));

select * from client;
select * from compte_courant;
select * from compte_epargne;