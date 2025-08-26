import User from "../types/User"

export const cadastrarUsuario = async(user: User) => {
    const response = await fetch('http://localhost:8080/api/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(user),
    });

    if(!response.ok) {
        throw new Error('Erro ao cadastrar usuário');
    }

    return response.text()
}