CREATE TABLE dmr (
    idDMR VARCHAR(30),
    nomPatient VARCHAR(30),
    prenomPatient VARCHAR(30),
    dateNaissance VARCHAR(30),
    genre VARCHAR(30),
    adresse VARCHAR(300),
    numSS VARCHAR(30),
    estAdmis VARCHAR(30),
    temporaire VARCHAR(30),
    PRIMARY KEY (idDMR, numSS)
)