import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./components/Navbar";
import Login from "./components/Login";
import Landing from "./components/Landing";
import Register from "./components/Register";
import Profile from "./components/Profile";

function App() {

  return (
    <div className="p-4 font-inter">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route index path="/" element={<Landing />} />
          <Route path="/register" element={<Register />} />
          <Route path="/auth/login" element={<Login />} />
          <Route path="/account/:subpage?" element={<Profile />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
