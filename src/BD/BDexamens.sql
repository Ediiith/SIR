CREATE TABLE examens (
    idExamen VARCHAR(30),
    idDMR VARCHAR(30),
    dateExamen VARCHAR(30),
    idResponsable VARCHAR(30),
    typeExamen VARCHAR(30),
    compteRendu VARCHAR(3000),
    lienPACS VARCHAR(3000),
    PRIMARY KEY (idExamen),
    FOREIGN KEY (idDMR) REFERENCES dmr(idDMR),
    FOREIGN KEY (idResponsable) REFERENCES personnel(idPersonnel)
)
