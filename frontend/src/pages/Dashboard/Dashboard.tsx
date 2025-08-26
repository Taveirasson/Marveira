import React, { useState } from "react";

const Dashboard: React.FC = () => {
    const [isLogin, setIsLogin] = useState(true);

    const togleForm = () => {
        setIsLogin(!isLogin);
    }

    return (
        <div style={{ textAlign: "center", marginTop: "50px" }}>
            <h1>Bem-vindo à área protegida!</h1>
            <p>Você está logado.</p>
        </div>
    );
};

export default Dashboard;
  