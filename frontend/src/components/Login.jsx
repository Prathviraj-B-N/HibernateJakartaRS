import '../css/Login.css'
import { useState } from 'react';

export default function Login(props){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async(e)=>{
        e.preventDefault();
        try {
            const formData = {
              username: username,
              password: password
            };
            const requestOptions = {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify(formData),
            };
            const response = await fetch(
              "http://localhost:8080/login",
              requestOptions
            );
            const data = await response.json();
            
            if (data === true) {
                setUsername("");
                setPassword("");
                props.setlogin(true)
            }else{
                setUsername("Invalid Username/password");
                setPassword("");
            }
            
          } catch (error) {
            
            console.log(error);
          }
    }

    return (
        <div className="logincss">
             <h1>Admin Login</h1>

            <form>
                <label>
                    <p>Admin Username</p>
                    <input type="text" value={username} onChange={(e)=>setUsername(e.target.value)}/>
                </label>
                <label>
                    <p>Password</p>
                    <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
                </label>

                <li type="submit" onClick={(e) => handleLogin(e)}>Login</li>

            </form>

        </div>);
}