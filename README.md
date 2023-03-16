ViaCEP Client


Este é um programa em Java que utiliza a API do ViaCEP para pesquisar e validar CEPs brasileiros.

Funcionalidades
O programa oferece duas opções para o usuário:

Validar um CEP: o usuário digita um CEP e o programa verifica se ele é válido ou não, fazendo uma consulta à API. Se o CEP for inválido, o programa exibe uma mensagem de erro. Se o CEP for válido, o programa exibe as informações do endereço correspondente ao CEP.

Pesquisar um CEP: o usuário digita a sigla do estado, o nome da cidade e o nome do logradouro, e o programa faz uma consulta à API para buscar o(s) CEP(s) correspondente(s) ao endereço informado. Se nenhum CEP for encontrado, o programa exibe uma mensagem de erro. Se pelo menos um CEP for encontrado, o programa exibe as informações do(s) endereço(s) correspondente(s) ao(s) CEP(s).

O programa possui tratamentos de exceção para possíveis erros na conexão com a API ou no processamento dos dados recebidos. Além disso, ele realiza algumas correções nos dados digitados pelo usuário para garantir que a consulta à API seja bem-sucedida.

Como usar
Para utilizar o programa, basta executar a classe ViaCEPClient em uma IDE Java ou através do comando java ViaCEPClient em um terminal. O programa exibirá um menu com as opções disponíveis e guiará o usuário durante a interação.

Dependências
O programa utiliza a classe HttpClient da biblioteca padrão do Java 11 para realizar as requisições HTTP. Não são necessárias outras dependências além do próprio JDK.

Contribuições
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver alguma sugestão, sinta-se à vontade para abrir uma issue ou submeter um pull request.
