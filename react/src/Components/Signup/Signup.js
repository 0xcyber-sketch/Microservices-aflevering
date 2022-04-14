import { useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { post } from "../../http/httpClient.js"

function Signup(prop) {

    const [userName, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [email, setEmail] = useState("")

    const navigate = useNavigate()

    const handleOnChange = (e) => {
    
        const { name, value } = e.target
     
        if (name === "username") {
            setUsername(value)
            // error handler
        }
        else if (name === "password") {
            setPassword(value)
        }
        else if (name === "email") {
            setEmail(value)
        }
    }

    const handleSubmit = (e) => {

        e.preventDefault();
        post("signup", getPayload(), true, 8087)
        .then(() => {
            navigate('/login')
    
    })
        .catch(error => alert("User not created"))
        
    }

    const getPayload = () => {
        return {userName: userName, email: email, password: password}
    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <input placeholder="email" name="email" type='email' value={email.value} onChange={handleOnChange} />
                <input placeholder="username" name="username" type='text' value={userName.value} onChange={handleOnChange}/>
                <input placeholder="password" name="password" type='password' value={password.value} onChange={handleOnChange}/>
                <button >Signup</button>
            </form>

        </>)

}

export default Signup