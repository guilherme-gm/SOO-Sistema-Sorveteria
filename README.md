# SOO-Sistema-Sorveteria
Sistema de Sorveteria utilizando AspectJ para disciplina de Sistemas Orientados a Objetos

# Grupo
* Guilherme Guiguer Menaldo (@guilherme-gm)
* Jhenifer Marques Santos (@Jhenii01)
* Juliano Marcel Salgueiro (@julianoms)

# Pré-requisitos
1. Eclipse IDE ( https://www.eclipse.org/ )
2. Apache Tomcat (normalmente no Windows está em `C:/Program Files/Apache Software Foundation/tomcat/apache-tomcat-xxxxx/`)
3. MySQL
4. MySQL Workbench
5. Plugin AspectJ Development Tools ( https://www.eclipse.org/ajdt/ ) (Ver próxima seção)

# Instalação do Plugin
1. Acessar o site do AspectJ Development Tools (AJDT) -- https://www.eclipse.org/ajdt/
2. Vá em `Downloads`
3. Procure a versão compatível com seu Eclipse
4. Copie o link de update
5. No Eclipse, vá em `Help` > `Install New Software`
6. Coloque o link copiado do site do AJDT
7. Espere carregar e selecione os 3 pacotes
8. Clique em `Next`, `Next`, aceita a licença de uso
9. Espere instalar e reinicie o Eclipse

# Instalação do Sistema

1. Baixe o repositório
2. Importe o banco de dados em `docs/MER.mwb`
3. Abra o eclipse
4. Escolha a pasta do repositório como workspace
5. Vá em `File` > `Open Project from File System`
6. Clique em `Directory` e escolha a pasta do projeto (`Sorveteria`)
7. Clique em `Finish`
8. Clique com o direito sobre o projeto, vá em `Maven` > `Update Project`
9. Vá em `File` > `New` > `Other` procure `Server` e clique em `Next`
10. Escolha o `Apache Tomcat` na versão que você possui
11. Clique em  `Next`
12. Clique em `Browse` e busque a pasta do tomcat
13. Clique em `Next` e mova o projeto `Sorveteria` para o painel da direita
14. Clique em `Finish`
15. Clique com o direito no projeto `Sorveteria`
16. Clique em `Properties`
17. Procure `Targeted Runtimes`
18. Marque a versão do tomcat que você está usando e selecione-a
19. Clique em `Apply And Close`
20. Inicie o projeto no botão de `Run`

