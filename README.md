# Sistema - Pinguim Sorvetes
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
3. Execute o script `cria_usuario.sql` da pasta `docs` no banco de dados importado
4. Abra o eclipse
5. Escolha a pasta do repositório como workspace
6. Vá em `File` > `Open Project from File System`
7. Clique em `Directory` e escolha a pasta do projeto (`Sorveteria`)
8. Clique em `Finish`
9. Clique com o direito sobre o projeto, vá em `Maven` > `Update Project`
10. Vá em `File` > `New` > `Other` procure `Server` e clique em `Next`
11. Escolha o `Apache Tomcat` na versão que você possui
12. Clique em  `Next`
13. Clique em `Browse` e busque a pasta do tomcat
14. Clique em `Next` e mova o projeto `Sorveteria` para o painel da direita
15. Clique em `Finish`
16. Clique com o direito no projeto `Sorveteria`
17. Clique em `Properties`
18. Procure `Targeted Runtimes`
19. Marque a versão do tomcat que você está usando e selecione-a
20. Clique em `Apply And Close`
21. Configure a senha do MySQL na interface em `br.unesp.rc.pinguim.utils.IMySQL.java`
22. Inicie o projeto no botão de `Run`

# Usuário padrão (gerente)
* Nome de Usuário: gerente
* Senha: gerente
