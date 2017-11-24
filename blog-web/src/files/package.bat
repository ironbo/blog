D:
cd D:\git\blog\blog-web
rem call mvn clean install z-Dmaven.linux.skip=true 
call mvn clean package -Plinux
rem mvn clean package