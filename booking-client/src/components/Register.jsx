import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import AuthService from '../services/AuthService';

const Register = () => {
    const navigate = useNavigate();
    const [user, setUser] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: ""
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setUser({...user, [e.target.name]: value});
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        AuthService.registerUser(user);
        navigate("/auth/login");
    }


    return (
    <div className="flex max-w-2xl mx-auto mt-28 shadow border-b rounded-lg">
        <div className="w-full p-20">
            <div className="text-4xl text-center">
                <h1>Register</h1>
            </div>
            <div className="items-center justify-center w-full my-5">
                <input
                    required
                    type="text"
                    name="firstName"
                    value={user.firstName}
                    placeholder="First Name"
                    className="rounded-lg w-full border my-2 p-2"
                    onChange={handleChange}
                />
                <input
                    required
                    type="text"
                    name="lastName"
                    value={user.lastName}
                    placeholder="Last Name"
                    className="rounded-lg w-full border my-2 p-2"
                    onChange={handleChange}
                />
                <input
                    required
                    type="email"
                    name="email"
                    value={user.email}
                    placeholder="Email"
                    className="rounded-lg w-full border my-2 p-2"
                    onChange={handleChange}
                />
                <input
                    required
                    type="password"
                    name="password"
                    value={user.password}
                    placeholder="Password"
                    className="rounded-lg w-full border mt-2 p-2"
                    onChange={handleChange}
                />
            </div>
            <button
                onClick={handleSubmit} 
                className="w-full rounded-full p-2 bg-blue-500 text-white">Create Account</button>
            <div className="text-center text-gray-600 py-2">
                Already created an account? <Link className="underline text-gray-800" to={"/auth/login"}>Login here</Link>
            </div>
        </div>
    </div>
    );
}

export default Register;