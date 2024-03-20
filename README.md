# Upvote Projekt

Az Upvote Projekt egy olyan webalkalmazás, aminek a segítségével regisztrált szavazóként ötleteket
tudunk beküldeni, ami majd az admin jóváhagyása után bekerül az ötlet listába, továbbá tudunk szavazni a már jóváhagyottakra.

Két szerepkört tartalmaz, melyek az alábbi funkciókat érik el:

### Szavazó(Voter)
* Regisztráció
* Bejelentkezés/Kijelentkezés
* Ötlet beküldése
* Ötletekre tud szavazni(csak egyszer)

### Admin(Admin)
* Bejelentkezés/Kijelentkezés
* Ötletek jóváhagyása/elutasítása
* Jóváhagyott ötletek megtekintése, szavazás nyomonkövetése


### Használt eszközök
* Java 17
* Maven
* Spring Boot
* JPA
* PostgreSQL
* Angular 16 Typescript

### Docker telepítése
Windows:

* https://aka.ms/wsl2kernel (1.-5. pontig)
* https://docs.docker.com/docker-for-windows/install/
* https://docs.docker.com/docker-for-windows/wsl/ (3. pont) -> (https://docs.docker.com/desktop/windows/images/wsl2-enable.png)


Linux:

* https://docs.docker.com/engine/install/ubuntu/

MAC OS:

* https://docs.docker.com/desktop/mac/apple-silicon/

### Konténer létrehozása

* docker run --name upvote-db -e POSTGRES_PASSWORD=test1234 -d postgres

### Frontend elindítása

* npm install -g @angular/cli
* ng serve
* alapértelmezett URL: http://localhost:4200

### Swagger dokumentáció

* Az alkalmazás elindítása után elérhető a swagger api dokumentáció http://localhost:8080/swagger-ui/ oldalon.
* Illetve az api leíró pedig a főknyvtárban "api.yml" néven