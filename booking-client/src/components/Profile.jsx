import React from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import AuthService from '../services/AuthService';
import Accommodations from './Accommodations';

const Profile = () => {
    const navigate = useNavigate();
    const user = AuthService.getLoggedInUser();

    if (!user) {
        return navigate("/auth/login");
    }

    const {subpage} = useParams();

    const linkClasses = (type = null) => {
        let classes = "inline-flex gap-1 py-2 px-6 rounded-full";
        if (type === subpage || (subpage === undefined && type === "account")) {
            classes += " bg-blue-500 text-white"
        } else {
            classes += " bg-gray-100"
        }
        return classes;
    }

    const handleLogout = (e) => {
        e.preventDefault();
        AuthService.logout();
        navigate("/");
        window.location.reload();
    }

    return (
        <div>
            <nav className="w-full flex justify-center my-8 gap-2">
                <Link className={linkClasses('account')} to={"/account"}>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z" />
                    </svg>
                    My Profile
                </Link>
                <Link className={linkClasses('bookings')} to={"/account/bookings"}>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M17.593 3.322c1.1.128 1.907 1.077 1.907 2.185V21L12 17.25 4.5 21V5.507c0-1.108.806-2.057 1.907-2.185a48.507 48.507 0 0111.186 0z" />
                    </svg>
                    My Bookings
                </Link>
                <Link className={linkClasses('accommodations')} to={"/account/accommodations"}>
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M8.25 21v-4.875c0-.621.504-1.125 1.125-1.125h2.25c.621 0 1.125.504 1.125 1.125V21m0 0h4.5V3.545M12.75 21h7.5V10.75M2.25 21h1.5m18 0h-18M2.25 9l4.5-1.636M18.75 3l-1.5.545m0 6.205l3 1m1.5.5l-1.5-.5M6.75 7.364V3h-3v18m3-13.636l10.5-3.819" />
                    </svg>
                    My Accommodations
                </Link>
            </nav>
            {subpage === undefined && (
                <div className="mx-auto max-w-lg text-center">
                    <div>Hello, {user.firstName} {user.lastName}!</div>
                    <button onClick={handleLogout} className="my-4 px-16 py-2 bg-red-500 text-white rounded-full">Logout</button>
                </div>
            )}
            {subpage === "accommodations" && (
                <Accommodations />
            )}
        </div>
    );
}

export default Profile;