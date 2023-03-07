class AuthService {
    // Register a user.
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
    
    // Login a user.
    loginUser(userToLogin) {
        const LOGIN_API = "http://localhost:8080/auth/login";
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(userToLogin)
        }
        fetch(LOGIN_API, requestOptions)
        .then((response) => response.json())
        .then((data) => {
            const user = {
                firstName: data.firstName,
                lastName: data.lastName,
                email: data.email
            };
            const jwt = data.jwt;
            localStorage.setItem("user", JSON.stringify(user));
            localStorage.setItem("jwt", jwt);
            }).catch((error) => {
            console.log(error);
        });
    }

    getLoggedInUser() {
        return JSON.parse(localStorage.getItem("user"));
    }

    // Logout user. (clears local storage)
    logout() {
        localStorage.clear();
    }
}

export default new AuthService();