import React, { FormEvent, useState } from "react";
import { useNavigate } from "react-router-dom";
import User from "../../types/User";
import { cadastrarUsuario } from "../../api";

const Home: React.FC = () => {
    const [isLogin, setIsLogin] = useState<boolean>(true);
    const [formData, setFormData] = useState<User>({
        nome: '',
        cpf: '',
        email: '',
        telefone: ''
    })

    const navigate = useNavigate();

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target;
        setFormData( prev => ({
            ...prev,
            [name]: value
        }))
    };



    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();

        if(isLogin){
            console.log("Logando com:", formData.email);
            navigate("/dashboard");
        } else {
            try {
                const cadastro = await cadastrarUsuario(formData);
                alert('Cadastrado!');
                setIsLogin(true);
            } catch (err) {
                alert('Erro ao cadastrar!');
                console.log(err);
            }
          }
    }

    const togleForm = () => {
        setIsLogin((prev)=> !prev);
    }

    return (
        <div style={{ textAlign: "center", marginTop: "50px" }}>
            <h1>Bem Vindo ao Banco Marveira</h1>
            <div>
                <h2>{isLogin ? "Entrar" : "Cadastrar"}</h2>
                <form onSubmit={handleSubmit}
                    style={{
                        display: 'flex',
                        flexDirection: 'column',
                        gap: '10px',
                        maxWidth: '300px',       
                        margin: '0 auto',         
                        padding: '20px',
                        border: '1px solid #ccc',
                        borderRadius: '8px',
                        backgroundColor: '#f9f9f9'
                     }}
                  >
                    {!isLogin && (
                            <input type="text" placeholder="Nome" name="nome" value={formData.nome} onChange={handleChange} />
                    )}
                    
                    <input type="text" placeholder="Cpf" name="cpf" value={formData.cpf} onChange={handleChange} />
                    
                    <input type="email" placeholder="Email" name="email" value={formData.email} onChange={handleChange} />
                    
                    {!isLogin && (
                        <input type="tel" placeholder="Telefone" name="telefone" value={formData.telefone} onChange={handleChange} />
                    )}

                    <button type="submit">{ isLogin ? "Entrar" : "Cadastrar" }</button>
                </form>
                <p>
                    {isLogin ? "Não tem conta:" : "Já tem uma conta?"}{" "}
                    <button onClick={togleForm}>{isLogin ? "Cadastrar-se" : "Entrar"}</button>
                </p>
            </div>
        </div>
    );
};

export default Home;