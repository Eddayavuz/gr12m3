Create table trainers(
trainerID int primary key,
name varchar(50),
email varchar(50)
);

/* FOREIGN KEY CONSTRAINT */
create table sessions(
sessionID int primary key,
trainerID int,
classID int,
memberID int,
FOREIGN KEY (trainerID) REFERENCES trainers(trainerID),
FOREIGN KEY (classID) REFERENCES classes(classID),
FOREIGN KEY (memberID) REFERENCES members(memberID),
date datetime);
