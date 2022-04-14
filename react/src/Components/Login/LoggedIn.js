import {Link, useNavigate } from "react-router-dom"
import { get } from '../../http/httpClient.js'


function LoggedIn(props) {
    const navigate = useNavigate()


    if (props.loggedin) {
    return (
        <>
        <h1>Logged in</h1>
        <button onClick={() => {navigate('/categories')}}>Categories</button>
        <button onClick={ () => {navigate('/create-advertisment')}}>Create AD</button>
        </>
    )}
    else {
        //<Link
       // changePage()
        /*return (
            <Link to={"/"}></Link>
        )*/
        //window.location.href = "/"
        return null
    }
}
export default LoggedIn