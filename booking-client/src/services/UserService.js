import AuthService from "./AuthService";

class UserService {

    
    registerUser(user) {
        const REGISTER_API = "http://localhost:8080/register";
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        };
        
        return fetch(REGISTER_API, requestOptions)
        .then((response) => {
            
        })
        .catch((error) => {
            console.log(error);
        });
    }
    
    loginUser(user) {
        const LOGIN_API = "http://localhost:8080/auth/login";
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        }

        return fetch(LOGIN_API, requestOptions)
                .then((response) => response.json())
                .then(data => {
                    // Store JWT token in localStorage.
                    console.log(data.jwt);
                }).catch((error) => {
                    console.log(error);
                });
    }
}

export default new UserService();