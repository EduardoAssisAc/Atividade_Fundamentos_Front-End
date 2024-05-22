//Exemplo de evento 
/* let botao = document.querySelector('a#add');
botao.addEventListener('click', funcaoA);
botao.addEventListener('click', funcaoB);

function funcaoA() {
    alert('A');
}
function funcaoB() {
    alert('B');
} */

// Altera o tema quando mudar a opção selecionada
let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado) {
        mudaTema(temaSelecionado);
        // Salva a opção de tema escolhida pelo usuário no localStorage
        localStorage.setItem('tema', temaSelecionado);
    }
});

// Altera o tema o arquivo CSS de acordo com o tema selecionado
const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    //console.log(linkTema);
    let url = "/css/estilo-tema-" + temaSelecionado + ".css";
    linkTema.href = url;
}

// Recupera a opção de tema escolhida pelo usuário e
// altera o tema se houver uma opção salva no localStorage
let tema = localStorage.getItem('tema');
if (tema) {
    mudaTema(tema);
}

let totalRegistrosSpan = document.getElementById('total-registros');
// Função para atualizar o numero no rodapé da pagina
const atualizarRodape = () => {
    let totalRegistros = tabela.tBodies[0].rows.length;
    totalRegistrosSpan.textContent = totalRegistros;
}

//Função que carrega dados dos profissionais a partir de um objeto JSON
const carregarConvenios = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/convenios";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        for (const item of dados) {
            inserirConvenio(item);
        }
        atualizarRodape();
        eventoExcluir();
    }).catch(erro => {
        console.error(erro);
    });
    /* let xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            dados = JSON.parse(xhr.responseText);
            //console.log(dados);
            for (const item of dados) {
                //Criando os elementos HTML
                let linha = document.createElement('tr');
                let id = document.createElement('td');
                let nome = document.createElement('td');
                let registroConselho = document.createElement('td');
                let telefone = document.createElement('td');
                let email = document.createElement('td');
                let unidade = document.createElement('td');
                let especialidade = document.createElement('td');
                let acoes = document.createElement('td');
                //Preencher os elementos
                id.textContent = item.id;
                nome.textContent = item.nome;
                registroConselho.textContent = item.registro;
                telefone.textContent = item.telefone;
                email.textContent = item.email;
                unidade.textContent = item.unidade;
                especialidade.textContent = item.especialidade;
                acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
                //Preencher a linha
                linha.appendChild(id);
                linha.append(nome);
                linha.appendChild(registroConselho);
                linha.appendChild(email);
                linha.appendChild(telefone);
                linha.appendChild(unidade);
                linha.appendChild(especialidade);
                linha.appendChild(acoes);
                //Preencher a tabela com uma linha
                tabela.tBodies[0].appendChild(linha);
            }
        }
        eventoExcluir();
    });
    xhr.send(); */
};
carregarConvenios();

let rodapeTabela = document.querySelector('td.rodape');
let tabela = document.querySelector('table');

//Função para excluir um profissional
const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes) {
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            atualizarRodape();
        });
    };
};

let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');

//Adiciona o evento de click ao botao Adicionar
botaoAdicionar.addEventListener('click', () => {
    form.classList.remove('inativo');
    botaoAdicionar.classList.replace('botao','botao-inativo')  //ATIVIDADE 2: Muda o botão adicionar para inativo quando abrir o formulário

});

//Adiciona o evento de click ao botao Cancelar
botaoCancelar.addEventListener('click', () => {
    form.classList.add('inativo');
    form.reset();
    botaoAdicionar.classList.replace('botao-inativo','botao') //ATIVIDADE 2: Muda o botão adicionar para ativo quando cancela o formulário
})

//Adicionar um funcionamento para enviar os dados do form para a tabela
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); //Evita que a página seja recarregada
    let profissional = { //Cria um objeto com os dados do form
        id: tabela.tBodies[0].rows.length + 1,
        ativo: true,
        cnpj: form.cnpj.value,
        email: form.email.value,
        nome: form.nome.value,
        razao_social: form.razao_social.value,
        representante: form.representante.value,
        telefone: form.telefone.value,
    };
    //console.log(profissional);
    inserirConvenio(profissional); //insere o profissional na tabela
    form.reset(); //Limpa os campos do form
    botaoAdicionar.classList.replace('botao-inativo','botao')  //ATIVIDADE 2: Muda o botão adicionar para ativo quando cancela o formulário
    form.classList.add('inativo'); //Esconde o form
    eventoExcluir(); //Adiciona o evento de excluir ao botao criado ao inserir nova linha na tabela
    rodapeTabela.innerHTML = 'Total de registros: ' + tabela.tBodies[0].rows.length; //ATIVIDADE 3: Muda o número de registros de acordo com a quantidade de linhas da tabela.

});

//Função que insere um objeto profissional na tabela HTML
const inserirConvenio = (item) => {
    //Criando os elementos HTML
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let ativo = document.createElement('td');
    let cnpj = document.createElement('td');
    let email = document.createElement('td');
    let nome = document.createElement('td');
    let razao_social = document.createElement('td');
    let representante = document.createElement('td');
    let telefone = document.createElement('td');
    let acoes = document.createElement('td');
    //Preencher os elementos
    id.textContent = item.id;
    ativo.textContent = item.ativo;
    cnpj.textContent = item.cnpj;
    email.textContent = item.email;
    nome.textContent = item.nome;
    razao_social.textContent = item.razao_social;
    representante.textContent = item.representante;
    telefone.textContent = item.telefone;
    acoes.innerHTML = `<a class="botao" href="javascript:void(0)">Editar</a> <a id="vermelho" class="botao" href="javascript:void(0)">Excluir</a>`;
    //Preencher a linha
    linha.appendChild(id);
    linha.append(ativo);
    linha.appendChild(cnpj);
    linha.appendChild(email);
    linha.appendChild(nome);
    linha.appendChild(razao_social);
    linha.appendChild(representante);
    linha.appendChild(telefone);
    linha.appendChild(acoes);
    //Preencher a tabela com uma linha
    tabela.tBodies[0].appendChild(linha);
    eventoExcluir();
    atualizarRodape();
};
