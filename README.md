## IFI - TP 5 - GUI - MVC & Templating

### Thi-Ngoc-Anh TRAN, M2-E-Service 2019-2020, Université de Lille

https://juwit.github.io/ifi-2019/cours/05-gui/05-tp-gui.html

![mvc spring](./mvc_spring.png)

#### 1. Projet sur heroku

- Username et mot de passe : 
    + Ash et ash_password
    + Misty et misty_password

- Essayer les URLs suivants dans un navigateur (chrome, firefox, ...): avec une des trainers
    + https://trainer-ui-atr.herokuapp.com/
    + https://trainer-ui-atr.herokuapp.com/pokedex
    + https://trainer-ui-atr.herokuapp.com/trainers
    + https://trainer-ui-atr.herokuapp.com/profile    

- Sur terminal, pour tester POST/PUT/DELETE :
    + Ajouter un trainer `Bug Catcher`, avec 2 pokémons : 12 de niveau 6 et 10 de niveau 6, son username : Bug Catcher et mot de passe : ash_password :

        > curl -X POST https://trainer-api-atr.herokuapp.com/trainers/ -H 'Content-type:application/json' -d '{"name": "Bug Catcher","team": [{"pokemonType": 12, "level": 6},{"pokemonType": 10, "level": 6}],"password":"$2a$10$ny1bjSowICze3PhqV0qTC.t6S11duLPIGY6G26ffxH706VzA0/Ynm"}' -u user:7fab308f-2310-4f7e-b5e3-ffcb3ff556c7

    + Modifier les informations du trainer `Bug Catcher` sur le pokémon 12 de niveau 6 -> niveau 7 et le pokémon 10 de niveau 6 -> niveau 8 :

        > curl -X PUT https://trainer-api-atr.herokuapp.com/trainers/Bug%20Catcher -H 'Content-type:application/json' -d '{"name": "Bug Catcher","team": [{"pokemonType": 12, "level": 7},{"pokemonType": 10, "level": 8}]}'  -u user:7fab308f-2310-4f7e-b5e3-ffcb3ff556c7

    + Supprimer le trainer `Bug Catcher` :

        > curl -X DELETE https://trainer-api-atr.herokuapp.com/trainers/Bug%20Catcher  -u user:7fab308f-2310-4f7e-b5e3-ffcb3ff556c7

#### 2. Configuration de Java 12 sur les postes de l’université
Modifier le fichier ~/.bashrc pour y ajouter les lignes suivantes :

> export JAVA_HOME=/usr/lib/jvm/jdk-12.0.1

> export PATH=$JAVA_HOME/bin:$PATH

### 3. Config url :
Dans config de tomcat : deployement -> application context : mettre /

### 4. Pré-requise : 
- java : version >= 12
- maven : version >= 3

### 5. Execution
- La première vue : http://localhost:9000 