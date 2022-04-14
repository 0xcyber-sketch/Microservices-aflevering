import { useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { post } from "../../http/httpClient.js"

function Login(props) {

    const [userName, setUsername] = useState("")
    const [password, setPassword] = useState("")

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
    }

    const handleSubmit = (e) => {

        e.preventDefault();
        post("login", getPayload(), true, 8087).then((res) => {
            res.json().then((resp) => {
                console.log("Hello");
                console.log(resp);
                if ("message" in resp) {
                    alert("Login failed")
                }
                else {
                    props.setLoggedin(true)

                    navigate('/loggedIn')
                }
            })

        }).catch(error => {
            console.log(error)
            alert("Login failed")
        })

    }

    const getPayload = () => {
        return { credential: userName, password: password }
    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <input placeholder="username" name="username" type='text' value={userName.value} onChange={handleOnChange} />
                <input placeholder="password" name="password" type='password' value={password.value} onChange={handleOnChange} />
                <button >Login</button>
            </form>

        </>)
}

export default Login