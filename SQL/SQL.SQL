

CREATE TABLE document
(
     id SERIAL NOT NULL ,
    titre character varying(255) NOT NULL,
    auteur character varying(255)  NOT NULL,
    date_publication date NOT NULL,
    nombre_de_pages integer NOT NULL,
    type typedocument NOT NULL,
    status boolean NOT NULL DEFAULT false,
    CONSTRAINT document_pkey PRIMARY KEY (id)
)


CREATE TABLE journal_scientifique
(
    domainerecherche character varying(255) ,
    CONSTRAINT journal_scientifique_pkey PRIMARY KEY (id)
)
    INHERITS (document);

 CREATE TABLE livre
(
    isbn character varying(255),
    CONSTRAINT livre_pkey PRIMARY KEY (id)
)
    INHERITS (document);



CREATE TABLE magazine
(

    numero integer,
    CONSTRAINT magazine_pkey PRIMARY KEY (id)
)
    INHERITS (document)

CREATE TABLE these_universitaire
(
    "université" character varying(255) ,
    CONSTRAINT these_universitaire_pkey PRIMARY KEY (id)
)
    INHERITS (document)



CREATE TABLE utilisateurs
(
    id SERIAL NOT NULL,
    nom VARCHAR(255) NOT NULL,
    typeuser VARCHAR(50) NOT NULL,
    date_inscription DATE NOT NULL,
    CONSTRAINT utilisateurs_pkey PRIMARY KEY (id)
);
CREATE TABLE professeur
(
    idmassarprof character varying(255) ,
    CONSTRAINT professeur_pkey PRIMARY KEY (idmassarprof)
)
    INHERITS (utilisateurs)
    
CREATE TABLE etudiant
(
    id_massar character varying(255)  NOT NULL,
    CONSTRAINT etudiant_pkey PRIMARY KEY (id_massar)
)
    INHERITS (utilisateurs);

CREATE TABLE emprunt
(
    id_document integer,
    id_utilisateur integer,
    date_emprunt date NOT NULL,
    date_retour date,
    reservation_status boolean DEFAULT false,
    emprunt_status boolean DEFAULT false,
    id integer NOT NULL DEFAULT ,
    CONSTRAINT emprunt_pkey PRIMARY KEY (id)
)

