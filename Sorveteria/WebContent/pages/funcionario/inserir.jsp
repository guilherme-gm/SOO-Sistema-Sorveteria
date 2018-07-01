<h2>Inserir Funcionário</h2>
<form method="POST" action="#">
	<div class="form-group">
		<label for="cpf">CPF</label> <input type="text" class="form-control"
			name="cpf" id="cpf" placeholder="CPF" value="">
	</div>
	<div class="form-group">
		<label for="nome">Nome</label> <input type="text" class="form-control"
			name="nome" id="nome" placeholder="Nome" value="">
	</div>
	<div class="form-group">
		<label for="dataNascimento">Data Nascimento</label> <input type="date"
			class="form-control" name="dataNascimento" id="dataNascimento"
			placeholder="Data Nascimento" value="">
	</div>

	<div class="form-group">
		<label for="cargo">Cargo</label> <select name="cargo" id="cargo"
			class="form-control">
			<option value="VENDEDOR">Vendedor</option>
			<option value="GERENTE">Gerente</option>
		</select>
	</div>

	<div class="form-group">
		<h2>Endereço</h2>
	</div>
	<div class="form-group">
		<label for="cep">CEP</label> <input type="text" class="form-control"
			name="cep" id="cep" placeholder="CEP" value="">
	</div>
	<div class="form-group">
		<label for="rua">Rua</label> <input type="text" class="form-control"
			name="rua" id="rua" placeholder="Rua" value="">
	</div>
	<div class="form-group">
		<label for="numero">Número</label> <input type="text"
			class="form-control" name="numero" id="numero" placeholder="Número"
			value="">
	</div>
	<div class="form-group">
		<label for="cidade">Cidade</label> <input type="text"
			class="form-control" name="cidade" id="cidade" placeholder="Cidade"
			value="">
	</div>
	<div class="form-group">
		<label for="estado">Estado</label> <input type="text"
			class="form-control" name="estado" id="estado" placeholder="Estado"
			value="">
	</div>
	<div class="form-group">
		<h2>Contato</h2>
	</div>

	<div class="form-group">
		<label for="telefone">Telefone</label> <input type="text"
			class="form-control" name="telefone" id="telefone"
			placeholder="Telefone" value="">
	</div>
	<div class="form-group">
		<label for="celular">Celular</label> <input type="text"
			class="form-control" name="celular" id="celular"
			placeholder="Celular" value="">
	</div>
	<div class="form-group">
		<label for="email">E-mail</label> <input type="text"
			class="form-control" name="email" id="email" placeholder="E-mail"
			value="">
	</div>

	<h2>Acesso</h2>
	<div class="form-group">
		<label for="usuario">Usuário</label> <input type="text"
			class="form-control" name="usuario" id="usuario"
			placeholder="Usuário" value="">
	</div>
	<div class="form-group">
		<label for="senha">Senha</label> <input type="password"
			class="form-control" name="senha" id="senha" placeholder="Senha"
			value="">
	</div>

	<button type="reset" class="btn btn-primary">Limpar</button>
	<button type="submit" class="btn btn-primary">Inserir</button>
</form>