function FrontPage(props) {

if (!props.loggedin) {
    console.log(props.loggedin);
    return (
        <>
        <div>
        <h2>This is an awesome Site</h2>
    </div>
        </>
    )}
    else {
        console.log("WE HERE");
        //<Link
       // changePage()
        /*return (
            <Link to={"/"}></Link>
        )*/
        window.location.href = "/loggedIn"
        return null
    }
}


export default FrontPage