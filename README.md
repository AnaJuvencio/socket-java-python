# socket-java-python

##Cliente Java:

1. Compile e execute o código do cliente Java em uma máquina cliente. Certifique-se de que a máquina cliente possa se conectar à máquina onde o servidor Python está em execução.
2. O cliente Java solicitará que você escolha entre "SEND" (enviar arquivo) ou "RECEIVE" (receber arquivo).
3. Se você escolher "SEND," o cliente solicitará o nome do arquivo que deseja enviar para o servidor. Certifique-se de que o arquivo exista no sistema cliente.
4. Se você escolher "RECEIVE," o cliente solicitará o nome do arquivo que deseja receber do servidor.
5. O cliente se conectará ao servidor Python na máquina e porta especificadas, e a comunicação ocorrerá.
6. Após a conclusão da operação, o cliente Java exibirá uma mensagem apropriada (por exemplo, "Arquivo Enviado" ou "    Arquivo Salvo").

##Servidor Python:

1. Compile e execute o código do servidor Python na máquina servidor. Certifique-se de que a máquina servidor tenha uma porta acessível para conexões de clientes (porta 12345 no exemplo fornecido).
2. O servidor Python aguardará conexões de clientes na porta especificada.
3. Quando um cliente se conectar, o servidor Python criará uma nova thread para lidar com essa conexão.
4. O servidor receberá a opção ("SEND" ou "RECEIVE") e o nome do arquivo do cliente.
5. Se a opção for "SEND," o servidor receberá o arquivo do cliente e o salvará no diretório especificado.
6. Se a opção for "RECEIVE," o servidor enviará o arquivo solicitado de volta ao cliente.
7. O servidor exibirá mensagens apropriadas indicando o status da operação.