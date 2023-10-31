import socket
import threading
import os

def receive_file(file_name, client_socket):
    with open(file_name, 'wb') as file:
        while True:
            data = client_socket.recv(8192)
            if not data:
                break
            file.write(data)

def send_file(file_name, client_socket):
    with open(file_name, 'rb') as file:
        for data in file:
            client_socket.send(data)

def handle_client(client_socket):
    option = client_socket.recv(1024).decode()
    file_name = client_socket.recv(1024).decode().strip()  

    if option.strip() == "SEND":  
        print(f"Recebendo arquivo: {file_name}")
        receive_file(file_name, client_socket)
        print(f"Arquivo recebido: {file_name}")
    elif option.strip() == "RECEIVE":  # remover \r\n
        full_file_path = 'C:/Users/Beatriz/Documents/redes2/RecebidoServidor/' + file_name
        print(f"Enviando Arquivo: {full_file_path}")
        send_file(full_file_path, client_socket)
        print(f"Arquivo enviado: {full_file_path}")
    else:
        print("Opção invalida: " + option)



    client_socket.close()

def main():
    host = "192.168.0.23" #UTILIZE O SEU
    port = 12346

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((host, port))
    server.listen(5)

    print("Servidor recebendo conexão...")

    while True:
        client_socket, addr = server.accept()
        client_handler = threading.Thread(target=handle_client, args=(client_socket,))
        client_handler.start()

if __name__ == "__main__":
    main()
