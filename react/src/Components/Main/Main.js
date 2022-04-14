import { Route, Routes, Switch} from "react-router-dom"
import FrontPage from "../FrontPage/FrontPage.js"
import Signup from "../Signup/Signup.js"
import Login from "../Login/Login.js"
import LoggedIn from "../Login/LoggedIn.js"
import Categories from "../Categories/Categories.js"
import ShowAdvertismentsList from "../Advertisements/ShowAdvertismentsList.js"
import CreateAdvertisment from "../Advertisements/CreateAdvertisment.js"
import Advertisement from "../Advertisements/Advertisement.js"

function Main(props) {

    return (


        <div>
            <Routes>
                <Route path={"/"} element={<FrontPage loggedin={props.loggedin}/>} />
                <Route path={"*"} element={<FrontPage loggedin={props.loggedin}/>} />
                <Route path={"/signup"} element={<Signup />} />
                <Route path={"/login"} element={<Login setLoggedin={props.setLoggedin} loggedin={props.loggedin}/>} />
                <Route path={"/loggedIn"} element={<LoggedIn loggedin={props.loggedin}/>}    />
                <Route path={"/categories"} element={<Categories loggedin={props.loggedin}/>} />
                <Route path={"/categories/:category/advertisements"} element={<ShowAdvertismentsList loggedin={props.loggedin}/>} />
                <Route path={"/create-advertisment"} element={<CreateAdvertisment loggedin={props.loggedin}/>} />
                <Route path={"/advertisement/:id"} element={<Advertisement loggedin={props.loggedin}/>} />


            </Routes>
        </div>
    )
}

export default Main