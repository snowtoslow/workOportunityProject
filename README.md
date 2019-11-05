# workOportunityProject
An application which is capable to manage a blog 


1)dataBaseInfo: mysql; username: vovaUniversal, password: password;
  
  1.2)Script to create DB : IS ATACHED IN REPO WITH NAME -> scriptofBlogDB.sql.tx
  
 
  

2)Basci auth:

username -> vovaUniversal
password -> password

3)Requests:
port : 8080
URL:localhost:8080
    1./users
    2./comments
    3./post
    
    3.1) Mappings: 
    GET --> USE TO GET INFO ABOUT ALL USER/POSTS/COMMENTS OR TO GET INFO ABOUT SPECIFIC USER/POST/COMMENT BY ID;
    POST --> CREATE USER/POST/COMMENT;
    PUT --> UPDATE USER/POST/COMMENT;
    DELETE --. DELETE USER/POST/COMMENT;




for DB:

1) test script for user:
INSERT INTO user
VALUES (1,'dsvssds','dsvsdvsdvs','dvsvsgsdgsdgsdsc','svdasaawewe','asqeqwrqwr','ONLINE');


2)test script for post:
INSERT INTO user
VALUES (2,'dsvssds','dsvsdvsdvs','dvsvsgsdgsdgsdsc','svdasaawewe','asqeqwrqwr','ONLINE');

3)test script for comment:
INSERT INTO comment
values (1,'2019-10-15',1,1,1);
