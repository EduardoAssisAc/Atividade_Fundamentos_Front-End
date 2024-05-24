let botao = document.querySelector('a#add');
let selectTema = document.querySelector('select#tema');
let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');
let totalRegistrosSpan = document.getElementById('total-registros');
let tabela = document.querySelector('table');
let tema = localStorage.getItem('tema');

selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado){
        mudaTema(temaSelecionado);
        localStorage.setItem('tema', temaSelecionado);
    }
});

const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    let url = "/css/estilo-tema-"+temaSelecionado+".css";
    linkTema.href = url;
}

if (tema){
    mudaTema(tema);
}

const atualizarRodape = () => {
    let totalRegistros = tabela.tBodies[0].rows.length;
    totalRegistrosSpan.textContent = totalRegistros;
}

botaoAdicionar.addEventListener('click', () => {
    botaoAdicionar.classList.add('inativo');
    form.classList.remove('inativo'); 
});

botaoCancelar.addEventListener('click', () => {
    botaoAdicionar.classList.remove('inativo');
    form.classList.add('inativo');
    form.reset();
})

// Adicionar um funcionamento para enviar os dados do form para a tabela

form.addEventListener('submit', (evento) => {
    evento.preventDefault(); // evita que a pagina seja recarregada
    let profissional = {
        id: tabela.tBodies[0].rows.length + 1,
        nome: form.nome.value,
        registroConselho: form.registroConselho.value,
        telefone: form.telefone.value,
        email: form.email.value,
        unidade: form.unidade.options[form.unidade.selectedIndex].label,
        especialidade: form.especialidade.options[form.especialidade.selectedIndex].label
    };
    inserirProfissional(profissional);
    form.reset();
    form.classList.add('inativo');
    botaoAdicionar.classList.remove('inativo');
    atualizarRodape();
});

// Função que insee um objeto profissional na tabela HTML
const inserirProfissional = (item) =>{
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let nome = document.createElement('td');
    let registroConselho = document.createElement('td');
    let telefone = document.createElement('td');
    let email = document.createElement('td');
    let unidade = document.createElement('td');
    let especialidade = document.createElement('td');
    let acoes = document.createElement('td');
    // Preencher os elementos
    id.textContent = item.id;
    nome.textContent = item.nome;
    registroConselho.textContent = item.registroConselho;
    telefone.textContent = item.telefone;
    email.textContent = item.email;
    unidade.textContent = item.unidade;
    especialidade.textContent = item.especialidade;
    acoes.innerHTML = `<a class="botao" href="javascript:void(0)">Editar</a> <a id="vermelho" class="botao" href="javascript:void(0)">Excluir</a>`;
    // Preencher a linha
    linha.appendChild(id);
    linha.append(nome);
    linha.appendChild(registroConselho);
    linha.appendChild(email);
    linha.appendChild(telefone);
    linha.appendChild(unidade);
    linha.appendChild(especialidade);
    linha.appendChild(acoes);
    // Preencher a tabela com uma linha
    tabela.tBodies[0].appendChild(linha);
    eventoExcluir();
}

// Criar uma função para excluir os profissionais

const eventoExcluir = () =>{
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes){
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            atualizarRodape();
        });
    }
};

const carregarProfissionais = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/profissionais";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    })
    .then(dados => {
        for(const item of dados){
            inserirProfissional(item);
        }
        atualizarRodape();
        eventoExcluir();
    })
    .catch(erro => {
        console.error(erro);
    });
    // let xhr = new XMLHttpRequest();
    // xhr.open('GET', url);
    // xhr.addEventListener('readystatechange', () => {
    //     if(xhr.readyState === 4 && xhr.status === 200) {
    //         dados = JSON.parse(xhr.responseText);
    //         console.log(dados);
    //         for (const item of dados){
    //             // Cirando os elementos HTML
    //             let linha = document.createElement('tr');
    //             let id = document.createElement('td');
    //             let nome = document.createElement('td');
    //             let registro = document.createElement('td');
    //             let telefone = document.createElement('td');
    //             let email = document.createElement('td');
    //             let unidade = document.createElement('td');
    //             let especialidade = document.createElement('td');
    //             let acoes = document.createElement('td');
    //             // Preencher os elementos
    //             id.textContent = item.id;
    //             nome.textContent = item.nome;
    //             registroConselho.textContent = item.registro;
    //             telefone.textContent = item.telefone;
    //             email.textContent = item.email;
    //             unidade.textContent = item.unidade;
    //             especialidade.textContent = item.especialidade;
    //             acoes.innerHTML = `<a class="botao" href="javascript:void(0)">Editar</a> <a id="vermelho" class="botao" href="javascript:void(0)">Excluir</a>`;
    //             // Preencher a linha
    //             linha.appendChild(id);
    //             linha.append(nome);
    //             linha.appendChild(registroConselho);
    //             linha.appendChild(email);
    //             linha.appendChild(telefone);
    //             linha.appendChild(unidade);
    //             linha.appendChild(especialidade);
    //             linha.appendChild(acoes);
    //             // Preencher a tabela com uma linha
    //             tabela.tBodies[0].appendChild(linha);
    //         }
    //         
    //     }
    // });
    // xhr.send();
    // eventoExcluir();
 
};
carregarProfissionais();