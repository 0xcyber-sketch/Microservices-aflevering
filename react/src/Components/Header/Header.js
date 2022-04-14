import { useNavigate } from "react-router-dom"
import { get } from "../../http/httpClient"
import { HiHome } from "react-icons/hi"
function Header(props) {
    const navigate = useNavigate()
    // log out

    const handleLogOut = () => {
        get('logout', true, 8087).then((element) => {
            console.log(element);

            props.setLoggedin(false)
            navigate("/")
        }).catch((element) => {
            console.log("Error")
            console.log(element);
        })
    }



    if (!props.loggedin) {
        return (
            <>
                <div id="Logo-container" onClick={() => navigate("/")}>
                    <HiHome />
                </div>
                <button onClick={() => navigate("/signup")}>Sign up</button>
                <button onClick={() => navigate("/login")}>Login</button>
            </>
        )
    } else {
        return (
            <>
                <div id="Logo-container" onClick={() => navigate("/")}>
                    <HiHome />
                </div>
                <button onClick={handleLogOut}>Logout</button>

            </>)
    }

}

export default Header