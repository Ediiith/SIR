CREATE TABLE examens (
    idExamen VARCHAR(20),
    idDMR VARCHAR(20),
    dateExamen VARCHAR(20),
    idResponsable VARCHAR(20),
    typeExamen VARCHAR(20),
    compteRendu VARCHAR(20),
    lienPACS VARCHAR(20),
    PRIMARY KEY (idExamen),
    FOREIGN KEY (idDMR) REFERENCES dmr(idDMR),
    FOREIGN KEY (idResponsable) REFERENCES personnel(idPersonnel)
)
