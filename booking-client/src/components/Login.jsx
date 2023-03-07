import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';


const Login = () => {
    const navigate = useNavigate();
    const [loading, setLoading] = useState(false);
    const [user, setUser] = useState({
        email: "",
        password: ""
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setUser({...user, [e.target.name]: value});
    }

    const handleLogin = (e) => {
        e.preventDefault();
        AuthService.loginUser(user);
        setLoading(true);
        setTimeout(() => {
            navigate("/");
            window.location.reload();
        }, 2000);
    }

    if (loading) {
        return (
            <div className="loader-container">
      	        <div className="spinner"></div>
            </div>
        );
    } else {
        return (
            <div className="flex max-w-2xl mx-auto mt-28 shadow border-b rounded-lg">
                <div className="w-full p-20">
                    <div className="text-4xl text-center">
                        <h1>Login</h1>
                    </div>
                    <div className="items-center justify-center w-full my-5">
                        <input
                            type="email"
                            name="email"
                            value={user.email}
                            onChange={handleChange}
                            placeholder="Email"
                            className="rounded-lg w-full border my-2 p-2"
                        />
                        <input
                            type="password"
                            name="password"
                            value={user.password}
                            onChange={handleChange}
                            placeholder="Password"
                            className="rounded-lg w-full border mt-2 p-2"
                        />
                    </div>
                    <button
                        onClick={handleLogin}
                        className="w-full rounded-full p-2 bg-blue-500 text-white">Login</button>
                    <div className="text-center text-gray-600 py-2">
                    Don't have an account yet? <Link className="underline text-gray-800" to={"/register"}>Register here</Link>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;