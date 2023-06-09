CREATE DATABASE instructor_directory;
USE instructor_directory;
CREATE TABLE instructor_detail (
 id int(11) NOT NULL AUTO_INCREMENT,
 youtube_channel varchar(128) DEFAULT NULL,
 hobby varchar(45) DEFAULT NULL,
	PRIMARY KEY(id)
) Engine=InnoDB auto_increment=1 charset=utf8mb4;

CREATE TABLE instructor (
	id int(11) NOT NULL AUTO_INCREMENT,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL,
    instructor_detaiL_id int(11) DEFAULT NULL,
    PRIMARY KEY(id),
   KEY FK_DETAIL_idx (instructor_detail_id),
   CONSTRAINT FK_DETAIL FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail(id)
	ON DELETE NO ACTION ON UPDATE NO ACTION
) Engine=InnoDB auto_increment=1 charset=utf8mb4;

CREATE TABLE course(
	id int(11) NOT NULL AUTO_INCREMENT,
    title varchar(128) DEFAULT NULL,
	instructor_id int(11) DEFAULT NULL,
    
    PRIMARY KEY(id),
    UNIQUE KEY TITLE_UNIQUE (title),
    KEY FK_INSTRUCTOR_idx (instructor_id),
    FOREIGN KEY (instructor_id) REFERENCES instructor(id)
) Engine=InnoDb auto_increment=1 charset=utf8mb4;

drop table course;
