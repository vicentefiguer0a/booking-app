import React from 'react'
import { Link } from 'react-router-dom';

const Register = () => {
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
                    placeholder="First Name"
                    className="rounded-lg w-full border my-2 p-2"
                />
                <input
                    required
                    type="text"
                    placeholder="Last Name"
                    className="rounded-lg w-full border my-2 p-2"
                />
                <input
                    required
                    type="email"
                    placeholder="Email"
                    className="rounded-lg w-full border my-2 p-2"
                />
                <input
                    required
                    type="password"
                    placeholder="Password"
                    className="rounded-lg w-full border mt-2 p-2"
                />
            </div>
            <button className="w-full rounded-full p-2 bg-blue-500 text-white">Create Account</button>
            <div className="text-center text-gray-600 py-2">
                Already created an account? <Link className="underline text-gray-800" to={"/auth/login"}>Login here</Link>
            </div>
        </div>
    </div>
  )
}

export default Register;