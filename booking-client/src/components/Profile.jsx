import React from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import AuthService from '../services/AuthService';

const Profile = () => {
    const navigate = useNavigate();
    const user = AuthService.getLoggedInUser();

    if (!user) {
        return navigate("/auth/login");
    }

    const {subpage} = useParams();

    const linkClasses = (type = null) => {
        let classes = "py-2 px-6";
        if (type === subpage || (subpage === undefined && type === "account")) {
            classes += " bg-blue-500 text-white rounded-full"
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
                <Link className={linkClasses('account')} to={"/account"}>My Profile</Link>
                <Link className={linkClasses('bookings')} to={"/account/bookings"}>My Bookings</Link>
                <Link className={linkClasses('accommodations')} to={"/account/accommodations"}>My Accommodations</Link>
            </nav>
            {subpage === undefined && (
                <div className="mx-auto max-w-lg text-center">
                    <div>Hello, {user.firstName} {user.lastName}!</div>
                    <button onClick={handleLogout} className="px-16 py-2 bg-red-500 text-white rounded-full">Logout</button>
                </div>
            )}
        </div>
    );
}

export default Profile;