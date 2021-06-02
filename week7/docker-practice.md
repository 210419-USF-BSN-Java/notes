## *Running* `nsnake` *Container in an EC2* 

1. SSH into an EC2 instance.  You will only need 1 security rule which is supplied to you by default (SSH port 20).

2. Once you've ssh's in, run the following commands:

``` sh
# Install Docker
sudo yum install docker
# Create a group of users within your EC@ instance with Docker permissions
sudo groupadd docker
sudo usermod -a -G docker ec2-user
sudo service docker start
# Make a folder to contain your Dockerfile -> cd into it
mkdir snakedocker
cd snakedocker
# Use the nano command to open up a text editor
nano Dockerfile
# The following commands go inside your Dockerfile
# FROM specifies the base image, running an ubuntu OS
FROM ubuntu:18.04
# RUN specifies the duty of the container.  It should install this software
RUN apt-get update && apt-get install -y libncurses5-dev && apt-get install -y nsnake
# CMD specifies the instruction that is to be executed when a Docker container starts
# In this case, we are running the executable located at /usr/games/nsnake within the nginx container
CMD ["/usr/games/nsnake"]
```

3. Exit the `nano` text editor with the keyboard commands `ctrl` + `X`, then press `Y` to save.

4. Build the image from the `Dockerfile` with the following command: 
    >`sudo docker build -t snake:auto .`
    
5. Finally, run the image with the following command and you'll load up the game thanks to the `CMD` command.
    >`sudo docker run -it snake:auto` <br>
        the `-it` flag allows you to interact with the executable file, which, in this case, is the game itself.
<br>

<hr>

<br>

## How to `Dockerize` an Angular app 🦸

1. Open an angular application in VScode.

2. Create a new file (directly in the Angular application's directory) called `Dockerfile`
    > The file must be titled `Dockerfile` *exactly*, with no extensions.
3. Create a distribution directory which will hold all of the files to be deployed on nginx. Inside your application, run the following command:
    > `ng build`
    
4. Within this file, write the following code:
```sh
# FROM specifies the base image (also called the parent image).  In this case we will use Ubuntu OS
FROM nginx:1.17.1-alpine
# Copy all files from the dist directory to the directory where ngix hosts the files to serve at a specified port
COPY dist/[app-name] /usr/share/nginx/html
```

5. Build an image from the Dockerfile with the following command: <br>
    > `docker build -t [app-name]:latest .`
6. Create a command by running the imamge on port 80 with the following command. <br>
    > `docker run -p 80:80 -d --name [container-name]  [app-name]:latest`
<br>

<hr>

<br>

## PostgreSQL on Docker

To run a simple Postgres server instance:
>docker run -e POSTGRES_PASSWORD password -p [port]:5432 postgres
Where [port] is your choice of port. A common port is 5432, a default for many Postgres databases:
>docker run -e POSTGRES_PASSWORD password -p 5432:5432 postgres
To run a database as a background process, use the `-d` switch:
>docker run -e POSTGRES_PASSWORD password -d -p 5432:5432 postgres
It's a good idea to label a database with the `--name` switch:
>docker run -e POSTGRES_PASSWORD password -d --name my_postgres -p 5432:5432 postgres
To see running containers, use:
>docker ps
To stop a container, run:
>docker stop <CONTAINER-NAME-OR-ID>
### Running PostgreSQL from a Dockerfile
To create a custom postgres database, create a file named `Dockerfile`:
```Dockerfile
FROM postgres:10
ENV POSTGRES_USER hello-postgres
ENV POSTGRES_PASSWORD hello-postgres
ADD init.sql /docker-entrypoint-initdb.d
EXPOSE 5432
```

Where init.sql is an optional `.sql` script file in the same directory as your Dockerfile. Use `ENV` to set the username and password as needed. Both `ENV` lines can be omitted, causing the username to default to `postgres` and no password required.

To build an image from the Dockerfile:
>docker build -t demo-postgres .
Where `demo-postgres` is the name you wish to give this image. Then to run the build:
>docker run -p 5432:5432 -d demo-postgres
Remember to expose the ports and use any desired flags.

### Connecting to a Docker PostgreSQL database with `psql`
With your Docker postgres image built and a container running, use `docker exec` to run the `psql` tool on the running container:
>docker exec -it demo-postgres psql -U hello-postgres
Enter your Postgres username after `-U` (`postgres` by default if no `POSTGRES_USER` was set) and enter your password when prompted.